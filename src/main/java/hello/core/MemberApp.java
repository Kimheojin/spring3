package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    //test용
//    psvm치고 enter치면 자동으로 나옴
    public static void main(String[] args) {

 //       AppConfig appConfig = new AppConfig();
        //이렇게 memberservice를 꺼낸다
    //    MemberService memberService = appConfig.memberService();

//      아까 bean으로 했던 모든것을 관리해 주는 역할(spring에서만 사용하는듯)

        //applicationcontext를 보통 spring container 라고 한다
        //applicationContext는 인터페이스이다
        //다형성이 적용되어 있다
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        //spring container은 xml 기반으로 만들 수 있고 애노테이션 가반의 자바 설정 클래스로도 만들 수 있다.

        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        //첫번째 꺼는 spring Bean안에 있는 이름이랑 맞춰주기.
//        두번째꺼는 타입

        Member member = new Member(1L, "memberA", Grade.VIP);
        //회원가입
        memberService.join(member);

        //soutv 개꿀팁인듯

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());

        //이건 한계가 있다

    }
}
