package starter;

import engine.GameEngine;
import game.CarGame;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Starter
{
    public static void main(String[] args)
    {
    	GameEngine gameEngine = new GameEngine(new CarGame());
    	gameEngine.addWindowListener(new WindowAdapter()
    	{
    	    public void windowClosing(WindowEvent e)
    	    {
    	    	System.exit(0);;
    	    }
    	});
    	gameEngine.start();
    }
}
