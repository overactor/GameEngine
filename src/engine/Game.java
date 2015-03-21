package engine;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.ActionMap;
import javax.swing.InputMap;

public abstract class Game
{	
    public Game() 
    {
    	
    }

    public abstract void gameStart(EngineSettings settings, InputMap inputMap, ActionMap actionMap);
    public abstract void gameTick(double elapsedTime);
    public abstract void gameDraw(Canvas canvas);
    static public final Image loadImage(String pfad)
    {
    	Toolkit tool = Toolkit.getDefaultToolkit();
    	return tool.getImage(pfad);
    }
    static public final Image loadImage(URL pfad)
    {
    	Toolkit tool = Toolkit.getDefaultToolkit();
    	return tool.getImage(pfad);
    }
}
