package com.mushiny.workbin.dto;

import com.mushiny.workbin.entity.InvUnitLoad;

/**
 * @Description TODO
 * @ClassName： :
 * @Package
 * @anthor：wyang
 * @date：
 * @版本：V1.0
 */
public class InvUnitLoadDTO extends InvUnitLoad {
    private String storageBinCode;

    public String getStorageBinCode() {
        return storageBinCode == null ? "" : storageBinCode;
    }

    public InvUnitLoadDTO setStorageBinCode(String storageBinCode) {
        this.storageBinCode = storageBinCode;
        return this;
    }
}
