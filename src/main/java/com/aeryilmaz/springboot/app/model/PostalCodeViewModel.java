package com.aeryilmaz.springboot.app.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(prefix = "m_")
@Setter
public class PostalCodeViewModel {
    private String m_adminCode1;
    private String m_adminCode2;
    private double m_longitude;
    private double m_latitude;
    private String m_countryCode;
    private String m_adminName1;
    private String m_adminName2;
    private String m_placeName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getAdminCode1()
    {
        return m_adminCode1;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getAdminCode2()
    {
        return m_adminCode2;
    }

    public double getLongitude()
    {
        return m_longitude;
    }

    public double getLatitude()
    {
        return m_latitude;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCountryCode()
    {
        return m_countryCode;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getAdminName1()
    {
        return m_adminName1;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getAdminName2()
    {
        return m_adminName2;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getPlaceName()
    {
        return m_placeName;
    }
}
