package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string;
        while (!(string = reader.readLine()).equals("exit")) {
            new ReadThread(string).start();

        }
        reader.close();

    }

    public static class ReadThread extends Thread {
        private String string;
        HashMap<Integer, Integer> map = new HashMap<>();

        public ReadThread(String fileName) {
            super();
            this.string = fileName;

            //implement constructor body
        }

        @Override
        public void run() {
            super.run();
            FileInputStream inputStream = null;
            try {
                inputStream = new FileInputStream(string);
               // System.out.println("hi");
                int max = 0;
                int byteIn = 0;
                int maxByte = 0;
                try {
                while (inputStream.available() > 0) {
                    byteIn = inputStream.read();
                    if (map.containsKey(byteIn)) {
                        map.put(byteIn, map.get(byteIn) + 1);
                    } else map.put(byteIn, 1);
                    for (Map.Entry<Integer, Integer> maps : map.entrySet()) {
                        if (maps.getValue() > max) {
                            max = maps.getValue();
                            maxByte = maps.getKey();
                        }
                    }
                    resultMap.put(string, maxByte);
                }
                  //  System.out.println("Сама мапа: " + map);

                } catch (IOException e) {
                        e.printStackTrace();
                    }

                System.out.println(resultMap);
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            this.interrupt();
        }
        // implement file reading here - реализуйте чтение из файла тут
    }
}
