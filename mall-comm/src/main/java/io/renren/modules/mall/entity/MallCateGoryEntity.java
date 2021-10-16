package io.renren.modules.mall.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@TableName("pms_category")
public class MallCateGoryEntity implements Serializable {
    @TableId(value = "cat_id")
    private int id;
    @TableField(value = "name")
    private String label;
    private int parentCid;
    private int catLevel;
    @TableLogic
    private int showStatus=1;
    private int sort;
    private String icon;
    private String productUnit;
    private int productCount;
    @TableField(exist = false)
    private List<MallCateGoryEntity> children;
    @TableField(exist = false)
    private int value;
    public void setValue(){
        this.value = this.id;
    }
    public int getValue(){
        this.setValue();
        return value;
    }
}
