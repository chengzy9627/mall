package io.renren.modules.mall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.modules.mall.entity.MallCateGoryEntity;

import java.util.List;

public interface MallClassifyService extends IService<MallCateGoryEntity> {
//    public List<MallClassifyEntity> queryList();
    List<MallCateGoryEntity> queryList();
    List<Integer> queryId(int id);
    void add(MallCateGoryEntity cateGoryEntity);
    void del(Integer[] ids);
    void update(MallCateGoryEntity cateGoryEntity);
}
