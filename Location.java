public class Location
{
    public static final int UNGUESSED = 0;
    public static final int HIT = 1;
    public static final int MISSED = 2;
    
    private boolean containsShip;
    private int theStatus;
    
    public Location()
    {
        theStatus = 0;
    }
    
    public boolean checkHit()
    {
        if(theStatus == HIT)
        {
            return true;
        }
        return false;
    }
    public boolean checkMiss()
    {
        if(theStatus == MISSED)
        {
            return true;
        }
        return false;
    }
    public boolean isUnguessed()
    {
        if(theStatus == UNGUESSED)
        {
            return true;
        }
        return false;
    }
    public void markHit()
    {
        theStatus = HIT;
    }
    public void markMiss()
    {
        theStatus = MISSED;
    }
    public void setStatus(int status)
    {
        if(checkHit())
        {
            theStatus = HIT;
        }
        if(checkMiss())
        {
            theStatus = MISSED;
        }
        if(isUnguessed())
        {
            theStatus = UNGUESSED;
        }
    }
    public boolean hasShip()
    {
        return containsShip;
    }
    
    public void setShip(boolean val)
    {
        containsShip = val;
    }
    
    public int getStatus()
    {
        return theStatus;
    }
}