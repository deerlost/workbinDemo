package com.mushiny.workbin.enums;


/**
 * @Description TODO
 * @Package com.mushiny.workbin.enums
 * @anthor：wyang
 * @date：2020/9/28
 */
public enum OrderStatusEnum {

    CREATE(10), PROCESS(20), COMPLETE(30),FINISH(40),
    ;

    private int value;

    OrderStatusEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
