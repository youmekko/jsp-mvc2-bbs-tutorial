<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1">

<title>MVC2 BBS</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">


<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


</head>
<body>

	<div class="container">
		<form action="modify.do" method="post">
			<table style="width=500; cellpadding=0; cellspacing=0; border=1;">
				<input type="hidden" name="bbsId" value="${content_view.bbsId}">
				<tr>
					<td>번</td>
					<td>${content_view.bbsId}</td>
				</tr>
				<tr>
					<td>조회수</td>
					<td>${content_view.bbsHit}</td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="bbsName"
						value="${content_view.bbsName}"></td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input type="text" name="bbsTitle"
						value="${content_view.bbsTitle}"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea rows="10" name="bbsContent">${content_view.bbsContent}</textarea></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="submit">
						&nbsp;&nbsp; <a href="list.do">목록</a> &nbsp;&nbsp; <a
						href="delete.do?bbsId=${content_view.bbsId}">삭제</a> &nbsp;&nbsp; <a
						href="reply_view.do?bbsId=${content_view.bbsId}">댓글</a></td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>