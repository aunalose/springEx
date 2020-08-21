/**
 * 
 */

console.log("Reply Module...");

//[1]
//var replyService={}; 
/* =[] 배열담겠다. ={} 객체담겠다*/


//[2] 모듈(=자바스크립트에서 메서드를 가지는 클래스 객체) 구성하기
//즉시 실행 함수?
/*
var replyService=(function() {
	alert("TEST");
	return {name: "AAAAA"};
})();

console.log(">replyService=" + replyService);
console.log(">replyService=" + replyService.name); //replyService의 변수값 replyService=AAAAA
*/

 var replyService=(function() {
	 
	 function add(reply, callback) {
		console.log("reply....");
	}
	 return {plus:add}; //객체, 변수값, 함수를 등록해도 괜찮대. 자바스크립트에서는
	
})();
 
 replyService.plus();