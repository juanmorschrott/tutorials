package com.juanmorschrott.hotel;

import io.jaegertracing.Configuration;
import io.opentracing.Tracer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HotelApplication {

	@Bean
	public Tracer getTracer() {
		Configuration.SamplerConfiguration samplerConfig = new Configuration.SamplerConfiguration();
		Configuration.ReporterConfiguration reporterConfig = new Configuration.ReporterConfiguration();

		Configuration config = new Configuration("opentracing-tutorial");
		config.withSampler(samplerConfig);
		config.withReporter(reporterConfig);

		return config.getTracer();
	}

	public static void main(String[] args) {
		SpringApplication.run(HotelApplication.class, args);
	}

}
