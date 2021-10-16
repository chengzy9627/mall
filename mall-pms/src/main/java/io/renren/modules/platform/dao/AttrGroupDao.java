package io.renren.modules.platform.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.platform.entity.PlatformAttrGroupEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AttrGroupDao extends BaseMapper<PlatformAttrGroupEntity> {
    public void deleteByIds(List<Integer> ids);
    public void addAttrRel(int[] ids);
}
