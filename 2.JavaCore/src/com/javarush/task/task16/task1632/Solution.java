package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new Thread1());
        threads.add(new Thread2());
        threads.add(new Thread3());
        threads.add(new Thread4());
        threads.add(new Thread5());
    }

    public static void main(String[] args) {
    }

    public static class Thread1 extends Thread {
        @Override
        public void run() {
            while (true) {

            }

        }
    }
    public static class Thread2 extends Thread {

        public Thread2() {
          //
            //this.start();
//            try {
//                Thread.sleep(2000);
//                interrupt();
//            } catch (InterruptedException e) {
                //System.out.println("Interrupted Exception");
//            }
        }

        @Override
        public void run() {


                try {
                    while (true) {

                        throw new InterruptedException();
                        }

                } catch (InterruptedException e) {
                    System.out.println("InterruptedException");
                }
            }

    }
    public static class Thread3 extends Thread {

        public Thread3() {
           //this.start();
        }

        @Override
        public void run() {
            while (true){
                System.out.println("Ура");
                try {
                    Thread.sleep(500);

                } catch (InterruptedException e) {

                }
            }
        }
    }
    public static class Thread4 extends Thread implements Message {

        public Thread4() {
         // this.start();

        }

        @Override
        public void run() {
            while (!isInterrupted()) {

            }

        }

        @Override
        public void showWarning() {
            interrupt();
        }
    }
    public static class Thread5 extends Thread {

        public Thread5() {
           // this.start();
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        @Override
        public void run() {
            String s;
            Integer inte=0;
            try {
                while (!(s=reader.readLine()).equals("N")) {
                inte = inte + Integer.parseInt(s);


                }
                System.out.println(inte);
            } catch (IOException e) {

            }


        }
    }
}

