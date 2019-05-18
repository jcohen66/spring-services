package com.katonahcomputing.jsonplaceholderservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhotoDTO {
    private Long albumId;
    private Long id;
    private String title;
    private String url;
    private String thumbnailUrl;
}
