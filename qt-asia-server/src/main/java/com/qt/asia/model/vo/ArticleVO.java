package com.qt.asia.model.vo;

/**
 * @Author: gaoxi1534@126.com
 * @CreateTime: 2020-07-14 17:22
 * @Description: 文章视图VO
 */
public class ArticleVO {

  private Long id;

  private String title;

  private Boolean isValid;

  private String author;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Boolean getValid() {
    return isValid;
  }

  public void setValid(Boolean valid) {
    isValid = valid;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }
}
