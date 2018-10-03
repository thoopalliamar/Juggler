package com.stackroute.juggler.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.stackroute.juggler.kafka.domain.InputUser;

@EnableKafka
@Configuration
public class KafkaConsumerconfiguration {

	@Value("${bootstrap-id}")
	private String bootstrap_id;

	// consumer factory of kafka which will hold the configuration details
	@Bean
	public ConsumerFactory<String, InputUser> consumerFactory() {
		Map<String, Object> config = new HashMap<>();
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrap_id);
		config.put(ConsumerConfig.GROUP_ID_CONFIG, "user");
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(),
				new JsonDeserializer<>(InputUser.class));
	}

	// Template imports the configuration from Consumer factory
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, InputUser> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, InputUser> factory = new ConcurrentKafkaListenerContainerFactory<String, InputUser>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}
}
