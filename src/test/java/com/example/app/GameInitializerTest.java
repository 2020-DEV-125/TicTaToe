package com.example.app;



//import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;



public class GameInitializerTest {

	
	@Test
	public void testInitialGrid() {
		
		
		Map<String,List<String>> grid=new HashMap<String, List<String>>();
		
		List<String> cellsA=new ArrayList<String>(3);
		cellsA.add("");
		cellsA.add("");
		cellsA.add("");
		grid.put("A", cellsA);
		
		List<String> cellsB=new ArrayList<String>(3);
		cellsB.add("");
		cellsB.add("");
		cellsB.add("");
		grid.put("B", cellsB);
		
		List<String> cellsC=new ArrayList<String>(3);
		cellsC.add("");
		cellsC.add("");
		cellsC.add("");
		grid.put("C", cellsC);
		
		assertEquals(3, grid.size());
	
		
	}
	
	
	@Test
	public void testCreateGridColCellWithDynamicNumber() {
		

		Map<String,List<String>> grid=new HashMap<String, List<String>>();
		
		int cols=3;
		
		List<String> cellsA=new ArrayList<String>(cols);
		for(int i=0; i<cols;i++) {
			cellsA.add("");
		}
		grid.put("A", cellsA);
		
	
		assertEquals(3, cellsA.size());
	
		
	}
	
	@Test
	public void testCreateGridRowCellWithDynamicNumber() {
		

		Map<String,List<String>> grid=new HashMap<String, List<String>>();
		
		int cols=3;
		int row=3;
		
		List<String> cellsA=new ArrayList<String>(cols);
		for(int i=0; i<cols;i++) {
			cellsA.add("");
		}
		grid.put(String.valueOf(row), cellsA);
		
	
		assertEquals(1, grid.size());
	
		
	}
	
	@Test
	public void testCreateGridWithDynamicValues() {
		
		GameInitializer gameInitializer=new GameInitializer();
		
		int square=0;

		Map<String, List<String>> grid = gameInitializer.generateGrid(square);
		
		assertEquals(square, grid.size());
	
		
	}


	
}
