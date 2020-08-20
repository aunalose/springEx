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
		
			<div class="form-group">
				<label>Bno</label> <input class="form-control" name='bno' value='<c:out value="${board.bno }"/>' readonly="readonly">
			</div>
			<div class="form-group">
				<label>Title</label> <input class="form-control" name='title' value='<c:out value="${board.title }"/>' >
			</div>
			<div class="form-group">
				<label>Text area</label>
					<textarea rows="3" name='content' class="form-control"  readonly="readonly"><c:out value="${board.content }"/></textarea>
			</div>
			<div class="form-group">
				<label>Writer</label> <input class="form-control" name='writer' readonly="readonly" value='<c:out value="${board.writer }"/>'>
			</div>
			<%-- <button type="button"  data-oper='modify' class="btn btn-default" onclick="location.href='/board/modify?bno=<c:out value="${board.bno} "/>' ">Modify</button> --%>
			<!-- <button type="button"  data-oper='list' class="btn btn-info" onclick="location.href='/board/list' ">List</button> -->
			<button type="button" class="btn btn-default" data-oper='modify'>Modify</button>
			<button type="button" class="btn btn-info" data-oper='list'>List</button>		
		
		<form action="/board/modify" method="get" id='operForm'>
			<input type='hidden' id='bno' name='bno' value='<c:out value="${board.bno }" />'>
			<input type='hidden' name='pageNum' value='<c:out value="${cri.pageNum }" />'>
			<input type='hidden' name='amount' value='<c:out value="${cri.amount }" />'>
			<input type='hidden' name='keyword' value='<c:out value="${cri.keyword }" />'>
			<input type='hidden' name='type' value='<c:out value="${cri.type }" />'>
		</form>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
//p.265
	$(document).ready(function (){
		var operForm=$("#operForm");
		$("button[data-oper='modify']").on("click", function (e) {
			operForm.attr("action", "/board/modify").submit();
		});
		$("button[data-oper='list']").on("click", function (e) {
			operForm.find("#bno").remove();
			operForm.attr("action", "/board/list");
			operForm.submit();
		});
	});
</script>
</body>
</html>