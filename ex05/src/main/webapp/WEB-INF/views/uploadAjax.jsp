<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<h1>Upload with Ajax</h1>
<div class="uploadDiv">
	<input type="file" name="uploadFile" multiple="multiple">
</div>
<button id="uploadBtn">Upload</button>
<!--jquery cdn  -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
<script >
$(document).ready(function () {
var regex=new RegExp("(.*?)\.(exe|sh|zip|alz)$");
var maxSize= 5242880; 

function checkExtension(fileName, fileSize){
	if (fileSize >= maxSize) {
		alert("파일 사이즈 초과");
		return false;
	}
	if (regex.test(fileName)) {
		alert("해당 종류의 파일은 업로드할 수 없습니다.");
		return false;
	}
	return true;
}// end checkExtension

	$("#uploadBtn").on("click", function(e) {
		var formData= new FormData();
		var inputFile=$("input[name='uploadFile']");
		var files= inputFile[0].files;
		console.log(files);
		
		
		//add filedate to formdata
		for (var i = 0; i < files.length; i++) {
			
			if (!checkExtension(files[i].name, files[i].size)) {
				return false;
			}
			
			formData.append("uploadFile", files[i]);
		}
		
		$.ajax({
			url: 'uploadAjaxAction',
			processData: false,
			contentType: false,
			data: formData,
			type: 'POST',
			success: function(result) {
				alert("Uploaded");
			}
		});// $.ajax
		
	});
});
</script>

</body>
</html>