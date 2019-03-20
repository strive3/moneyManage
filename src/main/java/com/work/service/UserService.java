package com.work.service;

import com.work.common.ServerResponse;
import com.work.dao.UserMapper;
import com.work.pojo.User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * @author 杜晓鹏
 * @create 2019-03-19 14:21
 */
public interface UserService {
    /**
     * 登陆
     * @param username
     * @param password
     * @return
     */
    ServerResponse login(String username, String password, HttpSession session);

    ServerResponse register(User user);

    ServerResponse updatePwd(User user);

    User selectById(Integer id);

    ServerResponse checkUsername(String username);
}
