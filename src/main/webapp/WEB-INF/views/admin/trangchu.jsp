<%@ include file="/common/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
        <link href="<c:url value="/resources/trangchu.css" />" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css" rel="stylesheet" type="text/css"> 
</head>
<body>
    <h2 class="text-center">Quản lý ADMIN</h2>
<div class="container">    
 <div class="row">      
  <div class="col-xs-12 col-lg-12"> 
   <div id="panelBox" class="panel panelBox panelFilter"> 
    <div class="panel-heading"> 
     <ul class="nav panelbox nav-tabs"><div class="logo_menuchinh" style="float:left; padding-top:5px; padding-left:10px; color:#fff; margin-left:auto; margin-right:auto; text-align=center; line-height:40px; font-size:16px;font-weight:bold;font-family:Arial">HOCWEBGIARE.COM</div><div class="menu-icon"></div> 
      <li class="active"><a href="https://hocwebgiare.com/#tabFilters" data-toggle="tab">Quản lý ca sĩ</a>
      </li> 
      <li><a href="https://hocwebgiare.com/#tabResults" data-toggle="tab">Quản lý thể loại</a>
      </li> 
      <li><a href="https://hocwebgiare.com/#tabMetrics" data-toggle="tab">Quản lý bài hát</a>
      </li> 
     </ul> 
    </div> 
    
 <tiles:insertAttribute name="admincasi" />
  <tiles:insertAttribute name="admintheloai" />
   <tiles:insertAttribute name="adminbaihat" />
 
   </div> 
  </div>   
 </div>
</div>

    
</body>
</html>
<script src="js/jquery-1.11.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>