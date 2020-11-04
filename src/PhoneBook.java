import java.util.Arrays;
import java.util.Scanner;

public class PhoneBook {

    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            boolean isCorrectName = false;
            String name = "";
            int number = 0;
            String[][] book = new String[0][2];
            while (!isCorrectName) {
                name = scanner.nextLine();
                isCorrectName = checkName(name);
                if (!isCorrectName) System.out.println("Введите корректное имя!");
            }
            name = formatName(name);
            if (scaningBook(name, book) != "") {
                System.out.println(scaningBook(name, book));
            } else {
                String[][] bookbigger = new String[book.length + 1][2];
                bookbigger[book.length][0] = name;
                bookbigger[book.length][1] = formatPhoneNumber(scanner.nextLine());
                System.out.println(bookbigger[book.length][0] + " " + bookbigger[book.length][1]);
            }
    }

    private static String scaningBook(String name, String[][] book) {
        String res = "";
        for (int x = 0; x < book.length -1; x++) {
            if (name.equalsIgnoreCase(book[x][0])); {
                res = book[x][0] + " " + book[x][1];
                break;
            }
        } return res;
    }

    public static boolean checkPhoneNumber(String phoneNumber) {
        String clean = phoneNumber.replaceAll("[^0-9]", "");
        return clean.length() == 11;
    }

    public static boolean checkName(String name) {
            String[] words = name.trim().split(" ");
            return words.length == 3;
    }

    public static String formatName(String name) {
        String[] words = name.trim().split(" ");
        String result = "";
        for (int i = 0; i < words.length; i++) {
            String str = words[i];
            char firstChar = str.charAt(0);
            if (!Character.isUpperCase(firstChar)) {
                result += Character.toUpperCase(firstChar) + str.substring(1) + " ";
            } else {
                result += str + "";
            }
        }
        return result;
    }

    public static String formatPhoneNumber(String number) {
        String clean = number.replaceAll("[^0-9]", "");
        String result = "+7" + " " + clean.substring(1, 4) + " " +
                clean.substring(4, 7) + " " + clean.substring(7, 9) + " " + clean.substring(9);

        return result;
    }

    public static void add(String[][] book, String name, String number) {
        //add logic
    }

    public static void list(String[][] book) {
        //print phone book
    }
}
