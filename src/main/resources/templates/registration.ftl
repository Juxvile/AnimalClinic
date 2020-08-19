<#import "parts/pageTemplate.ftl" as pt>

<@pt.page>
    <form method="post">
        <input type="hidden" name="id"
               value="<#if user?? && user.id??>${user.id}</#if>">
        <input type="text" name="username"
               class="form-control ${(usernameError??)?string('is-invalid', '')}"
               value="<#if user?? && user.username??>${user.username}</#if>"
               placeholder="Введите username">
        <input type="text" name="password"
               class="form-control ${(passwordError??)?string('is-invalid', '')}"
               value="<#if user?? && user.password??>${user.password}</#if>"
               placeholder="Введите пароль">
        <input type="email" name="email"
               class="form-control ${(emailError??)?string('is-invalid', '')}"
               value="<#if user?? && user.email??>${user.email}</#if>"
               placeholder="Введите ваш e-mail">
        <input type="text" name="firstname"
               class="form-control ${(firstnameError??)?string('is-invalid', '')}"
               value="<#if user?? && user.firstname??>${user.firstname}</#if>"
               placeholder="Введите Фамилия">
        <input type="text" name="lastname"
               class="form-control ${(lastnameError??)?string('is-invalid', '')}"
               value="<#if user?? && user.lastname??>${user.lastname}</#if>"
               placeholder="Введите ваше имя">
        <input type="text" name="surname"
               class="form-control ${(surnameError??)?string('is-invalid', '')}"
               value="<#if user?? && user.surname??>${user.surname}</#if>"
               placeholder="Введите ваш surname">
        <input type="date" name="birthday"
               class="form-control ${(birthdayError??)?string('is-invalid', '')}"
               value="<#if user?? && user.birthday??>${user.birthday}</#if>">
        <input type="submit" value="Submit">

    </form>
</@pt.page>