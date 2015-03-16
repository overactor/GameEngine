package game;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.net.URL;

import engine.Drawable;
import engine.EngineSettings;
import engine.Game;

public class CarGame extends Game 
{
    private String parcoursPfad = "\\res\\Parcours.gif";
    private Image parcours;
	
    private String autoPfad = "\\res\\AnhaltendesAuto.gif";
    private Image auto;
	
    @Override
    public void gameStart(EngineSettings settings) 
    {
    	String workingDir = new File("").getAbsolutePath();
    	//System.out.println(workingDir + parcoursPfad);
    	parcours = loadImage(workingDir + parcoursPfad);
    	auto = loadImage(workingDir + autoPfad);
    		
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
    	// TODO Auto-generated method stub
    }

    @Override
    public void gameDraw(Drawable canvas) 
    {
    	canvas.drawImage(parcours, 0, 0);
    	canvas.drawImage(auto, 50, 500);
    }

    @Override
    public void keyPressed(KeyEvent e) 
    {
    	// TODO Auto-generated method stub
    }

    @Override
    public void keyReleased(KeyEvent e) 
    {
    	// TODO Auto-generated method stub
    }

    @Override
    public void keyTyped(KeyEvent e) 
    {
    	// TODO Auto-generated method stub
    }

	@Override
	public void mouseClicked(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}
}
