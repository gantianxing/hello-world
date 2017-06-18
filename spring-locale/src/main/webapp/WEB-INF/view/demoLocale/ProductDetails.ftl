
<!DOCTYPE html>
<html>
<head>
<title><@spring.message "save.product.t"/></title>
<!--<style type="text/css">@import url("<c:url value="/css/main.css"/>");</style> -->
<link rel="stylesheet" href="/css/main.css">
</head>
<body>

<div id="global">
    <h4><@spring.message "save.result"/></h4>
    <p>
        <h5><@spring.message "save.details"/>:</h5>
        <@spring.message "save.product.name"/>: ${product.name}<br/>
        <@spring.message "save.description"/>: ${product.description}<br/>
        <@spring.message "save.price"/>:
        <#if unit== '0'>
            <@spring.message "price.unit"/>${product.price}
        <#else>
            ${product.price}<@spring.message "price.unit"/>
        </#if>
    </p>
</div>
</body>
</html>