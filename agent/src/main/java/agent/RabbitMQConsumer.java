package agent;

import com.rabbitmq.client.*;
import common.BuildMessage;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

public class RabbitMQConsumer {

    private static final String QUEUE = "build_queue";

    public static void listen() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE, false, false, false, null);

        System.out.println("Agent waiting for jobs...");

        DeliverCallback callback = (tag, delivery) -> {
            try {
                ObjectInputStream in = new ObjectInputStream(
                        new ByteArrayInputStream(delivery.getBody())
                );

                BuildMessage msg = (BuildMessage) in.readObject();

                System.out.println("Executing job: " + msg.jobName);

                executeCommand(msg.command);

                System.out.println("Job completed");

            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        channel.basicConsume(QUEUE, true, callback, tag -> {});
    }

    private static void executeCommand(String command) {
        try {
            Process process = Runtime.getRuntime().exec(command);
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
