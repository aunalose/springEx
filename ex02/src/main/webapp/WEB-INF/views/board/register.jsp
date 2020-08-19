<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board Register</h1>
	</div>
</div>
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Board Register</div>
			<div class="panel-body">
		<form action="/board/register" method="post" role="form">
			<div class="form-group">
				<label>Title</label> <input class="form-control" name='title'>
			</div>
			<div class="form-group">
				<label>Text area</label>
					<textarea rows="3" name='content' class="form-control"></textarea>
			</div>
			<div class="form-group">
				<label>Writer</label> <input class="form-control" name='writer'>
			</div>
			<button  type="submit" class="btn btn-default">Submit Button</button>
			<button type="reset" class="btn btn-default">Reset Button</button>
		</form>
			</div>
		</div>
	</div>
</div>
</body>
</html>