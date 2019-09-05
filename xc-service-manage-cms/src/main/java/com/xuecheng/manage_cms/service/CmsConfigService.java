package com.xuecheng.manage_cms.service;

import com.xuecheng.framework.domain.cms.CmsConfig;
import com.xuecheng.manage_cms.dao.CmsConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CmsConfigService {
    @Autowired
    private CmsConfigRepository cmsConfigRepository;

    //根据id查询cmsConfig
    public CmsConfig getConfigById(String id) {
        Optional<CmsConfig> cmsConfigOptional = cmsConfigRepository.findById(id);
        if (cmsConfigOptional.isPresent()) {
            CmsConfig cmsConfig = cmsConfigOptional.get();
            return cmsConfig;
        }
        return null;
    }
}
