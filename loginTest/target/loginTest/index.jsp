<%@ page contentType="text/html; charset=utf-8"%>
<html>
<body>
<h2>首页</h2>
<button type="button" onclick=callOrder()>button</button>
<script>
    function callOrder() {
        this.window.location.href='/order'
    }
</script>
<form action="/order">
    <input type="submit" value="查看订单" />
</form>
</body>
</html>
