<!DOCTYPE html>
<html>
<head>
  <title>Members</title>
  <style>
    body { font-family: Arial, sans-serif; background: #f4f7fb; margin: 0; }
    .navbar { background: #1f3c88; padding: 15px 30px; }
    .navbar a { color: white; text-decoration: none; margin-right: 20px; font-weight: bold; }
    .container { width: 80%; margin: 40px auto; }
    .card {
      background: white;
      padding: 25px;
      border-radius: 10px;
      box-shadow: 0 2px 10px rgba(0,0,0,0.1);
    }
    input, button {
      padding: 10px;
      margin: 10px 5px 10px 0;
    }
    input { width: 250px; }
    button {
      background: #1f3c88;
      color: white;
      border: none;
      border-radius: 5px;
    }
  </style>
</head>
<body>

<div class="navbar">
  <a href="home">Home</a>
  <a href="members.jsp">Members</a>
  <a href="issue-book.jsp">Issue Book</a>
  <a href="return-book.jsp">Return Book</a>
</div>

<div class="container">
  <div class="card">
    <h2>Add Member</h2>
    <form action="addMember" method="post">
      <input type="text" name="name" placeholder="Member Name" required><br>
      <input type="email" name="email" placeholder="Email" required><br>
      <input type="text" name="phone" placeholder="Phone" required><br>
      <button type="submit">Add Member</button>
    </form>
  </div>
</div>

</body>
</html>