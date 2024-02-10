package hello.core.member;

public class Member {


    //    속성 3가지
//    https://thalals.tistory.com/279
//    getter setter 사용하는 이유
//    setter을 이용해 저장하고 getter로 출력한다
    private Long id;
    private String name;
    private Grade grade;

    public Member(Long id, String name, Grade grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }
    //저장 역할
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
    //출력하는 역할

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Grade getGrade() {
        return grade;
    }
}
