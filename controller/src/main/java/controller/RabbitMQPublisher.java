package controller;

import com.rabbitmq.client.*;
import common.BuildMessage;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;

public class RabbitMQPublisher {

    private static final String QUEUE = "build_queue";

    public static void send(BuildMessage msg) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE, false, false, false, null);

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bos);
        out.writeObject(msg);

        channel.basicPublish("", QUEUE, null, bos.toByteArray());

        System.out.println("Sent job: " + msg.jobName);

        channel.close();
        connection.close();
    }
}
