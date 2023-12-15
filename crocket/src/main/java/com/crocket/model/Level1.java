package com.crocket.model;

import static com.crocket.shared.SurfaceType.*;

import com.crocket.model.entity.Hoop;
import com.crocket.model.entity.Peg;
import com.crocket.model.entity.Stone;
import com.crocket.shared.Direction;
import com.crocket.shared.SurfaceType;

/**
 * Represents Level 1 in the game.
 * Extends the abstract class Level.
 */
public class Level1 extends Level {
    private static int width = 25;
    private static int height = 15;
    private static final int STONEWIDTH = 30;
    private static final int STONEHEIGHT = 30;
    private static final int HOOPHEIGHT = 20;
    private static final int HOOPWIDTH = 40;
    private static final int HOOPOPENINGWIDTH = 32;
    private static final int HOOPOPENINGHEIGHT = 4;
    private static final int PEGWIDTH = 5;
    private static final int PEGHEIGHT = 40;

    private static SurfaceType[][] tilemap = {
            { GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS},
            { GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS },
            { GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS,GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS },
            { GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, ICE, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS },
            { GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, ICE, ICE, ICE, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS },
            { GRASS, GRASS, GRASS, GRASS, GRASS, ICE, ICE, ICE, ICE, ICE, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS },
            { GRASS, GRASS, GRASS, GRASS, ICE, ICE, ICE, ICE, ICE, ICE, ICE, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS },
            { GRASS, GRASS, GRASS, GRASS, GRASS, ICE, ICE, ICE, ICE, ICE, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, SAND },
            { GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, ICE, ICE, ICE, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, SAND, SAND, SAND },
            { GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, ICE, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, SAND, SAND, SAND, SAND },
            { GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, SAND, SAND, SAND, SAND, SAND },
            { GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, SAND, SAND, SAND, SAND, SAND, SAND, SAND, SAND, SAND, SAND, GRASS },
            { GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, SAND, SAND, SAND, SAND, SAND, SAND, SAND, SAND, SAND, SAND, GRASS, GRASS, GRASS },
            { GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, SAND, SAND, SAND, SAND, SAND, SAND, SAND, SAND, SAND, SAND, SAND, GRASS, GRASS, GRASS },
            { GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, SAND, SAND, SAND, SAND, SAND,SAND, SAND, SAND, SAND, SAND, SAND, GRASS, GRASS, GRASS, GRASS} };

    private static Stone[] stoneList = {
            new Stone(STONEWIDTH, STONEHEIGHT, 970, 570),
            new Stone(STONEWIDTH, STONEHEIGHT, 1070, 500),
            new Stone(STONEWIDTH, STONEHEIGHT, 900, 400),
            new Stone(STONEWIDTH, STONEHEIGHT, 1070, 200),
            new Stone(STONEWIDTH, STONEHEIGHT,970, 0),
            new Stone(STONEWIDTH, STONEHEIGHT, 700, 300),
            new Stone(STONEWIDTH, STONEHEIGHT, 600, 500),
            new Stone(STONEWIDTH, STONEHEIGHT, 400, 100),
            new Stone(STONEWIDTH, STONEHEIGHT, 400, 400),
            new Stone(STONEWIDTH, STONEHEIGHT, 200, 500)
    };

    private static Hoop[] hoopsList = {
            new Hoop(HOOPWIDTH, HOOPHEIGHT, HOOPOPENINGWIDTH, HOOPOPENINGHEIGHT, 970, 460, Direction.NORTH), 
            new Hoop(HOOPWIDTH, HOOPHEIGHT, HOOPOPENINGWIDTH, HOOPOPENINGHEIGHT, 1020, 260, Direction.NORTH),
            new Hoop(HOOPWIDTH, HOOPHEIGHT, HOOPOPENINGWIDTH, HOOPOPENINGHEIGHT, 970, 60, Direction.NORTH), 
            new Hoop(HOOPHEIGHT, HOOPWIDTH, HOOPOPENINGWIDTH, HOOPOPENINGHEIGHT, 800, 200, Direction.WEST),
            new Hoop(HOOPHEIGHT, HOOPWIDTH, HOOPOPENINGWIDTH, HOOPOPENINGHEIGHT, 700, 500, Direction.WEST), 
            new Hoop(HOOPWIDTH, HOOPHEIGHT, HOOPOPENINGWIDTH, HOOPOPENINGHEIGHT, 600, 300, Direction.NORTH),
            new Hoop(HOOPWIDTH, HOOPHEIGHT, HOOPOPENINGWIDTH, HOOPOPENINGHEIGHT, 470, 160, Direction.SOUTH), 
            new Hoop(HOOPHEIGHT, HOOPWIDTH, HOOPOPENINGWIDTH, HOOPOPENINGHEIGHT, 400, 500, Direction.EAST),
            new Hoop(HOOPWIDTH, HOOPHEIGHT, HOOPOPENINGWIDTH, HOOPOPENINGHEIGHT, 270, 300, Direction.SOUTH), 
            new Hoop(HOOPWIDTH, HOOPHEIGHT, HOOPOPENINGWIDTH, HOOPOPENINGHEIGHT, 150, 550, Direction.NORTH)
    };

    public Level1() {
        super(width, height, tilemap);

        for(Stone stone : stoneList){
            addStone(stone);
        }
        for (Hoop hoop : hoopsList){
            addHoop(hoop);
        }
        Peg p = new Peg(PEGWIDTH, PEGHEIGHT, 309, 100);
        addPeg(p);
    }

    public Level1(Level1 levelCopy){
        super(levelCopy);
    }
}
