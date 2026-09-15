package edu.luc.cs.laufer.cs371.shapes

import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

import cats.effect.unsafe.implicits.global
import doodle.core.{ClosedPath, Point}
import doodle.core.format.Png
import doodle.image.Image
import doodle.image.syntax.all.*
import doodle.java2d.*

import Shape.*

/** Renders a shape to a Doodle image (extra credit).
  *
  * Doodle 0.34.0 has no ellipse primitive, so an `Ellipse(w, h)` is drawn as a
  * closed curve through points sampled from the ellipse with semi-axes
  * `(w, h)` — giving the same `2w x 2h` extent that `boundingBox` assumes.
  * Doodle uses a y-up coordinate system, so a `Location(x, y, ...)` translates
  * its child by `(x, y)` in that frame.
  */
object draw:
  private val logger =
    import scala.language.unsafeNulls
    org.log4s.getLogger

  /** Convert a shape into a Doodle `Image`. */
  def apply(s: Shape): Image =
    val image = s match
      case Rectangle(w, h)       => Image.rectangle(w.toDouble, h.toDouble)
      case Ellipse(w, h)         => Image.path(ellipsePath(w.toDouble, h.toDouble))
      case Location(x, y, shape) => apply(shape).at(x.toDouble, y.toDouble)
      case Group(shapes*)        => shapes.foldLeft(Image.empty)((acc, sh) => apply(sh).on(acc))
    logger.debug(s"draw($s)")
    image

  /** A closed elliptical path centered at the origin with semi-axes (w, h). */
  private def ellipsePath(w: Double, h: Double): ClosedPath =
    val n = 60
    val points = (0 until n).map { i =>
      val angle = 2 * math.Pi * i / n
      Point(w * math.cos(angle), h * math.sin(angle))
    }
    ClosedPath.interpolatingSpline(points)

  /** Render a shape offline to a `BufferedImage`, without opening a window. */
  def toBufferedImage(s: Shape): BufferedImage =
    import scala.language.unsafeNulls
    val tmp = File.createTempFile("shape-", ".png")
    tmp.deleteOnExit()
    apply(s).write[Png](tmp.getAbsolutePath)
    ImageIO.read(tmp)

  /** Write a shape to a PNG file at the given path. */
  def writePng(s: Shape, path: String): Unit =
    apply(s).write[Png](path)

end draw
