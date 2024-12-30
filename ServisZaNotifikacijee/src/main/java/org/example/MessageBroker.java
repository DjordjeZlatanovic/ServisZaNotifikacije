package org.example;

import org.apache.activemq.broker.BrokerService;

public class MessageBroker {

    public static void main(String[] args) throws Exception {
        BrokerService broker = new BrokerService();
        // configure the broker
        broker.addConnector("tcp://localhost:61616");
        broker.start();
        System.out.println("Message Broker is running...");
        Thread.sleep(Long.MAX_VALUE);
    }
}
