package com.work.controller;

import com.work.common.Const;
import com.work.common.ServerResponse;
import com.work.pojo.User;
import com.work.service.impl.UserServiceImpl;
import com.work.utils.VerifyCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 杜晓鹏
 * @create 2019-03-19 14:20
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServiceImpl userService;
    /*
    到登陆页面
     */
    @RequestMapping("/login.do")
    public String login(){
        return "login";
    }
    /*
    登陆时验证码
     */
    @RequestMapping("/code.do")
    public void code(HttpServletResponse response,HttpSession session) throws IOException {
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        //生成随机字串
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
System.out.println("code1:"+verifyCode);
        //删除以前的
        session.removeAttribute("code");
        session.setAttribute("code",verifyCode);
        //生成图片
        int w = 100, h = 30;
        VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);
    }

    /*
    登陆
     */
    @RequestMapping("/logon.do")
    public String login(String username, String password, String code, HttpSession session, Model model) throws IOException {
        String verifyCode = (String)session.getAttribute("code");
System.out.println("codesession:"+verifyCode);
System.out.println("code用户:"+code);
        //验证码正确
        if (code != null && !code.equals("")){
            if (code.toLowerCase().equals(verifyCode.toLowerCase())){
                ServerResponse login = userService.login(username, password, session);
                if (login.getStatus() == 0){
                    User user = (User) session.getAttribute(Const.CURRENT_USER);
                    //1:管理员    0：用户
                    if (user.getRole() == 1)
                        return "main_admin";
                    else
                        return "main_user";
                }
                //登陆失败
                model.addAttribute("error_msg","用户名或密码错误");
            }else{
                model.addAttribute("error_msg_code","验证码错误");

            }
        }else{
            model.addAttribute("error_msg","验证码不能为空");
        }
        //待改
        return "login";
    }
    /*
    到达注册的页面
     */
    @RequestMapping("/register.do")
    public String register() {
        return "user/add_user";
    }
    /*
    注册用户
     */
    @RequestMapping("/add.do")
    @ResponseBody
    public ServerResponse add(String username, @RequestParam("pwd") String password) throws IOException {
        User user = new User();
        System.out.println(username);
        user.setUsername(username);
        user.setPassword(password);

        return userService.register(user);
    }

    @RequestMapping("/check.do")
    @ResponseBody
    public ServerResponse check( String username) {
        System.out.println("---------------------------");
        return userService.checkUsername(username);
    }

    @RequestMapping("/update.do")
    @ResponseBody
    public ServerResponse updatePwd(User user,HttpSession session) {

        User userInfo = (User) session.getAttribute(Const.CURRENT_USER);
        //如果用户为空   说明用户未登陆
        if (user == null) {
            return ServerResponse.serverResponseError("用户未登陆");
        }

        user.setId(userInfo.getId());
        ServerResponse serverResponse = userService.updatePwd(user);
        if (serverResponse.isSuccess()){
            //更新session中的用户信息
            User userInfo1 = userService.selectById(user.getId());
            session.setAttribute(Const.CURRENT_USER,userInfo1);
        }

        return serverResponse;
    }



    @RequestMapping("/logout.do")
    public String logout(HttpSession session) {
        session.invalidate();
        return "login";
    }

}
