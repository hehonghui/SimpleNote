package com.demo.simplenote.dp.adapter;

/**
 * Created by mrsimple on 18/10/17.
 */

public class Test {
    /**
     * test
     * @param args
     */
    public static void main(String[] args) {
        PowerPlug chinaPlug = new ChinaPlug() ;
        // 通过 EuropePlug 适配 中国的插头
        PowerPlug europePlug = new EuropePlug(chinaPlug) ;
        europePlug.charge();
    }
}
