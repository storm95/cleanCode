package com.ankit.InMemoryQueue;

import com.ankit.InMemoryQueue.library.App;
import com.ankit.InMemoryQueue.library.Message;
import com.ankit.InMemoryQueue.library.Producer;

public class Client {
    public static void main(String args[]) {
        App.init();
        App.registerQueue("queue1");
        App.registerConsumer("consumer1", "queue1");
        App.registerConsumer("consumer2", "queue1");
        Producer producer1 = App.registerProducer("producer1", "queue1");

        producer1.pushMessage(new Message("message1 queue1 producer1"));
        producer1.pushMessage(new Message("message2 queue1 producer1"));

        Producer producer2 = App.registerProducer("producer2", "queue1");
        producer2.pushMessage(new Message("message3 queue1 producer2"));
        producer2.pushMessage(new Message("message4 queue1 producer2"));
    }
}
