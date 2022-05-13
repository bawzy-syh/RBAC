package org.syh.RBAC.mapper;

import org.syh.RBAC.model.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author syh
 * @since 2022-04-17
 */
public interface RoleMapper extends BaseMapper<Role> {
    List<String> getPrivilegeList(int roleID);
}
