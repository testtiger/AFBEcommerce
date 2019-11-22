package afbeans.services;

import afbeans.model.address.Address;
import afbeans.model.profiles.GenericProfile;
import afbeans.model.profiles.ShopperProfile;
import afbeans.repository.addresses.AddressRepository;
import afbeans.repository.profiles.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/***

 Created by 
 @author dkammara on Wednesday - 9/11/2019

 */
@Service
public class ProfileServices {

    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    AddressRepository addressRepository;

    public ProfileRepository getProfileRepository() {
        return profileRepository;
    }

    public void setProfileRepository(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public AddressRepository getAddressRepository() {
        return addressRepository;
    }

    public void setAddressRepository(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }



    public List<ShopperProfile> getProfiles(){
        return  profileRepository.getProfiles();
    }

    public Object addProfile(ShopperProfile profile){
        return profileRepository.addProfile(profile);
    }

    public GenericProfile getProfile(long id){
        return profileRepository.getProfile(id);
    }

    public List<Address> getAllAddress(long id){
        return null;
    }

}
