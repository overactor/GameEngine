package game;

import javax.swing.ActionMap;
import javax.swing.InputMap;

import engine.Canvas;
import engine.EngineSettings;
import engine.Game;

public class CarGame extends Game 
{
	private Parcours parcours;
	
    @Override
    public void gameStart(EngineSettings settings, InputMap inputMap, ActionMap actionMap) 
    {
    	
    	parcours = new Parcours(inputMap, actionMap);
    	
    	settings.setFps(60);
    	settings.setHeight(700);
    	settings.setWidth(400);
    	settings.setXPos(30);
    	settings.setYPos(30);
    	settings.setDebug(false);
    	settings.setCaption("Vrooom!!!");
    	
    	
    }

    @Override
    public void gameTick(double elapsedTime) 
    {
    	parcours.tick(elapsedTime);
    }

    @Override
    public void gameDraw(Canvas canvas) 
    {
    	parcours.DrawRelative(canvas);
    }
}
