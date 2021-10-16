package io.renren.modules.mall.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.mall.entity.MallCateGoryEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface ClassifyDao extends BaseMapper<MallCateGoryEntity> {
    public List<MallCateGoryEntity> queryList();
    public List<MallCateGoryEntity> queryListParentId();
    public int queryId(int id);

}
