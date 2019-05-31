package com.katonahcomputing.authservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetailsDTO {
    LocalDate startDate;
    LocalDate endDate;
    String label;
}
