package afbeans.repository.addresses;

import afbeans.model.address.Address;
import afbeans.model.profiles.ShopperProfile;
import afbeans.repository.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/***
 Created by 
 @author dkammara on Thursday - 10/24/2019
 */
@Repository
public class AddressRepository implements GenericRepository<Address> {

    @Autowired
    JdbcTemplate template;

    final static String addAddressSQL="insert into address (" +
            "address_type," +
            "first_name,"+
            "last_name,"+
            "address_line1," +
            "address_line2," +
            "city," +
            "country," +
            "state," +
            "zip," +
            "is_default_address,"+
            "address_id," +
            "profile_id"+
            ") values(?,?,?,?,?,?,?,?,?,?,?,?)";


    final static String SQL_FOR_Find_Addresses_Of_A_Profile="SELECT * FROM ADDRESS WHERE PROFILE_ID = ?";
    @Override
    public Address findOne(long id) {
        return null;
    }

    @Override
    public List<Address> findAll() {
        String sql="SELECT * FROM address";
        List<Address> addressList = this.template.query(sql,new AddressRepository.AddressRowMapper());
        return addressList;
    }


    public List<Address> findAllAddressOfProfile(long profileId) {
        //String sql="SELECT addr.adresline_1,prf.lastname FROM address addr join profile prf on prf.profile_id = addr.profile_id WHERE prf.profile_id = ?";
        List<Address> addresses = this.template.query(
                SQL_FOR_Find_Addresses_Of_A_Profile, new Object[] { profileId }, new AddressRepository.AddressRowMapper());
        return addresses;
    }

    @Override
    public void create(Address addressDetails) {
         template.update(addAddressSQL,
                 addressDetails.getAddressType(),
                 addressDetails.getFirstName(),
                 addressDetails.getLastName(),
                 addressDetails.getAddressLine1(),
                 addressDetails.getAddressLine2(),
                 addressDetails.getCity(),
                 addressDetails.getCountry(),
                 addressDetails.getState(),
                 addressDetails.getZip(),
                 addressDetails.getIsDefaultAddress(),
                 addressDetails.getAddressId(),
                 addressDetails.getProfile().getProfileId()
         );
    }

    @Override
    public Address update(Address entity) {
        return null;
    }

    @Override
    public void delete(Address entity) {

    }

    @Override
    public void deleteById(long entityId) {

    }

    static class AddressRowMapper implements RowMapper<Address> {
        @Override
        public Address mapRow(ResultSet rs, int rowNum) throws SQLException {
            //profile.setProfileId(rs.getLong("profile_id"));
            Address address = new Address();
            address.setAddressType(rs.getString("address_type"));
            address.setFirstName(rs.getString("first_name"));
            address.setLastName(rs.getString("last_name"));
            address.setAddressLine1(rs.getString("address_line1"));
            address.setAddressLine2(rs.getString("address_line2"));
            address.setCity(rs.getString("city"));
            address.setCountry(rs.getString("country"));
            address.setState(rs.getString("state"));
            address.setZip(rs.getString("zip"));
            address.setIsDefaultAddress(rs.getBoolean("is_default_address"));
            address.setAddressId(rs.getLong("address_id"));

            ShopperProfile profile=new ShopperProfile();
            profile.setProfileId(rs.getLong("profile_id"));

            address.setProfile(profile);

            return address;
        }
    }
}

/***
 *
 *
 */
