package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ZhaopinLiuyanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 职位留言
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("zhaopin_liuyan")
public class ZhaopinLiuyanView extends ZhaopinLiuyanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表

	//级联表 学生
		/**
		* 学生姓名
		*/

		@ColumnInfo(comment="学生姓名",type="varchar(200)")
		private String xueshengName;
		/**
		* 学生手机号
		*/

		@ColumnInfo(comment="学生手机号",type="varchar(200)")
		private String xueshengPhone;
		/**
		* 学生身份证号
		*/

		@ColumnInfo(comment="学生身份证号",type="varchar(200)")
		private String xueshengIdNumber;
		/**
		* 学生头像
		*/

		@ColumnInfo(comment="学生头像",type="varchar(200)")
		private String xueshengPhoto;
		/**
		* 学生邮箱
		*/

		@ColumnInfo(comment="学生邮箱",type="varchar(200)")
		private String xueshengEmail;
	//级联表 职位招聘
					 
		/**
		* 职位招聘 的 公司
		*/
		@ColumnInfo(comment="公司",type="int(11)")
		private Integer zhaopinGongsiId;
		/**
		* 招聘信息名称
		*/

		@ColumnInfo(comment="招聘信息名称",type="varchar(200)")
		private String zhaopinName;
		/**
		* 招聘信息照片
		*/

		@ColumnInfo(comment="招聘信息照片",type="varchar(200)")
		private String zhaopinPhoto;
		/**
		* 薪资待遇
		*/

		@ColumnInfo(comment="薪资待遇",type="varchar(200)")
		private String zhaopinDaiyu;
		/**
		* 上班地点
		*/

		@ColumnInfo(comment="上班地点",type="varchar(200)")
		private String zhaopinAddress;
		/**
		* 联系人
		*/

		@ColumnInfo(comment="联系人",type="varchar(200)")
		private String lianxirenName;
		/**
		* 招聘电话
		*/

		@ColumnInfo(comment="招聘电话",type="varchar(200)")
		private String zhaopinPhone;
		/**
		* 招聘岗位
		*/
		@ColumnInfo(comment="招聘岗位",type="int(11)")
		private Integer zhaopinTypes;
			/**
			* 招聘岗位的值
			*/
			@ColumnInfo(comment="招聘岗位的字典表值",type="varchar(200)")
			private String zhaopinValue;
		/**
		* 招聘类型
		*/
		@ColumnInfo(comment="招聘类型",type="int(11)")
		private Integer leixingTypes;
			/**
			* 招聘类型的值
			*/
			@ColumnInfo(comment="招聘类型的字典表值",type="varchar(200)")
			private String leixingValue;
		/**
		* 招聘人数
		*/

		@ColumnInfo(comment="招聘人数",type="int(11)")
		private Integer zhaopinRenshuNumber;
		/**
		* 是否上架
		*/
		@ColumnInfo(comment="是否上架",type="int(11)")
		private Integer shangxiaTypes;
			/**
			* 是否上架的值
			*/
			@ColumnInfo(comment="是否上架的字典表值",type="varchar(200)")
			private String shangxiaValue;
		/**
		* 招聘信息详情
		*/

		@ColumnInfo(comment="招聘信息详情",type="text")
		private String zhaopinContent;



	public ZhaopinLiuyanView() {

	}

	public ZhaopinLiuyanView(ZhaopinLiuyanEntity zhaopinLiuyanEntity) {
		try {
			BeanUtils.copyProperties(this, zhaopinLiuyanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}





	//级联表的get和set 学生

		/**
		* 获取： 学生姓名
		*/
		public String getXueshengName() {
			return xueshengName;
		}
		/**
		* 设置： 学生姓名
		*/
		public void setXueshengName(String xueshengName) {
			this.xueshengName = xueshengName;
		}

		/**
		* 获取： 学生手机号
		*/
		public String getXueshengPhone() {
			return xueshengPhone;
		}
		/**
		* 设置： 学生手机号
		*/
		public void setXueshengPhone(String xueshengPhone) {
			this.xueshengPhone = xueshengPhone;
		}

		/**
		* 获取： 学生身份证号
		*/
		public String getXueshengIdNumber() {
			return xueshengIdNumber;
		}
		/**
		* 设置： 学生身份证号
		*/
		public void setXueshengIdNumber(String xueshengIdNumber) {
			this.xueshengIdNumber = xueshengIdNumber;
		}

		/**
		* 获取： 学生头像
		*/
		public String getXueshengPhoto() {
			return xueshengPhoto;
		}
		/**
		* 设置： 学生头像
		*/
		public void setXueshengPhoto(String xueshengPhoto) {
			this.xueshengPhoto = xueshengPhoto;
		}

		/**
		* 获取： 学生邮箱
		*/
		public String getXueshengEmail() {
			return xueshengEmail;
		}
		/**
		* 设置： 学生邮箱
		*/
		public void setXueshengEmail(String xueshengEmail) {
			this.xueshengEmail = xueshengEmail;
		}
	//级联表的get和set 职位招聘
		/**
		* 获取：职位招聘 的 公司
		*/
		public Integer getZhaopinGongsiId() {
			return zhaopinGongsiId;
		}
		/**
		* 设置：职位招聘 的 公司
		*/
		public void setZhaopinGongsiId(Integer zhaopinGongsiId) {
			this.zhaopinGongsiId = zhaopinGongsiId;
		}

		/**
		* 获取： 招聘信息名称
		*/
		public String getZhaopinName() {
			return zhaopinName;
		}
		/**
		* 设置： 招聘信息名称
		*/
		public void setZhaopinName(String zhaopinName) {
			this.zhaopinName = zhaopinName;
		}

		/**
		* 获取： 招聘信息照片
		*/
		public String getZhaopinPhoto() {
			return zhaopinPhoto;
		}
		/**
		* 设置： 招聘信息照片
		*/
		public void setZhaopinPhoto(String zhaopinPhoto) {
			this.zhaopinPhoto = zhaopinPhoto;
		}

		/**
		* 获取： 薪资待遇
		*/
		public String getZhaopinDaiyu() {
			return zhaopinDaiyu;
		}
		/**
		* 设置： 薪资待遇
		*/
		public void setZhaopinDaiyu(String zhaopinDaiyu) {
			this.zhaopinDaiyu = zhaopinDaiyu;
		}

		/**
		* 获取： 上班地点
		*/
		public String getZhaopinAddress() {
			return zhaopinAddress;
		}
		/**
		* 设置： 上班地点
		*/
		public void setZhaopinAddress(String zhaopinAddress) {
			this.zhaopinAddress = zhaopinAddress;
		}

		/**
		* 获取： 联系人
		*/
		public String getLianxirenName() {
			return lianxirenName;
		}
		/**
		* 设置： 联系人
		*/
		public void setLianxirenName(String lianxirenName) {
			this.lianxirenName = lianxirenName;
		}

		/**
		* 获取： 招聘电话
		*/
		public String getZhaopinPhone() {
			return zhaopinPhone;
		}
		/**
		* 设置： 招聘电话
		*/
		public void setZhaopinPhone(String zhaopinPhone) {
			this.zhaopinPhone = zhaopinPhone;
		}
		/**
		* 获取： 招聘岗位
		*/
		public Integer getZhaopinTypes() {
			return zhaopinTypes;
		}
		/**
		* 设置： 招聘岗位
		*/
		public void setZhaopinTypes(Integer zhaopinTypes) {
			this.zhaopinTypes = zhaopinTypes;
		}


			/**
			* 获取： 招聘岗位的值
			*/
			public String getZhaopinValue() {
				return zhaopinValue;
			}
			/**
			* 设置： 招聘岗位的值
			*/
			public void setZhaopinValue(String zhaopinValue) {
				this.zhaopinValue = zhaopinValue;
			}
		/**
		* 获取： 招聘类型
		*/
		public Integer getLeixingTypes() {
			return leixingTypes;
		}
		/**
		* 设置： 招聘类型
		*/
		public void setLeixingTypes(Integer leixingTypes) {
			this.leixingTypes = leixingTypes;
		}


			/**
			* 获取： 招聘类型的值
			*/
			public String getLeixingValue() {
				return leixingValue;
			}
			/**
			* 设置： 招聘类型的值
			*/
			public void setLeixingValue(String leixingValue) {
				this.leixingValue = leixingValue;
			}

		/**
		* 获取： 招聘人数
		*/
		public Integer getZhaopinRenshuNumber() {
			return zhaopinRenshuNumber;
		}
		/**
		* 设置： 招聘人数
		*/
		public void setZhaopinRenshuNumber(Integer zhaopinRenshuNumber) {
			this.zhaopinRenshuNumber = zhaopinRenshuNumber;
		}
		/**
		* 获取： 是否上架
		*/
		public Integer getShangxiaTypes() {
			return shangxiaTypes;
		}
		/**
		* 设置： 是否上架
		*/
		public void setShangxiaTypes(Integer shangxiaTypes) {
			this.shangxiaTypes = shangxiaTypes;
		}


			/**
			* 获取： 是否上架的值
			*/
			public String getShangxiaValue() {
				return shangxiaValue;
			}
			/**
			* 设置： 是否上架的值
			*/
			public void setShangxiaValue(String shangxiaValue) {
				this.shangxiaValue = shangxiaValue;
			}

		/**
		* 获取： 招聘信息详情
		*/
		public String getZhaopinContent() {
			return zhaopinContent;
		}
		/**
		* 设置： 招聘信息详情
		*/
		public void setZhaopinContent(String zhaopinContent) {
			this.zhaopinContent = zhaopinContent;
		}


	@Override
	public String toString() {
		return "ZhaopinLiuyanView{" +
			", zhaopinName=" + zhaopinName +
			", zhaopinPhoto=" + zhaopinPhoto +
			", zhaopinDaiyu=" + zhaopinDaiyu +
			", zhaopinAddress=" + zhaopinAddress +
			", lianxirenName=" + lianxirenName +
			", zhaopinPhone=" + zhaopinPhone +
			", zhaopinRenshuNumber=" + zhaopinRenshuNumber +
			", zhaopinContent=" + zhaopinContent +
			", xueshengName=" + xueshengName +
			", xueshengPhone=" + xueshengPhone +
			", xueshengIdNumber=" + xueshengIdNumber +
			", xueshengPhoto=" + xueshengPhoto +
			", xueshengEmail=" + xueshengEmail +
			"} " + super.toString();
	}
}
