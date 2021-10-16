package io.renren.modules.platform.service.impl;

import io.renren.modules.platform.dao.AttrGroupAttrRelationDao;
import io.renren.modules.platform.entity.PlatformAttrAttrGroupRelationEntity;
import io.renren.modules.platform.service.PlatformAttrGroupAttrRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlatformAttrGroupAttrRelationServiceImpl implements PlatformAttrGroupAttrRelationService {
    @Autowired
    private AttrGroupAttrRelationDao relationDao;
    @Override
    public void addRelation(PlatformAttrAttrGroupRelationEntity platformAttrAttrGroupRelationEntity) {
        List<Integer> attrIds = platformAttrAttrGroupRelationEntity.getAttrIds();
        for (int attrId : attrIds){
            PlatformAttrAttrGroupRelationEntity agar = new PlatformAttrAttrGroupRelationEntity();
            agar.setAttrGroupId(platformAttrAttrGroupRelationEntity.getAttrGroupId());
            agar.setAttrId(attrId);
            this.relationDao.insert(agar);
        }
    }

    @Override
    public void delRelation(int[] ids) {
        List<Integer> list = new ArrayList<>();
        for (int id : ids){
            list.add(id);
        }
        this.relationDao.deleteBatchIds(list);
    }
}
