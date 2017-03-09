<%-- 
    Document   : error
    Created on : 30.03.2015, 16:20:58
    Author     : Юрий
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<c:if test="${! empty message}">
    <center>
        <div class="alert alert-success"" >
            <c:forEach items="${message}" var="message" >
                <p>${message}</p>
            </c:forEach>
        </div>  
    </center>
</c:if>
