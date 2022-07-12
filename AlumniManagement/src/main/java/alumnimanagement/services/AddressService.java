package alumnimanagement.services;

import alumnimanagement.entity.Address;

import java.util.List;

public interface AddressService {

    void create(Address comment);

    List<Address> getComment(long id);

    void update(Address commentDTO, long id);

    void delete(long id);

    List<Address> commentByStudentId(long id);

    Address getById(long id);
}
