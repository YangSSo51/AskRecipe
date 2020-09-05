package org.kpu.myweb.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kpu.myweb.domain.RecipeVO;
import org.kpu.myweb.domain.SearchVO;
import org.kpu.myweb.domain.UserVO;
import org.kpu.myweb.persistence.RecipeDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class RecipeDAOTest {

	@Autowired
	private RecipeDAO dao;
	private static Logger logger = LoggerFactory.getLogger(RecipeDAOTest.class);
	
	@Test
	public void testReadList() throws Exception {
		List<RecipeVO> voList;
		voList = dao.readList();

		for(RecipeVO svo : voList) {
			logger.info(svo.toString());
		}
	}

}
