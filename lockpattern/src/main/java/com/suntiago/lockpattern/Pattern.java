package com.suntiago.lockpattern;

/**
 * Created by Jeremy on 2018/9/6.
 */


public interface Pattern {
    void setPatternCallback(PatternManager.PatternCallback patternCallback);

    /**
     * 主账户登录
     */
    void accountLogin(String accountId);

    /**
     * 验证pattern
     */
    void checkoutPattern();


    /**
     * 主账户登出
     */
    void accountLoginout();

    /**
     * 绘制pattern
     */
    void setPattern();

    /**
     * 是否已经设置了图案解锁
     */
    boolean isPatternSet();
}