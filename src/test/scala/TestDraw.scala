package edu.luc.cs.laufer.cs371.shapes

import java.awt.image.BufferedImage

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.{assertNotNull, assertTrue}

import TestFixtures.*

/** Offline rendering tests for the draw behavior (extra credit).
  * Each shape is rendered to a BufferedImage with no window, then checked to be
  * a valid, non-empty image.
  */
class TestDraw:

  /** True if the image contains at least two distinct pixel values, i.e.
    * something was actually drawn on top of the background.
    */
  private def hasContent(bi: BufferedImage): Boolean =
    val first = bi.getRGB(0, 0)
    var y = 0
    while y < bi.getHeight do
      var x = 0
      while x < bi.getWidth do
        if bi.getRGB(x, y) != first then return true
        x += 1
      y += 1
    false

  private def testDraw(s: Shape): Unit =
    val bi = draw.toBufferedImage(s)
    assertNotNull(bi)
    assertTrue(bi.getWidth > 0 && bi.getHeight > 0, "image should have positive dimensions")
    assertTrue(hasContent(bi), "rendered image should contain drawn pixels")

  @Test
  def testSimpleRectangle(): Unit =
    testDraw(simpleRectangle)

  @Test
  def testSimpleLocation(): Unit =
    testDraw(simpleLocation)

  @Test
  def testSimpleEllipse(): Unit =
    testDraw(simpleEllipse)

  @Test
  def testBasicGroup(): Unit =
    testDraw(basicGroup)

  @Test
  def testSimpleGroup(): Unit =
    testDraw(simpleGroup)

  @Test
  def testComplexGroup(): Unit =
    testDraw(complexGroup)

end TestDraw
