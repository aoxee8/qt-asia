package com.qt.asia.model.request;

/**
 * @Author: gaoxi1534@126.com
 * @CreateTime: 2020-07-16 14:19
 * @Description: 文章编辑请求
 */
public class ArticleEditRequest {

    private Long id;

    private String title;

    private String author;

    private Boolean valid;

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }
}
