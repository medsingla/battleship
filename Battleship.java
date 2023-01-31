public class Battleship extends ConsoleProgram
{
    public void run()
    {
        Randomizer rand = new Randomizer();
        System.out.println("Welcome to Battleship! \n");
        Player one = new Player();
        Player two = new Player();
        String[] letters = {"A","B","C","D","E","F","G","H","I","J"};


        // PRINT INITIAL GRID
        one.printMyShips();
        // FOR 5 SHIPS USER PICKED
        for(int j = 0; j < 5; j++)
        {
            // GET LOCATION
            int x = j + 1;
            int col = readInt("\nColumn of Ship " + x + " (Length of " + one.getShipLength(j) + ") : ") - 1;
            int row = 10;
            String temp = readLine("Row of Ship " + x + ": ").toUpperCase();
            for(int i = 0; i < 10; i++)
            {
                if(letters[i].equals(temp))
                {
                row = i;
                }
            }
            boolean locationValid = true;
            // GET DIRECTION
            int direction = 0;
            boolean directionValid = true;
            if(locationValid)
            {
                String dir = readLine("Direction of Ship (enter horiztonal or vertical: ");
                System.out.print("\n");
                if(dir.toLowerCase().equals("h") || dir.toLowerCase().equals("horizontal"))
                {
                    direction = 0;
                }
                else if(dir.toLowerCase().equals("v") || dir.toLowerCase().equals("vertical"))
                {
                    direction = 1;
                }
                // INCORRECT DIRECTION PREVENTION
                else
                {
                    directionValid = false;
                    System.out.println("Error! Try again");
                    j--;
                }
            }
            // INCORRECT LOCATION PREVENTION
            if(row > 9 || col > 9 || one.getBoard().hasShip(row, col) || !one.valid(row, col, one.getShipLength(j), direction))
            {
                if(directionValid)
                {
                    System.out.println("Error! Try again");
                    locationValid = false;
                    j--;
                }
            }
            // SET SHIP
            if(locationValid && directionValid)
            {
                one.chooseShipLocation(row, col, direction);
                one.printMyShips();
            }
        }
    


// COMPUTER GENERATED SHIPS
        for(int j = 0; j < 5; j++)
            {
                // GET LOCATION
                int col = rand.nextInt(9);
                int row = rand.nextInt(9);
                boolean locationValid = true;
                // GET DIRECTION
                int direction = rand.nextInt(2);
                // INCORRECT LOCATION PREVENTION
                if(row > 9 || col > 9 || two.getBoard().hasShip(row, col) || !two.valid(row, col, two.getShipLength(j), direction))
                {
                        locationValid = false;
                        j--;
                }
                // SET SHIP
                if(locationValid)
                {
                    two.chooseShipLocation(row, col, direction);
                }
            }
// ======================================================================================
        
        
        // PREVIOUS CODE
        System.out.println("\nPlayer Two Board Guesses: \n");
        two.printOpponentGuesses();
        
        // ASK FOR PLAYER GUESS START
        int col = 0;
        int row = 0;
        int x = 0;
        String win = "";
        while(x == 0)
            {
            for(int i = 0; i < 1; i++)
            {
                col = readInt("Column of Player One's Guess: ") - 1;
                row = 0;
                String temp = readLine("Row of Player One's Guess: ").toUpperCase();
                for(i = 0; i < 10; i++)
                {
                    if(letters[i].equals(temp))
                    {
                        row = i;
                    }
                }
                if(col > 9 || row > 9)
                {
                    System.out.println("Invalid Guess! Try again.");
                    i--;
                }
                else
                {
                    if(one.isGuessed(row, col))
                    {
                        System.out.println("Invalid Guess! Try again.");
                        i--;
                    }
                }
            }
            two.recordOpponentGuess(row, col);
            System.out.println("\nPlayer One Guess on Player Two's Board: \n");
            two.printOpponentGuesses();
            
            
            // COMPUTER GUESS
            
            for(int i = 0; i < 1; i++)
            {
                col = rand.nextInt(10);
                row = rand.nextInt(10);
                if(col > 9 || row > 9 || two.isGuessed(row, col))
                {
                    System.out.println("Invalid Guess! Try again.");
                    i--;
                }
            }
            
            // COMPUTER OUTPUT
            one.recordOpponentGuess(row, col);
            System.out.println("\nPlayer Two Guess On Player One Board: \n");
            one.printOpponentGuesses();
            
            System.out.println("Player Two Board: \n");
            two.printOpponentGuesses();
        
        // ASK FOR GUESS END
        if(one.checkTheBoard())
        {
            win = "one";
            x = 1;
        }
        if(two.checkTheBoard())
        {
            win = "two";
            x = 1;
        }
        }
        System.out.println("\n Player " + win + " Wins!");
}
}