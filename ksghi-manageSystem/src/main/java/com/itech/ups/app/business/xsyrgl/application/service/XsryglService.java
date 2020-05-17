package com.itech.ups.app.business.xsyrgl.application.service;


import com.itech.ups.app.xsrygl.application.domain.Xsrygl;

import java.util.List;
import java.util.Map;


public interface XsryglService {

    public Xsrygl addXsrygl(Xsrygl ccxbd);

    public void deleteXsrygl(Xsrygl ccxbd);

    public Xsrygl editXsrygl(Xsrygl ccxbd);

    public List<Xsrygl> findXsrygl(Map<String, Object> params, int rowStart, int rowEnd);

    public Xsrygl findXsryglById(String id);

    public long findXsryglCount(Map<String, Object> params);

}
