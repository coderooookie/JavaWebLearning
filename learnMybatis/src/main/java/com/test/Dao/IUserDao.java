package com.test.Dao;

import com.test.Model.User;

import java.util.List;

public interface IUserDao {
        public User findUserById(int id); //查询
        public void addUser(User user); //添加
        public List<User> getAllUsers();
}

