package io.renren.modules.mall.controller;

import io.renren.common.utils.R;
import io.renren.modules.mall.entity.MallBrandEntity;
import io.renren.modules.mall.entity.MallBrandRelCateEntity;
import io.renren.modules.mall.fegin.MallBrandFeginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("/mall/brand")
public class MallBrandFeginController {
    @Autowired
    private MallBrandFeginService mallBrandFeginService;

    @GetMapping("/list")
    public R query(@RequestParam Map<String, Object> params){
        return mallBrandFeginService.query(params);
    }
    @PostMapping("/pic")
    public R picAdd(@RequestParam("file") MultipartFile file){
        return mallBrandFeginService.picAdd(file);
    }
    @PostMapping("/add")
    public R brandAdd(@RequestBody MallBrandEntity mallBrandEntity){
        return mallBrandFeginService.brandAdd(mallBrandEntity);
    }
    @PostMapping("/update")
    public R brandUpdate(@RequestBody MallBrandEntity mallBrandEntity){
        return mallBrandFeginService.brandUpdate(mallBrandEntity);
    }
    @PostMapping("/del")
    public R brandDel(@RequestBody int[] ids){
        return mallBrandFeginService.brandDel(ids);
    }
    @GetMapping("/queryById/{id}")
    public R queryById(@PathVariable("id") int id){
        return mallBrandFeginService.queryById(id);
    }
    @GetMapping("/catRel/{brandId}")
    public R catRel(@PathVariable("brandId") long brandId){
        return mallBrandFeginService.catRel(brandId);
    }
    @PostMapping("/catRel/add")
    public R catRelAdd(@RequestBody MallBrandRelCateEntity mallBrandRelCateEntity){
        return mallBrandFeginService.catRelAdd(mallBrandRelCateEntity);
    }
    @PostMapping("/catRel/del/{id}")
    public R catRelDel(@PathVariable("id") int id){
        return mallBrandFeginService.catRelDel(id);
    }
}
