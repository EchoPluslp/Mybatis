package peng.service;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import peng.dao.UsersDao;
import peng.entity.Users;

@WebServlet("/deluser")
public class UserDelServlet extends HttpServlet {
	private UsersDao usersDao = new UsersDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取参数
		String id = request.getParameter("id");
		String type = request.getParameter("type");
		System.out.println("type="+type);
		//执行删除或者锁定操作
		if(Objects.equals(type, "lock")) {
			//锁定操作！！！其实就是update操作
			Users users = new Users();
			users.setId(Integer.parseInt(id));
			users.setUserStatus(1);
			usersDao.updateUser(users);
		}else if(Objects.equals(type, "del")) {
			//删除操作！！！ delele操作
			usersDao.delById(Integer.parseInt(id));
		}else if(Objects.equals(type, "unlock")) {
			Users users = new Users();
			users.setId(Integer.parseInt(id));
			users.setUserStatus(0);
			usersDao.updateUser(users);
		}
		//跳转到首页
		response.sendRedirect(request.getContextPath()+"/index");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
