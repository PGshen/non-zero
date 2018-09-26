package space.zero.business.module.official.website.model;

import space.zero.core.model.BaseEntity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "official_website_recruit")
public class OfficialWebsiteRecruit extends BaseEntity {
    /**
     * 招聘信息id
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 职位名称
     */
    @Column(name = "CAPACITY_NAME")
    private String capacityName;

    /**
     * 职位类别（外键）
     */
    @Column(name = "CAPACITY_CLASS")
    private String capacityClass;

    /**
     * 部门
     */
    @Column(name = "DEPARTMENT")
    private String department;

    /**
     * 工作地点
     */
    @Column(name = "JOB_STATION")
    private String jobStation;

    /**
     * 工作性质
     */
    @Column(name = "JOB_KIND")
    private String jobKind;

    /**
     * 招聘人数
     */
    @Column(name = "RECRUIT_NUM")
    private String recruitNum;

    /**
     * 薪资
     */
    @Column(name = "SALARY")
    private String salary;

    /**
     * 发布时间
     */
    @Column(name = "RELEASE_TIME")
    private Date releaseTime;

    /**
     * 工作职责
     */
    @Column(name = "JOB_DUTIES")
    private String jobDuties;

    /**
     * 任职资格
     */
    @Column(name = "JOB_QUALIFICATION")
    private String jobQualification;

    /**
     * 投送邮箱
     */
    @Column(name = "DELIVERY_EMAIL")
    private String deliveryEmail;

    /**
     * 启用标识 1：启用 0：不启用
     */
    @Column(name = "IS_ENABLE")
    private String isEnable;

    /**
     * 删除标识 1：删除 0：未删除
     */
    @Column(name = "IS_DELETE")
    private String isDelete;

    /**
     * 更新时间
     */
    @Column(name = "UPDATE_TIME")
    private Date updateTime;

    /**
     * 创建时间
     */
    @Column(name = "CREATED_TIME")
    private Date createdTime;

    /**
     * 最近修改人
     */
    @Column(name = "UPDATE_USER")
    private String updateUser;

    /**
     * 获取招聘信息id
     *
     * @return ID - 招聘信息id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置招聘信息id
     *
     * @param id 招聘信息id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取职位名称
     *
     * @return CAPACITY_NAME - 职位名称
     */
    public String getCapacityName() {
        return capacityName;
    }

    /**
     * 设置职位名称
     *
     * @param capacityName 职位名称
     */
    public void setCapacityName(String capacityName) {
        this.capacityName = capacityName;
    }

    /**
     * 获取职位类别（外键）
     *
     * @return CAPACITY_CLASS - 职位类别（外键）
     */
    public String getCapacityClass() {
        return capacityClass;
    }

    /**
     * 设置职位类别（外键）
     *
     * @param capacityClass 职位类别（外键）
     */
    public void setCapacityClass(String capacityClass) {
        this.capacityClass = capacityClass;
    }

    /**
     * 获取部门
     *
     * @return DEPARTMENT - 部门
     */
    public String getDepartment() {
        return department;
    }

    /**
     * 设置部门
     *
     * @param department 部门
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * 获取工作地点
     *
     * @return JOB_STATION - 工作地点
     */
    public String getJobStation() {
        return jobStation;
    }

    /**
     * 设置工作地点
     *
     * @param jobStation 工作地点
     */
    public void setJobStation(String jobStation) {
        this.jobStation = jobStation;
    }

    /**
     * 获取工作性质
     *
     * @return JOB_KIND - 工作性质
     */
    public String getJobKind() {
        return jobKind;
    }

    /**
     * 设置工作性质
     *
     * @param jobKind 工作性质
     */
    public void setJobKind(String jobKind) {
        this.jobKind = jobKind;
    }

    /**
     * 获取招聘人数
     *
     * @return RECRUIT_NUM - 招聘人数
     */
    public String getRecruitNum() {
        return recruitNum;
    }

    /**
     * 设置招聘人数
     *
     * @param recruitNum 招聘人数
     */
    public void setRecruitNum(String recruitNum) {
        this.recruitNum = recruitNum;
    }

    /**
     * 获取薪资
     *
     * @return SALARY - 薪资
     */
    public String getSalary() {
        return salary;
    }

    /**
     * 设置薪资
     *
     * @param salary 薪资
     */
    public void setSalary(String salary) {
        this.salary = salary;
    }

    /**
     * 获取发布时间
     *
     * @return RELEASE_TIME - 发布时间
     */
    public Date getReleaseTime() {
        return releaseTime;
    }

    /**
     * 设置发布时间
     *
     * @param releaseTime 发布时间
     */
    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    /**
     * 获取工作职责
     *
     * @return JOB_DUTIES - 工作职责
     */
    public String getJobDuties() {
        return jobDuties;
    }

    /**
     * 设置工作职责
     *
     * @param jobDuties 工作职责
     */
    public void setJobDuties(String jobDuties) {
        this.jobDuties = jobDuties;
    }

    /**
     * 获取任职资格
     *
     * @return JOB_QUALIFICATION - 任职资格
     */
    public String getJobQualification() {
        return jobQualification;
    }

    /**
     * 设置任职资格
     *
     * @param jobQualification 任职资格
     */
    public void setJobQualification(String jobQualification) {
        this.jobQualification = jobQualification;
    }

    /**
     * 获取投送邮箱
     *
     * @return DELIVERY_EMAIL - 投送邮箱
     */
    public String getDeliveryEmail() {
        return deliveryEmail;
    }

    /**
     * 设置投送邮箱
     *
     * @param deliveryEmail 投送邮箱
     */
    public void setDeliveryEmail(String deliveryEmail) {
        this.deliveryEmail = deliveryEmail;
    }

    /**
     * 获取启用标识 1：启用 0：不启用
     *
     * @return IS_ENABLE - 启用标识 1：启用 0：不启用
     */
    public String getIsEnable() {
        return isEnable;
    }

    /**
     * 设置启用标识 1：启用 0：不启用
     *
     * @param isEnable 启用标识 1：启用 0：不启用
     */
    public void setIsEnable(String isEnable) {
        this.isEnable = isEnable;
    }

    /**
     * 获取删除标识 1：删除 0：未删除
     *
     * @return IS_DELETE - 删除标识 1：删除 0：未删除
     */
    public String getIsDelete() {
        return isDelete;
    }

    /**
     * 设置删除标识 1：删除 0：未删除
     *
     * @param isDelete 删除标识 1：删除 0：未删除
     */
    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * 获取更新时间
     *
     * @return UPDATE_TIME - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取创建时间
     *
     * @return CREATED_TIME - 创建时间
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * 设置创建时间
     *
     * @param createdTime 创建时间
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * 获取最近修改人
     *
     * @return UPDATE_USER - 最近修改人
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * 设置最近修改人
     *
     * @param updateUser 最近修改人
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }
}