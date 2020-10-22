package com.javarush.task.task18.task1820;

import java.io.*;
import java.util.ArrayList;

/* 
Округление чисел
*/

public class Solution {


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] path = new String[2];
        ArrayList<Double> doubleList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            path[i] = reader.readLine();
        }
        reader.close();
        int character;
        String string = "";

        FileReader fileReader = new FileReader(path[0]);
        while ((character = fileReader.read()) != -1) {
            while ((character = fileReader.read()) != -1) {
                if (character != ' ') {
                string = string + (char) character; }
                else {
//                    tempDouble = Double.parseDouble(string);
//                    tempString = String.format("%.1f", tempDouble);
                    doubleList.add(Double.parseDouble(string));
                    string = "";
                }
            }
        }

        doubleList.add(Double.parseDouble(string));
        fileReader.close();
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(path[1]));
        int in = 0;
        for (Double list: doubleList) {
            System.out.println(Math.round(list));
//            if (in != 0) {
//            fileWriter.write(System.lineSeparator()); }
            if (in != doubleList.size()-1) {
                fileWriter.write(Math.round(list)+" ");
            } else fileWriter.write(Math.round(list) + "");
            in++;
        }
        fileWriter.close();
    }

}
