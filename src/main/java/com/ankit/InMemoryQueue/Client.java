package com.ankit.InMemoryQueue;

import com.ankit.InMemoryQueue.library.*;

public class Client {
    public static void main(String args[]) {
        App.init(100);

        queue1Testcase();
        queue2Testcase();

        System.out.println("In main Thread: "+Thread.currentThread().getName());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(QueueManager.getInstance().getQueue("queue1").getSize());
        System.out.println("End of the App");


        App.shutdown();
    }

    public static void queue1Testcase() {

        App.registerQueue("queue1", 5000);
        Consumer consumer1 = App.registerConsumer("consumer1", "queue1");
        Consumer consumer2 = App.registerConsumer("consumer2", "queue1");
        Producer producer1 = App.registerProducer("producer1", "queue1");

        producer1.pushMessage(new Message("message1 queue1 producer1", 1000L));
        System.out.println(QueueManager.getInstance().getQueue("queue1").getSize());

        producer1.pushMessage(new Message("message2 queue1 producer1", 1000L));
        System.out.println(QueueManager.getInstance().getQueue("queue1").getSize());

        Producer producer2 = App.registerProducer("producer2", "queue1");
        producer2.pushMessage(new Message("message3 queue1 producer2", 1000L));
        System.out.println(QueueManager.getInstance().getQueue("queue1").getSize());

        producer2.pushMessage(new Message("message4 queue1 producer2", 1000L));
        System.out.println(QueueManager.getInstance().getQueue("queue1").getSize());
    }

    public static void queue2Testcase() {

        App.registerQueue("queue11", 5000);
        Consumer consumer1 = App.registerConsumer("consumer11", "queue11");
        Consumer consumer2 = App.registerConsumer("consumer21", "queue11");
        Producer producer1 = App.registerProducer("producer11", "queue11");

        producer1.pushMessage(new Message("message11 queue11 producer11", 1000L));
        System.out.println(QueueManager.getInstance().getQueue("queue11").getSize());

        producer1.pushMessage(new Message("message21 queue11 producer11", 900L));
        System.out.println(QueueManager.getInstance().getQueue("queue11").getSize());

        Producer producer2 = App.registerProducer("producer21", "queue11");
        producer2.pushMessage(new Message("message31 queue11 producer21", 1000L));
        System.out.println(QueueManager.getInstance().getQueue("queue11").getSize());

        producer2.pushMessage(new Message("message41 queue11 producer21", 800L));
        System.out.println(QueueManager.getInstance().getQueue("queue11").getSize());
    }
}
