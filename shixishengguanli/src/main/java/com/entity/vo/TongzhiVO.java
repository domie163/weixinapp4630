package com.entity.vo;

import com.entity.TongzhiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 通知
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("tongzhi")
public class TongzhiVO implements Serializable {
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
     * 通知名称
     */

    @TableField(value = "tongzhi_name")
    private String tongzhiName;


    /**
     * 通知图片
     */

    @TableField(value = "tongzhi_photo")
    private String tongzhiPhoto;


    /**
     * 附件
     */

    @TableField(value = "tongzhi_file")
    private String tongzhiFile;


    /**
     * 通知类型
     */

    @TableField(value = "tongzhi_types")
    private Integer tongzhiTypes;


    /**
     * 通知时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 通知内容
     */

    @TableField(value = "tongzhi_content")
    private String tongzhiContent;


    /**
     * 创建时间 show3 nameShow
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
	 * 设置：通知名称
	 */
    public String getTongzhiName() {
        return tongzhiName;
    }


    /**
	 * 获取：通知名称
	 */

    public void setTongzhiName(String tongzhiName) {
        this.tongzhiName = tongzhiName;
    }
    /**
	 * 设置：通知图片
	 */
    public String getTongzhiPhoto() {
        return tongzhiPhoto;
    }


    /**
	 * 获取：通知图片
	 */

    public void setTongzhiPhoto(String tongzhiPhoto) {
        this.tongzhiPhoto = tongzhiPhoto;
    }
    /**
	 * 设置：附件
	 */
    public String getTongzhiFile() {
        return tongzhiFile;
    }


    /**
	 * 获取：附件
	 */

    public void setTongzhiFile(String tongzhiFile) {
        this.tongzhiFile = tongzhiFile;
    }
    /**
	 * 设置：通知类型
	 */
    public Integer getTongzhiTypes() {
        return tongzhiTypes;
    }


    /**
	 * 获取：通知类型
	 */

    public void setTongzhiTypes(Integer tongzhiTypes) {
        this.tongzhiTypes = tongzhiTypes;
    }
    /**
	 * 设置：通知时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：通知时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：通知内容
	 */
    public String getTongzhiContent() {
        return tongzhiContent;
    }


    /**
	 * 获取：通知内容
	 */

    public void setTongzhiContent(String tongzhiContent) {
        this.tongzhiContent = tongzhiContent;
    }
    /**
	 * 设置：创建时间 show3 nameShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 nameShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
