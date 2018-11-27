package csvToMysql;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;


public class App {
    public static void main(String[] args) throws Exception {
        String[] springConfig  = {    "jobs/csvToMysqlJob.xml" };

        // Creating the application context object
        ApplicationContext context = new ClassPathXmlApplicationContext(springConfig);

        // Creating the job launcher
        JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");

        // Creating the job
        Job job = (Job) context.getBean("csvToMysqlJob");

        // Executing the JOB
        JobExecution execution = jobLauncher.run(job, getJobParameters());

        System.out.println("Exit Status : " + execution.getStatus());
    }

    public static JobParameters getJobParameters() {
        JobParametersBuilder jobParametersBuilder = new JobParametersBuilder();
        jobParametersBuilder.addString("jobId", "test4");
        return jobParametersBuilder.toJobParameters();
    }
}
