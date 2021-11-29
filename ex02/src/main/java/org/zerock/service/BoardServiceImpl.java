package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {
	// spring 4.3 이상에서 자동 처리
	private BoardMapper mapper;

	@Override
	public void register(BoardVO board) {
		log.info("register: " + board);
		
		mapper.insertSelectKey(board);
	}

	@Override
	public BoardVO get(Long bno) {
		log.info("get: " + bno);
		
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		log.info("modify: " + board);
		
		return mapper.update(board) > 0;
	}

	@Override
	public boolean remove(Long bno) {
		log.info("remove: " + bno);
		return mapper.delete(bno) > 0;
	}

	@Override
	public List<BoardVO> getList() {
		log.info("getList......");
		
		return mapper.getList();
	}
}
