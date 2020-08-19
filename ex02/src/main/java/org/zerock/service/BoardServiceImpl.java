package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;


@Log4j
@Service
@AllArgsConstructor //紐⑤뱺 �씤�옄瑜� 媛�吏��뒗 �깮�꽦�옄 - hier: mapper諛뽰뿉 �뾾�쓬
public class BoardServiceImpl implements BoardService {
	
	
	//boardmapper�뒗 dao�뿭�븷�엫.
	//spring 4.3 �씠�긽�뿉�꽌 �옄�룞泥섎━ 
	//@Autowired
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	@Override
	public void register(BoardVO board) {
		log.info("register....." + board);
		mapper.insertSelectKey(board);
	}

	
	@Override
	public BoardVO get(Long bno) {
		log.info("get....." + bno);
		return mapper.read(bno);
	}
	
	
	@Override
	public List<BoardVO> getList(Criteria cri){
		log.info("get List with criteria: "+cri);
		return mapper.getListWithPaging(cri);
		
	}
	
	@Override
	public boolean modify(BoardVO board) {
		log.info("modify..."+board);
		return mapper.update(board)==1;
	}

	@Override
	public boolean remove(Long bno) {
		log.info("remove..."+bno);
		return mapper.delete(bno)==1;
	}

	/*
	@Override
	public List<BoardVO> getList() {
	log.info("getList....");
		return mapper.getList();
	}
	*/


	

}
