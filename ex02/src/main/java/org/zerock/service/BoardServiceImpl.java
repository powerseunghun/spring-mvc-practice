package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class BoardServiceImpl implements BoardService {
	// AllArgsConstructor로 주입
	private BoardMapper mapper;
	
	@Override
	public void register(BoardVO board) {
		log.info("register: " + board);
		
		mapper.insertSelectKey(board);
	}

	@Override
	public BoardVO get(Long bno) {
		log.info("GET: " + bno);
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {	
		log.info("MODIFY: " + board);
		return mapper.update(board) > 0;
	}

	@Override
	public boolean remove(Long bno) {
		log.info("REMOVE: " + bno);
		return mapper.delete(bno) > 0;
	}

	@Override
	public List<BoardVO> getList() {
		log.info("GET LIST");
		
		return mapper.getList();
	}
	
}
