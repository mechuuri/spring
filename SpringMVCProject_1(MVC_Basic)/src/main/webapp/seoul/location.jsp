<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/d.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
	margin-top: 50px;
	
}
.row{
	margin: 0px auto;
	width: 1200px;
}
</style>
</head>
<body>
 <div class="container">
   <div class="row">
    <c:forEach var="vo" items="${list }">
      <div class="col-md-3">
    <div class="thumbnail">
      <a href="/w3images/lights.jpg">
        <img src="${vo.poster }" alt="Lights" style="width:300px; height: 200px">
        <div class="caption">
          <p>${vo.poster }</p>
        </div>
      </a>
    </div>
    </c:forEach>
   </div>
   <div class="row">
    <div class="text-center">
      <a href="location.do?page=${curpage>1?curpage-1:curpage }" class="btn btn-sm btn-danger">이전</a>
      ${curpage } page / ${totalpate } pages
      <a href="location.do?page=${curpage<totalpage?curpage+1:curpage}" class="btn btn-sm btn-primary">다음</a>
    
    </div>
   </div>
 </div>
</body>
</html>