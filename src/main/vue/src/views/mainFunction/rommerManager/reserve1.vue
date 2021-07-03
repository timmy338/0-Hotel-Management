<template>
  <div id="roomManager">
    <div id="addAndSearch">
      <div id="search">
        <el-form :inline="true" :model="formInline" class="demo-form-inline">
          <span class="searchSpan">编号: </span>
          <el-input v-model="formInline.searchId" placeholder="客房编号"></el-input>
          <span class="searchSpan">类型: </span>
          <el-select v-model="formInline.type" filterable placeholder="请选择">
            <el-option
                v-for="item in typeOptions"
                :key="item.value"
                :label="item.label"
                :value="item.value"
            >
            </el-option>
          </el-select>
          <span class="searchSpan">楼层: </span>
          <el-select v-model="formInline.floor" filterable placeholder="请选择">
            <el-option
                v-for="item in floorOptions"
                :key="item.value"
                :label="item.label"
                :value="item.value"
            >
            </el-option>
          </el-select>

          <span class="searchSpan">状态: </span>
          <el-select v-model="formInline.status" filterable placeholder="请选择">
            <el-option
                v-for="item in statusOptions"
                :key="item.value"
                :label="item.label"
                :value="item.value"
            >
            </el-option>
          </el-select>
          <span class="searchSpan">价格: </span>
          <el-input v-model="formInline.standardPrice" placeholder="價格"></el-input>
          <el-button type="primary" @click="onSearch()">查询</el-button>
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
            >預定
            </el-button
            >

          </template>
        </el-table-column>

      </el-table>
    </div>

    <div id="editDialog">
      <el-dialog
          title="预定信息"
          :visible.sync="centerDialogVisible"
          width="30%"
          center
      >
        <div>
          <el-form ref="form" :model="form" label-width="80px">

            <el-form-item label="预定人">
              <el-input v-model="form.guestName"></el-input>
            </el-form-item>

            <el-form-item label="证件类别">
              <el-select v-model="form.guestIdType" filterable placeholder="请选择">
                <el-option
                    v-for="item in guestTypeOptions"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value"
                >
                </el-option>
              </el-select>
            </el-form-item>

            <el-form-item label="证件号码">
              <el-input v-model="form.guestId"></el-input>
            </el-form-item>
            <el-form-item label="联系电话">
              <el-input v-model="form.tel"></el-input>
            </el-form-item>

            <div class="block">
              <span class="demonstration">默认</span>
              <el-date-picker
                  v-model="Time"
                  type="datetimerange"
                  range-separator="至"
                  start-placeholder="开始日期"
                  end-placeholder="结束日期">
              </el-date-picker>
            </div>

            <el-form-item label="入住人数">
              <el-input v-model="form.guestCount "></el-input>
            </el-form-item>

            <el-form-item label="会员编号">
              <el-input v-model="form.memberId"></el-input>
            </el-form-item>


          </el-form>
        </div>
        <span slot="footer" class="dialog-footer">
          <el-button @click="centerDialogVisible = false;resetForm()">取 消</el-button>
          <el-button
              type="primary"
              @click="
              centerDialogVisible = false;
              addClick();
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

    inspectInput() {
      return this.form.type == "" || this.form.status == "" || this.form.floor == "" || this.form.memberPrice == "" || this.form.discountPrice == "" || this.form.standardPrice == "" || this.form.vipPrice == ""
    },

    onSearch() {
      console.log(this.formInline);
      this.selectRoom();
    },
    delClick(row) {
      //刪除功能
      //row為當前用戶的數據
      /*console.log(row);*/
      this.delRoom(row.id);
    },
    getM(month) {
      if (month < 10) {
        return '0' + month;
      } else {
        return month;
      }
    },
    parseTime() {
      for (var i = 0; i < 2; i++) {
        var newDate = this.Time[i].getFullYear() + '-' + this.getM(this.Time[i].getMonth() + 1) + '-' + this.getM(this.Time[i].getDate()) +
            '/' + this.getM(this.Time[i].getHours()) + ':' + this.getM(this.Time[i].getMinutes()) + ':' + this.getM(this.Time[i].getSeconds());
        /*  console.log(newDate);*/
        this.Time[i] = newDate;
      }

    },

    editButton(row) {
      this.form.guestName = row.guestName;
      this.form.guestIdType = row.guestIdType;
      this.form.guestId = row.guestId;
      this.form.tel = row.tel;
      this.form.guestCount = row.guestCount;
      this.form.memberId = row.memberId;
      /*   console.log(this.form);*/
      this.editId = row.id;
    },

    resetForm() {
      this.form.guestName = "";
      this.form.guestIdType = "";
      this.form.guestId = "";
      this.form.tel = "";
      this.form.guestCount = "";
      this.form.memberId = "";
      this.arriveTime = "";
      this.leaveTime = "";
    },
    handleClose(done) {
      //彈出框屬性
      this.$confirm("确认关闭？")
          .then((_) => {
            done();
          })
          .catch((_) => {
          });
    },
    handleCurrentChange(val) {
      /*console.log(val);*/
      this.getRoom(val);
      this.nowpage = val;
    },

    getRoom(page) {

      axios.get(this.http + "getRoom?page=" + page).then(
          (res) => {
            /*console.log(res);*/

            this.UserList = res.data.List;
            this.floorOption = res.data.OptionFloor;
            this.typeOption = res.data.OptionType;
            if (res.data.List.length == 0 && this.nowpage != 1) {
              this.nowpage--;
              this.getRoom(this.nowpage);
            }

            if (res.data.count / 6 != 0) {
              this.totalPage = res.data.count / 6;
            } else {
              this.totalPage = res.data.count / 6 - 1;
            }
            this.totalPage = this.totalPage * 10;
            this.getOption();
            /* console.log(this.totalPage); */

          },
          (res) => {
          }
      );
    },
    getOption() {
      this.typeOptions = [];
      this.floorOptions = [];
      var share = {
        value: "",
        label: "无",
      }
      this.typeOptions.push(share);
      this.floorOptions.push(share);

      for (var i = 0; i < this.typeOption.length; i++) {
        var add = {
          value: this.typeOption[i],
          label: this.typeOption[i],
        }
        this.typeOptions.push(add);
      }

      for (var i = 0; i < this.floorOption.length; i++) {
        var add = {
          value: this.floorOption[i],
          label: this.floorOption[i],
        }
        this.floorOptions.push(add);
      }
      /*console.log(this.floorOption);*/

    },
    delRoom(id) {

      axios
          .get(this.http + "delRoom?id=" + id)
          .then(
              (res) => {
                /*console.log(res.data);*/
                this.getRoom(this.nowpage);
              },
              (res) => {
              }
          );

    },
    selectRoom() {
      axios
          .get(
              this.http + "selectRoom?id=" +
              this.formInline.searchId + "&type=" + this.formInline.type + "&floor=" + this.formInline.floor + "&status=" + this.formInline.status + "&standardPrice=" + this.formInline.standardPrice
          )
          .then(
              (res) => {
                /* console.log(res);*/

                this.UserList = res.data.List;
                this.nowpage = 1;
              },
              (res) => {
              }
          );
    },
    addClick() {
      this.parseTime();
      axios
          .get(
              this.http + "addReserve?id=" + this.editId + "&guestName=" +
              this.form.guestName +
              "&guestIdType=" +
              this.form.guestIdType + "&guestId=" + this.form.guestId +
              "&tel=" + this.form.tel +
              "&arriveTime=" + this.Time[0] +
              "&leaveTime=" + this.Time[1] +
              "&guestCount=" + this.form.guestCount +
              "&memberId=" + this.form.memberId
          )
          .then(
              (res) => {

                this.getRoom(this.nowpage);
                this.resetForm();
              },
              (res) => {
              }
          );

    },
  },



  data() {
    return {
      http: "http://localhost:8080/0_Hotel_Management_war/",
      UserList: [
        {}
      ],
      floorOption:[],
      typeOption:[],
      arriveTime:'',
      leaveTime:'',
      Time:[],
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
        guestName: "",
        standardPrice: "",
        guestIdType: "",
        guestId: "",
        tel: "",
        guestCount: "",
        memberId: "",
      },
      formInline: {
        //搜尋用戶
        searchId: "",
        type: "",
        floor: "",
        status: "",
        standardPrice:"",
      },
      typeOptions: [

      ],
      guestTypeOptions:
      [
        {
          value: "身份证",
          label: "身份证",
        },
        {
          value: "居住证",
          label: "居住证",
        },

      ],
      floorOptions: [

      ],
      statusOptions: [
        {
          value: "空房",
          label: "空房",
        },
        {
          value: "预定",
          label: "预定",
        },
        {
          value: "入住",
          label: "入住",
        },
        {
          value: "",
          label: "无",
        }
      ],
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
#roomManager #addAndSearch #search .searchSpan
{
  margin-left: 20px;
  font-size: 12px;
}
#roomManager #addAndSearch #search .el-input {
  width: 120px;
}

#roomManager #editDialog .el-input {
  width: 280px;
}

#roomManager #page {
  bottom: 0;
  left: 50%;
  position: absolute;
}

#roomManager #formDiv .el-table th, #roomManager #formDiv .el-table tr, #roomManager #formDiv .el-table__empty-block, #roomManager .el-table__row td {
  border: 1px solid #CBCBCB;
  background-color: #EEEEEE;
}

#roomManager .el-form-item__label {
  width: 100px !important;
}

#roomManager .el-dialog {
  margin-top: 20px !important;
}
</style>

