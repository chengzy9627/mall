package io.renren.modules.platform.controller;

import io.renren.common.utils.R;
import io.renren.modules.platform.entity.PlatformAttrAttrGroupRelationEntity;
import io.renren.modules.platform.entity.PlatformAttrGroupEntity;
import io.renren.modules.platform.service.PlatformAttrGroupAttrRelationService;
import io.renren.modules.platform.service.PlatformAttrGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/platform")
public class PlatformAttrGroupController {
    @Autowired
    private PlatformAttrGroupService platformAttrGroupService;
    @Autowired
    private PlatformAttrGroupAttrRelationService platformAttrGroupAttrRelationService;
    @GetMapping("/attrGroup/list")
    public R queryAttrGroup(@RequestParam Map<String,Object> params){
        List<PlatformAttrGroupEntity> platformAttrGroupEntities = this.platformAttrGroupService.queryAttrGroup(params);
        return R.ok().put("attrGroups",platformAttrGroupEntities);
    }
    @PostMapping("/attrGroup/add")
    public R addAttrGroup(@RequestBody PlatformAttrGroupEntity platformAttrGroupEntity){
        System.out.println(platformAttrGroupEntity);
        this.platformAttrGroupService.addAttrGroup(platformAttrGroupEntity);
        return R.ok();
    }

    @PostMapping("/attrGroup/del")
    public R delAttrGroup(@RequestBody int[] ids){
        this.platformAttrGroupService.delAttrGroup(ids);
        return R.ok();
    }
    @PostMapping("/attrGroup/update")
    public R updateAttrGroup(@RequestBody PlatformAttrGroupEntity platformAttrGroupEntity){
        this.platformAttrGroupService.updateAttrGroup(platformAttrGroupEntity);
        return R.ok();
    }
    @PostMapping("/attrGroup/addAttr")
    public R addAttrRel(@RequestBody PlatformAttrAttrGroupRelationEntity platformAttrAttrGroupRelation){
        this.platformAttrGroupAttrRelationService.addRelation(platformAttrAttrGroupRelation);
        return R.ok();
    }
    @PostMapping("/attrGroup/delAttr")
    public R delAttrRel(@RequestBody int[] ids){
        this.platformAttrGroupAttrRelationService.delRelation(ids);
        return R.ok();
    }
}
