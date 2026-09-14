package edu.luc.cs.laufer.cs371.shapes

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

import TestFixtures.*
import Shape.*

class TestScale:

  def testScale(s: Shape, factor: Int, expected: Shape): Unit =
    assertEquals(expected, scale(s, factor))

  @Test
  def testSimpleRectangle(): Unit =
    testScale(simpleRectangle, 2, Rectangle(160, 240))

  @Test
  def testSimpleEllipse(): Unit =
    testScale(simpleEllipse, 3, Ellipse(150, 90))

  @Test
  def testSimpleLocation(): Unit =
    testScale(simpleLocation, 2, Location(140, 60, Rectangle(160, 240)))

  @Test
  def testBasicGroup(): Unit =
    testScale(basicGroup, 2, Group(Ellipse(100, 60), Rectangle(40, 80)))

  @Test
  def testSimpleGroup(): Unit =
    testScale(
      simpleGroup,
      2,
      Group(
        Location(400, 200, Ellipse(100, 60)),
        Location(800, 600, Rectangle(200, 100))
      )
    )

  @Test
  def testComplexGroup(): Unit =
    testScale(
      complexGroup,
      2,
      Location(100, 200,
        Group(
          Ellipse(40, 80),
          Location(300, 100,
            Group(
              Rectangle(100, 60),
              Rectangle(600, 120),
              Location(200, 400, Ellipse(100, 60))
            )
          ),
          Rectangle(200, 400)
        )
      )
    )

  @Test
  def testIdentityScale(): Unit =
    testScale(complexGroup, 1, complexGroup)

end TestScale
