package main.src.java;

import main.src.java.DayFive.DayFive;
import main.src.java.DayFour.DayFour;
import main.src.java.DayThree.DayThree;

public class AdventOfCode {

    //private static String fileLocationOne = "C:/devel/adventofcode_2020/main/src/java/DayOne/DayOneInput.txt";
    
    //private static String fileLocationTwo = "C:/devel/adventofcode_2020/main/src/java/DayTwo/DayTwoInput.txt";
    
    //private static String fileLocationThree = "/home/jakob-michael/Dokumente/devel/adventofcode_2020/main/src/java/DayThree/DayThreeInput.txt";

    //private static String fileLocationFour = "/home/jakob-michael/Dokumente/devel/adventofcode_2020/main/src/java/DayFour/DayFourInput.txt";

    private static String fileLocationFive = "C:/devel/adventofcode_2020/main/src/java/DayFive/DayFiveInput.txt";
    
    public static void main(String args[]) throws Exception {
        /*enter 1 for part one, 2 for part two
        DayOne dayOne = new DayOne(fileLocationOne,2);
        System.out.println(dayOne.getSolution());*/

        // DayTwo dayTwo = new DayTwo(fileLocationTwo,1);
        // System.out.println(dayTwo.getNumberOfValidPW());

        /*DayThree dayThree = new DayThree(fileLocationThree);
        System.out.println(dayThree.getNumberOfTrees());
        Integer solutionDayThree = 1;
        
        for (Integer trees : dayThree.getNumberOfTrees()) {
            solutionDayThree *= trees;
        }

        System.out.println(solutionDayThree);*/

        //DayFour dayFour = new DayFour(fileLocationFour);
        //System.out.println(dayFour.getValidPassports());

        DayFive dayFive = new DayFive(fileLocationFive);
        System.out.println(dayFive.getMaxSeatID());
        
    


    
    

      
    
       
    }
    
}
