import java.util.Scanner;

public class test{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1, num2;
        double total;
        char operator;
        char retry = 'Y';
        System.out.println("======게임 시작=====");
        while(retry == 'Y') {
            total = 0;
            System.out.println("피연산자 연산자 피연산자 순으로 입력하시오.");
            num1 = sc.nextInt();
            operator = sc.next().charAt(0);
            num2 = sc.nextInt();
            switch (operator) {
                case '+':
                    total = num1 + num2;
                    break;
                case '-':
                    total = num1 - num2;
                    break;
                case '*':
                    total = num1 * num2;
                    break;
                case '/':
                    if(num2 == 0){
                        System.out.println("0으로 나눌 수 없습니다. 다시 시도하십시오.");
                        break;
                    }
                    total = (double) num1 / num2;
                    break;
                default:
                    System.out.println("잘못된 연산자입니다. 다시 시도하십시오.");
                    break;
            }
            System.out.println("계산 결과 : " + total + "입니다.");
            System.out.println("다시 하려면 Y, 종료는 N을 입력하시오.");
            retry = sc.next().charAt(0);
        }
    }
}