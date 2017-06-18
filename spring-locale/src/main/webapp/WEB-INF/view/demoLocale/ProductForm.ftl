
<!DOCTYPE html>
<html>
<head>
    <title><@spring.message "page.productform.title"/> </title>
    <link rel="stylesheet" href="/css/main.css">
</head>
<body>

<div id="global">
<@spring.message "current.locale"/> : ${request.locale}
<br/>

<@spring.message "select.language"/> : <span><a href="javascript:void(0)" onclick="changeLanguage('en')">EN</a></span>
|<span><a href="javascript:void(0)" onclick="changeLanguage('zh_CN')">CN</a></span>

    <form name="product" action="save-product" method="post">
    <fieldset>
        <legend><@spring.message "form.name"/></legend>
        <p>
            <@spring.bind "product.name" />
            <label for="name"><@spring.message "label.productName"/>:</label>
            <input id="name" type="text" name="name" cssErrorClass="error"/>
            <@spring.showErrors "<br/>" cssClass="error"/>
        </p>
        <p>
            <label for="description"><@spring.message "label.description"/>: </label>
            <input id="description" type="text" name="description"/>
        </p>
        <p>
            <@spring.bind "product.price" />
            <label for="price"><@spring.message "label.price"/>: </label>
            <input id="price" type="text" name="price" cssErrorClass="error"/>
            <@spring.showErrors "<br/>" cssClass="error"/>
        </p>
        <p id="buttons">
            <input id="reset" type="reset" tabindex="4" 
                value="<@spring.message "button.reset"/>">
            <input id="submit" type="submit" tabindex="5" 
                value="<@spring.message "button.submit"/>">
        </p>
    </fieldset>
</form>
</div>
</body>
</html>
<script type="text/javascript" src="//misc.360buyimg.com/jdf/lib/jquery-1.6.4.js?t=1705252218"></script>
<script type="text/javascript">
function changeLanguage(language)
{
    $.ajax({
        type: "POST",
        url:"/changelanguage",
        data: "new_lang="+language,
        dataType:"text",
        async: true,
        error: function(data, error) {alert("change lang error!"); alert(error)},
        success: function(data)
        {
            window.location.reload();
        }
    });
}
</script>
