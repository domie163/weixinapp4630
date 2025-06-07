import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
    // 解决多次点击左侧菜单报错问题
    const VueRouterPush = VueRouter.prototype.push
    VueRouter.prototype.push = function push (to) {
    return VueRouterPush.call(this, to).catch(err => err)
    }
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
import beifen from '@/views/modules/databaseBackup/beifen'
import huanyuan from '@/views/modules/databaseBackup/huanyuan'

     import users from '@/views/modules/users/list'
    import dictionary from '@/views/modules/dictionary/list'
    import gonggao from '@/views/modules/gonggao/list'
    import gongsi from '@/views/modules/gongsi/list'
    import jianli from '@/views/modules/jianli/list'
    import laoshi from '@/views/modules/laoshi/list'
    import shixi from '@/views/modules/shixi/list'
    import shixirizhi from '@/views/modules/shixirizhi/list'
    import tongzhi from '@/views/modules/tongzhi/list'
    import xuesheng from '@/views/modules/xuesheng/list'
    import zhaopin from '@/views/modules/zhaopin/list'
    import zhaopinCollection from '@/views/modules/zhaopinCollection/list'
    import zhaopinLiuyan from '@/views/modules/zhaopinLiuyan/list'
    import zhaopinToudi from '@/views/modules/zhaopinToudi/list'
    import config from '@/views/modules/config/list'
    import dictionaryBuzhu from '@/views/modules/dictionaryBuzhu/list'
    import dictionaryDaijiao from '@/views/modules/dictionaryDaijiao/list'
    import dictionaryGonggao from '@/views/modules/dictionaryGonggao/list'
    import dictionaryGongsi from '@/views/modules/dictionaryGongsi/list'
    import dictionaryHangye from '@/views/modules/dictionaryHangye/list'
    import dictionaryJianli from '@/views/modules/dictionaryJianli/list'
    import dictionaryKaoyanzhuanye from '@/views/modules/dictionaryKaoyanzhuanye/list'
    import dictionaryLeixing from '@/views/modules/dictionaryLeixing/list'
    import dictionaryManyi from '@/views/modules/dictionaryManyi/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionaryShangxia from '@/views/modules/dictionaryShangxia/list'
    import dictionaryShixi from '@/views/modules/dictionaryShixi/list'
    import dictionarySuoshuleixing from '@/views/modules/dictionarySuoshuleixing/list'
    import dictionarySushe from '@/views/modules/dictionarySushe/list'
    import dictionaryTongzhi from '@/views/modules/dictionaryTongzhi/list'
    import dictionaryZhaopin from '@/views/modules/dictionaryZhaopin/list'
    import dictionaryZhaopinCollection from '@/views/modules/dictionaryZhaopinCollection/list'
    import dictionaryZhaopinShifou from '@/views/modules/dictionaryZhaopinShifou/list'
    import dictionaryZhaopinToudiYesno from '@/views/modules/dictionaryZhaopinToudiYesno/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }, {
        path: '/huanyuan',
        name: '数据还原',
        component: huanyuan
    }, {
        path: '/beifen',
        name: '数据备份',
        component: beifen
    }, {
        path: '/users',
        name: '管理信息',
        component: users
    }
    ,{
        path: '/dictionaryBuzhu',
        name: '补助',
        component: dictionaryBuzhu
    }
    ,{
        path: '/dictionaryDaijiao',
        name: '是否安排带教',
        component: dictionaryDaijiao
    }
    ,{
        path: '/dictionaryGonggao',
        name: '公告类型',
        component: dictionaryGonggao
    }
    ,{
        path: '/dictionaryGongsi',
        name: '公司类型',
        component: dictionaryGongsi
    }
    ,{
        path: '/dictionaryHangye',
        name: '行业',
        component: dictionaryHangye
    }
    ,{
        path: '/dictionaryJianli',
        name: '求职意向',
        component: dictionaryJianli
    }
    ,{
        path: '/dictionaryKaoyanzhuanye',
        name: '考研专业',
        component: dictionaryKaoyanzhuanye
    }
    ,{
        path: '/dictionaryLeixing',
        name: '招聘类型',
        component: dictionaryLeixing
    }
    ,{
        path: '/dictionaryManyi',
        name: '单位满意状态',
        component: dictionaryManyi
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryShangxia',
        name: '是否上架',
        component: dictionaryShangxia
    }
    ,{
        path: '/dictionaryShixi',
        name: '实习类型',
        component: dictionaryShixi
    }
    ,{
        path: '/dictionarySuoshuleixing',
        name: '所属类型',
        component: dictionarySuoshuleixing
    }
    ,{
        path: '/dictionarySushe',
        name: '住宿',
        component: dictionarySushe
    }
    ,{
        path: '/dictionaryTongzhi',
        name: '通知类型',
        component: dictionaryTongzhi
    }
    ,{
        path: '/dictionaryZhaopin',
        name: '招聘岗位',
        component: dictionaryZhaopin
    }
    ,{
        path: '/dictionaryZhaopinCollection',
        name: '收藏表类型',
        component: dictionaryZhaopinCollection
    }
    ,{
        path: '/dictionaryZhaopinShifou',
        name: '是否招聘',
        component: dictionaryZhaopinShifou
    }
    ,{
        path: '/dictionaryZhaopinToudiYesno',
        name: '审核状态',
        component: dictionaryZhaopinToudiYesno
    }
    ,{
        path: '/config',
        name: '轮播图',
        component: config
    }


    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/gonggao',
        name: '公告',
        component: gonggao
      }
    ,{
        path: '/gongsi',
        name: '公司',
        component: gongsi
      }
    ,{
        path: '/jianli',
        name: '简历',
        component: jianli
      }
    ,{
        path: '/laoshi',
        name: '老师',
        component: laoshi
      }
    ,{
        path: '/shixi',
        name: '实习',
        component: shixi
      }
    ,{
        path: '/shixirizhi',
        name: '实习日志',
        component: shixirizhi
      }
    ,{
        path: '/tongzhi',
        name: '通知',
        component: tongzhi
      }
    ,{
        path: '/xuesheng',
        name: '学生',
        component: xuesheng
      }
    ,{
        path: '/zhaopin',
        name: '职位招聘',
        component: zhaopin
      }
    ,{
        path: '/zhaopinCollection',
        name: '职位收藏',
        component: zhaopinCollection
      }
    ,{
        path: '/zhaopinLiuyan',
        name: '职位留言',
        component: zhaopinLiuyan
      }
    ,{
        path: '/zhaopinToudi',
        name: '简历投递',
        component: zhaopinToudi
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
