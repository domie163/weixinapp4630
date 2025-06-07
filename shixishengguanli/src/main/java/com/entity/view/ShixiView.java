package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ShixiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 实习
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("shixi")
public class ShixiView extends ShixiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 实习类型的值
	*/
	@ColumnInfo(comment="实习类型的字典表值",type="varchar(200)")
	private String shixiValue;
	/**
	* 行业的值
	*/
	@ColumnInfo(comment="行业的字典表值",type="varchar(200)")
	private String hangyeValue;
	/**
	* 所属类型的值
	*/
	@ColumnInfo(comment="所属类型的字典表值",type="varchar(200)")
	private String suoshuleixingValue;
	/**
	* 是否安排带教的值
	*/
	@ColumnInfo(comment="是否安排带教的字典表值",type="varchar(200)")
	private String daijiaoValue;
	/**
	* 补助的值
	*/
	@ColumnInfo(comment="补助的字典表值",type="varchar(200)")
	private String buzhuValue;
	/**
	* 包宿的值
	*/
	@ColumnInfo(comment="包宿的字典表值",type="varchar(200)")
	private String susheValue;
	/**
	* 是否招聘的值
	*/
	@ColumnInfo(comment="是否招聘的字典表值",type="varchar(200)")
	private String zhaopinShifouValue;
	/**
	* 单位满意状态的值
	*/
	@ColumnInfo(comment="单位满意状态的字典表值",type="varchar(200)")
	private String manyiValue;
	/**
	* 考研专业的值
	*/
	@ColumnInfo(comment="考研专业的字典表值",type="varchar(200)")
	private String kaoyanzhuanyeValue;

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



	public ShixiView() {

	}

	public ShixiView(ShixiEntity shixiEntity) {
		try {
			BeanUtils.copyProperties(this, shixiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 实习类型的值
	*/
	public String getShixiValue() {
		return shixiValue;
	}
	/**
	* 设置： 实习类型的值
	*/
	public void setShixiValue(String shixiValue) {
		this.shixiValue = shixiValue;
	}
	//当前表的
	/**
	* 获取： 行业的值
	*/
	public String getHangyeValue() {
		return hangyeValue;
	}
	/**
	* 设置： 行业的值
	*/
	public void setHangyeValue(String hangyeValue) {
		this.hangyeValue = hangyeValue;
	}
	//当前表的
	/**
	* 获取： 所属类型的值
	*/
	public String getSuoshuleixingValue() {
		return suoshuleixingValue;
	}
	/**
	* 设置： 所属类型的值
	*/
	public void setSuoshuleixingValue(String suoshuleixingValue) {
		this.suoshuleixingValue = suoshuleixingValue;
	}
	//当前表的
	/**
	* 获取： 是否安排带教的值
	*/
	public String getDaijiaoValue() {
		return daijiaoValue;
	}
	/**
	* 设置： 是否安排带教的值
	*/
	public void setDaijiaoValue(String daijiaoValue) {
		this.daijiaoValue = daijiaoValue;
	}
	//当前表的
	/**
	* 获取： 补助的值
	*/
	public String getBuzhuValue() {
		return buzhuValue;
	}
	/**
	* 设置： 补助的值
	*/
	public void setBuzhuValue(String buzhuValue) {
		this.buzhuValue = buzhuValue;
	}
	//当前表的
	/**
	* 获取： 包宿的值
	*/
	public String getSusheValue() {
		return susheValue;
	}
	/**
	* 设置： 包宿的值
	*/
	public void setSusheValue(String susheValue) {
		this.susheValue = susheValue;
	}
	//当前表的
	/**
	* 获取： 是否招聘的值
	*/
	public String getZhaopinShifouValue() {
		return zhaopinShifouValue;
	}
	/**
	* 设置： 是否招聘的值
	*/
	public void setZhaopinShifouValue(String zhaopinShifouValue) {
		this.zhaopinShifouValue = zhaopinShifouValue;
	}
	//当前表的
	/**
	* 获取： 单位满意状态的值
	*/
	public String getManyiValue() {
		return manyiValue;
	}
	/**
	* 设置： 单位满意状态的值
	*/
	public void setManyiValue(String manyiValue) {
		this.manyiValue = manyiValue;
	}
	//当前表的
	/**
	* 获取： 考研专业的值
	*/
	public String getKaoyanzhuanyeValue() {
		return kaoyanzhuanyeValue;
	}
	/**
	* 设置： 考研专业的值
	*/
	public void setKaoyanzhuanyeValue(String kaoyanzhuanyeValue) {
		this.kaoyanzhuanyeValue = kaoyanzhuanyeValue;
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


	@Override
	public String toString() {
		return "ShixiView{" +
			", shixiValue=" + shixiValue +
			", hangyeValue=" + hangyeValue +
			", suoshuleixingValue=" + suoshuleixingValue +
			", daijiaoValue=" + daijiaoValue +
			", buzhuValue=" + buzhuValue +
			", susheValue=" + susheValue +
			", zhaopinShifouValue=" + zhaopinShifouValue +
			", manyiValue=" + manyiValue +
			", kaoyanzhuanyeValue=" + kaoyanzhuanyeValue +
			", xueshengName=" + xueshengName +
			", xueshengPhone=" + xueshengPhone +
			", xueshengIdNumber=" + xueshengIdNumber +
			", xueshengPhoto=" + xueshengPhoto +
			", xueshengEmail=" + xueshengEmail +
			"} " + super.toString();
	}
}
