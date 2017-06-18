
<!DOCTYPE HTML>
<html>
<head>
    <title>Save User</title>
    <link rel="stylesheet" href="/css/main.css">
</head>
<body>

<@spring.message "current.locale"/> : ${request.locale}
<div id="global">
    <h4>The User info.</h4>
    <p>
    <h5>Details:</h5>
    User Name: ${newUser.name}<br/>
    User birthday: ${newUser.birthday}<br/>
    User money: ${newUser.money}
    </p>
</div>
</body>
</html>