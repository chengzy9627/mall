package io.renren.modules.mall.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("brand")
public class MallBrandEntity {
    @TableId(value = "brand_id")
    private int id;
    @TableField(value = "brand_name")
    private String name;
    private String url;
    private int status;
    private String text;
    private String search;
    private int sort;
    @TableLogic
    private int showStatus = 1;
}
