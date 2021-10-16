package io.renren.modules.platform.service;

import io.renren.modules.platform.entity.PlatformAttrAttrGroupRelationEntity;

public interface PlatformAttrGroupAttrRelationService {
    void addRelation(PlatformAttrAttrGroupRelationEntity platformAttrAttrGroupRelation);
    void delRelation(int[] ids);
}
