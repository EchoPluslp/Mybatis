package peng.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import peng.entity.Users;
import peng.utils.SqlSessionFactoryUtils;

public class UsersDao {
	private List<Users> lists;
	private SqlSession sqlSession;

	// 注意！！！此处应该把session单独列出来，避免session意外关闭！！！
	// Error querying database. Cause: org.apache.ibatis.executor.ExecutorException:
	// Executor was closed.
	private SqlSession getSqlSession() {
		sqlSession = SqlSessionFactoryUtils.getSqlSession().openSession();
		return sqlSession;
	}
	// 通过session查找到相应的值
	public List<Users> findAll() {
		// 通过mapper中的属性，执行相应的sql语句
		try {
			lists = getSqlSession().selectList("findUsers");
		} catch (Exception e) {
			System.out.println("获得结果错误！findAll！！");
		} finally {
			SqlSessionFactoryUtils.close();
		}
		return lists;
	}

	// 根据编号查询单个用户
	public Users findById(Integer id) {
		// 通过mapper中的属性，执行相应的sql语句
		// 为单个用户查询
		Users users = null;
		try {
			// 此时，当使用了sql动态语句时，mapper里面的id，其实是从命名空间里来的
			// 即Users里面的ID，并不是当前的ID。所以我们需要改变一下,并且当前参数会和上面的不一样！！
			users = getSqlSession().selectOne("findUsers", new Users(id));
		} catch (Exception e) {
			System.out.println("获得结果错误findById！！！");
		} finally {
			SqlSessionFactoryUtils.close();
		}
		return users;
	}

	// 增加一个新用户数据
	public Users addUser(Users user) {
		try {
			// 返回值，insert执行过程中影响的行数
			getSqlSession().insert("addUser", user);
			// 添加数据，一定要提交！
			sqlSession.commit();
		} catch (Exception e) {
			System.out.println("获得结果错误！addUser！！");
		} finally {
			SqlSessionFactoryUtils.close();
		}
		return user;
	}
	
	
	// 修改用户信息
		public Users updateUser(Users user) {
			try {
				// 返回值，insert执行过程中影响的行数
				getSqlSession().update("updateuser",user);
				// 添加数据，一定要提交！
				sqlSession.commit();
			} catch (Exception e) {
				System.out.println("获得结果错误！！updateUser！");
			} finally {
				SqlSessionFactoryUtils.close();
			}
			return user;
		}
		
		//删除操作
		public void delById(Integer id) {
			try {
				getSqlSession().delete("deluser",id);
				sqlSession.commit();
			} catch (Exception e) {
				System.out.println("获得结果错误！！delById！");
			} finally {
				SqlSessionFactoryUtils.close();
			}
		}
}
