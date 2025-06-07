package com.entity.model;

import com.entity.ShixiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 实习
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ShixiModel implements Serializable {
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
     * 实习编号
     */
    private String shixiUuidNumber;


    /**
     * 实习名称
     */
    private String shixiName;


    /**
     * 实习类型
     */
    private Integer shixiTypes;


    /**
     * 实习单位
     */
    private String shixiDanweimingcheng;


    /**
     * 行业
     */
    private Integer hangyeTypes;


    /**
     * 所属类型
     */
    private Integer suoshuleixingTypes;


    /**
     * 企业规模
     */
    private String qiyeGuimo;


    /**
     * 单位地址
     */
    private String shixiDanweidizhi;


    /**
     * 进入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date jinruTime;


    /**
     * 实习岗位
     */
    private String shixiGangwei;


    /**
     * 岗位培养方向
     */
    private String shixiGangweiFangxiang;


    /**
     * 是否安排带教
     */
    private Integer daijiaoTypes;


    /**
     * 补助
     */
    private Integer buzhuTypes;


    /**
     * 包宿
     */
    private Integer susheTypes;


    /**
     * 薪资
     */
    private Double xinzi;


    /**
     * 现住地址
     */
    private String xianzhuAddress;


    /**
     * 同公司校友情况
     */
    private String tonggongsixiaoyouContent;


    /**
     * 是否招聘
     */
    private Integer zhaopinTypes;


    /**
     * 单位专业评价
     */
    private String danweizhuanyeContent;


    /**
     * 单位人事评价
     */
    private String danweirenshiContent;


    /**
     * 单位满意状态
     */
    private Integer manyiTypes;


    /**
     * 考研学校
     */
    private String shixiKaoyanxuexiao;


    /**
     * 考研专业
     */
    private Integer kaoyanzhuanyeTypes;


    /**
     * 方向
     */
    private String shixiKaoyanfangxiang;


    /**
     * 考公地区
     */
    private String shixiKaogongdiqu;


    /**
     * 职位
     */
    private String shixiKaogongzhiwei;


    /**
     * 考公时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date kaogongTime;


    /**
     * 留学国家
     */
    private String shixiLiuxue;


    /**
     * 留学大学
     */
    private String shixiLiuxueDaxue;


    /**
     * 留学单位
     */
    private String shixiLiuxueDanwei;


    /**
     * 备注
     */
    private String shixiContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间    show3 listShow
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
    public Integer getZhaopinTypes() {
        return zhaopinTypes;
    }


    /**
	 * 设置：是否招聘
	 */
    public void setZhaopinTypes(Integer zhaopinTypes) {
        this.zhaopinTypes = zhaopinTypes;
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
	 * 获取：创建时间    show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间    show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
