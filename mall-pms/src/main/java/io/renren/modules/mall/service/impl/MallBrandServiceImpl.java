package io.renren.modules.mall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.modules.mall.dao.BrandDao;
import io.renren.modules.mall.entity.MallBrandEntity;
import io.renren.modules.mall.entity.MallBrandRelCateEntity;
import io.renren.modules.mall.service.MallBrandService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MallBrandServiceImpl extends ServiceImpl<BrandDao, MallBrandEntity> implements MallBrandService {
    @Override
    public List<MallBrandEntity> queryBrand(String name) {
        List<MallBrandEntity> brands = new ArrayList<>();
        if (name != null && !("".equals(name))) {

            brands = this.baseMapper.selectList(new QueryWrapper<MallBrandEntity>().eq("brand_name",name));
        }else{
            brands = this.baseMapper.selectList(new QueryWrapper<MallBrandEntity>());
        }
        return brands;
    }

    @Override
    public void addBrand(MallBrandEntity mallBrandEntity) {
        this.baseMapper.insert(mallBrandEntity);
    }

    @Override
    public void delBrand(int[] ids) {
        Set set = new HashSet();
        for (int id : ids){
            set.add(id);
        }
        this.baseMapper.deleteBatchIds(set);
    }

    @Override
    public void updateBrand(MallBrandEntity mallBrandEntity) {
        this.baseMapper.updateById(mallBrandEntity);
    }

    @Override
    public MallBrandEntity queryById(int id) {
        return this.baseMapper.selectById(id);
    }

    @Override
    public List<MallBrandRelCateEntity> queryBrandRCat(Long brandId) {
        return this.baseMapper.queryBrandRCat(brandId);
    }

    @Override
    public void addCatRel(MallBrandRelCateEntity mallBrandRelCateEntity) {
        this.baseMapper.addBrandRelCat(mallBrandRelCateEntity);
    }

    @Override
    public void delCatRel(int id) {
        this.baseMapper.delBrandRelCat(id);
    }
}
