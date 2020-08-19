package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {
	
	//boardcontroller�뒗 boardservice ���엯�쓽 媛앹껜�� 媛숈씠 �뿰�룞�빐�뼏 �븯誘�濡� �쓽議댁꽦�뿉 ���븳 泥섎━�룄 媛숈씠 吏꾪뻾�븿. �깮�꽦�옄媛� �엳�뼱�빞 �옄�룞�쑝濡� 二쇱엯�맖.
	private BoardService service;
	
	/*
	//p.212
	@GetMapping("/list")
	public void list(Model model) {
		log.info("list");
		model.addAttribute("list", service.getList());
	}
	*/
	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		log.info("list: " +cri);
		model.addAttribute("list", service.getList(cri));
		
	}
	//p.216
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		log.info("register: " + board);
		service.register(board);
		rttr.addFlashAttribute("result",board.getBno());
		return "redirect:/board/list";
	}
	
	//p.239
	@GetMapping("/register")
	public void register() {
		
	}
	//p.218
	@GetMapping({"/get", "/modify"})
	public void get(@RequestParam("bno") Long bno, Model model) {
		log.info("/get or modify");
		model.addAttribute("board", service.get(bno));
	}

	
	//p.219
	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr) {
		log.info("modify: " + board);
		if (service.modify(board)) {
			rttr.addFlashAttribute("result", "success");
			
		}
		return "redirect:/board/list";
	}
	
	//p.221
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
		log.info("remove.." + bno);
		if (service.remove(bno)) {
			rttr.addFlashAttribute("result","success");
		}
		return "redirect:/board/list";
	}
	
	
	
	
	}//class
