package com.itech.ups.app.business.website.prizepool.application.infrastructure;

import com.itech.ups.app.operation.application.domain.PrizePool;
import com.itech.ups.base.application.infrastructure.dataaccess.AbstractRepositoryParent;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class PrizePoolRepository extends AbstractRepositoryParent {

    public PrizePool addNews(PrizePool prizePool) {
        prizePool.setId(generateIdentifier());
        sqlMapClientTemplate.insert("prizePool.insertPrizePool", prizePool);
        return prizePool;
    }

    public PrizePool editNews(PrizePool prizePool) {
        sqlMapClientTemplate.update("prizePool.updatePrizePool", prizePool);
        return prizePool;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public List<PrizePool> findNews(Map params, int rowStart, int rowEnd) {
        params.put("rowStart", rowStart);
        params.put("rowEnd", rowEnd);
        List<PrizePool> results = sqlMapClientTemplate.queryForList("prizePool.selectPrizePools", params);
        return results;
    }

    public PrizePool findNews(String id) {
        PrizePool prizePool = (PrizePool) sqlMapClientTemplate.queryForObject("prizePool.selectPrizePoolsById", id);
        return prizePool;
    }

    @SuppressWarnings("rawtypes")
    public long findNewsTotalCount(Map params) {
        long totalCount = (Long) sqlMapClientTemplate.queryForObject("prizePool.selectPrizePoolsTotalCount", params);
        return totalCount;
    }
}
