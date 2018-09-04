package reloj;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import usuario.Cliente;

import static org.quartz.JobBuilder.*;
import static org.quartz.TriggerBuilder.*;

import org.quartz.CronScheduleBuilder;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import static org.quartz.SimpleScheduleBuilder.*;

public class Reloj {
	public void ejecutarSimplexDiaHoraMinuto(Cliente unCliente,int dia,int hora,int minuto) throws Exception {
		
		JobDetail job = JobBuilder.newJob(SimplexJob.class)
				.withIdentity("simplex", "group1")
				.build();

		
		Trigger trigger = TriggerBuilder
				.newTrigger()
				.withIdentity("mensual", "group1")
				.withSchedule(
						CronScheduleBuilder.monthlyOnDayAndHourAndMinute(dia,hora,minuto))
				.build();
		
	
		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
		scheduler.getContext().put("cliente", unCliente);
		scheduler.start();
		scheduler.scheduleJob(job, trigger);

	}
}

// http://www.quartz-scheduler.org/
// http://www.quartz-scheduler.org/documentation/quartz-2.2.x/tutorials/tutorial-lesson-01.html
