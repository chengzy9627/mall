package io.renren.modules.platform.controller;

import io.renren.common.utils.R;
import io.renren.modules.platform.fegin.PlatformAttrGroupFeginService;
import io.renren.modules.platform.entity.PlatformAttrAttrGroupRelationEntity;
import io.renren.modules.platform.entity.PlatformAttrGroupEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/platform")
public class PlatformAttrGroupFeginController {
    @Autowired
    private PlatformAttrGroupFeginService platformAttrGroupFeginService;
    @GetMapping("/attrGroup/list")
    public R queryAttrGroup(@RequestParam Map<String,Object> params){
        return platformAttrGroupFeginService.queryAttrGroup(params);
    }
    @PostMapping("/attrGroup/add")
    public R addAttrGroup(@RequestBody PlatformAttrGroupEntity platformAttrGroupEntity){
        return platformAttrGroupFeginService.addAttrGroup(platformAttrGroupEntity);
    }

    @PostMapping("/attrGroup/del")
    public R delAttrGroup(@RequestBody int[] ids){
        return platformAttrGroupFeginService.delAttrGroup(ids);
    }
    @PostMapping("/attrGroup/update")
    public R updateAttrGroup(@RequestBody PlatformAttrGroupEntity platformAttrGroupEntity){
        return platformAttrGroupFeginService.updateAttrGroup(platformAttrGroupEntity);
    }
    @PostMapping("/attrGroup/addAttr")
    public R addAttrRel(@RequestBody PlatformAttrAttrGroupRelationEntity platformAttrAttrGroupRelation){
        return platformAttrGroupFeginService.addAttrRel(platformAttrAttrGroupRelation);
    }
    @PostMapping("/attrGroup/delAttr")
    public R delAttrRel(@RequestBody int[] ids){
        return platformAttrGroupFeginService.delAttrRel(ids);
    }
}
