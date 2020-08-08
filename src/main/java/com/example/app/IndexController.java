package com.example.app;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.app.model.Cell;

@Controller
@RequestMapping({ "/", "/index" })
public class IndexController {

	// Initialization of the grid
	GameInitializer gameInitializer = new GameInitializer();

	private String currentPlayer = "";

	// Variable that store player number
	private int playerNumber = 0;

	// Variable that store what users play. Either 'X' or 'O'
	// Initialized with 'X' because first player play 'X'
	String draw = "X";

	// Grid corresponding the number of columns and rows
	// Cell holds the index of the row and colunm and the value played by the user.
	Map<String, List<Cell>> grids = new HashMap<String, List<Cell>>();

	// Variable that store if player win
	boolean win = false;

	// Variable that store if the game ends with draw
	boolean game_draw = false;

	// Variable to count play
	int counter = 0;

	// Start with the assumption that grid has 3 rows and 3 cols
	int square = 3;

	// Variable that store which player number win
	int winner = 0;

	// Variable that store the last player who played
	int previous_player = 0;

	/**
	 * Index page that set game grid
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping
	public String getIndex(Model model) {
		// Initialize first player a player 1
		playerNumber = 1;
		currentPlayer = "Player " + playerNumber + ", it is your turn to play";

		// Return the grid initialized with empty value
		grids = gameInitializer.generateGridWithValue(square);

		// Reinitialize player draw to 'X' for the first player 1
		draw = "X";

		// reset counter to 0
		counter = 0;

		// reset variable that notify if game is draw
		game_draw = false;

		// Setting the Model that will be used by the View to display data
		model.addAttribute("welcome_msg", "Welcome To Tic Tac Toe Game");
		model.addAttribute("currentPlayer", currentPlayer);
		model.addAttribute("grids", grids);
		return "index";
	}

	/**
	 * Method called when users start playing
	 * 
	 * @param model
	 * @param row
	 * @param col
	 * @return
	 */
	@GetMapping("/playing")
	public String startGame(Model model, @RequestParam(name = "row") int row, @RequestParam(name = "col") int col) {
		
		// If Game grid is not set (grid with 0 row and 0 col), redirect to index to reinitialize game
		if(grids.size()==0) {
			return "redirect:/";
		}

		// Set current player as previous player
		previous_player = ((draw == "X") ? 1 : 2);

		// Initialization of class that draws user played value
		PlayerDraw playerDraw = new PlayerDraw();

		// Check if position/cell is already played.
		// If position is played, dont update
		boolean isCellAlreadyPlayed = playerDraw.checkIfCellIsAlreadyPlayed(grids, row, col);

		if (!isCellAlreadyPlayed) {

			// 'row' represent the row index the user played
			// 'col' represent the col index the user played
			grids = playerDraw.setDrawAndReturnUpdatedGrid(grids, draw, row, col);

			// With the return grid, check if player win.
			// win is true is player win else false
			win = playerDraw.checkIfPlayerWin(grids, draw);

			if (!win) {
				playerNumber++;
			}

			draw = ((draw == "X") ? "O" : "X");
			counter++;
		}

		currentPlayer = "Player " + playerNumber + ", it is your turn to play";

		// Setting the Model that will be used by the View to display data
		model.addAttribute("welcome_msg", "Welcome To Tic Tac Toe Game");
		model.addAttribute("currentPlayer", currentPlayer);
		model.addAttribute("grids", grids);
		model.addAttribute("win", win);
		model.addAttribute("winner_msg", "Bravo ! Player " + previous_player + " win");

		// Check if position/cell is already played.
		// Update the player number
		if (!isCellAlreadyPlayed) {
			if (playerNumber == 2) {
				if (!win) {
					playerNumber = 0;
				}
			}
		}

		// Check if no player win and all the position/cell are played.
		// Set game as draw
		if (!win) {
			if (counter == (int) Math.pow(square, 2)) {
				game_draw = true;
			}
		}
		model.addAttribute("game_draw", game_draw);
		model.addAttribute("draw_msg", "Sorry! Game Draw. No winner!");
		model.addAttribute("counter", counter + " -- " + Math.pow(square, 2));

		return "index";
	}
}
