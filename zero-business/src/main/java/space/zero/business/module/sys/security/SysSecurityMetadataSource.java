package space.zero.business.module.sys.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.web.FilterInvocation;
import space.zero.business.module.sys.model.SysMenu;
import space.zero.business.module.sys.service.SysMenuService;
import space.zero.common.utils.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 *
 * 权限资源 SecurityMetadataSource是一个接口，同时还有一个接口FilterInvocationSecurityMetadataSource继承于它
 * 主要用于加在权限资源，url与权限信息
 */
public class SysSecurityMetadataSource implements SecurityMetadataSource {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SysMenuService sysMenuService;

    private HashMap<Perm, Collection<ConfigAttribute>> map =null;

    /**
     * 加载权限表中所有权限
     */
    public void loadResourceDefine(){
        map = new HashMap<>();
        Collection<ConfigAttribute> array;
        ConfigAttribute cfg;
        List<SysMenu> sysMenus = sysMenuService.findAll();
        for(SysMenu sysMenu : sysMenus) {
            array = new ArrayList<>();
            if (!sysMenu.getPerm().isEmpty()){
                List<String> perms = Arrays.asList(sysMenu.getPerm().split(","));
                for(String perm : perms) {
                    cfg = new SecurityConfig(perm);
                    array.add(cfg);
                }

                // 用权限的getUrl() + getMethod 作为map的key，用ConfigAttribute的集合作为 value，
//                map.put(sysMenu.getPath(), array);
                if (sysMenu.getUrl() != null)
                    map.put(new Perm(sysMenu.getUrl(), sysMenu.getMethod()), array);
            }
        }

        log.debug("load security resource:" + map.size());
        for(Perm tmp : map.keySet()) {
            log.debug(tmp.toString());
        }
    }

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        if(map == null) loadResourceDefine();
        // object 中包含用户请求的request 信息，根据请求Url + Method获取权限列表中系统规定需要权限，用于与用户权限进行比较
        HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();
        AntPathRequestMatcher matcher;
        for (Perm perm : map.keySet()) {
            if (perm.getUrl() != null && perm.getMethod() != null && StringUtils.isNotEmpty(perm.getUrl()) && StringUtils.isNotEmpty(perm.getMethod())) {
                matcher = new AntPathRequestMatcher(perm.getUrl(), perm.getMethod());
                if (matcher.matches(request)) {
                    return map.get(perm);
                }
            }
        }

//        throw new AccessDeniedException("授权异常");

        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }

    /**
     * map的key,自定义对象,url+method
     */
    class Perm{
        private String url;
        private String method;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getMethod() {
            return method;
        }

        public void setMethod(String method) {
            this.method = method;
        }

        public Perm() {
        }

        public Perm(String url, String method) {
            this.url = url;
            this.method = method;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Perm perm = (Perm) o;
            return Objects.equals(url, perm.url) &&
                    Objects.equals(method, perm.method);
        }

        @Override
        public int hashCode() {

            return Objects.hash(url, method);
        }

        @Override
        public String toString() {
            return "Perm{" +
                    "url='" + url + '\'' +
                    ", method='" + method + '\'' +
                    '}';
        }
    }

    /**
     * Test
     */
//    public static void main(String[] args){
//        Map<Perm,String> map = new HashMap<>();
//        Perm p1 = new Perm("/user","GET");
//        Perm p2 = new Perm("/user","POST");
//        map.put(p1,"1212");
//        map.put(p2,"1213");
//        System.out.println(map.get(p1));
//        Perm p3 = new Perm("/user","GET");
//        System.out.println(map.get(p3));
//        Perm p4 = new Perm();
//        p4.setMethod("POST");
//        p4.setUrl("/user");
//        System.out.println(map.get(p4));
//    }
}
    
