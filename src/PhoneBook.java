import java.util.Arrays;
import java.util.Scanner;

public class PhoneBook {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = "";
        String number = "";
        String[][] book = {{"Иванов Иван Иванович", "+7 999 999 99 99"}, {"Михайлов Михаил Михайлович", "+7 888 888 88 88"}};
        System.out.println("Введите stop для завершения.\nВведите list для печати книги.");
        while (!name.equals("Stop")) {
            System.out.println("Введите имя:");
            name = formatName(scanner.nextLine());
            if (name.equals("Stop")) {
                break;
            }
            else if (name.equals("List")) {
                list(book);
            }
            else if (!checkName(name)) System.out.println("Введите корректное имя!");
            else if (searchBook(name, book) != ("")) System.out.println(searchBook(name, book));
            else {
                System.out.println("Введите телефон:");
                number = formatPhoneNumber(scanner.nextLine());
                book = add(book, name, number);
            }
        }
    }

    private static String searchBook(String name, String[][] book) {
        String res = "";
        for (int z = 0; z < book.length; z++) {
            if (book[z][0].equals(name)) {
                res = name + ": " + book[z][1];
            }
        }
        return res;
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
        String res = "";
        String[] words = name.trim().split(" ");
        for (int x = 0; x < words.length; x++) {
            words[x] = words[x].replace(words[x].charAt(0), Character.toUpperCase(words[x].charAt(0)));
        }
        for (String c : words) {
            res += c + " ";
        }
        return res.trim();
    }

    public static String formatPhoneNumber(String number) {
        String cleanNumber = number.replaceAll("[^0-9]", "");
        String res = "+7" + " " + cleanNumber.substring(1, 4) + " " + cleanNumber.substring(4, 7) + " " + cleanNumber.substring(7, 9) + " " + cleanNumber.substring(9);
        return res;
    }

    public static String[][] add(String[][] book, String name, String number) {
        String[][] bigbook = new String[book.length + 1][2];
        for (int x = 0; x < book.length; x++) {
            bigbook[x] = Arrays.copyOf(book[x], book.length);
        }
        bigbook[book.length][0] = name;
        bigbook[book.length][1] = number;
        book = new String[bigbook.length][2];
        for (int x = 0; x < bigbook.length; x++) {
            book[x] = Arrays.copyOf(bigbook[x], bigbook.length);
        } return book;
    }

    public static void list(String[][] book) {
        for (int x = 0; x < book.length; x++) {
            System.out.println(book[x][0] + ": " + book[x][1]);
        }
    }
}
