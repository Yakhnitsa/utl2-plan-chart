package com.yurets_y.utl2planchart.entities;


import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name="partners_data")
public class Partner {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String type;

    private Integer code;

    @Size(min=3, max=10)
    private String shortCompanyName;

    @Size(max=50)
    private String fullCompanyName;

    @Size(max=255)
    private String postAddress;

    @Size(max=255)
    private String emailAddress;

    @Size(max=1024)
    private String descriptions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getShortCompanyName() {
        return shortCompanyName;
    }

    public void setShortCompanyName(String shortCompanyName) {
        this.shortCompanyName = shortCompanyName;
    }

    public String getFullCompanyName() {
        return fullCompanyName;
    }

    public void setFullCompanyName(String fullCompanyName) {
        this.fullCompanyName = fullCompanyName;
    }

    public String getPostAddress() {
        return postAddress;
    }

    public void setPostAddress(String postAddress) {
        this.postAddress = postAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }
}
