package com.doorloop.zwolle;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class ZwolleApplicationTests {

	@Test
	void contextLoads() {
		int a = 3;
		int b = 5;
		Assert.isTrue(a==b);
	}

}
