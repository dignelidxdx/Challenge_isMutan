package ar.com.mutan.xmen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

// Spring Boot 1.x
//import org.springframework.boot.web.support.SpringBootServletInitializer;
@SpringBootApplication
@EnableAsync
// agregar esta anotacion para permitir Batch Progress
@EnableScheduling
public class XmenApplication extends SpringBootServletInitializer {

	@Bean("threadPoolExecutor") //para la ejecucion del pool de hilos que se ejecutara
	public TaskExecutor getAsuncExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(3);
		executor.setMaxPoolSize(3);
		executor.setQueueCapacity(100);
		executor.setThreadNamePrefix("Async");
		executor.initialize();
		return executor;
	}

	public static void main(String[] args) {
		SpringApplication.run(XmenApplication.class, args);
	}


}
