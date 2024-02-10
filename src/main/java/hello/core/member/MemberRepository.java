package hello.core.member;

public interface MemberRepository {

    //spring boot interface 역할
    //추상화 매서들을 나열한 형태
    void save(Member member);

    Member findById(Long memberId);
}
