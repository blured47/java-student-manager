import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

class Student3 {
    private String name = "";
    private int age = 0;
    private String num = "";

    void setName(String name){
        this.name = name;
    }

    void setAge(int age){
        if(age<0)
            return;
        this.age = age;
    }

    void setNum(String num){
        this.num = num;
    }

    String getName(){
        return name;
    }

    int getAge(){
        return age;
    }

    String getNum(){
        return num;
    }

    void showInfo() {
        System.out.println("이름 : " + name + " 나이 : " + age +" 번호 : " + num);
    }
}


class ManageStudent {
    List<Student3> list = new ArrayList<>();
    Scanner sc;

    ManageStudent(Scanner sc){
        this.sc = sc;
    }

    void addStudent(){
        Student3 s = new Student3();

        System.out.println("이름 : ");
        String inputName = sc.nextLine();
        s.setName(inputName);

        System.out.println("나이 : ");
        int inputAge = Integer.parseInt(sc.nextLine());
        //Integer.parseInt(String "12345") -> "12345"를 정수형 12345로 바꿔줌.
        //Integer.parseInt(String "1004", 8 or 16) -> 8진수 or 16진수 "12345"를 10진수 or 4100으로 바꿔줌.
        s.setAge(inputAge);

        System.out.println("번호 : ");
        String inputNum = sc.nextLine();
        s.setNum(inputNum);

        list.add(s);

        System.out.println("등록 완료!");
    }

    void printAll(){
        for(Student3 s : list)  // list[0]부터 끝까지 하나씩 s에 넣어 반복문 돌리기. 전체 출력 시 코드 단순화 장점
            s.showInfo();
    }

    void updateStudent(){
        System.out.println("수정할 인덱스를 입력하시오 :");
        int editIndex = Integer.parseInt(sc.nextLine());
        if((editIndex < 0) || editIndex >= list.size()) {
            System.out.println("잘못된 index");
            return;
        }
        else {
            System.out.println("새 이름 : ");
            list.get(editIndex).setName(sc.nextLine());
            System.out.println("새 나이 : ");
            list.get(editIndex).setAge(Integer.parseInt(sc.nextLine()));
            System.out.println("새 번호 : ");
            list.get(editIndex).setNum(sc.nextLine());
        }
        System.out.println("수정 완료!");
    }

    void updateStudentByName(){
        System.out.println("수정할 학생의 이름을 입력하세요.");
        String updateName = sc.nextLine();
        boolean found = false;
        for(int updateIndex=0; updateIndex<list.size(); updateIndex++){
            if(list.get(updateIndex).getName().equals(updateName)){
                found = true;
                list.get(updateIndex).showInfo();
                System.out.println("새 이름 : ");
                list.get(updateIndex).setName(sc.nextLine());
                System.out.println("새 나이 : ");
                list.get(updateIndex).setAge(Integer.parseInt(sc.nextLine()));
                System.out.println("새 번호 : ");
                list.get(updateIndex).setNum(sc.nextLine());
            }
        }
        if(found){
            System.out.println("수정 완료!");
        }
        else System.out.println("해당 이름의 학생을 찾을 수 없습니다.");
    }

    void deleteStudent(){
        System.out.println("삭제할 인덱스를 입력하시오 : ");
        int deleteIndex = Integer.parseInt(sc.nextLine());

        if(deleteIndex < 0 || deleteIndex >= list.size()){
            System.out.println("잘못된 index");
            return;
        }

        else list.remove(deleteIndex);

        System.out.println("삭제 완료!");
    }

    void deleteStudentByName(){
        System.out.println("삭제할 이름을 입력하시오 : ");
        String deleteName = sc.nextLine();
        boolean ending = false;
        for(int i = 0; i<list.size(); i++){
            if(list.get(i).getName().equals(deleteName)){
                ending = true;
                list.remove(i);
                i--; // 삭제된 인덱스가 있기에 i값을 줄여 건너뛰는 인덱스가 없도록 함. 입력값과 같은 모든 이름의 학생을 삭제시키는 코드.
            }
        }
        if(ending){
            System.out.println("삭제되었습니다!");
        }
        else System.out.println("해당 이름의 학생이 없습니다.");
    }

    void searchStudent() {
        System.out.println("1.이름 2.나이 3.번호 중 무엇으로 찾으시겠습니까? 1,2,3 중 입력해주세요.");
        int tmp = Integer.parseInt(sc.nextLine());
        boolean found = false;

        switch (tmp) {
            case 1:
                System.out.println("이름을 입력하세요 : ");
                String targetName = sc.nextLine();

                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getName().equals(targetName)) {
                        System.out.println("찾았습니다!");
                        System.out.println((i + 1) + "번째 학생의 정보");
                        list.get(i).showInfo();
                        found = true;
                    }
                }
                break;

            case 2:
                System.out.println("나이를 입력하세요 : ");
                int targetAge = Integer.parseInt(sc.nextLine());
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getAge() == targetAge) {
                        System.out.println("찾았습니다!");
                        System.out.println((i + 1) + "번째 학생의 정보");
                        list.get(i).showInfo();
                        found = true;
                    }
                }
                break;

            case 3:
                System.out.println("번호를 입력하세요 : ");
                String targetNum = sc.nextLine();
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getNum().equals(targetNum)) {
                        System.out.println("찾았습니다!");
                        System.out.println((i + 1) + "번째 학생의 정보");
                        list.get(i).showInfo();
                        found = true;
                    }
                }
                break;

            default:
                System.out.println("잘못 입력하였습니다.");
                break;
        }
        if (!found)  System.out.println("해당 없음.");
    }

    void searchStudentByName(){
        System.out.println("이름을 입력하시오.");
        boolean found = false;
        String targetName = sc.nextLine();
        for(int i = 0; i<list.size(); i++){
            if(list.get(i).getName().contains(targetName)){
                found = true;
                System.out.println((i+1) + "번째 학생의 정보");
                list.get(i).showInfo();
            }
        }
        if(!found) System.out.println("해당 이름을 가진 학생이 없습니다.");
    }
}


public class test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ManageStudent ms = new ManageStudent(sc);

        while(true){
            System.out.println("\n1.등록 2.출력 3.수정 4.삭제 5.검색 6. 종료");
            int menu = Integer.parseInt(sc.nextLine());

            switch (menu){
                case 1:
                    ms.addStudent();
                    break;

                case 2:
                    ms.printAll();
                    break;

                case 3:
                    ms.updateStudentByName();
                    break;

                case 4:
                    ms.deleteStudentByName();
                    break;

                case 5:
                    ms.searchStudentByName();
                    break;

                default:
                    return;
            }
        }
    }
}
