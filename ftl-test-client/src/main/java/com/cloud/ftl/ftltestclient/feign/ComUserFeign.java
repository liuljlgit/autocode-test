package com.cloud.ftl.ftltestclient.feign;

import com.cloud.ftl.ftlbasic.webEntity.PageBean;
import com.cloud.ftl.ftlbasic.webEntity.CommonResp;
import com.sun.istack.internal.NotNull;
import org.springframework.validation.annotation.Validated;
import io.swagger.annotations.*;
import com.cloud.ftl.ftltestclient.entity.ComUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@Api(tags = "文档信息",hidden = true)
@FeignClient(name = "${ftl.test.server:ftl-test-server}")
public interface ComUserFeign {

    @GetMapping(value = "/comuser/obj")
    @ApiOperation(value = "根据主键查询" , tags = "xxx", hidden = true, notes = "author: llj")
    @ApiImplicitParam(name="userId", value="主键",required = true)
    CommonResp<ComUser> selectById(@RequestParam("userId") @com.sun.istack.internal.NotNull Long userId);

    @PostMapping(value = "/comuser/list")
    @ApiOperation(value = "查询所有列表" , tags = "xxx", hidden = true, notes = "author: llj")
    CommonResp<List<ComUser>> selectList(@RequestBody ComUser comUser);

    @PostMapping(value = "/comuser/page")
    @ApiOperation(value = "分页查询" , tags = "xxx", hidden = true, notes = "author: llj")
    CommonResp<PageBean<ComUser>> selectPage(@RequestBody ComUser comUser);

    @PostMapping(value = "/comuser/obj")
    @ApiOperation(value = "更新或者新增", tags = "xxx", hidden = true, notes = "author: llj")
    CommonResp<Object> save(@RequestBody ComUser comUser);

    @DeleteMapping(value = "/comuser/obj")
    @ApiOperation(value = "根据主键删除", tags = "xxx", hidden = true, notes = "author: llj")
    @ApiImplicitParam(name="userId", value="主键",required = true)
    CommonResp<Object> deleteById(@RequestParam(value="userId") @NotNull Long userId);

}
