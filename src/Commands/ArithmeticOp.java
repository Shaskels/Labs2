package Commands;

public class ArithmeticOp {
    public String Sum(String[] digits){
        float num1 = Float.parseFloat(digits[0]);
        float num2 = Float.parseFloat(digits[1]);
        float res = num1 + num2;
        return Float.toString(res);
    }

    public String Sub(String[] digits){
        float num1 = Float.parseFloat(digits[0]);
        float num2 = Float.parseFloat(digits[1]);
        float res = num2 - num1;
        return Float.toString(res);
    }

    public String Mult(String[] digits){
        float num1 = Float.parseFloat(digits[0]);
        float num2 = Float.parseFloat(digits[1]);
        float res = num2 * num1;
        return Float.toString(res);
    }

    public String Div(String[] digits){
        float num1 = Float.parseFloat(digits[0]);
        float num2 = Float.parseFloat(digits[1]);
        float res = num2 / num1;
        return Float.toString(res);
    }

    public String Sqrt(String[] digits){
        float num1 = Float.parseFloat(digits[0]);
        double res = Math.sqrt(num1);
        return Double.toString(res);
    }
}
