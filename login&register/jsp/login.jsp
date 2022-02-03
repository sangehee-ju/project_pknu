<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE>
<html>
<head>
<title>Insert title here</title>
<script>
    window.onload = function(){
      mode();
    }

    function mode(){
      let cus = document.getElementById("cus");
      let sel = document.getElementById("sel");
      let cuslog = document.getElementById("cuslog");
      let sellog = document.getElementById("sellog");

      cus.onchange = function(){
        cuslog.style.display='block';
        sellog.style.display='none';
      }

      sel.onchange = function(){
        cuslog.style.display='none';
        sellog.style.display='block';
      }
    }
  </script>
  <link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet" type="text/css"/>
</head>
<body>
  <label for="cus">소비자</label><input type="radio" name="mode" value="customer" id="cus" checked/>
  <label for="sel">판매자</label><input type="radio" name="mode" value="seller" id="sel"/><br/>
  <section id="cuslog">
  	<form method="post" action="cuslogin.pj">
	  <label for="cusid">소비자아이디</label><input type="text" name="cusid" id="cusid">
      <label for="cuspw">비밀번호</label><input type="password" name="cuspw" id="cuspw"><br/>
      <input type="submit" value="소비자로 로그인하기">	
  	</form>
  </section>
  <section id="sellog">
  	<form method="post" action="sellogin.pj">
	  <label for="selid">판매자아이디</label><input type="text" name="selid" id="selid">
      <label for="selpw">비밀번호</label><input type="password" name="selpw" id="selpw"><br/>
      <input type="submit" value="판매자로 로그인하기">
  	</form>
  </section>
  <div id="register">회원이 아니신가요?<a href="register.pj">회원가입하기</a></div>
</body>
</html>