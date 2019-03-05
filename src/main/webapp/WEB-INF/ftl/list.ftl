<ul>
    <#list users as user>
        <li>${user_index+1}-${user.username}-${user.name}-${user.password}</li>
    </#list>
</ul>