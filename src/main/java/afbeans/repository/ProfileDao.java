package afbeans.repository;

import afbeans.model.profiles.GenericProfile;
import afbeans.model.profiles.ShopperProfile;

import java.util.List;

/***

 Created by 
 @author dkammara on Monday - 9/23/2019

 */
public interface ProfileDao<T extends GenericProfile> {

   /* public List<ShopperProfile>  getProfiles();
    public ShopperProfile  getProfile(long profileId);
    public Object addProfile(ShopperProfile profileDetails);
    public ShopperProfile updateProfile(String profileId,ShopperProfile profileDetails);
    public Object deleteProfile(String profileId);*/
   public List<T>  getProfiles();
    public T  getProfile(long profileId);
    public Object addProfile(T profileDetails);
    public ShopperProfile updateProfile(long profileId,T profileDetails);
    public Object deleteProfile(long profileId);
}
