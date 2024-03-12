package org.zerock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")//*는 모든걸 받겠다는 뜻이다.
@AllArgsConstructor //생성자 자동 주입
public class BoardController {

  @Autowired
  private BoardService service; //서비스와 연결
  
  @GetMapping("/list")
  public void list(Model model) { 
   /* Model(객체)
      ModelAndView -> mav (객체+경로)  / 옛날방식*/
    
    log.info("list");
    
    //addAttribute(앞, 뒤) -> 뒤 값을 앞에 입력 / .jsp파일에 출력할 내용을 앞(이름)에 입력
    model.addAttribute("list", service.getList());
  }
  
  @PostMapping("/register") //등록처리
  public String register(BoardVO board, RedirectAttributes rttr) {
    
    log.info("register: " + board);
    
    service.register(board);
    
    rttr.addFlashAttribute("result", board.getBno());
    
    return "redirect:/board/list";
  }
  
}





