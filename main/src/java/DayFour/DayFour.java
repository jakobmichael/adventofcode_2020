package main.src.java.DayFour;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class DayFour {

    private List<HashMap<String, String>> inputList;
    private String location;
    private int validPassports;
    private List<HashMap<String, String>> validPassportList;
    private int validPassportsTwo;

    public DayFour(String location) throws Exception {
        this.location = location;
        this.inputList = getInputFromFile();
        this.validPassports = validatePassport(this.inputList);
        this.validPassportsTwo = checkValues();


    }


    public int getValidPassports() {
        return validPassports;
    }

    private List<HashMap<String, String>> getInputFromFile() throws Exception {
        List<HashMap<String, String>> input = new ArrayList();
        Scanner scanner = new Scanner(new File(this.location));
        HashMap<String, String> passportData = new HashMap<>();

        while (scanner.hasNextLine()) {
            String[] inputLine = scanner.nextLine().split(":");

            if (inputLine.length == 2) {
                passportData.put(inputLine[0], inputLine[1]);
            } else {

                input.add(new HashMap<String, String>(passportData));
                passportData.clear();
            }


        }
        return input;
    }

    private int validatePassport(List<HashMap<String, String>> inputList) {
        int numberOfValidPassports = 0;
        List<HashMap<String, String>> validPassports = new ArrayList<>();
        for (HashMap<String, String> passport : inputList) {
            if ((passport.keySet().size() == 8) | (passport.keySet().size() == 7 && !passport.keySet().contains("cid"))) {
                validPassports.add(passport);
                numberOfValidPassports++;

            } else {
                //
            }
        }
        this.validPassportList = validPassports;
        return numberOfValidPassports;
    }

    private int checkValues() {
        int numberOfValidPassports = 0;
        List<HashMap<String, String>> validPassports = new ArrayList<>();
        for (HashMap<String, String> passport : this.validPassportList) {

            if (checkByr(passport.get("byr")) && checkEyr(passport.get("eyr")) && checkIyr(passport.get("iyr")) && checkHgt(passport.get("hgt")) && checkHcl(passport.get("hcl")) && checkEcl(passport.get("ecl")) && checkPid(passport.get("pid"))) {
                validPassports.add(passport);
            }


        }
        System.out.println(validPassports.size());
        return numberOfValidPassports;
    }


    private boolean checkByr(String byr) {
        if (byr.length() == 4) {
            Integer birthYear = Integer.parseInt(byr);
            if (birthYear >= 1920 && birthYear <= 2002) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private boolean checkIyr(String iyr) {
        if (iyr.length() == 4) {
            Integer issueYear = Integer.parseInt(iyr);
            if (issueYear >= 2010 && issueYear <= 2020) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private boolean checkEyr(String eyr) {
        if (eyr.length() == 4) {
            Integer expYear = Integer.parseInt(eyr);
            if (expYear >= 2020 && expYear <= 2030) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private boolean checkHgt(String hgt) {

        int stringLength = hgt.length();
        int height = Integer.parseInt(hgt.replaceAll("[^\\d]", ""));
        String lastString = String.valueOf(hgt.charAt(stringLength - 1));


        if (lastString.equals("m")) {
            if (height >= 150 && height <= 193) {
                return true;
            } else {
                return false;
            }
        } else if (lastString.equals("n")) {
            if (height >= 59 && height <= 76) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private boolean checkHcl(String hcl) {
        String firstString = String.valueOf(hcl.charAt(0));
        int stringLength = hcl.length();
        if (firstString.equals("#")) {
            if (stringLength == 7) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private boolean checkEcl(String ecl) {
        switch (ecl) {
            case "amb":
                return true;

            case "blu":
                return true;

            case "brn":
                return true;

            case "gry":
                return true;

            case "grn":
                return true;

            case "hzl":
                return true;

            case "oth":
                return true;

            default:
                return false;


        }
    }

    private boolean checkPid(String pid) {
        if(pid.matches("[0-9]+") && pid.length() == 9){
            return true;
        } else {
            return false;
        }
    }

}
