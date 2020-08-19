package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardService {

	//湲� �벐湲�
	public void register(BoardVO board);
	
	//�듅�젙�븳 寃뚯떆臾쇱쓣 媛��졇�삤�뒗 硫붿꽌�뱶
	public BoardVO get(Long bno);
	
	//湲� �닔�젙�븯湲�
	public boolean modify(BoardVO board);
	
	//湲� �궘�젣�븯湲�
	public boolean remove(Long bno);
	
	//�쟾泥� 由ъ뒪�듃 媛��졇�삤�뒗 硫붿꽌�뱶
	//public List<BoardVO> getList();
	
	public List<BoardVO> getList(Criteria cri);
}
