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
	
	public void setXOrigin(double xOrigin)
	{
		this.xOrigin = xOrigin;
	}
	
	public double getYOrigin()
	{
		return yOrigin;
	}
	
	public void setYOrigin(double yOrigin)
	{
		this.yOrigin = yOrigin;
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
