package com.crocket;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import com.crocket.model.Level1;
import com.crocket.model.interfaces.ILevel;
import com.crocket.shared.SurfaceType;

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
        SurfaceType[][] testMatrix = testLevel.getLevelSurfacemap();
        for (SurfaceType[] row : testMatrix) {
            for (SurfaceType surface : row) {
                assertNotEquals(surface, null);
            }
        }
    }
}
