<template>
    <view class="content">
        <form class="app-update-pv">

            <view class="btn">
                <button
                        :style='{"boxShadow":"0 0 16rpx rgba(0,0,0,0) inset","backgroundColor":"var(--publicMainColor)","borderColor":"#409EFF","borderRadius":"8rpx","color":"rgba(255, 255, 255, 1)","borderWidth":"0","width":"70%","fontSize":"32rpx","borderStyle":"solid","height":"80rpx"}'
                        @tap="onSubmitTap" class="bg-red">提交</button>
            </view>
        </form>

					<w-picker mode="dateTime" step="1" :current="false" :hasSecond="false" @confirm="insertTimeConfirm"
                              ref="insertTime" themeColor="#333333"></w-picker>
					<w-picker mode="dateTime" step="1" :current="false" :hasSecond="false" @confirm="zhaopinToudiShenheTimeConfirm"
                              ref="zhaopinToudiShenheTime" themeColor="#333333"></w-picker>
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
					jianliId: false,
					zhaopinId: false,
					insertTime: false,
					zhaopinToudiYesnoTypes: false,
					zhaopinToudiYesnoText: false,
					zhaopinToudiShenheTime: false,
					createTime: false,
        },
            ruleForm: {
					jianliId: '',
					zhaopinId: '',
					insertTime: '',
					zhaopinToudiYesnoTypes: '',//数字
					zhaopinToudiYesnoValue: '',//数字对应的值
					zhaopinToudiYesnoText: '',
					zhaopinToudiShenheTime: '',
					createTime: '',
            },
            // 登陆用户信息
            user: {},
				zhaopinToudiYesnoTypesOptions: [],
							zhaopinToudiYesnoTypesIndex : 0,

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
			let zhaopinToudiYesnoTypesParams = {
                page: 1,
                limit: 100,
                dicCode: 'zhaopin_toudi_yesno_types',
            }
			let zhaopinToudiYesnoTypes = await this.$api.page(`dictionary`, zhaopinToudiYesnoTypesParams);
			this.zhaopinToudiYesnoTypesOptions = zhaopinToudiYesnoTypes.data.list


            // 如果是更新操作
            if (options.id) {
                this.ruleForm.id = options.id;
                // 获取信息
                let res = await this.$api.info(`zhaopinToudi`, this.ruleForm.id);
                this.ruleForm = res.data;
            }
            if(options.zhaopinToudiId){
                this.ruleForm.zhaopinToudiId = options.zhaopinToudiId;
            }
            // 跨表
            // this.styleChange()
        },
        methods: {
            // 下拉变化
            zhaopinToudiYesnoTypesChange(e) {
                this.zhaopinToudiYesnoTypesIndex = e.target.value
                this.ruleForm.zhaopinToudiYesnoValue = this.zhaopinToudiYesnoTypesOptions[this.zhaopinToudiYesnoTypesIndex].indexName
                this.ruleForm.zhaopinToudiYesnoTypes = this.zhaopinToudiYesnoTypesOptions[this.zhaopinToudiYesnoTypesIndex].codeIndex
            },


            // styleChange() {
            // 	this.$nextTick(() => {
            // 		// document.querySelectorAll('.app-update-pv .cu-form-group .uni-yaoxianStyle-yaoxianStyle').forEach(el=>{
            // 		//   el.style.backgroundColor = this.addUpdateForm.yaoxianStyle.content.backgroundColor
            // 		// })
            // 	})
            // },


			// 日期控件
			insertTimeConfirm(val) {
                this.ruleForm.insertTime = val.result;
                this.$forceUpdate();
            },
			// 日期控件
			zhaopinToudiShenheTimeConfirm(val) {
                this.ruleForm.zhaopinToudiShenheTime = val.result;
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
                if (this.ruleForm.id) {
                    await this.$api.update(`zhaopinToudi`, this.ruleForm);
                } else {
                    await this.$api.save(`zhaopinToudi`, this.ruleForm);
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