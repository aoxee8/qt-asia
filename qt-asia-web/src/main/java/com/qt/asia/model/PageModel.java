package com.qt.asia.model;

import java.util.List;

/**
 * @Author: gaoxi1534@126.com
 * @CreateTime: 2020-07-14 18:45
 * @Description: 分页model
 */
public class PageModel<T> {

  private Pager paging;

  private List<T> items;

  public PageModel(Pager paging, List<T> items) {
    this.paging = paging;
    this.items = items;
  }

  public Pager getPaging() {
    return paging;
  }

  public void setPaging(Pager paging) {
    this.paging = paging;
  }

  public List<T> getItems() {
    return items;
  }

  public void setItems(List<T> items) {
    this.items = items;
  }
}
