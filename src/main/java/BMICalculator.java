import java.math.BigDecimal;
import java.math.MathContext;

public class BMICalculator implements Calculator {
    private final double weight;
    private final double height;
    private double bmi;
    private String result;

    public String calculate(){
        bmi = weight / (height*height);
        BigDecimal bmiBig = new BigDecimal(bmi);
        bmiBig = bmiBig.round(new MathContext(2));
        return bmiBig.toString();
    }

    public String interpret(){
        double[] valuesOfBmi = {0, 15, 16, 18.5, 25, 30, 35, 40, 45, 50, 60};
        String[] infosForBmi = {"Very severely underweight",
                "Severely underweight",
                "Underweight",
                "Normal (healthy weight)",
                "Overweight",
                "Obese Class I (Moderately obese)",
                "Obese Class II (Severely obese)",
                "Obese Class III (Very severely obese)",
                "Obese Class IV (Morbidly Obese)",
                "Obese Class V (Super Obese)",
                "Obese Class VI (Hyper Obese)"};

        for (int i = 0; i < valuesOfBmi.length; i++) {
            if (bmi > valuesOfBmi[i]) {
                result = infosForBmi[i];
            }
        }
        return result;
    }

    BMICalculator (double weight, double height){
        if (weight <= 0){
            throw new IllegalArgumentException("Podaj prawidlowa wage w kilogramach!");
        }
        if (height <= 0 || height > 3) {
            throw new IllegalArgumentException("Podaj prawidlowy wzrost w metrach!");
        }
        this.weight = weight;
        this.height = height;
    }

}
