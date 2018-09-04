package reloj;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.SchedulerContext;
import org.quartz.SchedulerException;

import usuario.Cliente;

public class SimplexJob implements Job{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {

		SchedulerContext schedulerContext = null;
		try {
			schedulerContext = context.getScheduler().getContext();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		
		 Cliente unCliente = (Cliente) schedulerContext.get("cliente");

		unCliente.ejecutarSimplex();
	}

}

// https://stackoverflow.com/questions/12777057/how-to-pass-instance-variables-into-quartz-job/12782677