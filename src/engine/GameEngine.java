package engine;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class GameEngine extends JFrame implements Runnable, Canvas, EngineSettings 
{
	private static final long serialVersionUID = 1243484763699841276L;
	
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
    	game.gameStart((EngineSettings) this, getRootPane().getInputMap(), getRootPane().getActionMap());
    	
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
			long sleep = Math.round(((double)1000000000.0/fps - elapsedTime)/1000000.0);
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
		
		game.gameTick(((double) elapsedTime)/1000000000.0);
		gBuf.clearRect(0, 0, width, height);
		game.gameDraw((Canvas) this);
		if (debug) System.out.println("fps: " + Long.toString(Math.round(1000000000.0/elapsedTime)));
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
	public void drawImage(Image image, int x, int y)
	{
		gBuf.drawImage(image, x, y, this);
	}

	@Override
	public void drawImage(Image image, double x, double y)
	{
		drawImage(image, (int) Math.round(x), (int) Math.round(y));
	}

	@Override
	public Graphics2D getGraphics2D()
	{
		return gBuf;
	}

	@Override
	public void Transform(Movable relative)
	{
		gBuf.translate(relative.getXPos(), relative.getYPos());
		gBuf.scale(relative.getXScale(), relative.getYScale());
		gBuf.rotate(relative.getRotation());
	}

	@Override
	public void RevertTransform(Movable relative)
	{
		gBuf.rotate(-1*relative.getRotation());
		gBuf.scale(1/relative.getXScale(), 1/relative.getYScale());
		gBuf.translate(-1*relative.getXPos(), -1*relative.getYPos());
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
