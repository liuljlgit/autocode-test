package com.cloud.ftl.ftltest.controller;

import com.cloud.ftl.ftlbasic.webEntity.PageBean;
import com.cloud.ftl.ftlbasic.webEntity.RespEntity;
import com.cloud.ftl.ftlbasic.webEntity.CommonResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.*;
import com.cloud.ftl.ftltest.service.IComUserService;
import com.cloud.ftl.ftltestclient.entity.ComUser;
import com.cloud.ftl.ftltestclient.feign.ComUserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@Validated
public class ComUserCtrl implements ComUserFeign {

    @Autowired
    private IComUserService comUserService;

    @Override
    public CommonResp<ComUser> selectById(@RequestParam("userId") @NotNull Long userId) {
        return RespEntity.ok(comUserService.selectById(userId,"没有符合条件的记录！"));
    }

    @Override
    public CommonResp<List<ComUser>> selectList(@RequestBody ComUser comUser){
        return RespEntity.ok(comUserService.selectList(comUser));
    }

    @Override
    public CommonResp<PageBean<ComUser>> selectPage(@RequestBody ComUser comUser) {
        return RespEntity.ok(comUserService.selectPage(comUser));
    }

    @Override
    public CommonResp<Object> save(@RequestBody ComUser comUser) {
        comUserService.save(comUser);
        return RespEntity.ok();
    }

    @Override
    public CommonResp<Object> deleteById(@RequestParam(value="userId") @NotNull Long userId) {
        comUserService.deleteById(userId);
        return RespEntity.ok();
    }

}