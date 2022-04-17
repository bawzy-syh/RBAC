package org.syh.RBAC.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.syh.RBAC.common.JsonResponse;
import org.syh.RBAC.service.PrivilegeService;
import org.syh.RBAC.model.Privilege;


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
@RequestMapping("/privilege")
public class PrivilegeController {

    private final Logger logger = LoggerFactory.getLogger( PrivilegeController.class );

    @Autowired
    private PrivilegeService privilegeService;

    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        Privilege  privilege =  privilegeService.getById(id);
        return JsonResponse.success(privilege);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        privilegeService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResponse updatePrivilege(@PathVariable("id") Integer  id,Privilege  privilege) throws Exception {
        privilege.setPrivilegeID(id);
        privilegeService.updateById(privilege);
        return JsonResponse.success(null);
    }


    /**
    * 描述:创建Privilege
    *
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(Privilege  privilege) throws Exception {
        privilegeService.save(privilege);
        return JsonResponse.success(null);
    }

    /**
    * 描述:查询Privilege列表
    *
    */
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getList() throws Exception {
        Object result = privilegeService.list(null);
        return JsonResponse.success(result);
    }

}

