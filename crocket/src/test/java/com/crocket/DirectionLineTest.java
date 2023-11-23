package com.crocket;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DirectionLineTest {
    private DirectionLine directionLine = new DirectionLine(90, 20, 20, 20, 2);

    @Before
    public void reset_directionline(){
        directionLine = new DirectionLine(90, 20, 20, 20, 2);
    }

    @Test
    public void test_if_decrementdegreeAngle_changes_angle(){
        directionLine.decrementDegreeAngle();
        assertEquals(directionLine.getDegreeAngle(), 85, 0.0001);
    }

    @Test
    public void test_if_decrementdegreeAngle_changes_angle_when_0(){
        directionLine.setDegreeAngle(0);
        directionLine.decrementDegreeAngle();
        assertEquals(directionLine.getDegreeAngle(), 355, 0.0001);
    }

    @Test
    public void test_if_incrementdegreeAngle_changes_angle(){
        directionLine.incrementDegreeAngle();
        assertEquals(directionLine.getDegreeAngle(), 95, 0.0001);
    }

    @Test
    public void test_if_incrementdegreeAngle_changes_angle_when_360(){
        directionLine.setDegreeAngle(360);
        directionLine.incrementDegreeAngle();
        assertEquals(directionLine.getDegreeAngle(), 5, 0.0001);
    }

}
