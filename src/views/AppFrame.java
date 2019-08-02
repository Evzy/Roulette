package views;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import model.SimplePlayer;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.GameEngineCallbackImpl;
import view.interfaces.GameEngineCallback;

@SuppressWarnings("serial")
public class AppFrame extends JFrame{
	
	private GameEngine engine;
	private ToolBar toolBar;
	private ArrayList<Player> players;
	private JMenuBar menuBar;
	private SummaryPanel playerPanel;
	private WheelPanel wheel;
	private StatusBar statusBar = new StatusBar("ROULETTE! Ready to spin!");
	private boolean readyState = true;
	
	public AppFrame(GameEngine engine){	
		
	GameEngineCallback loggingCallback = new GameEngineCallbackImpl();
	GUICallback callback = new GUICallback(statusBar);
	engine.addGameEngineCallback(loggingCallback);		
	engine.addGameEngineCallback(callback);
	this.engine = engine;

	// QUICKLY MAKING AND ADDING PLAYERS, JUST BECAUSE WE DONT WANT NONE WHEN WE SETUP FOR THE TIME BEING, DONT WANT A NULL RESPONSE FROM GETALLPLAYERS();
	
	///*
	Player[] tempPlayers = new Player[] { new SimplePlayer("1", "Come In Spinner", 1000),
	         new SimplePlayer("2", "The Loser", 750), new SimplePlayer("3", "The Dabbler", 500) };
	
	for (Player player : tempPlayers)
    {
      engine.addPlayer(player);
    } //*/
	
    //****************************************************************************
	
	
	//statusBar = new StatusBar("ROULETTE! Ready to spin!");	
	
	players = (ArrayList<Player>) engine.getAllPlayers();
	toolBar = new ToolBar(engine,players,statusBar,this);
	menuBar = new MenuBar(this, engine, statusBar);
	
	playerPanel = new SummaryPanel(players);
	wheel = new WheelPanel(callback);	
	
	setSize(900,800);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setTitle("Roulette");
	setLayout(new BorderLayout());
	setJMenuBar(menuBar);
	setVisible(true);
	
	add(toolBar, BorderLayout.NORTH);
	add(wheel, BorderLayout.CENTER);
	add(playerPanel, BorderLayout.WEST);
	add(statusBar, BorderLayout.SOUTH);
	}
	
	public void Exit() {
		
		System.exit(0);
		
	}
	
	public void Update() {
		
		ArrayList<Player> players = (ArrayList<Player>) engine.getAllPlayers();
		
		remove(playerPanel);
		remove(toolBar);
		add(toolBar = new ToolBar(engine,players,statusBar,this), BorderLayout.NORTH);
		add(playerPanel = new SummaryPanel(players), BorderLayout.WEST);

		revalidate();
		repaint();
	}
	
	
	public boolean getReadyState() {
		
		return readyState;
		
	}
	
	public void setReadyState(boolean readyState) {
		
		this.readyState = readyState;		
		
	}
}
