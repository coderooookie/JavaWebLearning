package com.test.Dao;

import com.test.Model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class UserDaoImpl implements IUserDao{
    private SqlSessionFactory sessionFactory;
    private SqlSession session;
    public UserDaoImpl() {
        String resource = "conf.xml";
        try {
            Reader reader = Resources.getResourceAsReader(resource);
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);
            session = sessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public User findUserById(int id) {
        String statement = "userMapper.findUserById";
        User user = (User)session.selectOne(statement, 1);
        return user;
    }
    public void addUser(User user) {
        String statement = "userMapper.addUser";
        session.insert(statement, user);
        session.commit();
    }
    public List<User> getAllUsers(){
        String statement = "userMapper.getAllUsers";
        List<User> list = session.selectList(statement);
        return list;
    }
}
