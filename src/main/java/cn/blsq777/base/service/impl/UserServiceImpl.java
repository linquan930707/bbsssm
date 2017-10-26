package cn.blsq777.base.service.impl;

import cn.blsq777.base.bean.User;
import cn.blsq777.base.dao.UserDao;
import cn.blsq777.base.service.UserService;
import cn.blsq777.common.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserDao   userDao;
    @Autowired
    private RedisUtil redisUtil;


    @Override
    public User getUserByUserId(String id){
        return this.userDao.getUserById(id);
    }

    @Override
    public User getUserByName(String userName)
    {
        User                                        usr         =new User();
        usr=(User)redisUtil.get(userName);
        if (usr==null){
            usr=this.userDao.getUserByName(userName);
            redisUtil.set(userName,usr);
        }
        return usr;
    }
}
