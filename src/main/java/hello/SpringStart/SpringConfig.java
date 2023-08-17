package hello.SpringStart;

import hello.SpringStart.repository.JdbcMemberRepository;
import hello.SpringStart.repository.MemberRepository;
import hello.SpringStart.repository.MemoryMemberRepository;
import hello.SpringStart.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

// bean에 따로 등록하는 방법
@Configuration
public class SpringConfig {

    DataSource dataSource;
    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
        return new JdbcMemberRepository(dataSource);
    }

}
