public class Player
{
    private static final int[] SHIP_LENGTHS = {2, 3, 3, 4, 5};
    private Grid board = new Grid();
    private Grid oppBoard = new Grid();
    private Ship[] ships = new Ship[5];
    private int count = 0;
    
    public Player()
    {
        Grid theBoard = board;
        Grid opBoard = oppBoard;
        Ship[] theShips = ships;
        for(int i = 0; i < 5; i++)
        {
            theShips[i] = new Ship(SHIP_LENGTHS[i]);
        }
        
    }
    
    public void chooseShipLocation(int row, int col, int direction)
    {
        if(count < 5)
        {
            ships[count].setLocation(row, col);
            ships[count].setDirection(direction);
            board.addShip(ships[count]);
            count++;
        }
    }
    public int getShipLength(int pos)
    {
        if(pos < 5)
        {
            System.out.println(pos);
            return SHIP_LENGTHS[pos];
        }
        return 0;
    }
    public void printMyShips()
    {
        board.printShips();
    }
    public void printOpponentGuesses()
    {
        oppBoard.printStatus();
    }
    public boolean isGuessed(int row, int col)
    {
        return board.alreadyGuessed(row, col);
    }
    public void printMyGuesses()
    {
        board.printStatus();
    }
    public Grid getBoard()
    {
        return board;
    }
    public boolean valid(int row, int col, int length, int direction)
    {
        return board.isValid(row, col, length, direction);
    }
    public boolean checkTheBoard()
    {
        return oppBoard.checkBoard();
    }
    public void recordOpponentGuess(int row, int col)
    {
        if(board.hasShip(row, col));
        {
            oppBoard.markHit(row, col);
        }
        if(!board.hasShip(row, col))
        {
            oppBoard.markMiss(row, col);
        }
    }
}