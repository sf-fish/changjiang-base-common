package com.changjiang.base.common.lib.exception.asserts;

import com.changjiang.base.common.lib.exception.base.BaseAssert;
import com.changjiang.base.common.lib.exception.base.BaseException;
import com.changjiang.base.common.lib.exception.base.BaseResponseEnum;
import com.changjiang.base.common.lib.exception.exceptions.BusinessException;

import java.util.Arrays;

/**
 * @author sfy
 * @description 业务异常断言接口
 * @date 2020/12/8
 */
public interface BusinessExceptionAssert extends BaseResponseEnum, BaseAssert {

    @Override
    default BaseException newException(Object... args) {
        return new BusinessException(this, args, formatMessage(args));
    }

    @Override
    default BaseException newException(Throwable throwable, Object... args) {
        return new BusinessException(this, args, formatMessage(args), throwable);
    }

    /**
     * @description 拼接参数
      * @param args
     * @return java.lang.String
     * @author sfy
     * @date 2020/12/8 19:41
     */
    default String formatMessage(Object... args) {
        String message = this.getMessage();
        if(args != null && args.length > 0){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(message).append(Arrays.toString(args));
            message = stringBuilder.toString();
        }
        return message;
    }
}
