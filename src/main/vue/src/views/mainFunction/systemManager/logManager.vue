<template>
  <div id="logManager">

    <div id="formDiv">
      <el-table
          :data="List"
          border
          style="width: 100%"
      >
        <el-table-column fixed prop="id" label="编号" width="150">
        </el-table-column>
        <el-table-column prop="imageUrl" label="圖片地址" width="180">
        </el-table-column>

        <el-table-column label="操作">
          <template slot-scope="scope">
            <el-upload
                :action="uploadUrl(scope.row.id)"
                :on-success="handleAvatarSuccess"
                :befor-upload="beforeAvatarUpload"
            >
              <el-button size="mini">
                更新圖片
              </el-button>


            </el-upload>
          </template>
        </el-table-column>

      </el-table>
    </div>

    <div id="page">
      <el-pagination
          background
          layout="prev, pager, next"
          :total="300"
          @current-change="handleCurrentChange"
      >
      </el-pagination>
    </div>
  </div>
</template>

<script>
const axios = require("axios");
export default {
  mounted() {
    this.getUser(0);
  },
  methods: {
    uploadUrl(id){
      return 'http://localhost:8081/uploadBannerPic?id='+id;
    },
    handleAvatarSuccess(res,file){
      this.imageUrl = URL.createObjectURL(file.raw);
     /* this.searchAdmin(this.currentPage)*/

    },
    beforeAvatarUpload(file){
      let is=(file.type === 'image/jpeg') || (file.type === 'image/png')
      if(!is){
        this.$message.error('上傳頭像圖片只能是jpg或png格式');
        return false;
      }
      return true;
    },
    getUser(page) {
      axios.get(this.http+"queryBannerLimit?page="+page+"&pageSize=6").then(
          (res) => {
            console.log(res);
            this.List = res.data.data;
          },
          (res) => {}
      );
    },
    handleCurrentChange(val) {
      /*console.log(val);*/
      this.getUser((val-1)*6);
    },

  },

  data() {
    return {
      http:"http://localhost:8081/",
      List: [

      ],
    }
  },
};
</script>

<style>
#logManager {
  width: 100%;
  height: 100%;
  position: relative;

}

</style>

