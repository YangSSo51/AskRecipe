package org.kpu.myweb.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kpu.myweb.domain.UserVO;
import org.kpu.myweb.persistence.UserDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class UserDAOTest {

	@Autowired
	private UserDAO dao;
	private static Logger logger = LoggerFactory.getLogger(UserDAOTest.class);
	
	@Test
	public void testReadByid() throws Exception {
		UserVO vo;
		vo = dao.read("so");

		logger.info(vo.toString());
	}
	@Test
	public void testReadList() throws Exception {
		List<UserVO> voList;
		voList = dao.readList();

		for(UserVO svo : voList) {
			logger.info(svo.toString());
		}
	}
}
