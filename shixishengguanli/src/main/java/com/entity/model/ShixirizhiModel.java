package com.entity.model;

import com.entity.ShixirizhiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 实习日志
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ShixirizhiModel implements Serializable {
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
     * 实习日志编号
     */
    private String shixirizhiUuidNumber;


    /**
     * 实习日志标题
     */
    private String shixirizhiName;


    /**
     * 日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date riqiTime;


    /**
     * 实习日志内容
     */
    private String shixirizhiContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show3 listShow
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
	 * 获取：创建时间  show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
