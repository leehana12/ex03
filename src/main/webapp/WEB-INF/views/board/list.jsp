<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- header와 부터로 나눈 부분에 아래 include를 작성해줘야 함. 코드 맨아래 footer.jsp연결도 있음. -->
<%@include file="../includes/header.jsp" %>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Board List Page</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Board List Page
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th>번호</th>
                                        <th>제목</th>
                                        <th>작성자(s)</th>
                                        <th>작성일</th>
                                        <th>수정일</th>
                                    </tr>
                                </thead>
								<c:forEach items="${list}" var="board">
									<tr>
										<!-- JSP view페이지를 만들 때 XSS공격 방지를 위해 " <c:out> "을 사용하여 막을 수 있다/보안성 -->
										<td><c:out value="${board.bno}" /></td>
										<td><c:out value="${board.title}" /></td>
										<td><c:out value="${board.writer}" /></td>
										<!-- regDate와 updateDate를 대소문자 구분을 제대로 안해줄 경우 forEach문이 돌아 가지 않는ㄴ다. -->
										<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.regDate}"/></td>
										<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.updateDate}"/></td>
									</tr>
								</c:forEach>
							</table>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>

            </div>
            <!-- /.row -->
            
<%@include file="../includes/footer.jsp" %>
