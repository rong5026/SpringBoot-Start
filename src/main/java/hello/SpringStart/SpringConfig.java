package hello.SpringStart;

import hello.SpringStart.repository.MemberRepository;
import hello.SpringStart.repository.MemoryMemberRepository;
import hello.SpringStart.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// bean에 따로 등록하는 방법
@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
