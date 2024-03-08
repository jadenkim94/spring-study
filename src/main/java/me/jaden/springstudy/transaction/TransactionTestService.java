package me.jaden.springstudy.transaction;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransactionTestService {

    private final MemberRepository memberRepository;
    private final InnerService innerService;

    @Transactional
    public void createMember(String name) {
        Member newMember = Member.of(name);
        memberRepository.save(newMember);
        try {
            innerService.makeNameUpper(newMember.getId());
        } catch (RuntimeException e) {
            log.info("just do it");
        }
    }

}
