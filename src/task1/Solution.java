package task1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * For example:
 * <p>
 * 1abc2
 * pqr3stu8vwx
 * a1b2c3d4e5f
 * treb7uchet
 * In this example, the calibration values of these four lines are 12, 38, 15, and 77. Adding these together produces 142.
 * <p>
 * Consider your entire calibration document. What is the sum of all of the calibration values?
 */
public class Solution {

    public static void main(String[] args) throws IOException {
        result();
    }

    public static int result() throws IOException {
        var strings = Files.readAllLines(Paths.get("src/task1/input.txt"));
        var sum = strings.stream()
                .mapToInt(Solution::getCalibrationValues)
                .sum();
        System.out.println(sum);
        return sum;
    }

    private static int getCalibrationValues(String value) {
        var numArray = new ArrayList<Character>();
        for (var ch : value.toCharArray()) {
            if (Character.isDigit(ch)) {
                numArray.add(ch);
            }
        }

        var firstNumber = numArray.getFirst();
        var lastNumber = numArray.getLast();

        var firstTwoDigitsInString = firstNumber.toString().concat(lastNumber.toString());
        return Integer.parseInt(firstTwoDigitsInString);
    }
}
