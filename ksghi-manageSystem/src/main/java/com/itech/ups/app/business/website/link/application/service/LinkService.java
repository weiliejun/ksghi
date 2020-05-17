package com.itech.ups.app.business.website.link.application.service;

import com.itech.ups.app.link.application.domain.Link;

import java.util.List;
import java.util.Map;


/*
 * @version 1.0, 2014-10-9
 * @author  jxy
 *
 */
public interface LinkService {

    Link addLink(Link link);

    void deleteLink(Link link);

    Link editLink(Link link);

    Link findLink(String id);

    Link findLinkByName(String name);

    List<Link> findLinks(Map paramMap, int rowStart, int rowEnd);

    long findLinkTotalCount(Map paramMap);

}
