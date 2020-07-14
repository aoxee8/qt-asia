package com.qt.asia.model;

/**
 * @Author: gaoxi1534@126.com
 * @CreateTime: 2020-07-14 17:28
 * @Description: 统一分页
 */
public class Pager {

  private static final Long DEFAULT_COUNT = 0L;

  private static final Integer DEFAULT_PAGE = 1;

  private static final Integer DEFAULT_SIZE = 20;

  private static final Long DEFAULT_OFFSET = 0L;

  private Long count = DEFAULT_COUNT;

  private Integer page = DEFAULT_PAGE;

  private Integer size = DEFAULT_SIZE;

  private Long offset = DEFAULT_OFFSET;

  public Pager() {

  }

  public Pager(Integer page, Integer size) {
    this.page = page;
    this.size = size;
  }

  public Pager(Long count) {
    this.count = count;
  }

  @Override
  public String toString() {
    return "Pager{" +
        "count=" + count +
        ", page=" + page +
        ", size=" + size +
        ", offset=" + offset +
        '}';
  }

  public Long getCount() {
    return count;
  }

  public void setCount(Long count) {
    this.count = count;
  }

  public Integer getPage() {
    return page;
  }

  public void setPage(Integer page) {
    this.page = page;
  }

  public Integer getSize() {
    return size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }

  public Long getOffset() {
    this.offset = (long) (getPage() - 1) * (long) getSize();
    return offset;
  }

  public void setOffset(Long offset) {
    this.offset = offset;
  }
}
