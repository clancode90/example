<%-- 
    Document   : css_js
    Created on : 24.03.2015, 16:07:43
    Author     : Юрий
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %> 

<!--    css -->
<link href="<c:url value='/css/bootstrap.min.css'/>" rel="stylesheet" media="screen">
<link href="<c:url value='/css/mystyles.css'/>" rel="stylesheet" media="screen">
<link rel="stylesheet" type="text/css" href=<c:url value='/css/body.css'/> >


<!--    js -->
<script src="<c:url value='/js/jquery-1.11.2.min.js'/>"> </script>
<script src="<c:url value='/js/bootstrap.min.js'/>"> </script>
<script src="<c:url value='/js/bootstrap.js'/>"> </script>
<script src="<c:url value='/js/dropdown.js'/>"> </script>
