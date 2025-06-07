
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 实习日志
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/shixirizhi")
public class ShixirizhiController {
    private static final Logger logger = LoggerFactory.getLogger(ShixirizhiController.class);

    private static final String TABLE_NAME = "shixirizhi";

    @Autowired
    private ShixirizhiService shixirizhiService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private GonggaoService gonggaoService;//公告
    @Autowired
    private GongsiService gongsiService;//公司
    @Autowired
    private JianliService jianliService;//简历
    @Autowired
    private LaoshiService laoshiService;//老师
    @Autowired
    private ShixiService shixiService;//实习
    @Autowired
    private TongzhiService tongzhiService;//通知
    @Autowired
    private XueshengService xueshengService;//学生
    @Autowired
    private ZhaopinService zhaopinService;//职位招聘
    @Autowired
    private ZhaopinCollectionService zhaopinCollectionService;//职位收藏
    @Autowired
    private ZhaopinLiuyanService zhaopinLiuyanService;//职位留言
    @Autowired
    private ZhaopinToudiService zhaopinToudiService;//简历投递
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("学生".equals(role))
            params.put("xueshengId",request.getSession().getAttribute("userId"));
        else if("公司".equals(role))
            params.put("gongsiId",request.getSession().getAttribute("userId"));
        else if("老师".equals(role))
            params.put("laoshiId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = shixirizhiService.queryPage(params);

        //字典表数据转换
        List<ShixirizhiView> list =(List<ShixirizhiView>)page.getList();
        for(ShixirizhiView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ShixirizhiEntity shixirizhi = shixirizhiService.selectById(id);
        if(shixirizhi !=null){
            //entity转view
            ShixirizhiView view = new ShixirizhiView();
            BeanUtils.copyProperties( shixirizhi , view );//把实体数据重构到view中
            //级联表 学生
            //级联表
            XueshengEntity xuesheng = xueshengService.selectById(shixirizhi.getXueshengId());
            if(xuesheng != null){
            BeanUtils.copyProperties( xuesheng , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "xueshengId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setXueshengId(xuesheng.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ShixirizhiEntity shixirizhi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,shixirizhi:{}",this.getClass().getName(),shixirizhi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("学生".equals(role))
            shixirizhi.setXueshengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<ShixirizhiEntity> queryWrapper = new EntityWrapper<ShixirizhiEntity>()
            .eq("xuesheng_id", shixirizhi.getXueshengId())
            .eq("riqi_time", new SimpleDateFormat("yyyy-MM-dd").format(shixirizhi.getRiqiTime()))
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShixirizhiEntity shixirizhiEntity = shixirizhiService.selectOne(queryWrapper);
        if(shixirizhiEntity==null){
            shixirizhi.setInsertTime(new Date());
            shixirizhi.setCreateTime(new Date());
            shixirizhiService.insert(shixirizhi);
            return R.ok();
        }else {
            return R.error(511,"该天已有日志");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ShixirizhiEntity shixirizhi, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,shixirizhi:{}",this.getClass().getName(),shixirizhi.toString());
        ShixirizhiEntity oldShixirizhiEntity = shixirizhiService.selectById(shixirizhi.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("学生".equals(role))
//            shixirizhi.setXueshengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            shixirizhiService.updateById(shixirizhi);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ShixirizhiEntity> oldShixirizhiList =shixirizhiService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        shixirizhiService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer xueshengId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<ShixirizhiEntity> shixirizhiList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            ShixirizhiEntity shixirizhiEntity = new ShixirizhiEntity();
//                            shixirizhiEntity.setXueshengId(Integer.valueOf(data.get(0)));   //学生 要改的
//                            shixirizhiEntity.setShixirizhiUuidNumber(data.get(0));                    //实习日志编号 要改的
//                            shixirizhiEntity.setShixirizhiName(data.get(0));                    //实习日志标题 要改的
//                            shixirizhiEntity.setRiqiTime(sdf.parse(data.get(0)));          //日期 要改的
//                            shixirizhiEntity.setShixirizhiContent("");//详情和图片
//                            shixirizhiEntity.setInsertTime(date);//时间
//                            shixirizhiEntity.setCreateTime(date);//时间
                            shixirizhiList.add(shixirizhiEntity);


                            //把要查询是否重复的字段放入map中
                                //实习日志编号
                                if(seachFields.containsKey("shixirizhiUuidNumber")){
                                    List<String> shixirizhiUuidNumber = seachFields.get("shixirizhiUuidNumber");
                                    shixirizhiUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> shixirizhiUuidNumber = new ArrayList<>();
                                    shixirizhiUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("shixirizhiUuidNumber",shixirizhiUuidNumber);
                                }
                        }

                        //查询是否重复
                         //实习日志编号
                        List<ShixirizhiEntity> shixirizhiEntities_shixirizhiUuidNumber = shixirizhiService.selectList(new EntityWrapper<ShixirizhiEntity>().in("shixirizhi_uuid_number", seachFields.get("shixirizhiUuidNumber")));
                        if(shixirizhiEntities_shixirizhiUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ShixirizhiEntity s:shixirizhiEntities_shixirizhiUuidNumber){
                                repeatFields.add(s.getShixirizhiUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [实习日志编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        shixirizhiService.insertBatch(shixirizhiList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = shixirizhiService.queryPage(params);

        //字典表数据转换
        List<ShixirizhiView> list =(List<ShixirizhiView>)page.getList();
        for(ShixirizhiView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ShixirizhiEntity shixirizhi = shixirizhiService.selectById(id);
            if(shixirizhi !=null){


                //entity转view
                ShixirizhiView view = new ShixirizhiView();
                BeanUtils.copyProperties( shixirizhi , view );//把实体数据重构到view中

                //级联表
                    XueshengEntity xuesheng = xueshengService.selectById(shixirizhi.getXueshengId());
                if(xuesheng != null){
                    BeanUtils.copyProperties( xuesheng , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setXueshengId(xuesheng.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody ShixirizhiEntity shixirizhi, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,shixirizhi:{}",this.getClass().getName(),shixirizhi.toString());
        Wrapper<ShixirizhiEntity> queryWrapper = new EntityWrapper<ShixirizhiEntity>()
            .eq("xuesheng_id", shixirizhi.getXueshengId())
            .eq("shixirizhi_uuid_number", shixirizhi.getShixirizhiUuidNumber())
            .eq("shixirizhi_name", shixirizhi.getShixirizhiName())
//            .notIn("shixirizhi_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShixirizhiEntity shixirizhiEntity = shixirizhiService.selectOne(queryWrapper);
        if(shixirizhiEntity==null){
            shixirizhi.setInsertTime(new Date());
            shixirizhi.setCreateTime(new Date());
        shixirizhiService.insert(shixirizhi);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

