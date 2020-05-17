package com.itech.ups.app.business.website.bulletin.application.infrastructure;

import com.itech.ups.app.bulletin.application.domain.Bulletin;
import com.itech.ups.base.application.infrastructure.dataaccess.AbstractRepositoryParent;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class BulletinRepository extends AbstractRepositoryParent {
    public Bulletin addBulletin(Bulletin bulletin) {
        bulletin.setId(generateIdentifier());
        sqlMapClientTemplate.insert("website.insertBulletin", bulletin);
        return bulletin;
    }

    public Bulletin editBulletin(Bulletin bulletin) {
        sqlMapClientTemplate.update("website.updateBulletin", bulletin);
        return bulletin;
    }

    public Bulletin findBulletin(String id) {
        Bulletin bulletin = (Bulletin) sqlMapClientTemplate.queryForObject("website.selectBulletin", id);
        return bulletin;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public List<Bulletin> findBulletins(Map params, int rowStart, int rowEnd) {
        /*
         * String roleType = (String) params.get("roleType"); if (roleType !=
         * null) { StringBuffer queryCriteria = new StringBuffer();
         * queryCriteria.append("and ("); String[] roles = roleType.split(",");
         * for (int i = 0; i < roles.length; i++) {
         * queryCriteria.append("role_Type like '%" + roles[i] + "%'"); if (i !=
         * roles.length - 1) queryCriteria.append(" or "); }
         * queryCriteria.append(")"); params.put("queryCriteria",
         * queryCriteria.toString()); }
         */
        params.put("rowStart", rowStart);
        params.put("rowEnd", rowEnd);
        List<Bulletin> results = sqlMapClientTemplate.queryForList("website.selectBulletins", params);
        return results;
    }

    @SuppressWarnings("rawtypes")
    public long findBulletinsTotalCount(Map params) {
        /*
         * String roleType = (String) params.get("roleType"); if (roleType !=
         * null) { StringBuffer queryCriteria = new StringBuffer();
         * queryCriteria.append("and ("); String[] roles = roleType.split(",");
         * for (int i = 0; i < roles.length; i++) {
         * queryCriteria.append("role_Type like '%" + roles[i] + "%'"); if (i !=
         * roles.length - 1) queryCriteria.append(" or "); }
         * queryCriteria.append(")"); params.put("queryCriteria",
         * queryCriteria.toString()); }
         */
        long totalCount = (Long) sqlMapClientTemplate.queryForObject("website.selectBulletinsTotalCount", params);
        return totalCount;
    }
}