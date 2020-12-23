package com.mushiny.workbin.rabbit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;

@Configuration
public class RabbitMQConfig {
	private Logger log = LoggerFactory.getLogger(RabbitMQConfig.class);
	@Autowired
	private Environment environment;

	@Bean
	public ConnectionFactory connectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
		connectionFactory.setAddresses(environment.getProperty("spring.rabbitmq.host"));
		connectionFactory.setUsername(environment.getProperty("spring.rabbitmq.username"));
		connectionFactory.setPassword(environment.getProperty("spring.rabbitmq.password"));
		//必须要设置
		connectionFactory.setPublisherConfirms(true);
		return connectionFactory;
	}

	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public RabbitTemplate rabbitTemplate() {
		RabbitTemplate template = new RabbitTemplate(connectionFactory());
		return template;
	}

	@Bean
	public RabbitListenerContainerFactory<SimpleMessageListenerContainer> highPerformance(ConnectionFactory rabbitConnectionFactory) {
		SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
		factory.setConnectionFactory(rabbitConnectionFactory);
		//每个线程一次取10个
		factory.setPrefetchCount(10);
		//15个并发线程
		factory.setConcurrentConsumers(15);
		factory.setAcknowledgeMode(AcknowledgeMode.NONE);
		return factory;
	}
}
