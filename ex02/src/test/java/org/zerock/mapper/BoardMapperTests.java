package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.CommandLinePropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {org.zerock.config.RootConfig.class})
@Slf4j
public class BoardMapperTests {
//	@Autowired
	@Setter(onMethod_ = {@Autowired})
	private BoardMapper mapper;
	
//	@Test
	public void autowiredTest() {
		log.info("mapper is : " + mapper + "");
	}
	
//	@Test
	public void testGetList() {
		mapper.getList().forEach(board -> log.info(board + ""));
	}
	
//	@Test
	public void testInsert() {
		BoardVO board = new BoardVO();
		board.setTitle("New Title");
		board.setContent("New Content");
		board.setWriter("newbie");
		
		mapper.insert(board);
		log.info(board+"");
	}
	
//	@Test
	public void testInsertSelectKey() {
		BoardVO board = new BoardVO();
		board.setTitle("New Title SelectKey");
		board.setContent("New Content SelectKey");
		board.setWriter("newbie");
		
		mapper.insertSelectKey(board);
		log.info(board+"");
	}
	
	@Test
	public void testRead() {
		BoardVO board = mapper.read(7L);
		
		log.info(board + "");
	}
}
