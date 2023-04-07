<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
<div class="wrapper row3 rows">
     <main class="container clear">
         <div class="one_half first">
           <c:if test="${count==0 }">
             <table class="table">
               <tr>
                 <td class="text-center"><h3>등록된 레시피정보가 없습니다</h3></td>
               </tr>
             </table>
           </c:if>
           <c:if test="${count>0 }">
           <table class="table">
             <tr>
               <td class="text-center" colspan="3">
                 <img src="${vo.poster }" style="width:100%">
               </td>
             </tr>
             <tr>
               <td class="text-center" colspan="3">${vo.title }</td>
             </tr>
             <tr>
               <td class="text-center" colspan="3">${vo.content }</td>
             </tr>
             <tr>
               <td class="text-center"><img src="../images/info1.png"></td>
               <td class="text-center"><img src="../images/info2.png"></td>
               <td class="text-center"><img src="../images/info3.png"></td>
             </tr>
             <tr>
               <td class="text-center">${vo.info1 }</td>
               <td class="text-center">${vo.info2 }</td>
               <td class="text-center">${vo.info3 }</td>
             </tr>
           </table>
           <table class="table">
             <caption>재료</caption>
             <tr>
               <td>
                 <ul>
                   <c:forTokens items="${vo.data }" delims="," var="d">
					  <li>${d }</li>                   
                   </c:forTokens>
                 </ul>
               </td>
             </tr>
           </table>
           <table class="table">
             <caption>조리순서</caption>
             <c:forEach var="fm" items="${tList1 }" varStatus="s">
               <tr>
                 <td width=70%>${fm }</td>
                 <td width=30%><img src="${iList1[s.index]}" style="width: 200px;height: 150px"></td>
               </tr>
             </c:forEach>
           </table>
           </c:if>
         </div>
         
         <div class="one_half">
         
         </div>
     </main>
</div>
</body>
</html>