package com.techment.SwaggerDemo.POJO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "view_address")
public class SwaggerView {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "address_line1")
    private String addressLine1;

    @Column(name = "address_line2")
    private String addressLine2;

    @Column(name = "zipcode")
    private String zipcode;

    @Column(name = "country_name")
    private String countryName;

    @Column(name = "state_name")
    private String stateName;

    @Column(name = "city_name")
    private String cityName;

    protected SwaggerView() {}

    public SwaggerView(String addressLine1, String addressLine2, String zipcode, String countryName, String stateName, String cityName) {
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.zipcode = zipcode;
        this.countryName = countryName;
        this.stateName = stateName;
        this.cityName = cityName;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getStateName() {
        return stateName;
    }

    public String getCityName() {
        return cityName;
    }
}