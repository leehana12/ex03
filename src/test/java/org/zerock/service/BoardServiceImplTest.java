package org.zerock.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceImplTest {

  @Autowired
  private BoardService service;
  
  @Test
  public void testExist() {
    
    log.info(service);
    assertNotNull(service); //존재유무 체크
  }

  @Test
  public void testRegister() {
    
    BoardVO board = new BoardVO();
    board.setTitle("새로 작성하는 글- ser");
    board.setContent("새로 작성하는 글 내용 -ser");
    board.setWriter("newbie - ser");
    
    service.register(board);
    
    log.info("생성된 게시물 번호 : " + board.getBno());
  }
  @Test // 목록작업의 구현과 테스트
  public void testGetList() {
    service.getList().forEach(board -> log.info(board));
  }
  
  @Test //조회 test
  public void testGet() {
    
    log.info(service.get(12L));//12번 확인
  }

  @Test // 삭제
  public void testDelete() {
    
    //게시물 번호의 존재 여부를 확인하고 테스트 할 것
    log.info("REMOVE RESULT: " + service.remove(12L));//12번 삭제
  }
  
  @Test //수정
  public void testUpdate() {
    
    BoardVO board = service.get(1L);
    
    if(board == null) {
      return;
    }
    
    board.setTitle("제목수정합니다.2");
    log.info("MODIFY RESULT: " + service.modify(board));//1번 확인
  }
}








