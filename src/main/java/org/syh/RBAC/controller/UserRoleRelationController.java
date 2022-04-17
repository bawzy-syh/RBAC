package org.syh.RBAC.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.syh.RBAC.common.JsonResponse;
import org.syh.RBAC.service.UserRoleRelationService;
import org.syh.RBAC.model.UserRoleRelation;


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
@RequestMapping("/userRoleRelation")
public class UserRoleRelationController {

    private final Logger logger = LoggerFactory.getLogger( UserRoleRelationController.class );

    @Autowired
    private UserRoleRelationService userRoleRelationService;

    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        UserRoleRelation  userRoleRelation =  userRoleRelationService.getById(id);
        return JsonResponse.success(userRoleRelation);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        userRoleRelationService.removeById(id);
        return JsonResponse.success(null);
    }





    /**
    * 描述:创建UserRoleRelation
    *
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(UserRoleRelation  userRoleRelation) throws Exception {
        userRoleRelationService.save(userRoleRelation);
        return JsonResponse.success(null);
    }

    /**
    * 描述:查询UserRoleRelation列表
    *
    */
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getList() throws Exception {
        Object result = userRoleRelationService.list(null);
        return JsonResponse.success(result);
    }

}

