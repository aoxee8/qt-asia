package com.qt.asia.handler;

import com.qt.asia.common.exception.ServiceException;
import com.qt.asia.model.BaseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Author: gaoxi1534@126.com
 * @CreateTime: 2020-07-14 17:00
 * @Description: MVC拦截器
 */
@ControllerAdvice(annotations = ResponseBody.class)
public class GlobalExceptionHandler {

  private static Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

  /**
   * 通用异常处理
   *
   * @param e 异常
   * @return
   */
  @ResponseBody
  @ResponseStatus(HttpStatus.OK)
  @ExceptionHandler(value = Exception.class)
  public BaseModel commonExceptionHandle(Exception e) {
    if (e instanceof ServiceException) {
      LOGGER.error(e.getMessage());
    } else {
      LOGGER.error(e.getMessage(), e);
    }
    BaseModel res = new BaseModel();
    res.setCode(50000);
    res.setMessage(e.getMessage());
    return res;
  }

}
