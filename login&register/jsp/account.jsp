<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE>
<html>
<head>
<title>Insert title here</title>
<script>
    window.onload = function(){
      mode();
    }
    function mode(){
      let sel = document.getElementById("seller");
      let cus = document.getElementById("customer");
      let cusbtn = document.getElementById("cusbtn");
      let selbtn = document.getElementById("selbtn");
      selbtn.onclick = function(){
          sel.style.display='block';
          cus.style.display="none";
      }
      cusbtn.onclick = function(){
        cus.style.display='block';
        sel.style.display="none";
      }
    }
  </script>
  <link href="${pageContext.request.contextPath}/css/account.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<input type="button" value="소비자" id="cusbtn"/>
	<input type="button" value="판매자" id="selbtn"/>
    
    <section id="customer">
    	<form method="post" action="cusaccount.pj">
    		<label for="cusid">아이디</label><input type="text" name="cusid" id="cusid"/><br/>
			<label for="cuspw">비밀번호</label><input type="password" name="cuspw" id="cuspw"/><br/>
			<label for="cusname">이름</label><input type="text" name="cusname" id="cusname"/><br/>
			<label for="idnum">주민등록번호</label><input type="text" name="cusresid" id="idnum"/><br/>
			<label for="cusaddr">주소</label><input type="text" name="cusaddr" id="cusaddr"/><br/>
			<label for="cusphone">전화번호</label><input type="text" name="cusphone" id="cusphone"/><br/>
			<label for="email">이메일</label><input type="text" name="cusmail" id="cusemail"/><br/>
      		<input type="submit" value="등록하기">
    	</form>
    </section>
    
    <section id="seller">
    	<form method="post" action="selaccount.pj">
    		<label for="selid">아이디</label><input type="text" name="selid" id="selid"/><br/>
			<label for="selpw">비밀번호</label><input type="password" name="selpw" id="selpw"/><br/>
			<label for="selname">상호명</label><input type="text" name="selname" id="selname"/><br/>
			<label for="selnum">등록번호</label><input type="text" name="selnum" id="selnum"/><br/>
			<label for="seladdr">주소</label><input type="text" name="seladdr" id="seladdr"/><br/>
			<label for="selphone">전화번호</label><input type="text" name="selphone" id="selphone"/><br/>
			<label for="repname">담당자명</label><input type="text" name="repname" id="repname"/><br/>
      		<input type="submit" value="등록하기">
    	</form>
    </section>
</body>
</html>