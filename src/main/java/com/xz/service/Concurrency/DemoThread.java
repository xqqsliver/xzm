package com.xz.service.Concurrency;

public class DemoThread  extends Thread {

    @Override
    public void run() {

    }

    static class TestA implements  Runnable{

        public void run() {

        }

    }
    public static void main(String args[]){
        DemoThread t=new DemoThread();
        t.start();//method 1
       Thread th=new Thread(new TestA());
        th.start();//method 2

    }
}
