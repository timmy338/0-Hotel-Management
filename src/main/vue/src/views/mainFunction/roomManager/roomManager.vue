  /* 本页面中房间类型为type、额定人数为limit、备注为remark */
<template>
  <div id="roomManager">
    <div id="addAndSearch">
      <div id="add">
        <el-button type="text" @click="addDialogVisible = true"
          >增加房间</el-button
        >
        <el-dialog
          title="增加房间"
          :visible.sync="addDialogVisible"
          width="50%"
          :before-close="handleClose"
        >
          <div>
            <el-form ref="form" :model="form" label-width="80px">
              <el-form-item label="类型名">
                <el-input v-model="form.name"></el-input>
              </el-form-item>
              <el-form-item label="额定人数">
                <el-input v-model="form.limit"></el-input>
              </el-form-item>

            </el-form>
          </div>
          <span slot="footer" class="dialog-footer">
            <el-button @click="addDialogVisible = false">取 消</el-button>
            <el-button
              type="primary"
              @click="
                addDialogVisible = false;
                onSubmit();
              "
              >立即创建</el-button
            >
          </span>
        </el-dialog>
      </div>
      <div id="search">
        <el-form :inline="true" :model="formInline" class="demo-form-inline">
          <el-select v-model="value" filterable placeholder="请选择">
            <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            >
            </el-option>
          </el-select>
          <el-input v-model="formInline.search" placeholder="输入"></el-input>

          <el-form-item>
            <el-button type="primary" @click="onSearch()">查询</el-button>
          </el-form-item>
        </el-form>
      </div>
    </div>
    <div id="formDiv">
      <el-table :data="UserList.slice(this.page,6)" border style="width: 100%">
        <el-table-column fixed prop="type" label="类型名" width="300px">
        </el-table-column>
        <el-table-column prop="limit" label="额定人数" width="300px">
        </el-table-column>
        <el-table-column prop="remark" label="备注" width="300px">
          <template slot-scope="scope">
            <el-button
              type="text"
              @click="
                centerDialogVisible = true;
                editButton(scope.row);
              "
              >编辑</el-button
            >
            <el-button @click="delClick(scope.row)" type="text" size="small"
              >刪除</el-button
            >
          </template>
        </el-table-column>
      </el-table>

      <el-dialog
        title="修改用户资料"
        :visible.sync="centerDialogVisible"
        width="30%"
        center
      >
        <div>
          <el-form ref="form" :model="form" label-width="80px">
            <el-form-item label="类型名">
              <el-input v-model="form.name"></el-input>
            </el-form-item>
            <el-form-item label="额定人数">
              <el-input v-model="form.limit"></el-input>
            </el-form-item>

          </el-form>
        </div>
        <span slot="footer" class="dialog-footer">
          <el-button @click="centerDialogVisible = false">取 消</el-button>
          <el-button
            type="primary"
            @click="
              centerDialogVisible = false;
              editClick();
            "
            >确 定</el-button
          >
        </span>
      </el-dialog>
    </div>
    <div id="page">
        <el-pagination background layout="prev, pager, next" :total="this.totalPage">
    </el-pagination>
    </div>
  
  </div>
</template>

<script>
const axios = require("axios");
export default {
  mounted() {
    this.getUserList();
  },
  methods: {
    onSubmit() {
      //增加用戶按鈕
      /* console.log(this.form); */
      this.addUser();
    },
    onSearch() {
      console.log(this.formInline.search);
      this.searchById(this.formInline.search);

      /* this.searchById(); */
    },
    delClick(row) {
      //刪除功能
      //row為當前房间的數據
      /* console.log(row); */
      this.delRoom(row.type);
    },
    editButton(row) {
      this.form.type = row.type;
      this.form.limit = row.limit;
      this.form.remark= row.remark;
    },

    resetForm() {
      this.form.type = "";
      this.form.limit = "";
      this.form.remark = "";
    },
    handleClose(done) {
      //彈出框屬性
      this.$confirm("确认关闭？")
        .then((_) => {
          done();
        })
        .catch((_) => {});
    },

    getUserList() {
      axios.get("http://localhost:8080/demo_war_exploded/getPUserList").then(
        (res) => {
          /* console.log(res); */
          this.UserList = res.data;
          if(res.data.length%6!=0)
          {
            this.totalPage=(res.data.length%6);
          }
          else
          {
            this.totalPage=res.data.length%6-1;
          }
          this.totalPage=this.totalPage*10;
          console.log(this.totalPage);
        
        },
        (res) => {}
      );
    },
    addUser() {
      axios
        .get(
          "http://localhost:8080/demo_war_exploded/addPUser?username=" +
            this.form.name +
            "&password=" +
            this.form.password +
            "&usertype=" +
            this.form.resource
        )
        .then(
          (res) => {
            /* console.log("addFinish"); */
            this.getUserList();
          },
          (res) => {}
        );
    },
    delUser(id) {
      axios
        .get("http://localhost:8080/demo_war_exploded/delPUser?id=" + id)
        .then(
          (res) => {
            /* console.log("del"); */
            this.getUserList();
          },
          (res) => {}
        );
    },
    searchById(search) {
      axios
        .get(
          "http://localhost:8080/demo_war_exploded/getPUserByID?userid=" +
            search
        )
        .then(
          (res) => {
            console.log(res);
            this.UserList = res.data;
          },
          (res) => {}
        );
    },
    editClick() {
      axios
        .get(
          "http://localhost:8080/demo_war_exploded/updatePUser?userid=" +
            this.editId +
            "&username=" +
            this.form.name +
            "&password=" +
            this.form.password +
            "&usertype=" +
            this.form.resource
        )
        .then(
          (res) => {
            this.getUserList();
            this.resetForm();
          },
          (res) => {}
        );
    },
  },

  data() {
    return {
      UserList: [],
      page:0,
      totalPage:10,
      addDialogVisible: false, //add彈出框屬性
      centerDialogVisible: false, //
      editId: "",
      form: {
        //房间資料
        type: "",
        limit: "",
        remark: "",
      },
      formInline: {
        //搜尋用戶
        search: "",
      },
      options: [
        {
          value: "type",
          label: "房间类型",
        },
        {
          value: "count",
          label: "额定人数",
        },
      ],
      value: "type",
    };
  },
};
</script>

<style>
#roomManager {
  width: 100%;
  height: 100%;
  position: relative;
  background-color:rgb(238, 238, 238);
}
#roomManager #addAndSearch {
  margin-top: 10px;
  padding: 20px;
  width: 100%;
  height: 50px;
}
#roomManager #addAndSearch .el-input {
  width: 200px;
}
#roomManager #addAndSearch #add {
  float: left;
}
#roomManager #addAndSearch #search {
  float: right;
  margin-right: 60px;
}
#roomManager #addAndSearch .el-input {
  width: 110px;
}
#roomManager #page
{
  bottom: 20px;
  left: 370px;
  position: absolute;

}
</style>

