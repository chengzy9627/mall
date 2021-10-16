package io.renren.modules.platform.service;

import io.renren.modules.platform.entity.PlatformAttrGroupEntity;

import java.util.List;
import java.util.Map;

public interface PlatformAttrGroupService {
    public List<PlatformAttrGroupEntity> queryAttrGroup(Map<String,Object> params);
    public void addAttrGroup(PlatformAttrGroupEntity platformAttrGroupEntity);
    public void delAttrGroup(int[] ids);
    public void updateAttrGroup(PlatformAttrGroupEntity platformAttrGroupEntity);
}
