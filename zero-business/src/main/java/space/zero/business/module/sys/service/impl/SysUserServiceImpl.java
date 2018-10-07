package space.zero.business.module.sys.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import space.zero.business.module.sys.dao.SysRoleMenuMapper;
import space.zero.business.module.sys.dao.SysUserMapper;
import space.zero.business.module.sys.dao.SysUserRoleMapper;
import space.zero.business.module.sys.model.SysUser;
import space.zero.business.module.sys.model.SysUserDetails;
import space.zero.business.module.sys.service.SysUserRoleService;
import space.zero.business.module.sys.service.SysUserService;
import space.zero.common.keyGenerator.KeyGenerator;
import space.zero.common.utils.StringUtils;
import space.zero.core.service.AbstractDeleteFlagService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static space.zero.core.constant.Constant.DELETE_FLAG_FALSE;


/**
 * Created by PG_shen on 2018/03/08.
 */
@Service
@Transactional
public class SysUserServiceImpl extends AbstractDeleteFlagService<SysUser> implements SysUserService {
    private static final Logger logger = LoggerFactory.getLogger(SysUserService.class);

    @Autowired
    private KeyGenerator<String> keyGenerator;
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;
    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private SysUserRoleService sysUserRoleService;

    public List<SysUser> getByLoginName(String loginName) {
        return super.findBy("loginName", loginName);
    }

    /**
     * 根据用户名获取鉴权现象，用于登陆
     * @param username 用户名
     * @return 用户详细信息
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<SysUser> userList = getByLoginName(username);
        if (!userList.isEmpty()){
            SysUser user = userList.get(0);
            if (user != null && DELETE_FLAG_FALSE.equals(user.getIsDelete())) {
                List<String> roles = sysUserRoleMapper.getSysRolesByUsername(username);
                user.setRole(roles);

                List<GrantedAuthority> auths = new ArrayList<>();
//            String perms;
//            for (String role : roles) {
//                perms = sysRoleMenuRepository.getPermsByRole(role);
//                if (!StringUtils.isEmpty(perms)){
//                    List<String> permsList = Arrays.asList(perms.split(","));
//                    for (String perm : permsList) {
//                        auths.add(new SimpleGrantedAuthority(perm));
//                        logger.debug("loginName : {}, authCode : {}", user.getLoginName(), perm);
//                    }
//                }
//            }
                List<String> permsList;
                for (String role : roles) {
                    permsList = sysRoleMenuMapper.getPermsByRole(role);
                    if (permsList.size()>0){
                        for (String perm : permsList) {
                            auths.add(new SimpleGrantedAuthority(perm));
                            logger.debug("loginName : {}, authCode : {}", user.getLoginName(), perm);
                        }
                    }
                }

                user.setPerms(auths);

                SysUserDetails userDetails = new SysUserDetails(user);
                System.out.println("username = [" + username + "]");

                return userDetails;
            }
        }


        throw new UsernameNotFoundException("用户不存在");
    }

    @Override
    public SysUser save(SysUser data) {
        SysUser user = findById(data.getId());
        System.out.println("data = [" + data.getLoginName() + "]");
        if(StringUtils.isBlank(data.getPassword())){
            throw new RuntimeException("密码不能为空");
        }else{
            data.setPassword(passwordEncoder.encode(data.getPassword()));
        }
        data.setIsEnable("1");
        data.setCreatedTime(new Timestamp(new Date().getTime()));
        return super.save(data);
    }


    @Override
    public SysUser update(SysUser data) {

        if(!StringUtils .isBlank(data.getPassword())){
            data.setPassword(passwordEncoder.encode(data.getPassword()));
        }
        return super.update(data);
    }

    public List<String> findUserRoleList(String userId){
        return sysUserRoleService.getRoleByUserId(userId);
    }


    @Override
    public boolean preInsert(SysUser data) {
        if (StringUtils.isBlank(data.getId())) {
            data.setId(keyGenerator.getNext());
        }
        data.setCreatedTime(new Timestamp(new Date().getTime()));
        data.setUpdateTime(new Timestamp(new Date().getTime()));
        return super.preInsert(data);
    }

    @Override
    public boolean preUpdate(SysUser data){
        SysUser sysUser = findById(data.getId());
        data.setCreatedTime(sysUser.getCreatedTime());
        data.setUpdateTime(new Timestamp(new Date().getTime()));
        return super.preUpdate(data);
    }


}
