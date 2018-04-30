package temperature.view;

import java.util.Observer;

import temperature.controller.TemperatureController;

public interface TemperatureView extends Observer {
	public void startView(TemperatureController controller);

	void show(String text);

}
