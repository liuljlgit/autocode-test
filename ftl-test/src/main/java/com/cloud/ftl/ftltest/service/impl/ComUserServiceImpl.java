package com.cloud.ftl.ftltest.service.impl;

import org.springframework.stereotype.Service;
import com.cloud.ftl.ftltest.cache.impl.ComUserCacheImpl;
import com.cloud.ftl.ftltest.service.IComUserService;

/**
 * IComUserService service实现类
 * @author lijun
 */
@Service("comUserService")
public class ComUserServiceImpl extends ComUserCacheImpl implements IComUserService {


}