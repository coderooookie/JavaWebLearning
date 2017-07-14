<%@ page contentType="text/html; charset=utf-8"%>
<html>
<body>
<h2>首页</h2>
<button type="button" onclick=callOrder()>button</button>
<a href="/order">查看订单</a>
<script>
    function callOrder() {
        var xmlHttp=new XMLHttpRequest();
        xmlHttp.open("GET","login.jsp",true);
        xmlHttp.send();
        xmlHttp.onreadystatechange = function() {
            //alert(xmlHttp.responseText);
            if (this.readyState === 4 && this.status === 200) {
                document.write(xmlHttp.responseText);
            }
        }
    }
</script>
<form action="/order">
    <input type="submit" value="查看订单" />
</form>
</body>
</html>
