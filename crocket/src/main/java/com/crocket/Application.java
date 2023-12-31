package com.crocket;

import java.util.List;

import com.crocket.controller.CroquetController;
import com.crocket.model.EventPublisher;
import com.crocket.model.Level;
import com.crocket.model.Level1;
import com.crocket.model.LevelTest;
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
        //Level level1 = new Level1();                // For level 1
        //LevelView level1View = new LevelView();     // For level 1
        Level levelTest = new LevelTest();          // For level test
        LevelView levelTestView = new LevelView();  // For level test


        IModel model = Model.getInstance();
        List<Player> players = new ArrayList<Player>();

        EventPublisher eventPublisher = EventPublisher.getInstance();
        eventPublisher.addListener(Model.getInstance());

        //Ball p1Ball = new Ball(19, 19, 1030d, 650d, 20);  // For level 1
        //Ball p2Ball = new Ball(19, 19, 1070d, 650d, 20);  // For level 1
        Ball p1Ball = new Ball(19, 19, 400d, 450d, 20);   // For level test
        Ball p2Ball = new Ball(19, 19, 430d, 480d, 20);   // For level test

        // TODO: Implement a way for the end user to decide how many players there should be
        Player player1 = new Player(p1Ball, "Player 1");
        Player player2 = new Player(p2Ball, "Player 2");
        players.add(player1);
        players.add(player2);

        //model.setLevel(level1);     // For level 1
        model.setLevel(levelTest);  // For level test
        model.setPlayers(players);

        CroquetController controller = new CroquetController(frame, model);
        //level1View.setSurfaceMap(level1.getLevelSurfacemap(), level1.getLevelHeight(), level1.getLevelWidth());             // For level 1
        //frame.setLevelView(level1View);                                                                                     // For level 1
        levelTestView.setSurfaceMap(levelTest.getLevelSurfacemap(), levelTest.getLevelHeight(), levelTest.getLevelWidth()); // For level test
        frame.setLevelView(levelTestView);                                                                                  // For level test
        Thread run = new Thread();
        run.start();

        model.addSubscriber(frame);
        model.start();
    }
}