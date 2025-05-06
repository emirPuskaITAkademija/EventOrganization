<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%--    <link rel="stylesheet" type="text/css" href="login.css">--%>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Event Login</title>
</head>
<body>

<div style="padding: 20px">
    <section class="login-block">
        <div class="container">
            <div class="row">
                <div class="col-md-6 login-sec">
                    <h2>Join the Event</h2>
                    <!-- Poruka o neispravnoj kombinaciji -->
                    <%
                        String errorMessage = (String) request.getAttribute("errorMessage");
                        if (errorMessage != null) {
                    %>
                    <div class="alert alert-danger" role="alert">
                        <%= errorMessage %>
                    </div>
                    <% } %>

                    <form action="authentication" method="post" class="login-form">
                        <div class="form-group">
                            <label for="username">Username</label>
                            <input id="username" name="username" type="text" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="password">Password</label>
                            <input id="password" name="password" type="password" class="form-control">
                        </div>
                        <button type="submit" class="btn btn-login btn-lg btn-block">Login</button>
                        <a href="registration" class="btn btn-link">Register for the event</a>
                    </form>
                </div>

                <div class="col-md-6 banner-sec">
                    <img class="d-block img-fluid"
                         src="https://images.inc.com/uploaded_files/image/1920x1080/getty_479977238_253066.jpg"
                         alt="Event Image">
                </div>
            </div>
        </div>
    </section>
</div>
</body>
</html>