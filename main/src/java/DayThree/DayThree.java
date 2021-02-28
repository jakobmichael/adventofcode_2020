package main.src.java.DayThree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DayThree {

    private List<String> input;
    private List<Integer> numberOfTrees;
    List<Integer[]> slopes;

    public DayThree(String fileLocation) throws Exception {
        this.input = getInputStrings(fileLocation);
        this.slopes = getSlopeRoutes();
        this.numberOfTrees = allTreesInSlopes();

    }

    public List<String> getInput() {
        return this.input;
    }

    public List<Integer> getNumberOfTrees() {
        return this.numberOfTrees;
    }

    private List<Integer[]> getSlopeRoutes() {
        List<Integer[]> slopes = new ArrayList<>();
        slopes.add(new Integer[] { 1, 1 });
        slopes.add(new Integer[] { 3, 1 });
        slopes.add(new Integer[] { 5, 1 });
        slopes.add(new Integer[] { 7, 1 });
        slopes.add(new Integer[] { 1, 2 });

        return slopes;

    }

    private List<String> getInputStrings(String fileLocation) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileLocation));
        List<String> inputLines = new ArrayList<String>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            inputLines.add(line);
        }
        return inputLines;
    }

    private String getCharacterAtLocation(String line, int index) {
        line = line.repeat(250);
        String charAtLoc = String.valueOf(line.charAt(index));

        return charAtLoc;

    }

    private Integer searchTrees(Integer slopeRight, Integer slopeDown) {
        Integer numberOfTrees = 0;
        int rightTurns = 0;

        for (int i = 0; i < this.input.size(); i+=slopeDown) {
            String charAtLoc = getCharacterAtLocation(this.input.get(i), rightTurns);
            switch (charAtLoc) {
                case ".":
                    break;
                case "#":
                    numberOfTrees++;
                    break;
            }
            rightTurns += slopeRight;
        }
        return numberOfTrees;
    }

    private List<Integer> allTreesInSlopes() {
        List<Integer> numberOfTrees = new ArrayList<>();
        for (Integer[] slope : this.slopes) {
            numberOfTrees.add(searchTrees(slope[0], slope[1]));
        }

        return numberOfTrees;
    }
}
