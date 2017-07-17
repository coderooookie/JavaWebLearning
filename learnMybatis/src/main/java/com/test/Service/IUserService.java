package com.test.Service;

import com.test.Model.User;

import java.util.List;

public interface IUserService {
    public User findUserById(int id);
    public void addUser(User user);
    public List<User> getAllUsers();
}
