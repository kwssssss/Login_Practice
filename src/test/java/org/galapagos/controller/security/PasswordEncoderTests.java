package org.galapagos.controller.security;

import org.galapagos.config.RootConfig;
import org.galapagos.config.SecurityConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
		RootConfig.class,
		SecurityConfig.class
})
@Log4j
public class PasswordEncoderTests {
	@Autowired
	private PasswordEncoder pwEncoder;
	
	@Test
	public void testEncode() {
		String str = "1234";
		
		String enStr = pwEncoder.encode(str); // encode << 암호화하는 메소드
		log.info("passwrod: " + enStr); // salt < 소금을 뿌리듯이 그때그때 랜덤한 값을 더해줌, 실제 비밀번호와 salt(매번 바뀌는 랜덤 요소)하고 같이 묶어서 암호홥니다.
		
		String enStr2 = pwEncoder.encode(str); // encode << 암호화하는 메소드
		log.info("passwrod: " + enStr2);
		
		log.info("match :" + pwEncoder.matches(str, enStr));
		log.info("match :" + pwEncoder.matches(str, enStr2));
		log.info("match :" + pwEncoder.matches(enStr, enStr2));
		
		
	}

}
