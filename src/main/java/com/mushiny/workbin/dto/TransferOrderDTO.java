package com.mushiny.workbin.dto;

import com.mushiny.workbin.entity.TransferOrder;

/**
 * @Description TODO
 * @ClassName： :
 * @Package
 * @anthor：wyang
 * @date：
 * @版本：V1.0
 */
public class TransferOrderDTO extends TransferOrder {
    private String storageBinCode;

    public String getStorageBinCode() {
        return storageBinCode == null ? "" : storageBinCode;
    }

    public TransferOrderDTO setStorageBinCode(String storageBinCode) {
        this.storageBinCode = storageBinCode;
        return this;
    }
}
