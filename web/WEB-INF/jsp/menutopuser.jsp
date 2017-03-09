<%-- 
    Document   : menutop
    Created on : 24.03.2015, 15:44:32
    Author     : Юрий
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>


   
     <div class="navbar">
        <ul class="nav navbar-nav">
            <li><a href="<c:url value="/index"/>" class="dropdown-toggle">Главная</a></li>
            
           
            <li><a href="#">Эвент</a></li>
            <li><a href="#">Компании</a></li>  
        </ul> 
        
             <%@include file="/WEB-INF/jsp/menuright.jsp" %>
    </div>   


