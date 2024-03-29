package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.*;

//제어의 역전 = 프레임 워크가 대신 호출해 준다
//제어권이 뒤바뀐다.
class RateDiscountePolicyTest {
    RateDiscountePolicy discountePolicy = new RateDiscountePolicy();

    @Test
    @DisplayName("VIP는 10프로 할인이 적용되어야 한다")
    void VIPp_o() {
        //given
        Member member = new Member(1L, "memberVIP", Grade.VIP);



        //when
        int discount = discountePolicy.discount(member, 10000);
        assertThat(discount).isEqualTo(1000);
        //then
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다")
    void VIP_x() {
        //given
        Member member = new Member(2L, "memberBasic", Grade.BASIC);



        //when
        int discount = discountePolicy.discount(member, 10000);
        assertThat(discount).isEqualTo(0);
        //then
    }
}