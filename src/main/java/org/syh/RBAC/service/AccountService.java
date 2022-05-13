package org.syh.RBAC.service;

import org.syh.RBAC.model.Account;
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
public interface AccountService extends IService<Account> {
    List<String> getUserRole(int uid);
}
