<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2016/12/16
  Time: 上午9:53
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Spittle</title>
</head>
<body>
    <div class="spittleView">
        <div class spittleMessage><c:out value="${spittle.message}"/> </div>
        <div>
            <span class="spittleTime"><c:out value="${spittle.createtime}"/></span>
        </div>
    </div>

</body>
</html>
