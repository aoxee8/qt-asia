<template>
  <div class="app-container">
    <div class="filter-container">
      <el-input v-model="listQuery.title" placeholder="标题" style="width: 200px;" class="filter-item"></el-input>
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
      style="width: 100%;">
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

    <pagination
      v-show="paging.count>0"
      layout="total,prev, pager, next"
      :total="paging.count"
      :page.sync="listQuery.page"
      :limit.sync="listQuery.size"
      @pagination="fetchData">
    </pagination>

    <el-dialog
      :visible.sync="dialogFormVisible"
      title="编辑专题"
      width="600px">
      <el-form
        ref="dataForm"
        :model="editModel"
        :rules="rules"
        label-position="left"
        label-width="120px"
        style="width: 400px; margin-left:30px;">
        <el-form-item label="标题" prop="title">
          <el-input v-model="editModel.title"></el-input>
        </el-form-item>
        <el-form-item label="作者" prop="author">
          <el-input v-model="editModel.author"></el-input>
        </el-form-item>
        <el-form-item label="是否启用" prop="valid">
          <el-radio-group v-model="editModel.valid">
            <el-radio :label=true>启用</el-radio>
            <el-radio :label=false>禁用</el-radio>
          </el-radio-group>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取消</el-button>
        <el-button type="primary" @click="doUpdate()">确定</el-button>
      </div>
    </el-dialog>

  </div>
</template>

<script>
  import { getList, updateArticle } from '@/api/article'
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
          title: '',
          page: 1,
          size: 20
        },
        listLoading: true,
        dialogFormVisible: false,
        editModel: {
          id: undefined,
          title: '',
          author: '',
          valid: false
        },
        rules: {
          title: [
            {required: true, message: '请输入标题名称', trigger: 'blur'}
          ],
          author: [
            {required: true, message: '请输入作者名称', trigger: 'blur'}
          ],
          valid: [
            {required: true, message: '请选择是否启用', trigger: 'change'}
          ],
        }
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
          this.listQuery.page = this.paging.page
          this.listQuery.size = this.paging.size
          this.listLoading = false
        }).finally(() => {
          this.listLoading = false
        })
      },
      search() {
        this.listQuery.page = 1
        this.listQuery.size = 20
        this.fetchData();
      },
      cleanSearch() {
        this.listQuery.title = ''
        this.listQuery.page = 1
        this.listQuery.size = 20
        this.fetchData()
      },
      handleUpdate(row) {
        this.resetModel()
        this.dialogFormVisible = true
        this.editModel = Object.assign({}, row)
        this.$nextTick(() => {
          this.$refs['dataForm'].clearValidate()
        })
      },
      doUpdate() {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            updateArticle(this.editModel).then(response => {
              console.log(response.code)
              if (response.code === 20000) {
                this.dialogFormVisible = false
                this.$message("编辑专题成功")
                this.fetchData()
              } else {
                this.$message("编辑专题失败")
              }
            })
          }
        })
      },
      resetModel() {
        this.editModel = {
          id: undefined,
          title: '',
          author: '',
          valid: false
        }
      }
    }
  }
</script>

<style scoped>
  .filter-container {
    padding: 20px;
  }
</style>
