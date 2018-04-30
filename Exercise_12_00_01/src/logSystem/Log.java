package logSystem;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Log {

	private File file;

	private static Log logSingleton;

	private QueueADT<LogLine> logs;

	private Log() {
		logs = new ArrayQueue<>();

		file = new File("logInfo.txt");

	}

	public static Log getLog() {
		if (logSingleton == null) {
			logSingleton = new Log();
		}

		return logSingleton;
	}

	public void add(LogLine logLine) {

		if (logLine == null) {
			return;
		}
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new FileWriter(file, true));
			out.write(logLine + "\n");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public QueueADT<LogLine> getAll() {
		return logs;
	}
}