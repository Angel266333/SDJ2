package temperature.view;

import temperature.controller.TemperatureController;

public interface TemperatureView {
	public void startView(TemperatureController controller);

	void show(String text);
}
