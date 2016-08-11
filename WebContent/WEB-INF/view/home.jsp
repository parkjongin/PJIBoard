<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>


<body>



    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">PJI Board</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <form class="navbar-form navbar-right">
            <div class="form-group">
              <input type="text" placeholder="Search" class="form-control">
            </div>
            <button type="submit" class="btn btn-success">Search</button>
          </form>
        </div><!--/.navbar-collapse -->
      </div>
    </nav>

    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
      <div class="container">
      	<br>       
        <img src = "http://www.hanwon.org/wp-content/uploads/2014/10/dong50_web.jpg" height="350" width="1200"></img>
      </div>
    </div>

    <div class="container">
<p>          
<table class="table table-hover table-bordered">
		<td class="active">번호</td>
		<td class="active">제목</td>
		<td class="active">글쓴이</td>
		<td class="active">날짜</td>
		<c:forEach items="${articles}" var="article">        
		

             <tr class="active" onclick="location.href='http://localhost:8080/PJIBoard/articleView/${article.getID()}'">
                            <td class="active">
                            
                            ${article.getID()}
                            
                            </td>
                             <td class="active">${article.getTitle()}</td>
                              <td class="active">${article.getAuthor()}</td>
                              <td class="active">${article.getDate()}</td>
             </tr>

             </c:forEach></p>

</table>

      <footer>
        <p>&copy; PJI 2016.Summer</p>
      </footer>
    </div> <!-- /container -->


</body>
</html>