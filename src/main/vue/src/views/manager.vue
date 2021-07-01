<template>
  <div class="manager">
    <div id="managerTop">
      <div id="logo"></div>
      <span id="title">酒店管理系统</span>
      <span id="user">用戶 {{this.uname}} , 你好</span>
    </div>

    <div id="middle">
      <div id="function">
        <el-col :span="12">
          <el-menu
            default-active="userManager"
            class="el-menu-vertical-demo"
            background-color="#002244"
            text-color="#fff"
            active-text-color="#ffd04b"
          >
            <el-submenu index="1">
              <template slot="title">
                <i class="el-icon-location"></i>
                <span>系统管理</span>
              </template>
              <el-menu-item-group>
                <el-menu-item index="userManager" @click="clickFunction">用户管理</el-menu-item>
                <el-menu-item index="logManager" @click="clickFunction">日志管理</el-menu-item>
              </el-menu-item-group>
            </el-submenu>

            <el-submenu index="2">
              <template slot="title">
                <i class="el-icon-menu"></i>
                <span>报表管理</span>
              </template>
              <el-menu-item-group>
                <el-menu-item index="2-1" @click="clickFunction">预定客人报表</el-menu-item>
                <el-menu-item index="2-2" @click="clickFunction">在住客人报表</el-menu-item>
                <el-menu-item index="2-3" @click="clickFunction">离店客人报表</el-menu-item>
                <el-menu-item index="2-4" @click="clickFunction">财务进帐报表</el-menu-item>
              </el-menu-item-group>
            </el-submenu>

            <el-submenu index="3">
              <template slot="title">
                <i class="el-icon-user"></i>
                <span>房客管理</span>
              </template>
              <el-menu-item-group>
                <el-menu-item index="3-1" @click="clickFunction">客房预定管理</el-menu-item>
                <el-menu-item index="3-2" @click="clickFunction">入住登记管理</el-menu-item>
                <el-menu-item index="3-3" @click="clickFunction">预定转入住</el-menu-item>
                <el-menu-item index="3-4" @click="clickFunction">换房管理</el-menu-item>
                <el-menu-item index="3-5" @click="clickFunction">结帐管理</el-menu-item>
              </el-menu-item-group>
            </el-submenu>

            <el-submenu index="4">
              <template slot="title">
                <i class="el-icon-document-copy"></i>
                <span>基础信息维护</span>
              </template>
              <el-menu-item-group>
                <el-menu-item index="floorManager" @click="clickFunction">客房类型管理</el-menu-item>
                <el-menu-item index="roomtypeManager" @click="clickFunction">楼层管理</el-menu-item>
                <el-menu-item index="goodstypeManager" @click="clickFunction">商品类别管理</el-menu-item>
                <el-menu-item index="goodsManager" @click="clickFunction">商品管理</el-menu-item>
                <el-menu-item index="memberManager" @click="clickFunction">会员管理</el-menu-item>
              </el-menu-item-group>
            </el-submenu>

            <el-menu-item index="consumeManager" @click="oneClickFunction">
              <i class="el-icon-shopping-cart-2"></i>
              <span slot="title">消费管理</span>
            </el-menu-item>

            <el-menu-item index="roomManager" @click="oneClickFunction">
              <i class="el-icon-setting"></i>
              <span slot="title">客房管理</span>
            </el-menu-item>
          </el-menu>
        </el-col>
      </div>

      <div id="mainFunction">
        <router-view></router-view>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  mounted(){
    this.getUserName();
  },
  data() {
    return {
        uname:"",
    };

  },


  methods: {
    getUserName()
    {
      console.log(this.$route.query);
      this.uname=this.$route.query.name;
    },
    oneClickFunction(keyPath)
    {
      /* console.log(keyPath.index); */
      this.$router.push("/manager/"+keyPath.index);
    },
    clickFunction(keyPath)
    {
      /* console.log(keyPath.index); */
      this.$router.push("/manager/"+keyPath.index);
    },
  },
};
</script>
<style>
.manager
{
  width: 100%;
  height: 100%;
}
#managerTop {
  width: 100%;
  height: 130px;
  background-color: #002244;
 /* background-image: linear-gradient(45deg, #545C64 30%, yellow );*/
  /*background: url("../assets/top.jpg") no-repeat center center; !*加载背景图*! !* 背景图不平铺 *!
  background-size: cover; !* 让背景图基于容器大小伸缩 *!
  background-attachment: fixed;*/
}
#managerTop #title {
  font-size: 25px;
  margin-left: 30px;
  line-height: 120px;
  color: #EDBF71;
}
#managerTop #user {
  float: right;
  margin-top: 100px;
  margin-right: 80px;
  color: white;
}
#managerTop #logo
{
  float: left;
  margin-left: 20px;
  width: 130px;
  height: 120px;

 background: url("../assets/logo.png") no-repeat;
}
.manager #middle {
  width: 100%;

}
.manager #middle #mainFunction
{
  width: 1140px;
  height: 600px;

}
.manager #middle #function,.manager #middle #mainFunction
{
  float: left;
}
.manager #middle #function {
  background-color: #002141;
}
/* 左邊導航栏width更改 */
.manager #function .el-col-12 {
  width: 298px;
  height: 700px;

}
.manager #function .el-menu
{
  width: 298px;

}
</style>