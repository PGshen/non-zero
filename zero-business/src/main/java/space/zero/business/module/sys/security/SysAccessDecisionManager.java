package space.zero.business.module.sys.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import space.zero.common.utils.StringUtils;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by jiabinl on 2017-3-23.
 */
public class SysAccessDecisionManager implements AccessDecisionManager {
    private static final Logger logger = LoggerFactory.getLogger(SysAccessDecisionManager.class);

    /***
     * 决策当前的访问是否能通过权限验证
     *
     * @param authentication 包含了当前的用户信息，包括拥有的权限
     * @param object FilterInvocation对象，可以得到request等web资源
     * @param configAttributes 本次访问需要的权限
     * @throws AccessDeniedException 拒绝访问异常
     * @throws InsufficientAuthenticationException
     */
    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        logger.debug("------------------------- decide now -------------------------");

        if (authentication == null) {
            throw new AccessDeniedException("当前访问没有权限");
        }

        Iterator<ConfigAttribute> iterator = configAttributes.iterator();
        while (iterator.hasNext()) {
            ConfigAttribute configAttribute = iterator.next();
            String needPerm = configAttribute.getAttribute();
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            for (GrantedAuthority authority : authorities) {
                if (StringUtils.equals(authority.getAuthority(), needPerm)) {
                    return;
                }
            }
        }

        throw new AccessDeniedException("当前访问没有权限");
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}

