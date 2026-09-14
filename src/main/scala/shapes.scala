package edu.luc.cs.laufer.cs371.shapes

/** data Shape = Rectangle(w, h) | Location(x, y, Shape) | Ellipse(w, h) | Group(Shape*) */
enum Shape derives CanEqual:
  case Rectangle(width: Int, height: Int)
  case Location(x: Int, y: Int, shape: Shape)
  case Ellipse(width: Int, height: Int)
  case Group(shapes: Shape*)

  this match
    case Rectangle(w, h) =>
      require(w >= 0 && h >= 0, s"Rectangle dimensions must be nonnegative: ($w, $h)")
    case Ellipse(w, h) =>
      require(w >= 0 && h >= 0, s"Ellipse dimensions must be nonnegative: ($w, $h)")
    case _ => ()
