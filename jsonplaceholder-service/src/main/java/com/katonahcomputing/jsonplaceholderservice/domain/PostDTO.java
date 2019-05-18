package com.katonahcomputing.jsonplaceholderservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
    private Long userId;
    private Long id;
    private String title;
    private String body;
}
