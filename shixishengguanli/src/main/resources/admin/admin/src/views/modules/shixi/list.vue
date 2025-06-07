<template>
    <div class="main-content">

        <!-- 条件查询 -->
        <div v-if="showFlag">
            <el-form :inline="true" :model="searchForm" class="form-content">
                <el-row :gutter="20" class="slt" :style="{justifyContent:contents.searchBoxPosition=='1'?'flex-start':contents.searchBoxPosition=='2'?'center':'flex-end'}">
                                 
                     <el-form-item :label="contents.inputTitle == 1 ? '实习名称' : ''">
                         <el-input prefix-icon="el-icon-search" v-model="searchForm.shixiName" placeholder="实习名称" clearable></el-input>
                     </el-form-item>
         
                     <el-form-item :label="contents.inputTitle == 1 ? '实习类型' : ''">
                        <el-select v-model="searchForm.shixiTypes" placeholder="请选择实习类型">
                            <el-option label="=-请选择-=" value=""></el-option>
                            <el-option
                               v-for="(item,index) in shixiTypesSelectSearch"
                               v-bind:key="index"
                               :label="item.indexName"
                               :value="item.codeIndex">
                            <!--lable是要展示的名称-->
                            <!--value是值-->
                            </el-option>
                        </el-select>
                     </el-form-item>

         
                     <el-form-item :label="contents.inputTitle == 1 ? '实习单位' : ''">
                         <el-input prefix-icon="el-icon-search" v-model="searchForm.shixiDanweimingcheng" placeholder="实习单位" clearable></el-input>
                     </el-form-item>
         
                     <el-form-item :label="contents.inputTitle == 1 ? '行业' : ''">
                        <el-select v-model="searchForm.hangyeTypes" placeholder="请选择行业">
                            <el-option label="=-请选择-=" value=""></el-option>
                            <el-option
                               v-for="(item,index) in hangyeTypesSelectSearch"
                               v-bind:key="index"
                               :label="item.indexName"
                               :value="item.codeIndex">
                            <!--lable是要展示的名称-->
                            <!--value是值-->
                            </el-option>
                        </el-select>
                     </el-form-item>

         
                     <el-form-item :label="contents.inputTitle == 1 ? '所属类型' : ''">
                        <el-select v-model="searchForm.suoshuleixingTypes" placeholder="请选择所属类型">
                            <el-option label="=-请选择-=" value=""></el-option>
                            <el-option
                               v-for="(item,index) in suoshuleixingTypesSelectSearch"
                               v-bind:key="index"
                               :label="item.indexName"
                               :value="item.codeIndex">
                            <!--lable是要展示的名称-->
                            <!--value是值-->
                            </el-option>
                        </el-select>
                     </el-form-item>

                                                                                                                                 
                     <el-form-item :label="contents.inputTitle == 1 ? '考研学校' : ''">
                         <el-input prefix-icon="el-icon-search" v-model="searchForm.shixiKaoyanxuexiao" placeholder="考研学校" clearable></el-input>
                     </el-form-item>
                         
                     <el-form-item :label="contents.inputTitle == 1 ? '考公地区' : ''">
                         <el-input prefix-icon="el-icon-search" v-model="searchForm.shixiKaogongdiqu" placeholder="考公地区" clearable></el-input>
                     </el-form-item>
                                                                
                                         
                    <el-form-item :label="contents.inputTitle == 1 ? '学生姓名' : ''">
                        <el-input prefix-icon="el-icon-search" v-model="searchForm.xueshengName" placeholder="学生姓名" clearable></el-input>
                    </el-form-item>
                                                                                                    

                    <el-form-item>
                        <el-button type="success" @click="search()">查询<i class="el-icon-search el-icon--right"/></el-button>
                    </el-form-item>
                </el-row>
                <el-row class="ad" :style="{justifyContent:contents.btnAdAllBoxPosition=='1'?'flex-start':contents.btnAdAllBoxPosition=='2'?'center':'flex-end'}">
                    <el-form-item>
                        <el-button
                                v-if="isAuth('shixi','新增')"
                                type="success"
                                icon="el-icon-plus"
                                @click="addOrUpdateHandler()"
                        >新增</el-button>
                        &nbsp;
                        <el-button
                                v-if="isAuth('shixi','删除')"
                                :disabled="dataListSelections.length <= 0"
                                type="danger"
                                icon="el-icon-delete"
                                @click="deleteHandler()"
                        >删除</el-button>
                        &nbsp;
                        <el-button
                                v-if="isAuth('shixi','报表')"
                                type="success"
                                icon="el-icon-pie-chart"
                                @click="chartDialog()"
                        >实习类型统计报表</el-button>
                        &nbsp;
                        <a style="text-decoration:none" class="el-button el-button--success"
                           v-if="isAuth('shixi','导入导出')"
                           icon="el-icon-download"
                           href="http://localhost:8080/shixishengguanli/upload/shixiMuBan.xls"
                        >批量导入实习数据模板</a>
                        &nbsp;
                        <el-upload
                                v-if="isAuth('shixi','导入导出')"
                                style="display: inline-block"
                                :action="getActionUrl"
                                :on-success="shixiUploadSuccess"
                                :on-error="shixiUploadError"
                                :show-file-list = false>
                            <el-button
                                    v-if="isAuth('shixi','导入导出')"
                                    type="success"
                                    icon="el-icon-upload2"
                            >批量导入实习数据</el-button>
                        </el-upload>
                        &nbsp;
                        <!-- 导出excel -->
                        <download-excel style="display: inline-block" class = "export-excel-wrapper" :data = "dataList" :fields = "json_fields" name = "shixi.xls">
                            <!-- 导出excel -->
                            <el-button
                                    type="success"
                                    icon="el-icon-download"
                            >导出</el-button>
                        </download-excel>
                        &nbsp;
                    </el-form-item>
                </el-row>
            </el-form>
            <div class="table-content">
                <el-table class="tables" :size="contents.tableSize" :show-header="contents.tableShowHeader"
                          :header-row-style="headerRowStyle" :header-cell-style="headerCellStyle"
                          :border="contents.tableBorder"
                          :fit="contents.tableFit"
                          :stripe="contents.tableStripe"
                          :row-style="rowStyle"
                          :cell-style="cellStyle"
                          :style="{width: '100%',fontSize:contents.tableContentFontSize,color:contents.tableContentFontColor}"
                          v-if="isAuth('shixi','查看')"
                          :data="dataList"
                          v-loading="dataListLoading"
                          @selection-change="selectionChangeHandler">
                    <el-table-column  v-if="contents.tableSelection"
                                      type="selection"
                                      header-align="center"
                                      align="center"
                                      width="50">
                    </el-table-column>
                    <el-table-column label="索引" v-if="contents.tableIndex" type="index" width="50" />
                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                      prop="xueshengName"
                                      header-align="center"
                                      label="学生姓名">
                        <template slot-scope="scope">
                            {{scope.row.xueshengName}}
                        </template>
                    </el-table-column>
                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                      prop="xueshengPhone"
                                      header-align="center"
                                      label="学生手机号">
                        <template slot-scope="scope">
                            {{scope.row.xueshengPhone}}
                        </template>
                    </el-table-column>
                    <el-table-column :sortable="contents.tableSortable" :align="contents.tableAlign" prop="xueshengPhoto"
                               header-align="center"
                               width="200"
                               label="学生头像">
                        <template slot-scope="scope">
                            <div v-if="scope.row.xueshengPhoto">
                                <img :src="$base.url+scope.row.xueshengPhoto" width="100" height="100">
                            </div>
                            <div v-else>无图片</div>
                        </template>
                    </el-table-column>

                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                   prop="shixiUuidNumber"
                                   header-align="center"
                                   label="实习编号">
                        <template slot-scope="scope">
                            {{scope.row.shixiUuidNumber}}
                        </template>
                    </el-table-column>

                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                   prop="shixiName"
                                   header-align="center"
                                   label="实习名称">
                        <template slot-scope="scope">
                            {{scope.row.shixiName}}
                        </template>
                    </el-table-column>
                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                      prop="shixiTypes"
                                      header-align="center"
                                      label="实习类型">
                        <template slot-scope="scope">
                            {{scope.row.shixiValue}}
                        </template>
                    </el-table-column>

                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                   prop="shixiDanweimingcheng"
                                   header-align="center"
                                   label="实习单位">
                        <template slot-scope="scope">
                            {{scope.row.shixiDanweimingcheng}}
                        </template>
                    </el-table-column>
                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                      prop="hangyeTypes"
                                      header-align="center"
                                      label="行业">
                        <template slot-scope="scope">
                            {{scope.row.hangyeValue}}
                        </template>
                    </el-table-column>
                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                      prop="suoshuleixingTypes"
                                      header-align="center"
                                      label="所属类型">
                        <template slot-scope="scope">
                            {{scope.row.suoshuleixingValue}}
                        </template>
                    </el-table-column>

                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                   prop="qiyeGuimo"
                                   header-align="center"
                                   label="企业规模">
                        <template slot-scope="scope">
                            {{scope.row.qiyeGuimo}}
                        </template>
                    </el-table-column>

                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                   prop="shixiDanweidizhi"
                                   header-align="center"
                                   label="单位地址">
                        <template slot-scope="scope">
                            {{scope.row.shixiDanweidizhi}}
                        </template>
                    </el-table-column>

                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                   prop="jinruTime"
                                   header-align="center"
                                   label="进入时间">
                        <template slot-scope="scope">
                            {{scope.row.jinruTime}}
                        </template>
                    </el-table-column>

                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                   prop="shixiGangwei"
                                   header-align="center"
                                   label="实习岗位">
                        <template slot-scope="scope">
                            {{scope.row.shixiGangwei}}
                        </template>
                    </el-table-column>

                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                   prop="shixiGangweiFangxiang"
                                   header-align="center"
                                   label="岗位培养方向">
                        <template slot-scope="scope">
                            {{scope.row.shixiGangweiFangxiang}}
                        </template>
                    </el-table-column>
                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                      prop="daijiaoTypes"
                                      header-align="center"
                                      label="是否安排带教">
                        <template slot-scope="scope">
                            {{scope.row.daijiaoValue}}
                        </template>
                    </el-table-column>
                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                      prop="buzhuTypes"
                                      header-align="center"
                                      label="补助">
                        <template slot-scope="scope">
                            {{scope.row.buzhuValue}}
                        </template>
                    </el-table-column>
                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                      prop="susheTypes"
                                      header-align="center"
                                      label="包宿">
                        <template slot-scope="scope">
                            {{scope.row.susheValue}}
                        </template>
                    </el-table-column>

                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                   prop="xinzi"
                                   header-align="center"
                                   label="薪资">
                        <template slot-scope="scope">
                            {{scope.row.xinzi}}
                        </template>
                    </el-table-column>

                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                   prop="xianzhuAddress"
                                   header-align="center"
                                   label="现住地址">
                        <template slot-scope="scope">
                            {{scope.row.xianzhuAddress}}
                        </template>
                    </el-table-column>
                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                      prop="zhaopinShifouTypes"
                                      header-align="center"
                                      label="是否招聘">
                        <template slot-scope="scope">
                            {{scope.row.zhaopinShifouValue}}
                        </template>
                    </el-table-column>
                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                      prop="manyiTypes"
                                      header-align="center"
                                      label="单位满意状态">
                        <template slot-scope="scope">
                            {{scope.row.manyiValue}}
                        </template>
                    </el-table-column>

                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                   prop="shixiKaoyanxuexiao"
                                   header-align="center"
                                   label="考研学校">
                        <template slot-scope="scope">
                            {{scope.row.shixiKaoyanxuexiao}}
                        </template>
                    </el-table-column>
                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                      prop="kaoyanzhuanyeTypes"
                                      header-align="center"
                                      label="考研专业">
                        <template slot-scope="scope">
                            {{scope.row.kaoyanzhuanyeValue}}
                        </template>
                    </el-table-column>

                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                   prop="shixiKaoyanfangxiang"
                                   header-align="center"
                                   label="方向">
                        <template slot-scope="scope">
                            {{scope.row.shixiKaoyanfangxiang}}
                        </template>
                    </el-table-column>

                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                   prop="shixiKaogongdiqu"
                                   header-align="center"
                                   label="考公地区">
                        <template slot-scope="scope">
                            {{scope.row.shixiKaogongdiqu}}
                        </template>
                    </el-table-column>

                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                   prop="shixiKaogongzhiwei"
                                   header-align="center"
                                   label="职位">
                        <template slot-scope="scope">
                            {{scope.row.shixiKaogongzhiwei}}
                        </template>
                    </el-table-column>

                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                   prop="kaogongTime"
                                   header-align="center"
                                   label="考公时间">
                        <template slot-scope="scope">
                            {{scope.row.kaogongTime}}
                        </template>
                    </el-table-column>

                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                   prop="shixiLiuxue"
                                   header-align="center"
                                   label="留学国家">
                        <template slot-scope="scope">
                            {{scope.row.shixiLiuxue}}
                        </template>
                    </el-table-column>

                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                   prop="shixiLiuxueDaxue"
                                   header-align="center"
                                   label="留学大学">
                        <template slot-scope="scope">
                            {{scope.row.shixiLiuxueDaxue}}
                        </template>
                    </el-table-column>

                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                   prop="shixiLiuxueDanwei"
                                   header-align="center"
                                   label="留学单位">
                        <template slot-scope="scope">
                            {{scope.row.shixiLiuxueDanwei}}
                        </template>
                    </el-table-column>

                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                   prop="insertTime"
                                   header-align="center"
                                   label="录入时间">
                        <template slot-scope="scope">
                            {{scope.row.insertTime}}
                        </template>
                    </el-table-column>

                    <el-table-column width="300" :align="contents.tableAlign"
                                     header-align="center"
                                     label="操作">
                        <template slot-scope="scope">
                            <el-button v-if="sessionTable=='false'" type="primary" size="mini" @click="wuyong(scope.row.id)">无用按钮</el-button>
                            <el-button v-if="sessionTable=='false'" type="success" icon="el-icon-printer" size="mini" @click="dayinOpen(scope.row)">打印</el-button>
                            <el-button v-if="isAuth('shixi','查看')" type="success" icon="el-icon-tickets" size="mini" @click="addOrUpdateHandler(scope.row.id,'info')">详情</el-button>
                            <el-button v-if="isAuth('shixi','修改')" type="primary" icon="el-icon-edit" size="mini" @click="addOrUpdateHandler(scope.row.id)">修改</el-button>
                            <el-button v-if="isAuth('shixi','删除')" type="danger" icon="el-icon-delete" size="mini" @click="deleteHandler(scope.row.id)">删除</el-button>

                        </template>
                    </el-table-column>
                </el-table>
                <el-pagination
                        clsss="pages"
                        :layout="layouts"
                        @size-change="sizeChangeHandle"
                        @current-change="currentChangeHandle"
                        :current-page="pageIndex"
                        :page-sizes="[10, 20, 50, 100]"
                        :page-size="Number(contents.pageEachNum)"
                        :total="totalPage"
                        :small="contents.pageStyle"
                        class="pagination-content"
                        :background="contents.pageBtnBG"
                        :style="{textAlign:contents.pagePosition==1?'left':contents.pagePosition==2?'center':'right'}"
                ></el-pagination>
            </div>
        </div>
        <!-- 添加/修改页面  将父组件的search方法传递给子组件-->
        <add-or-update v-if="addOrUpdateFlag" :parent="this" ref="addOrUpdate"></add-or-update>


        <el-dialog title="打印" :visible.sync="printVisiable" width="500px">
            <el-form ref="printContent" :model="printFrom" label-width="auto">
                <el-form-item label="发件人">
                    <div  style="display: flex">
                        <el-input v-model="printFrom.kuaidiFajianName" disabled></el-input>
                        :
                        <el-input v-model="printFrom.kuaidiFajianShoujihao" disabled></el-input>
                    </div>
                </el-form-item>
                <el-form-item label="发件人地址">
                    <el-input v-model="printFrom.kuaidiFajianAddress" disabled></el-input>
                </el-form-item>
            </el-form>
            <span slot="footer" class="dialog-footer">
              <el-button @click="printContent()" icon="el-icon-printer" type="success">打印</el-button>
              <el-button @click="printVisiable = false">关闭</el-button>
            </span>
        </el-dialog>

        <el-dialog title="统计报表" :visible.sync="chartVisiable" width="80%">
                <div id="statistic" style="width:100%;height:600px;"></div>
            <span slot="footer" class="dialog-footer">
				<el-button @click="chartVisiable = false">关闭</el-button>
			</span>
        </el-dialog>

    </div>
</template>
<script>
    import AddOrUpdate from "./add-or-update";
    import styleJs from "../../../utils/style.js";
    import utilsJs, {getYearFormat,getMonthFormat,getDateFormat,getDatetimeFormat} from "../../../utils/utils.js";

    export default {
        data() {
        return {
            //打印开始
            printFrom: {
                name1:"",
            },
            printVisiable: false,
            //打印结束
            searchForm: {
                key: ""
            },
            sessionTable : "",//登录账户所在表名
            role : "",//权限
            userId:"",//当前登录人的id
    //级联表下拉框搜索条件
    //当前表下拉框搜索条件
              shixiTypesSelectSearch : [],
              hangyeTypesSelectSearch : [],
              suoshuleixingTypesSelectSearch : [],
            form:{
                id : null,
                xueshengId : null,
                shixiUuidNumber : null,
                shixiName : null,
                shixiTypes : null,
                shixiDanweimingcheng : null,
                hangyeTypes : null,
                suoshuleixingTypes : null,
                qiyeGuimo : null,
                shixiDanweidizhi : null,
                jinruTime : null,
                shixiGangwei : null,
                shixiGangweiFangxiang : null,
                daijiaoTypes : null,
                buzhuTypes : null,
                susheTypes : null,
                xinzi : null,
                xianzhuAddress : null,
                tonggongsixiaoyouContent : null,
                zhaopinShifouTypes : null,
                danweizhuanyeContent : null,
                danweirenshiContent : null,
                manyiTypes : null,
                shixiKaoyanxuexiao : null,
                kaoyanzhuanyeTypes : null,
                shixiKaoyanfangxiang : null,
                shixiKaogongdiqu : null,
                shixiKaogongzhiwei : null,
                kaogongTime : null,
                shixiLiuxue : null,
                shixiLiuxueDaxue : null,
                shixiLiuxueDanwei : null,
                shixiContent : null,
                insertTime : null,
                createTime : null,
            },
            dataList: [],
            pageIndex: 1,
            pageSize: 10,
            totalPage: 0,
            dataListLoading: false,
            dataListSelections: [],
            showFlag: true,
            sfshVisiable: false,
            shForm: {},
            chartVisiable: false,
            echartsDate: new Date(),//echarts的时间查询字段
            addOrUpdateFlag:false,
            contents:null,
            layouts: '',

            //导出excel
            json_fields: {
                //级联表字段
                     '学生姓名': 'xueshengName',
                     '学生手机号': 'xueshengPhone',
                     '学生身份证号': 'xueshengIdNumber',
                     '学生头像': 'xueshengPhoto',
                     '学生邮箱': 'xueshengEmail',
                //本表字段
                     '实习编号': "shixiUuidNumber",
                     '实习名称': "shixiName",
                     '实习类型': "shixiValue",
                     '实习单位': "shixiDanweimingcheng",
                     '行业': "hangyeValue",
                     '所属类型': "suoshuleixingValue",
                     '企业规模': "qiyeGuimo",
                     '单位地址': "shixiDanweidizhi",
                     '进入时间': "jinruTime",
                     '实习岗位': "shixiGangwei",
                     '岗位培养方向': "shixiGangweiFangxiang",
                     '是否安排带教': "daijiaoValue",
                     '补助': "buzhuValue",
                     '包宿': "susheValue",
                     '薪资': "xinzi",
                     '现住地址': "xianzhuAddress",
                     '是否招聘': "zhaopinShifouValue",
                     '单位满意状态': "manyiValue",
                     '考研学校': "shixiKaoyanxuexiao",
                     '考研专业': "kaoyanzhuanyeValue",
                     '方向': "shixiKaoyanfangxiang",
                     '考公地区': "shixiKaogongdiqu",
                     '职位': "shixiKaogongzhiwei",
                     '考公时间': "kaogongTime",
                     '留学国家': "shixiLiuxue",
                     '留学大学': "shixiLiuxueDaxue",
                     '留学单位': "shixiLiuxueDanwei",
                     '录入时间': "insertTime",
            },

            };
        },
        created() {
            this.contents = styleJs.listStyle();
            this.init();
            this.getDataList();
            this.contentStyleChange()
        },
        mounted() {
            //获取当前登录学生的信息
            this.sessionTable = this.$storage.get("sessionTable");
            this.role = this.$storage.get("role");
            this.userId = this.$storage.get("userId");

        },
        filters: {
            htmlfilter: function (val) {
                return val.replace(/<[^>]*>/g).replace(/undefined/g,'');
            }
        },
        components: {
            AddOrUpdate,
        },
        computed: {
            getActionUrl: function() {
                return `/`+this.$base.name+`/file/upload`;
            }
        },
        methods: {
            chartDialog() {
                let _this = this;
                //饼状图
                _this.chartVisiable = true;
                this.$nextTick(()=>{
                    var statistic = this.$echarts.init(document.getElementById("statistic"),'macarons');
                    let params = {
                        tableName: "shixi",
                        groupColumn: "shixi_types",
                    }
                    this.$http({
                        url: "newSelectGroupCount",//pieSum pieCount
                        method: "get",
                        params: params
                    }).then(({data}) => {
                        if (data && data.code === 0) {
                            let res = data.data;
                            let xAxis = [];
                            let yAxis = [];
                            let pArray = []
                            var option = {};
                            for(let i=0;i<res.length;i++){
                                xAxis.push(res[i].name);
                                yAxis.push(res[i].value);
                                pArray.push({
                                    value: res[i].value,
                                    name: res[i].name
                                })
                                option = {
                                    title: {
                                        text: '实习类型统计报表',
                                        left: 'center'
                                    },
                                    tooltip: {
                                        trigger: 'item',
                                        formatter: '{b} : {c} ({d}%)'
                                    },
                                    legend: {
                                        orient: 'vertical',
                                        left: 'left'
                                    },
                                    series: [
                                        {
                                            type: 'pie',
                                            radius: '55%',
                                            center: ['50%', '60%'],
                                            data: pArray,
                                            emphasis: {
                                                itemStyle: {
                                                    shadowBlur: 10,
                                                    shadowOffsetX: 0,
                                                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                                                }
                                            }
                                        }
                                    ]
                                };
                            }
                            statistic.setOption(option,true);
                            window.onresize = function() {
                                statistic.resize();
                            };
                        }
                    });
                })
            },
            contentStyleChange() {
                this.contentSearchStyleChange()
                this.contentBtnAdAllStyleChange()
                this.contentSearchBtnStyleChange()
                this.contentTableBtnStyleChange()
                this.contentPageStyleChange()
            },
            contentSearchStyleChange() {
                this.$nextTick(() => {
                    document.querySelectorAll('.form-content .slt .el-input__inner').forEach(el => {
                        let textAlign = 'left'
                        if(this.contents.inputFontPosition == 2)
                            textAlign = 'center'
                            if (this.contents.inputFontPosition == 3) textAlign = 'right'
                                el.style.textAlign = textAlign
                            el.style.height = this.contents.inputHeight
                            el.style.lineHeight = this.contents.inputHeight
                            el.style.color = this.contents.inputFontColor
                            el.style.fontSize = this.contents.inputFontSize
                            el.style.borderWidth = this.contents.inputBorderWidth
                            el.style.borderStyle = this.contents.inputBorderStyle
                            el.style.borderColor = this.contents.inputBorderColor
                            el.style.borderRadius = this.contents.inputBorderRadius
                            el.style.backgroundColor = this.contents.inputBgColor
                    })
                    if (this.contents.inputTitle) {
                        document.querySelectorAll('.form-content .slt .el-form-item__label').forEach(el => {
                            el.style.color = this.contents.inputTitleColor
                            el.style.fontSize = this.contents.inputTitleSize
                            el.style.lineHeight = this.contents.inputHeight
                        })
                    }
                    setTimeout(() => {
                        document.querySelectorAll('.form-content .slt .el-input__prefix').forEach(el => {
                            el.style.color = this.contents.inputIconColor
                            el.style.lineHeight = this.contents.inputHeight
                        })
                        document.querySelectorAll('.form-content .slt .el-input__suffix').forEach(el => {
                            el.style.color = this.contents.inputIconColor
                            el.style.lineHeight = this.contents.inputHeight
                        })
                        document.querySelectorAll('.form-content .slt .el-input__icon').forEach(el => {
                            el.style.lineHeight = this.contents.inputHeight
                        })
                    }, 10 )
                })
            },
            // 搜索按钮
            contentSearchBtnStyleChange() {
                this.$nextTick(() => {
                    document.querySelectorAll('.form-content .slt .el-button--success').forEach(el => {
                        el.style.height = this.contents.searchBtnHeight
                        el.style.color = this.contents.searchBtnFontColor
                        el.style.fontSize = this.contents.searchBtnFontSize
                        el.style.borderWidth = this.contents.searchBtnBorderWidth
                        el.style.borderStyle = this.contents.searchBtnBorderStyle
                        el.style.borderColor = this.contents.searchBtnBorderColor
                        el.style.borderRadius = this.contents.searchBtnBorderRadius
                        el.style.backgroundColor = this.contents.searchBtnBgColor
                    })
                })
            },
            // 新增、批量删除
            contentBtnAdAllStyleChange() {
                this.$nextTick(() => {
                    document.querySelectorAll('.form-content .ad .el-button--success').forEach(el => {
                        el.style.height = this.contents.btnAdAllHeight
                        el.style.color = this.contents.btnAdAllAddFontColor
                        el.style.fontSize = this.contents.btnAdAllFontSize
                        el.style.borderWidth = this.contents.btnAdAllBorderWidth
                        el.style.borderStyle = this.contents.btnAdAllBorderStyle
                        el.style.borderColor = this.contents.btnAdAllBorderColor
                        el.style.borderRadius = this.contents.btnAdAllBorderRadius
                        el.style.backgroundColor = this.contents.btnAdAllAddBgColor
                    })
                    document.querySelectorAll('.form-content .ad .el-button--danger').forEach(el => {
                        el.style.height = this.contents.btnAdAllHeight
                        el.style.color = this.contents.btnAdAllDelFontColor
                        el.style.fontSize = this.contents.btnAdAllFontSize
                        el.style.borderWidth = this.contents.btnAdAllBorderWidth
                        el.style.borderStyle = this.contents.btnAdAllBorderStyle
                        el.style.borderColor = this.contents.btnAdAllBorderColor
                        el.style.borderRadius = this.contents.btnAdAllBorderRadius
                        el.style.backgroundColor = this.contents.btnAdAllDelBgColor
                    })
                    document.querySelectorAll('.form-content .ad .el-button--warning').forEach(el => {
                        el.style.height = this.contents.btnAdAllHeight
                        el.style.color = this.contents.btnAdAllWarnFontColor
                        el.style.fontSize = this.contents.btnAdAllFontSize
                        el.style.borderWidth = this.contents.btnAdAllBorderWidth
                        el.style.borderStyle = this.contents.btnAdAllBorderStyle
                        el.style.borderColor = this.contents.btnAdAllBorderColor
                        el.style.borderRadius = this.contents.btnAdAllBorderRadius
                        el.style.backgroundColor = this.contents.btnAdAllWarnBgColor
                    })
                })
            },
            // 表格
            rowStyle({row, rowIndex}) {
                if (rowIndex % 2 == 1) {
                    if (this.contents.tableStripe) {
                        return {color: this.contents.tableStripeFontColor}
                    }
                } else {
                    return ''
                }
            },
            cellStyle({row, rowIndex}) {
                if (rowIndex % 2 == 1) {
                    if (this.contents.tableStripe) {
                        return {backgroundColor: this.contents.tableStripeBgColor}
                    }
                } else {
                    return ''
                }
            },
            headerRowStyle({row, rowIndex}) {
                return {color: this.contents.tableHeaderFontColor}
            },
            headerCellStyle({row, rowIndex}) {
                return {backgroundColor: this.contents.tableHeaderBgColor}
            },
            // 表格按钮
            contentTableBtnStyleChange() {
                // this.$nextTick(()=>{
                //   setTimeout(()=>{
                //     document.querySelectorAll('.table-content .tables .el-table__body .el-button--success').forEach(el=>{
                //       el.style.height = this.contents.tableBtnHeight
                //       el.style.color = this.contents.tableBtnDetailFontColor
                //       el.style.fontSize = this.contents.tableBtnFontSize
                //       el.style.borderWidth = this.contents.tableBtnBorderWidth
                //       el.style.borderStyle = this.contents.tableBtnBorderStyle
                //       el.style.borderColor = this.contents.tableBtnBorderColor
                //       el.style.borderRadius = this.contents.tableBtnBorderRadius
                //       el.style.backgroundColor = this.contents.tableBtnDetailBgColor
                //     })
                //     document.querySelectorAll('.table-content .tables .el-table__body .el-button--primary').forEach(el=>{
                //       el.style.height = this.contents.tableBtnHeight
                //       el.style.color = this.contents.tableBtnEditFontColor
                //       el.style.fontSize = this.contents.tableBtnFontSize
                //       el.style.borderWidth = this.contents.tableBtnBorderWidth
                //       el.style.borderStyle = this.contents.tableBtnBorderStyle
                //       el.style.borderColor = this.contents.tableBtnBorderColor
                //       el.style.borderRadius = this.contents.tableBtnBorderRadius
                //       el.style.backgroundColor = this.contents.tableBtnEditBgColor
                //     })
                //     document.querySelectorAll('.table-content .tables .el-table__body .el-button--danger').forEach(el=>{
                //       el.style.height = this.contents.tableBtnHeight
                //       el.style.color = this.contents.tableBtnDelFontColor
                //       el.style.fontSize = this.contents.tableBtnFontSize
                //       el.style.borderWidth = this.contents.tableBtnBorderWidth
                //       el.style.borderStyle = this.contents.tableBtnBorderStyle
                //       el.style.borderColor = this.contents.tableBtnBorderColor
                //       el.style.borderRadius = this.contents.tableBtnBorderRadius
                //       el.style.backgroundColor = this.contents.tableBtnDelBgColor
                //     })

                //   }, 50)
                // })
            },
            // 分页
            contentPageStyleChange() {
                let arr = []
                if (this.contents.pageTotal) arr.push('total')
                if (this.contents.pageSizes) arr.push('sizes')
                if (this.contents.pagePrevNext) {
                    arr.push('prev')
                    if (this.contents.pagePager) arr.push('pager')
                    arr.push('next')
                }
                if (this.contents.pageJumper) arr.push('jumper')
                this.layouts = arr.join()
                this.contents.pageEachNum = 10
            },

            init() {
            },
            search() {
                this.pageIndex = 1;
                this.getDataList();
            },
            // 获取数据列表
            getDataList() {
                this.dataListLoading = true;
                let params = {
                    page: this.pageIndex,
                    limit: this.pageSize,
                    sort: 'id',
                }

                                         
                if (this.searchForm.xueshengName!= '' && this.searchForm.xueshengName!= undefined) {
                    params['xueshengName'] = '%' + this.searchForm.xueshengName + '%'
                }
                                                                                                                                     
                if (this.searchForm.shixiName!= '' && this.searchForm.shixiName!= undefined) {
                    params['shixiName'] = '%' + this.searchForm.shixiName + '%'
                }
         
                if (this.searchForm.shixiTypes!= '' && this.searchForm.shixiTypes!= undefined) {
                    params['shixiTypes'] = this.searchForm.shixiTypes
                }
         
                if (this.searchForm.shixiDanweimingcheng!= '' && this.searchForm.shixiDanweimingcheng!= undefined) {
                    params['shixiDanweimingcheng'] = '%' + this.searchForm.shixiDanweimingcheng + '%'
                }
         
                if (this.searchForm.hangyeTypes!= '' && this.searchForm.hangyeTypes!= undefined) {
                    params['hangyeTypes'] = this.searchForm.hangyeTypes
                }
         
                if (this.searchForm.suoshuleixingTypes!= '' && this.searchForm.suoshuleixingTypes!= undefined) {
                    params['suoshuleixingTypes'] = this.searchForm.suoshuleixingTypes
                }
                                                                                                                                 
                if (this.searchForm.shixiKaoyanxuexiao!= '' && this.searchForm.shixiKaoyanxuexiao!= undefined) {
                    params['shixiKaoyanxuexiao'] = '%' + this.searchForm.shixiKaoyanxuexiao + '%'
                }
                         
                if (this.searchForm.shixiKaogongdiqu!= '' && this.searchForm.shixiKaogongdiqu!= undefined) {
                    params['shixiKaogongdiqu'] = '%' + this.searchForm.shixiKaogongdiqu + '%'
                }
                                                                
                params['shixiDelete'] = 1// 逻辑删除字段 1 未删除 2 删除


                this.$http({
                    url: "shixi/page",
                    method: "get",
                    params: params
                }).then(({data}) => {
                    if(data && data.code === 0){
                        this.dataList = data.data.list;
                        this.totalPage = data.data.total;
                    }else{
                        this.dataList = [];
                        this.totalPage = 0;
                    }
                    this.dataListLoading = false;
                });

                //查询级联表搜索条件所有列表
                //查询当前表搜索条件所有列表
                //填充下拉框选项
                this.$http({
                    url: "dictionary/page?dicCode=shixi_types&page=1&limit=100",
                    method: "get",
                }).then(({data}) => {
                    if(data && data.code === 0){
                        this.shixiTypesSelectSearch = data.data.list;
                    }
                });
                //填充下拉框选项
                this.$http({
                    url: "dictionary/page?dicCode=hangye_types&page=1&limit=100",
                    method: "get",
                }).then(({data}) => {
                    if(data && data.code === 0){
                        this.hangyeTypesSelectSearch = data.data.list;
                    }
                });
                //填充下拉框选项
                this.$http({
                    url: "dictionary/page?dicCode=suoshuleixing_types&page=1&limit=100",
                    method: "get",
                }).then(({data}) => {
                    if(data && data.code === 0){
                        this.suoshuleixingTypesSelectSearch = data.data.list;
                    }
                });
            },
            //每页数
            sizeChangeHandle(val) {
                this.pageSize = val;
                this.pageIndex = 1;
                this.getDataList();
            },
            // 当前页
            currentChangeHandle(val) {
                this.pageIndex = val;
                this.getDataList();
            },
            // 多选
            selectionChangeHandler(val) {
                this.dataListSelections = val;
            },
            // 添加/修改
            addOrUpdateHandler(id, type) {
                this.showFlag = false;
                this.addOrUpdateFlag = true;
                this.crossAddOrUpdateFlag = false;
                if (type != 'info') {
                    type = 'else';
                }
                this.$nextTick(() => {
                    this.$refs.addOrUpdate.init(id, type);
                });
            },
            // 下载
            download(file) {
                window.open(" ${file} ")
            },
            // 弹出打印模态框
            dayinOpen(item) {
                let _this = this;
                _this.printVisiable = true;
                _this.printFrom=item;
            },
            // 打印内容
            printContent() {
                let _this = this;
                _this.$print(_this.$refs.printContent)
                _this.printVisiable = false;
            },
            // 删除
            deleteHandler(id) {
                var ids = id ? [Number(id)] : this.dataListSelections.map(item => {
                    return Number(item.id);
                });

                this.$confirm(`确定进行[${id ? "删除" : "批量删除"}]操作?`, "提示", {
                    confirmButtonText: "确定",
                    cancelButtonText: "取消",
                    type: "warning"
                }).then(() => {
                    this.$http({
                        url: "shixi/delete",
                        method: "post",
                        data: ids
                    }).then(({data}) => {
                        if(data && data.code === 0){
                            this.$message({
                                message: "操作成功",
                                type: "success",
                                duration: 1500,
                                onClose: () => {
                                    this.search();
                                }
                            });
                        }else{
                            this.$message.error(data.msg);
                        }
                    });
                });
            },
            // 导入功能上传文件成功后调用导入方法
            shixiUploadSuccess(data){
                let _this = this;
                _this.$http({
                    url: "shixi/batchInsert?fileName=" + data.file,
                    method: "get"
                }).then(({data}) => {
                    if(data && data.code === 0){
                        _this.$message({
                            message: "导入实习数据成功",
                            type: "success",
                            duration: 1500,
                            onClose: () => {
                                _this.search();
                            }
                        });
                    }else{
                        _this.$message.error(data.msg);
                    }
                });

            },
            // 导入功能上传文件失败后调用导入方法
            shixiUploadError(data){
                this.$message.error('上传失败');
            },
	
            //无用
            wuyong(id) {
                let _this = this;
                _this.$confirm(`确定    操作?`, "提示", {confirmButtonText: "确定",cancelButtonText: "取消",type: "warning"
                }).then(() => {
                    _this.$http({
                        url: "shixi/update",
                        method: "post",
                        data: {
                            id:id,
//                            shixiTypes:shixiTypes,
                        }
                    }).then(({data}) => {
                        if(data && data.code === 0){
                            _this.$message({message: "操作成功",type: "success",duration: 1500,onClose: () => {
                                _this.search();
                            }});
                        }else{
                            _this.$message.error(data.msg);
                        }
                    });
                });
            },
        }
    };
</script>
<style lang="scss" scoped>
.slt {
margin: 0 !important;
display: flex;
}

.ad {
margin: 0 !important;
display: flex;
}

.pages {
& /deep/ el-pagination__sizes{
& /deep/ el-input__inner {
height: 22px;
line-height: 22px;
}
}
}


.el-button+.el-button {
margin:0;
}

.tables {
& /deep/ .el-button--success {
height: 40px;
color: #fff;
font-size: 14px;
border-width: 1px;
border-style: solid;
border-color: #DCDFE6;
border-radius: 6px;
background-color:var(--publicMainColor);
}

& /deep/ .el-button--primary {
height: 40px;
color: #fff;
font-size: 14px;
border-width: 1px;
border-style: solid;
border-color: #DCDFE6;
border-radius: 6px;
background-color: var(--publicSubColor);
}

& /deep/ .el-button--danger {
height: 40px;
color: #fff;
font-size: 14px;
border-width: 1px;
border-style: solid;
border-color: #DCDFE6;
border-radius: 6px;
background-color: var(--publicMainColor);
}

& /deep/ .el-button {
margin: 4px;
}
}</style>


