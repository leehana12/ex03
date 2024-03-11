package org.zerock.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {

  static {
    try {//예외처리
      Class.forName("oracle.jdbc.OracleDriver");
      
    } catch (Exception e) { // Exception은 가장 기본적인 에러 처리 이다/에러의 종류가 자세하게 나오지 않는다/.맨마지막에 사용하는 에러처리.
      e.printStackTrace();
    }
  }
  
  @Test
  public void testConnetion() {
    try(Connection con =//자동으로 잡을 떄 sql이 붙은것으로 선택해야 한다.
        DriverManager.getConnection(
            "jdbc:oracle:thin:@localhost:1521:XE",
            "webdb",
            "12345")){
          log.info(con);
    } catch (Exception e) {
      fail(e.getMessage());
    }
  }

}

