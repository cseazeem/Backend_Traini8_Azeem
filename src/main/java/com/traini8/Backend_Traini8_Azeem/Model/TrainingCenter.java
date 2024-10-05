package com.traini8.Backend_Traini8_Azeem.Model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrainingCenter {
    private Long id;

    @Size(max = 40)
    @NotBlank(message = "Center name cannot be blank")
    private String centerName;

    @Pattern(regexp = "^[a-zA-Z0-9]{12}$", message = "Center code must be exactly 12 alphanumeric characters")
    @NotBlank(message = "Center code cannot be blank")
    private String centerCode;

    @Valid
    @NotNull(message = "Address is required")
    private Address address;

    private int studentCapacity;

    private List<String> coursesOffered;

    private long createdOn;

    @Email(message = "Invalid email format")
    private String contactEmail;

    @Pattern(regexp = "^\\+?[0-9. ()-]{7,}$", message = "Invalid phone number format")
    @NotBlank(message = "Contact phone is required")
    private String contactPhone;
}



