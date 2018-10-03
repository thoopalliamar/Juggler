package com.stackroute.juggler.movieschedule.config;

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

import com.stackroute.juggler.kafka.domain.Theatre;

//Kafka KafkaConsumerConfig for TheatreRegistration Details

@EnableKafka
@Configuration
public class KafkaConsumerConfig {

	@Value("${bootstrap-id}")
	private String bootstrap_id;

	// 172.23.238.190 192.168.43.174 10.20.1.16

	// KafkaConsumerConfigg factory of kafka which will hold the configuration
	// details
	@Bean
	public ConsumerFactory<String, Theatre> consumerFactory() {
		Map<String, Object> config = new HashMap<>();
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "10.20.1.16:9092");
		config.put(ConsumerConfig.GROUP_ID_CONFIG, "grpid");
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);

		return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(),
				new JsonDeserializer<>(Theatre.class));
	}

	// Template imports the configuration from consumer factory
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, Theatre> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, Theatre> factory = new ConcurrentKafkaListenerContainerFactory<String, Theatre>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}

}
