<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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


				<table class="table table-condensed">

					<thead>
						<tr>
							<th>번호</th>
							<th>이름</th>
							<th>제목</th>
							<th>날짜</th>
							<th>조회수</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="bbs">
							<tr>
								<td>${bbs.bbsId}</td>
								<td>${bbs.bbsName}</td>
								<td><c:forEach begin="1" end="${bbs.bbsIndent}">-</c:forEach>
									<a href="content_view.do?bbsId=${bbs.bbsId}">${bbs.bbsTitle}</a></td>
								<td>${bbs.bbsDate}</td>
								<td>${bbs.bbsHit}</td>
							</tr>

						</c:forEach>

						<tr>
							<td colspan="5"><a href="write_view.do"> <input
									type="button" class="btn btn-primary" value="글쓰기"></a></td>
					</tbody>
				</table>

			</div>
		</div>

	</div>

</body>
</html>