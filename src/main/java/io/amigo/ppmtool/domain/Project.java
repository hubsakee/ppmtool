package io.amigo.ppmtool.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Data
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Naam mag niet leeg zijn")
    private String projectName;
    @NotBlank(message = "Veld mag niet leeg zijn")
    @Column(updatable = false, unique = true)
    private String projectIdentifier;
    @NotBlank(message = "Beschrijving mag niet leeg zijn")
    private String description;
    @JsonFormat(pattern = "dd-mm-yyyy")
    private Date start_date;
    @JsonFormat(pattern = "dd-mm-yyyy")
    private Date end_date;

    @JsonFormat(pattern = "dd-mm-yyyy")
    private Date created_at;
    @JsonFormat(pattern = "dd-mm-yyyy")
    private Date updated_at;

    public Project() {

    }

    @PrePersist
    protected void onCreate() {
        this.created_at = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updated_at = new Date();
    }

}