package dreamteam.hotelchainproject.models;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "username cannot be blank")
    @Column(name = "username")
    private String username;

    @NotBlank(message = "first name cannot be blank")
    @Column(name = "firstName")
    private String firstName;

    @NotBlank(message = "last name cannot be blank")
    @Column(name = "lastName")
    private String lastName;

    @NotBlank(message = "identification type cannot be blank")
    @Column(name = "identificationType")
    private String identificationType;

    @NotBlank(message = "identificationNumber cannot be blank")
    @Column(name = "identificationNumber")
    private String identificationNumber;

    @NotBlank(message = "address cannot be blank")
    @Column(name = "address")
    private String address;

    @Column(name = "homePhone")
    private String homePhone;

    @NotBlank(message = "mobile phone number cannot be blank")
    @Column(name = "mobilePhone")
    private String mobilePhone;

    @NotBlank(message = "password cannot be blank")
    @Column(name = "password")
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIdentificationType() {
        return identificationType;
    }

    public void setIdentificationType(String identificationType) {
        this.identificationType = identificationType;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
