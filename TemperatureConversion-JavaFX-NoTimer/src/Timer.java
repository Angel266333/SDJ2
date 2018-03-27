import javafx.application.Platform;

public class Timer implements Runnable{
	
	private Clock clock;
	private TemperatureView view;
	

	public Timer(Clock clock, TemperatureView view) {
		this.clock = clock;
		this.view = view;
	}


	@Override
	public void run() {
		for(;;) {
			try {
				Thread.sleep(1000);
				String time = clock.getCurrentTime();
				Platform.runLater(new ShowTimeUpdater(view, time));

			} catch (InterruptedException e) {
				e.printStackTrace();
				break;
			}
		}
		
	}

}
