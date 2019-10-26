package afbeans.model.profiles;

import afbeans.model.address.Address;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;


/***

 Created by 
 @author dkammara on Friday - 7/5/2019

 */
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShopperProfile implements GenericProfile {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    @JsonIgnore
    private String password;
    @Id
    @GeneratedValue(strategy = SEQUENCE)
    private long profileId;
    @OneToMany(targetEntity = Address.class, mappedBy = "profileId")
    @Transient
    private List<Address> addressList;

    public ShopperProfile(){

    }
    public ShopperProfile(String firstName, String lastName, String email, String phone, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.profileId=1;
    }

    public void setProfileId(long profileId) {
        this.profileId = profileId;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList=addressList;
    }

    public long getProfileId() {
        return profileId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "ShopperProfile{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", addressList=" + addressList +
                ", profileId=" + profileId +
                '}';
    }

}
