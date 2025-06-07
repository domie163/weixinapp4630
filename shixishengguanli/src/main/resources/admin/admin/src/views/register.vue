<template>
    <div>
        <div class="container">
            <div class="login-form">
                <h1 class="h1" style="color:#000;fontSize:28px;">实习生管理系统注册</h1>
                <el-form class="rgs-form">
                    <el-form-item label="账号" class="input">
                        <el-input v-model="ruleForm.username" autocomplete="off" placeholder="账号"  />
                    </el-form-item>
                    <el-form-item label="密码" class="input">
                        <el-input type="password" v-model="ruleForm.password" autocomplete="off" show-password/>
                    </el-form-item>
                    <el-form-item label="重复密码" class="input">
                        <el-input type="passwo   rd" v-model="ruleForm.repetitionPassword" autocomplete="off" show-password/>
                    </el-form-item>
                        <el-form-item label="公司名称" class="input" v-if="tableName=='gongsi'">
                            <el-input v-model="ruleForm.gongsiName" autocomplete="off" placeholder="公司名称"  />
                        </el-form-item>
                        <!--
                            <el-form-item label="公司类型" class="input" v-if="tableName=='gongsi'">
                                <el-input v-model="ruleForm.gongsiTypes" autocomplete="off" placeholder="公司类型"  />
                           </el-form-item>
                        -->
                        <el-form-item label="联系方式" class="input" v-if="tableName=='gongsi'">
                            <el-input v-model="ruleForm.gongsiPhone" autocomplete="off" placeholder="联系方式"  />
                        </el-form-item>
                        <el-form-item label="邮箱" class="input" v-if="tableName=='gongsi'">
                            <el-input v-model="ruleForm.gongsiEmail" autocomplete="off" placeholder="邮箱"  />
                        </el-form-item>
                        <!--
                            <el-form-item v-if="gongsiPhotoFlag">
                            </el-form-item>
                            <el-form-item label="公司logo" class="input" v-if="tableName=='gongsi'">
                                    <file-upload
                                        tip="点击上传公司logo"
                                        action="file/upload"
                                        :limit="1"
                                        :multiple="true"
                                        :fileUrls="ruleForm.gongsiPhoto?$base.url+ruleForm.gongsiPhoto:''"
                                        @change="gongsiPhotoUploadChange"
                                    ></file-upload>
                           </el-form-item>
                        -->
                        <!--
                            <el-form-item label="公司成立时间" class="input" v-if="tableName=='gongsi'">
                                <el-input v-model="ruleForm.gongsiChenglishijianTime" autocomplete="off" placeholder="公司成立时间"  />
                           </el-form-item>
                        -->
                        <!--
                            <el-form-item label="公司介绍" class="input" v-if="tableName=='gongsi'">
                                <el-input type="textarea" v-model="ruleForm.gongsiContent" placeholder="公司介绍"></el-input>
                           </el-form-item>
                        -->
                        <!--
                            <el-form-item label="逻辑删除" class="input" v-if="tableName=='gongsi'">
                                <el-input v-model="ruleForm.gongsiDelete" autocomplete="off" placeholder="逻辑删除"  />
                           </el-form-item>
                        -->
                        <!--
                            <el-form-item label="创建时间 show1 show2 photoShow" class="input" v-if="tableName=='gongsi'">
                                <el-input v-model="ruleForm.createTime" autocomplete="off" placeholder="创建时间 show1 show2 photoShow"  />
                           </el-form-item>
                        -->
                        <el-form-item label="老师姓名" class="input" v-if="tableName=='laoshi'">
                            <el-input v-model="ruleForm.laoshiName" autocomplete="off" placeholder="老师姓名"  />
                        </el-form-item>
                        <el-form-item label="老师手机号" class="input" v-if="tableName=='laoshi'">
                            <el-input v-model="ruleForm.laoshiPhone" autocomplete="off" placeholder="老师手机号"  />
                        </el-form-item>
                        <el-form-item label="老师身份证号" class="input" v-if="tableName=='laoshi'">
                            <el-input v-model="ruleForm.laoshiIdNumber" autocomplete="off" placeholder="老师身份证号"  />
                        </el-form-item>
                        <!--
                            <el-form-item v-if="laoshiPhotoFlag">
                            </el-form-item>
                            <el-form-item label="老师头像" class="input" v-if="tableName=='laoshi'">
                                    <file-upload
                                        tip="点击上传老师头像"
                                        action="file/upload"
                                        :limit="1"
                                        :multiple="true"
                                        :fileUrls="ruleForm.laoshiPhoto?$base.url+ruleForm.laoshiPhoto:''"
                                        @change="laoshiPhotoUploadChange"
                                    ></file-upload>
                           </el-form-item>
                        -->
                        <el-form-item label="老师邮箱" class="input" v-if="tableName=='laoshi'">
                            <el-input v-model="ruleForm.laoshiEmail" autocomplete="off" placeholder="老师邮箱"  />
                        </el-form-item>
                        <!--
                            <el-form-item label="创建时间" class="input" v-if="tableName=='laoshi'">
                                <el-input v-model="ruleForm.createTime" autocomplete="off" placeholder="创建时间"  />
                           </el-form-item>
                        -->
                        <el-form-item label="学生姓名" class="input" v-if="tableName=='xuesheng'">
                            <el-input v-model="ruleForm.xueshengName" autocomplete="off" placeholder="学生姓名"  />
                        </el-form-item>
                        <el-form-item label="学生手机号" class="input" v-if="tableName=='xuesheng'">
                            <el-input v-model="ruleForm.xueshengPhone" autocomplete="off" placeholder="学生手机号"  />
                        </el-form-item>
                        <el-form-item label="学生身份证号" class="input" v-if="tableName=='xuesheng'">
                            <el-input v-model="ruleForm.xueshengIdNumber" autocomplete="off" placeholder="学生身份证号"  />
                        </el-form-item>
                        <!--
                            <el-form-item v-if="xueshengPhotoFlag">
                            </el-form-item>
                            <el-form-item label="学生头像" class="input" v-if="tableName=='xuesheng'">
                                    <file-upload
                                        tip="点击上传学生头像"
                                        action="file/upload"
                                        :limit="1"
                                        :multiple="true"
                                        :fileUrls="ruleForm.xueshengPhoto?$base.url+ruleForm.xueshengPhoto:''"
                                        @change="xueshengPhotoUploadChange"
                                    ></file-upload>
                           </el-form-item>
                        -->
                        <el-form-item label="学生邮箱" class="input" v-if="tableName=='xuesheng'">
                            <el-input v-model="ruleForm.xueshengEmail" autocomplete="off" placeholder="学生邮箱"  />
                        </el-form-item>
                        <!--
                            <el-form-item label="创建时间" class="input" v-if="tableName=='xuesheng'">
                                <el-input v-model="ruleForm.createTime" autocomplete="off" placeholder="创建时间"  />
                           </el-form-item>
                        -->
                    <div style="display: flex;flex-wrap: wrap;width: 100%;justify-content: center;">
                        <el-button class="btn" type="primary" @click="login()">注册</el-button>
                        <el-button class="btn close" type="primary" @click="close()">取消</el-button>
                    </div>
                </el-form>
            </div>
        </div>
    </div>
</template>
<script>
    export default {
        data() {
            return {
                ruleForm: {
                },
                tableName:"",
                rules: {},
                sexTypesOptions : [],
                gongsiPhotoFlag:false,//用于刷新文件上传
                laoshiPhotoFlag:false,//用于刷新文件上传
                xueshengPhotoFlag:false,//用于刷新文件上传
            };
        },
        mounted(){
            let table = this.$storage.get("loginTable");
            this.tableName = table;

            //级联表的下拉框查询

        },
        methods: {
            // 获取uuid
            getUUID () {
                return new Date().getTime();
            },
            gongsiPhotoUploadChange(fileUrls) {
               this.ruleForm.gongsiPhoto = fileUrls;
                if(this.gongsiPhotoFlag){
                    this.gongsiPhotoFlag=false;
                }else{
                    this.gongsiPhotoFlag=true;
                }
            },
            laoshiPhotoUploadChange(fileUrls) {
               this.ruleForm.laoshiPhoto = fileUrls;
                if(this.laoshiPhotoFlag){
                    this.laoshiPhotoFlag=false;
                }else{
                    this.laoshiPhotoFlag=true;
                }
            },
            xueshengPhotoUploadChange(fileUrls) {
               this.ruleForm.xueshengPhoto = fileUrls;
                if(this.xueshengPhotoFlag){
                    this.xueshengPhotoFlag=false;
                }else{
                    this.xueshengPhotoFlag=true;
                }
            },
            close(){
                this.$router.push({ path: "/login" });
            },
            // 注册
            login() {

                            if((!this.ruleForm.username)){
                                this.$message.error('账号不能为空');
                                return
                            }
                            if((!this.ruleForm.password)){
                                this.$message.error('密码不能为空');
                                return
                            }
                            if((!this.ruleForm.repetitionPassword)){
                                this.$message.error('重复密码不能为空');
                                return
                            }
                            if(this.ruleForm.repetitionPassword != this.ruleForm.password){
                                this.$message.error('密码和重复密码不一致');
                                return
                            }
                            if((!this.ruleForm.gongsiName)&& 'gongsi'==this.tableName){
                                this.$message.error('公司名称不能为空');
                                return
                            }
                            // gongsi 中的 公司类型 判空处理
                            // if('gongsi' == this.tableName && (this.ruleForm.gongsiTypes== null ||this.ruleForm.gongsiTypes== "")){
                            //     this.$message.error("公司类型不能为空");
                            //     return
                            // }
                             if('gongsi' == this.tableName && this.ruleForm.gongsiPhone&&(!this.$validate.isMobile(this.ruleForm.gongsiPhone))){
                                 this.$message.error('手机应输入手机格式');
                                 return
                             }
                            if('gongsi' == this.tableName && this.ruleForm.gongsiEmail&&(!this.$validate.isEmail(this.ruleForm.gongsiEmail))){
                                this.$message.error("邮箱应输入邮件格式");
                                return
                            }
                            // gongsi 中的 公司logo 判空处理
                            // if('gongsi' == this.tableName && (this.ruleForm.gongsiPhoto== null ||this.ruleForm.gongsiPhoto== "")){
                            //     this.$message.error("公司logo不能为空");
                            //     return
                            // }
                            // gongsi 中的 公司成立时间 判空处理
                            // if('gongsi' == this.tableName && (this.ruleForm.gongsiChenglishijianTime== null ||this.ruleForm.gongsiChenglishijianTime== "")){
                            //     this.$message.error("公司成立时间不能为空");
                            //     return
                            // }
                            // gongsi 中的 公司介绍 判空处理
                            // if('gongsi' == this.tableName && (this.ruleForm.gongsiContent== null ||this.ruleForm.gongsiContent== "")){
                            //     this.$message.error("公司介绍不能为空");
                            //     return
                            // }
                            // gongsi 中的 逻辑删除 判空处理
                            // if('gongsi' == this.tableName && (this.ruleForm.gongsiDelete== null ||this.ruleForm.gongsiDelete== "")){
                            //     this.$message.error("逻辑删除不能为空");
                            //     return
                            // }
                            // gongsi 中的 创建时间 show1 show2 photoShow 判空处理
                            // if('gongsi' == this.tableName && (this.ruleForm.createTime== null ||this.ruleForm.createTime== "")){
                            //     this.$message.error("创建时间 show1 show2 photoShow不能为空");
                            //     return
                            // }
                            if((!this.ruleForm.laoshiName)&& 'laoshi'==this.tableName){
                                this.$message.error('老师姓名不能为空');
                                return
                            }
                             if('laoshi' == this.tableName && this.ruleForm.laoshiPhone&&(!this.$validate.isMobile(this.ruleForm.laoshiPhone))){
                                 this.$message.error('手机应输入手机格式');
                                 return
                             }
                            if((!this.ruleForm.laoshiIdNumber)&& 'laoshi'==this.tableName){
                                this.$message.error('老师身份证号不能为空');
                                return
                            }
                            // laoshi 中的 老师头像 判空处理
                            // if('laoshi' == this.tableName && (this.ruleForm.laoshiPhoto== null ||this.ruleForm.laoshiPhoto== "")){
                            //     this.$message.error("老师头像不能为空");
                            //     return
                            // }
                            if('laoshi' == this.tableName && this.ruleForm.laoshiEmail&&(!this.$validate.isEmail(this.ruleForm.laoshiEmail))){
                                this.$message.error("邮箱应输入邮件格式");
                                return
                            }
                            // laoshi 中的 创建时间 判空处理
                            // if('laoshi' == this.tableName && (this.ruleForm.createTime== null ||this.ruleForm.createTime== "")){
                            //     this.$message.error("创建时间不能为空");
                            //     return
                            // }
                            if((!this.ruleForm.xueshengName)&& 'xuesheng'==this.tableName){
                                this.$message.error('学生姓名不能为空');
                                return
                            }
                             if('xuesheng' == this.tableName && this.ruleForm.xueshengPhone&&(!this.$validate.isMobile(this.ruleForm.xueshengPhone))){
                                 this.$message.error('手机应输入手机格式');
                                 return
                             }
                            if((!this.ruleForm.xueshengIdNumber)&& 'xuesheng'==this.tableName){
                                this.$message.error('学生身份证号不能为空');
                                return
                            }
                            // xuesheng 中的 学生头像 判空处理
                            // if('xuesheng' == this.tableName && (this.ruleForm.xueshengPhoto== null ||this.ruleForm.xueshengPhoto== "")){
                            //     this.$message.error("学生头像不能为空");
                            //     return
                            // }
                            if('xuesheng' == this.tableName && this.ruleForm.xueshengEmail&&(!this.$validate.isEmail(this.ruleForm.xueshengEmail))){
                                this.$message.error("邮箱应输入邮件格式");
                                return
                            }
                            // xuesheng 中的 创建时间 判空处理
                            // if('xuesheng' == this.tableName && (this.ruleForm.createTime== null ||this.ruleForm.createTime== "")){
                            //     this.$message.error("创建时间不能为空");
                            //     return
                            // }
                this.$http({
                    url: `${this.tableName}/register`,
                    method: "post",
                    data:this.ruleForm
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                    this.$message({
                        message: "注册成功,请登录后在个人中心页面补充个人数据",
                        type: "success",
                        duration: 1500,
                        onClose: () => {
                        this.$router.replace({ path: "/login" });
                }
                });
                } else {
                    this.$message.error(data.msg);
                }
            });
            }
        }
    };
</script>
<style lang="scss" scoped>
.el-radio__input.is-checked .el-radio__inner {
    border-color: #00c292;
    background: #00c292;
}

.el-radio__input.is-checked .el-radio__inner {
    border-color: #00c292;
    background: #00c292;
}

.el-radio__input.is-checked+.el-radio__label {
    color: #00c292;
}

.el-radio__input.is-checked+.el-radio__label {
    color: #00c292;
}

.el-radio__input.is-checked+.el-radio__label {
    color: #00c292;
}

.h1 {
    margin-top: 10px;
}

body {
    padding: 0;
    margin: 0;
}


.nk-navigation {
    margin-top: 15px;

a {
    display: inline-block;
    color: #fff;
    background: rgba(255, 255, 255, .2);
    width: 100px;
    height: 50px;
    border-radius: 30px;
    text-align: center;
    display: flex;
    align-items: center;
    margin: 0 auto;
    justify-content: center;
    padding: 0 20px;
}

.icon {
    margin-left: 10px;
    width: 30px;
    height: 30px;
}
}

.register-container {
    margin-top: 10px;

a {
    display: inline-block;
    color: #fff;
    max-width: 500px;
    height: 50px;
    border-radius: 30px;
    text-align: center;
    display: flex;
    align-items: center;
    margin: 0 auto;
    justify-content: center;
    padding: 0 20px;

div {
    margin-left: 10px;
}
}
}

.container {
    height: 100vh;
    background-position: center center;
    background-size: cover;
    background-repeat: no-repeat;
        background-image: url(/shixishengguanli/img/back-img-bg.jpg);

.login-form {
    right: 50%;
    top: 50%;
    height: auto;
    transform: translate3d(50%, -50%, 0);
    border-radius: 10px;
    background-color: rgba(255,255,255,.5);
    width: 420px;
    padding: 30px 30px 40px 30px;
    font-size: 14px;
    font-weight: 500;

.h1 {
    margin: 0;
    text-align: center;
    line-height: 54px;
    font-size: 24px;
    color: #000;
}

.rgs-form {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;

.input {
    width: 95%;

& /deep/ .el-form-item__label {
      line-height: 40px;
      color: rgba(17, 16, 16, 1);
      font-size: #606266;
  }

& /deep/ .el-input__inner {
      height: 40px;
      color: rgba(23, 24, 26, 1);
      font-size: 14px;
      border-width: 1px;
      border-style: solid;
      border-color: #606266;
      border-radius: 22px;
      background-color: #fff;
  }
}

.btn {
    margin: 0 10px;
    width: 88px;
    height: 44px;
    color: #fff;
    font-size: 14px;
    border-width: 1px;
    border-style: solid;
    border-color: #409EFF;
    border-radius: 22px;
    background-color: #409EFF;
}

.close {
    margin: 0 10px;
    width: 88px;
    height: 44px;
    color: #409EFF;
    font-size: 14px;
    border-width: 1px;
    border-style: solid;
    border-color: #409EFF;
    border-radius: 22px;
    background-color: #FFF;
}

}
}
}
</style>




