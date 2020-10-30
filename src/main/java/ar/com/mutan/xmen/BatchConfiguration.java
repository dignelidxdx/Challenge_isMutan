package ar.com.mutan.xmen;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.annotation.EnableAsync;

import ar.com.mutan.xmen.entities.Persona;
import ar.com.mutan.xmen.listener.JobListener;
import ar.com.mutan.xmen.processor.PersonaItemProcessor;
/*

@Configuration
@EnableAsync
@EnableBatchProcessing
public class BatchConfiguration {
	
	@Autowired
	public JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public FlatFileItemReader<Persona> reader(){
		return new FlatFileItemReaderBuilder<Persona>()
			   .name("personaItemReader")
			   .resource(new ClassPathResource("sample-data.csv"))
			   .delimited()
			   .names(new String[] {"primerNombre", "segundoNombre", "telefono"})
			   .fieldSetMapper(new BeanWrapperFieldSetMapper<Persona>() {{
				   setTargetType(Persona.class);
			   }})
			   .build();
	}
	
	@Bean
	public PersonaItemProcessor processor() {
		return new PersonaItemProcessor();
	}
	
	@Bean
	public JdbcBatchItemWriter<Persona> writer(DataSource dataSource){
		return new JdbcBatchItemWriterBuilder<Persona>()
				.itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
				.sql("INSERT INTO persona (primer_nombre, segundo_nombre, telefono) VALUES (:primerNombre, :segundoNombre, :telefono)")
				.dataSource(dataSource)
				.build();
	}
	
	@Bean
	public Job importPersonaJob(JobListener listener, Step step1) {
		return jobBuilderFactory.get("importPersonaJob")
				.incrementer(new RunIdIncrementer())
				.listener(listener)
				.flow(step1)
				.end()
				.build();
	}
	
	@Bean
	public Step step1(JdbcBatchItemWriter<Persona> writer) {
		return stepBuilderFactory.get("step1")
				.<Persona, Persona> chunk(10)
				.reader(reader())
				.writer(writer)
				.build();
	}

} */