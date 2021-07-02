<template>
  <div id="roomManager">
    <div id="addAndSearch">
      <div id="add">
        <el-button type="text" @click="addDialogVisible = true"
        >增加客房</el-button
        >
        <el-dialog
            title="增加客房"
            :visible.sync="addDialogVisible"
            width="50%"
            :before-close="handleClose"
        >
          <div>
            <el-form ref="form" :model="form" label-width="80px">
              <el-form-item label="类型">
                <el-radio-group v-model="form.type ">
                  <el-radio label="单人间"></el-radio>
                  <el-radio label="双人间"></el-radio>
                  <el-radio label="豪华双人间"></el-radio>
                </el-radio-group>
              </el-form-item>


              <el-form-item label="楼层">
                <el-radio-group v-model="form.floor ">
                  <el-radio label="一楼"></el-radio>
                  <el-radio label="二楼"></el-radio>
                  <el-radio label="三楼"></el-radio>
                </el-radio-group>
              </el-form-item>

              <el-form-item label="状态">
                <el-radio-group v-model="form.floor ">
                  <el-radio label="空房"></el-radio>
                  <el-radio label="预定"></el-radio>
                  <el-radio label="入住"></el-radio>
                </el-radio-group>
              </el-form-item>

              <el-form-item label="标准价格">
                <el-input v-model="form.standardPrice"></el-input>
              </el-form-item>

              <el-form-item label="折后价">
                <el-input v-model="form.discountPrice"></el-input>
              </el-form-item>

              <el-form-item label="普通会员价">
                <el-input v-model="form.memberPrice "></el-input>
              </el-form-item>

              <el-form-item label="会员价">
                <el-input v-model="form.vipPrice"></el-input>
              </el-form-item>

              <el-form-item label="备注">
                <el-input v-model="form.remarks"></el-input>
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
          <el-input v-model="formInline.search"   @keyup.enter="onSearch()" placeholder="输入"></el-input>

          <el-form-item>
            <el-button type="primary" @click="onSearch()">查询</el-button>
          </el-form-item>
        </el-form>
      </div>
    </div>
    <div id="formDiv">
      <el-table
          :data="UserList"
          border
          style="width: 100%"
      >
        <el-table-column fixed prop="id" label="编号" width="100">
        </el-table-column>
        <el-table-column prop="type" label="类型" width="150">
        </el-table-column>
        <el-table-column prop="floor" label="楼层" width="100">
        </el-table-column>
        <el-table-column prop="status" label="状态" width="100">
        </el-table-column>
        <el-table-column prop="standardPrice" label="标准价格" width="100">
        </el-table-column>
        <el-table-column prop="discountPrice" label="折后价" width="100">
        </el-table-column>
        <el-table-column prop="memberPrice" label="普通会员价" width="100">
        </el-table-column>
        <el-table-column prop="vipPrice" label="Vip会员价" width="100">
        </el-table-column>
        <el-table-column prop="remarks" label="备注" width="150">
        </el-table-column>
        <el-table-column label="操作" width="130">
          <template slot-scope="scope">
            <el-button
                type="text"
                @click="
                centerDialogVisible = true;
                editButton(scope.row);
              "
                size="small"
            >编辑</el-button
            >
            <el-button @click="delClick(scope.row)" type="text" size="small"
            >刪除</el-button
            >
          </template>
        </el-table-column>
      </el-table>
    </div>

    <div id="editDialog">
      <el-dialog
          title="修改客房资料"
          :visible.sync="centerDialogVisible"
          width="30%"
          center
      >
        <div>
          <el-form ref="form" :model="form" label-width="80px">
            <el-form-item label="类型">
              <el-radio-group v-model="form.type ">
                <el-radio label="单人间"></el-radio>
                <el-radio label="双人间"></el-radio>
                <el-radio label="豪华双人间"></el-radio>
              </el-radio-group>
            </el-form-item>


            <el-form-item label="楼层">
              <el-radio-group v-model="form.floor ">
                <el-radio label="一楼"></el-radio>
                <el-radio label="二楼"></el-radio>
                <el-radio label="三楼"></el-radio>
              </el-radio-group>
            </el-form-item>

            <el-form-item label="状态">
              <el-radio-group v-model="form.status ">
                <el-radio label="空房"></el-radio>
                <el-radio label="预定"></el-radio>
                <el-radio label="入住"></el-radio>
              </el-radio-group>
            </el-form-item>

            <el-form-item label="标准价格">
              <el-input v-model="form.standardPrice"></el-input>
            </el-form-item>

            <el-form-item label="折后价">
              <el-input v-model="form.discountPrice"></el-input>
            </el-form-item>

            <el-form-item label="普通会员价">
              <el-input v-model="form.memberPrice "></el-input>
            </el-form-item>

            <el-form-item label="会员价">
              <el-input v-model="form.vipPrice"></el-input>
            </el-form-item>

            <el-form-item label="备注">
              <el-input v-model="form.remarks"></el-input>
            </el-form-item>

          </el-form>
        </div>
        <span slot="footer" class="dialog-footer">
          <el-button @click="centerDialogVisible = false;resetForm()">取 消</el-button>
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
      <el-pagination
          background
          layout="prev, pager, next"
          :total="this.totalPage"
          @current-change="handleCurrentChange"
          :current-page="nowpage"
      >
        <!--上面的屬性 :current-page="nowpage"-->
      </el-pagination>
    </div>
  </div>
</template>

<script>
const axios = require("axios");
export default {
  mounted() {
    this.getRoom("1");
  },
  methods: {
    onSubmit() {
      //增加用戶按鈕
      /* console.log(this.form); */
      if(this.inspectInput())
      {
        alert("请输入完整信息");
      }
      else
      {
        this.addUser();
      }

    },
    inspectInput()
    {
      return this.form.type==""||this.form.status ==""|| this.form.floor=="" || this.form.memberPrice=="" ||this.form.discountPrice=="" ||this.form.standardPrice==""||this.form.vipPrice==""
    },

    onSearch() {
      console.log(this.formInline.search);

      if(this.value=="id")
      {

        this.searchById(this.formInline.search);
      }
      else
      {
        this.searchByName(this.formInline.search)
      }


      /* this.searchById(); */
    },
    delClick(row) {
      //刪除功能
      //row為當前用戶的數據
      console.log(row);
      this.delUser(row.id);
    },
    editButton(row) {
      this.form.type = row.type;
      this.form.floor = row.floor;
      this.form.status  = row.status ;
      this.form.standardPrice  = row.standardPrice ;
      this.form.discountPrice   = row.discountPrice  ;
      this.form.memberPrice   = row.memberPrice  ;
      this.form.vipPrice    = row.vipPrice   ;
      console.log(this.form);
      this.editId = row.id;
    },

    resetForm() {
      this.form.type = "";
      this.form.floor = "";
      this.form.status = "";
      this.form.standardPrice  = "";
      this.form.discountPrice  = "";
      this.form.memberPrice   = "";
      this.form.vipPrice   = "";
      this.form.remarks = "";
    },
    handleClose(done) {
      //彈出框屬性
      this.$confirm("确认关闭？")
          .then((_) => {
            done();
          })
          .catch((_) => {});
    },
    handleCurrentChange(val) {
      /*console.log(val);*/
      this.getRoom(val);
      this.nowpage=val;
    },

    getRoom(page) {
      axios.get(this.http+"getRoom?page="+page).then(
          (res) => {
            console.log(res);

            this.UserList = res.data.List;
            if(res.data.List.length==0 && this.nowpage!=1)
            {
              this.nowpage--;
              this.getRoom(this.nowpage);
            }

            if (res.data.count / 6 != 0) {
              this.totalPage = res.data.count / 6;
            } else {
              this.totalPage = res.data.count / 6 - 1;
            }
            this.totalPage = this.totalPage * 10;
            /* console.log(this.totalPage); */

          },
          (res) => {}
      );
    },
    addUser() {
      axios
          .get(
              this.http+"addUser?type=" +
              this.form.type +
              "&floor=" +
              this.form.floor+"&status="+this.form.status +"&remarks="+this.form.remarks
          )
          .then(
              (res) => {
                /* console.log("addFinish"); */
                this.getRoom(this.nowpage);
              },
              (res) => {}
          );
    },
    delUser(id) {

      axios
          .get(this.http+"delUser?id=" + id)
          .then(
              (res) => {
                console.log(res.data);
                this.getRoom(this.nowpage);
              },
              (res) => {}
          );

    },
    searchById(search) {
      if(search=="")
      {
        this.getRoom(1);
        this.nowpage=1;
      }
      else
      {
        axios
            .get(
                this.http+"searchUserById?id=" +
                search
            )
            .then(
                (res) => {
                  /* console.log(res);*/

                  this.UserList = res.data.List;
                  this.nowpage=1;
                },
                (res) => {}
            );
      }

    },
    searchByName(search) {
      if(search=="")
      {
        this.getRoom(1);
        this.nowpage=1;
      }
      else
      {
        axios
            .get(
                this.http+"searchUserByUname?type=" +
                search
            )
            .then(
                (res) => {
                  /* console.log(res);*/

                  this.UserList = res.data.List;
                  this.nowpage=1;
                },
                (res) => {}
            );
      }

    },
    editClick() {
      axios
          .get(
              this.http+"editUser?id="+
              this.editId +
              "&type=" +
              this.form.type +
              "&floor=" +
              this.form.floor +
              "&status=" +
              this.form.status +"&remarks="+this.form.remarks
          )
          .then(
              (res) => {
                this.getRoom(this.nowpage);
                this.resetForm();
              },
              (res) => {}
          );
    },
  },

  data() {
    return {
      http:"http://localhost:8080/0_Hotel_Management_war/",
      UserList: [
        {

        }
      ],
      page: 0,
      nowpage: 1,
      totalPage: 10,
      addDialogVisible: false, //add彈出框屬性
      centerDialogVisible: false, //
      editId: "",
      form: {
        //用戶資料
        type: "",
        floor: "",
        status : "",
        standardPrice:"",
        discountPrice:"",
        memberPrice:"",
        vipPrice:"",
        remarks:"",
      },
      formInline: {
        //搜尋用戶
        search: "",
      },
      options: [
        {
          value: "id",
          label: "用户编号",
        },
        {
          value: "type",
          label: "用户名",
        },
      ],
      value: "id",
    };
  },
};
</script>

<style>
#roomManager {
  width: 100%;
  height: 100%;
  position: relative;

}

#roomManager #addAndSearch {
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
#roomManager #addAndSearch #search .el-input {
  width: 120px;
}
#roomManager #editDialog .el-input {
  width: 280px;
}
#roomManager #page {
  bottom: 0;
  left:50%;
  position: absolute;
}

#roomManager #formDiv .el-table th,#roomManager #formDiv .el-table tr,#roomManager #formDiv .el-table__empty-block,#roomManager .el-table__row td
{
  border: 1px solid #CBCBCB;
  background-color: #EEEEEE;
}
#roomManager .el-form-item__label
{
  width: 100px !important;
}
#roomManager  .el-dialog
{
  margin-top: 20px!important;
}
</style>

