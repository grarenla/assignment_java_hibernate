<%@ page import="entity.User" %>
<%@ page import="entity.Account" %><%
    HttpSession httpSession = request.getSession();
    Account account = (Account) httpSession.getAttribute("account");
    if (account == null) account = new Account();
    String username = account.getUsername();
%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="<%= request.getContextPath()%>/home">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="<%= request.getContextPath()%>/feedback">Send feedback <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="<%= request.getContextPath()%>/manage">Manage<span class="sr-only">(current)</span></a>
            </li>
        </ul>
        <%
            if (username == null) {
        %>
                <a class="btn btn-default my-2 my-lg-0" href="<%= request.getContextPath()%>/register">Register</a>
                <a class="btn btn-default my-2 my-lg-0" href="<%= request.getContextPath()%>/login">Login</a>
        <%
            } else {
        %>
                <a class="btn btn-default my-2 my-lg-0"><%= username%></a>
        <%
            }
        %>
    </div>
</nav>