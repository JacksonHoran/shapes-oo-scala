package edu.luc.cs.laufer.cs371.shapes

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

import TestFixtures.*

class TestSize:

  def testSize(s: Shape, expected: Int): Unit =
    assertEquals(expected, size(s))

  @Test
  def testSimpleRectangle(): Unit =
    testSize(simpleRectangle, 1)

  @Test
  def testSimpleLocation(): Unit =
    testSize(simpleLocation, 1)

  @Test
  def testSimpleEllipse(): Unit =
    testSize(simpleEllipse, 1)

  @Test
  def testBasicGroup(): Unit =
    testSize(basicGroup, 2)

  @Test
  def testSimpleGroup(): Unit =
    testSize(simpleGroup, 2)

  @Test
  def testComplexGroup(): Unit =
    testSize(complexGroup, 5)

end TestSize
