package main.src.java;

import main.src.java.DayThree.DayThree;
import main.src.java.DayTwo.DayTwo;

public class AdventOfCode {

    //private static String fileLocationOne = "C:/devel/adventofcode_2020/main/src/java/DayOne/DayOneInput.txt";
    
    //private static String fileLocationTwo = "C:/devel/adventofcode_2020/main/src/java/DayTwo/DayTwoInput.txt";
    
    private static String fileLocationThree = "C:/devel/adventofcode_2020/main/src/java/DayThree/DayThreeInput.txt";
    public static void main(String args[]) throws Exception {
        /*enter 1 for part one, 2 for part two
        DayOne dayOne = new DayOne(fileLocationOne,2);
        System.out.println(dayOne.getSolution());*/

        // DayTwo dayTwo = new DayTwo(fileLocationTwo,1);
        // System.out.println(dayTwo.getNumberOfValidPW());

        DayThree dayThree = new DayThree(fileLocationThree);
        System.out.println(dayThree.getNumberOfTrees());
        Integer solutionDayTwo = 1;
        
        for (Integer trees : dayThree.getNumberOfTrees()) {
            solutionDayTwo *= trees;
        }

        System.out.println(solutionDayTwo);




    
    

      
    
       
    }
    
}
