package com.websystique.springboot;

import java.net.InetAddress;

import org.slf4j.LoggerFactory;
//import org.apache.log4j.spi.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.core.env.SimpleCommandLinePropertySource;
//import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.websystique.springboot.configuration.JpaConfiguration;


@Import(JpaConfiguration.class)
@SpringBootApplication(scanBasePackages={"com.websystique.springboot"})// same as @Configuration @EnableAutoConfiguration @ComponentScan
public class SpringBootCRUDApp {
	
	  private static final Logger log = LoggerFactory.getLogger(SpringBootCRUDApp.class);

	   /* @Inject
	    private Environment env;*/

	public static void main(String[] args) {
		//SpringApplication.run(SpringBootCRUDApp.class, args);
		SpringApplication app = new SpringApplication(SpringBootCRUDApp.class);
		//app.setShowBanner(false);
        SimpleCommandLinePropertySource source = new SimpleCommandLinePropertySource(args);
     //   addDefaultProfile(app, source);
       // addLiquibaseScanPackages();
        Environment env = app.run(args).getEnvironment();
        log.info("Access URLs:\n----------------------------------------------------------\n\t" +
            "Local: \t\thttp://127.0.0.1:{}\n\t" +
            "External: \thttp://{}:{}\n----------------------------------------------------------",
            env.getProperty("server.port"),
         //   InetAddress.getLocalHost().getHostAddress(),
            env.getProperty("server.port"));
	}
}
