
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Podaj swoją wagę w kilogramach: ");
        Scanner scanner = new Scanner(System.in);
        String weightStr = scanner.nextLine();
        System.out.println("Podaj swój wzrost w metrach: ");
        String heightStr = scanner.nextLine();
        double weight = Double.parseDouble(weightStr);
        double height = Double.parseDouble(heightStr.replace(",","."));
        BMICalculator calculator = new BMICalculator(weight, height);

        String indexBmi = calculator.calculate();
        System.out.println("Twój indeks wynosi: " + indexBmi);
        String diagnoza = calculator.interpret();
        System.out.println("To oznacza: " + diagnoza);
    }
}
