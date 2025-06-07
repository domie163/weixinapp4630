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
 * 通知
 *
 * @author 
 * @email
 */
@TableName("tongzhi")
public class TongzhiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public TongzhiEntity() {

	}

	public TongzhiEntity(T t) {
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
     * 通知名称
     */
    @ColumnInfo(comment="通知名称",type="varchar(200)")
    @TableField(value = "tongzhi_name")

    private String tongzhiName;


    /**
     * 通知图片
     */
    @ColumnInfo(comment="通知图片",type="varchar(200)")
    @TableField(value = "tongzhi_photo")

    private String tongzhiPhoto;


    /**
     * 附件
     */
    @ColumnInfo(comment="附件",type="varchar(200)")
    @TableField(value = "tongzhi_file")

    private String tongzhiFile;


    /**
     * 通知类型
     */
    @ColumnInfo(comment="通知类型",type="int(11)")
    @TableField(value = "tongzhi_types")

    private Integer tongzhiTypes;


    /**
     * 通知时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="通知时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 通知内容
     */
    @ColumnInfo(comment="通知内容",type="longtext")
    @TableField(value = "tongzhi_content")

    private String tongzhiContent;


    /**
     * 创建时间
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
	 * 获取：通知名称
	 */
    public String getTongzhiName() {
        return tongzhiName;
    }
    /**
	 * 设置：通知名称
	 */

    public void setTongzhiName(String tongzhiName) {
        this.tongzhiName = tongzhiName;
    }
    /**
	 * 获取：通知图片
	 */
    public String getTongzhiPhoto() {
        return tongzhiPhoto;
    }
    /**
	 * 设置：通知图片
	 */

    public void setTongzhiPhoto(String tongzhiPhoto) {
        this.tongzhiPhoto = tongzhiPhoto;
    }
    /**
	 * 获取：附件
	 */
    public String getTongzhiFile() {
        return tongzhiFile;
    }
    /**
	 * 设置：附件
	 */

    public void setTongzhiFile(String tongzhiFile) {
        this.tongzhiFile = tongzhiFile;
    }
    /**
	 * 获取：通知类型
	 */
    public Integer getTongzhiTypes() {
        return tongzhiTypes;
    }
    /**
	 * 设置：通知类型
	 */

    public void setTongzhiTypes(Integer tongzhiTypes) {
        this.tongzhiTypes = tongzhiTypes;
    }
    /**
	 * 获取：通知时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：通知时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：通知内容
	 */
    public String getTongzhiContent() {
        return tongzhiContent;
    }
    /**
	 * 设置：通知内容
	 */

    public void setTongzhiContent(String tongzhiContent) {
        this.tongzhiContent = tongzhiContent;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Tongzhi{" +
            ", id=" + id +
            ", xueshengId=" + xueshengId +
            ", tongzhiName=" + tongzhiName +
            ", tongzhiPhoto=" + tongzhiPhoto +
            ", tongzhiFile=" + tongzhiFile +
            ", tongzhiTypes=" + tongzhiTypes +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", tongzhiContent=" + tongzhiContent +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
