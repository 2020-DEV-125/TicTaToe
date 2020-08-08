package com.example.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.example.app.model.Cell;

public class GenerateGridWithValue {
	
	@Test
	public void testCreateGridWithPlayedValue() {
		
		GameInitializer gameInitializer=new GameInitializer();
		
		int square=3;

		Map<String, List<Cell>> grid = gameInitializer.generateGridWithValue(square);
		assertEquals(square, grid.size());	
	}
	
	
	@Test
	public void setAPlayerDraw() {
		
		GameInitializer gameInitializer=new GameInitializer(); // Declaration the grid initializer
		
		int square=3; // Indicate the number of the rows and cols we want for the grid
		
		/**
		 * Return the grid initialized 
		 */
		Map<String, List<Cell>> grid = gameInitializer.generateGridWithValue(square);

		PlayerDraw playerDraw=new PlayerDraw();
		
		String draw="X";
		String value_draw=playerDraw.setADraw(grid, draw, 0,1);
		assertEquals(draw, value_draw);
	}
	
	
	@Test
	public void testCheckIfPlayerWin() {
		
		GameInitializer gameInitializer=new GameInitializer(); // Declaration the grid initializer
		
		// Start with the assumption that grid has 3 rows and 3 cols
		int square=3; 
		
		/**
		 * Return the grid initialized with empty value
		 */
		Map<String, List<Cell>> grid = gameInitializer.generateGridWithValue(square);

		/**
		 *  Initialization of class that draws user played value
		 */
		PlayerDraw playerDraw=new PlayerDraw();
		
		// Assumes player draws 'X' in a cell . Possible values 'X' or 'O'
		String draw="X"; 
		
		// Varialble that indicate the user played on first row 0 and first cell 0
		int row_played=0; 
		int col_played=0;
		
		// Make sure value entered is between 0 and square lenght
		if(row_played<0 || row_played>=square || col_played<0 || col_played>=square) {
			
			fail();
			return;
		}
		
		grid=playerDraw.setDrawAndReturnUpdatedGrid(grid, draw, 0,1);
		grid=playerDraw.setDrawAndReturnUpdatedGrid(grid, draw, 1,1);
		grid=playerDraw.setDrawAndReturnUpdatedGrid(grid, draw, 2,1);

		boolean win = playerDraw.checkIfPlayerWin( grid, draw);
		assertTrue(win);
	}

	@Test
	public void testCheckIfCellIsAlreadyPlayed() {
		
		GameInitializer gameInitializer=new GameInitializer(); // Declaration the grid initializer
		
		// Start with the assumption that grid has 3 rows and 3 cols
		int square=3; 
		
		/**
		 * Return the grid initialized with empty value
		 */
		Map<String, List<Cell>> grid = gameInitializer.generateGridWithValue(square);

		
		/**
		 *  Initialization of class that draws user played value
		 */
		PlayerDraw playerDraw=new PlayerDraw();
		
		// Assumes player draws 'X' in a cell . Possible values 'X' or 'O'
		String draw="X"; 
		
		// If player draws a value in the cell at row 0 and col 1, uncomment below and the test will fail
		// If the player did't draw a value in the cell at row 0 and col 1, you keep the comment and the will pass
		
		//grid=playerDraw.setDrawAndReturnUpdatedGrid(grid, draw, 0,1);
		grid=playerDraw.setDrawAndReturnUpdatedGrid(grid, draw, 1,1);
		grid=playerDraw.setDrawAndReturnUpdatedGrid(grid, draw, 2,1);
		
		boolean result=playerDraw.checkIfCellIsAlreadyPlayed(grid, 0, 1);
		assertFalse(result);
	}
}
