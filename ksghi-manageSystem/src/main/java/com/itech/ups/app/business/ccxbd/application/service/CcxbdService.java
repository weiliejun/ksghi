package com.itech.ups.app.business.ccxbd.application.service;

import com.itech.ups.app.ccxbd.application.domain.Ccxbd;
import com.itech.ups.app.business.ccxbd.action.CcxbdImportData;

import java.util.List;
import java.util.Map;


public interface CcxbdService {

    public Ccxbd addCcxbd(Ccxbd ccxbd);

    public void addCcxbds(List<CcxbdImportData> list);

    public void deleteCcxbd(String id);

    public Ccxbd editCcxbd(Ccxbd ccxbd);

    public List<Ccxbd> findCcxbd(Map<String, Object> params, int rowStart, int rowEnd);

    public Ccxbd findCcxbdById(String id);

    public long findCcxbdCount(Map<String, Object> params);

}
