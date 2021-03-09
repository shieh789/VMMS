package com.vmms.parts.service;
import com.vmms.common.QueryResponseResult;
import com.vmms.parts.domain.Parts;
import com.vmms.parts.response.PartsPageResult;

public interface PartsService {

    public PartsPageResult addParts(Parts parts);

    public QueryResponseResult findPartsByCondition(Integer page, Integer size, Parts parts);

}
