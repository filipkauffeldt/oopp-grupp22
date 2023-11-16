package com.crocket;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class DrawLevelTest {
    @Test
    public void validateLevelTest() {
        Level testLevel = new Level1();
       testLevel.validateLevel();
    }

    @Test
    public void getLevelHeightTest() {
        Level testLevel = new Level1();
        assertEquals(testLevel.getLevelHeight(), 15);
    }

    @Test
    public void getLevelWidthTest() {
        Level testLevel = new Level1();
        assertEquals(testLevel.getLevelWidth(), 25);
    }
    @Test
    public void drawWrongLevelTest() {
        CroquetView testView= new CroquetView();
        LevelView level1View = null;
        testView.drawLevel(level1View);
    }

}
