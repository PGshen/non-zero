package space.zero.core.constant;

/**
 * 项目常量
 */
public final class Constant {
    public static final String BASE_PACKAGE = "space.zero.business.module.sys";//项目基础包名称，根据自己公司的项目修改
    public static final String CORE_PACKAGE = "space.zero.core";

    public static final String MODEL_PACKAGE = BASE_PACKAGE + ".model";//Model所在包
    public static final String MAPPER_PACKAGE = BASE_PACKAGE + ".dao";//Mapper所在包
    public static final String SERVICE_PACKAGE = BASE_PACKAGE + ".service";//Service所在包
    public static final String SERVICE_IMPL_PACKAGE = SERVICE_PACKAGE + ".impl";//ServiceImpl所在包
    public static final String CONTROLLER_PACKAGE = BASE_PACKAGE + ".web";//Controller所在包

    public static final String MAPPER_INTERFACE_REFERENCE = CORE_PACKAGE + ".mapper.Mapper";//Mapper插件基础接口的完全限定名

    public static final String DELETE_FLAG_FALSE = "0";
    public static final String DELETE_FLAG_TRUE = "1";

    public static final String ENABLE_FLAG_FALSE = "0";
    public static final String ENABLE_FLAG_TRUE = "1";


}

