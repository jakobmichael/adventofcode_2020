package main.src.java.DayOne;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class DayOne {

    
    private ArrayList<Integer> inputNumbers;
    private ArrayList<Integer> solutionValues;
    private Integer solution;


    public DayOne(String fileLocation, Integer mode) throws Exception {
       
        this.inputNumbers = getInput(fileLocation);
        this.solutionValues = findValues(mode);
        this.solution = multiplySolutionValues(solutionValues);

    }
 

    public ArrayList<Integer> getInputNumbers() {
        return this.inputNumbers;
    }

    public ArrayList<Integer> getSolutionValues() {
        return this.solutionValues;
    }
    
    public Integer getSolution() {
        return this.solution;
    }

    


    private ArrayList<Integer> getInput(String fileLocation) throws Exception {

        ArrayList<Integer> inputNumbers = new ArrayList<Integer>();
        Scanner scanner = new Scanner(new File(fileLocation));
        int count = 0;

        while (scanner.hasNextInt()) {
            inputNumbers.add(count, scanner.nextInt());
            count++;

        }

        return inputNumbers;
    }
    
    private ArrayList<Integer> findValues(Integer mode) {
        ArrayList<Integer> solutionValues = new ArrayList<Integer>();

        switch (mode) {
            case 1:
                solutionValues = partOne(this.inputNumbers);
                break;
            case 2:
                solutionValues = partTwo(this.inputNumbers);
                break;
            default:
                solutionValues.add(0);
                solutionValues.add(0);
                        }

      
        return solutionValues;

    }
    
    private ArrayList<Integer> partOne(ArrayList<Integer> range) {
        ArrayList<Integer> solutionValues = new ArrayList<Integer>();
          for (int i = 0; i < range.size(); i++) {
            Integer valueOne = range.get(i);
            for (int j = i + 1; j < range.size() - 1; j++) {
                Integer valueTwo = range.get(j);
              Integer valuesToSum[] = {valueOne,valueTwo};
               
                if (sumValues(valuesToSum)) {
                    solutionValues.add(valueOne);
                    solutionValues.add(valueTwo);
                } else {
                    // do nothing
                }
            }
        }

        return solutionValues;
    }

    private ArrayList<Integer> partTwo(ArrayList<Integer> range) {
        ArrayList<Integer> solutionValues = new ArrayList<Integer>();
        for (int i = 0; i < range.size(); i++) {
            Integer valueOne = range.get(i);
            for (int j = i + 1; j < range.size() - 1; j++) {
                Integer valueTwo = range.get(j);
                for (int k = i + 2; k < range.size() - 2; k++) {

                    Integer valueThree = range.get(k);
                    Integer valuesToSum[] = { valueOne, valueTwo, valueThree };

                    if (sumValues(valuesToSum)) {
                        solutionValues.add(valueOne);
                        solutionValues.add(valueTwo);
                        solutionValues.add(valueThree);
                        return solutionValues;
                    } else {
                        // do nothing
                    }
                }
            }
        }
        System.out.println(solutionValues);
          return solutionValues;
    }
    
    private Boolean sumValues(Integer valuesToSum[]) {
        Integer sum = 0;

        for (int i = 0; i < valuesToSum.length; i++) {
            sum += valuesToSum[i];
        }
        if (sum == 2020) {
            return true;
        } else {
            return false;
        }
                  
    }

    private Integer multiplySolutionValues(ArrayList<Integer> solutionValues) {


        Integer solution = 1;
        for (int i = 0; i < solutionValues.size(); i++) {
            solution *= solutionValues.get(i);
        }
        return solution;
    }

    
}
