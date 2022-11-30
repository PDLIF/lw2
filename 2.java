import java.util.Scanner;
import java.util.regex.*;

public class App{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("your password: ");
        String password = scan.next();

        String regexp1 = "\\w{8}";
        String regexp2 = "[A-Z]";
        String regexp3 = "[a-z]";
        String regexp4 = "\\d";

        Pattern mainPattern = Pattern.compile(regexp1);
        Pattern valid1 = Pattern.compile(regexp2);
        Pattern valid2 = Pattern.compile(regexp3);
        Pattern valid3 = Pattern.compile(regexp4);


        Matcher password_matcher = mainPattern.matcher(password);
        Matcher checking_for_uppercase = valid1.matcher(password);
        Matcher checking_for_lowercase = valid2.matcher(password);
        Matcher checking_for_digit = valid3.matcher(password);

        if (password_matcher.matches()) {
            if (checking_for_uppercase.find() && 
                checking_for_lowercase.find() &&
                checking_for_digit.find()) {
                    System.out.println("Your password is strong enough");
            } else {
                System.out.println("Weak password. Try something better");
            }
        } else {
            System.out.println("Your password must consist of 8 charachters, including one digits, \nuppercase and lowercase letters altogether. Try again.");
        }

    }
}