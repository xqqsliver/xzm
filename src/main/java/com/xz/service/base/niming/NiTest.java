package com.xz.service.base.niming;

public class NiTest {
    public void show(){
        People test=new People(){
            public void say(){
               System.out.print("say heool");
            }

        };

    }

    public static void main(String args[]){
        NiTest t=new NiTest();
        t.show();
        Thread t1=new Thread(){
            public void run(){
                System.out.print("cccccc");
            }
        };

    }
}
