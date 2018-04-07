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
		<form action="reply.do" method="post">
			<table style="width=500; cellpadding=0; cellspacing=0; border=1;">
				<input type="hidden" name="bbsId" value="${reply_view.bId}">
				<input type="hidden" name="bbbsGroup" value="${reply_view.bGroup}">
				<input type="hidden" name="bbsStep" value="${reply_view.bStep}">
				<input type="hidden" name="bbsIndent" value="${reply_view.bIndent}">
				<tr>
					<td>Id</td>
					<td>${reply_view.bbsId}</td>
				</tr>
				<tr>
					<td>HIT</td>
					<td>${reply_view.bbsHit}</td>
				</tr>
				<tr>
					<td>NAME</td>
					<td><input type="text" name="bbsName"
						value="${reply_view.bbsName}"></td>
				</tr>
				<tr>
					<td>Title</td>
					<td><input type="text" name="bbsTitle"
						value="${reply_view.bbsTitle}"></td>
				</tr>
				<tr>
					<td>CONTENT</td>
					<td><textarea rows="10" name="bContent">${reply_view.bbsContent}</textarea></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="submit"> <a
						href="list.do">목록</a></td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>