package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import model.CellState;
import model.UniverseGrid;

public class GameOfLife {
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the dimention :");
		
		int dimention = Integer.parseInt(br.readLine());
		
		UniverseGrid mUniverseGrid = new UniverseGrid(dimention);
		mUniverseGrid.getCellAt(2, 1).setCellState(CellState.LIVE);
		mUniverseGrid.getCellAt(2, 2).setCellState(CellState.LIVE);
		mUniverseGrid.getCellAt(2, 3).setCellState(CellState.LIVE);
		
	}
}