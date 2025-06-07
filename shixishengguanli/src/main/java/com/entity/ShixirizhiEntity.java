package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 实习日志
 *
 * @author 
 * @email
 */
@TableName("shixirizhi")
public class ShixirizhiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShixirizhiEntity() {

	}

	public ShixirizhiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 学生
     */
    @ColumnInfo(comment="学生",type="int(11)")
    @TableField(value = "xuesheng_id")

    private Integer xueshengId;


    /**
     * 实习日志编号
     */
    @ColumnInfo(comment="实习日志编号",type="varchar(200)")
    @TableField(value = "shixirizhi_uuid_number")

    private String shixirizhiUuidNumber;


    /**
     * 实习日志标题
     */
    @ColumnInfo(comment="实习日志标题",type="varchar(200)")
    @TableField(value = "shixirizhi_name")

    private String shixirizhiName;


    /**
     * 日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat
    @ColumnInfo(comment="日期",type="date")
    @TableField(value = "riqi_time")

    private Date riqiTime;


    /**
     * 实习日志内容
     */
    @ColumnInfo(comment="实习日志内容",type="longtext")
    @TableField(value = "shixirizhi_content")

    private String shixirizhiContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间   listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：学生
	 */
    public Integer getXueshengId() {
        return xueshengId;
    }
    /**
	 * 设置：学生
	 */

    public void setXueshengId(Integer xueshengId) {
        this.xueshengId = xueshengId;
    }
    /**
	 * 获取：实习日志编号
	 */
    public String getShixirizhiUuidNumber() {
        return shixirizhiUuidNumber;
    }
    /**
	 * 设置：实习日志编号
	 */

    public void setShixirizhiUuidNumber(String shixirizhiUuidNumber) {
        this.shixirizhiUuidNumber = shixirizhiUuidNumber;
    }
    /**
	 * 获取：实习日志标题
	 */
    public String getShixirizhiName() {
        return shixirizhiName;
    }
    /**
	 * 设置：实习日志标题
	 */

    public void setShixirizhiName(String shixirizhiName) {
        this.shixirizhiName = shixirizhiName;
    }
    /**
	 * 获取：日期
	 */
    public Date getRiqiTime() {
        return riqiTime;
    }
    /**
	 * 设置：日期
	 */

    public void setRiqiTime(Date riqiTime) {
        this.riqiTime = riqiTime;
    }
    /**
	 * 获取：实习日志内容
	 */
    public String getShixirizhiContent() {
        return shixirizhiContent;
    }
    /**
	 * 设置：实习日志内容
	 */

    public void setShixirizhiContent(String shixirizhiContent) {
        this.shixirizhiContent = shixirizhiContent;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间   listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间   listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Shixirizhi{" +
            ", id=" + id +
            ", xueshengId=" + xueshengId +
            ", shixirizhiUuidNumber=" + shixirizhiUuidNumber +
            ", shixirizhiName=" + shixirizhiName +
            ", riqiTime=" + DateUtil.convertString(riqiTime,"yyyy-MM-dd") +
            ", shixirizhiContent=" + shixirizhiContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
