package io.renren.modules.platform.controller;

import io.renren.common.utils.R;
import io.renren.modules.platform.fegin.PlatformAttrFeginService;
import io.renren.modules.platform.entity.PlatformAttrEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/platform")
public class PlatformAttrFeginController {
    @Autowired
    private PlatformAttrFeginService platformAttrFeginService;

    @GetMapping("/specification/list")
    public R querySpAll(@RequestParam Map<String,Object> params){
        return platformAttrFeginService.querySpAll(params);
    }
    @GetMapping("/sell/list")
    public R querySaleAll(@RequestParam Map<String,Object> params){
        return platformAttrFeginService.querySaleAll(params);
    }
    @GetMapping("/attr/{id}")
    public R queryAttr(@PathVariable("id") int attrGroupId){
        return platformAttrFeginService.queryAttr(attrGroupId);
    }
    @GetMapping("/attr/nogroup")
    public R queryAttrNoGroup(@RequestParam Map<String,Object> params){
        return platformAttrFeginService.queryAttrNoGroup(params);
    }
    @PostMapping("/attr/del")
    public R delAttr(@RequestBody int[] ids){
        return platformAttrFeginService.delAttr(ids);
    }
    @PostMapping("/attr/add")
    public R addAttr(@RequestBody PlatformAttrEntity attrEntity){
        return platformAttrFeginService.addAttr(attrEntity);
    }
    @PostMapping("/attr/update")
    public R updateAttr(@RequestBody PlatformAttrEntity attrEntity){
        return platformAttrFeginService.updateAttr(attrEntity);
    }
}
