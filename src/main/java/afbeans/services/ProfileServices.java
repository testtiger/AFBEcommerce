package afbeans.services;

import afbeans.model.profiles.GenericProfile;
import afbeans.model.profiles.ShopperProfile;
import afbeans.repository.ProfileRepository;
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

    public List<ShopperProfile> getProfiles(){
        return  profileRepository.getProfiles();
    }

    public Object addProfile(ShopperProfile profile){
        return profileRepository.addProfile(profile);
    }

    public GenericProfile getProfile(long id){
        return profileRepository.getProfile(id);
    }

}
