<%-- 
    Document   : menu
    Created on : 30.03.2015, 16:42:28
    Author     : Юрий
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:if test="${role=='user'}">
    <%@include file="/WEB-INF/jsp/menutopuser.jsp" %>
    
</c:if>

<c:if test="${role=='admin'}">
    <%@include file="/WEB-INF/jsp/menutopadm.jsp" %>
    
</c:if>

