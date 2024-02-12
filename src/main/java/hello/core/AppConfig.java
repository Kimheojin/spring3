package hello.core;


import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountePolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//구현 객체를 생성


//Bean이름은 항상 다른 것을 부여해야 한다
@Configuration
public class AppConfig {
//    설정정보

    //di 컨테이너 라고 한다

    //control alt m 하면 만들어 준다
//    분리 하는게 중요한듯

//    다 springcontainer에 등록이 된다.


    //(name 으로 이름 변경하다) Bean annotation 이용해서
    //반환 역할
    @Bean
    public MemoryMemberRepository memberRepository() {
    return new MemoryMemberRepository();
    }

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }



    // injection 주입
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(),discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountePolicy();
    }


}
