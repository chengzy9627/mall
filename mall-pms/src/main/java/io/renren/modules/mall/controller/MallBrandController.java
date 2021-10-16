package io.renren.modules.mall.controller;


import io.renren.common.utils.R;
import io.renren.modules.mall.entity.MallBrandEntity;
import io.renren.modules.mall.entity.MallBrandRelCateEntity;
import io.renren.modules.mall.service.MallBrandService;
import io.renren.modules.mall.utils.FastDFSUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/mall/brand")
public class MallBrandController {
    @Autowired
    private FastDFSUtils fastDFSUtils;
    @Autowired
    private MallBrandService mallBrandService;

    @GetMapping("/list")
    public R query(@RequestParam Map<String, Object> params){
        List<MallBrandEntity> brands = this.mallBrandService.queryBrand((String) params.get("name"));
        return R.ok().put("brands",brands);
    }
    @PostMapping("/pic")
    public R picAdd(@RequestParam("file") MultipartFile file){
        String url = null;
        try {
            url = fastDFSUtils.uploadFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(url);
        return R.ok().put("url",url);
    }
    @PostMapping("/add")
    public R brandAdd(@RequestBody MallBrandEntity mallBrandEntity){
        this.mallBrandService.addBrand(mallBrandEntity);
        return R.ok();
    }
    @PostMapping("/update")
    public R brandUpdate(@RequestBody MallBrandEntity mallBrandEntity){
        this.mallBrandService.updateBrand(mallBrandEntity);
        return R.ok();
    }
    @PostMapping("/del")
    public R brandDel(@RequestBody int[] ids){
        System.out.println(Arrays.toString(ids));
        this.mallBrandService.delBrand(ids);
        return R.ok();
    }
    @GetMapping("/queryById/{id}")
    public R queryById(@PathVariable("id") int id){
        MallBrandEntity mallBrandEntity = this.mallBrandService.queryById(id);
        System.out.println(mallBrandEntity);
        return R.ok().put("brand",mallBrandEntity);
    }
    @GetMapping("/catRel/{brandId}")
    public R catRel(@PathVariable("brandId") long brandId){
        List<MallBrandRelCateEntity> mallBrandRelCateEntities = this.mallBrandService.queryBrandRCat(brandId);
        return R.ok().put("cateRel",mallBrandRelCateEntities);
    }
    @PostMapping("/catRel/add")
    public R catRelAdd(@RequestBody MallBrandRelCateEntity mallBrandRelCateEntity){
        this.mallBrandService.addCatRel(mallBrandRelCateEntity);
        return R.ok();
    }
    @PostMapping("/catRel/del/{id}")
    public R catRelDel(@PathVariable("id") int id){
        this.mallBrandService.delCatRel(id);
        return R.ok();
    }
}
