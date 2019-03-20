package com.work.dao;

import com.work.pojo.Income;
import java.util.List;

public interface IncomeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table income
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table income
     *
     * @mbg.generated
     */
    int insert(Income record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table income
     *
     * @mbg.generated
     */
    Income selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table income
     *
     * @mbg.generated
     */
    List<Income> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table income
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Income record);

    Income selectByUid(Integer uid);
}