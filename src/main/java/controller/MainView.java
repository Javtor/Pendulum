package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import model.Cube;
import model.Piece;

public class MainView {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Canvas canvas;

	@FXML
	private JFXButton btnF;

	@FXML
	private JFXButton btnFPrime;

	@FXML
	private JFXButton btnR;

	@FXML
	private JFXButton btnRPrime;

	@FXML
	private JFXButton btnU;

	@FXML
	private JFXButton btnUPrime;

	@FXML
	private JFXButton btnL;

	@FXML
	private JFXButton btnLPrime;

	@FXML
	private JFXButton btnB;

	@FXML
	private JFXButton btnBPrime;

	@FXML
	private JFXButton btnD;

	@FXML
	private JFXButton btnDPrime;

	@FXML
	private JFXButton btnShuffle;

	@FXML
	private JFXButton btnReset;
	
	@FXML
	private JFXButton btnSolve;

	@FXML
	private JFXTextArea txtMoves;

	private Cube cube;

	@FXML
	private JFXButton btnM;

	@FXML
	private JFXButton btnMPrime;

	@FXML
	private JFXButton btnE;

	@FXML
	private JFXButton btnEPrime;

	@FXML
	private JFXButton btnS;

	@FXML
	private JFXButton btnSPrime;

	@FXML
	private JFXButton btnX;

	@FXML
	private JFXButton btnXPrime;

	@FXML
	private JFXButton btnY;

	@FXML
	private JFXButton btnYPrime;

	@FXML
	private JFXButton btnZ;

	@FXML
	private JFXButton btnZPrime;

	@FXML
	void b(ActionEvent event) {
		cube.b();
		drawCube();
	}

	@FXML
	void bPrime(ActionEvent event) {
		cube.bPrime();
		drawCube();
	}

	@FXML
	void d(ActionEvent event) {
		cube.d();
		drawCube();
	}

	@FXML
	void dPrime(ActionEvent event) {
		cube.dPrime();
		drawCube();
	}

	@FXML
	void f(ActionEvent event) {
		cube.f();
		drawCube();
	}

	@FXML
	void fPrime(ActionEvent event) {
		cube.fPrime();
		drawCube();
	}

	@FXML
	void l(ActionEvent event) {
		cube.l();
		drawCube();
	}

	@FXML
	void lPrime(ActionEvent event) {
		cube.lPrime();
		drawCube();
	}

	@FXML
	void r(ActionEvent event) {
		cube.r();
		drawCube();
	}

	@FXML
	void rPrime(ActionEvent event) {
		cube.rPrime();
		drawCube();
	}

	@FXML
	void reset(ActionEvent event) {
		txtMoves.setText("");
		this.cube = new Cube();
		drawCube();
	}

	@FXML
	void shuffle(ActionEvent event) {
		reset(null);
		String text = cube.shuffle();
		txtMoves.setText(text);
		drawCube();
	}

	@FXML
	void u(ActionEvent event) {
		cube.u();
		drawCube();
	}

	@FXML
	void uPrime(ActionEvent event) {
		cube.uPrime();
		drawCube();
	}
	
	@FXML
	void m(ActionEvent event) {
		cube.m();
		drawCube();
	}

	@FXML
	void mPrime(ActionEvent event) {
		cube.mPrime();
		drawCube();
	}
	
	@FXML
	void e(ActionEvent event) {
		cube.e();
		drawCube();
	}

	@FXML
	void ePrime(ActionEvent event) {
		cube.ePrime();
		drawCube();
	}

	@FXML
	void s(ActionEvent event) {
		cube.s();
		drawCube();
	}

	@FXML
	void sPrime(ActionEvent event) {
		cube.sPrime();
		drawCube();
	}

	@FXML
	void x(ActionEvent event) {
		cube.x();
		drawCube();
	}

	@FXML
	void xPrime(ActionEvent event) {
		cube.xPrime();
		drawCube();
	}

	@FXML
	void y(ActionEvent event) {
		cube.y();
		drawCube();
	}

	@FXML
	void yPrime(ActionEvent event) {
		cube.yPrime();
		drawCube();
	}

	@FXML
	void z(ActionEvent event) {
		cube.z();
		drawCube();
	}

	@FXML
	void zPrime(ActionEvent event) {
		cube.zPrime();
		drawCube();
	}
	
	@FXML
	void solve(ActionEvent event) {
		cube.solve();
		drawCube();
	}

	@FXML
	void initialize() {
		this.cube = new Cube();
		txtMoves.setWrapText(true);
		drawCube();

	}

	private void drawCube() {
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setStroke(Color.BLACK);

		drawFace(gc, Cube.F, 95, 95);
		drawFace(gc, Cube.R, 185, 95);
		drawFace(gc, Cube.U, 95, 5);
		drawFace(gc, Cube.L, 5, 95);
		drawFace(gc, Cube.B, 275, 95);
		drawFace(gc, Cube.D, 95, 185);

	}

	private void drawFace(GraphicsContext gc, int face, int x, int y) {

		gc.setLineWidth(2);
		int[][] info = cube.getFace(face);
		for (int i = 0; i < info.length; i++) {
			for (int j = 0; j < info.length; j++) {
				switch (info[i][j]) {
				case Piece.GREEN:
					gc.setFill(Color.GREEN);
					break;
				case Piece.RED:
					gc.setFill(Color.RED);
					break;
				case Piece.WHITE:
					gc.setFill(Color.WHITE);
					break;
				case Piece.ORANGE:
					gc.setFill(Color.DARKORANGE);
					break;
				case Piece.BLUE:
					gc.setFill(Color.BLUE);
					break;
				case Piece.YELLOW:
					gc.setFill(Color.YELLOW);
					break;
				}
				gc.fillRect(x, y, 30, 30);
				gc.strokeRect(x, y, 30, 30);
				x += 30;
			}
			x -= 90;
			y += 30;
		}
		y -= 90;
		gc.setLineWidth(3);
		gc.strokeRect(x, y, 90, 90);
	}
}
