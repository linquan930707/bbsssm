package cn.blsq777.base.service;

import cn.blsq777.base.bean.User;

public interface UserService
{
    User getUserByUserId(String id);
    User getUserByName(String userName);
}
