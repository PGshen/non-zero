package space.zero.business.module.official.website.model;

import space.zero.core.model.BaseEntity;

import javax.persistence.*;

@Table(name = "official_website_class_mate")
public class OfficialWebsiteClassMate extends BaseEntity {
    /**
     * 类别ID
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 类别名称
     */
    @Column(name = "CLASS_NAME")
    private String className;

    /**
     * 类别值
     */
    @Column(name = "CLASS_VALUE")
    private String classValue;

    /**
     * 获取类别ID
     *
     * @return ID - 类别ID
     */
    public String getId() {
        return id;
    }

    /**
     * 设置类别ID
     *
     * @param id 类别ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取类别名称
     *
     * @return CLASS_NAME - 类别名称
     */
    public String getClassName() {
        return className;
    }

    /**
     * 设置类别名称
     *
     * @param className 类别名称
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * 获取类别值
     *
     * @return CLASS_VALUE - 类别值
     */
    public String getClassValue() {
        return classValue;
    }

    /**
     * 设置类别值
     *
     * @param classValue 类别值
     */
    public void setClassValue(String classValue) {
        this.classValue = classValue;
    }
}