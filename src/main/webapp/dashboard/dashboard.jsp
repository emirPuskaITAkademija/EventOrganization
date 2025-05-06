<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Event Dashboard</title>

  <style>
    body {
      font-family: 'Poppins', sans-serif;
      background: linear-gradient(to bottom, #1e1e2f, #3a3a5f);
      color: #fff;
    }
    .dashboard-container {
      padding: 40px;
      background: rgba(255, 255, 255, 0.1);
      border-radius: 15px;
      box-shadow: 0px 10px 30px rgba(0, 0, 0, 0.3);
    }
    .card {
      background: #22223b;
      border: none;
      color: #fff;
    }
    .card-title {
      color: #ffcc00;
    }
    .btn-custom {
      background: #ffcc00;
      color: #1e1e2f;
      font-weight: 600;
      padding: 12px;
      border-radius: 8px;
      transition: 0.3s;
    }
    .btn-custom:hover {
      background: #ffaa00;
    }
  </style>
</head>
<body>

<div class="container mt-5">
  <div class="dashboard-container">
    <h1 class="text-center">Welcome, <%= request.getAttribute("username") %>!</h1>
    <p class="text-center">Manage your events and stay updated.</p>

    <div class="row mt-4">
      <div class="col-md-4">
        <div class="card text-center">
          <div class="card-body">
            <h5 class="card-title">Upcoming Events</h5>
            <p class="card-text">Check out the latest upcoming events!</p>
            <a href="#" class="btn btn-custom">View Events</a>
          </div>
        </div>
      </div>

      <div class="col-md-4">
        <div class="card text-center">
          <div class="card-body">
            <h5 class="card-title">Manage Your Profile</h5>
            <p class="card-text">Edit your personal details and preferences.</p>
            <a href="#" class="btn btn-custom">Profile Settings</a>
          </div>
        </div>
      </div>

      <div class="col-md-4">
        <div class="card text-center">
          <div class="card-body">
            <h5 class="card-title">Event Statistics</h5>
            <p class="card-text">View analytics and reports on event participation.</p>
            <a href="#" class="btn btn-custom">View Stats</a>
          </div>
        </div>
      </div>
    </div>

    <div class="text-center mt-5">
      <a href="logout.jsp" class="btn btn-danger">Logout</a>
    </div>
  </div>
</div>

</body>
</html>