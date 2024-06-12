<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>식품 영양 성분 검색</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

    <style>
        @font-face {
            font-family: 'WavvePADO-Regular';
            src: url('https://fastly.jsdelivr.net/gh/projectnoonnu/2404@1.0/WavvePADO-Regular.woff2') format('woff2');
            font-weight: normal;
            font-style: normal;
        }

        @font-face {
            font-family: 'SejonghospitalBold';
            src: url('https://fastly.jsdelivr.net/gh/projectnoonnu/noonfonts_2312-1@1.1/SejonghospitalBold.woff2') format('woff2');
            font-weight: 700;
            font-style: normal;
        }

        body {
            font-family: SejonghospitalBold, WavvePADO-Regular, Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
        }

        .container {
            width: 90%;
            margin: 50px auto;
            background-color: #fff;
            border-radius: 10px;
            padding: 20px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        h3 {
            text-align: center;
            color: #333;
        }

        a {
            display: block;
            margin-bottom: 20px;
            text-align: center;
            color: #4CAF50;
            text-decoration: none;
            font-weight: bold;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: center;
        }

        th {

            /*background-color: #f2f2f2;*/
            background-color: #4CAF50;

        }

        .food_name {
            background-color: #aff8b2;
        }


        .index {
            width: 5%;
        }
        .search_container {
            width: 90%;
            margin: 50px auto;
            background-color: #aff8b2;
            border-radius: 10px;
            padding: 20px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            border: 3px solid black;
        }

        h3 {
            text-align: center;
            color: #333;
        }

        form {
            text-align: center;
        }

        input[type="text"] {
            font-family: SejonghospitalBold;
            width: 70%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 16px;
            margin-bottom: 10px;
        }

        input[type="submit"] {
            font-family: SejonghospitalBold;
            background-color: #4CAF50;
            color: black;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            transition: 0.15s ease-in-out;

        }

        input[type="submit"]:hover {
            transform: scale(1.3);
        }


        .table_row:hover {
            border: 3px solid dodgerblue;
            font-size: large;

        }

        .attribute_width {
            width: 12.5%;
        }

        #pagination {
            text-align: center;
            margin-top: 20px;
        }

        #pagination a {
            display: inline-block;
            margin-right: 5px;
            padding: 5px 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            text-decoration: none;
            color: #333;
        }

        #pagination a.active {
            background-color: #4CAF50;
            color: white;
        }

    </style>


</head>
<body>
<div class="bg">
    <div class="container">
        <div class="search_container">
            <h3>🔍 식품 영양 성분 검색</h3>
            <form action="/foodsearch">
                식품명 : <input name='keyword' type='text'/>
                <input class="search_btn" type="submit" value="검색하기" required>
            </form>
        </div>
        <br>

        <hr>

        <br><br><br>

        <h3>📜 식품 영양 성분 검색 결과 </h3> ( <strong><u>${param.keyword}</u></strong>에 대한 검색결과: <span id="totalCount">${totalCount} 개</span> )

        <table>
            <thead>
            <tr>
                <th>순번</th>
                <th>식품명</th>
                <th>1회 제공량 (g)</th>
                <th>열량 (kcal)</th>
                <th>탄수화물 (g)</th>
                <th>단백질 (g)</th>
                <th>지방 (g)</th>
                <th>당류 (g)</th>
                <th>나트륨 (mg)</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${foods}" var="food" varStatus="status">
                <tr class="table_row">
                    <td class="food_name index">${(status.index + 1)  + ((currentPage-1)*20)}</td>
                    <td class="food_name attribute_width">${food.descKor}</td>
                    <td class="attribute_width servingWt">${food.servingWt}</td>
                    <td class="attribute_width n1">${food.nutrCont1}</td>
                    <td class="attribute_width n2">${food.nutrCont2}</td>
                    <td class="attribute_width n3">${food.nutrCont3}</td>
                    <td class="attribute_width n4">${food.nutrCont4}</td>
                    <td class="attribute_width n5">${food.nutrCont5}</td>
                    <td class="attribute_width n6">${food.nutrCont6}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <br><br>
        <center>
            <div id="pagination">
                <c:if test="${currentPage > 1}">
                    <a href="/foodsearch?keyword=${param.keyword}&page=${currentPage - 1}">이전</a>
                </c:if>
                <c:forEach begin="1" end="${totalPages}" var="pageNumber">
                    <c:choose>
                        <c:when test="${pageNumber == currentPage}">
                            <span class="active">${pageNumber}</span>
                        </c:when>
                        <c:otherwise>
                            <a href="/foodsearch?keyword=${param.keyword}&page=${pageNumber}">${pageNumber}</a>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
                <c:if test="${currentPage < totalPages}">
                    <a href="/foodsearch?keyword=${param.keyword}&page=${currentPage + 1}">다음</a>
                </c:if>
            </div>
        </center>


    </div>

</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>

<script>
    // errorMessage 변수를 가져와서 alert 창을 띄웁니다.
    let errorMessage = "${errorMessage}";
    let totalCount = Math.ceil(parseInt(document.getElementById('totalCount').innerText));

    console.log(errorMessage);
    if (errorMessage !== "") {
        alert(errorMessage);
    }

    document.addEventListener("DOMContentLoaded", function() {
        document.querySelectorAll(".table_row").forEach(function(row) {
            var tds = row.querySelectorAll("td");
            var tdTexts = [];
            tds.forEach(function(td) {
                tdTexts.push(td.innerText);
            });

            const dailyNtrTotal = [2000, 324, 55, 54, 100, 2000]; // 각 영양 성분의 하루 일일섭취량

            for (let i = 3; i < tds.length; i++) {
                let nutrientContent = parseFloat(tdTexts[i]);
                if (!isNaN(nutrientContent)) {
                    let percentage = (nutrientContent / dailyNtrTotal[i - 3]) * 100;
                    tds[i].innerText += " (" + percentage.toFixed(1) + "%)";
                }
            }
        });
    });

</script>
</body>
</html>