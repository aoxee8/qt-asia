package com.qt.asia.service.article.impl;

import com.qt.asia.model.PageModel;
import com.qt.asia.model.Pager;
import com.qt.asia.model.request.ArticleRequest;
import com.qt.asia.model.vo.ArticleVO;
import com.qt.asia.service.article.ArticleService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * @Author: gaoxi1534@126.com
 * @CreateTime: 2020-07-14 17:26
 * @Description: 实现类
 */
@Service
public class ArticleServiceImpl implements ArticleService {

  @Override
  public PageModel<ArticleVO> getList(ArticleRequest request, Pager pager) {

    List<ArticleVO> list = getList();

    Long count = new Long(list.size());

    pager.setCount(count);

    PageModel<ArticleVO> pageModel = new PageModel<>(pager, list);

    return pageModel;
  }

  private List<ArticleVO> getList() {

    List<ArticleVO> list = new ArrayList<>();

    for (int i = 0; i < 25; i++) {

      ArticleVO entity = new ArticleVO();
      entity.setId(new Long((i + 1)));
      entity.setAuthor("张三" + i);
      entity.setTitle(entity.getAuthor() + "今日上头条");
      if (i / 2 == 0) {
        entity.setValid(Boolean.TRUE);
      } else {
        entity.setValid(Boolean.FALSE);
      }
      list.add(entity);
    }
    return list;
  }
}
