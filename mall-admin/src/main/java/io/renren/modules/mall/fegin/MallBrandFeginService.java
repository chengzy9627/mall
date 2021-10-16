package io.renren.modules.mall.fegin;

import io.renren.common.utils.R;
import io.renren.modules.mall.entity.MallBrandEntity;
import io.renren.modules.mall.entity.MallBrandRelCateEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@FeignClient("mall-pms")
public interface MallBrandFeginService {
    @GetMapping("/mall/brand/list")
    public R query(@RequestParam Map<String, Object> params);
    @PostMapping("/mall/brand/pic")
    public R picAdd(@RequestParam("file") MultipartFile file);
    @PostMapping("/mall/brand/add")
    public R brandAdd(@RequestBody MallBrandEntity mallBrandEntity);
    @PostMapping("/mall/brand/update")
    public R brandUpdate(@RequestBody MallBrandEntity mallBrandEntity);
    @PostMapping("/mall/brand/del")
    public R brandDel(@RequestBody int[] ids);
    @GetMapping("/mall/brand/queryById/{id}")
    public R queryById(@PathVariable("id") int id);
    @GetMapping("/mall/brand/catRel/{brandId}")
    public R catRel(@PathVariable("brandId") long brandId);
    @PostMapping("/mall/brand/catRel/add")
    public R catRelAdd(@RequestBody MallBrandRelCateEntity mallBrandRelCateEntity);
    @PostMapping("/mall/brand/catRel/del/{id}")
    public R catRelDel(@PathVariable("id") int id);
}
