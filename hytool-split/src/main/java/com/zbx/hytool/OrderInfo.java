package com.zbx.hytool;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderInfo {

    private String orderNo;
    private String orderStatus;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

}
