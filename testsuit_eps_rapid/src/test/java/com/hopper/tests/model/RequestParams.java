package com.hopper.tests.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RequestParams
{
    private final Map<String, String> m_params = new HashMap<>();
    private final Map<String, List<String>> m_paramsWithMultipleValues = new HashMap<>();

    public void setParams(Map<String, String> params)
    {
        if (params != null && !params.isEmpty())
        {
            m_params.putAll(params);
        }
    }

    public void addParam(String header, String value)
    {
        m_params.put(header, value);
    }

    public void removeParam(String header)
    {
        m_params.remove(header);
    }

    public void addParamWithMultipleValues(String header, List<String> values)
    {
        m_paramsWithMultipleValues.put(header, values);
    }

    public void removeParamWithMultipleValues(String header)
    {
        m_paramsWithMultipleValues.remove(header);
    }

    public Map<String, String> getParams()
    {
        return m_params;
    }

    public Map<String, List<String>> getParamsWithMultipleValues()
    {
        return m_paramsWithMultipleValues;
    }
}
