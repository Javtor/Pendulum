package model;

public class Pendulum {
	
	private double theta;
	private double dTheta;
	
	
	public Pendulum(double theta, double dTheta) {
		super();
		this.theta = theta;
		this.dTheta = dTheta;
		
	}

	public double getTheta() {
		return theta;
	}

	public void setTheta(double theta) {
		this.theta = theta;
	}

	public double getDTheta() {
		return dTheta;
	}

	public void setDTheta(double dTheta) {
		this.dTheta = dTheta;
	}
	
	public void step(double dt) {
		theta += dTheta*dt;
	}
	
	public double getX() {
		return theta;
	}
	
	public double getY() {
		return 0;
	}

}
