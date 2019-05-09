package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.sun.javafx.logging.PulseLogger;

class PieceTest {
	
	private Piece piece;
	
	private void setupPiece() {
		this.piece = new Piece();
	}

	@Test
	void testCreation() {
		setupPiece();
		assertTrue(piece.getU() == Piece.WHITE);
		assertTrue(piece.getF() == Piece.GREEN);
		assertTrue(piece.getR() == Piece.RED);
		assertTrue(piece.getB() == Piece.BLUE);
		assertTrue(piece.getL() == Piece.ORANGE);
		assertTrue(piece.getD() == Piece.YELLOW);
	}
	
	@Test
	void testRotateX1() {
		setupPiece();
		piece.rotateX(Piece.CLOCKWISE);
		assertTrue(piece.getU() == Piece.GREEN);
		assertTrue(piece.getF() == Piece.YELLOW);
		assertTrue(piece.getR() == Piece.RED);
		assertTrue(piece.getB() == Piece.WHITE);
		assertTrue(piece.getL() == Piece.ORANGE);
		assertTrue(piece.getD() == Piece.BLUE);
	}
	
	@Test
	void testRotateX2() {
		setupPiece();
		piece.rotateX(Piece.COUNTERCLOCKWISE);
		assertTrue(piece.getU() == Piece.BLUE);
		assertTrue(piece.getF() == Piece.WHITE);
		assertTrue(piece.getR() == Piece.RED);
		assertTrue(piece.getB() == Piece.YELLOW);
		assertTrue(piece.getL() == Piece.ORANGE);
		assertTrue(piece.getD() == Piece.GREEN);
	}
	
	@Test
	void testRotateX3() {
		setupPiece();
		piece.rotateX(Piece.CLOCKWISE);
		piece.rotateX(Piece.COUNTERCLOCKWISE);
		assertTrue(piece.getU() == Piece.WHITE);
		assertTrue(piece.getF() == Piece.GREEN);
		assertTrue(piece.getR() == Piece.RED);
		assertTrue(piece.getB() == Piece.BLUE);
		assertTrue(piece.getL() == Piece.ORANGE);
		assertTrue(piece.getD() == Piece.YELLOW);
	}
	
	@Test
	void testRotateY1() {
		setupPiece();
		piece.rotateY(Piece.CLOCKWISE);
		assertTrue(piece.getU() == Piece.ORANGE);
		assertTrue(piece.getF() == Piece.GREEN);
		assertTrue(piece.getR() == Piece.WHITE);
		assertTrue(piece.getB() == Piece.BLUE);
		assertTrue(piece.getL() == Piece.YELLOW);
		assertTrue(piece.getD() == Piece.RED);
	}
	
	@Test
	void testRotateY2() {
		setupPiece();
		piece.rotateY(Piece.COUNTERCLOCKWISE);
		assertTrue(piece.getU() == Piece.RED);
		assertTrue(piece.getF() == Piece.GREEN);
		assertTrue(piece.getR() == Piece.YELLOW);
		assertTrue(piece.getB() == Piece.BLUE);
		assertTrue(piece.getL() == Piece.WHITE);
		assertTrue(piece.getD() == Piece.ORANGE);
	}
	
	@Test
	void testRotateY3() {
		setupPiece();
		piece.rotateY(Piece.CLOCKWISE);
		piece.rotateY(Piece.COUNTERCLOCKWISE);
		assertTrue(piece.getU() == Piece.WHITE);
		assertTrue(piece.getF() == Piece.GREEN);
		assertTrue(piece.getR() == Piece.RED);
		assertTrue(piece.getB() == Piece.BLUE);
		assertTrue(piece.getL() == Piece.ORANGE);
		assertTrue(piece.getD() == Piece.YELLOW);
	}
	
	@Test
	void testRotateZ1() {
		setupPiece();
		piece.rotateZ(Piece.CLOCKWISE);
		assertTrue(piece.getU() == Piece.WHITE);
		assertTrue(piece.getF() == Piece.RED);
		assertTrue(piece.getR() == Piece.BLUE);
		assertTrue(piece.getB() == Piece.ORANGE);
		assertTrue(piece.getL() == Piece.GREEN);
		assertTrue(piece.getD() == Piece.YELLOW);
	}
	
	@Test
	void testRotateZ2() {
		setupPiece();
		piece.rotateZ(Piece.COUNTERCLOCKWISE);
		assertTrue(piece.getU() == Piece.WHITE);
		assertTrue(piece.getF() == Piece.ORANGE);
		assertTrue(piece.getR() == Piece.GREEN);
		assertTrue(piece.getB() == Piece.RED);
		assertTrue(piece.getL() == Piece.BLUE);
		assertTrue(piece.getD() == Piece.YELLOW);
	}
	
	@Test
	void testRotateZ3() {
		setupPiece();
		piece.rotateZ(Piece.CLOCKWISE);
		piece.rotateZ(Piece.COUNTERCLOCKWISE);
		assertTrue(piece.getU() == Piece.WHITE);
		assertTrue(piece.getF() == Piece.GREEN);
		assertTrue(piece.getR() == Piece.RED);
		assertTrue(piece.getB() == Piece.BLUE);
		assertTrue(piece.getL() == Piece.ORANGE);
		assertTrue(piece.getD() == Piece.YELLOW);
	}

}
