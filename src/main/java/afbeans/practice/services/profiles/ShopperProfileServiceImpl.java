package afbeans.practice.services.profiles;

import afbeans.model.profiles.ShopperProfile;
import afbeans.model.profiles.GenericProfile;

import java.util.ArrayList;
import java.util.List;

/***

 Created by 
 @author dkammara on Friday - 7/5/2019

 */
public class ShopperProfileServiceImpl implements ProfileService {

    List ll =new ArrayList<>();

    public ShopperProfileServiceImpl(){
        ll.add(new ShopperProfile(
                        "Kim",
                        "Anderson",
                        "kim@example.com",
                        "9441474103",
                        "Test@123"
                )
        );
    }


    @Override
    public <T extends GenericProfile> Object createProfile(T profile) {
        return null;
    }

    @Override
    public <T extends GenericProfile> Object updateProfile(String profileId) {
        return null;
    }

    @Override
    public <T extends GenericProfile> T getProfile(String profileId, T profileUpdates) {
        return null;
    }

    @Override
    public Object deleteProfile(String profileId) {
        return null;
    }
}
