package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

//인터페이스는 구현체 - implements가 붙으면 인터페이스가 붙었다는 의미 - 구현체 (Override)
@Log4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService{

  
   // spring 4.3 이상에서 자동 처리
  @Autowired
    private BoardMapper mapper;
   
  
  @Override
  public void register(BoardVO board) {
    
    log.info("register....." + board);
    
    mapper.insertSelectKey(board);
  }

  @Override
  public BoardVO get(Long bno) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean modify(BoardVO board) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean remove(BoardVO board) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public List<BoardVO> getList() {
    // TODO Auto-generated method stub
    return null;
  }
  
}
