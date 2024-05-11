<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Book Search</title>
	</head>
	<body>
		<style>
			input {
				margin: 2px;
			}
		</style>
		<h3>공공데이터 오픈 API를 활용한 식품 영양정보 검색 </h3>
		<table>
        	<form action="/foodsearch">
  				식품명  : <input name='keyword' type='text' required/>
  				<input type="submit" value="검색하기">
			</form>
		</table>
		
	</body>
</html>