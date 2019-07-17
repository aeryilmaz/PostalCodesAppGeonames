package com.aeryilmaz.springboot.app.model;

import com.aeryilmaz.springboot.app.entity.PostalCodeInfo;

import java.util.List;

public class PostalCodesModel {
    private List<PostalCodeInfo> m_postalCodes;

    public List<PostalCodeInfo> getPostalCodes()
    {
        return m_postalCodes;
    }

    public void setPostalCodes(List<PostalCodeInfo> postalCodes)
    {
        m_postalCodes = postalCodes;
    }
}
