//Customize Customer Entity Serialization/Deserialization:
package com.example.bookstoreapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Customer {
    private Long id;
    
    @JsonProperty("full_name")
    private String name;

    private String email;
    private String address;
}
