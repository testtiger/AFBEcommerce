package afbeans.repository;

import afbeans.model.address.Address;
import afbeans.model.profiles.GenericProfile;
import afbeans.model.profiles.ShopperProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.persistence.PrePersist;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static afbeans.PrintUtil.println;

/***

 Created by 
 @author dkammara on Tuesday - 9/10/2019

 create table shopper_profile (
 profile_id bigint not null,
 email varchar(255),
 first_name varchar(255),
 last_name varchar(255),
 password varchar(255),
 phone varchar(255),
 primary key (profile_id)

 )
 */
@Repository
 public class ProfileRepository implements ProfileDao<ShopperProfile> {

    List<ShopperProfile> profileList=new ArrayList<>();

    public ProfileRepository(){

    }
    @Autowired
    JdbcTemplate template;

    @Autowired
    AddressRepository addressRepository;

    @PostConstruct
    public void init(){

    }

    @Override
    public List<ShopperProfile> getProfiles() {
        String sql="SELECT * FROM shopper_profile";
        List<ShopperProfile> shoppers = this.template.query(sql,new ShopperRowMapper());
        return shoppers;
    }

    @Override
    public ShopperProfile getProfile(long profileId) {
        String sql="SELECT * FROM shopper_profile WHERE profile_id =?";
        return this.template.queryForObject(sql,new Object[]{profileId},new ShopperRowMapper());
    }

    public void setAddressRepository(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public  void putAddressesToAddressTable(List<Address> addressList, ShopperProfile profileDetails){
        if(profileDetails.getAddressList()!=null &&!profileDetails.getAddressList().isEmpty()){
            for(Address address:addressList){
                address.setProfile(profileDetails);
                addressRepository.create(address);
            }
        }
    }

    @Override
    public Object addProfile(ShopperProfile profileDetails) {


        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql="insert into shopper_profile (profile_id,email,first_name,last_name,password,phone) values(?,?,?,?,?,?)";


        String sql1="insert into shopper_profile (profile_id,email,first_name,last_name,password,phone) values(?,?,?,?,?,?)";

       /* template.update(connection -> {
            PreparedStatement stmt = connection.prepareStatement(sql, new String[]{"id"});
            stmt.setLong(1, profileDetails.getProfileId());
            stmt.setString(2, profileDetails.getEmail());
            stmt.setString(3, profileDetails.getFirstName());
            stmt.setString(4, profileDetails.getLastName());
            stmt.setString(5, profileDetails.getPassword());
            stmt.setString(5, profileDetails.getPhone());
            return stmt;
        }, keyHolder);

        long createdProfileId=keyHolder.getKey().longValue();*/
        int x=template.update(sql,profileDetails.getProfileId(),profileDetails.getEmail(),profileDetails.getFirstName(),profileDetails.getLastName(),profileDetails.getPassword(),profileDetails.getPhone());
        putAddressesToAddressTable(profileDetails.getAddressList(),profileDetails);
        return x;
    }

    @Override
    public ShopperProfile updateProfile(long profileId, ShopperProfile profileDetails) {
        //first_name,last_name,password,phone
        String sql="update books set price = ? where id = ?";
        //return template.update()
        return null;

    }

    @Override
    public Object deleteProfile(long profileId) {
        return null;
    }

    static class ShopperRowMapper implements RowMapper<ShopperProfile> {
        @Override
        public ShopperProfile mapRow(ResultSet rs, int rowNum) throws SQLException {
            ShopperProfile profile = new ShopperProfile();
            profile.setProfileId(rs.getLong("profile_id"));
            profile.setFirstName(rs.getString("first_name"));
            profile.setLastName(rs.getString("last_name"));
            profile.setEmail(rs.getString("email"));
            profile.setPhone(rs.getString("phone"));
            return profile;
        }
    }
}

