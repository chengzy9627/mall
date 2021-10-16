package io.renren.modules.mall.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.modules.mall.dao.ClassifyDao;
import io.renren.modules.mall.entity.MallCateGoryEntity;
import io.renren.modules.mall.service.MallClassifyService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MallClassifyServiceImpl extends ServiceImpl<ClassifyDao, MallCateGoryEntity> implements MallClassifyService {

    @Override
    public List<MallCateGoryEntity> queryList() {
//        List<MallCateGoryEntity> list = this.baseMapper.queryList();
        List<MallCateGoryEntity> list = this.baseMapper.selectList(new QueryWrapper<MallCateGoryEntity>().eq("parent_cid",0));
        List<MallCateGoryEntity> children = this.getChildren(list);
        return children;
    }

    @Override
    public void add(MallCateGoryEntity cateGoryEntity) {
        this.baseMapper.insert(cateGoryEntity);
    }

    @Override
    public void del(Integer[] ids) {
        this.removeByIds(Arrays.asList(ids));
//        Set set = new HashSet();
//        for (int id : ids){
//            set.add(id);
//        }
//        this.baseMapper.deleteBatchIds(set);
    }

    @Override
    public void update(MallCateGoryEntity cateGoryEntity) {
        this.baseMapper.updateById(cateGoryEntity);
    }

    @Override
    public List<Integer> queryId(int id) {
        int pid = 0;
        List<Integer> integerList = new ArrayList<>();
        do {
            integerList.add(0,id);
            pid = this.baseMapper.queryId(id);
            id = pid;
        }while (pid!=0);
        return integerList;
    }

    private List<MallCateGoryEntity> getChildren(List<MallCateGoryEntity> list){
        List<MallCateGoryEntity> children = new ArrayList<>();
        List<MallCateGoryEntity> c = new ArrayList<>();
        for (MallCateGoryEntity cateGoryEntity : list){
            if (cateGoryEntity.getCatLevel() != 3){
                List<MallCateGoryEntity> list1 = this.baseMapper.selectList(new QueryWrapper<MallCateGoryEntity>().eq("parent_cid", cateGoryEntity.getId()));
                c = this.getChildren(list1);
                cateGoryEntity.setChildren(c);
            }
            children.add(cateGoryEntity);
        }
        return children;
    }
}
