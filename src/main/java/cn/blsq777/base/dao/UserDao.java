package cn.blsq777.base.dao;

import cn.blsq777.base.bean.User;

public interface UserDao
{
    public User getUserById(String id);
    public User getUserByName(String userName);
}
