package com.com.threading;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumer {



}


class Producer extends Thread {

    Queue<String> queue = new LinkedBlockingQueue<>();

    public Producer(Queue<String> queue) {
        this.queue  = queue;
    }

    public void produce(String item) {
        // this is a blockign operation....
        queue.add(item);
    }

    @Override
    public void run() {
        super.run();
    }
}

class Consumer {

    Queue<String> queue = new LinkedBlockingQueue<>();

    public Consumer(Queue<String> queue) {
        this.queue = queue;
    }

    public void consume() {

    }
}
