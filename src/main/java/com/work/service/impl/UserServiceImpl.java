package com.work.service.impl;

import com.work.common.Const;
import com.work.common.ErrorCode;
import com.work.common.ServerResponse;
import com.work.dao.UserMapper;
import com.work.pojo.User;
import com.work.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 杜晓鹏
 * @create 2019-03-19 14:27
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public ServerResponse login(String username, String password, HttpSession session) {
        if (username == null || username.equals("")){
            return ServerResponse.serverResponseError("用户名不能为空");
        }
        if (password == null || password.equals("")){
            return ServerResponse.serverResponseError("密码不能为空");
        }
        User user = userMapper.findByUsernameAndPassword(username, password);
        if (user != null) {
            session.setAttribute(Const.CURRENT_USER, user);
            return ServerResponse.serverResponseSuccess();
        }
        return ServerResponse.serverResponseError("登陆失败");
    }

    @Override
    public ServerResponse register(User user) {
        if (user.getUsername()== null || user.getUsername().equals(""))
            return ServerResponse.serverResponseError("用户名不能为空");

        if (user.getPassword()== null || user.getPassword().equals(""))
            return ServerResponse.serverResponseError("密码不能为空");

        User user1 = userMapper.checkUsername(user.getUsername());
        if (user1 != null)
            return ServerResponse.serverResponseError("用户名已存在");

        int insert = userMapper.insert(user);
        if (insert == 1)
            return ServerResponse.serverResponseSuccess();
        return ServerResponse.serverResponseError("注册失败");
    }

    @Override
    public ServerResponse updatePwd(User user) {
        int i = userMapper.updateByPrimaryKey(user);
        if (i == 1)
            return ServerResponse.serverResponseSuccess();
        return ServerResponse.serverResponseError("更新失败");
    }

    @Override
    public User selectById(Integer id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    @Override
    public ServerResponse checkUsername(String username) {
        if (username == null || username.equals(""))
            return ServerResponse.serverResponseError("用户名不能为空");
        User user = userMapper.checkUsername(username);
        if (user == null)
            return ServerResponse.serverResponseSuccess();
        return ServerResponse.serverResponseError("用户名已存在");
    }

    /**
     * 查找所有的学生
     * @return
     */
    @Override
    public List<User> findAll() {
        List<User> users = userMapper.selectAll();

        return users;
    }


}

