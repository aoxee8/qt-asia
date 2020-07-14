package com.qt.asia.controller.article;

import com.qt.asia.model.BaseModel;
import com.qt.asia.model.PageModel;
import com.qt.asia.model.Pager;
import com.qt.asia.model.request.ArticleRequest;
import com.qt.asia.model.vo.ArticleVO;
import com.qt.asia.service.article.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: gaoxi1534@126.com
 * @CreateTime: 2020-07-14 16:33
 * @Description: 文章控制器
 */
@RestController
@RequestMapping("/api/{env}/article")
public class ArticleController {

  @Autowired
  private ArticleService articleService;

  @GetMapping(value = "/list")
  public BaseModel<PageModel<ArticleVO>> list(ArticleRequest request, Pager page, @PathVariable String env) {

    return BaseModel.getInstance(articleService.getList(request, page));
  }
}
