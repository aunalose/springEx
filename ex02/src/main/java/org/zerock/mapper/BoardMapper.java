package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardMapper {

	//@Select("select* from tbl_board where bno>0 ")
	public List<BoardVO> getList();
	
	public List<BoardVO> getListWithPaging(Criteria cri);
	
	//insert留� 泥섎━�릺怨� �깮�꽦�맂 PK 媛믪쓣 �븣 �븘�슂媛� �뾾�뒗 寃쎌슦
	public void insert(BoardVO board);
	
	//insert臾몄씠 �떎�뻾�릺怨� �깮�꽦�맂 PK 媛믪쓣 �븣�븘�빞 �븯�뒗 寃쎌슦
	public void insertSelectKey(BoardVO board);
	
	//read 泥섎━
	public BoardVO read(Long bno);
	
	//delete 泥섎━
	public int delete(Long bno);
	
	//update 泥섎━
	public int update(BoardVO board);
	
	public int getTotalCount(Criteria cri);
}
