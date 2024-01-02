package com.zbx.hytool.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@TableName(value = "A_SearchFilter")
@Data
public class SearchFilter implements Serializable {

    /**
     * id
     */
    @TableId(value = "Id", type = IdType.AUTO)
    private Integer id;

    /**
     * 父id
     */
    @TableField(value = "ParentId")
    private Integer parentId;

    /**
     * 规则类型 2=报价规则; 11=促销活动规则
     */
    @TableField(value = "SearchFilterType")
    private Integer searchFilterType;

    /**
     * 对应规则id
     */
    @TableField(value = "RefId")
    private Integer refId;

    /**
     * 是否是分组
     */
    @TableField(value = "IsGroup")
    private Boolean isGroup;

    /**
     * 分组类型
     */
    @TableField(value = "GroupOperator")
    private Integer groupOperator;

    /**
     * 条件名称
     */
    @TableField(value = "FieldCaption")
    private String fieldCaption;

    /**
     * 条件名称字段
     */
    @TableField(value = "FieldName")
    private String fieldName;

    /**
     * 字段类型
     */
    @TableField(value = "FieldType")
    private Integer fieldType;

    /**
     * 条件表达式
     */
    @TableField(value = "SearchOperator")
    private Integer searchOperator;

    /**
     * 条件值
     */
    @TableField(value = "Value")
    private String value;

    /**
     * 值显示名称
     */
    @TableField(value = "ValueDisplayText")
    private String valueDisplayText;

    /**
     * 表达式
     */
    @TableField(value = "Expression")
    private String expression;

    /**
     * 表达式显示
     */
    @TableField(value = "ExpressionDisplay")
    private String expressionDisplay;

    /**
     * 子条件
     */
    @TableField(exist = false)
    private List<SearchFilter> children;
}