package io.renren.modules.platform.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.renren.modules.platform.dao.AttrGroupAttrRelationDao;
import io.renren.modules.platform.dao.AttrGroupDao;
import io.renren.modules.platform.entity.PlatformAttrGroupEntity;
import io.renren.modules.platform.service.PlatformAttrGroupService;
import io.renren.modules.platform.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PlatformAttrGroupServiceImpl implements PlatformAttrGroupService {
    @Autowired
    private AttrGroupDao AttrGroupDao;
    @Autowired
    private AttrGroupAttrRelationDao relationDao;

    @Override
    public List<PlatformAttrGroupEntity> queryAttrGroup(Map<String,Object> params) {
        String name = (String) params.get("name");
        String id = (String)params.get("id");
        List<PlatformAttrGroupEntity> platformAttrGroupEntities = this.AttrGroupDao.selectList(
                new QueryWrapper<PlatformAttrGroupEntity>().eq(StringUtils.isNotBlank(name),"attr_group_name",name).eq(StringUtils.isNotBlank(id),"catelog_id",id));
        return platformAttrGroupEntities;
    }

    @Override
    public void addAttrGroup(PlatformAttrGroupEntity platformAttrGroupEntity) {
        this.AttrGroupDao.insert(platformAttrGroupEntity);
    }

    @Override
    public void delAttrGroup(int[] ids) {
        List<Integer> list = new ArrayList<>();
        for (int id : ids){
            list.add(id);
            this.relationDao.delByAttrGroupId(id);
        }
        this.AttrGroupDao.deleteBatchIds(list);
    }

    @Override
    public void updateAttrGroup(PlatformAttrGroupEntity platformAttrGroupEntity) {
        this.AttrGroupDao.updateById(platformAttrGroupEntity);
    }

}
