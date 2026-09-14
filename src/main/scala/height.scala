package edu.luc.cs.laufer.cs371.shapes

import Shape.*

/** Computes the height of a shape tree */
object height:
  private val logger =
    import scala.language.unsafeNulls
    org.log4s.getLogger

  def apply(s: Shape): Int =
    val result = s match
      case Rectangle(_, _)       => 1
      case Ellipse(_, _)         => 1
      case Location(_, _, shape) => 1 + apply(shape)
      case Group(shapes*)        => 1 + shapes.foldLeft(0)((acc, shape) => acc max apply(shape))
    logger.debug(s"height($s) = $result")
    result

end height
