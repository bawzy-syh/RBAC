package org.syh.RBAC.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.syh.RBAC.common.JsonResponse;
import org.syh.RBAC.service.RsaKeyService;
import org.syh.RBAC.model.RsaKey;


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
@RequestMapping("/rsaKey")
public class RsaKeyController {

    private final Logger logger = LoggerFactory.getLogger( RsaKeyController.class );

    @Autowired
    private RsaKeyService rsaKeyService;

    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        RsaKey  rsaKey =  rsaKeyService.getById(id);
        return JsonResponse.success(rsaKey);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        rsaKeyService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResponse updateRsaKey(@PathVariable("id") Long  id,RsaKey  rsaKey) throws Exception {
        rsaKey.setKeyId(id);
        rsaKeyService.updateById(rsaKey);
        return JsonResponse.success(null);
    }


    /**
    * 描述:创建RsaKey
    *
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(RsaKey  rsaKey) throws Exception {
        rsaKeyService.save(rsaKey);
        return JsonResponse.success(null);
    }

    /**
    * 描述:查询RsaKey列表
    *
    */
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getList() throws Exception {
        Object result = rsaKeyService.list(null);
        return JsonResponse.success(result);
    }

}

