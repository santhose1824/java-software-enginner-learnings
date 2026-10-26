# Tic Tac Toe (Java Console Game)

A two-player Tic Tac Toe game that runs in the terminal. It keeps a scoreboard for the current pair of players and lets you review the moves of the last game.

## Features

- Two-player game on a 3x3 board (Player One is `X`, Player Two is `O`)
- Input validation for names, rows and columns
- Win detection for rows, columns and both diagonals
- Draw detection when all 9 cells are filled
- Scoreboard with matches played, won, lost and drawn
- Move history for the most recent game
- Scoreboard reset option

## Requirements

- Java 14 or later (the code uses the `switch` arrow syntax)

Check your version with:

```
java -version
```

## How to Run

From the folder that contains `TicTacToe.java`:

```
javac TicTacToe.java
java TicTacToe
```

## Menu

```
===== TIC TAC TOE =====
1. Play a game
2. View scoreboard
3. View last game's moves
4. Reset scoreboard
5. Exit
```

| Option | What it does |
|--------|--------------|
| 1 | Starts a new game. You are asked for both player names. |
| 2 | Shows the scoreboard for the current pair of players. |
| 3 | Shows every move of the last game, in the order played. |
| 4 | Clears scores, draw count, match count and move history. |
| 5 | Exits the program. |

## How to Play

1. Choose option `1` and enter the two player names.
2. Player One (`X`) moves first, then the players alternate.
3. On your turn, enter the **row** and then the **column**, each from 1 to 3.
4. The board is shown after every move.
5. The game ends when a player gets three in a row (horizontally, vertically or diagonally) or when all 9 cells are filled (draw).

The board coordinates look like this:

```
(1,1) | (1,2) | (1,3)
(2,1) | (2,2) | (2,3)
(3,1) | (3,2) | (3,3)
```

### Example

```
Enter your row :
2
Enter your column :
2
```

This places your symbol in the centre cell.

## Rules and Validation

- Names cannot be empty or purely numeric.
- Both players cannot have the same name (case-insensitive).
- Row and column must be numbers between 1 and 3.
- If you choose a cell that is already taken, or enter invalid input, you are asked again. Your turn is not lost.

## Scoreboard

The scoreboard tracks one pair of players at a time:

- **Matches played**: games finished by this pair
- **Matches won**: games the player won
- **Matches lost**: games the other player won
- **Draws**: games that ended with no winner

If a different pair of names starts a game, the scoreboard resets automatically. You can also reset it manually with option `4`.

## Project Structure

```
TicTacToe.java   // All game logic in a single class
README.md
```

Main sections inside `TicTacToe.java`:

| Section | Purpose |
|---------|---------|
| Print methods | Menu and instructions |
| Helper methods | Board drawing, board reset, scoreboard reset, name validation |
| Winner checks | Row, column and diagonal checks, combined in `isWinnerFound()` |
| Game methods | `playGame`, `viewScoreCard`, `viewLastGamesMoves` |
| `main` | Menu loop |

## Known Limitations

- Scores and move history are kept in memory only and are lost when the program exits.
- Only the last game's moves are shown, and only one pair of players is tracked at a time.
- The game is console-only and designed for two human players (no computer opponent).