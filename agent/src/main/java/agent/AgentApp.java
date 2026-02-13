package agent;

public class AgentApp {
    public static void main(String[] args) throws Exception {
        RabbitMQConsumer.listen();
    }
}
