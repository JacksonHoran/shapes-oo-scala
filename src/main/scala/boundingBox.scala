package edu.luc.cs.laufer.cs371.shapes

// TODO: implement this behavior

import Shape.*

object boundingBox:
  def apply(s: Shape): Location = s match
    case _ => Location(0, 0, Rectangle(0, 0)) // not yet implemented

end boundingBox
