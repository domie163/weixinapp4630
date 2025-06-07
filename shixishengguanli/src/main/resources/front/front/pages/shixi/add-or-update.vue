<template>
    <view class="content">
        <form class="app-update-pv">
            <view
                    :style='{"boxShadow":"0","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(228, 232, 230, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"100rpx"}'
                    class="cu-form-group">
                <view :style='{"width":"160rpx","fontSize":"28rpx","color":"var(--publicMainColor)","textAlign":"left"}'
                      class="title">实习编号</view>
                <input   disabled
                         :style='{"padding":"0 30rpx","boxShadow":"0 0 0px rgba(0,0,0,.6) inset","backgroundColor":"rgba(255, 255, 255, 1)","borderColor":"var(--publicMainColor)","borderRadius":"16rpx","color":"var(--publicMainColor)","textAlign":"left","borderWidth":"2rpx","fontSize":"28rpx","borderStyle":"solid","height":"88rpx","marginTop":"7rpx"}'
                         :disabled="ro.shixiUuidNumber" type="text" v-model="ruleForm.shixiUuidNumber" placeholder="实习编号"></input>
            </view>
            <view
                    :style='{"boxShadow":"0","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(228, 232, 230, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"100rpx"}'
                    class="cu-form-group">
                <view :style='{"width":"160rpx","fontSize":"28rpx","color":"var(--publicMainColor)","textAlign":"left"}'
                      class="title">实习名称</view>
                <input   disabled
                         :style='{"padding":"0 30rpx","boxShadow":"0 0 0px rgba(0,0,0,.6) inset","backgroundColor":"rgba(255, 255, 255, 1)","borderColor":"var(--publicMainColor)","borderRadius":"16rpx","color":"var(--publicMainColor)","textAlign":"left","borderWidth":"2rpx","fontSize":"28rpx","borderStyle":"solid","height":"88rpx","marginTop":"7rpx"}'
                         :disabled="ro.shixiName" type="text" v-model="ruleForm.shixiName" placeholder="实习名称"></input>
            </view>
                <view :style='{"boxShadow":"0","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(228, 232, 230, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"100rpx"}'
                      class="cu-form-group">
                    <view :style='{"width":"160rpx","fontSize":"28rpx","color":"var(--publicMainColor)","textAlign":"left"}'
                          class="title">实习类型</view>
                    <picker @change="shixiTypesChange" :value="shixiTypesIndex" :range="shixiTypesOptions" range-key="indexName">
                        <view
                                :style='{"padding":"0 30rpx","boxShadow":"0 0 0px rgba(0,0,0,.6) inset","backgroundColor":"rgba(255, 255, 255, 1)","borderColor":"var(--publicMainColor)","borderRadius":"16rpx","color":"var(--publicMainColor)","textAlign":"left","borderWidth":"2rpx","fontSize":"28rpx","borderStyle":"solid","height":"88rpx","marginTop":"7rpx"}'
                                class="uni-input">{{ruleForm.shixiTypes?ruleForm.shixiValue:"请选择实习类型"}}</view>
                    </picker>
                </view>
				
				
				
				
				
<view v-if="ruleForm.shixiTypes==1"><!-- 实习flag -->
            <view
                    :style='{"boxShadow":"0","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(228, 232, 230, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"100rpx"}'
                    class="cu-form-group">
                <view :style='{"width":"160rpx","fontSize":"28rpx","color":"var(--publicMainColor)","textAlign":"left"}'
                      class="title">实习单位</view>
                <input   disabled
                         :style='{"padding":"0 30rpx","boxShadow":"0 0 0px rgba(0,0,0,.6) inset","backgroundColor":"rgba(255, 255, 255, 1)","borderColor":"var(--publicMainColor)","borderRadius":"16rpx","color":"var(--publicMainColor)","textAlign":"left","borderWidth":"2rpx","fontSize":"28rpx","borderStyle":"solid","height":"88rpx","marginTop":"7rpx"}'
                         :disabled="ro.shixiDanweimingcheng" type="text" v-model="ruleForm.shixiDanweimingcheng" placeholder="实习单位"></input>
            </view>
                <view :style='{"boxShadow":"0","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(228, 232, 230, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"100rpx"}'
                      class="cu-form-group">
                    <view :style='{"width":"160rpx","fontSize":"28rpx","color":"var(--publicMainColor)","textAlign":"left"}'
                          class="title">行业</view>
                    <picker @change="hangyeTypesChange" :value="hangyeTypesIndex" :range="hangyeTypesOptions" range-key="indexName">
                        <view
                                :style='{"padding":"0 30rpx","boxShadow":"0 0 0px rgba(0,0,0,.6) inset","backgroundColor":"rgba(255, 255, 255, 1)","borderColor":"var(--publicMainColor)","borderRadius":"16rpx","color":"var(--publicMainColor)","textAlign":"left","borderWidth":"2rpx","fontSize":"28rpx","borderStyle":"solid","height":"88rpx","marginTop":"7rpx"}'
                                class="uni-input">{{ruleForm.hangyeTypes?ruleForm.hangyeValue:"请选择行业"}}</view>
                    </picker>
                </view>
                <view :style='{"boxShadow":"0","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(228, 232, 230, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"100rpx"}'
                      class="cu-form-group">
                    <view :style='{"width":"160rpx","fontSize":"28rpx","color":"var(--publicMainColor)","textAlign":"left"}'
                          class="title">所属类型</view>
                    <picker @change="suoshuleixingTypesChange" :value="suoshuleixingTypesIndex" :range="suoshuleixingTypesOptions" range-key="indexName">
                        <view
                                :style='{"padding":"0 30rpx","boxShadow":"0 0 0px rgba(0,0,0,.6) inset","backgroundColor":"rgba(255, 255, 255, 1)","borderColor":"var(--publicMainColor)","borderRadius":"16rpx","color":"var(--publicMainColor)","textAlign":"left","borderWidth":"2rpx","fontSize":"28rpx","borderStyle":"solid","height":"88rpx","marginTop":"7rpx"}'
                                class="uni-input">{{ruleForm.suoshuleixingTypes?ruleForm.suoshuleixingValue:"请选择所属类型"}}</view>
                    </picker>
                </view>
            <view
                    :style='{"boxShadow":"0","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(228, 232, 230, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"100rpx"}'
                    class="cu-form-group">
                <view :style='{"width":"160rpx","fontSize":"28rpx","color":"var(--publicMainColor)","textAlign":"left"}'
                      class="title">企业规模</view>
                <input   disabled
                         :style='{"padding":"0 30rpx","boxShadow":"0 0 0px rgba(0,0,0,.6) inset","backgroundColor":"rgba(255, 255, 255, 1)","borderColor":"var(--publicMainColor)","borderRadius":"16rpx","color":"var(--publicMainColor)","textAlign":"left","borderWidth":"2rpx","fontSize":"28rpx","borderStyle":"solid","height":"88rpx","marginTop":"7rpx"}'
                         :disabled="ro.qiyeGuimo" type="text" v-model="ruleForm.qiyeGuimo" placeholder="企业规模"></input>
            </view>
            <view
                    :style='{"boxShadow":"0","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(228, 232, 230, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"100rpx"}'
                    class="cu-form-group">
                <view :style='{"width":"160rpx","fontSize":"28rpx","color":"var(--publicMainColor)","textAlign":"left"}'
                      class="title">单位地址</view>
                <input   disabled
                         :style='{"padding":"0 30rpx","boxShadow":"0 0 0px rgba(0,0,0,.6) inset","backgroundColor":"rgba(255, 255, 255, 1)","borderColor":"var(--publicMainColor)","borderRadius":"16rpx","color":"var(--publicMainColor)","textAlign":"left","borderWidth":"2rpx","fontSize":"28rpx","borderStyle":"solid","height":"88rpx","marginTop":"7rpx"}'
                         :disabled="ro.shixiDanweidizhi" type="text" v-model="ruleForm.shixiDanweidizhi" placeholder="单位地址"></input>
            </view>
            <view
                    :style='{"boxShadow":"0","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(228, 232, 230, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"100rpx"}'
                    class="cu-form-group">
                <view :style='{"width":"160rpx","fontSize":"28rpx","color":"var(--publicMainColor)","textAlign":"left"}'
                      class="title">进入时间</view>
                <input
                        :style='{"padding":"0 30rpx","boxShadow":"0 0 0px rgba(0,0,0,.6) inset","backgroundColor":"rgba(255, 255, 255, 1)","borderColor":"var(--publicMainColor)","borderRadius":"16rpx","color":"var(--publicMainColor)","textAlign":"left","borderWidth":"2rpx","fontSize":"28rpx","borderStyle":"solid","height":"88rpx","marginTop":"7rpx"}'
                        v-model="ruleForm.jinruTime" placeholder="进入时间" :readonly="ro.jinruTime"
                        @tap="toggleTab('jinruTime')"></input>
            </view>
					            <view
                    :style='{"boxShadow":"0","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(228, 232, 230, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"100rpx"}'
                    class="cu-form-group">
                <view :style='{"width":"160rpx","fontSize":"28rpx","color":"var(--publicMainColor)","textAlign":"left"}'
                      class="title">实习岗位</view>
                <input   disabled
                         :style='{"padding":"0 30rpx","boxShadow":"0 0 0px rgba(0,0,0,.6) inset","backgroundColor":"rgba(255, 255, 255, 1)","borderColor":"var(--publicMainColor)","borderRadius":"16rpx","color":"var(--publicMainColor)","textAlign":"left","borderWidth":"2rpx","fontSize":"28rpx","borderStyle":"solid","height":"88rpx","marginTop":"7rpx"}'
                         :disabled="ro.shixiGangwei" type="text" v-model="ruleForm.shixiGangwei" placeholder="实习岗位"></input>
            </view>
            <view
                    :style='{"boxShadow":"0","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(228, 232, 230, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"100rpx"}'
                    class="cu-form-group">
                <view :style='{"width":"160rpx","fontSize":"28rpx","color":"var(--publicMainColor)","textAlign":"left"}'
                      class="title">岗位培养方向</view>
                <input   disabled
                         :style='{"padding":"0 30rpx","boxShadow":"0 0 0px rgba(0,0,0,.6) inset","backgroundColor":"rgba(255, 255, 255, 1)","borderColor":"var(--publicMainColor)","borderRadius":"16rpx","color":"var(--publicMainColor)","textAlign":"left","borderWidth":"2rpx","fontSize":"28rpx","borderStyle":"solid","height":"88rpx","marginTop":"7rpx"}'
                         :disabled="ro.shixiGangweiFangxiang" type="text" v-model="ruleForm.shixiGangweiFangxiang" placeholder="岗位培养方向"></input>
            </view>
                <view :style='{"boxShadow":"0","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(228, 232, 230, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"100rpx"}'
                      class="cu-form-group">
                    <view :style='{"width":"160rpx","fontSize":"28rpx","color":"var(--publicMainColor)","textAlign":"left"}'
                          class="title">是否安排带教</view>
                    <picker @change="daijiaoTypesChange" :value="daijiaoTypesIndex" :range="daijiaoTypesOptions" range-key="indexName">
                        <view
                                :style='{"padding":"0 30rpx","boxShadow":"0 0 0px rgba(0,0,0,.6) inset","backgroundColor":"rgba(255, 255, 255, 1)","borderColor":"var(--publicMainColor)","borderRadius":"16rpx","color":"var(--publicMainColor)","textAlign":"left","borderWidth":"2rpx","fontSize":"28rpx","borderStyle":"solid","height":"88rpx","marginTop":"7rpx"}'
                                class="uni-input">{{ruleForm.daijiaoTypes?ruleForm.daijiaoValue:"请选择是否安排带教"}}</view>
                    </picker>
                </view>
                <view :style='{"boxShadow":"0","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(228, 232, 230, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"100rpx"}'
                      class="cu-form-group">
                    <view :style='{"width":"160rpx","fontSize":"28rpx","color":"var(--publicMainColor)","textAlign":"left"}'
                          class="title">补助</view>
                    <picker @change="buzhuTypesChange" :value="buzhuTypesIndex" :range="buzhuTypesOptions" range-key="indexName">
                        <view
                                :style='{"padding":"0 30rpx","boxShadow":"0 0 0px rgba(0,0,0,.6) inset","backgroundColor":"rgba(255, 255, 255, 1)","borderColor":"var(--publicMainColor)","borderRadius":"16rpx","color":"var(--publicMainColor)","textAlign":"left","borderWidth":"2rpx","fontSize":"28rpx","borderStyle":"solid","height":"88rpx","marginTop":"7rpx"}'
                                class="uni-input">{{ruleForm.buzhuTypes?ruleForm.buzhuValue:"请选择补助"}}</view>
                    </picker>
                </view>
                <view :style='{"boxShadow":"0","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(228, 232, 230, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"100rpx"}'
                      class="cu-form-group">
                    <view :style='{"width":"160rpx","fontSize":"28rpx","color":"var(--publicMainColor)","textAlign":"left"}'
                          class="title">包宿</view>
                    <picker @change="susheTypesChange" :value="susheTypesIndex" :range="susheTypesOptions" range-key="indexName">
                        <view
                                :style='{"padding":"0 30rpx","boxShadow":"0 0 0px rgba(0,0,0,.6) inset","backgroundColor":"rgba(255, 255, 255, 1)","borderColor":"var(--publicMainColor)","borderRadius":"16rpx","color":"var(--publicMainColor)","textAlign":"left","borderWidth":"2rpx","fontSize":"28rpx","borderStyle":"solid","height":"88rpx","marginTop":"7rpx"}'
                                class="uni-input">{{ruleForm.susheTypes?ruleForm.susheValue:"请选择包宿"}}</view>
                    </picker>
                </view>
                <view
                        :style='{"boxShadow":"0","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(228, 232, 230, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"100rpx"}'
                        class="cu-form-group">
                    <view :style='{"width":"160rpx","fontSize":"28rpx","color":"var(--publicMainColor)","textAlign":"left"}'
                          class="title">薪资</view>
                    <input   disabled
                             :style='{"padding":"0 30rpx","boxShadow":"0 0 0px rgba(0,0,0,.6) inset","backgroundColor":"rgba(255, 255, 255, 1)","borderColor":"var(--publicMainColor)","borderRadius":"16rpx","color":"var(--publicMainColor)","textAlign":"left","borderWidth":"2rpx","fontSize":"28rpx","borderStyle":"solid","height":"88rpx","marginTop":"7rpx"}'
                             :disabled="ro.xinzi" type="number" v-model="ruleForm.xinzi" placeholder="薪资"></input>
                </view>
            <view
                    :style='{"boxShadow":"0","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(228, 232, 230, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"100rpx"}'
                    class="cu-form-group">
                <view :style='{"width":"160rpx","fontSize":"28rpx","color":"var(--publicMainColor)","textAlign":"left"}'
                      class="title">现住地址</view>
                <input   disabled
                         :style='{"padding":"0 30rpx","boxShadow":"0 0 0px rgba(0,0,0,.6) inset","backgroundColor":"rgba(255, 255, 255, 1)","borderColor":"var(--publicMainColor)","borderRadius":"16rpx","color":"var(--publicMainColor)","textAlign":"left","borderWidth":"2rpx","fontSize":"28rpx","borderStyle":"solid","height":"88rpx","marginTop":"7rpx"}'
                         :disabled="ro.xianzhuAddress" type="text" v-model="ruleForm.xianzhuAddress" placeholder="现住地址"></input>
            </view>
            <view
                    :style='{"boxShadow":"0","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(228, 232, 230, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"210rpx"}'
                    class="cu-form-group">
                <view :style='{"width":"160rpx","fontSize":"28rpx","color":"var(--publicMainColor)","textAlign":"left"}'
                      class="title">同公司校友情况</view>
                <textarea :style='{"padding":"0 30rpx","boxShadow":"0 0 0px rgba(0,0,0,.6) inset","backgroundColor":"rgba(255, 255, 255, 1)","borderColor":"var(--publicMainColor)","borderRadius":"16rpx","color":"var(--publicMainColor)","textAlign":"left","borderWidth":"2rpx","fontSize":"28rpx","borderStyle":"solid","height":"88rpx","marginTop":"7rpx","height":"200rpx"}'
                          :disabled="ro.tonggongsixiaoyouContent" v-model="ruleForm.tonggongsixiaoyouContent" placeholder="同公司校友情况"/>
            </view>
                <view :style='{"boxShadow":"0","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(228, 232, 230, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"100rpx"}'
                      class="cu-form-group">
                    <view :style='{"width":"160rpx","fontSize":"28rpx","color":"var(--publicMainColor)","textAlign":"left"}'
                          class="title">是否招聘</view>
                    <picker @change="zhaopinShifouTypesChange" :value="zhaopinShifouTypesIndex" :range="zhaopinShifouTypesOptions" range-key="indexName">
                        <view
                                :style='{"padding":"0 30rpx","boxShadow":"0 0 0px rgba(0,0,0,.6) inset","backgroundColor":"rgba(255, 255, 255, 1)","borderColor":"var(--publicMainColor)","borderRadius":"16rpx","color":"var(--publicMainColor)","textAlign":"left","borderWidth":"2rpx","fontSize":"28rpx","borderStyle":"solid","height":"88rpx","marginTop":"7rpx"}'
                                class="uni-input">{{ruleForm.zhaopinShifouTypes?ruleForm.zhaopinShifouValue:"请选择是否招聘"}}</view>
                    </picker>
                </view>
            <view
                    :style='{"boxShadow":"0","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(228, 232, 230, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"210rpx"}'
                    class="cu-form-group">
                <view :style='{"width":"160rpx","fontSize":"28rpx","color":"var(--publicMainColor)","textAlign":"left"}'
                      class="title">单位专业评价</view>
                <textarea :style='{"padding":"0 30rpx","boxShadow":"0 0 0px rgba(0,0,0,.6) inset","backgroundColor":"rgba(255, 255, 255, 1)","borderColor":"var(--publicMainColor)","borderRadius":"16rpx","color":"var(--publicMainColor)","textAlign":"left","borderWidth":"2rpx","fontSize":"28rpx","borderStyle":"solid","height":"88rpx","marginTop":"7rpx","height":"200rpx"}'
                          :disabled="ro.danweizhuanyeContent" v-model="ruleForm.danweizhuanyeContent" placeholder="单位专业评价"/>
            </view>
            <view
                    :style='{"boxShadow":"0","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(228, 232, 230, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"210rpx"}'
                    class="cu-form-group">
                <view :style='{"width":"160rpx","fontSize":"28rpx","color":"var(--publicMainColor)","textAlign":"left"}'
                      class="title">单位人事评价</view>
                <textarea :style='{"padding":"0 30rpx","boxShadow":"0 0 0px rgba(0,0,0,.6) inset","backgroundColor":"rgba(255, 255, 255, 1)","borderColor":"var(--publicMainColor)","borderRadius":"16rpx","color":"var(--publicMainColor)","textAlign":"left","borderWidth":"2rpx","fontSize":"28rpx","borderStyle":"solid","height":"88rpx","marginTop":"7rpx","height":"200rpx"}'
                          :disabled="ro.danweirenshiContent" v-model="ruleForm.danweirenshiContent" placeholder="单位人事评价"/>
            </view>
                <view :style='{"boxShadow":"0","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(228, 232, 230, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"100rpx"}'
                      class="cu-form-group">
                    <view :style='{"width":"160rpx","fontSize":"28rpx","color":"var(--publicMainColor)","textAlign":"left"}'
                          class="title">单位满意状态</view>
                    <picker @change="manyiTypesChange" :value="manyiTypesIndex" :range="manyiTypesOptions" range-key="indexName">
                        <view
                                :style='{"padding":"0 30rpx","boxShadow":"0 0 0px rgba(0,0,0,.6) inset","backgroundColor":"rgba(255, 255, 255, 1)","borderColor":"var(--publicMainColor)","borderRadius":"16rpx","color":"var(--publicMainColor)","textAlign":"left","borderWidth":"2rpx","fontSize":"28rpx","borderStyle":"solid","height":"88rpx","marginTop":"7rpx"}'
                                class="uni-input">{{ruleForm.manyiTypes?ruleForm.manyiValue:"请选择单位满意状态"}}</view>
                    </picker>
                </view>
				

</view>	
<view v-if="ruleForm.shixiTypes==3">
				
				<!-- 考研 -->
            <view :style='{"boxShadow":"0","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(228, 232, 230, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"100rpx"}'
                    class="cu-form-group">
                <view :style='{"width":"160rpx","fontSize":"28rpx","color":"var(--publicMainColor)","textAlign":"left"}'
                      class="title">考研学校</view>
                <input   disabled
                         :style='{"padding":"0 30rpx","boxShadow":"0 0 0px rgba(0,0,0,.6) inset","backgroundColor":"rgba(255, 255, 255, 1)","borderColor":"var(--publicMainColor)","borderRadius":"16rpx","color":"var(--publicMainColor)","textAlign":"left","borderWidth":"2rpx","fontSize":"28rpx","borderStyle":"solid","height":"88rpx","marginTop":"7rpx"}'
                         :disabled="ro.shixiKaoyanxuexiao" type="text" v-model="ruleForm.shixiKaoyanxuexiao" placeholder="考研学校"></input>
            </view>
                <view :style='{"boxShadow":"0","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(228, 232, 230, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"100rpx"}'
                      class="cu-form-group">
                    <view :style='{"width":"160rpx","fontSize":"28rpx","color":"var(--publicMainColor)","textAlign":"left"}'
                          class="title">考研专业</view>
                    <picker @change="kaoyanzhuanyeTypesChange" :value="kaoyanzhuanyeTypesIndex" :range="kaoyanzhuanyeTypesOptions" range-key="indexName">
                        <view
                                :style='{"padding":"0 30rpx","boxShadow":"0 0 0px rgba(0,0,0,.6) inset","backgroundColor":"rgba(255, 255, 255, 1)","borderColor":"var(--publicMainColor)","borderRadius":"16rpx","color":"var(--publicMainColor)","textAlign":"left","borderWidth":"2rpx","fontSize":"28rpx","borderStyle":"solid","height":"88rpx","marginTop":"7rpx"}'
                                class="uni-input">{{ruleForm.kaoyanzhuanyeTypes?ruleForm.kaoyanzhuanyeValue:"请选择考研专业"}}</view>
                    </picker>
                </view>
            <view
                    :style='{"boxShadow":"0","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(228, 232, 230, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"100rpx"}'
                    class="cu-form-group">
                <view :style='{"width":"160rpx","fontSize":"28rpx","color":"var(--publicMainColor)","textAlign":"left"}'
                      class="title">方向</view>
                <input   disabled
                         :style='{"padding":"0 30rpx","boxShadow":"0 0 0px rgba(0,0,0,.6) inset","backgroundColor":"rgba(255, 255, 255, 1)","borderColor":"var(--publicMainColor)","borderRadius":"16rpx","color":"var(--publicMainColor)","textAlign":"left","borderWidth":"2rpx","fontSize":"28rpx","borderStyle":"solid","height":"88rpx","marginTop":"7rpx"}'
                         :disabled="ro.shixiKaoyanfangxiang" type="text" v-model="ruleForm.shixiKaoyanfangxiang" placeholder="方向"></input>
            </view>
		
</view>	
			
			
<view v-if="ruleForm.shixiTypes==2">
			<!-- 考公 -->
            <view
                    :style='{"boxShadow":"0","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(228, 232, 230, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"100rpx"}'
                    class="cu-form-group">
                <view :style='{"width":"160rpx","fontSize":"28rpx","color":"var(--publicMainColor)","textAlign":"left"}'
                      class="title">考公地区</view>
                <input   disabled
                         :style='{"padding":"0 30rpx","boxShadow":"0 0 0px rgba(0,0,0,.6) inset","backgroundColor":"rgba(255, 255, 255, 1)","borderColor":"var(--publicMainColor)","borderRadius":"16rpx","color":"var(--publicMainColor)","textAlign":"left","borderWidth":"2rpx","fontSize":"28rpx","borderStyle":"solid","height":"88rpx","marginTop":"7rpx"}'
                         :disabled="ro.shixiKaogongdiqu" type="text" v-model="ruleForm.shixiKaogongdiqu" placeholder="考公地区"></input>
            </view>
            <view
                    :style='{"boxShadow":"0","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(228, 232, 230, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"100rpx"}'
                    class="cu-form-group">
                <view :style='{"width":"160rpx","fontSize":"28rpx","color":"var(--publicMainColor)","textAlign":"left"}'
                      class="title">职位</view>
                <input   disabled
                         :style='{"padding":"0 30rpx","boxShadow":"0 0 0px rgba(0,0,0,.6) inset","backgroundColor":"rgba(255, 255, 255, 1)","borderColor":"var(--publicMainColor)","borderRadius":"16rpx","color":"var(--publicMainColor)","textAlign":"left","borderWidth":"2rpx","fontSize":"28rpx","borderStyle":"solid","height":"88rpx","marginTop":"7rpx"}'
                         :disabled="ro.shixiKaogongzhiwei" type="text" v-model="ruleForm.shixiKaogongzhiwei" placeholder="职位"></input>
            </view>
            <view
                    :style='{"boxShadow":"0","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(228, 232, 230, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"100rpx"}'
                    class="cu-form-group">
                <view :style='{"width":"160rpx","fontSize":"28rpx","color":"var(--publicMainColor)","textAlign":"left"}'
                      class="title">考公时间</view>
                <input
                        :style='{"padding":"0 30rpx","boxShadow":"0 0 0px rgba(0,0,0,.6) inset","backgroundColor":"rgba(255, 255, 255, 1)","borderColor":"var(--publicMainColor)","borderRadius":"16rpx","color":"var(--publicMainColor)","textAlign":"left","borderWidth":"2rpx","fontSize":"28rpx","borderStyle":"solid","height":"88rpx","marginTop":"7rpx"}'
                        v-model="ruleForm.kaogongTime" placeholder="考公时间" :readonly="ro.kaogongTime"
                        @tap="toggleTab('kaogongTime')"></input>
            </view>
</view>	
			
			
		
<view v-if="ruleForm.shixiTypes==4">	
			<!-- 留学 -->
					            <view
                    :style='{"boxShadow":"0","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(228, 232, 230, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"100rpx"}'
                    class="cu-form-group">
                <view :style='{"width":"160rpx","fontSize":"28rpx","color":"var(--publicMainColor)","textAlign":"left"}'
                      class="title">留学国家</view>
                <input   disabled
                         :style='{"padding":"0 30rpx","boxShadow":"0 0 0px rgba(0,0,0,.6) inset","backgroundColor":"rgba(255, 255, 255, 1)","borderColor":"var(--publicMainColor)","borderRadius":"16rpx","color":"var(--publicMainColor)","textAlign":"left","borderWidth":"2rpx","fontSize":"28rpx","borderStyle":"solid","height":"88rpx","marginTop":"7rpx"}'
                         :disabled="ro.shixiLiuxue" type="text" v-model="ruleForm.shixiLiuxue" placeholder="留学国家"></input>
            </view>
            <view
                    :style='{"boxShadow":"0","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(228, 232, 230, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"100rpx"}'
                    class="cu-form-group">
                <view :style='{"width":"160rpx","fontSize":"28rpx","color":"var(--publicMainColor)","textAlign":"left"}'
                      class="title">留学大学</view>
                <input   disabled
                         :style='{"padding":"0 30rpx","boxShadow":"0 0 0px rgba(0,0,0,.6) inset","backgroundColor":"rgba(255, 255, 255, 1)","borderColor":"var(--publicMainColor)","borderRadius":"16rpx","color":"var(--publicMainColor)","textAlign":"left","borderWidth":"2rpx","fontSize":"28rpx","borderStyle":"solid","height":"88rpx","marginTop":"7rpx"}'
                         :disabled="ro.shixiLiuxueDaxue" type="text" v-model="ruleForm.shixiLiuxueDaxue" placeholder="留学大学"></input>
            </view>
            <view
                    :style='{"boxShadow":"0","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(228, 232, 230, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"100rpx"}'
                    class="cu-form-group">
                <view :style='{"width":"160rpx","fontSize":"28rpx","color":"var(--publicMainColor)","textAlign":"left"}'
                      class="title">留学单位</view>
                <input   disabled
                         :style='{"padding":"0 30rpx","boxShadow":"0 0 0px rgba(0,0,0,.6) inset","backgroundColor":"rgba(255, 255, 255, 1)","borderColor":"var(--publicMainColor)","borderRadius":"16rpx","color":"var(--publicMainColor)","textAlign":"left","borderWidth":"2rpx","fontSize":"28rpx","borderStyle":"solid","height":"88rpx","marginTop":"7rpx"}'
                         :disabled="ro.shixiLiuxueDanwei" type="text" v-model="ruleForm.shixiLiuxueDanwei" placeholder="留学单位"></input>
            </view>
</view>	
<!-- text后缀 -->
            <view
                    :style='{"boxShadow":"0","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(228, 232, 230, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"210rpx"}'
                    class="cu-form-group">
                <view :style='{"width":"160rpx","fontSize":"28rpx","color":"var(--publicMainColor)","textAlign":"left"}'
                      class="title">备注</view>
                <textarea :style='{"padding":"0 30rpx","boxShadow":"0 0 0px rgba(0,0,0,.6) inset","backgroundColor":"rgba(255, 255, 255, 1)","borderColor":"var(--publicMainColor)","borderRadius":"16rpx","color":"var(--publicMainColor)","textAlign":"left","borderWidth":"2rpx","fontSize":"28rpx","borderStyle":"solid","height":"88rpx","marginTop":"7rpx","height":"200rpx"}'
                          :disabled="ro.shixiContent" v-model="ruleForm.shixiContent" placeholder="备注"/>
            </view>

            <view class="btn">
                <button
                        :style='{"boxShadow":"0 0 16rpx rgba(0,0,0,0) inset","backgroundColor":"var(--publicMainColor)","borderColor":"#409EFF","borderRadius":"8rpx","color":"rgba(255, 255, 255, 1)","borderWidth":"0","width":"70%","fontSize":"32rpx","borderStyle":"solid","height":"80rpx"}'
                        @tap="onSubmitTap" class="bg-red">提交</button>
            </view>
        </form>

					<w-picker mode="dateTime" step="1" :current="false" :hasSecond="false" @confirm="jinruTimeConfirm"
                              ref="jinruTime" themeColor="#333333"></w-picker>
					<w-picker mode="dateTime" step="1" :current="false" :hasSecond="false" @confirm="kaogongTimeConfirm"
                              ref="kaogongTime" themeColor="#333333"></w-picker>
					<w-picker mode="dateTime" step="1" :current="false" :hasSecond="false" @confirm="insertTimeConfirm"
                              ref="insertTime" themeColor="#333333"></w-picker>
					<w-picker mode="dateTime" step="1" :current="false" :hasSecond="false" @confirm="createTimeConfirm"
                              ref="createTime" themeColor="#333333"></w-picker>


    </view>
</template>

<script>
    import wPicker from "@/components/w-picker/w-picker.vue";

    export default {
        data() {
            return {
                cross: '',
                ro:{
					xueshengId: false,
					shixiUuidNumber: true,
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
					createTime: false,
        },
            ruleForm: {
					xueshengId: '',
					shixiUuidNumber: this.getUUID(),//数字
					shixiName: '',
					shixiTypes: '',//数字
					shixiValue: '',//数字对应的值
					shixiDanweimingcheng: '',
					hangyeTypes: '',//数字
					hangyeValue: '',//数字对应的值
					suoshuleixingTypes: '',//数字
					suoshuleixingValue: '',//数字对应的值
					qiyeGuimo: '',
					shixiDanweidizhi: '',
					jinruTime: '',
					shixiGangwei: '',
					shixiGangweiFangxiang: '',
					daijiaoTypes: '',//数字
					daijiaoValue: '',//数字对应的值
					buzhuTypes: '',//数字
					buzhuValue: '',//数字对应的值
					susheTypes: '',//数字
					susheValue: '',//数字对应的值
					xinzi: '',
					xianzhuAddress: '',
					tonggongsixiaoyouContent: '',
					zhaopinShifouTypes: '',//数字
					zhaopinShifouValue: '',//数字对应的值
					danweizhuanyeContent: '',
					danweirenshiContent: '',
					manyiTypes: '',//数字
					manyiValue: '',//数字对应的值
					shixiKaoyanxuexiao: '',
					kaoyanzhuanyeTypes: '',//数字
					kaoyanzhuanyeValue: '',//数字对应的值
					shixiKaoyanfangxiang: '',
					shixiKaogongdiqu: '',
					shixiKaogongzhiwei: '',
					kaogongTime: '',
					shixiLiuxue: '',
					shixiLiuxueDaxue: '',
					shixiLiuxueDanwei: '',
					shixiContent: '',
					insertTime: '',
					createTime: '',
            },
            // 登陆用户信息
            user: {},
				shixiTypesOptions: [],
							shixiTypesIndex : 0,
				hangyeTypesOptions: [],
							hangyeTypesIndex : 0,
				suoshuleixingTypesOptions: [],
							suoshuleixingTypesIndex : 0,
				daijiaoTypesOptions: [],
							daijiaoTypesIndex : 0,
				buzhuTypesOptions: [],
							buzhuTypesIndex : 0,
				susheTypesOptions: [],
							susheTypesIndex : 0,
				zhaopinShifouTypesOptions: [],
							zhaopinShifouTypesIndex : 0,
				manyiTypesOptions: [],
							manyiTypesIndex : 0,
				kaoyanzhuanyeTypesOptions: [],
							kaoyanzhuanyeTypesIndex : 0,
							
							
							
				shixiFlag:false,			
				kaoyanFlag:false,			
				kaogongFlag:false,			
				liuxueFlag:false,			
        }
        },
        components: {
            wPicker
        },
        computed: {
            baseUrl() {
                return this.$base.url;
            },
        },
        async onLoad(options) {

		/*下拉框*/
			let shixiTypesParams = {
                page: 1,
                limit: 100,
                dicCode: 'shixi_types',
            }
			let shixiTypes = await this.$api.page(`dictionary`, shixiTypesParams);
			this.shixiTypesOptions = shixiTypes.data.list
		/*下拉框*/
			let hangyeTypesParams = {
                page: 1,
                limit: 100,
                dicCode: 'hangye_types',
            }
			let hangyeTypes = await this.$api.page(`dictionary`, hangyeTypesParams);
			this.hangyeTypesOptions = hangyeTypes.data.list
		/*下拉框*/
			let suoshuleixingTypesParams = {
                page: 1,
                limit: 100,
                dicCode: 'suoshuleixing_types',
            }
			let suoshuleixingTypes = await this.$api.page(`dictionary`, suoshuleixingTypesParams);
			this.suoshuleixingTypesOptions = suoshuleixingTypes.data.list
		/*下拉框*/
			let daijiaoTypesParams = {
                page: 1,
                limit: 100,
                dicCode: 'daijiao_types',
            }
			let daijiaoTypes = await this.$api.page(`dictionary`, daijiaoTypesParams);
			this.daijiaoTypesOptions = daijiaoTypes.data.list
		/*下拉框*/
			let buzhuTypesParams = {
                page: 1,
                limit: 100,
                dicCode: 'buzhu_types',
            }
			let buzhuTypes = await this.$api.page(`dictionary`, buzhuTypesParams);
			this.buzhuTypesOptions = buzhuTypes.data.list
		/*下拉框*/
			let susheTypesParams = {
                page: 1,
                limit: 100,
                dicCode: 'sushe_types',
            }
			let susheTypes = await this.$api.page(`dictionary`, susheTypesParams);
			this.susheTypesOptions = susheTypes.data.list
		/*下拉框*/
			let zhaopinShifouTypesParams = {
                page: 1,
                limit: 100,
                dicCode: 'zhaopin_types',
            }
			let zhaopinShifouTypes = await this.$api.page(`dictionary`, zhaopinShifouTypesParams);
			this.zhaopinShifouTypesOptions = zhaopinShifouTypes.data.list
		/*下拉框*/
			let manyiTypesParams = {
                page: 1,
                limit: 100,
                dicCode: 'manyi_types',
            }
			let manyiTypes = await this.$api.page(`dictionary`, manyiTypesParams);
			this.manyiTypesOptions = manyiTypes.data.list
		/*下拉框*/
			let kaoyanzhuanyeTypesParams = {
                page: 1,
                limit: 100,
                dicCode: 'kaoyanzhuanye_types',
            }
			let kaoyanzhuanyeTypes = await this.$api.page(`dictionary`, kaoyanzhuanyeTypesParams);
			this.kaoyanzhuanyeTypesOptions = kaoyanzhuanyeTypes.data.list


            // 如果是更新操作
            if (options.id) {
                this.ruleForm.id = options.id;
                // 获取信息
                let res = await this.$api.info(`shixi`, this.ruleForm.id);
                this.ruleForm = res.data;
            }
            if(options.shixiId){
                this.ruleForm.shixiId = options.shixiId;
            }
            // 跨表
            // this.styleChange()
        },
        methods: {
            // 下拉变化
            shixiTypesChange(e) {
                this.shixiTypesIndex = e.target.value
                this.ruleForm.shixiValue = this.shixiTypesOptions[this.shixiTypesIndex].indexName
                this.ruleForm.shixiTypes = this.shixiTypesOptions[this.shixiTypesIndex].codeIndex
            },
            hangyeTypesChange(e) {
                this.hangyeTypesIndex = e.target.value
                this.ruleForm.hangyeValue = this.hangyeTypesOptions[this.hangyeTypesIndex].indexName
                this.ruleForm.hangyeTypes = this.hangyeTypesOptions[this.hangyeTypesIndex].codeIndex
            },
            suoshuleixingTypesChange(e) {
                this.suoshuleixingTypesIndex = e.target.value
                this.ruleForm.suoshuleixingValue = this.suoshuleixingTypesOptions[this.suoshuleixingTypesIndex].indexName
                this.ruleForm.suoshuleixingTypes = this.suoshuleixingTypesOptions[this.suoshuleixingTypesIndex].codeIndex
            },
            daijiaoTypesChange(e) {
                this.daijiaoTypesIndex = e.target.value
                this.ruleForm.daijiaoValue = this.daijiaoTypesOptions[this.daijiaoTypesIndex].indexName
                this.ruleForm.daijiaoTypes = this.daijiaoTypesOptions[this.daijiaoTypesIndex].codeIndex
            },
            buzhuTypesChange(e) {
                this.buzhuTypesIndex = e.target.value
                this.ruleForm.buzhuValue = this.buzhuTypesOptions[this.buzhuTypesIndex].indexName
                this.ruleForm.buzhuTypes = this.buzhuTypesOptions[this.buzhuTypesIndex].codeIndex
            },
            susheTypesChange(e) {
                this.susheTypesIndex = e.target.value
                this.ruleForm.susheValue = this.susheTypesOptions[this.susheTypesIndex].indexName
                this.ruleForm.susheTypes = this.susheTypesOptions[this.susheTypesIndex].codeIndex
            },
            zhaopinShifouTypesChange(e) {
                this.zhaopinShifouTypesIndex = e.target.value
                this.ruleForm.zhaopinShifouValue = this.zhaopinShifouTypesOptions[this.zhaopinShifouTypesIndex].indexName
                this.ruleForm.zhaopinShifouTypes = this.zhaopinShifouTypesOptions[this.zhaopinShifouTypesIndex].codeIndex
            },
            manyiTypesChange(e) {
                this.manyiTypesIndex = e.target.value
                this.ruleForm.manyiValue = this.manyiTypesOptions[this.manyiTypesIndex].indexName
                this.ruleForm.manyiTypes = this.manyiTypesOptions[this.manyiTypesIndex].codeIndex
            },
            kaoyanzhuanyeTypesChange(e) {
                this.kaoyanzhuanyeTypesIndex = e.target.value
                this.ruleForm.kaoyanzhuanyeValue = this.kaoyanzhuanyeTypesOptions[this.kaoyanzhuanyeTypesIndex].indexName
                this.ruleForm.kaoyanzhuanyeTypes = this.kaoyanzhuanyeTypesOptions[this.kaoyanzhuanyeTypesIndex].codeIndex
            },


            // styleChange() {
            // 	this.$nextTick(() => {
            // 		// document.querySelectorAll('.app-update-pv .cu-form-group .uni-yaoxianStyle-yaoxianStyle').forEach(el=>{
            // 		//   el.style.backgroundColor = this.addUpdateForm.yaoxianStyle.content.backgroundColor
            // 		// })
            // 	})
            // },


			// 日期控件
			jinruTimeConfirm(val) {
                this.ruleForm.jinruTime = val.result;
                this.$forceUpdate();
            },
			// 日期控件
			kaogongTimeConfirm(val) {
                this.ruleForm.kaogongTime = val.result;
                this.$forceUpdate();
            },
			// 日期控件
			insertTimeConfirm(val) {
                this.ruleForm.insertTime = val.result;
                this.$forceUpdate();
            },
			// 日期控件
			createTimeConfirm(val) {
                this.ruleForm.createTime = val.result;
                this.$forceUpdate();
            },




            getUUID() {
                return new Date().getTime();
            },
            async onSubmitTap() {
				if ((!this.ruleForm.shixiUuidNumber)) {
                    this.$utils.msg(`实习编号不能为空`);
                    return
                }
				if ((!this.ruleForm.shixiName)) {
                    this.$utils.msg(`实习名称不能为空`);
                    return
                }
				if(this.ruleForm.shixiTypes==1){//实习
					//考研
					this.ruleForm.shixiKaoyanxuexiao=null;
					this.ruleForm.kaoyanzhuanyeTypes=null;
					this.ruleForm.shixiKaoyanfangxiang=null;
					//考公
					this.ruleForm.shixiKaogongdiqu=null;
					this.ruleForm.shixiKaogongzhiwei=null;
					this.ruleForm.kaogongTime=null;
					//留学
					this.ruleForm.shixiLiuxue=null;
					this.ruleForm.shixiLiuxueDaxue=null;
					this.ruleForm.shixiLiuxueDanwei=null;
					//实习相关不能为空
					if ((!this.ruleForm.shixiDanweimingcheng)) {
						this.$utils.msg(`实习单位不能为空`);
						return
					}
					if ((!this.ruleForm.hangyeTypes)) {
						this.$utils.msg(`行业不能为空`);
						return
					}
					if ((!this.ruleForm.suoshuleixingTypes)) {
						this.$utils.msg(`所属类型不能为空`);
						return
					}
					if ((!this.ruleForm.qiyeGuimo)) {
						this.$utils.msg(`企业规模不能为空`);
						return
					}
					if ((!this.ruleForm.shixiDanweidizhi)) {
						this.$utils.msg(`单位地址不能为空`);
						return
					}
					if ((!this.ruleForm.jinruTime)) {
						this.$utils.msg(`进入时间不能为空`);
						return
					}
					if ((!this.ruleForm.shixiGangwei)) {
						this.$utils.msg(`实习岗位不能为空`);
						return
					}
					if ((!this.ruleForm.shixiGangweiFangxiang)) {
						this.$utils.msg(`岗位培养方向不能为空`);
						return
					}
					if ((!this.ruleForm.daijiaoTypes)) {
						this.$utils.msg(`是否安排带教不能为空`);
						return
					}
					if ((!this.ruleForm.buzhuTypes)) {
						this.$utils.msg(`补助不能为空`);
						return
					}
					if ((!this.ruleForm.susheTypes)) {
						this.$utils.msg(`包宿不能为空`);
						return
					}
					if ((!this.ruleForm.xinzi) && (!this.$validate.isNumber(this.ruleForm.xinzi)) && this.ruleForm.xinzi >0) {
						this.$utils.msg(`薪资不能为空，不能小于0 格式为数字或小数`);
						return
					}
					if ((!this.ruleForm.xianzhuAddress)) {
						this.$utils.msg(`现住地址不能为空`);
						return
					}
					if ((!this.ruleForm.zhaopinShifouTypes)) {
						this.$utils.msg(`是否招聘不能为空`);
						return
					}
					if ((!this.ruleForm.manyiTypes)) {
						this.$utils.msg(`单位满意状态不能为空`);
						return
					}
					
				}else if(this.ruleForm.shixiTypes==2){//考公
					//实习
					this.ruleForm.shixiDanweimingcheng=null;
					this.ruleForm.hangyeTypes=null;
					this.ruleForm.suoshuleixingTypes=null;
					this.ruleForm.qiyeGuimo=null;
					this.ruleForm.shixiDanweidizhi=null;
					this.ruleForm.jinruTime=null;
					this.ruleForm.shixiGangwei=null;
					this.ruleForm.shixiGangweiFangxiang=null;
					this.ruleForm.daijiaoTypes=null;
					this.ruleForm.buzhuTypes=null;
					this.ruleForm.susheTypes=null;
					this.ruleForm.xinzi=null;
					this.ruleForm.xianzhuAddress=null;
					this.ruleForm.tonggongsixiaoyouContent=null;
					this.ruleForm.zhaopinShifouTypes=null;
					this.ruleForm.danweizhuanyeContent=null;
					this.ruleForm.danweirenshiContent=null;
					this.ruleForm.manyiTypes=null;
					//考研
					this.ruleForm.shixiKaoyanxuexiao=null;
					this.ruleForm.kaoyanzhuanyeTypes=null;
					this.ruleForm.shixiKaoyanfangxiang=null;
					//留学
					this.ruleForm.shixiLiuxue=null;
					this.ruleForm.shixiLiuxueDaxue=null;
					this.ruleForm.shixiLiuxueDanwei=null;
					//考公
					if ((!this.ruleForm.shixiKaogongdiqu)) {
						this.$utils.msg(`考公地区不能为空`);
						return
					}
					if ((!this.ruleForm.shixiKaogongzhiwei)) {
						this.$utils.msg(`职位不能为空`);
						return
					}
					if ((!this.ruleForm.kaogongTime)) {
						this.$utils.msg(`考公时间不能为空`);
						return
					}
				}else if(this.ruleForm.shixiTypes==3){//考研
					//实习
					this.ruleForm.shixiDanweimingcheng=null;
					this.ruleForm.hangyeTypes=null;
					this.ruleForm.suoshuleixingTypes=null;
					this.ruleForm.qiyeGuimo=null;
					this.ruleForm.shixiDanweidizhi=null;
					this.ruleForm.jinruTime=null;
					this.ruleForm.shixiGangwei=null;
					this.ruleForm.shixiGangweiFangxiang=null;
					this.ruleForm.daijiaoTypes=null;
					this.ruleForm.buzhuTypes=null;
					this.ruleForm.susheTypes=null;
					this.ruleForm.xinzi=null;
					this.ruleForm.xianzhuAddress=null;
					this.ruleForm.tonggongsixiaoyouContent=null;
					this.ruleForm.zhaopinShifouTypes=null;
					this.ruleForm.danweizhuanyeContent=null;
					this.ruleForm.danweirenshiContent=null;
					this.ruleForm.manyiTypes=null;
					//考公
					this.ruleForm.shixiKaogongdiqu=null;
					this.ruleForm.shixiKaogongzhiwei=null;
					this.ruleForm.kaogongTime=null;
					//留学
					this.ruleForm.shixiLiuxue=null;
					this.ruleForm.shixiLiuxueDaxue=null;
					this.ruleForm.shixiLiuxueDanwei=null;
									
					//考研
					if ((!this.ruleForm.shixiKaoyanxuexiao)) {
						this.$utils.msg(`考研学校不能为空`);
						return
					}
					if ((!this.ruleForm.kaoyanzhuanyeTypes)) {
						this.$utils.msg(`考研专业不能为空`);
						return
					}
					if ((!this.ruleForm.shixiKaoyanfangxiang)) {
						this.$utils.msg(`方向不能为空`);
						return
					}
				}else if(this.ruleForm.shixiTypes==4){//出国留学
					//实习
					this.ruleForm.shixiDanweimingcheng=null;
					this.ruleForm.hangyeTypes=null;
					this.ruleForm.suoshuleixingTypes=null;
					this.ruleForm.qiyeGuimo=null;
					this.ruleForm.shixiDanweidizhi=null;
					this.ruleForm.jinruTime=null;
					this.ruleForm.shixiGangwei=null;
					this.ruleForm.shixiGangweiFangxiang=null;
					this.ruleForm.daijiaoTypes=null;
					this.ruleForm.buzhuTypes=null;
					this.ruleForm.susheTypes=null;
					this.ruleForm.xinzi=null;
					this.ruleForm.xianzhuAddress=null;
					this.ruleForm.tonggongsixiaoyouContent=null;
					this.ruleForm.zhaopinShifouTypes=null;
					this.ruleForm.danweizhuanyeContent=null;
					this.ruleForm.danweirenshiContent=null;
					this.ruleForm.manyiTypes=null;
					//考研
					this.ruleForm.shixiKaoyanxuexiao=null;
					this.ruleForm.kaoyanzhuanyeTypes=null;
					this.ruleForm.shixiKaoyanfangxiang=null;
					//考公
					this.ruleForm.shixiKaogongdiqu=null;
					this.ruleForm.shixiKaogongzhiwei=null;
					this.ruleForm.kaogongTime=null;
					
					//留学
					if ((!this.ruleForm.shixiLiuxue)) {
						this.$utils.msg(`留学国家不能为空`);
						return
					}
					if ((!this.ruleForm.shixiLiuxueDaxue)) {
						this.$utils.msg(`留学大学不能为空`);
						return
					}
					if ((!this.ruleForm.shixiLiuxueDanwei)) {
						this.$utils.msg(`留学单位不能为空`);
						return
					}
				}else if(this.ruleForm.shixiTypes==5){//其他			
					this.ruleForm.shixiDanweimingcheng=null;
					this.ruleForm.hangyeTypes=null;
					this.ruleForm.suoshuleixingTypes=null;
					this.ruleForm.qiyeGuimo=null;
					this.ruleForm.shixiDanweidizhi=null;
					this.ruleForm.jinruTime=null;
					this.ruleForm.shixiGangwei=null;
					this.ruleForm.shixiGangweiFangxiang=null;
					this.ruleForm.daijiaoTypes=null;
					this.ruleForm.buzhuTypes=null;
					this.ruleForm.susheTypes=null;
					this.ruleForm.xinzi=null;
					this.ruleForm.xianzhuAddress=null;
					this.ruleForm.tonggongsixiaoyouContent=null;
					this.ruleForm.zhaopinShifouTypes=null;
					this.ruleForm.danweizhuanyeContent=null;
					this.ruleForm.danweirenshiContent=null;
					this.ruleForm.manyiTypes=null;
					//考研
					this.ruleForm.shixiKaoyanxuexiao=null;
					this.ruleForm.kaoyanzhuanyeTypes=null;
					this.ruleForm.shixiKaoyanfangxiang=null;
					//考公
					this.ruleForm.shixiKaogongdiqu=null;
					this.ruleForm.shixiKaogongzhiwei=null;
					this.ruleForm.kaogongTime=null;
					//留学
					this.ruleForm.shixiLiuxue=null;
					this.ruleForm.shixiLiuxueDaxue=null;
					this.ruleForm.shixiLiuxueDanwei=null;
				}
                if (this.ruleForm.id) {
                    await this.$api.update(`shixi`, this.ruleForm);
                } else {
                    await this.$api.save(`shixi`, this.ruleForm);
                }
                uni.setStorageSync('pingluenStateState', true);
                this.$utils.msgBack('提交成功');
            },
            getDate(type) {
                const date = new Date();
                let year = date.getFullYear();
                let month = date.getMonth() + 1;
                let day = date.getDate();
                if (type === 'start') {
                    year = year - 60;
                } else if (type === 'end') {
                    year = year + 2;
                }
                month = month > 9 ? month : '0' + month;;
                day = day > 9 ? day : '0' + day;
                return `${year}-${month}-${day}`;
            },
            toggleTab(str) {
                this.$refs[str].show();
            }
        }
    }
</script>
<style lang="scss" scoped>
    .container {
        padding: 20upx;
    }

    .content:after {
        position: fixed;
        top: 0;
        right: 0;
        left: 0;
        bottom: 0;
        content: '';
        background-attachment: fixed;
        background-size: cover;
        background-position: center;
    }

    textarea {
        border: 1upx solid #EEEEEE;
        border-radius: 20upx;
        padding: 20upx;
    }

    .title {
        width: 180upx;
    }

    .avator {
        width: 150upx;
        height: 60upx;
    }

    .right-input {
        flex: 1;
        text-align: left;
        padding: 0 24upx;
    }

    .cu-form-group.active {
        justify-content: space-between;
    }

    .cu-form-group .title {
        height: auto;
        line-height:30rpx
    }

    .btn {
        display: flex;
        align-items: center;
        justify-content: center;
        flex-wrap: wrap;
        padding: 20upx 0;
    }

    .cu-form-group {
        padding: 0 24upx;
        background-color: transparent;
        min-height: inherit;
    }

    .cu-form-group+.cu-form-group {
        border: 0;
    }

    .cu-form-group uni-input {
        padding: 0 30upx;
    }

    .uni-input {
        padding: 0 30upx;
    }

    .cu-form-group uni-textarea {
        padding: 30upx;
        margin: 0;
    }

    .cu-form-group uni-picker::after {
        line-height: 80rpx;
    }

    .select .uni-input {
        line-height: 80rpx;
    }

    .input .right-input {
        line-height: 88rpx;
    }
</style>