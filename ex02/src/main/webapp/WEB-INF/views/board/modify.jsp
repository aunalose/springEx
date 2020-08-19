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
		<h1 class="page-header">Modify Page</h1>
	</div>
</div>
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Board Register</div>
			<div class="panel-body">
		<form action="/board/modify" method="post" role="form">
			<div class="form-group">
				<label>Bno</label> <input class="form-control" name='bno' value='<c:out value="${board.bno }"/>' readonly="readonly">
			</div>
				<div class="form-group">
				<label>Title</label> <input class="form-control" name='title' value='<c:out value="${board.title }"/>' >
			</div>
			<div class="form-group">
				<label>Text area</label>
					<textarea rows="3" name='content' class="form-control"  ><c:out value="${board.content }"/></textarea>
			</div>
			<div class="form-group">
				<label>Writer</label> <input class="form-control" name='writer' value='<c:out value="${board.writer }"/>'>
			</div>
			<div class="form-group">
				<label>RegDate</label>
				<input class="form-control" name="regDate" value='<fmt:formatDate pattern="yyyy/MM/dd" value="${board.regdate }" />' readonly="readonly">
			</div>
			<div class="form-group">
				<label>Update Date</label>
				<input class="form-control" name="updateDate" value='<fmt:formatDate pattern="yyyy/MM/dd" value="${board.updateDate }" />' readonly="readonly">
			</div>
			<button type="submit"  data-oper='modify' class="btn btn-default" >Modify</button>
			<button type="submit"  data-oper='remove' class="btn btn-danger">Remove</button>
			<button type="submit"  data-oper='list' class="btn btn-info" >List</button>
		</form>
			</div>
		</div>
	</div>
</div>

<!-- <script >
	//p.262
	$(document).ready(function(){
			var formObj= $("form");
			
			$('button').on("click", function(e){
				e.preventDefault();
				var operation= $(this).data("oper");
				console.log(operation);
				if (operation==='remove') {
					formObj.attr("action", "/board/remove");
				}else if(operation==='list'){
					//move to list
					self.location="/board/list";
					return;
				}
				formObj.submit();
			});
		});
</script> -->

<script type="text/javascript">
//p.266
$(document).ready(function (){
	
	var formObj= $("form");
	$('button').on("click", function(e){
		e.preventDefault();
	var operation=$(this).data("oper");
	console.log(operation);
	if (operation==='remove') {
		formObj.attr("action","/board/remove");
		
	}else if(operation==='list'){
		formObj.attr("action", "/board/list").attr("method", "get");
		formObj.empty();
	}
		formObj.submit();
	});
});

</script>
</body>
</html>