<template>
  <div class="app-container">
    <div class="filter-container">
      <el-input v-model="listQuery.title" placeholder="标题" style="width: 200px;" class="filter-item"/>
      <el-button class="filter-item" type="primary" icon="el-icon-search" plain @click="search()">搜索</el-button>
      <el-button class="filter-item" type="info" @click="cleanSearch()">重置</el-button>
    </div>

    <el-table
      v-loading="listLoading"
      :data="list"
      element-loading-text="Loading"
      border
      fit
      highlight-current-row
    >
      <el-table-column align="center" label="编号" width="95">
        <template slot-scope="scope">
          {{ scope.row.id }}
        </template>
      </el-table-column>
      <el-table-column label="标题">
        <template slot-scope="scope">
          {{ scope.row.title }}
        </template>
      </el-table-column>
      <el-table-column label="作者" width="110" align="center">
        <template slot-scope="scope">
          <span>{{ scope.row.author }}</span>
        </template>
      </el-table-column>
      <el-table-column class-name="status-col" label="是否启用" width="110" align="center">
        <template slot-scope="scope">
          <el-tag :type="scope.row.valid | statusFilter">{{ scope.row.valid }}</el-tag>
        </template>
      </el-table-column>
      <el-table-column align="center" prop="created_at" label="操作" min-width="150">
        <template slot-scope="scope">
          <el-button type="text" @click="handleUpdate(scope.row)">编辑</el-button>
        </template>
      </el-table-column>
    </el-table>
    <pagination v-show="paging.count>0" :total="paging.count" :page.sync="paging.page" :limit.sync="paging.size" @pagination="fetchData()"/>
    <!--    <el-dialog :visible.sync="dialogFormVisible" :title="textMap[dialogStatus]" width="600px">-->
    <!--      <el-form ref="dataForm" :rules="rules" :model="nodeModel" label-position="left" label-width="120px" style="width: 400px; margin-left:30px;">-->
    <!--        <el-form-item label="所属集群" prop="clusterId">-->
    <!--          <el-select v-if="dialogStatus === 'create'" v-model="nodeModel.clusterId" placeholder="选择所属集群">-->
    <!--            <el-option key="" label="单机" value="" />-->
    <!--            <el-option v-for="item in canalClusters" :key="item.id" :label="item.name" :value="item.id" />-->
    <!--          </el-select>-->
    <!--          <el-select v-else v-model="nodeModel.clusterId" placeholder="选择所属集群" disabled="disabled">-->
    <!--            <el-option key="" label="单机" value="" />-->
    <!--            <el-option v-for="item in canalClusters" :key="item.id" :label="item.name" :value="item.id" />-->
    <!--          </el-select>-->
    <!--        </el-form-item>-->
    <!--        <el-form-item label="Server 名称" prop="name">-->
    <!--          <el-input v-model="nodeModel.name" />-->
    <!--        </el-form-item>-->
    <!--        <el-form-item label="Server IP" prop="ip">-->
    <!--          <el-input v-model="nodeModel.ip" />-->
    <!--        </el-form-item>-->
    <!--        <el-form-item label="admin 端口" prop="adminPort">-->
    <!--          <el-input v-model="nodeModel.adminPort" placeholder="11110" type="number" />-->
    <!--        </el-form-item>-->
    <!--        <el-form-item label="tcp 端口" prop="tcpPort">-->
    <!--          <el-input v-model="nodeModel.tcpPort" placeholder="11111" type="number" />-->
    <!--        </el-form-item>-->
    <!--        <el-form-item label="metric 端口" prop="metricPort">-->
    <!--          <el-input v-model="nodeModel.metricPort" placeholder="11112" type="number" />-->
    <!--        </el-form-item>-->
    <!--      </el-form>-->
    <!--      <div slot="footer" class="dialog-footer">-->
    <!--        <el-button @click="dialogFormVisible = false">取消</el-button>-->
    <!--        <el-button type="primary" @click="dataOperation()">确定</el-button>-->
    <!--      </div>-->
    <!--    </el-dialog>-->
  </div>
</template>

<script>
  import {getList} from '@/api/article'
  import Pagination from '@/components/Pagination'

  export default {
    components: {Pagination},
    filters: {
      statusFilter(status) {
        const statusMap = {
          true: '禁用',
          false: '启用'
        }
        return statusMap[status]
      }
    },
    data() {
      return {
        list: [],
        paging: {
          count: 0,
          page: 1,
          size: 20
        },
        listQuery: {
          title: ''
        },
        listLoading: true
      }
    },
    created() {
      this.fetchData()
    },
    methods: {
      fetchData() {
        this.listLoading = true
        getList(this.listQuery).then(response => {
          this.list = response.data.items
          this.paging = response.data.paging
          this.listLoading = false
        }).finally(() => {
          this.listLoading = false
        })
      },
      search() {
        this.paging.page = 1
        this.fetchData();
      },
      cleanSearch(){
        this.listQuery.title=''
        this.paging.page=1
        this.fetchData()
      },
      handleUpdate(row) {
        console.log(row.id)
      },
      handleCreate() {
      }
    }
  }
</script>
