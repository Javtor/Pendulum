package model;

public class Pendulum {
	
	public static final double g = 9.81;
	
	private double theta;
	private double dTheta;
	private double L;
	private double m;
	
	public Pendulum(double theta, double dTheta, double l, double m) {
		super();
		setTheta(theta);
		this.dTheta = dTheta;
		L = l;
		this.m = m;
	}

	public double getTheta() {
		return theta;
	}

	public void setTheta(double theta) {
		this.theta = Math.toRadians(theta);
	}

	public double getDTheta() {
		return dTheta;
	}

	public void setDTheta(double dTheta) {
		this.dTheta = dTheta;
	}
	
	public void step(double dt) {
		theta += dTheta*dt;
		dTheta -= (g/L)*theta;
	}
	
	public double getX() {
		return L*Math.sin(theta);
	}
	
	public double getY() {
//		return L*(1-Math.cos(theta));
		return 0;
	}

	public double getL() {
		return L;
	}

	public void setL(double l) {
		L = l;
	}

	public double getM() {
		return m;
	}

	public void setM(double m) {
		this.m = m;
	}

	
}
