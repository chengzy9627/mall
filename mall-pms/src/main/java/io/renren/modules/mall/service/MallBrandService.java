package io.renren.modules.mall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.modules.mall.entity.MallBrandEntity;
import io.renren.modules.mall.entity.MallBrandRelCateEntity;

import java.util.List;

public interface MallBrandService extends IService<MallBrandEntity> {
    void addBrand(MallBrandEntity mallBrandEntity);
    List<MallBrandEntity> queryBrand(String name);
    MallBrandEntity queryById(int id);
    void updateBrand(MallBrandEntity mallBrandEntity);
    void delBrand(int[] ids);
    List<MallBrandRelCateEntity> queryBrandRCat(Long brandId);
    void addCatRel(MallBrandRelCateEntity mallBrandRelCateEntity);
    void delCatRel(int id);
}
