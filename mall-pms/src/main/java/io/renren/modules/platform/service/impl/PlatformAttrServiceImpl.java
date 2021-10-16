package io.renren.modules.platform.service.impl;

import io.renren.modules.platform.dao.AttrDao;
import io.renren.modules.platform.dao.AttrGroupAttrRelationDao;
import io.renren.modules.platform.entity.PlatformAttrEntity;
import io.renren.modules.platform.service.PlatformAttrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PlatformAttrServiceImpl implements PlatformAttrService {
    @Autowired
    private AttrDao attrDao;
    @Autowired
    private AttrGroupAttrRelationDao relationDao;
    @Override
    public List<PlatformAttrEntity> querySpList(Map<String,Object> params) {
        List<PlatformAttrEntity> attrs = this.attrDao.querySpList(params);
        return attrs;
    }

    @Override
    public List<PlatformAttrEntity> querySellList(Map<String, Object> params) {
        List<PlatformAttrEntity> attrs = this.attrDao.querySellList(params);
        return attrs;
    }

    @Override
    public List<PlatformAttrEntity> queryAttrByAttrGroupId(int attrGroupId) {
        return this.attrDao.queryAttrByAttrGroupId(attrGroupId);
    }

    @Override
    public List<PlatformAttrEntity> queryAttrNoGroup(Map<String,Object> params) {
        return this.attrDao.queryAttrNoGroup(params);
    }

    @Override
    public void delAttr(int[] ids) {
        List<Integer> list = new ArrayList<>();
        for (int id : ids){
            list.add(id);
            this.relationDao.delByAttrId(id);
        }
        this.attrDao.deleteBatchIds(list);
    }

    @Override
    public void addAttr(PlatformAttrEntity platformAttrEntity) {
//        this.attrDao.insert(platformAttrEntity);
//        this.attrDao.updateCatelogId(platformAttrEntity.getId(),platformAttrEntity.getCateGory().getId());
        this.attrDao.addAttr(platformAttrEntity);
        if (platformAttrEntity.getAttrGroup().getId() != 0){
            this.attrDao.addRel(platformAttrEntity.getId(),platformAttrEntity.getAttrGroup().getId());
        }
    }

    @Override
    public void updateAttr(PlatformAttrEntity platformAttrEntity) {
        this.attrDao.updateAttr(platformAttrEntity);
        this.attrDao.updateRel(platformAttrEntity.getAttrGroup().getId(),platformAttrEntity.getRelId());
    }
}
