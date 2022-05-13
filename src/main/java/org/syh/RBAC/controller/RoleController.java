package org.syh.RBAC.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.syh.RBAC.common.JsonResponse;
import org.syh.RBAC.model.RoleResponse;
import org.syh.RBAC.service.RoleService;
import org.syh.RBAC.model.Role;

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
@RequestMapping("/role")
public class RoleController {

    private final Logger logger = LoggerFactory.getLogger( RoleController.class );

    @Autowired
    private RoleService roleService;

    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        Role  role =  roleService.getById(id);
        return JsonResponse.success(role);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        roleService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResponse updateRole(@PathVariable("id") Integer  id,Role  role) throws Exception {
        role.setRoleID(id);
        roleService.updateById(role);
        return JsonResponse.success(null);
    }


    /**
    * 描述:创建Role
    *
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(Role  role) throws Exception {
        roleService.save(role);
        return JsonResponse.success(null);
    }

    /**
    * 描述:查询Role列表
    *
    */
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getList() throws Exception {
        List<Role> result = roleService.list(null);
        List<RoleResponse> resp = new ArrayList<>();
        for (Role role: result){
            StringBuilder stringBuilder = new StringBuilder();
            List<String> priName = roleService.getPrivilegeList(role.getRoleID());
            for (String name: priName){
                stringBuilder.append(name);
                stringBuilder.append(' ');
            }
            resp.add(new RoleResponse(role, stringBuilder.toString()));
        }
        return JsonResponse.success(resp);
    }

}

