package com.ankit.InMemoryQueue;

import com.ankit.InMemoryQueue.library.*;

public class Client {
    public static void main(String args[]) {
        App.init();
        App.registerQueue("queue1", 5000);
        Consumer consumer1 = App.registerConsumer("consumer1", "queue1");
        Consumer consumer2 = App.registerConsumer("consumer2", "queue1");
        Producer producer1 = App.registerProducer("producer1", "queue1");

        producer1.pushMessage(new Message("message1 queue1 producer1", 2000L));
        System.out.println(QueueProvider.getInstance().getQueue("queue1").getSize());

        producer1.pushMessage(new Message("message2 queue1 producer1", 5000L));
        System.out.println(QueueProvider.getInstance().getQueue("queue1").getSize());

        Producer producer2 = App.registerProducer("producer2", "queue1");
        producer2.pushMessage(new Message("message3 queue1 producer2", 1000L));
        System.out.println(QueueProvider.getInstance().getQueue("queue1").getSize());

        producer2.pushMessage(new Message("message4 queue1 producer2", 1000L));
        System.out.println(QueueProvider.getInstance().getQueue("queue1").getSize());

        System.out.println(QueueProvider.getInstance().getQueue("queue1").getSize());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(QueueProvider.getInstance().getQueue("queue1").getSize());


        App.shutdown();
    }
}
