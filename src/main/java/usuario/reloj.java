package usuario;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class reloj {
	Timer timer = new Timer();
	
	void ejecutarCadaDia(TimerTask tarea,Date inicio) {
		timer.scheduleAtFixedRate(tarea, inicio, TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS));
	}
	//https://stackoverflow.com/questions/10310411/run-a-scheduled-task-once-a-day
}