package view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String getCarNames() {
        return scanner.nextLine();
    }

    public static int getTryCount() {
        return scanner.nextInt();
    }
}
