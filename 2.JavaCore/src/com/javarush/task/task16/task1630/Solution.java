package com.javarush.task.task16.task1630;

import java.io.*;
import java.nio.Buffer;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        } catch (IOException e) {

        }
        try {
            reader.close();
        } catch (IOException e) {
                    }

    }
    //add your code here - добавьте код тут

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        //add your code here - добавьте код тут
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface  {
        private String s;
        private String fileContent="";
        @Override
        public void run() {

            try {
                BufferedReader reader = new BufferedReader(new FileReader(s));

                    String sn = reader.readLine();
                    while (sn!=null) {
                        fileContent=fileContent+sn+ " ";
                        sn=reader.readLine();
                    }


            } catch (FileNotFoundException e) {

            }
            catch (IOException e) {

            }


        }

        @Override
        public void setFileName(String fullFileName) {
            this.s = fullFileName;
        }

        @Override
        public String getFileContent() {
            return fileContent;
        }


    }

    //add your code here - добавьте код тут
}
