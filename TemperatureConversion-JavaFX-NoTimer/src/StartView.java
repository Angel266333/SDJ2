import javafx.application.Application;

public class StartView implements Runnable{
	
	private TemperatureView view;
	
	public StartView(TemperatureView view) {
		this.view = view;
	}

	@Override
	public void run() {
		Application.launch(view.getClass());
		
	}

}
