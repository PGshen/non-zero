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

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by jiabinl on 2017-3-23.
 *
 * 权限资源 SecurityMetadataSource是一个接口，同时还有一个接口FilterInvocationSecurityMetadataSource继承于它
 * 主要用于加在权限资源，url与权限信息
 */
public class SysSecurityMetadataSource implements SecurityMetadataSource {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SysMenuService sysMenuService;

    private HashMap<String, Collection<ConfigAttribute>> map =null;

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

                // 用权限的getUrl() 作为map的key，用ConfigAttribute的集合作为 value，
                map.put(sysMenu.getPath(), array);
            }
        }

        log.debug("load security resource:" + map.size());
        for(String tmp : map.keySet()) {
            log.debug(tmp);
        }
    }

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        if(map == null) loadResourceDefine();
        // object 中包含用户请求的request 信息，根据请求Url获取权限列表中系统规定需要权限，用于与用户权限进行比较
        HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();
        AntPathRequestMatcher matcher;
        String resUrl;
        for(Iterator<String> iter = map.keySet().iterator(); iter.hasNext(); ) {
            resUrl = iter.next();
            if (resUrl != null){
                matcher = new AntPathRequestMatcher(resUrl);
                if(matcher.matches(request)) {
                    return map.get(resUrl);
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
}
    
