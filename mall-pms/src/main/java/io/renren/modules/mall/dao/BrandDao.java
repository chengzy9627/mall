package io.renren.modules.mall.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.mall.entity.MallBrandEntity;
import io.renren.modules.mall.entity.MallBrandRelCateEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BrandDao extends BaseMapper<MallBrandEntity> {
    public List<MallBrandRelCateEntity> queryBrandRCat(Long brandId);
    public void addBrandRelCat(MallBrandRelCateEntity mallBrandRelCateEntity);
    public void delBrandRelCat(int id);
}
