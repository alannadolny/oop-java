package main;

import org.junit.*;
import static org.junit.Assert.assertEquals;

public class pointsTest {
    @Test
    public void testSetXCord(){
        points sut = new points(-10, -20);
        sut.setX(-20);
        assertEquals("x.setX(-20)", -20.0, sut.getX(), 0.00001);
    }
    @Test
    public void testSetYCord() {
        points sut = new points(-10, -20);
        sut.setY(20);
        assertEquals("x.setY(20)", 20.0, sut.getY(), 0.00001);
    }
    @Test
    public void testShiftXCord() {
        points sut = new points(-10, -10);
        sut.shift(10, 0);
        assertEquals("x.shift(10, 0)", 0, sut.getX(), 0.00001);

    }
    @Test
    public void testShiftYCord() {
        points sut = new points(-10, -10);
        sut.shift(0, 10);
        assertEquals("x.shift(0, 10)", 0, sut.getY(), 0.00001);

    }
    @Test
    public void testPointsDistance() {
        points sut = new points(-10, -10);
        points sut2 = new points(-10, 0);
        assertEquals("x.distance(y)", 10, sut.distance(sut2), 0.00001);
    }
}