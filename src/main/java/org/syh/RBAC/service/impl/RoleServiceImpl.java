package org.syh.RBAC.service.impl;

import org.syh.RBAC.model.Role;
import org.syh.RBAC.mapper.RoleMapper;
import org.syh.RBAC.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author syh
 * @since 2022-04-17
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
