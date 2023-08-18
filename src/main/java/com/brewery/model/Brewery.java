package com.brewery.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.joda.time.DateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Brewery {

    private Integer id;

    private String name;

    @JsonProperty("brewery_type")
    private String type;

    private String street;

    @JsonProperty("address_2")
    private String address2;

    @JsonProperty("address_3")
    private String address3;
    private String city;
    private String state;

    @JsonProperty("county_province")
    private String county_province;

    @JsonProperty("postal_code")
    private String postalCode;
    private String country;
    private String longitude;
    private String latitude;
    private String phone;

    @JsonProperty("website_url")
    private String websiteUrl;

    @JsonProperty("updated_at")
    private DateTime updatedAt;

    @JsonProperty("created_at")
    private DateTime createdAt;
}
