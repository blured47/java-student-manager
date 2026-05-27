package Calculator;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator cal = new Calculator();

        String tmp = "";
        do {
            System.out.println("=======프로그램 시작========");

            System.out.println("피연산자 연산자 피연산자 순으로 입력해주세요.");
            cal.setNum1(sc.nextInt());
            cal.setOperator(sc.next().charAt(0));
            cal.setNum2(sc.nextInt());
            System.out.println("계산 결과 : "+ cal.calculator());

            System.out.println("계속은 아무 키, 종료는 \"exit\"을 쳐주세요");
            tmp = sc.next();
        }while (!tmp.equals("exit"));

    }
}

