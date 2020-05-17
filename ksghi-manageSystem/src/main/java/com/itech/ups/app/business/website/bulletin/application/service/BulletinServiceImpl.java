package com.itech.ups.app.business.website.bulletin.application.service;

import com.itech.ups.app.bulletin.application.domain.Bulletin;
import com.itech.ups.app.business.website.bulletin.application.infrastructure.BulletinRepository;
import com.itech.ups.base.application.service.AbstractServiceParent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/*
 * @version 1.0, 2014-5-4
 * @author  wcl
 *
 */
@Service("bulletinService")
public class BulletinServiceImpl extends AbstractServiceParent implements BulletinService {

    @Autowired
    private BulletinRepository repository;

    @Override
    public Bulletin addBulletin(Bulletin bulletin) {
        bulletin.setDataStatus("valid"); // invalid-删除 valid有效
        return repository.addBulletin(bulletin);
    }

    @Override
    public Bulletin editBulletin(Bulletin bulletin) {
        return repository.editBulletin(bulletin);
    }

    @Override
    public Bulletin findBulletin(String id) {

        return repository.findBulletin(id);
    }

    @SuppressWarnings("rawtypes")
    @Override
    public List<Bulletin> findBulletins(Map params, int rowStart, int rowEnd) {

        return repository.findBulletins(params, rowStart, rowEnd);
    }

    @SuppressWarnings("rawtypes")
    @Override
    public long findBulletinsTotalCount(Map params) {
        return repository.findBulletinsTotalCount(params);
    }

}