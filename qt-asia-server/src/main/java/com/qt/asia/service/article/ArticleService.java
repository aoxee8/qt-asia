package com.qt.asia.service.article;

import com.qt.asia.model.Pager;
import com.qt.asia.model.request.ArticleRequest;
import com.qt.asia.model.vo.ArticleVO;

/**
 * @Author: gaoxi1534@126.com
 * @CreateTime: 2020-07-14 17:26
 * @Description: 文章服务
 */
public interface ArticleService {

  Pager<ArticleVO> getList(ArticleRequest request, Pager<ArticleVO> pager);

}
