package hello.core.beanfind;


import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

//junit 5부터는 public 지워도 상관 없다
class ApplicationContextBasicfindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);


    //Assertion에 대한 설명
//    https://effortguy.tistory.com/123
    @Test
    @DisplayName("빈 이름 조회")
    void findBeanByName() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        System.out.println("memberService = " + memberService);
        System.out.println("memberService.getClass() = " + memberService.getClass());

        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    //이름 없이 타입으로 조회
    @Test
    @DisplayName("빈 이름없이 타입으로만 조회")
    void findBeanBytype() {
        //인터페이스로 하면 구현체가 대상이 된다
        //이름을 빼도 상관 없음
        MemberService memberService = ac.getBean(MemberService.class);


        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByName2() {
        MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);


        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
    //항상 test는 실패 테스트도 반들어 보기

    @Test
    @DisplayName(" 빈 이름으로 조회 X")
    void findBeanByNameX() {
        //ac.get

        org.junit.jupiter.api.Assertions.assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("XXXX", MemberService.class));
    }
}
