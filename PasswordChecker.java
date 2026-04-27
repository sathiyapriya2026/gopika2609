import java.util.Scanner;
class Passwordchecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        int length = password.length();
        boolean hasUpper = false, hasLower = false;
        boolean hasDigit = false, hasSpecial = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpper = true;
            else if (Character.isLowerCase(c)) hasLower = true;
            else if (Character.isDigit(c)) hasDigit = true;
            else hasSpecial = true;
        }

        if (length >= 8 && hasUpper && hasLower && hasDigit && hasSpecial) {
            System.out.println("Strong Password ");
        } else if (length >= 6) {
            System.out.println("Medium Password ");
        } else {
            System.out.println("Weak Password ");
        }
    }
}