package org.syh.RBAC.service;

import org.syh.RBAC.model.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author syh
 * @since 2022-04-17
 */
public interface RoleService extends IService<Role> {
    List<String> getPrivilegeList(int roleID);
}
