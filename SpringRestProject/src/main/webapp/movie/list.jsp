<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
   margin-top:50px;
}
.row{
   margin: 0px auto;
   width:800px;
}
h1{
   text-align:center;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('.movies').click(function(){
		let no=$(this).attr("data-no");
		$.ajax({
			type:'post',
			url:'list_json.do',
			data:{"no":no},
			success:function(response)
			{
				$('#print').text(response);
			}
		})
	})
})
</script>
</head>
<body>
	<div class="container">
	 <div class="row">
	   <div class="text-center">
	     <input type=button class="btn btn-sm btn-danger movies" value="일일박스오피스" data-no="1">
	      <input type=button class="btn btn-sm btn-primary movies" value="실시간예매율" data-no="2">
	       <input type=button class="btn btn-sm btn-success movies" value="온라인 상관" data-no="3">
	       >
	   </div>
	 </div>
	 <div style="height: 10px">
	 <div class="row">
	   <div id="print">
	   
	   </div>
	 </div>
	 </div>
	</div>
</body>
</html>