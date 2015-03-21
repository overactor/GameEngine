package engine;

import java.awt.Graphics2D;
import java.awt.Image;

public interface Canvas 
{
    public void drawImage(Image image, int x, int y);
    public void drawImage(Image image, double x, double y);
    public Graphics2D getGraphics2D();
    
    public void Transform(Movable relative);
    public void RevertTransform(Movable relative);
}