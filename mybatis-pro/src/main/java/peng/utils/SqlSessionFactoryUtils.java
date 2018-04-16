package peng.utils;

import java.io.IOException;
import java.io.InputStream;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryUtils {
	private static SqlSessionFactory sessionFactory;
	
	private static final String RESOURCE = "mybatis-config.xml";
	
	private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();
	
	//获得sqlsessionfactory
	public static 	void initSqlSessionFactory() {
		try {
			InputStream inputStream = Resources.getResourceAsStream(RESOURCE);
			sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("获得sqlsession方法失败。。。");
		}
	}
	//返回sqlsessionfactor的方法
	public static SqlSessionFactory getSqlSession() {
		return sessionFactory;
	}
	//关闭sqlsession
	public static void close() {
		SqlSession session = threadLocal.get();
		if(session!=null) {
			session.close();
			threadLocal.set(null);
		}
	}
}
