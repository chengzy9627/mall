package io.renren.modules.platform.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("pms_attr_group")
public class PlatformAttrGroupEntity {
    @TableId(value = "attr_group_id")
    private int id;
    @TableField(value = "attr_group_name")
    private String name;
    private int sort;
    private String descript;
    private String icon;
    private int catelogId;
    @TableField(exist = false)
    private int value;
    @TableField(exist = false)
    private String label;

    public int getValue() {
        this.value = this.id;
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getLabel() {
        this.label = this.name;
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
