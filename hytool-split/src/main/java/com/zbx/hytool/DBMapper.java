package com.zbx.hytool;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;

@Mapper
public interface DBMapper {

    @Select(value = "select top(1) OrderID as orderNo, StartTime as startTime, CreateDate as endTime, OrderStatus as orderStatus from OrderLog where CreateDate > #{lastTime}")
    OrderInfo selectTopOrder(LocalDateTime lastTime);

}
