package org.zerock.MapperTests;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardMapper;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {org.zerock.config.RootConfig.class})
@Slf4j
public class BoardMapperTests {
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
//	@Test
	public void testExist() {
		assertNotNull(mapper);
		
		log.info("mapper : " + mapper);
	}
	
//	@Test
	public void tesGetList() {
		mapper.getList().forEach(board -> log.info(board.toString()));
	}
	
//	@Test
	public void testInsert() {
		BoardVO board = new BoardVO();
		board.setTitle("NEW TITLE");
		board.setContent("NEW CONTENT");
		board.setWriter("NEWBIE");
		
		mapper.insert(board);
		
		log.info(board.toString());
	}
	
//	@Test
	public void testInsertSelectKey() {
		BoardVO board = new BoardVO();
		board.setTitle("NEW TITLE SELECT KEY");
		board.setContent("NEW CONTENT SELECT KEY");
		board.setWriter("NEWBIE");
		
		mapper.insertSelectKey(board);
		
		log.info(board.toString());
	}
	
//	@Test
	public void testRead() {
		BoardVO board = mapper.read(7L);
		
		log.info(board.toString());
	}
	
//	@Test
	public void testDelete() {
		log.info("DELETE COUNT: " + mapper.delete(2L));
	}
	
//	@Test
	public void testUpdate() {
		BoardVO board = new BoardVO();
		
		board.setBno(3L);
		board.setTitle("UPDATE TITLE");
		board.setContent("UPDATE CONTENT");
		board.setWriter("UPDATE NEWBIE");
		
		int count = mapper.update(board);
		log.info("UPDATE COUNT: " + count);
	}
	
	@Test
	public void testPaging() {
		Criteria cri = new Criteria();
		cri.setPageNum(3);
		cri.setAmount(10);
		
		List<BoardVO> list = mapper.getListWithPaging(cri);
		
		list.forEach(board -> log.info(board.toString()));
	}
}
