package peng.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import peng.utils.SqlSessionFactoryUtils;

@WebListener
public class InitSqlSessionListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("监听器销毁中。。。");
    	//SqlSessionFactoryUtils.close();
    }
    public void contextInitialized(ServletContextEvent sce)  {
    	System.out.println("监听器启动中。。。");
    	SqlSessionFactoryUtils.initSqlSessionFactory();
    }
	
}
