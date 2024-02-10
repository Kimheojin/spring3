package hello.core.member;

public class MemberServiceImpl implements MemberService{

//    인터페이스만 만들면 null그거 생겨서 구현체 지정 필요
    private final MemberRepository memberRepository = new MemoryMemberRepository();

//    회원가입
    @Override
    public void join(Member member) {
        memberRepository.save(member);

    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
