import Vue from 'vue'
import VueRouter from 'vue-router'


const Manager = () => import('../views/manager')
const Login = () => import('../views/login')
const UserManager = () => import('../views/mainFunction/systemManager/userManager')
const LogManager = () => import('../views/mainFunction/systemManager/logManager')
const RoomManager = () => import('../views/mainFunction/roomManager/roomManager')

//基础信息维护頁面
const FloorManager = () => import('../views/mainFunction/dataManager/floorManager')
const GoodsManager = () => import('../views/mainFunction/dataManager/goodsManager')
const GoodstypeManager = () => import('../views/mainFunction/dataManager/goodstypeManager')
const MemberManager = () => import('../views/mainFunction/dataManager/memberManager')
const RoomtypeManager = () => import('../views/mainFunction/dataManager/roomtypeManager')

//消费管理
const ConsumeManager = () => import('../views/mainFunction/consumeManager/consumeManager')

Vue.use(VueRouter)

const routes = [

  {
    path: '/',
    redirect: 'login'
  },
  
  
  {
    path: '/manager',
    component: Manager,
    children: [
      {
        path: '/',
        redirect: 'userManager'
      },
      {
        path: 'userManager',
        component: UserManager
      },
      {
        path: 'logManager',
        component: LogManager
      },
      {
        path: 'roomManager',
        component: RoomManager
      },
      {
        path:'floorManager',
        component:FloorManager
      },
      {
        path:'goodsManager',
        component:GoodsManager
      },
      {
        path:'goodstypeManager',
        component:GoodstypeManager
      },
      {
        path:'memberManager',
        component:MemberManager
      },
      {
        path:'roomtypeManager',
        component:RoomtypeManager
      },
      {
        path:'consumeManager',
        component:ConsumeManager
      }
    ]
  },
  {
    path: '/login',
    component: Login
  },
 
]

const router = new VueRouter({
  mode:'history',
  routes
})

export default router
