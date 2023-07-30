public class Grid
{
    private Location[][] grid;
    
    public static final String[] letters = {"A","B","C","D","E","F","G","H","I","J"};
    public static final int NUM_ROWS = 10;
    public static final int NUM_COLS = 10;
    private boolean validLocation = true;
    
    public Grid()
    {
        grid = new Location[NUM_ROWS][NUM_COLS];
        for(int i = 0; i < 10; i++)
        {
            for(int j = 0; j < 10; j++)
            {
                grid[i][j] = new Location();
            }
        }
    }
    
    public void markHit(int row, int col)
    {
        grid[row][col].markHit();
    }
    public void markMiss(int row, int col)
    {
        grid[row][col].markMiss();
    }
    public void setStatus(int row, int col, int status)
    {
        grid[row][col].setStatus(status);
    }
    public int getStatus(int row, int col)
    {
        return grid[row][col].getStatus();
    }
    public boolean isValid(int row, int col, int length, int direction)
    {
        if(direction == 0 && col + length > 10)
        {
            return false;
        }
        if(direction == 1 && row + length > 10)
        {
            return false;
        }
        if(direction == 0 && col + length < 10)
        {
            for(int i = col; i < col + length; i ++)
            {
                {
                 if(hasShip(row, i))
                 {
                     return false;
                 }
                }
            }
        }
        if(direction == 1 && row + length < 10)
        {
            for(int i = row; i < row + length; i ++)
            {
                if(hasShip(i, col))
                 {
                     return false;
                 }
            }
        }
        return validLocation;
    }
    public boolean alreadyGuessed(int row, int col)
    {
        return !grid[row][col].isUnguessed();
    }
    public void setShip(int row, int col, boolean val)
    {
        grid[row][col].setShip(val);
    }
    public boolean hasShip(int row, int col)
    {
        return grid[row][col].hasShip();
    }
    public boolean checkBoard()
    {
        int x = 0;
        for(int i = 0; i < NUM_ROWS; i++)
        {
            for(int j = 0; j < NUM_COLS; j++)
            {
                if(grid[i][j].getStatus() == 1)
                {
                    x++;
                }
            }
        }
        if(x == 17)
        {
            System.out.println(x);
            return true;
        }
        else
        {
            System.out.println(x);
            x = 0;
        }
        return false;
    }
    public int numRows()
    {
        return NUM_ROWS;
    }
    public int numCols()
    {
        return NUM_COLS;
    }
    public void printStatus()
    {
        System.out.print("  1 2 3 4 5 6 7 8 9 10\n");
        for(int i = 0; i < NUM_ROWS; i++)
        {
            System.out.print(letters[i]);
            for(int j = 0; j < NUM_COLS; j++)
            {
                if(grid[i][j].isUnguessed())
                {
                    System.out.print(" -");
                }
                if(grid[i][j].checkMiss())
                {
                    System.out.print(" O");
                }
                if(grid[i][j].checkHit())
                {
                    System.out.print(" X");
                }
            }
            System.out.print(" \n");
        }
    }
    public void printShips()
    {
        System.out.print("  1 2 3 4 5 6 7 8 9 10\n");
        for(int i = 0; i < NUM_ROWS; i++)
        {
            System.out.print(letters[i]);
            for(int j = 0; j < NUM_COLS; j++)
            {
                if(!grid[i][j].hasShip())
                {
                    System.out.print(" -");
                }
                if(grid[i][j].hasShip())
                {
                    System.out.print(" X");
                }
            }
            System.out.print(" \n");
        }
    }
    
    public void addShip(Ship s)
    {
        validLocation = true;
        int length = s.getLength();
        int row = s.getRow();
        int col = s.getCol();
        int direction = s.getDirection();
        if(direction == 0 && col + length < 11)
        {
            for(int i = col; i < col + length; i ++)
            {
                {
                setShip(row, i, true);
                }
            }
        }
        if(direction == 1 && row + length < 11)
        {
            for(int i = row; i < row + length; i ++)
            {
                setShip(i, col, true);
            }
        }
    }
}