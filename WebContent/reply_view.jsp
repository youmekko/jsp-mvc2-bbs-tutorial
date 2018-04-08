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

	<div class="container" style="margin-top:50px;"> 

		<div class="panel panel-default">
			<div class="panel-heading">MVC MODEL2 BBS</div>
			<div class="panel-body">


				<form action="reply.do" method="post">
					<input type="hidden" name="bbsId" value="${reply_view.bbsId}">
					<input type="hidden" name="bbsGroup"
						value="${reply_view.bbsGroup}"> <input type="hidden"
						name="bbsStep" value="${reply_view.bbsStep}"> <input
						type="hidden" name="bbsIndent" value="${reply_view.bbsIndent}">
					<table class="table table-condensed">
						<tr>
							<td>번호</td>
							<td>${reply_view.bbsId}</td>
						</tr>
						<tr>
							<td>조회수</td>
							<td>${reply_view.bbsHit}</td>
						</tr>
						<tr>
							<td>이름</td>
							<td><input type="text" name="bbsName"
								value="${reply_view.bbsName}"></td>
						</tr>
						<tr>
							<td>제목</td>
							<td><input type="text" name="bbsTitle"
								value="${reply_view.bbsTitle}"></td>
						</tr>
						<tr>
							<td>내용</td>
							<td><textarea rows="10" name="bbsContent">${reply_view.bbsContent}</textarea></td>
						</tr>
						<tr>
							<td colspan="2"><button type="submit"
									class="btn btn-success">댓글</button></td>
						</tr>
					</table>
					<table>
						<tr>
							<td><a href="list.do"><button class="btn btn-primary">목록</button></a></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>

</body>
</html>