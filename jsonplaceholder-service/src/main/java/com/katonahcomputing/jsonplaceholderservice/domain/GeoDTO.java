package com.katonahcomputing.jsonplaceholderservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GeoDTO {
    private String lat;
    private String lng;
}
