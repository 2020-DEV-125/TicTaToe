package com.example.app.model;

public class Cell {

	private int rowNum;
	private int colNum;
	private String value;

	public Cell() {
	}

	public Cell(int rowNo, int colNo, String value) {
		this.rowNum = rowNo;
		this.colNum = colNo;
		this.value = value;
	}

	public int getRowNum() {
		return rowNum;
	}

	public int getColNum() {
		return colNum;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
