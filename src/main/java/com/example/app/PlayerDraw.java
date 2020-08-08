package com.example.app;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.app.model.Cell;

public class PlayerDraw {

	public String setADraw(Map<String, List<Cell>> grid,String playerDraw) {
		
		
		int square=grid.size();
		
		int row=0;
		int col=0;
		
		if(row<0 || row>=square) {
			row=0;
		}
		
		if(col<0 || col>=square ) {
			col=0;
		}

		
		
		List<Cell> listcell=grid.get(String.valueOf(row));
		Cell cell=listcell.get(col);
		
		// SET PLAYER DRAW
		if(playerDraw=="X" || playerDraw=="O" ) {
			cell.setValue(playerDraw);
		}else {
			playerDraw="";
		}
	
		grid.get(String.valueOf(row)).set(col, cell);
		
		
		// Return the value played by the user
		String value_draw=grid.get(String.valueOf(row)).get(col).getValue();
		
		return value_draw;
	}

	/**
	 * This method is to set a value ('X' or 'O') in a cell and return the value set.
	 * @param grid
	 * @param playerDraw
	 * @param draw_row
	 * @param draw_col
	 * @return 
	 */
	public String setADraw(Map<String, List<Cell>> grid,String playerDraw, int draw_row, int draw_col) {
		
		int square=grid.size();
		int row=draw_row;
		int col=draw_col;
		
		if(row<0 || row>=square) {
			row=0;
		}
		
		if(col<0 || col>=square ) {
			col=0;
		}

		List<Cell> listcell=grid.get(String.valueOf(row));
		Cell cell=listcell.get(col);
		
		// Set player draw
		if(playerDraw=="X" || playerDraw=="O" ) {
			cell.setValue(playerDraw);
		}else {
			playerDraw="";
		}
	
		grid.get(String.valueOf(row)).set(col, cell);
		
		
		// Return the value played by the user
		String value_draw=grid.get(String.valueOf(row)).get(col).getValue();
		
		return value_draw;
	}

	
	public Map<String, List<Cell>> setDrawAndReturnUpdatedGrid(Map<String, List<Cell>> grid,String playerDraw, int draw_row, int draw_col) {
		
		
		int square=grid.size();
		
		int row=draw_row;
		int col=draw_col;
		
		if(row<0 || row>=square) {
			row=0;
		}
		
		if(col<0 || col>=square ) {
			col=0;
		}

		
		
		List<Cell> listcell=grid.get(String.valueOf(row));
		Cell cell=listcell.get(col);
		
		// SET PLAYER DRAW
		if(playerDraw=="X" || playerDraw=="O" ) {
			cell.setValue(playerDraw);
		}else {
			playerDraw="";
		}
				
		grid.get(String.valueOf(row)).set(col, cell);
		
		
		
		
		// Return the value played by the user
		//String value_draw=grid.get(String.valueOf(row)).get(col).getValue();
		
		return grid;
	}

	public boolean checkIfPlayerWin(Map<String, List<Cell>> grid, String draw) {
		boolean win=false;
		
		int square=grid.size();
		
		/*
		 * CHECK HORIZONTALLY IF PLAYER WIN
		 */
		
		int counter_check_horizontally=0;
		
		for(int u=0; u<square;u++) { // Loop for rows
			
			List<Cell> listcell =grid.get(String.valueOf(u));
					
					
			for(int i=0; i<square;i++) { // Lopp for col
				
				if(draw==listcell.get(i).getValue()) {
					
					
					counter_check_horizontally++;
					
				}
			}
			
			if(square==counter_check_horizontally) {
				win=true;
				break;
			}else {
				counter_check_horizontally=0;
			}
		}
		
		
		
		/*
		 * CHECK VERTICALLY IF PLAYER WIN
		 */
		if(!win) {
			int counter_check_vertically=0;
			for(int u=0; u<square;u++) { // Loop for rows
					
				for(int i=0; i<square;i++) {// Lopp for col
					
					if(draw==grid.get(String.valueOf(i)).get(u).getValue()) {
						counter_check_vertically++;
					}
				}
				
				if(square==counter_check_vertically) {
					win=true;
					break;
				}else {
					counter_check_vertically=0;
				}
				
					
			}	
		}
		
		/*
		 * CHECK DIAGONALLY TOP - BOTTOM IF PLAYER WIN
		 */
		if(!win) {
			int counter_check_diagonally_top_bottom=0;
		
			for(int i=0; i<square;i++) {
				if(draw==grid.get(String.valueOf(i)).get(i).getValue()) {
					counter_check_diagonally_top_bottom++;
				}
			}
			
			if(square==counter_check_diagonally_top_bottom) {
				win=true;
			}else {
				counter_check_diagonally_top_bottom=0;
			}
		}
		
		/*
		 * CHECK DIAGONALLY BOTTOM - TOP  IF PLAYER WIN
		 */
		if(!win) {
			int counter_check_diagonally_bottom_top=0;
		
			for(int i=0; i<square;i++) {
				if(draw==grid.get(String.valueOf((square-1)-i)).get(i).getValue()) {
					counter_check_diagonally_bottom_top++;
				}
			}
			
			if(square==counter_check_diagonally_bottom_top) {
				win=true;
			}else {
				counter_check_diagonally_bottom_top=0;
			}
		}
		return win;
	}

	public boolean checkIfCellIsAlreadyPlayed(Map<String, List<Cell>> grid,int row, int col) {
		
		List<Cell> listcell=grid.get(String.valueOf(row));
		Cell cell=listcell.get(col);
		
		// If Cell is already used or played, Don't update
		if(cell.getValue()==null || cell.getValue()=="" || cell.getValue().isEmpty()) {
			return false;
		}
		
		return true;
	}

}
