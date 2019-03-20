package com.work.service.impl;

import com.work.common.ServerResponse;
import com.work.dao.CostMapper;
import com.work.dao.IncomeMapper;
import com.work.dao.UserMapper;
import com.work.pojo.Cost;
import com.work.pojo.Income;
import com.work.pojo.User;
import com.work.service.AdminService;
import com.work.vo.StudentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 杜晓鹏
 * @create 2019-03-20 17:50
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    IncomeMapper incomeMapper;

    @Autowired
    CostMapper costMapper;

    @Autowired
    UserMapper userMapper;
    /*
    查询所有的消费信息
     */
    @Override
    public ServerResponse selectCostAll() {
        List<Cost> costs = costMapper.selectAll();
        List<StudentVo> studentVos = new ArrayList<>();
        for (Cost cost : costs){
            StudentVo studentVo = getStudentVoByCostAndIncome(cost, null);
            studentVos.add(studentVo);
        }
        return ServerResponse.serverResponseSuccess(studentVos);
    }
    /*
        查询所有的收入信息
         */
    @Override
    public ServerResponse selectIncomeAll() {
        List<Income> incomes = incomeMapper.selectAll();
        List<StudentVo> studentVos = new ArrayList<>();
        for (Income income : incomes){
            StudentVo studentVo = getStudentVoByCostAndIncome(null, income);
            studentVos.add(studentVo);
        }
        return ServerResponse.serverResponseSuccess(studentVos);
    }
    /*
        查询某个学生的消费信息
         */
    @Override
    public StudentVo selectCostByUser(Integer uid) {
        Cost cost = costMapper.selectByUid(uid);
        StudentVo studentVo = getStudentVoByCostAndIncome(cost,null);
        return studentVo;
    }
    /*
        查询某个学生的收入信息
         */
    @Override
    public StudentVo selectIncomeByUser(Integer uid) {
        Income income = incomeMapper.selectByUid(uid);
        StudentVo studentVo = getStudentVoByCostAndIncome(null, income);
        return studentVo;
    }

    @Override
    public ServerResponse insertCost(Cost cost) {
        /*
        如果学生已有信息不让添加第二条
         */
        Cost cost1 = costMapper.selectByUid(cost.getUid());
        if (cost1 == null){
            return ServerResponse.serverResponseError("该学生已有信息不能再添加");
        }

        int insert = costMapper.insert(cost);
        if (insert == 1)
            return ServerResponse.serverResponseSuccess();

        return ServerResponse.serverResponseError("添加失败");
    }

    @Override
    public ServerResponse insertIncome(Income income) {
        /*
        如果学生已有信息不让添加第二条
         */
        Income income1 = incomeMapper.selectByUid(income.getUid());
        if (income1 == null){
            return ServerResponse.serverResponseError("该学生已有信息不能再添加");
        }

        int insert = incomeMapper.insert(income);
        if (insert == 1)
            return ServerResponse.serverResponseSuccess();

        return ServerResponse.serverResponseError("添加失败");
    }

    @Override
    public ServerResponse updateCost(Cost cost) {
        int i = costMapper.updateByPrimaryKey(cost);
        if (i == 1)
            return ServerResponse.serverResponseSuccess();
        return ServerResponse.serverResponseError("修改失败");
    }

    @Override
    public ServerResponse updateIncome(Income income) {
        int i = incomeMapper.updateByPrimaryKey(income);
        if (i == 1)
            return ServerResponse.serverResponseSuccess();
        return ServerResponse.serverResponseError("修改失败");
    }




    /*
    封装一个vo
     */
    private StudentVo getStudentVoByCostAndIncome(Cost cost, Income income){
        User user = null;
        StudentVo studentVo = new StudentVo();


        if (cost == null){
            user = userMapper.selectByPrimaryKey(income.getUid());
            studentVo.setWages(income.getWages());
            studentVo.setWsMessage(income.getWsMessage());
            studentVo.setGains(income.getGains());
            studentVo.setGsMessage(income.getGsMessage());
            studentVo.setBorrow(income.getBorrow());
            studentVo.setBwMessage(income.getBwMessage());
            studentVo.setIeDate(income.getIeDate());

        }
        if (income == null){
            user = userMapper.selectByPrimaryKey(cost.getUid());
            studentVo.setShop(cost.getShop());
            studentVo.setSpMessage(cost.getSpMessage());
            studentVo.setMeat(cost.getMeat());
            studentVo.setMtMessage(cost.getMtMessage());
            studentVo.setHouse(cost.getHouse());
            studentVo.setHeMessage(cost.getHeMessage());
            studentVo.setTravel(cost.getTravel());
            studentVo.setTlMessage(cost.getTlMessage());
            studentVo.setLark(cost.getLark());
            studentVo.setLkMessage(cost.getLkMessage());
            studentVo.setLend(cost.getLend());
            studentVo.setLdMessage(cost.getLdMessage());
            studentVo.setCtDate(cost.getCtDate());
        }

        studentVo.setId(user.getId());
        studentVo.setUsername(user.getUsername());
        return studentVo;
    }

}
