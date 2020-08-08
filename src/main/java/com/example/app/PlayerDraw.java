package com.example.app;

import java.util.List;
import java.util.Map;

import com.example.app.model.Cell;

public class PlayerDraw {

	/**
	 * **** TEST PURPOSE***** This method is to set a value ('X' or 'O') in a cell
	 * and return the value set. This is used for test purpose. The row and column
	 * are set manually
	 * 
	 * @param grid
	 * @param playerDraw
	 * @return
	 */
	public String setADraw(Map<String, List<Cell>> grid, String playerDraw) {

		int square = grid.size();
		int row = 0;
		int col = 0;

		if (row < 0 || row >= square) {
			row = 0;
		}

		if (col < 0 || col >= square) {
			col = 0;
		}

		List<Cell> listcell = grid.get(String.valueOf(row));
		Cell cell = listcell.get(col);

		// Set what the user played ('X' or 'O') in the return grid
		if (playerDraw == "X" || playerDraw == "O") {
			cell.setValue(playerDraw);
		} else {
			playerDraw = "";
		}

		grid.get(String.valueOf(row)).set(col, cell);

		// Return the value played by the user
		String value_draw = grid.get(String.valueOf(row)).get(col).getValue();

		return value_draw;
	}

	/**
	 * **** TEST PURPOSE***** This method is to set a value ('X' or 'O') in a cell
	 * and return the value set. This is used for test purpose. The row and column
	 * are parameters passed to the method
	 * 
	 * @param grid
	 * @param playerDraw
	 * @param draw_row
	 * @param draw_col
	 * @return
	 */
	public String setADraw(Map<String, List<Cell>> grid, String playerDraw, int draw_row, int draw_col) {

		int square = grid.size();
		int row = draw_row;
		int col = draw_col;

		if (row < 0 || row >= square) {
			row = 0;
		}

		if (col < 0 || col >= square) {
			col = 0;
		}

		List<Cell> listcell = grid.get(String.valueOf(row));
		Cell cell = listcell.get(col);

		// Set what the user played ('X' or 'O') in the return grid
		if (playerDraw == "X" || playerDraw == "O") {
			cell.setValue(playerDraw);
		} else {
			playerDraw = "";
		}

		grid.get(String.valueOf(row)).set(col, cell);

		// Return the value played by the user
		String value_draw = grid.get(String.valueOf(row)).get(col).getValue();

		return value_draw;
	}

	/**
	 * This method is to set a value ('X' or 'O') in a cell and return the value
	 * set. This is used for test purpose. The row and column are set when player
	 * click on the cell/position he want to play
	 * 
	 * @param grid
	 * @param playerDraw
	 * @param draw_row
	 * @param draw_col
	 * @return the grid with all cell/position played
	 */
	public Map<String, List<Cell>> setDrawAndReturnUpdatedGrid(Map<String, List<Cell>> grid, String playerDraw,
			int draw_row, int draw_col) {

		int square = grid.size();
		int row = draw_row;
		int col = draw_col;

		if (row < 0 || row >= square) {
			row = 0;
		}

		if (col < 0 || col >= square) {
			col = 0;
		}

		List<Cell> listcell = grid.get(String.valueOf(row));
		Cell cell = listcell.get(col);

		// Set what the user played ('X' or 'O') in the return grid
		if (playerDraw == "X" || playerDraw == "O") {
			cell.setValue(playerDraw);
		} else {
			// If none of this values, set empty string
			playerDraw = "";
		}

		grid.get(String.valueOf(row)).set(col, cell);
		return grid;
	}

	/**
	 * This method is to check if after a user played, he or she wins
	 * 
	 * @param grid
	 * @param playerDraw
	 * @param draw_row
	 * @param draw_col
	 * @return
	 */
	public boolean checkIfPlayerWin(Map<String, List<Cell>> grid, String draw) {

		boolean win = false;
		int square = grid.size();

		/*
		 * CHECK HORIZONTALLY IF PLAYER WIN
		 */
		int counter_check_horizontally = 0;

		// Loop for rows
		for (int u = 0; u < square; u++) {

			List<Cell> listcell = grid.get(String.valueOf(u));

			// Lopp for col
			for (int i = 0; i < square; i++) {
				if (draw == listcell.get(i).getValue()) {

					// increment counter if value played by the user, is the same found in the
					// subsequent cell/position
					counter_check_horizontally++;
				}
			}

			// If the number of col in a row is the same as counter, the player win, set win
			// to true and break the loop
			if (square == counter_check_horizontally) {
				win = true;
				break;
			} else {
				// reset counter to 0 for the next loop to do the same process
				counter_check_horizontally = 0;
			}
		}

		/*
		 * CHECK VERTICALLY IF PLAYER WIN
		 */
		if (!win) {
			int counter_check_vertically = 0;
			// Loop for rows
			for (int u = 0; u < square; u++) {

				// Lopp for col
				for (int i = 0; i < square; i++) {
					if (draw == grid.get(String.valueOf(i)).get(u).getValue()) {

						// increment counter if value played by the user, is the same found in the
						// subsequent cell/position
						counter_check_vertically++;
					}
				}

				// If the number of col in a row is the same as counter, the player win, set win
				// to true and break the loop
				if (square == counter_check_vertically) {
					win = true;
					break;
				} else {
					// reset counter to 0 for the next loop to do the same process
					counter_check_vertically = 0;
				}
			}
		}

		/*
		 * CHECK DIAGONALLY TOP - BOTTOM IF PLAYER WIN
		 */
		if (!win) {
			int counter_check_diagonally_top_bottom = 0;

			// Lopp for row
			for (int i = 0; i < square; i++) {
				if (draw == grid.get(String.valueOf(i)).get(i).getValue()) {

					// increment counter if value played by the user, is the same found in the
					// subsequent cell/position
					counter_check_diagonally_top_bottom++;
				}
			}

			// If the number of col in a row is the same as counter, the player win, set win
			// to true and break the loop
			if (square == counter_check_diagonally_top_bottom) {
				win = true;
			} else {
				// reset counter to 0 for the next loop to do the same process
				counter_check_diagonally_top_bottom = 0;
			}
		}

		/*
		 * CHECK DIAGONALLY BOTTOM - TOP IF PLAYER WIN
		 */
		if (!win) {
			int counter_check_diagonally_bottom_top = 0;

			// Lopp for row
			for (int i = 0; i < square; i++) {
				if (draw == grid.get(String.valueOf((square - 1) - i)).get(i).getValue()) {

					// increment counter if value played by the user, is the same found in the
					// subsequent cell/position
					counter_check_diagonally_bottom_top++;
				}
			}

			// If the number of col in a row is the same as counter, the player win, set win
			// to true and break the loop
			if (square == counter_check_diagonally_bottom_top) {
				win = true;
			} else {
				// reset counter to 0 for the next loop to do the same process
				counter_check_diagonally_bottom_top = 0;
			}
		}
		return win;
	}

	/**
	 * This method is to verify if a cell/position is already played. With the row
	 * and colunm index passed, we get the cell and verify if it is already set
	 * 
	 * @param grid
	 * @param row
	 * @param col
	 * @return
	 */
	public boolean checkIfCellIsAlreadyPlayed(Map<String, List<Cell>> grid, int row, int col) {

		List<Cell> listcell = grid.get(String.valueOf(row));
		Cell cell = listcell.get(col);

		// If Cell is already used or played, Don't update
		if (cell.getValue() == null || cell.getValue() == "" || cell.getValue().isEmpty()) {
			return false;
		}
		return true;
	}
}
