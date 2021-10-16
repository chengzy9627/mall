package io.renren.modules.platform.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.platform.entity.PlatformAttrAttrGroupRelationEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AttrGroupAttrRelationDao extends BaseMapper<PlatformAttrAttrGroupRelationEntity> {
    void delByAttrId(int attrId);
    void delByAttrGroupId(int attrGroupId);
}
