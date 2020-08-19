package org.zerock.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {

	@Setter(onMethod_ = @Autowired )
	private BoardMapper mapper;
	
	@Test
	public void testGetList() {
		mapper.getList().forEach(board -> log.info(board));
	}
	
	@Test
	public void testPaging() {
		Criteria cri = new Criteria();
		//10개씩 3페이지
		cri.setPageNum(3);
		cri.setAmount(10);
		List<BoardVO> list =mapper.getListWithPaging(cri);
		list.forEach(board -> log.info(board.getBno()));
	}
	
	
	@Test
	public void testInsert() {
		BoardVO board = new BoardVO();
		board.setTitle("�깉濡� �옉�꽦�븯�뒗 湲�");
		board.setContent("�깉濡� �옉�꽦�븯�뒗 �궡�슜");
		board.setWriter("newbie");
		mapper.insert(board);
		log.info(board); //lombok�쓽 tostring()�쑝濡� bno �씤�뒪�꽩�뒪 蹂��닔 媛믪쓣 �븣�븘蹂대젮怨� log李띿쓬.
	}
	
	@Test
	public void testInsertSelectKey() {
		
		BoardVO board = new BoardVO();
		board.setTitle("�깉濡� �옉�꽦�븯�뒗 湲� select key");
		board.setContent("�깉濡� �옉�꽦�븯�뒗 �궡�슜 select key");
		board.setWriter("newbie");
		mapper.insertSelectKey(board);
		log.info(board);
		
	}
	
	@Test
	public void testRead() {
		//議댁옱�븯�뒗 寃뚯떆臾� 踰덊샇濡� �뀒�뒪�듃
		BoardVO board= mapper.read(5L); //long �삎�씪 �뻹 L sequence踰덊샇 5 5+ L =5L
		log.info(board);
	}
	
	@Test
	public void testDelete() {
		log.info("DELETE COUNT: " + mapper.delete(3L));
		
	}
	
	@Test
	public void testUpdate() {
		
		BoardVO board = new BoardVO();
		//�떎�뻾 �쟾 議댁옱�븯�뒗 踰덊샇�씤吏� �솗�씤
		board.setBno(5L);
		board.setTitle("�닔�젙�맂 �젣紐�");
		board.setContent("�닔�젙�맂 �궡�슜");
		board.setWriter("user00");
		
		int count = mapper.update(board);
		log.info("UPDATE COUNT: " +count);
	}
}
