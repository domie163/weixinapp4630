package com.entity.vo;

import com.entity.ShixirizhiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 实习日志
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("shixirizhi")
public class ShixirizhiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 学生
     */

    @TableField(value = "xuesheng_id")
    private Integer xueshengId;


    /**
     * 实习日志编号
     */

    @TableField(value = "shixirizhi_uuid_number")
    private String shixirizhiUuidNumber;


    /**
     * 实习日志标题
     */

    @TableField(value = "shixirizhi_name")
    private String shixirizhiName;


    /**
     * 日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "riqi_time")
    private Date riqiTime;


    /**
     * 实习日志内容
     */

    @TableField(value = "shixirizhi_content")
    private String shixirizhiContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：学生
	 */
    public Integer getXueshengId() {
        return xueshengId;
    }


    /**
	 * 获取：学生
	 */

    public void setXueshengId(Integer xueshengId) {
        this.xueshengId = xueshengId;
    }
    /**
	 * 设置：实习日志编号
	 */
    public String getShixirizhiUuidNumber() {
        return shixirizhiUuidNumber;
    }


    /**
	 * 获取：实习日志编号
	 */

    public void setShixirizhiUuidNumber(String shixirizhiUuidNumber) {
        this.shixirizhiUuidNumber = shixirizhiUuidNumber;
    }
    /**
	 * 设置：实习日志标题
	 */
    public String getShixirizhiName() {
        return shixirizhiName;
    }


    /**
	 * 获取：实习日志标题
	 */

    public void setShixirizhiName(String shixirizhiName) {
        this.shixirizhiName = shixirizhiName;
    }
    /**
	 * 设置：日期
	 */
    public Date getRiqiTime() {
        return riqiTime;
    }


    /**
	 * 获取：日期
	 */

    public void setRiqiTime(Date riqiTime) {
        this.riqiTime = riqiTime;
    }
    /**
	 * 设置：实习日志内容
	 */
    public String getShixirizhiContent() {
        return shixirizhiContent;
    }


    /**
	 * 获取：实习日志内容
	 */

    public void setShixirizhiContent(String shixirizhiContent) {
        this.shixirizhiContent = shixirizhiContent;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
