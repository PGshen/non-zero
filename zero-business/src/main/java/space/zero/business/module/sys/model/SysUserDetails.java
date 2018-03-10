package space.zero.business.module.sys.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

import static space.zero.core.constant.Constant.ENABLE_FLAG_TRUE;

/**
 * Created by PG_shen
 * Date : 3/8/18
 * Time : 1:03 PM
 */
public class SysUserDetails implements UserDetails{
    private static final long serialVersionUID = 1L;

    private SysUser user;

    public SysUserDetails(SysUser user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getPerms();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getLoginName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return ENABLE_FLAG_TRUE.equals(user.getIsEnable());
    }

    public SysUser getUser() {
        return user;
    }

    public void setUser(SysUser user) {
        this.user = user;
    }
}
