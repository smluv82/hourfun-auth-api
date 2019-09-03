package com.hourfun.auth.test.jasypt;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JasyptTests {
    @Resource
    private StandardPBEStringEncryptor jasyptStringEncryptor;

    @Test
    public void 암복호화_테스트() throws Exception {
        String encText = jasyptStringEncryptor.encrypt("jwtsignkey");
        String decText = jasyptStringEncryptor.decrypt(encText);

        System.out.println("encText : " + encText);
        System.out.println("decText : " + decText);
    }
}
