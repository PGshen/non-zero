package space.zero.business.module.sys.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import space.zero.business.module.sys.model.SysUser;
import space.zero.core.service.Service;

import java.util.List;


/**
 * Created by PG_shen on 2018/03/08.
 */
public interface SysUserService extends Service<SysUser>,UserDetailsService {
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
    SysUser save(SysUser data);
    SysUser update(SysUser data);
    List<String> findUserRoleList(String userID);
}
