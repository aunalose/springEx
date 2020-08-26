package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/sample/*")
@Controller
public class SampleController {

	//로그인을 하지 않은 사용자도 접근 가능한 URI
	@GetMapping("/all")
	public void doAll() {
		log.info("do all can access everybody");
	}
	//로그인한 사용자들만이 접근할 수 있는 URI
	@GetMapping("/member")
	public void doMember() {
		log.info("logined member");
	}
	//로그인한 사용자들 중에서 관리자 권한을 가진 사용자만이 접근할 수 있는 URI
	@GetMapping("/admin")
	public void doAdmin() {
		log.info("admin only");
	}
}
