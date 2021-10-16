package io.renren.modules.mall.fegin;

import io.renren.common.utils.R;
import io.renren.modules.mall.entity.MallCateGoryEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("mall-pms")
public interface MallClassifyFeginService {
    @GetMapping("/mall/classify/list")
    public R list();
    @PostMapping("/mall/classify/add")
    public R add(@RequestBody MallCateGoryEntity cateGory);
    @PostMapping("/mall/classify/update")
    public R update(@RequestBody MallCateGoryEntity cateGory);
    @PostMapping("/mall/classify/delete")
    public R delBatch(@RequestBody Integer[] ids);
    @GetMapping("/mall/classify/queryId/{id}")
    public R queryId(@PathVariable("id") int id);
}
