package com.traini8.Backend_Traini8_Azeem.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String detailedAddress;
    private String city;
    private String state;
    private String pincode;
}
