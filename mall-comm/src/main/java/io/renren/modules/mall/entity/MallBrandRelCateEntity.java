package io.renren.modules.mall.entity;

import lombok.Data;

@Data
public class MallBrandRelCateEntity {
    private int id;
    private int brandId;
    private int catId;
    private String brandName;
    private String catName;
}
