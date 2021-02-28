package main.src.java.DayTwo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DayTwo {

    private Integer numberOfValidPW;
    
    public DayTwo(String fileLocation, Integer mode) throws Exception {
        this.numberOfValidPW = getValidPasswords(fileLocation, mode);

    }

    public Integer getNumberOfValidPW() {
        return this.numberOfValidPW;
    }

    private Integer getValidPasswords(String fileLocation, Integer mode) throws Exception {
        Integer numberOfValidPW = 0;
        Scanner scanner = new Scanner(new File(fileLocation));

        while (scanner.hasNextLine()) {
            String[] key = scanner.nextLine().split(":");

            List<Integer> boundaries = getPasswordRules(key[0]);
            String match = getMatchString(key[0]);
            Integer countOfMatch = countAppearanceOfMatch(match, key[1]);

            switch (mode) {
                case 1:

                    if (countOfMatch >= boundaries.get(0) && countOfMatch <= boundaries.get(1)) {
                        numberOfValidPW++;
                        break;
                    }
                case 2:
                    if (checkPasswordIndices(key[1], match, boundaries)) {
                        numberOfValidPW++;
                        break;
                    }

            }
        }

        return numberOfValidPW;
    }

    private Boolean checkPasswordIndices(String value, String match, List<Integer> indices) {
        int locOne = indices.get(0);
        int locTwo = indices.get(1);
        String[] indexStrings = new String[] { String.valueOf(value.charAt(locOne)),
                String.valueOf(value.charAt(locTwo)) };
        if (indexStrings[0].equals(match) && indexStrings[1].equals(match)) {
            return false;
        }
        if (indexStrings[0].equals(match)) {
            return true;
        } else if (indexStrings[1].equals(match)) {
            return true;
        }
        return false;

    }

    private List<Integer> getPasswordRules(String key) {

        Matcher matcher = Pattern.compile("\\d+").matcher(key);
        List<Integer> boundaries = new ArrayList<Integer>();
        while (matcher.find()) {
            boundaries.add(Integer.parseInt(matcher.group()));
        }
        return boundaries;
    }

    private Integer countAppearanceOfMatch(String match, String password) {
        Matcher matcher = Pattern.compile(match).matcher(password);
        Integer count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    private String getMatchString(String key) {

        String match = key.substring(key.length() - 1);

        return match;
    }

}
