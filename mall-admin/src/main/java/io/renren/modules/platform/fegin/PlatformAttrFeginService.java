package io.renren.modules.platform.fegin;

import io.renren.common.utils.R;
import io.renren.modules.platform.entity.PlatformAttrEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient("mall-pms")
public interface PlatformAttrFeginService {
    @GetMapping("/platform/specification/list")
    public R querySpAll(@RequestParam Map<String,Object> params);
    @GetMapping("/platform/sell/list")
    public R querySaleAll(@RequestParam Map<String,Object> params);
    @GetMapping("/platform/attr/{id}")
    public R queryAttr(@PathVariable("id") int attrGroupId);
    @GetMapping("/platform/attr/nogroup")
    public R queryAttrNoGroup(@RequestParam Map<String,Object> params);
    @PostMapping("/platform/attr/del")
    public R delAttr(@RequestBody int[] ids);
    @PostMapping("/platform/attr/add")
    public R addAttr(@RequestBody PlatformAttrEntity attrEntity);
    @PostMapping("/platform/attr/update")
    public R updateAttr(@RequestBody PlatformAttrEntity attrEntity);

}
