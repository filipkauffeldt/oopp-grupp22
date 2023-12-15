package com.crocket;

import java.util.List;

import com.crocket.controller.CroquetController;
import com.crocket.model.Level;
import com.crocket.model.Level1;
import com.crocket.model.Model;
import com.crocket.model.Player;
import com.crocket.model.entity.Ball;
import com.crocket.model.interfaces.IModel;
import com.crocket.view.CroquetView;
import com.crocket.view.LevelView;

import java.util.ArrayList;

public class Application {
    public static void main( String[] args )
    {
        init(); 
    }

    private static void init() {
        CroquetView frame = CroquetView.getInstance();
        Level level1 = new Level1();
        LevelView level1View = new LevelView();

        IModel model = Model.getInstance();
        List<Player> players = new ArrayList<Player>();

        Ball p1Ball = new Ball(19, 19, 1030d, 650d, 20);
        Ball p2Ball = new Ball(19, 19, 1070d, 650d, 20);

        // TODO: Implement a way for the end user to decide how many players there should be
        Player player1 = new Player(p1Ball, "Player 1");
        Player player2 = new Player(p2Ball, "Player 2");
        players.add(player1);
        players.add(player2);

        model.setLevel(level1);
        model.setPlayers(players);

        CroquetController controller = new CroquetController(frame, model);
        level1View.setSurfaceMap(level1.getLevelSurfacemap(), level1.getLevelHeight(), level1.getLevelWidth());
        frame.setLevelView(level1View);
        Thread run = new Thread();
        run.start();

        model.addSubscriber(level1View);
        model.start();
    }
}