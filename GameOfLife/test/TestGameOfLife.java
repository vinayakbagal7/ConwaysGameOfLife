import static org.junit.Assert.*;
import model.CellState;
import model.UniverseGrid;

import org.junit.Test;


public class TestGameOfLife {

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
		
		grid.setGrid(grid.applyAllRules());
		
		assertTrue(grid.getCellAt(0, 0).getCellState().equals(CellState.DEAD));
		assertTrue(grid.getCellAt(0, 1).getCellState().equals(CellState.LIVE));
		assertTrue(grid.getCellAt(0, 2).getCellState().equals(CellState.DEAD));
		assertTrue(grid.getCellAt(1, 0).getCellState().equals(CellState.DEAD));
		assertTrue(grid.getCellAt(1, 1).getCellState().equals(CellState.LIVE));
		assertTrue(grid.getCellAt(1, 2).getCellState().equals(CellState.DEAD));
		assertTrue(grid.getCellAt(2, 0).getCellState().equals(CellState.DEAD));
		assertTrue(grid.getCellAt(2, 1).getCellState().equals(CellState.LIVE));
		assertTrue(grid.getCellAt(2, 2).getCellState().equals(CellState.DEAD));
	}
}
