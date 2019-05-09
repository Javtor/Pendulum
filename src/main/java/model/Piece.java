package model;

public class Piece {

	public static final int CLOCKWISE = 0;
	public static final int COUNTERCLOCKWISE = 1;

	public static final int WHITE = 0;
	public static final int GREEN = 1;
	public static final int RED = 2;
	public static final int BLUE = 3;
	public static final int ORANGE = 4;
	public static final int YELLOW = 5;

	private int[] colors;

	Piece() {
		colors = new int[6];
		for (int i = 0; i < colors.length; i++) {
			colors[i] = i;
		}
	}

	public int getU() {
		return colors[0];
	}

	public int getF() {
		return colors[1];
	}

	public int getR() {
		return colors[2];
	}

	public int getB() {
		return colors[3];
	}

	public int getL() {
		return colors[4];
	}

	public int getD() {
		return colors[5];
	}

	private void setU(int color) {
		this.colors[0] = color;
	}

	private void setF(int color) {
		this.colors[1] = color;
	}

	private void setR(int color) {
		this.colors[2] = color;
	}

	private void setB(int color) {
		this.colors[3] = color;
	}

	private void setL(int color) {
		this.colors[4] = color;
	}

	private void setD(int color) {
		this.colors[5] = color;
	}

	public void rotateX(int direction) {
		switch (direction) {
		case CLOCKWISE:
			int temp = getU();
			setU(getF());
			setF(getD());
			setD(getB());
			setB(temp);
			
			break;
		case COUNTERCLOCKWISE:
//			temp = getU();
//			setU(getB());
//			setB(getD());
//			setD(getF());
//			setF(temp);	
			for (int i = 0; i < 3; i++) {
				rotateX(CLOCKWISE);
			}
			break;
			
		}
	}
	
	public void rotateY(int direction) {
		switch (direction) {
		case CLOCKWISE:
			int temp = getU();
			setU(getL());
			setL(getD());
			setD(getR());
			setR(temp);
			
			break;
		case COUNTERCLOCKWISE:
			for (int i = 0; i < 3; i++) {
				rotateY(CLOCKWISE);
			}	
			break;
		}
	}
	
	public void rotateZ(int direction) {
		switch (direction) {
		case CLOCKWISE:
			int temp = getF();
			setF(getR());
			setR(getB());
			setB(getL());
			setL(temp);
			break;
		case COUNTERCLOCKWISE:
			for (int i = 0; i < 3; i++) {
				rotateZ(CLOCKWISE);
			}
			break;
		}
	}

}
