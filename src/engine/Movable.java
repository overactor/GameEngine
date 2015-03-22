package engine;

public interface Movable
{
	public double getXPos();
	public void setXPos(double x);
	public double getYPos();
	public void setYPos(double y);	
	public double getRotation();
	public void setRotation(double rotation);
	public double getXScale();
	public void setXScale(double scale);
	public double getYScale();
	public void setYScale(double scale);
	public double getXOrigin();
	public void setXOrigin(double xOrigin);
	public double getYOrigin();
	public void setYOrigin(double yOrigin);
	public void moveForward(double step);
	public void moveRight(double step);
	public void setRelativeTo(Movable parent);
	public void revertToAbsolute(Movable parent);
}
