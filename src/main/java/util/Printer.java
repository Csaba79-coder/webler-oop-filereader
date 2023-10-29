package util;

public class Printer {

    public static void print(Object[] objects) {
        for (Object object : objects) {
            System.out.println(object);
        }
    }

    private Printer() {
    }
}
