package com.work.service;


import com.work.common.ServerResponse;
import com.work.dao.IncomeMapper;
import com.work.pojo.Cost;
import com.work.pojo.Income;
import com.work.vo.StudentVo;

/**
 * @author 杜晓鹏
 * @create 2019-03-20 17:37
 */
public interface AdminService {


    ServerResponse selectCostAll();

    ServerResponse selectIncomeAll();

    StudentVo selectCostByUser(Integer uid);

    StudentVo selectIncomeByUser(Integer uid);

    ServerResponse insertCost(Cost cost);

    ServerResponse insertIncome(Income income);

    ServerResponse updateCost(Cost cost);

    ServerResponse updateIncome(Income income);

}
