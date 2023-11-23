package com.crocket;

import org.junit.Before;
import org.junit.Test;
import com.crocket.Player;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

public class PlayerTest {
    private static Queue<Entity> targets = new LinkedList<Entity>();
    static final Hoop hoop1 = new Hoop(20, 20, 20, 20, 20, Direction.EAST);
    static final Hoop hoop2 = new Hoop(10, 20, 10, 20, 20, Direction.WEST);
    static final Hoop hoop3 = new Hoop(30, 20, 20, 20, 20, Direction.SOUTH);
    static final Hoop hoop4 = new Hoop(40, 20, 10, 20, 20, Direction.NORTH);
    static final Peg peg    = new Peg(20, 20, 20, 20);
    
    public static List<Entity> getTargets() {
        List<Entity> testTargets = new ArrayList<Entity>();
        testTargets.add(hoop1);
        testTargets.add(hoop2);
        testTargets.add(hoop3);
        testTargets.add(hoop4);
        testTargets.add(peg);
        return testTargets;
    }

    public static void addTargets() {
        List<Entity> targetList = getTargets();
        targets.add(targetList.get(0));
        targets.add(targetList.get(1));
        targets.add(targetList.get(2));
        targets.add(targetList.get(3));
        targets.add(targetList.get(4));
    }
    
    @Test
    public void test_hasWon_false() {
        Player player = new Player(new Ball(20, 20, 20, 20, 2));
        addTargets();
        player.setTargets(targets);
        assertFalse(player.hasWon());
    }

    @Test 
    public void test_hasWon_true() {
        Player player = new Player(new Ball(20, 20, 20, 20, 2));
        assertTrue(player.hasWon());
    }

    @Test
    public void test_handleEvent_rightHoop() {
        Player player = new Player(new Ball(20, 20, 20, 20, 2));
        List<Entity> targetList = getTargets();
        addTargets();
        player.setTargets(targets);
        player.handleEvent(new PassTargetEvent(player.getBall(), targetList.get(0)));
        assertNotEquals(player.getRemainingTargets(), targets);
    }   

    @Test
    public void test_handleEvent_wrongHoop() {
        Player player = new Player(new Ball(20, 20, 20, 20, 2));
        List<Entity> targetList = getTargets();
        addTargets();
        player.setTargets(targets);
        player.handleEvent(new PassTargetEvent(new Ball(20, 20, 20, 20, 2), targetList.get(1)));
        assertEquals(player.getRemainingTargets(), targets);
    }

}   

