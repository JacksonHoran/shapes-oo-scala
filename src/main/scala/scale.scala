package edu.luc.cs.laufer.cs371.shapes

import Shape.*

/** Recursively scales the dimensions of a shape by the given factor */
object scale:
  private val logger =
    import scala.language.unsafeNulls
    org.log4s.getLogger

  def apply(s: Shape, factor: Int): Shape =
    val result = s match
      case Rectangle(w, h)       => Rectangle(w * factor, h * factor)
      case Ellipse(w, h)         => Ellipse(w * factor, h * factor)
      case Location(x, y, shape) => Location(x * factor, y * factor, apply(shape, factor))
      case Group(shapes*)        => Group(shapes.map(apply(_, factor))*)
    logger.debug(s"scale($s, $factor) = $result")
    result

end scale
