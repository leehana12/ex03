package org.zerock.persistence;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {

  // Spring의 의존성 주입(DI)을 통해 BoardMapper 인터페이스의 구현체를 주입받음
  @Autowired
  private BoardMapper mapper;
  
  //JUnit 테스트 메서드로 지정
  @Test
  public void testGetList() {
    // BoardMapper 인터페이스의 getList() 메서드를 호출하고, 반환된 게시글 목록을 로그로 출력
    mapper.getList().forEach(board -> log.info(board));
  }
  @Test
  public void testInsert() {
    BoardVO board = new BoardVO();
    board.setTitle("새로 작성하는 글");
    board.setContent("새로 작성하는 글 내용");
    board.setWriter("newbie");
    
    mapper.insert(board);
    
    log.info(board);        
  }
  @Test
  public void testInsertSelectKey() {
    BoardVO board = new BoardVO();
    board.setTitle("새로 작성하는 글 select key");
    board.setContent("새로 작성하는 글 내용 select key");
    board.setWriter("newbie");
    
    mapper.insertSelectKey(board);
    
    log.info(board);   
    log.info("after insert seleckey" + board.getBno());
  }
  
  @Test
  public void testRead() {
    
    //존재하는 게시물 번호로 테스트
    BoardVO board = mapper.read(5L);
    log.info(board);
  }
  
}
