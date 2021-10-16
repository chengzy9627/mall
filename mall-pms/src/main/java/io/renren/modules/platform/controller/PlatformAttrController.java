package io.renren.modules.platform.controller;

import io.renren.common.utils.R;
import io.renren.modules.platform.entity.PlatformAttrEntity;
import io.renren.modules.platform.service.PlatformAttrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/platform")
public class PlatformAttrController {
    @Autowired
    private PlatformAttrService platformAttrService;

    @GetMapping("/specification/list")
    public R querySpAll(@RequestParam Map<String,Object> params){
        List<PlatformAttrEntity> platformAttrEntities = this.platformAttrService.querySpList(params);
        return R.ok().put("attr",platformAttrEntities);
    }
    @GetMapping("/sell/list")
    public R querySaleAll(@RequestParam Map<String,Object> params){
        List<PlatformAttrEntity> platformAttrEntities = this.platformAttrService.querySellList(params);
        return R.ok().put("attr",platformAttrEntities);
    }
    @GetMapping("/attr/{id}")
    public R queryAttr(@PathVariable("id") int attrGroupId){
        List<PlatformAttrEntity> attrs = this.platformAttrService.queryAttrByAttrGroupId(attrGroupId);
        return R.ok().put("attr",attrs);
    }
    @GetMapping("/attr/nogroup")
    public R queryAttrNoGroup(@RequestParam Map<String,Object> params){
        List<PlatformAttrEntity> attrs = this.platformAttrService.queryAttrNoGroup(params);
        return R.ok().put("attr",attrs);
    }
    @PostMapping("/attr/del")
    public R delAttr(@RequestBody int[] ids){
        System.out.println(Arrays.toString(ids));
        this.platformAttrService.delAttr(ids);
        return R.ok();
    }
    @PostMapping("/attr/add")
    public R addAttr(@RequestBody PlatformAttrEntity attrEntity){
        System.out.println(attrEntity);
        this.platformAttrService.addAttr(attrEntity);
        return R.ok();
    }
    @PostMapping("/attr/update")
    public R updateAttr(@RequestBody PlatformAttrEntity attrEntity){
        System.out.println(attrEntity);
        this.platformAttrService.updateAttr(attrEntity);
        return R.ok();
    }


}
