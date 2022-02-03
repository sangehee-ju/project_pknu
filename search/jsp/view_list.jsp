<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE>
<html>
<head>
<script type="text/javascript">
window.onload = function(){
	/*
	btn이 가리키고 있는 객체에 click이 일어났을때, 
	onclick이 가리키는 함수가 호출된다.
	
	*/
	let btn = document.getElementById("btn");
	btn.onclick = function(){
		alert();
	};
	
	abcd();
};

function abcd(old){
	let table = document.querySelector("table");
	let ab = document.getElementById("ab");

	if(ab.value!=old && ab.value!=''){
		dv.innerHTML = ab.value+":"+old;
		
		let xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function(){
			if(xhr.readyState==4){
				if(xhr.status == 200){
					let rt = xhr.responseText;
					let jo = window.eval("("+rt+")");
					let key = String(jo.key);
					if(key.indexOf(",")!=-1){
						let items = key.split(",");
						table.innerHTML="<tr><td>"+items[0]+"</td></tr>";
					}
					else{
						dv.innerText = key;
					}
				}
			}
		};
		/*
		ajax에서는 오직 utf-8 인코딩 방식만 지원한다.
		encodeURIComponent(): 문자열을 utf-8로 변환시키는 함수
		--한글이 전달될 여지가 조금이라도 있을 때, 반드시 utf-8로 변환시켜 넘겨주
		*/
		xhr.open('GET','ajax.pknu?keyword='+encodeURIComponent(ab.value),true);
		xhr.send(null);
	}
	
	let fc = "abcd('"+ab.value+"')";
	window.setTimeout(fc,700);
	
}
</script>
<style>
	*{
		margin:0;
		padding:0;
	}
	
	#ab{
		border: 5px solid #9c88ff;
		width:400px;
		height:50px;
		focuse:none;
		border-radius:5px;
	}
	
	#ab:focus{
		outline:none;
	}
	#btn{
		width:60px;
		height:49px;
		border: none;
		background-color:#9c88ff;
		color:white;
		font-size:15px;
		border-radius:5px;
	}
	
	#dv{
		width:400px;
		background-color:ghostwhite;
		box-shadow: 2px 3px 5px 0px #b2bec3;
		height:50px;
	}

</style>
</head>
<body>
	<input type="text" id="ab"/>
	<input type="button" id="btn" value="검색"/>
	<div id="dv">
		
	</div>
</body>
</body>
</html>