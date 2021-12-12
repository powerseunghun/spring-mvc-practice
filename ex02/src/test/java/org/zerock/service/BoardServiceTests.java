package org.zerock.service;

import static org.junit.Assert.assertNotNull;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {org.zerock.config.RootConfig.class})
@Slf4j
public class BoardServiceTests {
	@Setter(onMethod_ = @Autowired)
	private BoardService service;
	
//	@Test
	public void testExist() {
		assertNotNull(service);
		
		log.info("service: " + service);
	}
	
//	@Test
	public void testRegister() {
		BoardVO board = new BoardVO();
		board.setTitle("NEW TITLE SERVICE TESTS");
		board.setContent("NEW CONTENT SERVIC TESTS");
		board.setWriter("NEWBIE");
		
		service.register(board);
		
		log.info("CREATE BOARD BNO: " + board.getBno());
	}
	
//	@Test
	public void testGetList() {
		service.getList(new Criteria(2, 10)).forEach(board -> log.info(board.toString()));
	}
	
//	@Test
	public void testGet() {
		log.info(service.get(8L).toString());
	}
	
//	@Test
	public void testUpdate() {
		BoardVO board = service.get(1L);
		
		if (board == null) return;
		
		board.setTitle("UPDATE BOARD SERVICE TESTS");
		log.info("MODIFY RESULT: " + service.modify(board));
	}
	
//	@Test
	public void testDelete() {
		log.info("REMOVE RESULT: " + service.remove(4L));
	}
}
