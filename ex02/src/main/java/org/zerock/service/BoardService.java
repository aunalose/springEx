package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;

public interface BoardService {

	//글 쓰기
	public void register(BoardVO board);
	
	//특정한 게시물을 가져오는 메서드
	public BoardVO get(Long bno);
	
	//글 수정하기
	public boolean modify(BoardVO board);
	
	//글 삭제하기
	public boolean remove(Long bno);
	
	//전체 리스트 가져오는 메서드
	public List<BoardVO> getList();
}
