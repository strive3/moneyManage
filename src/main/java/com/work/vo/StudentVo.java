package com.work.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 杜晓鹏
 * @create 2019-03-20 17:56
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentVo {
    private Integer id;
    private String username;
    //零花钱
    private Double wages;
    private String wsMessage;
    //外快
    private Double gains;
    private String gsMessage;
    //借入
    private Double borrow;
    private String bwMessage;
    private Date ieDate;


    //购物
    private Double shop;
    private String spMessage;
    //吃饭
    private Double meat;
    private String mtMessage;
    //租房
    private Double house;
    private String heMessage;
    //旅行
    private Double travel;
    private String tlMessage;
    //玩乐
    private Double lark;
    private String lkMessage;
    //借出
    private Double lend;
    private String ldMessage;
    private Date ctDate;
}
