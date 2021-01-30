package com.example.parts.service;
import com.example.common.QueryResponseResult;
import com.example.parts.domain.Parts;
import com.example.parts.response.PartsPageResult;

public interface PartsService {

    public PartsPageResult addParts(Parts parts);

    public QueryResponseResult findPartsByCondition(Integer page, Integer size, Parts parts);

}
