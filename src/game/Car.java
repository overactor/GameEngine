package game;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.KeyStroke;

import engine.Canvas;
import engine.Game;
import engine.GameObject;

public class Car extends GameObject
{
	private String autoPfad = "\\res\\AnhaltendesAuto.gif";
    private Image auto;

    //private double xSpeed = 0;
    private double ySpeed = 0;
    private double rotationSpeed = 0;
    
    public Car(InputMap inputMap, ActionMap actionMap)
    {
    	String workingDir = new File("").getAbsolutePath();
    	auto = Game.loadImage(workingDir + autoPfad);

    	setXOrigin(50);
    	setYOrigin(65);
    	setXPos(200);
    	setYPos(400);

    	actionMap.put("speedUp", speedUp);
    	actionMap.put("speedDown", speedDown);
    	actionMap.put("speedLeft", speedLeft);
    	actionMap.put("speedRight", speedRight);
    	actionMap.put("slowUp", slowUp);
    	actionMap.put("slowDown", slowDown);
    	actionMap.put("slowLeft", slowLeft);
    	actionMap.put("slowRight", slowRight);

    	inputMap.put(KeyStroke.getKeyStroke("pressed UP"), "speedUp");
    	inputMap.put(KeyStroke.getKeyStroke("pressed DOWN"), "speedDown");
    	inputMap.put(KeyStroke.getKeyStroke("pressed LEFT"), "speedLeft");
    	inputMap.put(KeyStroke.getKeyStroke("pressed RIGHT"), "speedRight");
    	inputMap.put(KeyStroke.getKeyStroke("released UP"), "slowUp");
    	inputMap.put(KeyStroke.getKeyStroke("released DOWN"), "slowDown");
    	inputMap.put(KeyStroke.getKeyStroke("released LEFT"), "slowLeft");
    	inputMap.put(KeyStroke.getKeyStroke("released RIGHT"), "slowRight");
    }
	
	@Override
	public void Draw(Canvas canvas) 
	{
		canvas.drawImage(auto, -1*getXOrigin(), -1*getYOrigin());
	}

	@Override
	public void tick(double elapsedTime) 
	{
		//setXPos(getXPos() + xSpeed*elapsedTime);
		//setYPos(getYPos() + ySpeed*elapsedTime);
		moveForward(ySpeed*elapsedTime);
		if (ySpeed < 0)
		{
			setRotation(getRotation() + rotationSpeed*elapsedTime);
		}
		else if (ySpeed > 0)
		{
			setRotation(getRotation() - rotationSpeed*elapsedTime);
		}
	}
    
    private AbstractAction speedUp = new AbstractAction() 
    {
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			setEnabled(false);
			ySpeed -= 160;			
		}
	};
    
    private AbstractAction speedDown = new AbstractAction() 
    {	
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			setEnabled(false);
			ySpeed += 160;			
		}
	};
    
    private AbstractAction speedLeft = new AbstractAction() 
    {
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			setEnabled(false);
			//xSpeed -= 90;
			rotationSpeed -= 0.9;
		}
	};
    
    private AbstractAction speedRight = new AbstractAction() 
    {
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			setEnabled(false);
			//xSpeed += 90;
			rotationSpeed += 0.9;
		}
	};
    
    private AbstractAction slowUp = new AbstractAction() 
    {
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			speedUp.setEnabled(true);
			ySpeed += 160;			
		}
	};
    
    private AbstractAction slowDown = new AbstractAction() 
    {	
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			speedDown.setEnabled(true);
			ySpeed -= 160;			
		}
	};
    
    private AbstractAction slowLeft = new AbstractAction() 
    {
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			speedLeft.setEnabled(true);
			//xSpeed += 90;
			rotationSpeed += 0.9;
		}
	};
    
    private AbstractAction slowRight = new AbstractAction() 
    {
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			speedRight.setEnabled(true);
			//xSpeed -= 90;
			rotationSpeed -= 0.9;
		}
	};
}
