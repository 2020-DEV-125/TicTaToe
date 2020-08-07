package com.example.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.app.model.Cell;


public class GameInitializer {
	

	public Map<String, List<String>> generateGrid(int square) {
		Map<String,List<String>> grid=new HashMap<String, List<String>>();
		
		
		int cols=square;
		int rows=square;
		
		for(int u=0;u<rows; u++) {
			
			List<String> cellsA=new ArrayList<String>(cols);
			for(int i=0; i<cols;i++) {
				cellsA.add("");
				//cellsA.add(""+u+" - "+i);
			}
			grid.put(String.valueOf(u), cellsA);
			
		}
		return grid;
	}


	public Map<String, List<Cell>> generateGridWithValue(int square) {
		Map<String,List<Cell>> grid=new HashMap<String, List<Cell>>();
		
		
		int cols=square;
		int rows=square;
		
		for(int u=0;u<rows; u++) {
			
			List<Cell> cellsA=new ArrayList<Cell>(cols);
			for(int i=0; i<cols;i++) {
				
				cellsA.add(new Cell(u,i,""));
				//cellsA.add(""+u+" - "+i);
			}
			grid.put(String.valueOf(u), cellsA);
			
		}
		return grid;
	}

}
