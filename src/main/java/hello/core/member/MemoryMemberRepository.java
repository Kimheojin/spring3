package hello.core.member;

import java.util.HashMap;
import java.util.Map;


public class MemoryMemberRepository implements MemberRepository {
//데이터 그거 확정 안되어서 이렇게 만들었음
    //실무에선 concurrent hashmap을 사용한다.
    private static Map<Long, Member> store = new HashMap<>();
    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
