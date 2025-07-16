<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style type="text/css">
		div{
			text-align: center;
		}
		table {
			margin:50px auto;
			border:1px solid black;
			border-collapse: collapse;
			text-align:center;
		}
		td,tr{
			margin: 0; padding: 0;
			border: 1px solid black;
		}
		input {
			margin: 0;
		}
	</style>
</head>
<body>
	<%@ include file="../common/Header.jsp" %>
	<div>
		<a href="logout.do">로그아웃</a>
		<br>
		
		<!--
			
			enctype란
				
				- 전송하는 데이터 타입을 명시한다
				- 종류
					
					1) 디폴트: application/x-www-form-urlencoded
						
						- 파일이 없는 폼(multipart/form-data 외)에 대부분 사용한다
						- name=value 형식으로 전송된다
					
					2) multipart/form-data
						
						- input에 file이 포함된 이진데이터 폼을 전송할 때 사용
					
					3) text/plan
					
		 -->
		
		<form action="insertBoard.do" method="post" enctype="multipart/form-data">
			<table>
				<tr>
				    <!-- 수정가능 -->
					<td width="80px">제목</td> 
					<td><input type="text" name="title"></td>
				</tr>
				<tr>
					<td width="80px">작성자</td> 
					<td><input type="text" name="writer"></td>
				</tr>
				<tr>
					<!-- 수정가능 -->
					<td width="80px">내용</td> 
					<td><textarea  name="content" cols="40" rows="10" ></textarea></td>
				</tr>
				
				<!-- 파일 업로드 추가 -->
				<tr>
					
					<td bgcolor="orange" width="70px">업로드</td>
					<td align="left">
						
						<input type="file" name="uploadFile">
						
					</td>
					
				</tr>
				
				<tr>
					<td colspan="2"> <!-- 두칸으로 늘린다 -->
						<input type="submit" value="새글등록">   <!-- 버튼 -->
					</td>
				</tr>
			</table>
		
		</form>
		<a href="getBoardList.do">전체목록</a>
	</div>
	<%@ include file="../common/Footer.jsp" %>
</body>
</html>