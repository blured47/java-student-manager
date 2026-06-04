public class Student {
    // private으로 하는 이유 : 다른 코드 속에서 값을 강제로 못 바꾸게 하기 위해서
    // -> setter, getter로 값 사용함.
    private String name = "";
    private int age = 0;
    private String num = "";

    Student(){}

    // 생성자 사용하여 바로 이름 나이 번호 입력
    Student(String name, int age, String num){
        this.name = name;
        this.age = age;
        this.num = num;
    }

    //setter
    // 이름 저장
    void setName(String name){
        this.name = name;
    }

    // 나이 저장
    void setAge(int age){
        if(age<0)
            return;
        this.age = age;
    }

    // 번호 저장
    void setNum(String num){
        this.num = num;
    }

    //getter
    // 이름 사용
    String getName(){
        return name;
    }

    // 나이 사용
    int getAge(){
        return age;
    }

    // 번호 사용
    String getNum(){
        return num;
    }

    //학생 정보 출력
    void showInfo() {
        System.out.println("이름 : " + name + " 나이 : " + age +" 번호 : " + num);
    }
}
