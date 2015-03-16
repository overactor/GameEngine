package engine;

public interface EngineSettings 
{
    public int getFps();
    public void setFps(int fps);
    public int getXPos();
    public void setXPos(int xPos);
    public int getYPos();
    public void setYPos(int yPos);
    public int getHeight();
    public void setHeight(int height);
    public int getWidth();
    public void setWidth(int width);
    public boolean getDebug();
    public void setDebug(boolean debug);
    public String getCaption();
    public void setCaption(String caption);
}