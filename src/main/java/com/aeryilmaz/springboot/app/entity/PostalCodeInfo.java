package com.aeryilmaz.springboot.app.entity;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "postal_codes")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class PostalCodeInfo { //POJO
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "postalcode_id")
    private long id;

    @Column(name = "postal_code", nullable = false)
    private String postalCode;

    @Column(name = "admin_code1")
    private String adminCode1;

    @Column(name = "admin_code2")
    private String adminCode2;

    @Column(name = "longitude", nullable = false)
    private double longitude;

    @Column(name = "latitude", nullable = false)
    private double latitude;

    @Column(name = "country_code")
    private String countryCode;

    @Column(name = "admin_name1")
    private String adminName1;

    @Column(name = "admin_name2")
    private String adminName2;

    @Column(name = "place_name")
    private String placeName;

    @Column(name = "query_datetime", nullable = false)
    @JsonIgnore
    private LocalDateTime m_queryDateTime = LocalDateTime.now();

    @Column(name = "last_query_datetime", nullable = false)
    @JsonIgnore
    private LocalDateTime m_lastQueryDateTime = m_queryDateTime;

    @Column(name = "rating", nullable = false)
    @JsonIgnore
    private long m_rating;

    @JsonGetter(value = "lng")
    public double getLongitude()
    {
        return longitude;
    }

    @JsonGetter(value = "lat")
    public double getLatitude()
    {
        return latitude;
    }

}
