package io.renren.modules.platform.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.platform.entity.PlatformAttrEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface AttrDao extends BaseMapper<PlatformAttrEntity> {
    List<PlatformAttrEntity> querySpList(Map<String,Object> params);
    List<PlatformAttrEntity> querySellList(Map<String,Object> params);
    List<PlatformAttrEntity> queryAttrGroup(int attrId);
    List<PlatformAttrEntity> queryAttrByAttrGroupId(int attrGroupId);
    List<PlatformAttrEntity> queryAttrNoGroup(Map<String,Object> params);
    void updateCatelogId(@Param("attrId")int attrId, @Param("catelogId")int catelogId);
    void addRel(@Param("attrId")int attrId, @Param("attrGroupId")int attrGroupId);
    void addAttr(PlatformAttrEntity platformAttrEntity);
    void updateAttr(PlatformAttrEntity platformAttrEntity);
    void updateRel(@Param("attrGroupId")int attrGroupId, @Param("relId")int relId);
    int queryRelId(int attrId);
}
