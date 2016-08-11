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
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>


<script>
var toggle = false;

function generateReplyHTML(groupID, name, comment, date){
	
	  var  html = "	<div class='media'>	<div class='media-left'> <a href='#'> <img class='media-object' src='http://megaicons.net/static/img/icons_sizes/207/499/64/angry-bird-blue-icon.png'> </a>		          	</div>";
	   html += "<div class='media-body'> <h4 class='media-heading'>" + name + "</h4>";
		   html += comment + " <br>" +  date + "	<br></div></div>";
		

        
        $("#replyname").remove();
        $("#reply").remove();
        $("#replybtn").remove();
        $("#replyInputArea").remove();
       
        $('#'+groupID).append(html); // 추가기능
}

function submitReply (articleID, groupID, target) {
    // Ajax 통신으로 서버에 Data를 전송하고 Return 받습니다.
    $.ajax({
        // type을 설정합니다.
        type : "POST",
        url : "http://localhost:8080/PJIBoard/comment",
        // 사용자가 입력하여 id로 넘어온 값을 서버로 보냅니다.
        data : {"articleID" : articleID, "name" : $('#replyname').val(), "groupID" : groupID, "target" : target, "comment" : $('#reply').val() },
        // 성공적으로 값을 서버로 보냈을 경우 처리하는 코드입니다.
        success : function (data) {
        	var obj = $.parseJSON(data);
            // 서버에서 Return된 값으로 중복 여부를 사용자에게 알려줍니다.
            if (data) {
            	generateReplyHTML(obj.groupID, obj.name, obj.comment, obj.date);
            }  
        }
    });
}



function toggleReplyBtn(articleID, groupID){
	  var html = "";
	  

		   html += "<div id='replyInputArea'> <input type='text' class='form-control' id='replyname' placeholder='Input Your Name'><br>"
		   html += "<textarea class='form-control' id='reply' rows='3'></textarea><br>"
		   html += "<button type='button' class='btn btn-success' id='replybtn' onClick='submitReply(";
		   html += articleID + ", " + groupID;
		   html += ",1)'>등록</button><br><br></div>"	
	       $('#'+groupID).append(html);

}

function generateCommentHTML(articleID, groupID, name, comment, date){
	
    var html = "<br><ul class='media-list'";
    html += "  <li class='media'><div class='media-left'><a href=''#''><img class='media-object' src='http://megaicons.net/static/img/icons_sizes/207/499/64/angry-bird-blue-icon.png'></a></div><div class='media-body' id='";
    html += groupID + "'><h4 class='media-heading'>";
    html += name;
    html += "</h4>";
    html += comment + "<br>";
    html += date;
    html += "       <button type='button' class='btn btn-success' onClick='toggleReplyBtn(";
    html += articleID +","+ groupID;
    html += ")'>답글</button></div>";
    

    html +="  </li></ul>"
    
    $('#commentArea').append(html); // 추가기능
    
}

//사용자가 입력한 값과 DB에 저장된 값을 비교해서 중복하는지 Check합니다.
function submitComment(articleID, groupID, target) {
    // Ajax 통신으로 서버에 Data를 전송하고 Return 받습니다.
    $.ajax({
        // type을 설정합니다.
        type : "POST",
        url : "http://localhost:8080/PJIBoard/comment",
        // 사용자가 입력하여 id로 넘어온 값을 서버로 보냅니다.
        data : {"articleID" : articleID, "name" : $('#name').val(), "groupID" : groupID, "target" : target, "comment" : $('#comment').val() },
        // 성공적으로 값을 서버로 보냈을 경우 처리하는 코드입니다.
        success : function (data) {
        	var obj = $.parseJSON(data);
            // 서버에서 Return된 값으로 중복 여부를 사용자에게 알려줍니다.
            if (data) {
            	
            	
				generateCommentHTML(articleID, obj.groupID, obj.name, obj.comment, obj.date);
            }  
        }
    });
}


</script>


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
							<h1>${article.getTitle()}</h1><br><br>
                            <b>Author : ${article.getAuthor()} <br>
                            pubDate : ${article.getDate()} </b><brr><br><br><br>
                            ${article.getContent()}<br><br><br>


	  <input type="text" class="form-control" id="name" placeholder="Input Your Name"><br>
	  <textarea class="form-control" id="comment" rows="3"></textarea><br>
	  <button type="button" class="btn btn-success" onClick="submitComment(${article.getID()}, '1', 'NULL')">등록</button><br><br>

<div id="commentArea">    

		<c:forEach items="${commentList}" var="comment">        
		

			${comment.getCommentHTML()}
                            


        </c:forEach></p>
             




</div>

      <footer>
        <p>&copy; PJI 2016.Summer</p>
      </footer>
    </div> <!-- /container -->


</body>




</html>