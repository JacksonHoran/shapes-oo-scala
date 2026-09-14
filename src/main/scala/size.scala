package edu.luc.cs.laufer.cs371.shapes

import Shape.*

/** Counts the number of concrete leaf shapes (rectangles and ellipses) in a shape. */
object size:
  private val logger =
    import scala.language.unsafeNulls
    org.log4s.getLogger

  def apply(s: Shape): Int =
    val result = s match
      case Rectangle(_, _)       => 1
      case Ellipse(_, _)         => 1
      case Location(_, _, shape) => apply(shape)
      case Group(shapes*)        => shapes.map(apply).sum
    logger.debug(s"size($s) = $result")
    result

end size
