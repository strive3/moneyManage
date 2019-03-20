package com.work.controller;

import com.work.common.ServerResponse;
import com.work.pojo.Cost;
import com.work.pojo.Income;
import com.work.pojo.User;
import com.work.service.AdminService;
import com.work.service.UserService;
import com.work.vo.StudentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 杜晓鹏
 * @create 2019-03-20 19:32
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @Autowired
    UserService userService;
    /*
    查找所有的用户
     */
    @RequestMapping("/users")
    @ResponseBody
    public ServerResponse selectAllStudent(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users",users);
        return ServerResponse.serverResponseSuccess(users);
    }

    /**
     * 查看所有学生的消费情况
     */
    @RequestMapping("/conts")
    @ResponseBody
    public ServerResponse selectAllCont(Model model){
        ServerResponse serverResponse = adminService.selectCostAll();
        return serverResponse;
    }
    /**
     * 查看某个学生的消费情况
     */
    @RequestMapping("/conts/{uid}")
    @ResponseBody
    public ServerResponse selectContByUid(@PathVariable("uid") Integer uid, Model model){
        StudentVo studentVo = adminService.selectCostByUser(uid);
        model.addAttribute("studentVo",studentVo);
        return ServerResponse.serverResponseSuccess(studentVo);
    }
    /**
     * 查看所有学生的收入情况
     */
    @RequestMapping("/incomes")
    @ResponseBody
    public ServerResponse selectAllIncome(Model model){
        ServerResponse serverResponse = adminService.selectIncomeAll();
        return serverResponse;
    }
    @RequestMapping("/incomes/{uid}")
    @ResponseBody
    public ServerResponse selectIncomeByUid(@PathVariable("uid") Integer uid, Model model){
        StudentVo studentVo = adminService.selectIncomeByUser(uid);
        model.addAttribute("studentVo",studentVo);
        return ServerResponse.serverResponseSuccess(studentVo);
    }

    //为某个学生添加支出信息
    @RequestMapping("/addCost")
    public String toAddCost(){
        return "";
    }
    @RequestMapping("/insertCost")
    @ResponseBody
    public ServerResponse insertCost(Cost cost){
        ServerResponse serverResponse = adminService.insertCost(cost);
        return serverResponse;
    }

    //为某个学生添加收入信息
    @RequestMapping("/addIncome")
    public String toAddIncome(){
        return "";
    }

    @RequestMapping("/insertIncome")
    @ResponseBody
    public ServerResponse insertIncome(Income income){
        ServerResponse serverResponse = adminService.insertIncome(income);

        return serverResponse;
    }



}
