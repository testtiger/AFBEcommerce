package afbeans.practice.services.profiles;

import afbeans.model.profiles.GenericProfile;

/***

 Created by 
 @author dkammara on Tuesday - 7/23/2019

 */

public class DummyShopperProfileServiceImpl implements ProfileService{

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
