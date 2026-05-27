package Calculator;

public class Calculator {
    private double num1;
    private double num2;
    private char operator;

    public Calculator(){
        this.num1 = 0;
        this.num2 = 0;
        this.operator = ' ';
    }

    public double getNum1(){
        return num1;
    }

    public double setNum1(double num1){
        this.num1 = num1;
        return num1;
    }

    public double getNum2(){
        return num2;
    }

    public double setNum2(double num2){
        this.num2 = num2;
        return num2;
    }

    public double getOperator(){
        return operator;
    }

    public double setOperator(char operator){
        this.operator = operator;
        return  operator;
    }

    public double calculator(){
        double result = 0;

        switch (operator){
            case'+' :
                result = num1 + num2;
                break;
            case'-' :
                result = num1 - num2;
                break;
            case'*' :
                result = num1 * num2;
                break;
            case'/' :
                result = num1 / num2;
                break;
            default:
                System.out.println("잘못 입력하셨습니다.");
                break;
        }

        return result;
    }
}