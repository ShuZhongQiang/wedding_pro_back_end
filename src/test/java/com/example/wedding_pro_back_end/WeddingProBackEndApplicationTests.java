package com.example.wedding_pro_back_end;

import com.example.wedding_pro_back_end.bean.vo.TestVo;
import com.example.wedding_pro_back_end.mapper.TestMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WeddingProBackEndApplicationTests {

	@Autowired(required = false)
	private TestMapper testMapper;
	@Test
	void contextLoads() {
		for (TestVo testVo: testMapper.selectList(null)) {
			System.out.println(testVo.toString());
		}
	}

}
