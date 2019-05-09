package controller;

import javafx.scene.paint.Color;

import java.awt.GraphicsConfigTemplate;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MainView {
	
	public static final double PEND_W = 20;
	public static final double PEND_H = 20;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Canvas canvas;

    @FXML
    private TextField txtMass;

    @FXML
    private TextField txtGravity;

    @FXML
    private TextField txtLength;

    @FXML
    private TextField txtAngle;

    @FXML
    private Button btnStart;

    @FXML
    void start(ActionEvent event) {
    	double x = Double.parseDouble(txtMass.getText());
    	double y = Double.parseDouble(txtGravity.getText());
    	drawPend(x, y);
    }

    @FXML
    void initialize() {
    	drawPend(0, 0);
    	
    }
    
    public void drawPend(double x, double y) {
    	GraphicsContext gc = canvas.getGraphicsContext2D();
    	gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
    	drawPend(gc, x, y);
    }
    
    private void drawPend(GraphicsContext gc, double rawX, double rawY) {
    	gc.setFill(Color.RED);

    	double width = canvas.getWidth()/2;
    	double height = canvas.getHeight()/2;
    	
    	rawX += width;
    	rawY += height;
    	
    	double x = rawX - PEND_W/2;
    	double y = rawY - PEND_H/2;
    	
//    	//Eje y
//    	gc.strokeLine(width, 0, width, 2*height);
//    	//Eje x
//    	gc.strokeLine(0, height, width*2, height);
    	
    	gc.strokeLine(width, 0, rawX, rawY);
    	
    	gc.fillOval(x, y, PEND_W, PEND_H);
    	
    }
}
