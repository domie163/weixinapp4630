package com.entity.model;

import com.entity.TongzhiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 通知
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class TongzhiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 学生
     */
    private Integer xueshengId;


    /**
     * 通知名称
     */
    private String tongzhiName;


    /**
     * 通知图片
     */
    private String tongzhiPhoto;


    /**
     * 附件
     */
    private String tongzhiFile;


    /**
     * 通知类型
     */
    private Integer tongzhiTypes;


    /**
     * 通知时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 通知内容
     */
    private String tongzhiContent;


    /**
     * 创建时间 show3 nameShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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
	 * 获取：创建时间 show3 nameShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3 nameShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
