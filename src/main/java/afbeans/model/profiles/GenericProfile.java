package afbeans.model.profiles;

/***

 Created by 
 @author dkammara on Friday - 7/5/2019

 */
public interface GenericProfile {

    void setFirstName(String firstName);

    void setLastName(String lastName);

    void setEmail(String email);

    void setPhone(String phone);

    void setPassword(String password);

    String getFirstName();

    String getLastName() ;

    String getEmail() ;

    String getPhone();

    String getPassword();

}
