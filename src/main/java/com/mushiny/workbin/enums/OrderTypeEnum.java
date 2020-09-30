package com.mushiny.workbin.enums;


/**
 * @Description TODO
 * @Package com.mushiny.workbin.enums
 * @anthor：wyang
 * @date：2020/9/28
 */
public enum OrderTypeEnum {
    GOODS_IN((byte) 1), GOODS_OUT((byte)2);

    private byte value;

    OrderTypeEnum(byte value) {
        this.value = value;
    }

    public byte getValue() {
        return value;
    }
}
