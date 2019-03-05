<#if user??>
    <span style="color:red;font-size: 48px;">
    欢迎你，${user.name}
    </span>
    <h2>${user.username}</h2>
    <h2>${user.age}</h2>
    <h2>${user.password}</h2>
    <h2>${user.birthday?string('yyyy年MM月dd日 HH时mm分ss秒')}</h2>
    <h2>${user.registryTime?string('yyyy年MM月dd日 HH时mm分ss秒')}</h2>
    <h2>${user.address!'未登记地址'}</h2>

    <#if user.salary <= 1000>
        低收入人群
    <#elseif user.salary <10000>
        中收入人群
    <#else >
        高收入人群
    </#if>

    <#if user.username == 'admin'>
        系统管理员
    </#if>
<#else>
    对象不存在
</#if>