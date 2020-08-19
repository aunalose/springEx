package org.zerock.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {
//클래스 용도: pageNum과 amount 값을 같이 전달하는 용도

	
	private int pageNum; 	//페이지 번호
	private int amount; 	//한 페이지당 뿌릴 데이터
	
	//생성자를 통해서 기본값 1페이지, 10개씩으로 지정해서 처리
	public Criteria() {
		this(1,10);
	}
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	
}
