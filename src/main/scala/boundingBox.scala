package edu.luc.cs.laufer.cs371.shapes

import Shape.*

object boundingBox:
  def apply(s: Shape): Location = s match
    case Rectangle(w, h) => Location(0, 0, Rectangle(w, h))

    case Ellipse(w, h)   => Location(-w, -h, Rectangle(2 * w, 2 * h))

    case Location(x, y, shape) =>
      val Location(bx, by, Rectangle(bw, bh)) = apply(shape) : @unchecked
      Location(x + bx, y + by, Rectangle(bw, bh))
      
    case Group(shapes*) =>
      if shapes.isEmpty then Location(0, 0, Rectangle(0, 0))
      else
        val corners = shapes.map { shape =>
          val Location(bx, by, Rectangle(bw, bh)) = apply(shape) : @unchecked
          (bx, by, bx + bw, by + bh)
        }
        val minX = corners.map(_._1).min
        val minY = corners.map(_._2).min
        val maxX = corners.map(_._3).max
        val maxY = corners.map(_._4).max
        Location(minX, minY, Rectangle(maxX - minX, maxY - minY))

end boundingBox
