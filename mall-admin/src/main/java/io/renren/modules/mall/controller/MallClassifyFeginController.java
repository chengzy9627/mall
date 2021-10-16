package io.renren.modules.mall.controller;

import io.renren.modules.mall.fegin.MallClassifyFeginService;
import org.springframework.web.bind.annotation.RestController;

import io.renren.common.utils.R;
import io.renren.modules.mall.entity.MallCateGoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/mall/classify")
public class MallClassifyFeginController {
    @Autowired
    private MallClassifyFeginService mallClassifyFeginService;
    @GetMapping("/list")
    public R list(){
        return mallClassifyFeginService.list();
    }
    @PostMapping("/add")
    public R add(@RequestBody MallCateGoryEntity cateGory){
        return mallClassifyFeginService.add(cateGory);
    }
    @PostMapping("/update")
    public R update(@RequestBody MallCateGoryEntity cateGory){
        return mallClassifyFeginService.update(cateGory);
    }
    @PostMapping("/delete")
    public R delBatch(@RequestBody Integer[] ids){
        return mallClassifyFeginService.delBatch(ids);
    }
    @GetMapping("/queryId/{id}")
    public R queryId(@PathVariable("id") int id){
        return mallClassifyFeginService.queryId(id);
    }
}
