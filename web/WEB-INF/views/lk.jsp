<%-- 
    Document   : lk
    Created on : 26.03.2015, 14:04:30
    Author     : Юрий
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>



<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="/WEB-INF/jsp/css_js.jsp" %>
        <title>  </title>
    </head>
    <body class="container" >
      
        <%@include file="/WEB-INF/jsp/error.jsp" %> 


    <center>
        <form action="<c:url value="/Lk/selectLk" />" method="post">
            <h3> Выбор личного кабинета </h3><br>
            <select name="personalCabinetId" >
                <c:forEach items="${list}" var="CabinetUser">
                    <option value="${CabinetUser.cabinet.personalCabinetId}"> ${CabinetUser.cabinet.company}</option>
                </c:forEach>
            </select>

            <input type="submit" value="Выбрать" />

        </form>
    </center>
</body>
</html>
