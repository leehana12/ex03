package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
  /*
    인터페이스에는 코드가 들어 가지않고 구현체만 가능 하다. 
    
    java 1.8버전 부터는 default가 붙으면 코드를 집어 넣을 수가 있다.
   */
  @Select("SELECT CURRENT_DATE FROM dual")
  public String getTime();

  public String getTime2();

}
