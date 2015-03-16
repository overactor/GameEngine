package engine;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyListener;
import java.net.URL;

import javax.swing.event.MouseInputListener;

public abstract class Game implements KeyListener, MouseInputListener
{		
    public Game() 
    {
		
    }

    public abstract void gameStart(EngineSettings settings);
    public abstract void gameTick(double elapsedTime);
    public abstract void gameDraw(Drawable canvas);
    protected final Image loadImage(String pfad)
    {
    	Toolkit tool = Toolkit.getDefaultToolkit();
    	return tool.getImage(pfad);
    }
    protected final Image loadImage(URL pfad)
    {
    	Toolkit tool = Toolkit.getDefaultToolkit();
    	return tool.getImage(pfad);
    }
}
