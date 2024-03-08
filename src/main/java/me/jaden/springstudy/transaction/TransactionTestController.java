package me.jaden.springstudy.transaction;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TransactionTestController {

    private final TransactionTestService service;

    @PostMapping("/transaction/test")
    public void transactionTest(@RequestParam String name) {
        service.createMember(name);
    }
}
