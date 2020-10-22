package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();
    public int numOfSimilar = 0;

    public Solution() {

    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String allLinesStr = reader.readLine();
        String forRemovalStr = reader.readLine();
        BufferedReader reader2 = new BufferedReader(new FileReader(new File(allLinesStr)));
        BufferedReader reader3 = new BufferedReader(new FileReader(new File(forRemovalStr)));
        String allLinesFile = reader2.readLine();
        while (allLinesFile != null) {
            allLines.add(allLinesFile);
            allLinesFile = reader2.readLine();
        }
        String forRemovalFile = reader3.readLine();
        while (forRemovalFile != null) {
            forRemoveLines.add(forRemovalFile);
            forRemovalFile = reader3.readLine();
        }
        //System.out.println(allLines);
        //System.out.println(forRemoveLines);
        try {
            new Solution().joinData();
        } catch (CorruptedDataException e) {
            e.printStackTrace();
        }
        //System.out.println(allLines);
        reader.close();
        reader2.close();
        reader3.close();
    }

    public void joinData() throws CorruptedDataException {
        for (int i=0; i<forRemoveLines.size(); i++) {
            if (allLines.contains(forRemoveLines.get(i))) {
                numOfSimilar++;
            }
        }
        if (numOfSimilar == forRemoveLines.size()) {
            allLines.removeAll(forRemoveLines);
        } else {

            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
