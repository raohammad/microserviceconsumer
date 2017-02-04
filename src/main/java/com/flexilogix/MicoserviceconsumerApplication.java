package com.flexilogix;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@SpringBootApplication
@EnableBinding(Sink.class)
public class MicoserviceconsumerApplication {
	
	private final Logger logger = LoggerFactory.getLogger(MicoserviceconsumerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MicoserviceconsumerApplication.class, args);
	}
	
	@StreamListener(Sink.INPUT)
	public void loggerSink(Data sinkData) {
		logger.info("Received: " + sinkData.toString());
	}
}
