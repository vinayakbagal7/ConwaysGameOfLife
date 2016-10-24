package model;

public class UniverseGrid {
	private Cell[][] grid;
	private int dimentions;

	public UniverseGrid(int dimentions) {
		setDimentions(dimentions);
		setGrid(new Cell[dimentions][dimentions]);
		for (int i = 0; i < dimentions; i++) {
			for (int j = 0; j < dimentions; j++) {
				setCellAt(new Cell(), i, j);
			}
		}
	}

	public Cell[][] getGrid() {
		return grid;
	}

	public void setGrid(Cell[][] grid) {
		this.grid = grid;
	}
	
	public Cell getCellAt(int x, int y){
		return grid[x][y];
	}
	
	public void setCellAt(Cell cell, int x, int y){
		grid[x][y] = cell;
	}
	
	public int getDimentions() {
		return dimentions;
	}

	public void setDimentions(int dimentions) {
		this.dimentions = dimentions;
	}

	public int getLiveNeighboursCount(int x, int y) {
		int count = 0;
		
		if(x+1 < grid.length)
			count = getCellAt(x+1, y).getCellState().equals(CellState.LIVE) ? count + 1 : count;
		
		if(y+1 < grid.length)
			count = getCellAt(x, y+1).getCellState().equals(CellState.LIVE) ? count + 1 : count;
		
		if(x+1 < grid.length && y+1 < grid.length)
			count = getCellAt(x+1, y+1).getCellState().equals(CellState.LIVE) ? count + 1 : count;
		
		if(x-1 >= 0)
			count = getCellAt(x-1, y).getCellState().equals(CellState.LIVE) ? count + 1 : count;
		
		if(y-1 >= 0)
			count = getCellAt(x, y-1).getCellState().equals(CellState.LIVE) ? count + 1 : count;
		
		if(x-1 >= 0 && y-1 >= 0)
			count = getCellAt(x-1, y-1).getCellState().equals(CellState.LIVE) ? count + 1 : count;
		
		if(x+1 < grid.length && y-1 >= 0)
			count = getCellAt(x+1, y-1).getCellState().equals(CellState.LIVE) ? count + 1 : count;
		
		if(x-1 >= 0 && y+1 < grid.length)
			count = getCellAt(x-1, y+1).getCellState().equals(CellState.LIVE) ? count + 1 : count;
		
		return count;
	}
	
	public Cell[][] applyAllRules(){
		Cell tempGrid[][] = new Cell[getDimentions()][getDimentions()];
		
		for (int i = 0; i < getDimentions(); i++) {
			for (int j = 0; j < getDimentions(); j++) {
				Cell tempCell = new Cell();
				tempCell.setCellState(getCellAt(i, j).getCellState());

				int liveCount = getLiveNeighboursCount(i, j);
				
				if(liveCount < 2 && getCellAt(i, j).getCellState().equals(CellState.LIVE)){
					tempCell.setCellState(CellState.DEAD);
				}
				
				if(getCellAt(i, j).getCellState().equals(CellState.LIVE) && (liveCount == 2 || liveCount == 3)){
					tempCell.setCellState(CellState.LIVE);
				}
				
				if(getCellAt(i, j).getCellState().equals(CellState.LIVE) && liveCount > 3){
					tempCell.setCellState(CellState.DEAD);
				}
				
				if(getCellAt(i, j).getCellState().equals(CellState.DEAD) && liveCount == 3){
					tempCell.setCellState(CellState.LIVE);
				}

				tempGrid[i][j] = tempCell;
			}
		}
		return tempGrid;
	}
}