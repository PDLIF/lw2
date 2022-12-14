import java.util.Scanner;
import java.util.regex.*;


public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
            System.out.print("Дата: ");
            String date = scan.next();

            String regexp = "([012][0-9]|3[01])\\/(0[0-9]|1[12])\\/(19[0-9]{2}|[2-9]\\d{3})";
            Pattern pattern = Pattern.compile(regexp);
            Matcher dateMatcher = pattern.matcher(date);

            if (dateMatcher.matches()) { 
                int day = Integer.parseInt(dateMatcher.group(1));
                int month = Integer.parseInt(dateMatcher.group(2));
                int year = Integer.parseInt(dateMatcher.group(3));

                if (month == 2) { 
                    if (((day <= 29) && (year % 4 == 0)) || ((day <= 28) && (year % 4 != 0))) {
                        System.out.println("All good. Entered date is valid.");
                    } else if ((day > 29) && (year % 4 == 0)) {
                        System.out.println("fail (that's the leap year!)");
                    } else if ((day > 28) && (year % 4 != 0)) {
                        System.out.println("Fail (none-leap year's Fabruary consists not much than 28 days.)");
                    }
                } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                    if (day > 30) {
                        System.out.println("Wrong date. Entered date does not exist. Month under number " + month + " includes only 30 days.");
                    }
                } else {
                    System.out.println("All good. Entered date is valid.");
                }
            } else {
                System.out.println("Entered date's format is invalid, sorry(");
            }
        scan.close();
    } 
}

