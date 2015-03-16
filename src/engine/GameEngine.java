package engine;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class GameEngine extends JFrame implements Runnable, Drawable, EngineSettings 
{
	private int fps = 60;
    private int xPos = 0;
    private int yPos = 0;
    private int height = 400;
    private int width = 550;
    private boolean debug = false;
    private String caption = "";
    
    private Thread thread = new Thread(this);
    private long lastTime;
    
    private BufferedImage buf;
    private Graphics2D gBuf;
    private Graphics2D gWin;
    
    Game game;
	
    public GameEngine(Game game)
    {
    	lastTime = 0;
    	this.game = game;
    	game.gameStart((EngineSettings) this);
    	
    	addKeyListener((KeyListener) game);
    	
    	setSize(width, height);
    	setLocation(xPos, yPos);
    	setVisible(true);
    	setResizable(false);
    	setTitle(caption);
    	
    	buf = new BufferedImage(width, height, 1);
    	
    	gBuf = buf.createGraphics();
    	gWin = (Graphics2D) this.getGraphics();
    }
	
	public void start()
	{
	    thread.start();
	}

	@Override
	public void run() 
	{
		while(true)
		{
			tick();
		}
	}
	
	public void tick()
	{
		long elapsedTime = 0;
		long currentTime = System.nanoTime();		
		if (lastTime != 0)
		{
			elapsedTime = currentTime - lastTime;
			int sleep = (int) (1000000/fps - elapsedTime)/1000;
			if (sleep > 0)
			{
				try {
					Thread.sleep(sleep);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				currentTime = System.nanoTime();
				elapsedTime = currentTime - lastTime;
			}
		}
		lastTime = currentTime;
		
		game.gameTick(elapsedTime);
		gBuf.clearRect(0, 0, width, height);
		game.gameDraw((Drawable) this);
		//gBuf.setFont(Font.getFont("Arial"));
		//gBuf.setColor(new Color(0, 0, 0));
		//gBuf.drawString("fps: " + Long.toString(elapsedTime/1000), 20, 20);
		if (debug) System.out.println("fps: " + Long.toString(elapsedTime/1000));
		gWin.drawImage(buf, 0, 0, this);		
	}
	
	/*
	public Image loadImage(String name, String path)
	{
		Toolkit tool = Toolkit.getDefaultToolkit();
		return tool.getImage(path + name);
	}
	*/

	@Override
	public void drawImage(Image image, int x, int y) {
		gBuf.drawImage(image, x, y, this);
	}

	@Override
	public int getFps()
	{
		return fps;
	}

	@Override
	public void setFps(int fps)
	{
		this.fps = fps;
	}

	@Override
	public int getXPos() 
	{
		return xPos;
	}

	@Override
	public void setXPos(int xPos) 
	{
		this.xPos = xPos;
	}

	@Override
	public int getYPos() 
	{
		return yPos;
	}

	@Override
	public void setYPos(int yPos) 
	{
		this.yPos = yPos;
	}

	@Override
	public void setHeight(int height) 
	{
		this.height = height;		
	}

	@Override
	public void setWidth(int width) 
	{
		this.width = width;
	}

	@Override
	public boolean getDebug() 
	{
		return debug;
	}

	@Override
	public void setDebug(boolean debug) 
	{
		this.debug = debug;
	}

	@Override
	public String getCaption()
	{
	    return caption;
	}

	@Override
	public void setCaption(String caption)
	{
	    this.caption = caption;
	}
}
