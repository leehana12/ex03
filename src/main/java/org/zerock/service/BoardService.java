package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;

public interface BoardService {

  //CRUD 5개
  public void register(BoardVO boare);
  
  public BoardVO get(Long bno);
  
  public boolean modify(BoardVO board);

  public boolean remove(Long board);
  
  public List<BoardVO> getList();
  
}
