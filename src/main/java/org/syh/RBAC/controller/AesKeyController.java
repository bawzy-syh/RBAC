package org.syh.RBAC.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.syh.RBAC.common.JsonResponse;
import org.syh.RBAC.service.AesKeyService;
import org.syh.RBAC.model.AesKey;


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
@RequestMapping("/aesKey")
public class AesKeyController {

    private final Logger logger = LoggerFactory.getLogger( AesKeyController.class );

    @Autowired
    private AesKeyService aesKeyService;

    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        AesKey  aesKey =  aesKeyService.getById(id);
        return JsonResponse.success(aesKey);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        aesKeyService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResponse updateAesKey(@PathVariable("id") Long  id,AesKey  aesKey) throws Exception {
        aesKey.setKeyId(id);
        aesKeyService.updateById(aesKey);
        return JsonResponse.success(null);
    }


    /**
    * 描述:创建AesKey
    *
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(AesKey  aesKey) throws Exception {
        aesKeyService.save(aesKey);
        return JsonResponse.success(null);
    }

    /**
    * 描述:查询AesKey列表
    *
    */
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getList() throws Exception {
        Object result = aesKeyService.list(null);
        return JsonResponse.success(result);
    }

}

