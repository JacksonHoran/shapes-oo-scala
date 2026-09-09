package edu.luc.cs.laufer.cs371.shapes

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

import TestFixtures.*
import Shape.*

class TestBoundingBox:

  def testBoundingBox(s: Shape, x: Int, y: Int, width: Int, height: Int): Unit =
    val Location(u, v, Rectangle(w, h)) = boundingBox(s) : @unchecked
    assertEquals(x, u)
    assertEquals(y, v)
    assertEquals(width, w)
    assertEquals(height, h)

  @Test
  def testSimpleRectangle(): Unit =
    testBoundingBox(simpleRectangle, 0, 0, 80, 120)

  @Test
  def testSimpleLocation(): Unit =
    testBoundingBox(simpleLocation, 70, 30, 80, 120)

  // TODO reenable these commented-out tests after adding the missing case classes
  // (following the pattern of the other tests above)

  //  testBoundingBox(simpleEllipse, -50, -30, 100, 60)
  //  testBoundingBox(basicGroup, -50, -30, 100, 70)
  //  testBoundingBox(simpleGroup, 150, 70, 350, 280)
  //  testBoundingBox(complexGroup, 30, 60, 470, 320)

end TestBoundingBox
