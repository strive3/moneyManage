package com.work.dao;

import com.work.pojo.Cost;
import java.util.List;

public interface CostMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cost
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cost
     *
     * @mbg.generated
     */
    int insert(Cost record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cost
     *
     * @mbg.generated
     */
    Cost selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cost
     *
     * @mbg.generated
     */
    List<Cost> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cost
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Cost record);
}