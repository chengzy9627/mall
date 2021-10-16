package io.renren.modules.platform.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;


import io.renren.modules.mall.entity.MallCateGoryEntity;
import lombok.Data;

@Data
@TableName("pms_attr")
public class PlatformAttrEntity {
    @TableId(value = "attr_id")
    private int id;
    @TableField(value = "attr_name")
    private String name;
    private int searchType;
    private String icon;
    private String valueSelect;
    private int enable;
    private int attrType;
    private int valueType;
    private int showDesc;
    @TableField(exist = false)
    private MallCateGoryEntity cateGory;
    @TableField(exist = false)
    private PlatformAttrGroupEntity attrGroup;
    @TableField(exist = false)
    private int relId;
}
