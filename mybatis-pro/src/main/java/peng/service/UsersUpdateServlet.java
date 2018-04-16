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

/**
 * Servlet implementation class UsersUpdateServlet
 */
@WebServlet("/updateusers")
public class UsersUpdateServlet extends HttpServlet {

	private UsersDao usersDao = new UsersDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取用户要更新的数据
		String id = request.getParameter("id");
		String nickname = request.getParameter("nickname");
		String age = request.getParameter("age");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String remark = request.getParameter("remark");
		// 创建用户对象
		Users users = new Users(Integer.parseInt(id),nickname,Integer.parseInt(age),gender,email,phone,remark,new Date());
		// 提交更新
		usersDao.updateUser(users);
		// 查看更新后的用户信息
		response.sendRedirect(request.getContextPath()+"/detail?id="+users.getId());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
