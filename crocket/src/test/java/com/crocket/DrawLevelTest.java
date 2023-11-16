package com.crocket;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class DrawLevelTest {
    @Test
    public void validateLevelTest() {
        ILevel testLevel = new Level1();
       testLevel.validateLevel();
    }

    @Test
    public void getLevelHeightTest() {
        ILevel testLevel = new Level1();
        assertEquals(testLevel.getLevelHeight(), 15);
    }

    @Test
    public void getLevelWidthTest() {
        ILevel testLevel = new Level1();
        assertEquals(testLevel.getLevelWidth(), 25);
    }

}
