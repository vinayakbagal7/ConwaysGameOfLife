import static org.junit.Assert.*;
import model.CellState;
import model.UniverseGrid;

import org.junit.Test;


public class CheckLiveNeighbourCount {

	@Test
	public void test() {
		UniverseGrid grid = new UniverseGrid(3);
		
		grid.getCellAt(0, 0).setCellState(CellState.DEAD);
		grid.getCellAt(0, 1).setCellState(CellState.DEAD);
		grid.getCellAt(0, 2).setCellState(CellState.DEAD);
		grid.getCellAt(1, 0).setCellState(CellState.LIVE);
		grid.getCellAt(1, 1).setCellState(CellState.LIVE);
		grid.getCellAt(1, 2).setCellState(CellState.LIVE);
		grid.getCellAt(2, 0).setCellState(CellState.DEAD);
		grid.getCellAt(2, 1).setCellState(CellState.DEAD);
		grid.getCellAt(2, 2).setCellState(CellState.DEAD);
		
		assertTrue( grid.getLiveNeighboursCount(1, 1) == 2);
		assertTrue( grid.getLiveNeighboursCount(1, 0) == 1);
		assertTrue( grid.getLiveNeighboursCount(1, 2) == 1);
	}
}
