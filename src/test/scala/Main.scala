package edu.luc.cs.laufer.cs371.shapes

import TestFixtures.*
import Shape.Rectangle

object Main:
  def main(args: Array[String]): Unit =
    println(boundingBox(simpleLocation))
    println(Rectangle(2, 3) == Rectangle(2, 3))
    println(Rectangle(22, 33) == Rectangle(23, 34))
end Main
