package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.BoardVO;

public interface BoardMapper {

  //@Select("select * from tbl_board where bno > 0")//오라클에서 쿼리 작동 확인 해보기.
  public List<BoardVO> getList();
  
  public void insert(BoardVO board);
  
  public void insertSelectKey(BoardVO board);
  
  public BoardVO read(Long bno);

  public BoardVO delete(int bno);

  public int delete(long bno);
  
  public int update(BoardVO board);
}
