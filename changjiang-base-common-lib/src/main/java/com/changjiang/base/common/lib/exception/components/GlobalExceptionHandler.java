package com.changjiang.base.common.lib.exception.components;

import com.changjiang.base.common.lib.exception.base.BaseException;
import com.changjiang.base.common.lib.exception.enumtypes.BusinessResponseEnum;
import com.changjiang.base.common.lib.exception.enumtypes.OtherResponseEnum;
import com.changjiang.base.common.lib.exception.exceptions.BusinessException;
import com.changjiang.base.common.lib.exception.responses.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * @author sfy
 * @description 自定义统一异常处理类
 * @date 2020/12/8
 */
@Slf4j
@Component
@ControllerAdvice
@ConditionalOnWebApplication
public class GlobalExceptionHandler {

    /**
     * @description 消息内容处理
      * @param e
     * @return java.lang.String
     * @author sfy
     * @date 2020/12/8 11:14
     */
    public String getMessage(BaseException e) {
        return "错误信息：" + e.getResponseEnum().getMessage();
    }

    /**
     * @description 自定义业务异常处理
      * @param e
     * @return com.changjiang.base.common.lib.exception.responses.ErrorResponse
     * @author sfy
     * @date 2020/12/8 14:18
     */
    @ExceptionHandler({
            BaseException.class,
            BusinessException.class
    })
    @ResponseBody
    public ErrorResponse handleBusinessException(BusinessException e) {
        log.error(e.getMessage(), e);
        return new ErrorResponse(e.getResponseEnum().getCode(), getMessage(e));
    }

   /**
    * @description 其他未知异常
     * @param e
    * @return com.changjiang.base.common.lib.exception.responses.ErrorResponse
    * @author sfy
    * @date 2020/12/8 14:56
    */
    @ExceptionHandler({
            Exception.class,
            NoHandlerFoundException.class,
            HttpRequestMethodNotSupportedException.class,
            HttpMediaTypeNotSupportedException.class,
            MissingPathVariableException.class,
            MissingServletRequestParameterException.class,
            TypeMismatchException.class,
            HttpMessageNotReadableException.class,
            HttpMessageNotWritableException.class,
            HttpMediaTypeNotAcceptableException.class,
            ServletRequestBindingException.class,
            ConversionNotSupportedException.class,
            MissingServletRequestPartException.class,
            AsyncRequestTimeoutException.class
    })
    @ResponseBody
    public ErrorResponse handleServletException(Exception e) {
        log.error(e.getMessage(), e);
        String code = OtherResponseEnum.SERVER_ERROR.getCode();
        BaseException baseException = new BaseException(OtherResponseEnum.SERVER_ERROR);
        String message = getMessage(baseException);
        return new ErrorResponse(code, message);
    }

    /**
     * @description 参数绑定异常
      * @param e
     * @return com.changjiang.base.common.lib.exception.responses.ErrorResponse
     * @author sfy
     * @date 2020/12/8 14:27
     */
    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public ErrorResponse handleBindException(BindException e) {
        log.error(BusinessResponseEnum.PARAM_NULL.getMessage(), e);
        return wrapperBindingResult(e.getBindingResult());
    }

    /**
     * 参数校验异常，将校验失败的所有异常组合成一条错误信息
     *
     * @param e 异常
     * @return 异常结果
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public ErrorResponse handleValidException(MethodArgumentNotValidException e) {
        log.error(BusinessResponseEnum.PARAM_NULL.getMessage(), e);
        return wrapperBindingResult(e.getBindingResult());
    }

    /**
     * @description 包装绑定结果
      * @param bindingResult
     * @return com.changjiang.base.common.lib.exception.responses.ErrorResponse
     * @author sfy
     * @date 2020/12/8 14:23
     */
    private ErrorResponse wrapperBindingResult(BindingResult bindingResult) {
        StringBuilder stringBuilder = new StringBuilder();
        for (ObjectError error : bindingResult.getAllErrors()) {
            stringBuilder.append(", ");
            if (error instanceof FieldError) {
                stringBuilder.append(((FieldError) error).getField()).append(": ");
            }
            stringBuilder.append(error.getDefaultMessage() == null ? "" : error.getDefaultMessage());
        }
        return new ErrorResponse(
                BusinessResponseEnum.PARAM_INVALID.getCode(), stringBuilder.substring(2));
    }

}
