package org.syh.RBAC.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.syh.RBAC.common.JsonResponse;
import org.syh.RBAC.model.Privilege;
import org.syh.RBAC.service.PrivilegeService;
import org.syh.RBAC.service.RolePrivilegeRelationService;
import org.syh.RBAC.model.RolePrivilegeRelation;

import java.util.ArrayList;
import java.util.List;


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
@RequestMapping("/rolePrivilegeRelation")
public class RolePrivilegeRelationController {

    private final Logger logger = LoggerFactory.getLogger( RolePrivilegeRelationController.class );

    @Autowired
    private RolePrivilegeRelationService rolePrivilegeRelationService;
    @Autowired
    private PrivilegeService privilegeService;
    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        RolePrivilegeRelation  rolePrivilegeRelation =  rolePrivilegeRelationService.getById(id);
        return JsonResponse.success(rolePrivilegeRelation);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        rolePrivilegeRelationService.removeById(id);
        return JsonResponse.success(null);
    }





    /**
    * 描述:创建RolePrivilegeRelation
    *
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(RolePrivilegeRelation  rolePrivilegeRelation) throws Exception {
        rolePrivilegeRelationService.save(rolePrivilegeRelation);
        return JsonResponse.success(null);
    }

    /**
    * 描述:查询RolePrivilegeRelation列表
    *
    */
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getList(@RequestParam("roleID") Long roleID) throws Exception {
        QueryWrapper<RolePrivilegeRelation> wrapper = new QueryWrapper<>();
        wrapper.eq("roleID",roleID);
        List<RolePrivilegeRelation> result = rolePrivilegeRelationService.list(wrapper);
        List<Privilege> resp = new ArrayList<>();
        for (RolePrivilegeRelation item: result) {
            Privilege privilege = privilegeService.getById(item.getPrivilegeID());
            resp.add(privilege);
        }
        return JsonResponse.success(resp);
    }

}

