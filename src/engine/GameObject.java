package engine;

public abstract class GameObject implements Drawable, Movable
{
	private double x = 0;
	private double y = 0;
	private double rotation = 0;
	private double xScale = 1;
	private double yScale = 1;
	private double xOrigin = 0;
	private double yOrigin = 0;
	
	public abstract void tick(double elapsedTime);

	@Override
	public double getXPos() 
	{
		return x;
	}

	@Override
	public void setXPos(double x) 
	{
		this.x = x;
		
	}

	@Override
	public double getYPos() 
	{
		return y;
	}

	@Override
	public void setYPos(double y)
	{
		this.y = y;
	}

	@Override
	public double getRotation()
	{
		return rotation;
	}

	@Override
	public void setRotation(double rotation) 
	{
		this.rotation = rotation;
	}

	@Override
	public double getXScale()
	{
		return xScale;
	}

	@Override
	public void setXScale(double scale)
	{
		this.xScale = scale;
	}

	@Override
	public double getYScale()
	{
		return yScale;
	}

	@Override
	public void setYScale(double scale)
	{
		this.yScale = scale;
	}
	
	@Override
	public double getXOrigin()
	{
		return xOrigin;
	}
	
	@Override
	public void setXOrigin(double xOrigin)
	{
		this.xOrigin = xOrigin;
	}
	
	@Override
	public double getYOrigin()
	{
		return yOrigin;
	}
	
	@Override
	public void setYOrigin(double yOrigin)
	{
		this.yOrigin = yOrigin;
	}
	
	@Override
	public void moveForward(double step)
	{
		x -= step*Math.cos(rotation - Math.PI/2);
		y -= step*Math.sin(rotation - Math.PI/2);
	}
	
	@Override
	public void moveRight(double step)
	{
		x -= step*Math.cos(rotation);
		y -= step*Math.sin(rotation);
	}
	
	
	@Override
	public void setRelativeTo(Movable parent)
	{
		xScale /= parent.getXScale();
		yScale /= parent.getYScale();		
		
		x -= parent.getXPos();
		y -= parent.getYPos();

		double dist = Math.sqrt(x*x + y*y);
		double r = Math.acos(y/dist);
		x = dist*Math.sin(r - parent.getRotation() );
		y = dist*Math.cos(r - parent.getRotation());
		
		x /= parent.getXScale();
		y /= parent.getYScale();
		
		rotation -= parent.getRotation();
	}
	
	@Override
	public void revertToAbsolute(Movable parent)
	{
		xScale *= parent.getXScale();
		yScale *= parent.getYScale();
		
		x *= parent.getXScale();
		y *= parent.getYScale();
		
		double dist = Math.sqrt(x*x + y*y);
		double r = Math.acos(y/dist);
		x = dist*Math.sin(r + parent.getRotation());
		y = dist*Math.cos(r + parent.getRotation());
		
		x += parent.getXPos();
		y += parent.getYPos();

		rotation += parent.getRotation();
	}
	
	final public void DrawRelative(Canvas canvas)
	{
		canvas.Transform((Movable) this);		
		Draw(canvas);
		canvas.RevertTransform((Movable) this);
	}
	
	final public void DrawRelativeTo(Movable parent, Canvas canvas)
	{
		canvas.Transform(parent);
		DrawRelative(canvas);
		canvas.RevertTransform(parent);
	}

}
