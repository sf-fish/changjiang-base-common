package com.changjiang.base.common.lib.exception.base;

/**
 * @author sfy
 * @description 基础断言接口
 * @date 2020/12/7
 */
public interface BaseAssert {
    
    /**
     * @description 返回自定义异常
      * @param args 
     * @return com.changjiang.base.common.lib.exception.base.BaseException
     * @author sfy
     * @date 2020/12/7 19:28
     */
    BaseException newException(Object... args);

    /**
     * @description 返回自定义异常
      * @param t
     * @param args 
     * @return com.changjiang.base.common.lib.exception.base.BaseException
     * @author sfy
     * @date 2020/12/7 19:29
     */
    BaseException newException(Throwable t, Object... args);

    /**
     * @description 默认断言
      * @param obj
     * @return void
     * @author sfy
     * @date 2020/12/7 19:31
     */
    default void assertNotNull(Object obj) {
        if (obj == null) {
            throw newException(obj);
        }
    }

    /**
     * @description 默认断言 -- 携带参数
      * @param obj
     * @param args
     * @return void
     * @author sfy
     * @date 2020/12/7 19:32
     */
    default void assertNotNull(Object obj, Object... args) {
        if (obj == null) {
            throw newException(args);
        }
    }
}
