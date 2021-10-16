package io.renren.modules.mall.controller;

import io.renren.common.utils.R;
import io.renren.modules.mall.entity.MallCateGoryEntity;
import io.renren.modules.mall.service.MallClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/mall/classify")
public class MallClassifyController {
    @Autowired
    private MallClassifyService mallClassifyService;
    @GetMapping("/list")
    public R list(){
        List<MallCateGoryEntity> mallClassifyEntities = this.mallClassifyService.queryList();
        return R.ok().put("classify",mallClassifyEntities);
    }
    @PostMapping("/add")
    public R add(@RequestBody MallCateGoryEntity cateGory){
        this.mallClassifyService.add(cateGory);
        return R.ok();
    }
    @PostMapping("/update")
    public R update(@RequestBody MallCateGoryEntity cateGory){
        this.mallClassifyService.update(cateGory);
        return R.ok();
    }
    @PostMapping("/delete")
    public R delBatch(@RequestBody Integer[] ids){
        this.mallClassifyService.del(ids);
        System.out.println(Arrays.toString(ids));
        return R.ok();
    }
    @GetMapping("/queryId/{id}")
    public R queryId(@PathVariable("id") int id){
        List<Integer> integerList = this.mallClassifyService.queryId(id);
        System.out.println(integerList);
        return R.ok().put("selectedId",integerList);
    }
}
