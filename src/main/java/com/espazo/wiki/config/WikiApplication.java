package com.espazo.wiki.config;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

//@ComponentScan({"com.espazo.wiki", "com.test"})
@ComponentScan("com.espazo.wiki")
@SpringBootApplication
@MapperScan("com.espazo.wiki.mapper")
public class WikiApplication {

	private static final Logger LOG = LoggerFactory.getLogger(WikiApplication.class);

	public static void main(String[] args) {
//		SpringApplication.run(WikiApplication.class, args);
		SpringApplication app = new SpringApplication(WikiApplication.class);
		Environment env = app.run(args).getEnvironment();
		LOG.info("Successfully started");
		LOG.info("address: http://localhost:{}/", env.getProperty("server.port"));

	}

}
