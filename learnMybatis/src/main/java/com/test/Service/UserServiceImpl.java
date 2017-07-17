package com.test.Service;

import com.test.Dao.IUserDao;
import com.test.Dao.UserDaoImpl;
import com.test.Model.User;

import java.util.List;

public class UserServiceImpl implements IUserService {
    private IUserDao userDao;

    public UserServiceImpl() {
        userDao = new UserDaoImpl();
    }

    public User findUserById(int id) {
        return userDao.findUserById(id);
    }
    public void addUser(User user){
        userDao.addUser(user);
    }
    public List<User> getAllUsers(){
        return userDao.getAllUsers();
    }
}
