import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class ManageStudent {

    // 학생정보 저장공간
    List<Student> list = new ArrayList<>();
    Scanner sc;

    // main에서 사용하는 스캐너를 그대로 사용하기 위해 생성
    ManageStudent(Scanner sc){
        this.sc = sc;
    }

    // 학생 정보 list 및 student.txt 파일에 저장
    void addStudent(){
        Student s = new Student();

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

        saveFile();

        System.out.println("등록 완료!");
    }

    // 생성자를 사용하여 학생정보 생성과 동시에 값을 넣음 , 번호 중복 체크 추가
    void addStudentUsingConstructor() {
        System.out.println("이름 : ");
        String inputName = sc.nextLine();

        System.out.println("나이 : ");
        int inputAge = Integer.parseInt(sc.nextLine());

        System.out.println("번호 : ");
        String inputNum = sc.nextLine();

        while (true) {
            boolean duplicated = false;

            for (Student s : list) {
                if (s.getNum().equals(inputNum)) {
                    duplicated = true;
                    break;  // 중복 번호 발견 시 for문 탈출
                }
            }

            if (!duplicated) {
                break; // 중복 번호 없을 시 while문 탈출
            }


            //중복 번호 발견 시에만 실행됨
            System.out.println("이미 존재하는 번호입니다.");
            System.out.println("번호를 다시 입력하시오 : ");
            inputNum = sc.nextLine();
        }

        Student s = new Student(inputName, inputAge, inputNum);
        list.add(s);
        saveFile();
        System.out.println("등록 완료!");
    }

    // 학생 정보 출력
    void printAll(){
        for(Student s : list)  // list[0]부터 끝까지 하나씩 s에 넣어 반복문 돌리기. 전체 출력 시 코드 단순화 장점
            s.showInfo();
    }

    //updateStudentByName으로 변경
    void updateStudentByIndex(){
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

    // 이름으로 학생 검색 후 학생정보 변경
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

        saveFile();
    }


    //deleteStudentByName으로 변경
    void deleteStudentByIndex(){
        System.out.println("삭제할 인덱스를 입력하시오 : ");
        int deleteIndex = Integer.parseInt(sc.nextLine());

        if(deleteIndex < 0 || deleteIndex >= list.size()){
            System.out.println("잘못된 index");
            return;
        }

        else list.remove(deleteIndex);

        System.out.println("삭제 완료!");

        saveFile();
    }

    // 이름으로 학생 검색 후 학생정보 삭제
    void deleteStudentByName(){
        System.out.println("삭제할 이름을 입력하시오 : ");
        String deleteName = sc.nextLine();
        boolean ending = false;
        for(int i = 0; i<list.size(); i++){
            if(list.get(i).getName().equals(deleteName)){
                ending = true;
                list.remove(i);
                // 삭제된 인덱스가 있기에 i값을 줄여 건너뛰는 인덱스가 없도록 함.
                // 입력값과 같은 모든 이름의 학생을 삭제시키는 코드.
                i--;
            }
        }
        if(ending){
            System.out.println("삭제되었습니다!");
        }
        else System.out.println("해당 이름의 학생이 없습니다.");

        saveFile();
    }

    //searchStudentByName으로 변경
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

    // 이름으로 학생 검색 후 학생정보 출력, 동명이인 모두 출력 및 contains()를 활용하여 포함값 전체 출력함.
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

    // list에 존재하는 값을 student.txt에 저장
    void saveFile(){
        try {
            FileWriter fw = new FileWriter("student.txt");

            for(Student s : list) {
                fw.write(s.getName() + "," + s.getAge() + "," + s.getNum() + "\n");
            }
            fw.close();
        }
        catch (Exception e){
            System.out.println("파일 저장 실패");
            e.printStackTrace(); //몇번째 줄에서 터졌는지 보여줌
        }
    }

    // student.txt에 있는 정보를 list로 저장
    void loadFile(){
        list.clear();
        try{
            BufferedReader br = new BufferedReader(new FileReader("student.txt"));
            String line;

            while((line=br.readLine()) != null){

                String[] arr = line.split(",");

                Student s = new Student();

                s.setName(arr[0]);
                s.setAge(Integer.parseInt(arr[1]));
                s.setNum(arr[2]);

                list.add(s);
            }

            br.close();
        }
        catch (FileNotFoundException e){
            System.out.println("저장 파일 없음");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    // student.txt에서 긁어올 때 바로 학생정보를 생성자를 이용하여 값까지 list에 저장
    void loadFileUsingConstructor(){
        list.clear();
        try{
            BufferedReader br = new BufferedReader(new FileReader("student.txt"));
            String line;

            while((line=br.readLine()) != null){

                String[] arr = line.split(",");

                Student s = new Student(arr[0], Integer.parseInt(arr[1]), arr[2]);

                list.add(s);
            }

            br.close();
        }
        catch (FileNotFoundException e){
            System.out.println("저장 파일 없음");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
