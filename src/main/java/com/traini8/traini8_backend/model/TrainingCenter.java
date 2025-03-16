package com.traini8.traini8_backend.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;

@Entity
@Table(name = "training_centers")
public class TrainingCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Center name is mandatory")
    @Size(max = 40, message = "Center name must be less than 40 characters")
    private String centerName;

    @NotBlank(message = "Center code is mandatory")
    @Size(min = 12, max = 12, message = "Center code must be exactly 12 characters")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Center code must be alphanumeric")
    private String centerCode;

    @Embedded
    @NotNull(message = "Address is mandatory")
    @Valid
    private Address address;

    @NotNull(message = "Student capacity is mandatory")
    private Integer studentCapacity;

    @ElementCollection
    private List<String> coursesOffered;

    @Column(updatable = false)
    private Long createdOn;

    @NotNull(message = "Contact email is mandatory")
    @Email(message = "Invalid email format")
    private String contactEmail;

    @NotBlank(message = "Contact phone is mandatory")
    @Pattern(regexp = "^\\d{10}$", message = "Contact phone must be a 10-digit number")
    private String contactPhone;

    @PrePersist
    protected void onCreate() {
        this.createdOn = System.currentTimeMillis() / 1000;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCenterName() { return centerName; }
    public void setCenterName(String centerName) { this.centerName = centerName; }
    public String getCenterCode() { return centerCode; }
    public void setCenterCode(String centerCode) { this.centerCode = centerCode; }
    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }
    public Integer getStudentCapacity() { return studentCapacity; }
    public void setStudentCapacity(Integer studentCapacity) { this.studentCapacity = studentCapacity; }
    public List<String> getCoursesOffered() { return coursesOffered; }
    public void setCoursesOffered(List<String> coursesOffered) { this.coursesOffered = coursesOffered; }
    public Long getCreatedOn() { return createdOn; }
    public void setCreatedOn(Long createdOn) { this.createdOn = createdOn; } // Ignored due to @PrePersist
    public String getContactEmail() { return contactEmail; }
    public void setContactEmail(String contactEmail) { this.contactEmail = contactEmail; }
    public String getContactPhone() { return contactPhone; }
    public void setContactPhone(String contactPhone) { this.contactPhone = contactPhone; }
}
