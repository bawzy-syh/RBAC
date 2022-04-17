package org.syh.RBAC.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.syh.RBAC.common.JsonResponse;
import org.syh.RBAC.service.AccountService;
import org.syh.RBAC.model.Account;


/**
 *
 *  前端控制器
 *
 *
 * @author syh
 * @since 2022-04-17
 * @version v1.0
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    private final Logger logger = LoggerFactory.getLogger( AccountController.class );

    @Autowired
    private AccountService accountService;

    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        System.out.println(id);
        Account  account =  accountService.getById(id);
        System.out.println(account);
        return JsonResponse.success(account);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        accountService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResponse updateAccount(@PathVariable("id") Integer  id,Account  account) throws Exception {
        account.setUid(id);
        accountService.updateById(account);
        return JsonResponse.success(null);
    }


    /**
    * 描述:创建Account
    *
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(Account  account) throws Exception {
        accountService.save(account);
        return JsonResponse.success(null);
    }

    /**
    * 描述:查询Account列表
    *
    */
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getList() throws Exception {
        Object result = accountService.list(null);
        return JsonResponse.success(result);
    }

}

