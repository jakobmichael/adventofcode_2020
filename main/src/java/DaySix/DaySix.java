package main.src.java.DaySix;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class DaySix {

    private List<String> input;
    private String location;
    private int sumOfAnswers;
    private int sumOfAnswersTwo;

    public DaySix(String location) throws Exception {
        this.location = location;
        this.input = getInputFromFile();
        this.sumOfAnswers = getAnswers(this.input);
        this.sumOfAnswersTwo = getAnswersPartTwo(this.input);
    }


    public int getSumOfAnswers() {
        return this.sumOfAnswers;
    }

    public int getSumOfAnswesTwo() {
        return this.sumOfAnswersTwo;
    }

    private List<String> getInputFromFile() throws Exception {
        List<String> input = new ArrayList<>();
        Scanner scanner = new Scanner(new File(this.location));

        while (scanner.hasNextLine()) {
            input.add(scanner.nextLine());

        }
        return input;
    }

    private int getAnswers(List<String> input) {
        HashMap<String, Integer> groupAnswers = new HashMap<>();
        int sum = 0;
        for (int j = 0; j < input.size(); j++) {
            if (input.get(j).length() == 0) {
                sum += groupAnswers.keySet().size();
                groupAnswers.clear();
            } else {

                for (int i = 0; i < input.get(j).length(); i++) {
                    groupAnswers.put(input.get(j).substring(i, i + 1), 1);
                }
                if (j == input.size() - 1) {
                    sum += groupAnswers.keySet().size();
                }
            }
        }
        return sum;
    }

    private int getAnswersPartTwo(List<String> input) {
        int sum = 0;
        List<String> group = new ArrayList<>();

        for (int i = 0; i < input.size(); i++) {
            if (input.get(i).length() == 0) {
                sum += getEqualAnswers(group);
                group.clear();
            } else {
                group.add(input.get(i));
                if (i == input.size() - 1) {
                    sum += getEqualAnswers(group);
                }
            }
        }

        return sum;
    }
    
    private int getEqualAnswers(List<String> group) {
        int equalAnswers = 0;
        HashMap<String, Integer> answers = new HashMap<>();
        for (String answer : group) {
            for (int i = 0; i < answer.length(); i++) {
                if (answers.keySet().contains(answer.substring(i, i + 1))) {

                    answers.put(answer.substring(i, i + 1), answers.get(answer.substring(i, i + 1)) + 1);
                } else {
                    answers.put(answer.substring(i, i + 1), 1);
                }
            }
        }
        for (String key : answers.keySet()) {
            
            if (answers.get(key) == group.size()) {
                equalAnswers++;
            }
        }
       
        return equalAnswers;
    }
    
   
}
