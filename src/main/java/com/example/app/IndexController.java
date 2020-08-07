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
	GameInitializer gameInitializer=new GameInitializer();
	
	private String currentPlayer="";
	
	// Variable that store player number
	private int playerNumber=0;
	
	String draw="X"; 
	
	Map<String, List<Cell>> grids =new HashMap<String, List<Cell>>();
	
	// Variable that store if player win
	boolean win=false;
	
	@GetMapping
    public String getIndex( Model model) {
		
		playerNumber=1;
		
		//playerNumber++;
		
		currentPlayer="Player "+playerNumber+", it is your turn to play";
		
		// Start with the assumption that grid has 3 rows and 3 cols
		int square=3;

		/**
		 * Return the grid initialized with empty value
		 */
		grids = gameInitializer.generateGridWithValue(square);
		
		/**
		 *  Initialization of class that draws user played value
		 */
		//PlayerDraw playerDraw=new PlayerDraw();
		
		// Assumes player draws 'X' in a cell . Possible values 'X' or 'O'
		
		String draw="X";
		
		
		//String value_draw=playerDraw.setADraw(grid,draw);
		
		//boolean win = playerDraw.checkIfPlayerWin( grids, draw);
		
		
		

        model.addAttribute("welcome_msg", "Welcome To Tic Tac Toe Game");
        model.addAttribute("currentPlayer", currentPlayer);
        model.addAttribute("grids", grids);
       
        if(playerNumber==2) {
        	playerNumber=0;
        }
        

        return "index";
    }
	
	
	@GetMapping("/playing")
	public String startGame(Model model, 
			@RequestParam(name = "row") int row,
			@RequestParam(name = "col") int col) {
		
		if(draw==null) {
			
			return "redirect:/";
		}
		
		
		
		/**
		 *  Initialization of class that draws user played value
		 */
		PlayerDraw playerDraw=new PlayerDraw();
		
		// Assumes player draws 'X' in a cell . Possible values 'X' or 'O'
		//String draw="X"; 
		int winner=playerNumber;
		
		
		// Check if position is already played.
		// If position is played, dont update
		boolean isCellAlreadyPlayed=playerDraw.checkIfCellIsAlreadyPlayed(grids, row,col);
		
		if(!isCellAlreadyPlayed) {
			
			// 'row' represent the row index the user played
			// 'col' represent the col index the user played
			grids=playerDraw.setDrawAndReturnUpdatedGrid(grids, draw, row,col);
			
			
			win = playerDraw.checkIfPlayerWin( grids, draw);
			
			
			playerNumber++;
			
			draw=((draw=="X")?"O":"X");
			
		}
		
	
		
		
		currentPlayer="Player "+playerNumber+", it is your turn to play";
		

        model.addAttribute("welcome_msg", "Welcome To Tic Tac Toe Game");
        model.addAttribute("currentPlayer", currentPlayer);
        model.addAttribute("grids", grids);
        model.addAttribute("win", win);
        
        model.addAttribute("winner_msg", "Bravo ! Player "+winner+" win");
       
        if(!isCellAlreadyPlayed) {
            if(playerNumber==2) {
            	playerNumber=0;
            }    	
        }

        
        

        return "index";
    }
	

}
