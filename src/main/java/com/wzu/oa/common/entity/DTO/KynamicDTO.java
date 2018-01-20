package com.wzu.oa.common.entity.DTO;

import com.wzu.oa.common.entity.Kynamic;

/**
 * @author jack
 * @date 2018-01-19   12:29
 */
public class KynamicDTO {

    private Kynamic kynamic;

    private String icon;


    public KynamicDTO() {
    }

    public KynamicDTO(Kynamic kynamic, String icon) {
        this.kynamic = kynamic;
        this.icon = icon;
    }

    public Kynamic getKynamic() {
        return kynamic;
    }

    public void setKynamic(Kynamic kynamic) {
        this.kynamic = kynamic;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }


}
