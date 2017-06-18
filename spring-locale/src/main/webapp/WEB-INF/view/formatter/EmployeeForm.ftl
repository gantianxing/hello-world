<!DOCTYPE HTML>
<html>
<head>
    <title>Add Employee Form</title>
    <link rel="stylesheet" href="/css/main.css">
</head>
<body>

<div id="global">
<form name="employee" action="save-employee1" method="post">
    <fieldset>
        <legend>Add an employee</legend>
        <p>
            <label for="firstName">First Name: </label>
            <input id="firstName" type="text" name="firstName" value="${employee.firstName}" tabindex="1"/>
        </p>
        <p>
            <label for="lastName">Last Name: </label>
            <input id="lastName" type="text" name="lastName" value="${employee.lastName}" tabindex="2"/>
        </p>
        <p>
            <@spring.bind "employee.birthDate" />
            <label for="birthDate">Date Of Birth (MM-dd-yyyy): </label>
            <input id="birthDate" type="text" name="birthDate" value="${employee.birthDate}" tabindex="3"/>
            <@spring.showErrors "<br/>" cssClass="error"/>
        </p>
        <p id="buttons">
            <input id="reset" type="reset" tabindex="4">
            <input id="submit" type="submit" tabindex="5" 
                value="Add Employee">
        </p>
    </fieldset>
</form>
</div>
</body>
</html>
