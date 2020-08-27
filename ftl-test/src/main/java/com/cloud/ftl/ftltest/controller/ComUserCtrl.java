package com.cloud.ftl.ftltest.controller;

import com.cloud.ftl.ftlbasic.enums.Opt;
import com.cloud.ftl.ftlbasic.webEntity.PageBean;
import com.cloud.ftl.ftlbasic.webEntity.RespEntity;
import com.cloud.ftl.ftlbasic.webEntity.CommonResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.*;
import com.cloud.ftl.ftltest.service.IComUserService;
import com.cloud.ftl.ftltest.entity.ComUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@Validated
@RequestMapping("/comuser")
@Api(tags = "全局接口信息")
public class ComUserCtrl{

    @Autowired
    private IComUserService comUserService;

    @GetMapping(value = "/obj")
    @ApiOperation(value = "根据主键查询" , tags = "xxx",hidden = true, notes = "author: llj")
    @ApiImplicitParam(name="userId", value="主键",required = true)
    public CommonResp<ComUser> selectById(@RequestParam("userId") @NotNull Long userId) {
        return RespEntity.ok(comUserService.selectById(userId,"没有符合条件的记录！"));
    }

    @PostMapping(value = "/list")
    @ApiOperation(value = "查询所有列表" , tags = "xxx",hidden = true, notes = "author: llj")
    public CommonResp<List<ComUser>> selectList(@RequestBody ComUser comUser){
        comUser.setUserId(100001L);
        comUser.andConditGroup()
                    .andCondit(ComUser.ACCOUNT, Opt.EQUAL,1)
                    .orCondit(ComUser.CREATE_TIME,Opt.IS_NULL)
                .orConditGroup()
                    .andCondit(ComUser.ENABLED,Opt.EQUAL,(byte)1)
                    .orCondit(ComUser.ENABLED,Opt.EQUAL,(byte)2);
        return RespEntity.ok(comUserService.cacheSelectList(comUser));
    }

    @PostMapping(value = "/page")
    @ApiOperation(value = "分页查询" , tags = "xxx",hidden = true, notes = "author: llj")
    public CommonResp<PageBean<ComUser>> selectPage(@RequestBody ComUser comUser) {
        return RespEntity.ok(comUserService.selectPage(comUser));
    }


    @PostMapping(value = "/obj")
    @ApiOperation(value = "更新或者新增", tags = "xxx",hidden = true, notes = "author: llj")
    public CommonResp<Object> save(@RequestBody ComUser comUser) {
        comUserService.save(comUser);
        return RespEntity.ok();
    }

    @DeleteMapping(value = "/obj")
    @ApiOperation(value = "根据主键删除",tags = "xxx",hidden = true, notes = "author: llj")
    @ApiImplicitParam(name="userId", value="主键",required = true)
    public CommonResp<Object> deleteById(@RequestParam(value="userId") @NotNull Long userId) {
        comUserService.deleteById(userId);
        return RespEntity.ok();
    }

}
