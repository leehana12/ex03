package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;

public interface BoardMapper {

  @Select("select * from tbl_board where bno > 0")//오라클에서 쿼리 작동 확인 해보기.
  public List<BoardVO> getList();
}
