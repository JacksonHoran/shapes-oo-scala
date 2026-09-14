package edu.luc.cs.laufer.cs371.shapes

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertThrows

import Shape.*

class TestValidation:

  @Test
  def testNegativeRectangleWidth(): Unit =
    assertThrows(classOf[IllegalArgumentException], () => { val _ = Rectangle(-1, 10) }): Unit

  @Test
  def testNegativeRectangleHeight(): Unit =
    assertThrows(classOf[IllegalArgumentException], () => { val _ = Rectangle(10, -1) }): Unit

  @Test
  def testNegativeEllipseWidth(): Unit =
    assertThrows(classOf[IllegalArgumentException], () => { val _ = Ellipse(-1, 10) }): Unit

  @Test
  def testNegativeEllipseHeight(): Unit =
    assertThrows(classOf[IllegalArgumentException], () => { val _ = Ellipse(10, -1) }): Unit

  // valid shapes must construct without throwing
  @Test
  def testValidRectangle(): Unit =
    val _ = Rectangle(80, 120)

  @Test
  def testValidEllipse(): Unit =
    val _ = Ellipse(50, 30)

end TestValidation
