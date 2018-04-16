package peng.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import peng.dao.UsersDao;
import peng.entity.Users;

/**
 * Servlet implementation class UsersFindByIdServlet
 */
//增加注释
@WebServlet("/detail")
public class UsersFindByIdServlet extends HttpServlet {
	//创建Dao类
			UsersDao usersDao = new UsersDao();
			/*
			 * 创建对应的日记记录对象
			 * 通过不同的几级别对日志进行记录（DWBUG/WARN/INFO)
			 */
	private Logger logger = Logger.getLogger(UsersFindByIdServlet.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		System.out.println("detailOF id = "+id);
		logger.info("获取到查询参数ID" + id);
		Users user = usersDao.findById(Integer.parseInt(id));
		logger.info("查询数据完成，查询到的数据"+user);
		request.setAttribute("user", user);
		request.getRequestDispatcher("detail.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
