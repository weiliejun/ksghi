package com.itech.ups.app.business.stats.application.service;

import java.util.List;
import java.util.Map;

/**
 * @author 张可乐
 * @version 1.0
 * @description 互联网金融信息披露数据、企业数据报送
 * @update 2017-9-19 下午3:09:23
 */
public interface OperatorDataService {
    /**
     * @param params
     * @param rowStart
     * @param rowEnd
     * @return
     * @description 互联网金融信息披露数据
     * @version 1.0
     * @author 张可乐
     * @update 2017-9-19 下午3:12:42
     */
    List<Map<String, Object>> selectFinancialDisclosure(Map<String, Object> params, int rowStart, int rowEnd);

    int selectFinancialDisclosureTotalCount(Map<String, Object> params);

    /**
     * @param params
     * @param rowStart
     * @param rowEnd
     * @return
     * @description 企业数据报送
     * @version 1.0
     * @author 张可乐
     * @update 2017-9-19 下午3:12:53
     */
    List<Map<String, Object>> selectenterpriseData(Map<String, Object> params, int rowStart, int rowEnd);

    int selectenterpriseDataTotalCount(Map<String, Object> params);

}
