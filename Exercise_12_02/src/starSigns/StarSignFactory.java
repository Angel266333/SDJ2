package starSigns;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class StarSignFactory {

private static Map<String, StarSign> signs = new HashMap<String, StarSign>();

public static StarSign getStarSign(String name) {
	StarSign item = signs.get(name);

	if (item == null) {
		item = new StarSign(name);
		signs.put(name, item);
	}
	
	return item;
}

public static StarSignWithInterpretation getStarSign(String name, Calendar birthday, String location) {
	return new StarSignWithInterpretation(location, birthday, location);
}

}