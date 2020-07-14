package com.qt.asia.model;

/**
 * @Author: gaoxi1534@126.com
 * @CreateTime: 2020-07-14 16:56
 * @Description: 基础模块
 */
public class BaseModel<T> {

  private static final Integer SUCCESS_CODE = 20000;

  private Integer code = SUCCESS_CODE;

  private String message;

  private T data;

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public static <T> BaseModel<T> getInstance(T data) {
    BaseModel<T> baseModel = new BaseModel<>();
    baseModel.data = data;
    return baseModel;
  }

}
