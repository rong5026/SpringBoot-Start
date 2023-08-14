package hello.SpringStart.service;

import hello.SpringStart.domain.Member;
import hello.SpringStart.repository.MemberRepository;
import hello.SpringStart.repository.MemoryMemberRepository;

public class MemberService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    // 회원가입
    public Long join(Member member)
    {
        // 같은 이름이 있는 중복 회원
        memberRepository.save(member);
        return member.getId();
    }
}
