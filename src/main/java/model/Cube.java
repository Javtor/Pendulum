package model;

import java.util.concurrent.ThreadLocalRandom;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Cube {

	public static final int F = 0;
	public static final int R = 1;
	public static final int U = 2;
	public static final int L = 3;
	public static final int B = 4;
	public static final int D = 5;

	public static final int SHUFFLE_MOVES = 20;

	private Piece[][][] cube;

	public Cube() {
		cube = new Piece[3][3][3];
		for (int i = 0; i < cube.length; i++) {
			for (int j = 0; j < cube.length; j++) {
				for (int k = 0; k < cube.length; k++) {
					cube[i][j][k] = new Piece();
				}
			}
		}
	}

	public int[][] getFace(int face) {
		int[][] result = new int[3][3];
		switch (face) {
		case F:
			for (int i = 0; i < result.length; i++) {
				for (int j = 0; j < result.length; j++) {
					result[i][j] = cube[i][j][0].getF();
				}
			}
			break;
		case R:
			for (int i = 0; i < result.length; i++) {
				for (int j = 0; j < result.length; j++) {
					result[i][j] = cube[i][2][j].getR();
				}
			}
			break;
		case U:
			for (int i = 0; i < result.length; i++) {
				for (int j = 0; j < result.length; j++) {
					result[i][j] = cube[0][j][2 - i].getU();
				}
			}
			break;
		case L:
			for (int i = 0; i < result.length; i++) {
				for (int j = 0; j < result.length; j++) {
					result[i][j] = cube[i][0][2 - j].getL();
				}
			}
			break;
		case B:
			for (int i = 0; i < result.length; i++) {
				for (int j = 0; j < result.length; j++) {
					result[i][j] = cube[i][2 - j][2].getB();
				}
			}
			break;
		case D:
			for (int i = 0; i < result.length; i++) {
				for (int j = 0; j < result.length; j++) {
					result[i][j] = cube[2][j][i].getD();
				}
			}
			break;
		}
		return result;
	}

	public String shuffle() {
		StringBuilder shuffle = new StringBuilder();
		String[] moves = new String[] { "F", "R", "U", "L", "B", "D" };
		String[] type = new String[] { "", "2", "'" };
		for (int i = 0; i < SHUFFLE_MOVES; i++) {
			int rand = ThreadLocalRandom.current().nextInt(0, 6);
			shuffle.append(moves[rand]);
			int times = ThreadLocalRandom.current().nextInt(0, 3);
			shuffle.append(type[times] + " ");
			for (int j = 0; j < times + 1; j++) {
				switch (rand) {
				case F:
					f();
					break;

				case R:
					r();
					break;

				case U:
					u();
					break;

				case L:
					l();
					break;

				case B:
					b();
					break;

				case D:
					d();
					break;
				}
			}
		}
		return shuffle.toString().trim();
	}

	// Moves
	public void b() {
		rotateY(2);
	}

	public void bPrime() {
		for (int i = 0; i < 3; i++) {
			rotateY(2);
		}
	}

	public void d() {
		rotateZ(2);
	}

	public void dPrime() {
		for (int i = 0; i < 3; i++) {
			rotateZ(2);
		}
	}

	public void f() {
		rotateY(0);
	}

	public void fPrime() {
		for (int i = 0; i < 3; i++) {
			rotateY(0);
		}
	}

	public void l() {
		rotateX(0);
	}

	public void lPrime() {
		for (int i = 0; i < 3; i++) {
			rotateX(0);
		}
	}

	public void r() {
		rotateX(2);
	}

	public void rPrime() {
		for (int i = 0; i < 3; i++) {
			rotateX(2);
		}
	}

	public void u() {
		rotateZ(0);
	}

	public void uPrime() {
		for (int i = 0; i < 3; i++) {
			rotateZ(0);
		}
	}

	public void m() {
		rotateX(1);
	}

	public void mPrime() {
		for (int i = 0; i < 3; i++) {
			m();
		}
	}

	public void e() {
		rotateZ(1);
	}

	public void ePrime() {
		for (int i = 0; i < 3; i++) {
			e();
		}
	}

	public void s() {
		for (int i = 0; i < 3; i++) {
			sPrime();
		}
	}

	public void sPrime() {
		rotateY(1);
	}

	public void x() {
		r();
		mPrime();
		lPrime();
	}

	public void xPrime() {
		for (int i = 0; i < 3; i++) {
			x();
		}
	}

	public void y() {
		u();
		ePrime();
		dPrime();
	}

	public void yPrime() {
		for (int i = 0; i < 3; i++) {
			y();
		}
	}

	public void z() {
		f();
		s();
		bPrime();
	}

	public void zPrime() {
		for (int i = 0; i < 3; i++) {
			z();
		}
	}

	// privateMoves

	/*
	 * 0: L 2: R
	 */
	private void rotateX(int face) {
		Piece[][] temp = new Piece[3][3];
		for (int i = 0; i < cube.length; i++) {
			for (int j = 0; j < cube.length; j++) {
				if (face == 2) {
					cube[i][face][j].rotateX(Piece.CLOCKWISE);
					temp[j][2 - i] = cube[i][face][j];
				} else {
					cube[i][face][2 - j].rotateX(Piece.COUNTERCLOCKWISE);
					temp[j][2 - i] = cube[i][face][2 - j];
				}
			}
		}
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp.length; j++) {
				if (face == 2) {
					cube[i][face][j] = temp[i][j];
				} else {
					cube[i][face][2 - j] = temp[i][j];
				}
			}
		}
	}

	/*
	 * 0: F 2: B
	 */
	private void rotateY(int face) {
		Piece[][] temp = new Piece[3][3];
		for (int i = 0; i < cube.length; i++) {
			for (int j = 0; j < cube.length; j++) {
				if (face == 0) {
					cube[i][j][face].rotateY(Piece.CLOCKWISE);
					temp[j][2 - i] = cube[i][j][face];
				} else {
					cube[i][2 - j][face].rotateY(Piece.COUNTERCLOCKWISE);
					temp[j][2 - i] = cube[i][2 - j][face];
				}
			}
		}
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp.length; j++) {
				if (face == 0) {
					cube[i][j][face] = temp[i][j];
				} else {
					cube[i][2 - j][face] = temp[i][j];
				}
			}
		}
	}

	/*
	 * 0: U 2: D
	 */
	private void rotateZ(int face) {
		Piece[][] temp = new Piece[3][3];
		for (int i = 0; i < cube.length; i++) {
			for (int j = 0; j < cube.length; j++) {
				if (face == 0) {
					cube[face][j][2 - i].rotateZ(Piece.CLOCKWISE);
					temp[j][2 - i] = cube[0][j][2 - i];
				} else {
					cube[face][j][i].rotateZ(Piece.COUNTERCLOCKWISE);
					temp[j][2 - i] = cube[face][j][i];
				}
			}
		}
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp.length; j++) {
				if (face == 0) {
					cube[face][j][2 - i] = temp[i][j];
				} else {
					cube[face][j][i] = temp[i][j];
				}
			}
		}
	}

	public void solve() {
		// TODO Auto-generated method stub

	}
}
