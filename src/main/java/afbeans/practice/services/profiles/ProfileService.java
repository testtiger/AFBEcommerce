package afbeans.practice.services.profiles;

import afbeans.practice.services.GenericService;
import afbeans.model.profiles.GenericProfile;

/***

 Created by 
 @author dkammara on Friday - 7/5/2019

 */
public interface ProfileService extends GenericService {

    public <T extends GenericProfile> Object createProfile(T profile);
    public <T extends GenericProfile>  Object updateProfile(String profileId);
    public <T extends GenericProfile> T getProfile(String profileId ,T profileUpdates);
    public Object deleteProfile(String profileId);
}
