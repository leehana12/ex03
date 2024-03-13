package org.zerock.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({ //servlet의 프로퍼티에서 경로 가져온후 수정.
    "file:src/main/webapp/WEB-INF/spring/root-context.xml",  
    "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"  })
@Log4j
public class BoardControllerTests {

  @Autowired
  private WebApplicationContext ctx;
  
  private MockMvc mockMVC; // MockMvc 서버를 구동시키지 않아도 테스트 가능
  
  @Before // JUnit으로 import해줄것. /지정한 패턴에 해당하는 메소드가 실행되기 전에, interceptor와 같이 동작하는 것을 의미
  public void setup() {
    this.mockMVC = MockMvcBuilders.webAppContextSetup(ctx).build();
  }
  
  @Test
  public void testList() throws Exception{ // thorows Exception은 예외를 떠넘길떄 사용
    
    log.info(
          mockMVC.perform(MockMvcRequestBuilders.get("/board/list"))
          .andReturn()
          .getModelAndView()
          .getModelMap());
  }
  
  @Test //등록 
  public void testRegister() throws Exception{
    
    String resultPage= mockMVC.perform(MockMvcRequestBuilders.post(""
        + "/board/register")
        .param("title","테스트 새글 제목--")
        .param("content", "테스트 새글 내용--")
        .param("writer", "user00--")
        ).andReturn().getModelAndView().getViewName();
    
         log.info(resultPage);
  }


  @Test //조회 처리 테스트
  public void testGet() throws Exception {    
    log.info(
        mockMVC.perform(MockMvcRequestBuilders
        .get("/board/get")
        .param("bno","2"))
        .andReturn()
        .getModelAndView()
        .getModelMap());
  }

  @Test //수정 처리 테스트
  public void testModify() throws Exception {    

    String resultPage 
       = mockMVC.perform(MockMvcRequestBuilders
        .post("/board/modify")
        .param("bno","15")
        .param("title","수정된 테스트 새글 제목")
        .param("content","수정된 테스트 새글 내용")
        .param("write","user00"))
        .andReturn().getModelAndView().getViewName();
    
    log.info(resultPage);
  }
  
  @Test //삭제 처리 테스트
  public void testRemove() throws Exception {    
    //삭제전 데이터베이스에 게시물 번호 확인할 것  
    String resultPage 
    = mockMVC.perform(MockMvcRequestBuilders.post("/board/remove")
        .param("bno", "16"))
        .andReturn().getModelAndView().getViewName();
    
    log.info(resultPage);
         
  }  
}


