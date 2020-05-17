package com.itech.ups.app.business.website.bulletin.application.service;

import com.itech.ups.app.bulletin.application.domain.Bulletin;

import java.util.List;
import java.util.Map;

/*
 * @version 1.0, 2014-5-4
 * @author  wcl
 *
 */
public interface BulletinService {
    Bulletin addBulletin(Bulletin bulletin);

    Bulletin editBulletin(Bulletin bulletin);

    Bulletin findBulletin(String id);

    @SuppressWarnings("rawtypes")
    List<Bulletin> findBulletins(Map params, int rowStart, int rowEnd);

    @SuppressWarnings("rawtypes")
    long findBulletinsTotalCount(Map params);

}
