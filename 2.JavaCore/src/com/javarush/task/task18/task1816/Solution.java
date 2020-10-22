package com.javarush.task.task18.task1816;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 
Английские буквы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader inputStream = new FileReader(new File(args[0]));
        ArrayList<Integer> bytes = new ArrayList<>();
        int s = 0;
        int num = 0;
        while ((s = inputStream.read()) != -1) {
            if (((s > 96) && (s < 123)) || ((s > 64) && (s < 91))) {
            num++; }
        }
        System.out.println(num);
        inputStream.close();


    }
}
