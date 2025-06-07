package com.entity.vo;

import com.entity.ShixiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 实习
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("shixi")
public class ShixiVO implements Serializable {
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
     * 实习编号
     */

    @TableField(value = "shixi_uuid_number")
    private String shixiUuidNumber;


    /**
     * 实习名称
     */

    @TableField(value = "shixi_name")
    private String shixiName;


    /**
     * 实习类型
     */

    @TableField(value = "shixi_types")
    private Integer shixiTypes;


    /**
     * 实习单位
     */

    @TableField(value = "shixi_danweimingcheng")
    private String shixiDanweimingcheng;


    /**
     * 行业
     */

    @TableField(value = "hangye_types")
    private Integer hangyeTypes;


    /**
     * 所属类型
     */

    @TableField(value = "suoshuleixing_types")
    private Integer suoshuleixingTypes;


    /**
     * 企业规模
     */

    @TableField(value = "qiye_guimo")
    private String qiyeGuimo;


    /**
     * 单位地址
     */

    @TableField(value = "shixi_danweidizhi")
    private String shixiDanweidizhi;


    /**
     * 进入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "jinru_time")
    private Date jinruTime;


    /**
     * 实习岗位
     */

    @TableField(value = "shixi_gangwei")
    private String shixiGangwei;


    /**
     * 岗位培养方向
     */

    @TableField(value = "shixi_gangwei_fangxiang")
    private String shixiGangweiFangxiang;


    /**
     * 是否安排带教
     */

    @TableField(value = "daijiao_types")
    private Integer daijiaoTypes;


    /**
     * 补助
     */

    @TableField(value = "buzhu_types")
    private Integer buzhuTypes;


    /**
     * 包宿
     */

    @TableField(value = "sushe_types")
    private Integer susheTypes;


    /**
     * 薪资
     */

    @TableField(value = "xinzi")
    private Double xinzi;


    /**
     * 现住地址
     */

    @TableField(value = "xianzhu_address")
    private String xianzhuAddress;


    /**
     * 同公司校友情况
     */

    @TableField(value = "tonggongsixiaoyou_content")
    private String tonggongsixiaoyouContent;


    /**
     * 是否招聘
     */

    @TableField(value = "zhaopin_types")
    private Integer zhaopinTypes;


    /**
     * 单位专业评价
     */

    @TableField(value = "danweizhuanye_content")
    private String danweizhuanyeContent;


    /**
     * 单位人事评价
     */

    @TableField(value = "danweirenshi_content")
    private String danweirenshiContent;


    /**
     * 单位满意状态
     */

    @TableField(value = "manyi_types")
    private Integer manyiTypes;


    /**
     * 考研学校
     */

    @TableField(value = "shixi_kaoyanxuexiao")
    private String shixiKaoyanxuexiao;


    /**
     * 考研专业
     */

    @TableField(value = "kaoyanzhuanye_types")
    private Integer kaoyanzhuanyeTypes;


    /**
     * 方向
     */

    @TableField(value = "shixi_kaoyanfangxiang")
    private String shixiKaoyanfangxiang;


    /**
     * 考公地区
     */

    @TableField(value = "shixi_kaogongdiqu")
    private String shixiKaogongdiqu;


    /**
     * 职位
     */

    @TableField(value = "shixi_kaogongzhiwei")
    private String shixiKaogongzhiwei;


    /**
     * 考公时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "kaogong_time")
    private Date kaogongTime;


    /**
     * 留学国家
     */

    @TableField(value = "shixi_liuxue")
    private String shixiLiuxue;


    /**
     * 留学大学
     */

    @TableField(value = "shixi_liuxue_daxue")
    private String shixiLiuxueDaxue;


    /**
     * 留学单位
     */

    @TableField(value = "shixi_liuxue_danwei")
    private String shixiLiuxueDanwei;


    /**
     * 备注
     */

    @TableField(value = "shixi_content")
    private String shixiContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间    show3 listShow
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
	 * 设置：实习编号
	 */
    public String getShixiUuidNumber() {
        return shixiUuidNumber;
    }


    /**
	 * 获取：实习编号
	 */

    public void setShixiUuidNumber(String shixiUuidNumber) {
        this.shixiUuidNumber = shixiUuidNumber;
    }
    /**
	 * 设置：实习名称
	 */
    public String getShixiName() {
        return shixiName;
    }


    /**
	 * 获取：实习名称
	 */

    public void setShixiName(String shixiName) {
        this.shixiName = shixiName;
    }
    /**
	 * 设置：实习类型
	 */
    public Integer getShixiTypes() {
        return shixiTypes;
    }


    /**
	 * 获取：实习类型
	 */

    public void setShixiTypes(Integer shixiTypes) {
        this.shixiTypes = shixiTypes;
    }
    /**
	 * 设置：实习单位
	 */
    public String getShixiDanweimingcheng() {
        return shixiDanweimingcheng;
    }


    /**
	 * 获取：实习单位
	 */

    public void setShixiDanweimingcheng(String shixiDanweimingcheng) {
        this.shixiDanweimingcheng = shixiDanweimingcheng;
    }
    /**
	 * 设置：行业
	 */
    public Integer getHangyeTypes() {
        return hangyeTypes;
    }


    /**
	 * 获取：行业
	 */

    public void setHangyeTypes(Integer hangyeTypes) {
        this.hangyeTypes = hangyeTypes;
    }
    /**
	 * 设置：所属类型
	 */
    public Integer getSuoshuleixingTypes() {
        return suoshuleixingTypes;
    }


    /**
	 * 获取：所属类型
	 */

    public void setSuoshuleixingTypes(Integer suoshuleixingTypes) {
        this.suoshuleixingTypes = suoshuleixingTypes;
    }
    /**
	 * 设置：企业规模
	 */
    public String getQiyeGuimo() {
        return qiyeGuimo;
    }


    /**
	 * 获取：企业规模
	 */

    public void setQiyeGuimo(String qiyeGuimo) {
        this.qiyeGuimo = qiyeGuimo;
    }
    /**
	 * 设置：单位地址
	 */
    public String getShixiDanweidizhi() {
        return shixiDanweidizhi;
    }


    /**
	 * 获取：单位地址
	 */

    public void setShixiDanweidizhi(String shixiDanweidizhi) {
        this.shixiDanweidizhi = shixiDanweidizhi;
    }
    /**
	 * 设置：进入时间
	 */
    public Date getJinruTime() {
        return jinruTime;
    }


    /**
	 * 获取：进入时间
	 */

    public void setJinruTime(Date jinruTime) {
        this.jinruTime = jinruTime;
    }
    /**
	 * 设置：实习岗位
	 */
    public String getShixiGangwei() {
        return shixiGangwei;
    }


    /**
	 * 获取：实习岗位
	 */

    public void setShixiGangwei(String shixiGangwei) {
        this.shixiGangwei = shixiGangwei;
    }
    /**
	 * 设置：岗位培养方向
	 */
    public String getShixiGangweiFangxiang() {
        return shixiGangweiFangxiang;
    }


    /**
	 * 获取：岗位培养方向
	 */

    public void setShixiGangweiFangxiang(String shixiGangweiFangxiang) {
        this.shixiGangweiFangxiang = shixiGangweiFangxiang;
    }
    /**
	 * 设置：是否安排带教
	 */
    public Integer getDaijiaoTypes() {
        return daijiaoTypes;
    }


    /**
	 * 获取：是否安排带教
	 */

    public void setDaijiaoTypes(Integer daijiaoTypes) {
        this.daijiaoTypes = daijiaoTypes;
    }
    /**
	 * 设置：补助
	 */
    public Integer getBuzhuTypes() {
        return buzhuTypes;
    }


    /**
	 * 获取：补助
	 */

    public void setBuzhuTypes(Integer buzhuTypes) {
        this.buzhuTypes = buzhuTypes;
    }
    /**
	 * 设置：包宿
	 */
    public Integer getSusheTypes() {
        return susheTypes;
    }


    /**
	 * 获取：包宿
	 */

    public void setSusheTypes(Integer susheTypes) {
        this.susheTypes = susheTypes;
    }
    /**
	 * 设置：薪资
	 */
    public Double getXinzi() {
        return xinzi;
    }


    /**
	 * 获取：薪资
	 */

    public void setXinzi(Double xinzi) {
        this.xinzi = xinzi;
    }
    /**
	 * 设置：现住地址
	 */
    public String getXianzhuAddress() {
        return xianzhuAddress;
    }


    /**
	 * 获取：现住地址
	 */

    public void setXianzhuAddress(String xianzhuAddress) {
        this.xianzhuAddress = xianzhuAddress;
    }
    /**
	 * 设置：同公司校友情况
	 */
    public String getTonggongsixiaoyouContent() {
        return tonggongsixiaoyouContent;
    }


    /**
	 * 获取：同公司校友情况
	 */

    public void setTonggongsixiaoyouContent(String tonggongsixiaoyouContent) {
        this.tonggongsixiaoyouContent = tonggongsixiaoyouContent;
    }
    /**
	 * 设置：是否招聘
	 */
    public Integer getZhaopinTypes() {
        return zhaopinTypes;
    }


    /**
	 * 获取：是否招聘
	 */

    public void setZhaopinTypes(Integer zhaopinTypes) {
        this.zhaopinTypes = zhaopinTypes;
    }
    /**
	 * 设置：单位专业评价
	 */
    public String getDanweizhuanyeContent() {
        return danweizhuanyeContent;
    }


    /**
	 * 获取：单位专业评价
	 */

    public void setDanweizhuanyeContent(String danweizhuanyeContent) {
        this.danweizhuanyeContent = danweizhuanyeContent;
    }
    /**
	 * 设置：单位人事评价
	 */
    public String getDanweirenshiContent() {
        return danweirenshiContent;
    }


    /**
	 * 获取：单位人事评价
	 */

    public void setDanweirenshiContent(String danweirenshiContent) {
        this.danweirenshiContent = danweirenshiContent;
    }
    /**
	 * 设置：单位满意状态
	 */
    public Integer getManyiTypes() {
        return manyiTypes;
    }


    /**
	 * 获取：单位满意状态
	 */

    public void setManyiTypes(Integer manyiTypes) {
        this.manyiTypes = manyiTypes;
    }
    /**
	 * 设置：考研学校
	 */
    public String getShixiKaoyanxuexiao() {
        return shixiKaoyanxuexiao;
    }


    /**
	 * 获取：考研学校
	 */

    public void setShixiKaoyanxuexiao(String shixiKaoyanxuexiao) {
        this.shixiKaoyanxuexiao = shixiKaoyanxuexiao;
    }
    /**
	 * 设置：考研专业
	 */
    public Integer getKaoyanzhuanyeTypes() {
        return kaoyanzhuanyeTypes;
    }


    /**
	 * 获取：考研专业
	 */

    public void setKaoyanzhuanyeTypes(Integer kaoyanzhuanyeTypes) {
        this.kaoyanzhuanyeTypes = kaoyanzhuanyeTypes;
    }
    /**
	 * 设置：方向
	 */
    public String getShixiKaoyanfangxiang() {
        return shixiKaoyanfangxiang;
    }


    /**
	 * 获取：方向
	 */

    public void setShixiKaoyanfangxiang(String shixiKaoyanfangxiang) {
        this.shixiKaoyanfangxiang = shixiKaoyanfangxiang;
    }
    /**
	 * 设置：考公地区
	 */
    public String getShixiKaogongdiqu() {
        return shixiKaogongdiqu;
    }


    /**
	 * 获取：考公地区
	 */

    public void setShixiKaogongdiqu(String shixiKaogongdiqu) {
        this.shixiKaogongdiqu = shixiKaogongdiqu;
    }
    /**
	 * 设置：职位
	 */
    public String getShixiKaogongzhiwei() {
        return shixiKaogongzhiwei;
    }


    /**
	 * 获取：职位
	 */

    public void setShixiKaogongzhiwei(String shixiKaogongzhiwei) {
        this.shixiKaogongzhiwei = shixiKaogongzhiwei;
    }
    /**
	 * 设置：考公时间
	 */
    public Date getKaogongTime() {
        return kaogongTime;
    }


    /**
	 * 获取：考公时间
	 */

    public void setKaogongTime(Date kaogongTime) {
        this.kaogongTime = kaogongTime;
    }
    /**
	 * 设置：留学国家
	 */
    public String getShixiLiuxue() {
        return shixiLiuxue;
    }


    /**
	 * 获取：留学国家
	 */

    public void setShixiLiuxue(String shixiLiuxue) {
        this.shixiLiuxue = shixiLiuxue;
    }
    /**
	 * 设置：留学大学
	 */
    public String getShixiLiuxueDaxue() {
        return shixiLiuxueDaxue;
    }


    /**
	 * 获取：留学大学
	 */

    public void setShixiLiuxueDaxue(String shixiLiuxueDaxue) {
        this.shixiLiuxueDaxue = shixiLiuxueDaxue;
    }
    /**
	 * 设置：留学单位
	 */
    public String getShixiLiuxueDanwei() {
        return shixiLiuxueDanwei;
    }


    /**
	 * 获取：留学单位
	 */

    public void setShixiLiuxueDanwei(String shixiLiuxueDanwei) {
        this.shixiLiuxueDanwei = shixiLiuxueDanwei;
    }
    /**
	 * 设置：备注
	 */
    public String getShixiContent() {
        return shixiContent;
    }


    /**
	 * 获取：备注
	 */

    public void setShixiContent(String shixiContent) {
        this.shixiContent = shixiContent;
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
	 * 设置：创建时间    show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间    show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
