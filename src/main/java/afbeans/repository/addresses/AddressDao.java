package afbeans.repository.addresses;

import afbeans.model.profiles.ShopperProfile;

import java.util.List;

/***

 Created by 
 @author dkammara on Thursday - 10/24/2019

 */
public interface AddressDao<T> {
    //addAddress
    //UpdateAddress
    //getAddress

    public List<T> getProfiles();
    public T  getProfile(long profileId);
    public Object addProfile(T profileDetails);
    public ShopperProfile updateProfile(long profileId, T profileDetails);
    public Object deleteProfile(long profileId);
}
