<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.Feedback" %><%--
  Created by IntelliJ IDEA.
  User: s2rai
  Date: 08-Apr-19
  Time: 11:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList<Feedback> feedbackArrayList = (ArrayList<Feedback>) request.getAttribute("list");
    if (feedbackArrayList == null) feedbackArrayList = new ArrayList<>();
%>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<jsp:include page="navbar.jsp"/>
<section class="content">
    <div class="card">
        <div class="header">
            <h2>List Feedback</h2>
        </div>
        <div class="body">
            <div class="table-responsive">
                <%--<div class="row">--%>
                    <%--<div class="col-sm-12">--%>
                        <table class="table table-bordered table-hover">
                            <thead>
                            <tr class="text-center">
                                <th scope="col">#</th>
                                <th scope="col">Title</th>
                                <th scope="col">Description</th>
                            </tr>
                            </thead>
                            <tbody class="text-center">
                            <%
                                for (Feedback feedback :
                                        feedbackArrayList) {
                            %>
                            <tr>
                                <th scope="row"><%= feedback.getId()%></th>
                                <td><%= feedback.getTitle()%></td>
                                <td><%= feedback.getDescription()%></td>
                            </tr>
                            <%
                                }
                            %>
                            </tbody>
                        </table>
                    <%--</div>--%>
                    <%--</div>--%>
            </div>
        </div>

    </div>
</section>
<%--<div class="container-fluid">--%>
<%--<div class="body table-responsive">--%>

<%--</div>--%>
<%--</div>--%>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>
