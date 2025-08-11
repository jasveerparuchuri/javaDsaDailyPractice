package com.jasveer.OOPS.Multithreading.ProducerConsumerProblem;

public  class Producer extends Thread{
    Gfg gfg;

    Producer(Gfg gfg){
        this.gfg = gfg;
    }

    public void run(){
        int i = 0;
        while(true){
            try {
                gfg.produce(i);

                i++;
                    try {
                         Thread.sleep(100);
                    } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                    }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
