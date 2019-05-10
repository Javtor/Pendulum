package threads;

import controller.MainView;
import model.Pendulum;

public class TimeThread extends Thread {
	
	private Pendulum pendulum;
	private MainView mainView;
	private double deltaTime;
	private boolean playing;
	
	public TimeThread(Pendulum pendulum, MainView mainView) {
		super();
		this.pendulum = pendulum;
		this.mainView = mainView;
		this.playing = true;
		deltaTime = 0;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		playing = true;
		pendulum.setTheta(-80);
		long t1 = System.currentTimeMillis();
		long t2 = System.currentTimeMillis();
		while(playing) {
			t1 = t2;
			t2 = System.currentTimeMillis();
			deltaTime = (t2- t1)/1000.0;
			mainView.drawPend();
			pendulum.step(deltaTime);
			System.out.println(deltaTime);
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public boolean isPlaying() {
		return playing;
	}

	public void setPlaying(boolean playing) {
		this.playing = playing;
	}

}
