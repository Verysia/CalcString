import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String virajenie = scanner.nextLine();

        Calculator calculator = new Calculator();
        calculator.calc(virajenie);
    }
}