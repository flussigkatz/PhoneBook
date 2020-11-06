import java.util.Scanner;

public class PhoneBook {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean stop = false;
        String name = "";
        String number = "";
        String[][] book = {{"Иванов Иван Иванович", "+7 999 999 99 99"}, {"Михайлов Михаил Михайлович", "+7 888 888 88 88"}};
        while (!name.equals("stop")) {
            name = scanner.nextLine();
            if (!checkName(name)) {
                System.out.println("Введите корректное имя!");
            } else if (searchBook(name, book) != "") {
                System.out.println(searchBook(name, book));
            } else {
                number = formatPhoneNumber(scanner.nextLine());
                add(book, name, number);
            }
        }
    }
    private static String searchBook(String name, String[][] book) {
        String res = "";
        for (String[] namecolumn : book) {
            for (int z = 0; z < namecolumn.length; z++) {
                if (namecolumn[z].equals(name)) {
                    System.out.println(z);
                    res = name + ": " + book[z][1];
                }
            }
        } return res;
    }

    /*private static String scaningBook(String name, String[][] book) {
        String res = "";
        String[] copyarray = Arrays.copyOf(book, book.length);
        String[] copyarray = book;
        for (int x = 0; x < book.length -1; x++) {
            if (name.equalsIgnoreCase(book[x][0])) {
                res = book[x][1];
                break;
            }
        for (String x : copyarray) {
            if (x.equalsIgnoreCase(name)) {
                res = x;
                break;
            }
            System.out.println(x);
        }
        return res;
    }*/

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
                result += str + " ";
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
        String[][] bookbigger = new String[book.length + 1][2];
        bookbigger[book.length][0] = name;
        bookbigger[book.length][1] = number;
        System.out.println(bookbigger[book.length][0] + " " + bookbigger[book.length][1]);
    }

    public static void list(String[][] book) {
        //print phone book
    }
}
