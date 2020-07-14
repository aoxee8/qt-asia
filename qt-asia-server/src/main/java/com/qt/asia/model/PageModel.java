package com.qt.asia.model;

/**
 * @Author: gaoxi1534@126.com
 * @CreateTime: 2020-07-14 18:45
 * @Description: 分页model
 */
public class PageModel<T> {

  private Pager paging;

  private T data;

  public PageModel(Pager paging, T data) {
    this.paging = paging;
    this.data = data;
  }

  public Pager getPaging() {
    return paging;
  }

  public void setPaging(Pager paging) {
    this.paging = paging;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }
}
