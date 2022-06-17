package com.perscholas.naildujour.DTO;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class CustomerServicesView {
    String customerName;
    String toePolish;
    String fingerPolish;
    String beverageOpt;
}
