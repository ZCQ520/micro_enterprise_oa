package com.wzu.oa.service.impl;

import com.wzu.oa.service.KynamicService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author jack
 * @date 2018-01-16   17:11
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class KynamicServiceImpl implements KynamicService {
}
