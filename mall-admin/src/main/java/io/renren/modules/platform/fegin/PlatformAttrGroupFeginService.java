package io.renren.modules.platform.fegin;

import io.renren.common.utils.R;
import io.renren.modules.platform.entity.PlatformAttrAttrGroupRelationEntity;
import io.renren.modules.platform.entity.PlatformAttrGroupEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient("mall-pms")
public interface PlatformAttrGroupFeginService {
    @GetMapping("/platform/attrGroup/list")
    public R queryAttrGroup(@RequestParam Map<String,Object> params);
    @PostMapping("/platform/attrGroup/add")
    public R addAttrGroup(@RequestBody PlatformAttrGroupEntity platformAttrGroupEntity);
    @PostMapping("/platform/attrGroup/del")
    public R delAttrGroup(@RequestBody int[] ids);
    @PostMapping("/platform/attrGroup/update")
    public R updateAttrGroup(@RequestBody PlatformAttrGroupEntity platformAttrGroupEntity);
    @PostMapping("/platform/attrGroup/addAttr")
    public R addAttrRel(@RequestBody PlatformAttrAttrGroupRelationEntity platformAttrAttrGroupRelation);
    @PostMapping("/platform/attrGroup/delAttr")
    public R delAttrRel(@RequestBody int[] ids);
}
