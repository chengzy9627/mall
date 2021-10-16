package io.renren.modules.platform.service;


import io.renren.modules.platform.entity.PlatformAttrEntity;

import java.util.List;
import java.util.Map;

public interface PlatformAttrService {
    List<PlatformAttrEntity> querySpList(Map<String,Object> params);
    List<PlatformAttrEntity> querySellList(Map<String,Object> params);
    List<PlatformAttrEntity> queryAttrByAttrGroupId(int attrGroupId);
    List<PlatformAttrEntity> queryAttrNoGroup(Map<String,Object> params);
    void delAttr(int[] ids);
    void addAttr(PlatformAttrEntity platformAttrEntity);
    void updateAttr(PlatformAttrEntity platformAttrEntity);
}
