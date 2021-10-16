package io.renren.modules.platform.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

@Data
@TableName("pms_attr_attrgroup_relation")
public class PlatformAttrAttrGroupRelationEntity {
    @TableId
    private int id;
    private int attrId;
    private int attrGroupId;
    @TableField(exist = false)
    private List<Integer> attrIds;
}
