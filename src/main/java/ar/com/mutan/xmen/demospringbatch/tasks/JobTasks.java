package ar.com.mutan.xmen.demospringbatch.tasks;

import java.util.Date;

import javax.batch.api.listener.JobListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class JobTasks {

    private static final Logger log = LoggerFactory.getLogger(JobTasks.class);
    /*
    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job job;

    @Scheduled(fixedRate = 10000)
    public void executeJob() throws Exception {
        log.info("Inicio: " + new Date());
        JobParameters JobParameters = new JobParametersBuilder().addString("JobID", String.valueOf(System.currentTimeMillis())).toJobParameters();
        jobLauncher.run(job, jobParameters);} */
    
}
