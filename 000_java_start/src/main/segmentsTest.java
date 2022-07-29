package main;

import org.junit.*;
import static org.junit.Assert.assertEquals;

public class segmentsTest {
    @Test
    public void testSegmentsShiftFirstPointXCord(){
        points sut = new points(-10, -10);
        points sut2 = new points(0, 0);
        segments segment = new segments(sut, sut2);
        segment.shift(10, 10);
        assertEquals("x.shift(10, 10)", 0, segment.point1.getX(), 0.00001);
    }
    @Test
    public void testSegmentsShiftFirstPointYCord(){
        points sut = new points(-10, -10);
        points sut2 = new points(0, 0);
        segments segment = new segments(sut, sut2);
        segment.shift(10, 10);
        assertEquals("x.shift(10, 10)", 0, segment.point1.getY(), 0.00001);
    }
    @Test
    public void testSegmentsShiftSecondPointXCord(){
        points sut = new points(-10, -10);
        points sut2 = new points(0, 0);
        segments segment = new segments(sut, sut2);
        segment.shift(10, 10);
        assertEquals("x.shift(10, 10)", 10, segment.point2.getX(), 0.00001);
    }
    @Test
    public void testSegmentsShiftSecondPointYCord(){
        points sut = new points(-10, -10);
        points sut2 = new points(0, 0);
        segments segment = new segments(sut, sut2);
        segment.shift(10, 10);
        assertEquals("x.shift(10, 10)", 10, segment.point2.getY(), 0.00001);
    }
    @Test
    public void testDistanceBetweenSegmentAndPoint() {
        points sut = new points(10, -10);
        points sut2 = new points(5, -5);
        segments segment = new segments(sut, sut2);
        assertEquals("x.distance(10, 0)", 0, segment.distance(new points(0, 0)), 0.00001);

    }
}