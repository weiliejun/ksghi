package com.itech.ups.app.business.website.link.application.infrastructure;

import com.itech.ups.app.link.application.domain.Link;
import com.itech.ups.base.application.infrastructure.dataaccess.AbstractRepositoryParent;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/*
 * @version 1.0, 2014-10-9
 * @author  jxy
 *
 */
@Repository
public class LinkRepository extends AbstractRepositoryParent {

    public Link addLink(Link link) {
        link.setId(generateIdentifier());
        sqlMapClientTemplate.insert("link.insertLink", link);
        return link;
    }

    public Link editLink(Link link) {
        sqlMapClientTemplate.update("link.updateLink", link);
        return link;
    }

    public Link findLink(String id) {
        Link link = (Link) sqlMapClientTemplate.queryForObject("link.selectLink", id);
        return link;
    }

    public Link findLinkByName(String name) {
        Link link = (Link) sqlMapClientTemplate.queryForObject("link.selectLinkByName", name);
        return link;
    }

    @SuppressWarnings("unchecked")
    public List<Link> findLinks(Map paramMap, int rowStart, int rowEnd) {
        paramMap.put("rowStart", rowStart);
        paramMap.put("rowEnd", rowEnd);
        List<Link> results = sqlMapClientTemplate.queryForList("link.selectLinks", paramMap);
        return results;
    }

    public long findLinkTotalCount(Map paramMap) {
        long totalCount = (Long) sqlMapClientTemplate.queryForObject("link.selectLinkTotalCount", paramMap);
        return totalCount;
    }

}
