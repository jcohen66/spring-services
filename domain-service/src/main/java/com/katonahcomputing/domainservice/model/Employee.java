package com.katonahcomputing.domainservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.Principal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {
    private String email;
    private String name;
    private Principal principal;
}
