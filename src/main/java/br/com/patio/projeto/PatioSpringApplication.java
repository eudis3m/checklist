package br.com.patio.projeto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
@EnableAutoConfiguration()
@ComponentScan("br.com.patio.projeto")
@Configuration
public class PatioSpringApplication extends SpringBootServletInitializer {
	private static final Logger LOGGER = LoggerFactory.getLogger(PatioSpringApplication.class);

	//@Bean
	public static void main(String[] args) {
		SpringApplication.run(PatioSpringApplication.class, args);
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		LOGGER.info("Inicializando aplicação Multicanais via container (arquivo .war).");
		return application.sources(PatioSpringApplication.class);
	}
}
