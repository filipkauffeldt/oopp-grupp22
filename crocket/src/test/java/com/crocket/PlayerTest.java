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
import java.util.ArrayList;
import java.util.List;

public class PlayerTest {
    private static Queue<Entity> hoops = new LinkedList<Entity>();
    static final Hoop hoop1 = new Hoop(20, 20, 20, 20, 20, Direction.EAST);
    static final Hoop hoop2 = new Hoop(10, 20, 10, 20, 20, Direction.WEST);
    static final Hoop hoop3 = new Hoop(30, 20, 20, 20, 20, Direction.SOUTH);
    static final Hoop hoop4 = new Hoop(40, 20, 10, 20, 20, Direction.NORTH);
    
    public static List<Hoop> getHoops() {
        List<Hoop> hoopers = new ArrayList<Hoop>();
        hoopers.add(hoop1);
        hoopers.add(hoop2);
        hoopers.add(hoop3);
        hoopers.add(hoop4);
        return hoopers;
    }

    public static void addHoops() {
        List<Hoop> hoopers = getHoops();
        hoops.add(hoopers.get(0));
        hoops.add(hoopers.get(1));
        hoops.add(hoopers.get(2));
        hoops.add(hoopers.get(3));
    }
    
    @Test
    public void test_hasWon_false() {
        Player player = new Player(new Ball(20, 20, 20, 20, 2));
        addHoops();
        player.setHoops(hoops);
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
        List<Hoop> hoopers = getHoops();
        addHoops();
        player.setHoops(hoops);
        player.handleEvent(new PassHoopEvent(player.getBall(), hoopers.get(0)));
        assertNotEquals(player.unpassedHoops, hoops);
    }   

    @Test
    public void test_handleEvent_wrongHoop() {
        Player player = new Player(new Ball(20, 20, 20, 20, 2));
        List<Hoop> hoopers = getHoops();
        addHoops();
        player.setHoops(hoops);
        player.handleEvent(new PassHoopEvent(new Ball(20, 20, 20, 20, 2), hoopers.get(1)));
        assertEquals(player.unpassedHoops, hoops);
    }

}   
