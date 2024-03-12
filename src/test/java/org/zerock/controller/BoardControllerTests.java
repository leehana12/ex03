package org.zerock.controller;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import org.zerock.service.BoardServiceImplTest;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({ //servlet의 프로퍼티에서 경로 가져온후 수정.
    "file:src/main/webapp/WEB-INF/spring/root-context.xml",  
    "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"  })
@Log4j
public class BoardControllerTests {

  @Setter()
  private WebApplicationContext ctx;
  
  private MockMvc mockMvc; // MockMvc 서버를 구동시키지 않아도 테스트 가능
}





