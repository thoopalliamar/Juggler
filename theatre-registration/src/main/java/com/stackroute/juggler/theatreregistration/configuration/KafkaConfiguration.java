package com.stackroute.juggler.theatreregistration.configuration;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.stackroute.juggler.kafka.domain.Theatre;

@Configuration
public class KafkaConfiguration {

	// This is producer factory of kafka which will hold the configuration details
	@Bean
	public ProducerFactory<String, Theatre> producerFactory() {
		Map<String, Object> config = new HashMap<>();
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "10.20.1.16:9092");
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		// config.put(JsonDeserializer.TRUSTED_PACKAGES,
		// "com.stackroute.juggler.movieschedule.domain");
		return new DefaultKafkaProducerFactory<>(config);
	}

	// This template imports the configuration from producerfactory

	@Bean
	public KafkaTemplate<String, Theatre> kafkaTemplate() {
		return new KafkaTemplate<>(producerFactory());
	}
}
