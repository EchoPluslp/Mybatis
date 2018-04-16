package peng.service;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import peng.dao.UsersDao;
import peng.entity.Users;
@WebServlet("/addusers")
public class UsersAddServlet extends HttpServlet {
	UsersDao usersDao = new UsersDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取要添加的用户数据
		String username = request.getParameter("username");
		String userpass = request.getParameter("userpass");
		String nickname = request.getParameter("nickname");
		String age = request.getParameter("age");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String remark = null;
		//根据用户数据创建一个用户对象
		Users users = new Users(username,userpass,nickname,Integer.parseInt(age),gender,email,phone,new Date(),new Date(),new Date(),0,remark);
		//将用户对象添加到数据库中
		users = usersDao.addUser(users);
		System.out.println(users.getName()+":"+users.getEmail());
		System.out.println(users.getId());
		response.sendRedirect(request.getContextPath()+"/detail?id="+users.getId());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
