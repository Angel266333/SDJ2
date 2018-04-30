package temperature.domain.mediator;
import temperature.domain.model.Temperature;
import temperature.domain.model.TemperatureList;
public class TemperatureModelManager extends Observable implements TemperatureModel
{
 private TemperatureList temperatureList;
 public TemperatureModelManager()
 {
 temperatureList = new TemperatureList();
 }

 @Override
 public void addTemperature(int value)
 {
 Temperature temperature = new Temperature(value);
 this.temperatureList.addTemperature(temperature);
 }

 @Override
 public Temperature getLastInsertedTemperature()
 {
 return temperatureList.getTemperature(0);
 }

 public TemperatureList getAllTemperatures()
 {
 return temperatureList;
 }

 // and maybe other methods...
}