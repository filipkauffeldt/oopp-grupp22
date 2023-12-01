package com.crocket;

import java.util.List;
import java.util.ArrayList;

public class Application {

    private static final int delay = 20;
    private static CroquetView frame = CroquetView.getInstance();
    private static ILevel Level1 = new Level1();
    private static LevelView level1View = new LevelView();

    public static void main( String[] args )
    {
        init(); 
    }

    private static void init() {
        IModel model = Model.getInstance();
        ILevel level = new Level1();
        List<Player> players = new ArrayList<Player>();

        Ball p1Ball = new Ball(20, 20, 300d, 300d, 20);
        Ball p2Ball = new Ball(20, 20, 300d, 300d, 20);

        // TODO: Implement a way for the end user to decide how many players there should be
        Player player1 = new Player(p1Ball);
        Player player2 = new Player(p2Ball);
        players.add(player1);
        players.add(player2);

        model.setLevel(level);
        model.setPlayers(players);

        CroquetController controller = new CroquetController(frame, level1View, model);
        level1View.setSurfaceMap(Level1.getLevelSurfacemap(), Level1.getLevelHeight(), Level1.getLevelWidth());
        frame.setLevelView(level1View);
        Thread run = new Thread();
        run.start();

        while (true) {
            try {
                Thread.sleep(delay);
            } catch (Exception ex) {
            }
            controller.update();

        }

    }
}