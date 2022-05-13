package org.syh.RBAC.service.impl;

import org.syh.RBAC.model.Account;
import org.syh.RBAC.mapper.AccountMapper;
import org.syh.RBAC.service.AccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author syh
 * @since 2022-04-17
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {

    public List<String> getUserRole(int uid){
        return baseMapper.getUserRole(uid);
    }
}
