package com.itech.ups.app.business.website.link.application.service;

import com.itech.ups.app.business.website.link.application.infrastructure.LinkRepository;
import com.itech.ups.app.link.application.domain.Link;
import com.itech.ups.base.application.service.AbstractServiceParent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/*
 * @version 1.0, 2014-10-9
 * @author  jxy
 *
 */
@Service("linkService")
public class LinkServiceImpl extends AbstractServiceParent implements LinkService {

    @Autowired
    private LinkRepository repository;

    @Override
    public Link addLink(Link link) {
        link.setDataStatus("valid");
        link.setViews(new Long(0));
        return repository.addLink(link);
    }

    @Override
    public void deleteLink(Link link) {
        link.setDataStatus("invalid");
        repository.editLink(link);
    }

    @Override
    public Link editLink(Link link) {
        return repository.editLink(link);
    }

    @Override
    public Link findLink(String id) {
        return repository.findLink(id);
    }

    @Override
    public Link findLinkByName(String name) {
        return repository.findLinkByName(name);
    }

    @Override
    public List<Link> findLinks(Map paramMap, int rowStart, int rowEnd) {
        return repository.findLinks(paramMap, rowStart, rowEnd);
    }

    @Override
    public long findLinkTotalCount(Map paramMap) {
        return repository.findLinkTotalCount(paramMap);
    }

}
