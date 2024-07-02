package com.lbw.springjpapractices.global.properties;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

@Slf4j
@RequiredArgsConstructor
public class SamplePropertiesRunner implements ApplicationRunner {
    // configurationProperties를 이용하여 POJO 객체를 활용
    private final SampleProperties properties;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        final String email = properties.getEmail();
        final String nickname = properties.getNickname();
        final int age = properties.getAge();
        final boolean auth = properties.isAuth();
        final double amount = properties.getAmount();

        log.info("==================");
        log.info(email); // yun@test.com
        log.info(nickname); // yun
        log.info(String.valueOf(age)); // 27
        log.info(String.valueOf(auth)); // true
        log.info(String.valueOf(amount)); // 100.0
        log.info("==================");
    }
}
