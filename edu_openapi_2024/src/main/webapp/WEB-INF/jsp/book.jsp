<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>식품 영양 성분 검색</title>
	<style>
		body {
			font-family: Arial, sans-serif;
			background-color: #f5f5f5;
			margin: 0;
			padding: 0;
		}
		.container {
			width: 50%;
			margin: 50px auto;
			background-color: #fff;
			border-radius: 10px;
			padding: 20px;
			box-shadow: 0 2px 4px rgba(0,0,0,0.1);
		}
		h3 {
			text-align: center;
			color: #333;
		}
		form {
			text-align: center;
		}
		input[type="text"] {
			width: 70%;
			padding: 10px;
			border: 1px solid #ccc;
			border-radius: 5px;
			font-size: 16px;
			margin-bottom: 10px;
		}
		input[type="submit"] {
			background-color: #4CAF50;
			color: white;
			padding: 10px 20px;
			border: none;
			border-radius: 5px;
			cursor: pointer;
			font-size: 16px;
		}
		input[type="submit"]:hover {
			background-color: #45a049;
		}
	</style>
</head>
<body>
<div class="container">
	<h3>식품 영양 성분 검색</h3>
	<form action="/foodsearch">
		식품명 : <input name='keyword' type='text' required/>
		<input type="submit" value="검색하기">
	</form>
</div>
</body>
</html>
