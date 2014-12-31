<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<header>
    <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container-fluid">
            <ul class="nav navbar-nav navbar-right">
                <li><p class="user-name">
                    Hi,
                    <c:out value="${pageContext.request.remoteUser}"/>
                </p></li>
                <li class="dropdown"><a href="#"
                                        class="dropdown-toggle settings-icon" data-toggle="dropdown"></a>
                    <ul class="dropdown-menu dropdown-menu-margin-top" role="menu">
                        <li>
                            <form action="/logout" method="post">
                                <input type="submit" class="submitLink" value="Log out"/>
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            </form>
                        </li>
                        <li><a href="/user/list" class="btn btn-link">User Management</a></li>
                        <li><a href="/user/change-password" class="btn btn-link">Change Password</a></li>
                    </ul>
                </li>
            </ul>
            </li>
            </ul>
        </div>
    </div>
</header>
