import java.util.Scanner;
import java.util.ArrayList;

class Student {
    public String name = "";
    public int age = 0;
    public String num = "";

    void setName(String name){
        this.name = name;
    }

    void setAge(int age){
        this.age = age;
    }

    void setNum(String num){
        this.num = num;
    }

    void showInfo() {
        System.out.println(name + " " + age +" " + num);
    }
}


public class test2 {
    static Scanner sc = new Scanner(System.in);
    static Student[] arr = new Student[100];
    static int count = 0;

    static void addStudent(){
        Student s = new Student();

        System.out.println("이름 : ");
        String inputname = sc.next();
        s.name = inputname;

        System.out.println("나이 : ");
        int age = sc.nextInt();
        s.age = age;

        System.out.println("번호 : ");
        String num = sc.next();
        s.num = num;

        arr[count++] = s;

        System.out.println("등록 완료!");
    }

    static void printAll(){
        for(int i = 0; i<count; i++){
            System.out.println((i+1) + "번째 학생 정보");
            arr[i].showInfo();
        }
    }

    static void updateStudent(){
        System.out.println("수정할 인덱스를 입력하시오 :");
        int idx = sc.nextInt();

        if(idx < 0 || idx >=count){
            System.out.println("잘못된 index");
            return;
        }
        System.out.println("새 이름 : ");
        arr[idx].name = sc.next();
        System.out.println("새 나이 : ");
        arr[idx].age = sc.nextInt();
        System.out.println("새 번호 : ");
        arr[idx].num = sc.next();

        System.out.println("수정 완료!");
    }

    static void deleteStudent(){
        System.out.println("삭제할 인덱스를 입력하시오 : ");
        int idx = sc.nextInt();

        if(idx < 0 || idx >=count){
            System.out.println("잘못된 index");
            return;
        }
        for(int i = idx; i<count; i++){
            arr[i] = arr[i+1];
        }

        count--;

        System.out.println("삭제 완료!");
    }



    public static void main(String[] args) {
        while(true){
            System.out.println("\n1.등록 2.출력 3.수정 4.삭제 5.종료");
            int menu = sc.nextInt();

            if(menu==1) addStudent();
            else if(menu==2) printAll();
            else if(menu==3) updateStudent();
            else if(menu==4) deleteStudent();
            else break;

        }


    }
}