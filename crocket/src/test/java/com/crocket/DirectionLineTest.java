package com.crocket;


import org.junit.Before;
import org.junit.Test;

import com.crocket.model.DirectionLine;

import static org.junit.Assert.assertEquals;

public class DirectionLineTest {
    private DirectionLine directionLine = new DirectionLine(90, 20, 20);

    @Before
    public void reset_directionline(){
        directionLine = new DirectionLine(90, 20, 20);
    }

    @Test
    public void test_if_decrementdegreeAngle_changes_angle(){
        directionLine.decrementDegreeAngle();
        assertEquals(85, directionLine.getDegreeAngle(), 0.0001);
    }

    @Test
    public void test_if_decrementdegreeAngle_changes_angle_when_0(){
        directionLine.setDegreeAngle(0);
        directionLine.decrementDegreeAngle();
        assertEquals(355, directionLine.getDegreeAngle(), 0.0001);
    }

    @Test
    public void test_if_incrementdegreeAngle_changes_angle(){
        directionLine.incrementDegreeAngle();
        assertEquals(95, directionLine.getDegreeAngle(), 0.0001);
    }

    @Test
    public void test_if_incrementdegreeAngle_changes_angle_when_360(){
        directionLine.setDegreeAngle(360);
        directionLine.incrementDegreeAngle();
        assertEquals(5, directionLine.getDegreeAngle(), 0.0001);
    }

}
