package me.jaden.springstudy.transaction;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InnerService {

    private final MemberRepository memberRepository;

    @Transactional
    public void makeNameUpper(Long id) {
        Optional<Member> targetMember = memberRepository.findById(id);
        targetMember.ifPresent(member -> member.makeNameUpper());
        throw new RuntimeException();
    }
}
