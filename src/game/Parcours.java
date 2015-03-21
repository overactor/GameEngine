package game;

import java.awt.Image;
import java.io.File;

import javax.swing.ActionMap;
import javax.swing.InputMap;

import engine.Canvas;
import engine.Game;
import engine.GameObject;

public class Parcours extends GameObject
{
	private String parcoursPfad = "\\res\\Parcours.gif";
    private Image parcours;
    
    private Car car;
    
	public Parcours(InputMap inputMap, ActionMap actionMap)
	{
		String workingDir = new File("").getAbsolutePath();
    	parcours = Game.loadImage(workingDir + parcoursPfad);
    	
    	car = new Car(inputMap, actionMap);
	}

	@Override
	public void Draw(Canvas canvas)
	{
		canvas.drawImage(parcours, 0, 0);
		car.DrawRelative(canvas);
	}

	@Override
	public void tick(double elapsedTime)
	{
		car.tick(elapsedTime);
	}

}
