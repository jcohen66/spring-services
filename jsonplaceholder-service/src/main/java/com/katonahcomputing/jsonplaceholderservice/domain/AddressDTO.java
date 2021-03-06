package com.katonahcomputing.jsonplaceholderservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private GeoDTO geo;
}
