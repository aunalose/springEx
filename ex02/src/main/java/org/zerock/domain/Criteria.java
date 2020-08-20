package org.zerock.domain;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class Criteria {
	private int pageNum;  // 현재 페이지 번호
	private int amount;     // 한 페이지 출력할 게시글 수
	
	private String type;
	private String keyword;
	
	public Criteria() {
		this(1, 10);
	}

	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	// 메소드 사용처 ? 
	// 동적 SQL       foreach      collection="map"
	// TWC 이렇게 넘어오는거 자를려고
	public String[] getTypeArr() {
		return type == null ? new String [] {} : type.split("");
	}
	
	public String getListLink() {
		UriComponentsBuilder builder= UriComponentsBuilder.fromPath("")
				.queryParam("pageNum", this.pageNum)
				.queryParam("amount", this.getAmount())
				.queryParam("type", this.getType())
				.queryParam("keyword", this.getKeyword());
		
		return builder.toUriString();
	}
	
	
}//class





