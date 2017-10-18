package com.demo.simplenote.dp.template;

/**
 * Created by mrsimple on 18/10/17.
 */

public abstract class Template {

    /**
     * 定义算法框架
     */
    public final void start() {
        step1();
        step2();
        step3();
    }

    protected abstract void step1();
    protected abstract void step2();
    protected abstract void step3();

    /**
     * 模板的具体实现
     */
    public static class TemplateImpl extends Template {
        @Override
        protected void step1() {

        }

        @Override
        protected void step2() {

        }

        @Override
        protected void step3() {

        }
    }
}