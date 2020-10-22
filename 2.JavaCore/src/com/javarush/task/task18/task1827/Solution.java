package com.javarush.task.task18.task1827;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/* 
Прайсы
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        ArrayList<String> arguments = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileReader fileReader = new FileReader(new File(fileName));
        BufferedReader readFile = new BufferedReader(fileReader);
        String findIdInLine = null;
        FileOutputStream outputStream = new FileOutputStream(fileName, true);
        //BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);

        byte[] bytes2 = new byte[8];
        byte[] bytes;
        byte[] newId = new byte[8];
        byte[] string;
        byte[] productName = null;
        byte[] productPrice = null;
        byte[] productQuantity = null;
        String temp = null;
        Integer numero = 0;
        TreeSet<Integer> maxID = new TreeSet<Integer>();

        int in;
        if (args.length != 0) {
            if (args.length == 4) {
                for (int i = 0; i < args.length; i++) {
                    arguments.add(args[i]);
                }
            } else {
                arguments.add(args[0]);
                arguments.add(args[1]);
                for (int i = 2; i < args.length - 2; i++) {
                    arguments.set(1, arguments.get(1) + " " + args[i]);
                }
                arguments.add(args[args.length - 2]);
                arguments.add(args[args.length - 1]);
            }

            switch (arguments.get(0)) {
                case ("-c"): {
                    while ((findIdInLine = readFile.readLine()) != null) {
                            bytes = findIdInLine.getBytes();
                        System.out.println(new String(bytes));
                            in = 1;
                            for (int i = 0; i < 8; i++) {
                                if ((bytes[0] == 0) || (bytes[0] == ' ') && (i < 1)) {
                                    bytes2[0] = (byte) '0';
                                }
                                if (bytes[i] != (byte) ' ') {
                                    newId[i] = bytes[i];
                                    bytes2[i] = bytes[i];

                                } else {
                                    newId[i] = (byte) ' ';
                                    if ((i != 0) && (bytes[i - 1] != (byte) ' ')) {
                                        in = i;
                                    }
                                }

                                if ((i == 7)&&(newId[7] != ' ')) {
                                    in = i+1;
                                }
                            }
                            bytes = new byte[in];
                            for (int j = 0; j < in; j++) {
                                bytes[j] = bytes2[j];
                            }
                            temp = new String(bytes);
                            numero = Integer.parseInt(temp);

                            if (findIdInLine == null) {
                                newId[0] = (byte) '1';
                            }
                            maxID.add(numero);

                        }
                        if (maxID.isEmpty()) {
                            maxID.add(0);
                        }
                        numero = maxID.last();
                        numero++;
                        temp = Integer.toString(numero);
                        byte[] bytes1 = temp.getBytes();
                        for (int j = 0; j < temp.length(); j++) {
                            newId[j] = bytes1[j];
                        }
                        int m = arguments.get(1).length();
                        int m1 = arguments.get(2).length();
                        int m2 = arguments.get(3).length();
                        if (m < 30) {
                            for (int i = 0; i < 30 - m; i++) {
                                arguments.set(1, arguments.get(1) + " ");
                            }
                        } else if (m > 30) {
                            String newString = arguments.get(1);
                            char[] chars = newString.toCharArray();
                            char[] newChars = new char[30];
                            int len = chars.length;
                            for (int i = 0; i < 30; i++) {
                                newChars[i] = chars[i];
                            }
                            arguments.set(1, new String(newChars));
                        }
                        if (m1 < 8) {
                            for (int i = 0; i < 8 - m1; i++) {
                                arguments.set(2, arguments.get(2) + " ");
                            }
                        }
                        if (m2 < 4) {
                            for (int i = 0; i < 4 - m2; i++) {
                                arguments.set(3, arguments.get(3) + " ");
                            }

                        }
                        arguments.set(3, arguments.get(3));
                        productName = arguments.get(1).getBytes();
                        int pN = productName.length;
                        productPrice = arguments.get(2).getBytes();
                        int pP = productPrice.length;
                        productQuantity = arguments.get(3).getBytes();
                        int pQ = productQuantity.length;
                        string = new byte[9 + pQ + pP + pN];
                        for (int i = 0; i < 9 + pN + pP + pQ; i++) {
                            if (i == 0) {
                                string[0] = 10;
                            }
                            if (i > 0 && i < 9) {
                                string[i] = newId[i-1];
                            } else if ((i < 9 + pN) && (i > 8)) {
                                string[i] = productName[i - 9];
                            } else if ((i < 9 + pN + pP) && (i > 8 + pN)) {
                                string[i] = productPrice[i - (9 + pN)];
                            } else if ((i < 9 + pN + pP + pQ) && (i > 8 + pN + pP)) {
                                string[i] = productQuantity[i - (9 + pN + pP)];
                            }
                        }
                        outputStream.write(System.lineSeparator().getBytes());
                        outputStream.write(string);
                        outputStream.flush();

                    }
            }
        }
        //bufferedOutputStream.close();
        outputStream.close();
        readFile.close();
        fileReader.close();


        reader.close();

    }

}
