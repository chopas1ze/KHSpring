<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div id="wrap">
	<div id="logInPage">
		<form name="frm" method="post" action="logpro.do">
			<p>
				<label for="id">아이디</label> <input type="text" name="id" />
			</p>

			<p>
				<label for="pass">비밀번호</label> <input type="text" name="pass" />
			</p>

			<p>
				<input type="hidden" name="returnUrl" value="${param.returnUrl}" />
				<input type="submit" value="로그인" />
			</p>
		</form>
	</div>
	<div id="logOutPage">
		<p>
			<a href="logout.do">${sessionScope.chk }</a>님 로그아웃
		</p>
	</div>
</div>