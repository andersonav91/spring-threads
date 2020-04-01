package com.consejosano.status;

import com.consejosano.status.service.AsynchronousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

@SpringBootApplication
public class StatusApplication {


	@Value("${consejosano.cron.threads-number}")
	private int threadsNumber;

	@Autowired
	private AsynchronousService asynchronousService;

	@Scheduled(cron="0 */${consejosano.cron.delay-between-executions} * ? * *")
	public void cronJobSch() throws Exception {
		for(int i = 1; i <= this.threadsNumber; i++) {
			asynchronousService.executeAsynchronously(i); // start a new thread
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(StatusApplication.class, args);
	}

}
