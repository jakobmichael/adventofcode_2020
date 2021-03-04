package main.src.java.DayFive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DayFive {

    private List<String> input;
    private String location;
    private List<Integer> rows;
    private List<Integer> columns;
    private Integer maxSeatID;

    public DayFive(String location) throws FileNotFoundException {
        this.location = location;
        this.input = readInput();
        this.rows = getRows(this.input);
        this.columns = getColumns(this.input);
        this.maxSeatID = getMaxSeatID(this.rows, this.columns);

    }

    public Integer getMaxSeatID() {
        return this.maxSeatID;
    }

    private List<String> readInput() throws FileNotFoundException {
        List<String> input = new ArrayList<>();
        Scanner scanner = new Scanner(new File(this.location));

        while (scanner.hasNextLine()) {
            input.add(scanner.nextLine());
        }
        return input;

    }

    private List<Integer> getRows(List<String> input) {
        List<Integer> rows = new ArrayList<>();

        for (String seatCode : input) {
            String rowCode = seatCode.substring(0, 7);
            rows.add(analyseRowCode(rowCode));
        }
      
        return rows;

    }

    private List<Integer> getColumns(List<String> input) {
        List<Integer> columns = new ArrayList<>();
        for (String seatCode : input) {
            String columnCode = seatCode.substring(7, seatCode.length());
            columns.add(analyseColumnCode(columnCode));
        }

        return columns;
    }

    private int analyseRowCode(String rowCode) {
        int range = 128;
        int minRow = 0;
        int maxRow = 127;

        for (int i = 0; i < rowCode.length(); i++) {

            switch (rowCode.substring(i, i + 1)) {

                case "F":
                    maxRow = maxRow - (range / 2);
                    range = range / 2;
                    break;
                case "B":
                    minRow = minRow + (range / 2);
                    range = range / 2;
                    break;

            }

        }

        return maxRow;
    }

    private int analyseColumnCode(String columnCode) {
        int range = 8;
        int minColumn = 0;
        int maxColumn = 7;

        for (int i = 0; i < columnCode.length(); i++) {

            switch (columnCode.substring(i, i + 1)) {

                case "L":
                    maxColumn = maxColumn - (range / 2);
                    range = range / 2;
                    break;
                case "R":
                    minColumn = minColumn + (range / 2);
                    range = range / 2;
                    break;

            }

        }

        return maxColumn;
    }

    private Integer getMaxSeatID(List<Integer> rows, List<Integer> columns) {
        int maxSeatID = 0;
        List<Integer> seatIDs = new ArrayList<>();
        for (int i = 0; i < rows.size(); i++) {
            int seatID = rows.get(i) * 8 + columns.get(i);
            seatIDs.add(seatID);

            if (seatID > maxSeatID) {
                maxSeatID = seatID;
            }

        }

        getMissingSeat(seatIDs);

        
        return maxSeatID;
    }
    
    private void getMissingSeat(List<Integer> seatIDs) {
        Collections.sort(seatIDs);

        for (int i = 0; i < seatIDs.size()-1; i++) {
            if (seatIDs.get(i + 1) - seatIDs.get(i) != 1) {
                System.out.println(seatIDs.get(i)+1);
            }
        }

    }

}
