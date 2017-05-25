<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page
			import="com.academic.db.*,com.academic.model.*,com.academic.db.dao.*,java.sql.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Homepage</title>
<link rel="stylesheet" type="text/css"
	href="./css/FrontEnd_Homepage.css" media="screen">
<link href="https://fonts.googleapis.com/css?family=Roboto"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
</head>
<body>
	<header> </header>
	<div class="div-body">
		

		<%
			Dao<Course> courseDao = null;
			try {
				courseDao = DAOFactory.getInstance().getCourseDao();
			} catch (SQLException e) {
				out.print("Could not connect to the database");
				e.printStackTrace();
				return;
			}
			
			
			List<Course> list = courseDao.getAll();
			
			//out.print(courseDao.get(1));
			
			request.setAttribute("courses", list);
		%>
		<div class="container-fluid">
			<div class="row">
				<p>
					Welcome <br>Student
				</p>
				<div class="col-md-6">
					<button class="btn btn-block btn-primary">Home</button>
					<button class="btn btn-block btn-primary">Courses</button>
					<button class="btn btn-block btn-primary">Students</button>
					<button class="btn btn-block btn-primary">Teachers</button>
				</div>
				<div class="col-md-6">
					<table class="table table-bordered table-responsive table-hover">
						<thead>
							<tr>
								<th>All Available Courses</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${courses}" var="course">
								<tr>

									<td><a
										href="./html/ViewCourseDetails.jsp?id=${course.getCourseId()}"><c:out
												value="${course.getTitle()}" /></a></td>

								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<footer>
		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-4">
					<h3 class="text-center">
						<a href="#">About</a>
					</h3>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
						do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
						enim ad minim veniam, quis nostrud exercitation ullamco laboris
						nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in
						reprehenderit in voluptate velit esse cillum dolore eu fugiat
						nulla pariatur.</p>
				</div>
				<div class="col-sm-4">
					<h3 class="text-center">
						<a href="#">Useful Links</a>
					</h3>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
						do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
						enim ad minim veniam, quis nostrud exercitation ullamco laboris
						nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in
						reprehenderit in voluptate velit esse cillum dolore eu fugiat
						nulla pariatur.</p>
				</div>
				<div class="col-sm-4">
					<h3 class="text-center">
						<a href="#">Contact Us</a>
					</h3>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
						do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
						enim ad minim veniam, quis nostrud exercitation ullamco laboris
						nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in
						reprehenderit in voluptate velit esse cillum dolore eu fugiat
						nulla pariatur.</p>
				</div>
			</div>
		</div>
	</footer>
</body>
</html>
