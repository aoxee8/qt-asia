import request from '@/utils/request'

export function getList(params) {
  return request({
    url: '/article/list',
    method: 'get',
    baseURL:'http://localhost:8080/api/v1',
    params
  })
}

export function updateArticle(data) {
  return request({
    url: '/article/update',
    method: 'post',
    baseURL:'http://localhost:8080/api/v1',
    data
  })
}

export function addArticle(data) {
  return request({
    url: '/article/add',
    method: 'post',
    baseURL:'http://localhost:8080/api/v1',
    data
  })
}
