package controller;

import common.BuildMessage;

public class ControllerApp {
    public static void main(String[] args) throws Exception {
        BuildMessage msg = new BuildMessage(
                "TestJob",
                "echo Hello from Agent"
        );
        RabbitMQPublisher.send(msg);
    }
}
