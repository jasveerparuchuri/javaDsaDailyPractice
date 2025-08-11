package com.jasveer.OOPS.Multithreading;
class Brackets{

     public synchronized void bracket(char open , char close){
        for(int i = 0; i< 10;i++){
            if(i < 5){
                System.out.print(open);

//                System.out.println(Thread.currentThread()+" "+i);
            }else {
                System.out.print(close);
//                System.out.println(Thread.currentThread()+" "+i);
            }

        }
    }

    public void bracket1(char open , char close){
         synchronized (this) {
             for (int i = 0; i < 10; i++) {
                 if (i < 5) {
                     System.out.print(open);
//                System.out.println(Thread.currentThread()+" "+i);
                 } else {
                     System.out.print(close);
//                System.out.println(Thread.currentThread()+" "+i);
                 }

             }
         }
    }
}
public class Synochorinzed {
    public static void main(String[] args) {
            Brackets b = new Brackets();
            Thread t1 = new Thread(new Runnable(){
            @Override
            public void run() {
                long start = System.currentTimeMillis();
                for (int i = 0; i < 5; i++) {
                    b.bracket1('[',']');
                }
                long end = System.currentTimeMillis();
                System.out.println("Thread1 : +" + (end - start));

            }
        });
            Thread t2 = new Thread(new Runnable() {
                @Override

                public void run() {
                    long start = System.currentTimeMillis();
                    for (int i = 0; i <5 ; i++) {
                        b.bracket1('{','}');
                    }
                    long end = System.currentTimeMillis();
                    System.out.println("Thread2 : +" + ( end - start));
                }
            });
            t1.start();
            t2.start();
    }
}
