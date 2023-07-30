public class Ship
{
    // Direction Constants
    public static final int UNSET = -1;
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;
    
    // Instance Variables
    private int row = UNSET;
    private int col = UNSET;
    private int theLength;
    private int direction = UNSET;
    
    // Constructor
    public Ship(int length)
    {
        theLength = length;
    }
    
    public int getRow()
    {
        return row;
    }
    
    public int getCol()
    {
        return col;
    }
    
    public int getLength()
    {
        return theLength;
    }
    
    public int getDirection()
    {
        return direction;
    }
    
    // Has the location been initialized
    public boolean isLocationSet()
    {
        return row != -1 && col != -1;
    } 
    
    // Has the direction been initialized
    public boolean isDirectionSet()
    {
        return direction != UNSET;
    }
    
    // Set the location of the ship 
    public void setLocation(int theRow, int theCol)
    {
        row = theRow;
        col = theCol;
    }
    
    // Set the direction of the ship
    public void setDirection(int theDirection)
    {
        if(theDirection == 0)
        {
            direction = HORIZONTAL;
        }
        if(theDirection == 1)
        {
            direction = VERTICAL;
        }
    }
    
    // Helper method to get a string value from the direction
    private String directionToString()
    {
        if(direction == 0)
        {
            return "horizontal";
        }
        if(direction == 1)
        {
            return "vertical";
        }
        return "unset direction";
    }
    
    // Helper method to get a (row, col) string value from the location
    private String locationToString()
    {
        if(row == -1 || col == -1)
        {
        return "(unset location)";
        }
        return "(" + row + ", " + col + ")";
    }
    
    // toString value for this Ship
    public String toString()
    {
        return directionToString() + " ship of length " + theLength + " at " + locationToString();
    }
    
}