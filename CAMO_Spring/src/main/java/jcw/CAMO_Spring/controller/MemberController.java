package jcw.CAMO_Spring.controller;

import jcw.CAMO_Spring.domain.Member;
import jcw.CAMO_Spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class MemberController {
    private MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    /**
     * 메인 홈
     * @return Member
     */
    @GetMapping("/")
    public Member main() {
        Member member = new Member();
        member.setName("지찬우");
        member.setPassword("jcw1530");
        member.setEmail("jcw001031@gmail.com");
        memberService.join(member);

        member = new Member();
        member.setName("김민수");
        member.setPassword("12341234");
        member.setEmail("kimkim@naver.com");
        memberService.join(member);

        member = new Member();
        member.setName("박지수");
        member.setPassword("asdf@1234");
        member.setEmail("park1234@gmail.com");
        memberService.join(member);

        member = new Member();
        member.setName("엄준식");
        member.setPassword("Ummumm");
        member.setEmail("umm1234@naver.com");
        memberService.join(member);
        return member;
    }

    /**
     * 모든 회원 리스트
     * @return
     */
    @GetMapping("/member/all")
    public List<Member> getAllMember(){
        return memberService.findAll();
    }

    /**
     * email로 검색
     * @param email
     * @return
     */
    @GetMapping("/member/searchByEmail/{email}")
    public Member getMember(@PathVariable("email") String email){
        Optional<Member> member = memberService.findOneByEamil(email);
        return member.get();
    }

    /**
     * id로 검색
     * @param id
     * @return
     */
    @GetMapping("/member/searchById/{id}")
    public Member getMember(@PathVariable("id") Long id){
        Optional<Member> member = memberService.findOneById(id);
        return member.get();
    }

    /**
     * 회원 탈퇴
     * @param id
     * @return boolean
     */
    @GetMapping("/member/delete/{id}")
    public boolean delete(Long id){
        Optional<Member> member = memberService.findOneById(id);
        memberService.delete(member.get());
        return true;
    }
}