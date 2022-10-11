package com.com.threading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantLock;

/*
 *
 *
 *
 * */
public class BlockingQueue <T> {

    private int size;

    private Queue<T> queue = new LinkedList<T>();

    private ReentrantLock lock = new ReentrantLock();

    public BlockingQueue(int size) {
        this.size = size;
    }

    public void add(T item) throws InterruptedException {
        // lock.lock();

        synchronized (queue) {
            if(queue.size() == size) {
                wait();
            }
            queue.add(item);
            if(queue.size() == 1) {
                notifyAll();
            }
        }

        // lock.unlock();
    }

    public T poll() throws InterruptedException {
        T item = null;
        synchronized (queue) {
            if(queue.size() == 0) {
                wait();
            }

            // notify all is fine here as the notifyall call will wake other thread... and other threads wont be able to add to qeueue...
            // until they have the lock...
            if(queue.size() == size) {
                notifyAll();
            }


            item = queue.poll();
        }
        return item;
    }

}
