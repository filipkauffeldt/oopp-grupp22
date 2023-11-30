package com.crocket;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class DrawLevelTest {

    @Test
    public void getLevelHeightTest() {
        ILevel testLevel = new Level1();
        assertEquals(15, testLevel.getLevelHeight());
    }

    @Test
    public void getLevelWidthTest() {
        ILevel testLevel = new Level1();
        assertEquals(25,testLevel.getLevelWidth());
    }

    @Test
    public void testLevelMatrix() {
        ILevel testLevel = new Level1();
        Surface[][] testMatrix = testLevel.getLevelSurfacemap();
        for (Surface[] row : testMatrix) {
            for (Surface surface : row) {
                assertNotEquals(surface, null);
            }
        }
    }
}
