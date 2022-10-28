package es.bgtiban.application.exampleeventdriven;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

@RestController
@RequestMapping("/")
public class ExampleRabbitMqController {
	
	private final static String QUEUE_NAME = "hello";

	@GetMapping("/msg/{mensaje}")
	public String test(@PathVariable String mensaje) {
		
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		try (Connection connection = factory.newConnection();
		     Channel channel = connection.createChannel()) {
			
			channel.queueDeclare(QUEUE_NAME, true, false, false, null);
			
			channel.basicPublish("", QUEUE_NAME, null, mensaje.getBytes());
			System.out.println(" [x] Sent '" + mensaje + "'");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Tu mensaje ha sido enviado a la cola";
	}
	
	@GetMapping("/msg")
	public String test() {
		StringBuilder sb = new StringBuilder();
		
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		try (Connection connection = factory.newConnection();
		     Channel channel = connection.createChannel()) {
			
			channel.queueDeclare(QUEUE_NAME, true, false, false, null);
			
			DeliverCallback deliverCallback = (consumerTag, delivery) -> {
			    String message = new String(delivery.getBody(), "UTF-8");
			    System.out.println(message);
			    sb.append(message);
			};
			
			channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> { });
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb.toString();
	}
	
		 
}
