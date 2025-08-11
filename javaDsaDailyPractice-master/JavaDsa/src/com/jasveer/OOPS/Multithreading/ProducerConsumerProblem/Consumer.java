package com.jasveer.OOPS.Multithreading.ProducerConsumerProblem;



public  class Consumer  extends Thread{
    Gfg gfg;
    Consumer(Gfg gfg){
        this.gfg = gfg;
    }

    public void run(){
        while(true){
            try {
                gfg.consume();

                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
