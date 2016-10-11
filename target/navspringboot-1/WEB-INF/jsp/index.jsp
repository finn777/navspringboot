<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<body>
${message}
<br>
Rows count: ${rowscount}
<br>

<form action="<c:url value="/"/>" method="POST">
    <table>
        <tr>
            <td>Object Type:
                <select name="filterobjecttype" value = "${filter.filterobjecttype}">
                    <c:forEach var="type" items="${types}">
                        <option value="${type}" ${filter.filterobjecttype == type ? 'selected' : ' '}><c:out value="${type}" ></c:out></option>
                    </c:forEach>
                </select>
            </td>
            <td>Object ID  : <input type="text" pattern="^[0-9]+$" name="filterobjectid" value="${filter.filterobjectid}"/><br/></td>
            <td><input type="submit" name="Search" value="Search"/><br/></td>
            <td><input type="submit" name="Clear" value="Clear"/><br/></td>
        </tr>
    </table>
</form>


<br>
<table border = "1">
    <tr>
        <th>ObjectType</th>
        <th>ModuleName</th>
        <th>VersionName</th>
        <th>Read</th>
        <th>Insert</th>
        <th>Modify</th>
        <th>Delete</th>
        <th>Execute</th>
        <th>ProductLine</th>
    </tr>
    <c:forEach var="row" items="${rows}">
        <tr>
            <td><c:out value="${row.objecttype}"/></td>
            <td><c:out value="${row.modulename}"/></td>
            <td><c:out value="${row.versionname}"/></td>
            <td><c:out value="${row.read}"/></td>
            <td><c:out value="${row.insert}"/></td>
            <td><c:out value="${row.modify}"/></td>
            <td><c:out value="${row.delete}"/></td>
            <td><c:out value="${row.execute}"/></td>
            <td><c:out value="${row.productline}"/></td>
        </tr>
    </c:forEach>
</table>


</body>

</html>
