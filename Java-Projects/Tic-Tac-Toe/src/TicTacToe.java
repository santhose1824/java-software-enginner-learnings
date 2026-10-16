import java.util.*;

public class TicTacToe {

    // static variables - these can be used anywhere in the class without passing them as arguments.
    static char[][] ticTacToeBoard = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };

    static String leftCharacterPadding = "%3s";
    static String rightCharacterPadding = "%-2s";
    static String leftColumnPadding = "%3s";
    static String rightColumnPadding = "%-3s";

    // One inner list per game played.
    static ArrayList<ArrayList<String>> playerOneMoves = new ArrayList<>();
    static ArrayList<ArrayList<String>> playerTwoMoves = new ArrayList<>();

    static int playerOneScore = 0;
    static int playerTwoScore = 0;
    static int drawCount = 0;
    static int matchesPlayed = 0;

    static String playerOneName;
    static String playerTwoName;

    static String tableFormat = "| %-5s | %-15s | %-20s | %-18s | %-18s | %-10s |%n";
    static String tableBorder = "+-------+-----------------+----------------------+--------------------+--------------------+------------+";


    // Print Methods - these have static print statements.

    public static void printChoices() {
        System.out.println("===== TIC TAC TOE =====");
        System.out.println("1. Play a game");
        System.out.println("2. View scoreboard");
        System.out.println("3. View last game's moves");
        System.out.println("4. Reset scoreboard");
        System.out.println("5. Exit");
    }

    public static void instructions() {
        System.out.println("===== Instructions =====");
        System.out.println("1. Player One has X.");
        System.out.println("2. Player Two has O.");
        System.out.println("3. Player needs to enter only row and column (1,1)/(1,2) : where 1 represents row and 2 represents column in (1,2). ");
        System.out.println("4. The row and column should be in the range from 1 to 3. ");
        System.out.println("5. After each move you can see the board.");
    }


    // Helper Methods

    public static void drawBoard() {
        System.out.println("");
        for (int i = 0; i < ticTacToeBoard.length; i++) {
            if (i > 0) {
                System.out.print("===============");
                System.out.println();
            }
            for (int j = 0; j < ticTacToeBoard.length; j++) {
                if (j == 0) {
                    System.out.printf(leftCharacterPadding, ticTacToeBoard[i][j]);
                    System.out.printf(leftColumnPadding, "|");
                } else if (j == 1) {
                    System.out.printf(leftCharacterPadding, ticTacToeBoard[i][j] + " ");
                    System.out.printf(rightColumnPadding, "|");
                } else {
                    System.out.printf(rightCharacterPadding, ticTacToeBoard[i][j]);
                }
            }
            System.out.println();
        }
        System.out.println("");
    }

    // Clears all nine cells so every game starts with an empty board.
    public static void resetBoard() {
        for (int i = 0; i < ticTacToeBoard.length; i++) {
            for (int j = 0; j < ticTacToeBoard[i].length; j++) {
                ticTacToeBoard[i][j] = ' ';
            }
        }
    }

    // Clears scores, counts and move history.
    public static void resetScoreboard() {
        playerOneScore = 0;
        playerTwoScore = 0;
        drawCount = 0;
        matchesPlayed = 0;
        playerOneMoves.clear();
        playerTwoMoves.clear();
    }

    // Validates a player name. Prints the reason and returns false if it is not valid.
    public static boolean isValidName(String name, String label) {
        if (name.isEmpty()) {
            System.out.println(label + " name cannot be empty.");
            return false;
        }
        if (name.matches("-?\\+?\\d+")) {
            System.out.println(label + " name should be a string, not an integer.");
            return false;
        }
        return true;
    }


    // Winner Condition checks

    // To check whether all elements in a row are the same.
    public static boolean isRowsAreSame(int rowIndex) {
        char firstElement = ticTacToeBoard[rowIndex][0];
        if (firstElement == ' ') {
            return false;
        }
        for (int i = 1; i < ticTacToeBoard.length; i++) {
            if (ticTacToeBoard[rowIndex][i] != firstElement) {
                return false;
            }
        }
        return true;
    }

    // To check whether all elements in a column are the same.
    public static boolean isColumnsAreSame(int columnIndex) {
        char firstElement = ticTacToeBoard[0][columnIndex];
        if (firstElement == ' ') {
            return false;
        }
        for (int i = 1; i < ticTacToeBoard.length; i++) {
            if (ticTacToeBoard[i][columnIndex] != firstElement) {
                return false;
            }
        }
        return true;
    }

    // To check the diagonal from top left to bottom right.
    public static boolean isTopLeftToBottomRightDiagonalsAreSame() {
        char firstElement = ticTacToeBoard[0][0];
        if (firstElement == ' ') {
            return false;
        }
        for (int i = 1; i < ticTacToeBoard.length; i++) {
            if (ticTacToeBoard[i][i] != firstElement) {
                return false;
            }
        }
        return true;
    }

    // To check the diagonal from top right to bottom left.
    public static boolean isTopRightToBottomLeftDiagonalsAreSame() {
        char firstElement = ticTacToeBoard[0][ticTacToeBoard.length - 1];
        if (firstElement == ' ') {
            return false;
        }
        for (int i = 1; i < ticTacToeBoard.length; i++) {
            if (ticTacToeBoard[i][ticTacToeBoard.length - i - 1] != firstElement) {
                return false;
            }
        }
        return true;
    }

    // Method to determine the winning condition
    public static boolean isWinnerFound() {
        for (int i = 0; i < ticTacToeBoard.length; i++) {
            if (isRowsAreSame(i) || isColumnsAreSame(i)) {
                return true;
            }
        }
        return isTopLeftToBottomRightDiagonalsAreSame() || isTopRightToBottomLeftDiagonalsAreSame();
    }


    // Game Methods

    public static void playGame(Scanner input) {
        // nextInt() in main leaves a newline behind, so consume it here.
        input.nextLine();
        instructions();
        resetBoard();

        // Player One details input.
        System.out.println("Enter player one name :");
        String newPlayerOneName = input.nextLine().trim();
        if (!isValidName(newPlayerOneName, "Player One")) {
            return;
        }

        // Player Two details input.
        System.out.println("Enter player two name :");
        String newPlayerTwoName = input.nextLine().trim();
        if (!isValidName(newPlayerTwoName, "Player Two")) {
            return;
        }

        if (newPlayerOneName.equalsIgnoreCase(newPlayerTwoName)) {
            System.out.println("Both Players cannot have the same name.");
            return;
        }

        // The scoreboard belongs to one pair of players. If a different pair plays, start fresh.
        if (playerOneName != null && playerTwoName != null
                && (!playerOneName.equalsIgnoreCase(newPlayerOneName)
                || !playerTwoName.equalsIgnoreCase(newPlayerTwoName))) {
            System.out.println("New players detected. The scoreboard has been reset.");
            resetScoreboard();
        }
        playerOneName = newPlayerOneName;
        playerTwoName = newPlayerTwoName;

        drawBoard();

        System.out.println("Let's start the game!");
        System.out.println("Player One : " + playerOneName + " starts the game with X.");
        System.out.println("Player Two : " + playerTwoName + " plays with O.");

        // Moves of this game only.
        ArrayList<String> playerOneMovesInnerList = new ArrayList<>();
        ArrayList<String> playerTwoMovesInnerList = new ArrayList<>();

        boolean gameWon = false;
        int turn = 1;

        /*
            Take the players' moves as input.
            Odd turns belong to Player One, even turns to Player Two.
            A turn is only used up when a valid move is placed on the board.
            Invalid input or an already taken cell just asks the same player again.
        */
        while (turn <= 9) {
            boolean isPlayerOneTurn = turn % 2 != 0;
            String currentPlayer = isPlayerOneTurn ? playerOneName : playerTwoName;
            char currentPlayerSymbol = isPlayerOneTurn ? 'X' : 'O';

            System.out.println(currentPlayer + "'s turn (" + currentPlayerSymbol + ")");

            System.out.println("Enter your row : ");
            if (!input.hasNextInt()) {
                input.next();
                System.out.println("Invalid row. Please try again.");
                continue;
            }
            int row = input.nextInt();

            System.out.println("Enter your column : ");
            if (!input.hasNextInt()) {
                input.next();
                System.out.println("Invalid column. Please try again.");
                continue;
            }
            int column = input.nextInt();

            if (row < 1 || row > 3 || column < 1 || column > 3) {
                System.out.println("Row and column must be between 1 and 3. Please try again.");
                continue;
            }

            if (ticTacToeBoard[row - 1][column - 1] != ' ') {
                System.out.println("The particular cell is already taken. Please try again.");
                continue;
            }

            // The move is valid, so place it and record it.
            ticTacToeBoard[row - 1][column - 1] = currentPlayerSymbol;
            String move = currentPlayer + "->(" + row + "," + column + ")";
            if (isPlayerOneTurn) {
                playerOneMovesInnerList.add(move);
            } else {
                playerTwoMovesInnerList.add(move);
            }

            drawBoard();

            if (isWinnerFound()) {
                if (isPlayerOneTurn) {
                    playerOneScore++;
                } else {
                    playerTwoScore++;
                }
                int winnerScore = isPlayerOneTurn ? playerOneScore : playerTwoScore;

                System.out.println("=========================================");
                System.out.println("The winner is " + currentPlayer);
                System.out.println("Your score is : " + winnerScore);
                System.out.println("=========================================");
                gameWon = true;
                break;
            }

            turn++;
        }

        // All nine cells are filled and nobody won.
        if (!gameWon) {
            drawCount++;
            System.out.println("=========================================");
            System.out.println("The game is a draw");
            System.out.println("Overall draw count of both players is : " + drawCount);
            System.out.println("=========================================");
        }

        // Add the inner lists once per game, when the game is over.
        playerOneMoves.add(playerOneMovesInnerList);
        playerTwoMoves.add(playerTwoMovesInnerList);
        matchesPlayed++;
    }


    // This method prints the players' overall score card of the matches played.
    public static void viewScoreCard() {
        if (matchesPlayed == 0) {
            System.out.println("You have not played any game yet.");
            return;
        }

        // A match is lost when the other player wins it. Draws are counted separately.
        int matchesLostByPlayerOne = playerTwoScore;
        int matchesLostByPlayerTwo = playerOneScore;

        System.out.println(tableBorder);
        System.out.printf(tableFormat, "S.No", "Player Name", "No.of matches played", "No.of matches won", "No.of matches lost", "Draws");
        System.out.println(tableBorder);
        System.out.printf(tableFormat, "1.", playerOneName, matchesPlayed, playerOneScore, matchesLostByPlayerOne, drawCount);
        System.out.println(tableBorder);
        System.out.printf(tableFormat, "2.", playerTwoName, matchesPlayed, playerTwoScore, matchesLostByPlayerTwo, drawCount);
        System.out.println(tableBorder);
    }


    // Prints the moves of the most recent game, in the order they were played.
    public static void viewLastGamesMoves() {
        if (playerOneMoves.isEmpty()) {
            System.out.println("You have not played any game yet.");
            return;
        }

        ArrayList<String> lastPlayerOneMoves = playerOneMoves.get(playerOneMoves.size() - 1);
        ArrayList<String> lastPlayerTwoMoves = playerTwoMoves.get(playerTwoMoves.size() - 1);

        System.out.println("===== Last game's moves =====");
        int moveNumber = 1;
        for (int i = 0; i < lastPlayerOneMoves.size(); i++) {
            System.out.println(moveNumber++ + ". " + lastPlayerOneMoves.get(i));
            if (i < lastPlayerTwoMoves.size()) {
                System.out.println(moveNumber++ + ". " + lastPlayerTwoMoves.get(i));
            }
        }
    }


    public static void main(String[] args) {
        int choice;
        Scanner input = new Scanner(System.in);
        printChoices();

        do {
            System.out.println("Enter your choice : ");
            if (!input.hasNextInt()) {
                input.next();
                System.out.println("Please enter a number from 1 to 5 ");
                choice = 0;
                continue;
            }

            choice = input.nextInt();

            switch (choice) {
                case 1 -> playGame(input);
                case 2 -> viewScoreCard();
                case 3 -> viewLastGamesMoves();
                case 4 -> {
                    resetScoreboard();
                    playerOneName = null;
                    playerTwoName = null;
                    System.out.println("Scoreboard has been reset.");
                }
                case 5 -> System.out.println("Exit");
                default -> System.out.println("Please enter a number from 1 to 5 ");
            }

        } while (choice != 5);
    }
}