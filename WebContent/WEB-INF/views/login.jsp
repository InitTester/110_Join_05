<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>CodePen - Flat Login Form</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900'>
<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Montserrat:400,700'>
<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>

		<!-- jstl , c:url value를 이용해서 루트로부터 절대경로를 지정해준다.-->
		<link rel="stylesheet" href= "<c:url value='/resources/css/style.css'/>">	

</head>
<body>
<!-- partial:index.partial.html -->
<div class="container">
  <div class="info">
    <h1>Flat Login Form</h1><span>Made with <i class="fa fa-heart"></i> by <a href="http://andytran.me">Andy Tran</a></span>
  </div>
</div>
<div class="form">
  <div class="thumbnail"><img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/169963/hat.svg"/></div>
  <form class="register-form" action="<c:url value='/sign-up.do'/>">
    <input type="text" placeholder="name" name="name"/>
    <input type="password" placeholder="password" name="passwd"/>
    <!-- type email로 변경 -->
    <input type="email" placeholder="email address" name="email"/>
    <button>create</button>
    <p class="message">Already registered? <a href="#">Sign In</a></p>
  </form>
  <form class="login-form" action="<c:url value='/login.do'/>">
    <input type="text" placeholder="username" name ="name"/>
    <input type="password" placeholder="password" name="passwd"/>
    <button>login</button>
    <p class="message">Not registered? <a href="#">Create an account</a></p>
  </form>
</div>
<video id="video" autoplay="autoplay" loop="loop" poster="polina.jpg">
  <source src="http://andytran.me/A%20peaceful%20nature%20timelapse%20video.mp4" type="video/mp4"/>
</video>
<!-- partial -->
  <script src='//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
  	
	  <script src="<c:url value='/resources/js/script.js'/>"></script>
	  <script>
		/*     
			window.onload : 웹 페이지가 완전 로드되었을때 구동, 페이지의 요소를 접근하거나 초기화 할때 많이 사용된다.
		    전송된 데이터를 msg, result 값으로 받아서 result(db 처리 성공,실패)에 값이 있는경우 해당 경우에 맞는 msg 값을 받아서
		    화면에 보여주고, 새로고침을 하게되면 계속 회원가입이 되기 때문에 리다이렉트로 페이지 이   
		*/    
		window.onload=function(){
			var msg = '${msg}';
			var result = '${result}';
			
			if(result != ''){
				alert(msg);
				window.location.href = "<c:url value='/join-page.do'/>"
			}
		}
	</script>	

</body>
</html>