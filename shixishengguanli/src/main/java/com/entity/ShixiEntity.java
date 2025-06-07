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
 * 实习
 *
 * @author 
 * @email
 */
@TableName("shixi")
public class ShixiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShixiEntity() {

	}

	public ShixiEntity(T t) {
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
     * 实习编号
     */
    @ColumnInfo(comment="实习编号",type="varchar(200)")
    @TableField(value = "shixi_uuid_number")

    private String shixiUuidNumber;


    /**
     * 实习名称
     */
    @ColumnInfo(comment="实习名称",type="varchar(200)")
    @TableField(value = "shixi_name")

    private String shixiName;


    /**
     * 实习类型
     */
    @ColumnInfo(comment="实习类型",type="int(11)")
    @TableField(value = "shixi_types")

    private Integer shixiTypes;


    /**
     * 实习单位
     */
    @ColumnInfo(comment="实习单位",type="varchar(200)")
    @TableField(value = "shixi_danweimingcheng")

    private String shixiDanweimingcheng;


    /**
     * 行业
     */
    @ColumnInfo(comment="行业",type="int(11)")
    @TableField(value = "hangye_types")

    private Integer hangyeTypes;


    /**
     * 所属类型
     */
    @ColumnInfo(comment="所属类型",type="int(11)")
    @TableField(value = "suoshuleixing_types")

    private Integer suoshuleixingTypes;


    /**
     * 企业规模
     */
    @ColumnInfo(comment="企业规模",type="varchar(200)")
    @TableField(value = "qiye_guimo")

    private String qiyeGuimo;


    /**
     * 单位地址
     */
    @ColumnInfo(comment="单位地址",type="varchar(200)")
    @TableField(value = "shixi_danweidizhi")

    private String shixiDanweidizhi;


    /**
     * 进入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="进入时间",type="timestamp")
    @TableField(value = "jinru_time")

    private Date jinruTime;


    /**
     * 实习岗位
     */
    @ColumnInfo(comment="实习岗位",type="varchar(200)")
    @TableField(value = "shixi_gangwei")

    private String shixiGangwei;


    /**
     * 岗位培养方向
     */
    @ColumnInfo(comment="岗位培养方向",type="varchar(200)")
    @TableField(value = "shixi_gangwei_fangxiang")

    private String shixiGangweiFangxiang;


    /**
     * 是否安排带教
     */
    @ColumnInfo(comment="是否安排带教",type="int(11)")
    @TableField(value = "daijiao_types")

    private Integer daijiaoTypes;


    /**
     * 补助
     */
    @ColumnInfo(comment="补助",type="int(11)")
    @TableField(value = "buzhu_types")

    private Integer buzhuTypes;


    /**
     * 包宿
     */
    @ColumnInfo(comment="包宿",type="int(11)")
    @TableField(value = "sushe_types")

    private Integer susheTypes;


    /**
     * 薪资
     */
    @ColumnInfo(comment="薪资",type="decimal(10,2)")
    @TableField(value = "xinzi")

    private Double xinzi;


    /**
     * 现住地址
     */
    @ColumnInfo(comment="现住地址",type="varchar(200)")
    @TableField(value = "xianzhu_address")

    private String xianzhuAddress;


    /**
     * 同公司校友情况
     */
    @ColumnInfo(comment="同公司校友情况",type="longtext")
    @TableField(value = "tonggongsixiaoyou_content")

    private String tonggongsixiaoyouContent;


    /**
     * 是否招聘
     */
    @ColumnInfo(comment="是否招聘",type="int(11)")
    @TableField(value = "zhaopin_shifou_types")

    private Integer zhaopinShifouTypes;


    /**
     * 单位专业评价
     */
    @ColumnInfo(comment="单位专业评价",type="longtext")
    @TableField(value = "danweizhuanye_content")

    private String danweizhuanyeContent;


    /**
     * 单位人事评价
     */
    @ColumnInfo(comment="单位人事评价",type="longtext")
    @TableField(value = "danweirenshi_content")

    private String danweirenshiContent;


    /**
     * 单位满意状态
     */
    @ColumnInfo(comment="单位满意状态",type="int(11)")
    @TableField(value = "manyi_types")

    private Integer manyiTypes;


    /**
     * 考研学校
     */
    @ColumnInfo(comment="考研学校",type="varchar(200)")
    @TableField(value = "shixi_kaoyanxuexiao")

    private String shixiKaoyanxuexiao;


    /**
     * 考研专业
     */
    @ColumnInfo(comment="考研专业",type="int(11)")
    @TableField(value = "kaoyanzhuanye_types")

    private Integer kaoyanzhuanyeTypes;


    /**
     * 方向
     */
    @ColumnInfo(comment="方向",type="varchar(200)")
    @TableField(value = "shixi_kaoyanfangxiang")

    private String shixiKaoyanfangxiang;


    /**
     * 考公地区
     */
    @ColumnInfo(comment="考公地区",type="varchar(200)")
    @TableField(value = "shixi_kaogongdiqu")

    private String shixiKaogongdiqu;


    /**
     * 职位
     */
    @ColumnInfo(comment="职位",type="varchar(200)")
    @TableField(value = "shixi_kaogongzhiwei")

    private String shixiKaogongzhiwei;


    /**
     * 考公时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="考公时间",type="timestamp")
    @TableField(value = "kaogong_time")

    private Date kaogongTime;


    /**
     * 留学国家
     */
    @ColumnInfo(comment="留学国家",type="varchar(200)")
    @TableField(value = "shixi_liuxue")

    private String shixiLiuxue;


    /**
     * 留学大学
     */
    @ColumnInfo(comment="留学大学",type="varchar(200)")
    @TableField(value = "shixi_liuxue_daxue")

    private String shixiLiuxueDaxue;


    /**
     * 留学单位
     */
    @ColumnInfo(comment="留学单位",type="varchar(200)")
    @TableField(value = "shixi_liuxue_danwei")

    private String shixiLiuxueDanwei;


    /**
     * 备注
     */
    @ColumnInfo(comment="备注",type="longtext")
    @TableField(value = "shixi_content")

    private String shixiContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间     listShow
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
	 * 获取：实习编号
	 */
    public String getShixiUuidNumber() {
        return shixiUuidNumber;
    }
    /**
	 * 设置：实习编号
	 */

    public void setShixiUuidNumber(String shixiUuidNumber) {
        this.shixiUuidNumber = shixiUuidNumber;
    }
    /**
	 * 获取：实习名称
	 */
    public String getShixiName() {
        return shixiName;
    }
    /**
	 * 设置：实习名称
	 */

    public void setShixiName(String shixiName) {
        this.shixiName = shixiName;
    }
    /**
	 * 获取：实习类型
	 */
    public Integer getShixiTypes() {
        return shixiTypes;
    }
    /**
	 * 设置：实习类型
	 */

    public void setShixiTypes(Integer shixiTypes) {
        this.shixiTypes = shixiTypes;
    }
    /**
	 * 获取：实习单位
	 */
    public String getShixiDanweimingcheng() {
        return shixiDanweimingcheng;
    }
    /**
	 * 设置：实习单位
	 */

    public void setShixiDanweimingcheng(String shixiDanweimingcheng) {
        this.shixiDanweimingcheng = shixiDanweimingcheng;
    }
    /**
	 * 获取：行业
	 */
    public Integer getHangyeTypes() {
        return hangyeTypes;
    }
    /**
	 * 设置：行业
	 */

    public void setHangyeTypes(Integer hangyeTypes) {
        this.hangyeTypes = hangyeTypes;
    }
    /**
	 * 获取：所属类型
	 */
    public Integer getSuoshuleixingTypes() {
        return suoshuleixingTypes;
    }
    /**
	 * 设置：所属类型
	 */

    public void setSuoshuleixingTypes(Integer suoshuleixingTypes) {
        this.suoshuleixingTypes = suoshuleixingTypes;
    }
    /**
	 * 获取：企业规模
	 */
    public String getQiyeGuimo() {
        return qiyeGuimo;
    }
    /**
	 * 设置：企业规模
	 */

    public void setQiyeGuimo(String qiyeGuimo) {
        this.qiyeGuimo = qiyeGuimo;
    }
    /**
	 * 获取：单位地址
	 */
    public String getShixiDanweidizhi() {
        return shixiDanweidizhi;
    }
    /**
	 * 设置：单位地址
	 */

    public void setShixiDanweidizhi(String shixiDanweidizhi) {
        this.shixiDanweidizhi = shixiDanweidizhi;
    }
    /**
	 * 获取：进入时间
	 */
    public Date getJinruTime() {
        return jinruTime;
    }
    /**
	 * 设置：进入时间
	 */

    public void setJinruTime(Date jinruTime) {
        this.jinruTime = jinruTime;
    }
    /**
	 * 获取：实习岗位
	 */
    public String getShixiGangwei() {
        return shixiGangwei;
    }
    /**
	 * 设置：实习岗位
	 */

    public void setShixiGangwei(String shixiGangwei) {
        this.shixiGangwei = shixiGangwei;
    }
    /**
	 * 获取：岗位培养方向
	 */
    public String getShixiGangweiFangxiang() {
        return shixiGangweiFangxiang;
    }
    /**
	 * 设置：岗位培养方向
	 */

    public void setShixiGangweiFangxiang(String shixiGangweiFangxiang) {
        this.shixiGangweiFangxiang = shixiGangweiFangxiang;
    }
    /**
	 * 获取：是否安排带教
	 */
    public Integer getDaijiaoTypes() {
        return daijiaoTypes;
    }
    /**
	 * 设置：是否安排带教
	 */

    public void setDaijiaoTypes(Integer daijiaoTypes) {
        this.daijiaoTypes = daijiaoTypes;
    }
    /**
	 * 获取：补助
	 */
    public Integer getBuzhuTypes() {
        return buzhuTypes;
    }
    /**
	 * 设置：补助
	 */

    public void setBuzhuTypes(Integer buzhuTypes) {
        this.buzhuTypes = buzhuTypes;
    }
    /**
	 * 获取：包宿
	 */
    public Integer getSusheTypes() {
        return susheTypes;
    }
    /**
	 * 设置：包宿
	 */

    public void setSusheTypes(Integer susheTypes) {
        this.susheTypes = susheTypes;
    }
    /**
	 * 获取：薪资
	 */
    public Double getXinzi() {
        return xinzi;
    }
    /**
	 * 设置：薪资
	 */

    public void setXinzi(Double xinzi) {
        this.xinzi = xinzi;
    }
    /**
	 * 获取：现住地址
	 */
    public String getXianzhuAddress() {
        return xianzhuAddress;
    }
    /**
	 * 设置：现住地址
	 */

    public void setXianzhuAddress(String xianzhuAddress) {
        this.xianzhuAddress = xianzhuAddress;
    }
    /**
	 * 获取：同公司校友情况
	 */
    public String getTonggongsixiaoyouContent() {
        return tonggongsixiaoyouContent;
    }
    /**
	 * 设置：同公司校友情况
	 */

    public void setTonggongsixiaoyouContent(String tonggongsixiaoyouContent) {
        this.tonggongsixiaoyouContent = tonggongsixiaoyouContent;
    }
    /**
	 * 获取：是否招聘
	 */
    public Integer getZhaopinShifouTypes() {
        return zhaopinShifouTypes;
    }
    /**
	 * 设置：是否招聘
	 */

    public void setZhaopinShifouTypes(Integer zhaopinShifouTypes) {
        this.zhaopinShifouTypes = zhaopinShifouTypes;
    }
    /**
	 * 获取：单位专业评价
	 */
    public String getDanweizhuanyeContent() {
        return danweizhuanyeContent;
    }
    /**
	 * 设置：单位专业评价
	 */

    public void setDanweizhuanyeContent(String danweizhuanyeContent) {
        this.danweizhuanyeContent = danweizhuanyeContent;
    }
    /**
	 * 获取：单位人事评价
	 */
    public String getDanweirenshiContent() {
        return danweirenshiContent;
    }
    /**
	 * 设置：单位人事评价
	 */

    public void setDanweirenshiContent(String danweirenshiContent) {
        this.danweirenshiContent = danweirenshiContent;
    }
    /**
	 * 获取：单位满意状态
	 */
    public Integer getManyiTypes() {
        return manyiTypes;
    }
    /**
	 * 设置：单位满意状态
	 */

    public void setManyiTypes(Integer manyiTypes) {
        this.manyiTypes = manyiTypes;
    }
    /**
	 * 获取：考研学校
	 */
    public String getShixiKaoyanxuexiao() {
        return shixiKaoyanxuexiao;
    }
    /**
	 * 设置：考研学校
	 */

    public void setShixiKaoyanxuexiao(String shixiKaoyanxuexiao) {
        this.shixiKaoyanxuexiao = shixiKaoyanxuexiao;
    }
    /**
	 * 获取：考研专业
	 */
    public Integer getKaoyanzhuanyeTypes() {
        return kaoyanzhuanyeTypes;
    }
    /**
	 * 设置：考研专业
	 */

    public void setKaoyanzhuanyeTypes(Integer kaoyanzhuanyeTypes) {
        this.kaoyanzhuanyeTypes = kaoyanzhuanyeTypes;
    }
    /**
	 * 获取：方向
	 */
    public String getShixiKaoyanfangxiang() {
        return shixiKaoyanfangxiang;
    }
    /**
	 * 设置：方向
	 */

    public void setShixiKaoyanfangxiang(String shixiKaoyanfangxiang) {
        this.shixiKaoyanfangxiang = shixiKaoyanfangxiang;
    }
    /**
	 * 获取：考公地区
	 */
    public String getShixiKaogongdiqu() {
        return shixiKaogongdiqu;
    }
    /**
	 * 设置：考公地区
	 */

    public void setShixiKaogongdiqu(String shixiKaogongdiqu) {
        this.shixiKaogongdiqu = shixiKaogongdiqu;
    }
    /**
	 * 获取：职位
	 */
    public String getShixiKaogongzhiwei() {
        return shixiKaogongzhiwei;
    }
    /**
	 * 设置：职位
	 */

    public void setShixiKaogongzhiwei(String shixiKaogongzhiwei) {
        this.shixiKaogongzhiwei = shixiKaogongzhiwei;
    }
    /**
	 * 获取：考公时间
	 */
    public Date getKaogongTime() {
        return kaogongTime;
    }
    /**
	 * 设置：考公时间
	 */

    public void setKaogongTime(Date kaogongTime) {
        this.kaogongTime = kaogongTime;
    }
    /**
	 * 获取：留学国家
	 */
    public String getShixiLiuxue() {
        return shixiLiuxue;
    }
    /**
	 * 设置：留学国家
	 */

    public void setShixiLiuxue(String shixiLiuxue) {
        this.shixiLiuxue = shixiLiuxue;
    }
    /**
	 * 获取：留学大学
	 */
    public String getShixiLiuxueDaxue() {
        return shixiLiuxueDaxue;
    }
    /**
	 * 设置：留学大学
	 */

    public void setShixiLiuxueDaxue(String shixiLiuxueDaxue) {
        this.shixiLiuxueDaxue = shixiLiuxueDaxue;
    }
    /**
	 * 获取：留学单位
	 */
    public String getShixiLiuxueDanwei() {
        return shixiLiuxueDanwei;
    }
    /**
	 * 设置：留学单位
	 */

    public void setShixiLiuxueDanwei(String shixiLiuxueDanwei) {
        this.shixiLiuxueDanwei = shixiLiuxueDanwei;
    }
    /**
	 * 获取：备注
	 */
    public String getShixiContent() {
        return shixiContent;
    }
    /**
	 * 设置：备注
	 */

    public void setShixiContent(String shixiContent) {
        this.shixiContent = shixiContent;
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
	 * 获取：创建时间     listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间     listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Shixi{" +
            ", id=" + id +
            ", xueshengId=" + xueshengId +
            ", shixiUuidNumber=" + shixiUuidNumber +
            ", shixiName=" + shixiName +
            ", shixiTypes=" + shixiTypes +
            ", shixiDanweimingcheng=" + shixiDanweimingcheng +
            ", hangyeTypes=" + hangyeTypes +
            ", suoshuleixingTypes=" + suoshuleixingTypes +
            ", qiyeGuimo=" + qiyeGuimo +
            ", shixiDanweidizhi=" + shixiDanweidizhi +
            ", jinruTime=" + DateUtil.convertString(jinruTime,"yyyy-MM-dd") +
            ", shixiGangwei=" + shixiGangwei +
            ", shixiGangweiFangxiang=" + shixiGangweiFangxiang +
            ", daijiaoTypes=" + daijiaoTypes +
            ", buzhuTypes=" + buzhuTypes +
            ", susheTypes=" + susheTypes +
            ", xinzi=" + xinzi +
            ", xianzhuAddress=" + xianzhuAddress +
            ", tonggongsixiaoyouContent=" + tonggongsixiaoyouContent +
            ", zhaopinShifouTypes=" + zhaopinShifouTypes +
            ", danweizhuanyeContent=" + danweizhuanyeContent +
            ", danweirenshiContent=" + danweirenshiContent +
            ", manyiTypes=" + manyiTypes +
            ", shixiKaoyanxuexiao=" + shixiKaoyanxuexiao +
            ", kaoyanzhuanyeTypes=" + kaoyanzhuanyeTypes +
            ", shixiKaoyanfangxiang=" + shixiKaoyanfangxiang +
            ", shixiKaogongdiqu=" + shixiKaogongdiqu +
            ", shixiKaogongzhiwei=" + shixiKaogongzhiwei +
            ", kaogongTime=" + DateUtil.convertString(kaogongTime,"yyyy-MM-dd") +
            ", shixiLiuxue=" + shixiLiuxue +
            ", shixiLiuxueDaxue=" + shixiLiuxueDaxue +
            ", shixiLiuxueDanwei=" + shixiLiuxueDanwei +
            ", shixiContent=" + shixiContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
