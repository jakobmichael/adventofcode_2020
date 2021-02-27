package main.src.java.DayTwo;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DayTwo {

  
    private HashMap<String, String> input;
     
    public DayTwo(String fileLocation) throws Exception {
        this.input = getInputValues(fileLocation);

        
    }
    
    private Integer getNumberOfValidPasswords() {
        Integer numberOfValidPW = 0;

        for (String key : this.input.keySet()) {
            List<Integer> boundaries = getPasswordRules(key);
            String match = "";
            
        }



        return numberOfValidPW;
        
    }


    private HashMap<String, String> getInputValues(String fileLocation) throws Exception {

        HashMap<String, String> input = new HashMap<>();
        Scanner scanner = new Scanner(new File(fileLocation));

        while (scanner.hasNextLine()) {
            String[] key = scanner.nextLine().split(":");

            input.put(key[0], key[1]);

        }

        return input;
    }

    private List<Integer> getPasswordRules(String key) {

        Matcher matcher = Pattern.compile("\\d+").matcher(key);
        List<Integer> boundaries = new ArrayList<Integer>();
        while (matcher.find()) {
            boundaries.add(Integer.parseInt(matcher.group()));
        }
        return boundaries;
    }
    
    private String getMatchString(String key) {
      
        Matcher matcher = Pattern.compile(  "[a-zA-Z]").matcher(key);
        String match = key.matches("[a-zA-Z]")
        while (matcher.find()) {
           match.add(Integer.parseInt(matcher.group()));
        }
        return match
    }

}
