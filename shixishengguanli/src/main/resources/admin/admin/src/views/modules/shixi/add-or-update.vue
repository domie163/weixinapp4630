<template>
    <div class="addEdit-block">
        <el-form
                class="detail-form-content"
                ref="ruleForm"
                :model="ruleForm"
                :rules="rules"
                label-width="auto"
                >
            <el-row>
                <el-col :span="12"  v-if="sessionTable !='xuesheng'">
                    <el-form-item class="select" v-if="type!='info'"  label="学生" prop="xueshengId">
                        <el-select v-model="ruleForm.xueshengId" :disabled="ro.xueshengId" filterable placeholder="请选择学生" @change="xueshengChange">
                            <el-option
                                    v-for="(item,index) in xueshengOptions"
                                    v-bind:key="item.id"
                                    :label="item.xueshengName"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>

                <el-col :span="12"  v-if="sessionTable !='xuesheng' ">
                    <el-form-item class="input" v-if="type!='info'"  label="学生姓名" prop="xueshengName">
                        <el-input v-model="xueshengForm.xueshengName"
                                  placeholder="学生姓名" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="学生姓名" prop="xueshengName">
                            <el-input v-model="ruleForm.xueshengName"
                                      placeholder="学生姓名" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='xuesheng' ">
                    <el-form-item class="input" v-if="type!='info'"  label="学生手机号" prop="xueshengPhone">
                        <el-input v-model="xueshengForm.xueshengPhone"
                                  placeholder="学生手机号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="学生手机号" prop="xueshengPhone">
                            <el-input v-model="ruleForm.xueshengPhone"
                                      placeholder="学生手机号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='xuesheng' ">
                    <el-form-item class="input" v-if="type!='info'"  label="学生身份证号" prop="xueshengIdNumber">
                        <el-input v-model="xueshengForm.xueshengIdNumber"
                                  placeholder="学生身份证号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="学生身份证号" prop="xueshengIdNumber">
                            <el-input v-model="ruleForm.xueshengIdNumber"
                                      placeholder="学生身份证号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12" v-if="sessionTable !='xuesheng' ">
                    <el-form-item class="upload" v-if="type!='info' && !ro.xueshengPhoto" label="学生头像" prop="xueshengPhoto">
                        <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (xueshengForm.xueshengPhoto || '').split(',')" :src="$base.url+item" width="100" height="100">
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.xueshengPhoto" label="学生头像" prop="xueshengPhoto">
                            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (ruleForm.xueshengPhoto || '').split(',')" :src="$base.url+item" width="100" height="100">
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='xuesheng' ">
                    <el-form-item class="input" v-if="type!='info'"  label="学生邮箱" prop="xueshengEmail">
                        <el-input v-model="xueshengForm.xueshengEmail"
                                  placeholder="学生邮箱" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="学生邮箱" prop="xueshengEmail">
                            <el-input v-model="ruleForm.xueshengEmail"
                                      placeholder="学生邮箱" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <input id="updateId" name="id" type="hidden">
            <input id="xueshengId" name="xueshengId" type="hidden">
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="实习编号" prop="shixiUuidNumber">
                       <el-input v-model="ruleForm.shixiUuidNumber"
                                 placeholder="实习编号" clearable  :readonly="ro.shixiUuidNumber"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="实习编号" prop="shixiUuidNumber">
                           <el-input v-model="ruleForm.shixiUuidNumber"
                                     placeholder="实习编号" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="实习名称" prop="shixiName">
                       <el-input v-model="ruleForm.shixiName"
                                 placeholder="实习名称" clearable  :readonly="ro.shixiName"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="实习名称" prop="shixiName">
                           <el-input v-model="ruleForm.shixiName"
                                     placeholder="实习名称" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
                <el-col :span="12">
                    <el-form-item class="select" v-if="type!='info'"  label="实习类型" prop="shixiTypes">
                        <el-select v-model="ruleForm.shixiTypes" :disabled="ro.shixiTypes" placeholder="请选择实习类型">
                            <el-option
                                v-for="(item,index) in shixiTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="实习类型" prop="shixiValue">
                        <el-input v-model="ruleForm.shixiValue"
                            placeholder="实习类型" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="实习单位" prop="shixiDanweimingcheng">
                       <el-input v-model="ruleForm.shixiDanweimingcheng"
                                 placeholder="实习单位" clearable  :readonly="ro.shixiDanweimingcheng"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="实习单位" prop="shixiDanweimingcheng">
                           <el-input v-model="ruleForm.shixiDanweimingcheng"
                                     placeholder="实习单位" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
                <el-col :span="12">
                    <el-form-item class="select" v-if="type!='info'"  label="行业" prop="hangyeTypes">
                        <el-select v-model="ruleForm.hangyeTypes" :disabled="ro.hangyeTypes" placeholder="请选择行业">
                            <el-option
                                v-for="(item,index) in hangyeTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="行业" prop="hangyeValue">
                        <el-input v-model="ruleForm.hangyeValue"
                            placeholder="行业" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12">
                    <el-form-item class="select" v-if="type!='info'"  label="所属类型" prop="suoshuleixingTypes">
                        <el-select v-model="ruleForm.suoshuleixingTypes" :disabled="ro.suoshuleixingTypes" placeholder="请选择所属类型">
                            <el-option
                                v-for="(item,index) in suoshuleixingTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="所属类型" prop="suoshuleixingValue">
                        <el-input v-model="ruleForm.suoshuleixingValue"
                            placeholder="所属类型" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="企业规模" prop="qiyeGuimo">
                       <el-input v-model="ruleForm.qiyeGuimo"
                                 placeholder="企业规模" clearable  :readonly="ro.qiyeGuimo"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="企业规模" prop="qiyeGuimo">
                           <el-input v-model="ruleForm.qiyeGuimo"
                                     placeholder="企业规模" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="单位地址" prop="shixiDanweidizhi">
                       <el-input v-model="ruleForm.shixiDanweidizhi"
                                 placeholder="单位地址" clearable  :readonly="ro.shixiDanweidizhi"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="单位地址" prop="shixiDanweidizhi">
                           <el-input v-model="ruleForm.shixiDanweidizhi"
                                     placeholder="单位地址" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
                <el-col :span="12">
                    <el-form-item v-if="type!='info'"  class="input" label="进入时间" prop="jinruTime">
                        <el-date-picker
                                value-format="yyyy-MM-dd HH:mm:ss"
                                v-model="ruleForm.jinruTime"
                                type="datetime"
                                placeholder="进入时间"
                                :disabled="ro.jinruTime">
                        </el-date-picker>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.jinruTime" label="进入时间" prop="jinruTime">
                            <span v-html="ruleForm.jinruTime"></span>
                        </el-form-item>
                    </div>
                </el-col>

               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="实习岗位" prop="shixiGangwei">
                       <el-input v-model="ruleForm.shixiGangwei"
                                 placeholder="实习岗位" clearable  :readonly="ro.shixiGangwei"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="实习岗位" prop="shixiGangwei">
                           <el-input v-model="ruleForm.shixiGangwei"
                                     placeholder="实习岗位" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="岗位培养方向" prop="shixiGangweiFangxiang">
                       <el-input v-model="ruleForm.shixiGangweiFangxiang"
                                 placeholder="岗位培养方向" clearable  :readonly="ro.shixiGangweiFangxiang"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="岗位培养方向" prop="shixiGangweiFangxiang">
                           <el-input v-model="ruleForm.shixiGangweiFangxiang"
                                     placeholder="岗位培养方向" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
                <el-col :span="12">
                    <el-form-item class="select" v-if="type!='info'"  label="是否安排带教" prop="daijiaoTypes">
                        <el-select v-model="ruleForm.daijiaoTypes" :disabled="ro.daijiaoTypes" placeholder="请选择是否安排带教">
                            <el-option
                                v-for="(item,index) in daijiaoTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="是否安排带教" prop="daijiaoValue">
                        <el-input v-model="ruleForm.daijiaoValue"
                            placeholder="是否安排带教" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12">
                    <el-form-item class="select" v-if="type!='info'"  label="补助" prop="buzhuTypes">
                        <el-select v-model="ruleForm.buzhuTypes" :disabled="ro.buzhuTypes" placeholder="请选择补助">
                            <el-option
                                v-for="(item,index) in buzhuTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="补助" prop="buzhuValue">
                        <el-input v-model="ruleForm.buzhuValue"
                            placeholder="补助" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12">
                    <el-form-item class="select" v-if="type!='info'"  label="包宿" prop="susheTypes">
                        <el-select v-model="ruleForm.susheTypes" :disabled="ro.susheTypes" placeholder="请选择包宿">
                            <el-option
                                v-for="(item,index) in susheTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="包宿" prop="susheValue">
                        <el-input v-model="ruleForm.susheValue"
                            placeholder="包宿" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="薪资" prop="xinzi">
                       <el-input v-model="ruleForm.xinzi"
                                 placeholder="薪资" clearable  :readonly="ro.xinzi"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="薪资" prop="xinzi">
                           <el-input v-model="ruleForm.xinzi"
                                     placeholder="薪资" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="现住地址" prop="xianzhuAddress">
                       <el-input v-model="ruleForm.xianzhuAddress"
                                 placeholder="现住地址" clearable  :readonly="ro.xianzhuAddress"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="现住地址" prop="xianzhuAddress">
                           <el-input v-model="ruleForm.xianzhuAddress"
                                     placeholder="现住地址" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
                <el-col :span="24">
                    <el-form-item v-if="type!='info'"  label="同公司校友情况" prop="tonggongsixiaoyouContent">
                        <editor style="min-width: 200px; max-width: 600px;"
                                v-model="ruleForm.tonggongsixiaoyouContent"
                                class="editor"
                                action="file/upload">
                        </editor>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.tonggongsixiaoyouContent" label="同公司校友情况" prop="tonggongsixiaoyouContent">
                            <span v-html="ruleForm.tonggongsixiaoyouContent"></span>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12">
                    <el-form-item class="select" v-if="type!='info'"  label="是否招聘" prop="zhaopinShifouTypes">
                        <el-select v-model="ruleForm.zhaopinShifouTypes" :disabled="ro.zhaopinShifouTypes" placeholder="请选择是否招聘">
                            <el-option
                                v-for="(item,index) in zhaopinShifouTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="是否招聘" prop="zhaopinShifouValue">
                        <el-input v-model="ruleForm.zhaopinShifouValue"
                            placeholder="是否招聘" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="24">
                    <el-form-item v-if="type!='info'"  label="单位专业评价" prop="danweizhuanyeContent">
                        <editor style="min-width: 200px; max-width: 600px;"
                                v-model="ruleForm.danweizhuanyeContent"
                                class="editor"
                                action="file/upload">
                        </editor>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.danweizhuanyeContent" label="单位专业评价" prop="danweizhuanyeContent">
                            <span v-html="ruleForm.danweizhuanyeContent"></span>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="24">
                    <el-form-item v-if="type!='info'"  label="单位人事评价" prop="danweirenshiContent">
                        <editor style="min-width: 200px; max-width: 600px;"
                                v-model="ruleForm.danweirenshiContent"
                                class="editor"
                                action="file/upload">
                        </editor>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.danweirenshiContent" label="单位人事评价" prop="danweirenshiContent">
                            <span v-html="ruleForm.danweirenshiContent"></span>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12">
                    <el-form-item class="select" v-if="type!='info'"  label="单位满意状态" prop="manyiTypes">
                        <el-select v-model="ruleForm.manyiTypes" :disabled="ro.manyiTypes" placeholder="请选择单位满意状态">
                            <el-option
                                v-for="(item,index) in manyiTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="单位满意状态" prop="manyiValue">
                        <el-input v-model="ruleForm.manyiValue"
                            placeholder="单位满意状态" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="考研学校" prop="shixiKaoyanxuexiao">
                       <el-input v-model="ruleForm.shixiKaoyanxuexiao"
                                 placeholder="考研学校" clearable  :readonly="ro.shixiKaoyanxuexiao"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="考研学校" prop="shixiKaoyanxuexiao">
                           <el-input v-model="ruleForm.shixiKaoyanxuexiao"
                                     placeholder="考研学校" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
                <el-col :span="12">
                    <el-form-item class="select" v-if="type!='info'"  label="考研专业" prop="kaoyanzhuanyeTypes">
                        <el-select v-model="ruleForm.kaoyanzhuanyeTypes" :disabled="ro.kaoyanzhuanyeTypes" placeholder="请选择考研专业">
                            <el-option
                                v-for="(item,index) in kaoyanzhuanyeTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="考研专业" prop="kaoyanzhuanyeValue">
                        <el-input v-model="ruleForm.kaoyanzhuanyeValue"
                            placeholder="考研专业" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="方向" prop="shixiKaoyanfangxiang">
                       <el-input v-model="ruleForm.shixiKaoyanfangxiang"
                                 placeholder="方向" clearable  :readonly="ro.shixiKaoyanfangxiang"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="方向" prop="shixiKaoyanfangxiang">
                           <el-input v-model="ruleForm.shixiKaoyanfangxiang"
                                     placeholder="方向" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="考公地区" prop="shixiKaogongdiqu">
                       <el-input v-model="ruleForm.shixiKaogongdiqu"
                                 placeholder="考公地区" clearable  :readonly="ro.shixiKaogongdiqu"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="考公地区" prop="shixiKaogongdiqu">
                           <el-input v-model="ruleForm.shixiKaogongdiqu"
                                     placeholder="考公地区" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="职位" prop="shixiKaogongzhiwei">
                       <el-input v-model="ruleForm.shixiKaogongzhiwei"
                                 placeholder="职位" clearable  :readonly="ro.shixiKaogongzhiwei"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="职位" prop="shixiKaogongzhiwei">
                           <el-input v-model="ruleForm.shixiKaogongzhiwei"
                                     placeholder="职位" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
                <el-col :span="12">
                    <el-form-item v-if="type!='info'"  class="input" label="考公时间" prop="kaogongTime">
                        <el-date-picker
                                value-format="yyyy-MM-dd HH:mm:ss"
                                v-model="ruleForm.kaogongTime"
                                type="datetime"
                                placeholder="考公时间"
                                :disabled="ro.kaogongTime">
                        </el-date-picker>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.kaogongTime" label="考公时间" prop="kaogongTime">
                            <span v-html="ruleForm.kaogongTime"></span>
                        </el-form-item>
                    </div>
                </el-col>

               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="留学国家" prop="shixiLiuxue">
                       <el-input v-model="ruleForm.shixiLiuxue"
                                 placeholder="留学国家" clearable  :readonly="ro.shixiLiuxue"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="留学国家" prop="shixiLiuxue">
                           <el-input v-model="ruleForm.shixiLiuxue"
                                     placeholder="留学国家" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="留学大学" prop="shixiLiuxueDaxue">
                       <el-input v-model="ruleForm.shixiLiuxueDaxue"
                                 placeholder="留学大学" clearable  :readonly="ro.shixiLiuxueDaxue"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="留学大学" prop="shixiLiuxueDaxue">
                           <el-input v-model="ruleForm.shixiLiuxueDaxue"
                                     placeholder="留学大学" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="留学单位" prop="shixiLiuxueDanwei">
                       <el-input v-model="ruleForm.shixiLiuxueDanwei"
                                 placeholder="留学单位" clearable  :readonly="ro.shixiLiuxueDanwei"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="留学单位" prop="shixiLiuxueDanwei">
                           <el-input v-model="ruleForm.shixiLiuxueDanwei"
                                     placeholder="留学单位" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
                <el-col :span="24">
                    <el-form-item v-if="type!='info'"  label="备注" prop="shixiContent">
                        <editor style="min-width: 200px; max-width: 600px;"
                                v-model="ruleForm.shixiContent"
                                class="editor"
                                action="file/upload">
                        </editor>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.shixiContent" label="备注" prop="shixiContent">
                            <span v-html="ruleForm.shixiContent"></span>
                        </el-form-item>
                    </div>
                </el-col>
            </el-row>
            <el-form-item class="btn">
                <el-button v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
                <el-button v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
                <el-button v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>
<script>
    import styleJs from "../../../utils/style.js";
    // 数字，邮件，手机，url，身份证校验
    import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
    import utilsJs, {getYearFormat,getMonthFormat,getDateFormat,getDatetimeFormat} from "../../../utils/utils.js";
    export default {
        data() {
            return {
                addEditForm:null,
                id: '',
                type: '',
                sessionTable : "",//登录账户所在表名
                role : "",//权限
                userId:"",//当前登录人的id
                xueshengForm: {},
                ro:{
                    xueshengId: false,
                    shixiUuidNumber: false,
                    shixiName: false,
                    shixiTypes: false,
                    shixiDanweimingcheng: false,
                    hangyeTypes: false,
                    suoshuleixingTypes: false,
                    qiyeGuimo: false,
                    shixiDanweidizhi: false,
                    jinruTime: false,
                    shixiGangwei: false,
                    shixiGangweiFangxiang: false,
                    daijiaoTypes: false,
                    buzhuTypes: false,
                    susheTypes: false,
                    xinzi: false,
                    xianzhuAddress: false,
                    tonggongsixiaoyouContent: false,
                    zhaopinShifouTypes: false,
                    danweizhuanyeContent: false,
                    danweirenshiContent: false,
                    manyiTypes: false,
                    shixiKaoyanxuexiao: false,
                    kaoyanzhuanyeTypes: false,
                    shixiKaoyanfangxiang: false,
                    shixiKaogongdiqu: false,
                    shixiKaogongzhiwei: false,
                    kaogongTime: false,
                    shixiLiuxue: false,
                    shixiLiuxueDaxue: false,
                    shixiLiuxueDanwei: false,
                    shixiContent: false,
                    insertTime: false,
                },
                ruleForm: {
                    xueshengId: '',
                    shixiUuidNumber: new Date().getTime(),
                    shixiName: '',
                    shixiTypes: '',
                    shixiDanweimingcheng: '',
                    hangyeTypes: '',
                    suoshuleixingTypes: '',
                    qiyeGuimo: '',
                    shixiDanweidizhi: '',
                    jinruTime: '',
                    shixiGangwei: '',
                    shixiGangweiFangxiang: '',
                    daijiaoTypes: '',
                    buzhuTypes: '',
                    susheTypes: '',
                    xinzi: '',
                    xianzhuAddress: '',
                    tonggongsixiaoyouContent: '',
                    zhaopinShifouTypes: '',
                    danweizhuanyeContent: '',
                    danweirenshiContent: '',
                    manyiTypes: '',
                    shixiKaoyanxuexiao: '',
                    kaoyanzhuanyeTypes: '',
                    shixiKaoyanfangxiang: '',
                    shixiKaogongdiqu: '',
                    shixiKaogongzhiwei: '',
                    kaogongTime: '',
                    shixiLiuxue: '',
                    shixiLiuxueDaxue: '',
                    shixiLiuxueDanwei: '',
                    shixiContent: '',
                    insertTime: '',
                },
                shixiTypesOptions : [],
                hangyeTypesOptions : [],
                suoshuleixingTypesOptions : [],
                daijiaoTypesOptions : [],
                buzhuTypesOptions : [],
                susheTypesOptions : [],
                zhaopinShifouTypesOptions : [],
                manyiTypesOptions : [],
                kaoyanzhuanyeTypesOptions : [],
                xueshengOptions : [],
                rules: {
                   xueshengId: [
                              { required: true, message: '学生不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   shixiUuidNumber: [
                              { required: true, message: '实习编号不能为空', trigger: 'blur' },
                          ],
                   shixiName: [
                              { required: true, message: '实习名称不能为空', trigger: 'blur' },
                          ],
                   shixiTypes: [
                              { required: true, message: '实习类型不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   shixiDanweimingcheng: [
                              { required: true, message: '实习单位不能为空', trigger: 'blur' },
                          ],
                   hangyeTypes: [
                              { required: true, message: '行业不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   suoshuleixingTypes: [
                              { required: true, message: '所属类型不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   qiyeGuimo: [
                              { required: true, message: '企业规模不能为空', trigger: 'blur' },
                          ],
                   shixiDanweidizhi: [
                              { required: true, message: '单位地址不能为空', trigger: 'blur' },
                          ],
                   jinruTime: [
                              { required: true, message: '进入时间不能为空', trigger: 'blur' },
                          ],
                   shixiGangwei: [
                              { required: true, message: '实习岗位不能为空', trigger: 'blur' },
                          ],
                   shixiGangweiFangxiang: [
                              { required: true, message: '岗位培养方向不能为空', trigger: 'blur' },
                          ],
                   daijiaoTypes: [
                              { required: true, message: '是否安排带教不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   buzhuTypes: [
                              { required: true, message: '补助不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   susheTypes: [
                              { required: true, message: '包宿不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   xinzi: [
                              { required: true, message: '薪资不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]{0,6}(\.[0-9]{1,2})?$/,
                                  message: '只允许输入整数6位,小数2位的数字',
                                  trigger: 'blur'
                              }
                          ],
                   xianzhuAddress: [
                              { required: true, message: '现住地址不能为空', trigger: 'blur' },
                          ],
                   tonggongsixiaoyouContent: [
                              { required: true, message: '同公司校友情况不能为空', trigger: 'blur' },
                          ],
                   zhaopinShifouTypes: [
                              { required: true, message: '是否招聘不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   danweizhuanyeContent: [
                              { required: true, message: '单位专业评价不能为空', trigger: 'blur' },
                          ],
                   danweirenshiContent: [
                              { required: true, message: '单位人事评价不能为空', trigger: 'blur' },
                          ],
                   manyiTypes: [
                              { required: true, message: '单位满意状态不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   shixiKaoyanxuexiao: [
                              { required: true, message: '考研学校不能为空', trigger: 'blur' },
                          ],
                   kaoyanzhuanyeTypes: [
                              { required: true, message: '考研专业不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   shixiKaoyanfangxiang: [
                              { required: true, message: '方向不能为空', trigger: 'blur' },
                          ],
                   shixiKaogongdiqu: [
                              { required: true, message: '考公地区不能为空', trigger: 'blur' },
                          ],
                   shixiKaogongzhiwei: [
                              { required: true, message: '职位不能为空', trigger: 'blur' },
                          ],
                   kaogongTime: [
                              { required: true, message: '考公时间不能为空', trigger: 'blur' },
                          ],
                   shixiLiuxue: [
                              { required: true, message: '留学国家不能为空', trigger: 'blur' },
                          ],
                   shixiLiuxueDaxue: [
                              { required: true, message: '留学大学不能为空', trigger: 'blur' },
                          ],
                   shixiLiuxueDanwei: [
                              { required: true, message: '留学单位不能为空', trigger: 'blur' },
                          ],
                   shixiContent: [
                              { required: true, message: '备注不能为空', trigger: 'blur' },
                          ],
                   insertTime: [
                              { required: true, message: '录入时间不能为空', trigger: 'blur' },
                          ],
                }
            };
        },
        props: ["parent"],
        computed: {
        },
        created() {
            //获取当前登录用户的信息
            this.sessionTable = this.$storage.get("sessionTable");
            this.role = this.$storage.get("role");
            this.userId = this.$storage.get("userId");


            if (this.role != "管理员"){
            }
            this.addEditForm = styleJs.addStyle();
            this.addEditStyleChange()
            this.addEditUploadStyleChange()
            //获取下拉框信息
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=shixi_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.shixiTypesOptions = data.data.list;
                    }
                });
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=hangye_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.hangyeTypesOptions = data.data.list;
                    }
                });
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=suoshuleixing_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.suoshuleixingTypesOptions = data.data.list;
                    }
                });
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=daijiao_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.daijiaoTypesOptions = data.data.list;
                    }
                });
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=buzhu_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.buzhuTypesOptions = data.data.list;
                    }
                });
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=sushe_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.susheTypesOptions = data.data.list;
                    }
                });
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=zhaopin_shifou_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.zhaopinShifouTypesOptions = data.data.list;
                    }
                });
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=manyi_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.manyiTypesOptions = data.data.list;
                    }
                });
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=kaoyanzhuanye_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.kaoyanzhuanyeTypesOptions = data.data.list;
                    }
                });

         this.$http({
             url: `xuesheng/page?page=1&limit=100`,
             method: "get"
         }).then(({ data }) => {
             if (data && data.code === 0) {
                this.xueshengOptions = data.data.list;
            }
         });

        },
        mounted() {
        },
        methods: {
            // 下载
            download(file){
                window.open(`${file}`)
            },
            // 初始化
            init(id,type) {
                if (id) {
                    this.id = id;
                    this.type = type;
                }
                if(this.type=='info'||this.type=='else'){
                    this.info(id);
                }
                // 获取用户信息
                this.$http({
                    url:`${this.$storage.get("sessionTable")}/session`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        var json = data.data;
                    } else {
                        this.$message.error(data.msg);
                    }
                });
            },
            xueshengChange(id){
                this.$http({
                    url: `xuesheng/info/`+id,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.xueshengForm = data.data;
                    }
                });
            },
            // 多级联动参数
            info(id) {
                let _this =this;
                _this.$http({
                    url: `shixi/info/${id}`,
                    method: 'get'
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        _this.ruleForm = data.data;
                        _this.xueshengChange(data.data.xueshengId)
                        _this.ruleForm.tonggongsixiaoyouContent = _this.ruleForm.tonggongsixiaoyouContent.replaceAll("src=\"upload/","src=\""+this.$base.url+"upload/");
                        _this.ruleForm.danweizhuanyeContent = _this.ruleForm.danweizhuanyeContent.replaceAll("src=\"upload/","src=\""+this.$base.url+"upload/");
                        _this.ruleForm.danweirenshiContent = _this.ruleForm.danweirenshiContent.replaceAll("src=\"upload/","src=\""+this.$base.url+"upload/");
                        _this.ruleForm.shixiContent = _this.ruleForm.shixiContent.replaceAll("src=\"upload/","src=\""+this.$base.url+"upload/");
                    } else {
                        _this.$message.error(data.msg);
                    }
                });
            },
            // 提交
            onSubmit() {
                this.$refs["ruleForm"].validate(valid => {
                    if (valid) {
                        this.ruleForm.tonggongsixiaoyouContent = this.ruleForm.tonggongsixiaoyouContent.replaceAll(this.$base.url,"");
                        this.ruleForm.danweizhuanyeContent = this.ruleForm.danweizhuanyeContent.replaceAll(this.$base.url,"");
                        this.ruleForm.danweirenshiContent = this.ruleForm.danweirenshiContent.replaceAll(this.$base.url,"");
                        this.ruleForm.shixiContent = this.ruleForm.shixiContent.replaceAll(this.$base.url,"");
                        this.$http({
                            url:`shixi/${!this.ruleForm.id ? "save" : "update"}`,
                            method: "post",
                            data: this.ruleForm
                        }).then(({ data }) => {
                            if (data && data.code === 0) {
                                this.$message({
                                    message: "操作成功",
                                    type: "success",
                                    duration: 1500,
                                    onClose: () => {
                                        this.parent.showFlag = true;
                                        this.parent.addOrUpdateFlag = false;
                                        this.parent.shixiCrossAddOrUpdateFlag = false;
                                        this.parent.search();
                                        this.parent.contentStyleChange();
                                    }
                                });
                            } else {
                                this.$message.error(data.msg);
                            }
                        });
                    }
                });
            },
            // 获取uuid
            getUUID () {
                return new Date().getTime();
            },
            // 返回
            back() {
                this.parent.showFlag = true;
                this.parent.addOrUpdateFlag = false;
                this.parent.shixiCrossAddOrUpdateFlag = false;
                this.parent.contentStyleChange();
            },
            //图片

            addEditStyleChange() {
                this.$nextTick(()=>{
                    // input
                    document.querySelectorAll('.addEdit-block .input .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.inputHeight
                        el.style.color = this.addEditForm.inputFontColor
                        el.style.fontSize = this.addEditForm.inputFontSize
                        el.style.borderWidth = this.addEditForm.inputBorderWidth
                        el.style.borderStyle = this.addEditForm.inputBorderStyle
                        el.style.borderColor = this.addEditForm.inputBorderColor
                        el.style.borderRadius = this.addEditForm.inputBorderRadius
                        el.style.backgroundColor = this.addEditForm.inputBgColor
                    })
                    document.querySelectorAll('.addEdit-block .input .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.inputHeight
                        el.style.color = this.addEditForm.inputLableColor
                        el.style.fontSize = this.addEditForm.inputLableFontSize
                    })
                    // select
                    document.querySelectorAll('.addEdit-block .select .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.selectHeight
                        el.style.color = this.addEditForm.selectFontColor
                        el.style.fontSize = this.addEditForm.selectFontSize
                        el.style.borderWidth = this.addEditForm.selectBorderWidth
                        el.style.borderStyle = this.addEditForm.selectBorderStyle
                        el.style.borderColor = this.addEditForm.selectBorderColor
                        el.style.borderRadius = this.addEditForm.selectBorderRadius
                        el.style.backgroundColor = this.addEditForm.selectBgColor
                    })
                    document.querySelectorAll('.addEdit-block .select .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.selectHeight
                        el.style.color = this.addEditForm.selectLableColor
                        el.style.fontSize = this.addEditForm.selectLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .select .el-select__caret').forEach(el=>{
                        el.style.color = this.addEditForm.selectIconFontColor
                        el.style.fontSize = this.addEditForm.selectIconFontSize
                    })
                    // date
                    document.querySelectorAll('.addEdit-block .date .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.dateHeight
                        el.style.color = this.addEditForm.dateFontColor
                        el.style.fontSize = this.addEditForm.dateFontSize
                        el.style.borderWidth = this.addEditForm.dateBorderWidth
                        el.style.borderStyle = this.addEditForm.dateBorderStyle
                        el.style.borderColor = this.addEditForm.dateBorderColor
                        el.style.borderRadius = this.addEditForm.dateBorderRadius
                        el.style.backgroundColor = this.addEditForm.dateBgColor
                    })
                    document.querySelectorAll('.addEdit-block .date .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.dateHeight
                        el.style.color = this.addEditForm.dateLableColor
                        el.style.fontSize = this.addEditForm.dateLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .date .el-input__icon').forEach(el=>{
                        el.style.color = this.addEditForm.dateIconFontColor
                        el.style.fontSize = this.addEditForm.dateIconFontSize
                        el.style.lineHeight = this.addEditForm.dateHeight
                    })
                    // upload
                    let iconLineHeight = parseInt(this.addEditForm.uploadHeight) - parseInt(this.addEditForm.uploadBorderWidth) * 2 + 'px'
                    document.querySelectorAll('.addEdit-block .upload .el-upload--picture-card').forEach(el=>{
                        el.style.width = this.addEditForm.uploadHeight
                        el.style.height = this.addEditForm.uploadHeight
                        el.style.borderWidth = this.addEditForm.uploadBorderWidth
                        el.style.borderStyle = this.addEditForm.uploadBorderStyle
                        el.style.borderColor = this.addEditForm.uploadBorderColor
                        el.style.borderRadius = this.addEditForm.uploadBorderRadius
                        el.style.backgroundColor = this.addEditForm.uploadBgColor
                    })
                    document.querySelectorAll('.addEdit-block .upload .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.uploadHeight
                        el.style.color = this.addEditForm.uploadLableColor
                        el.style.fontSize = this.addEditForm.uploadLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .upload .el-icon-plus').forEach(el=>{
                        el.style.color = this.addEditForm.uploadIconFontColor
                        el.style.fontSize = this.addEditForm.uploadIconFontSize
                        el.style.lineHeight = iconLineHeight
                        el.style.display = 'block'
                    })
                    // 多文本输入框
                    document.querySelectorAll('.addEdit-block .textarea .el-textarea__inner').forEach(el=>{
                        el.style.height = this.addEditForm.textareaHeight
                        el.style.color = this.addEditForm.textareaFontColor
                        el.style.fontSize = this.addEditForm.textareaFontSize
                        el.style.borderWidth = this.addEditForm.textareaBorderWidth
                        el.style.borderStyle = this.addEditForm.textareaBorderStyle
                        el.style.borderColor = this.addEditForm.textareaBorderColor
                        el.style.borderRadius = this.addEditForm.textareaBorderRadius
                        el.style.backgroundColor = this.addEditForm.textareaBgColor
                    })
                    document.querySelectorAll('.addEdit-block .textarea .el-form-item__label').forEach(el=>{
                        // el.style.lineHeight = this.addEditForm.textareaHeight
                        el.style.color = this.addEditForm.textareaLableColor
                        el.style.fontSize = this.addEditForm.textareaLableFontSize
                    })
                    // 保存
                    document.querySelectorAll('.addEdit-block .btn .btn-success').forEach(el=>{
                        el.style.width = this.addEditForm.btnSaveWidth
                        el.style.height = this.addEditForm.btnSaveHeight
                        el.style.color = this.addEditForm.btnSaveFontColor
                        el.style.fontSize = this.addEditForm.btnSaveFontSize
                        el.style.borderWidth = this.addEditForm.btnSaveBorderWidth
                        el.style.borderStyle = this.addEditForm.btnSaveBorderStyle
                        el.style.borderColor = this.addEditForm.btnSaveBorderColor
                        el.style.borderRadius = this.addEditForm.btnSaveBorderRadius
                        el.style.backgroundColor = this.addEditForm.btnSaveBgColor
                    })
                    // 返回
                    document.querySelectorAll('.addEdit-block .btn .btn-close').forEach(el=>{
                        el.style.width = this.addEditForm.btnCancelWidth
                        el.style.height = this.addEditForm.btnCancelHeight
                        el.style.color = this.addEditForm.btnCancelFontColor
                        el.style.fontSize = this.addEditForm.btnCancelFontSize
                        el.style.borderWidth = this.addEditForm.btnCancelBorderWidth
                        el.style.borderStyle = this.addEditForm.btnCancelBorderStyle
                        el.style.borderColor = this.addEditForm.btnCancelBorderColor
                        el.style.borderRadius = this.addEditForm.btnCancelBorderRadius
                        el.style.backgroundColor = this.addEditForm.btnCancelBgColor
                    })
                })
            },
            addEditUploadStyleChange() {
                this.$nextTick(()=>{
                    document.querySelectorAll('.addEdit-block .upload .el-upload-list--picture-card .el-upload-list__item').forEach(el=>{
                        el.style.width = this.addEditForm.uploadHeight
                        el.style.height = this.addEditForm.uploadHeight
                        el.style.borderWidth = this.addEditForm.uploadBorderWidth
                        el.style.borderStyle = this.addEditForm.uploadBorderStyle
                        el.style.borderColor = this.addEditForm.uploadBorderColor
                        el.style.borderRadius = this.addEditForm.uploadBorderRadius
                        el.style.backgroundColor = this.addEditForm.uploadBgColor
                    })
                })
            },
        }
    };
</script>
<style lang="scss">
.editor{
  height: 500px;

  & /deep/ .ql-container {
	  height: 310px;
  }
}
.amap-wrapper {
  width: 100%;
  height: 500px;
}
.search-box {
  position: absolute;
}
.addEdit-block {
	margin: -10px;
}
.detail-form-content {
	padding: 12px;
}
.btn .el-button {
  padding: 0;
}</style>

