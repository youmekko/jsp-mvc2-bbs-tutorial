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
				<form action="write.do" method="post">
					<table class="table table-condensed">
						<tr>
							<td>이름</td>
							<td><input type="text" name="bbsName" size="50"></td>
						</tr>
						<tr>
							<td>제목</td>
							<td><input type="text" name="bbsTitle" size="50"></td>
						</tr>
						<tr>
							<td>내용</td>
							<td><textarea name="bbsContent" rows="10"></textarea></td>
						</tr>
						<tr>
							<td colspan="2"><button type="submit"
									class="btn btn-success">글 올리기</button></td>
						</tr>
					</table>
				</form>
				<table class="table">
					<tr>
						<td><a href="list.do"><button class="btn btn-primary">목록</button></a></td>
					</tr>
				</table>

			</div>
		</div>

	</div>

</body>
</html>