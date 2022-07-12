package alumnimanagement.services.impl;

import alumnimanagement.entity.Address;
import alumnimanagement.repo.AddressRepo;
import alumnimanagement.repo.UserAuthRepo;
import alumnimanagement.services.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AddressServiceImpl implements AddressService {

    private AddressRepo addressRepo;
    @Override
    public void create(Address comment) {

    }

    @Override
    public List<Address> getComment(long id) {
        return null;
    }

    @Override
    public void update(Address commentDTO, long id) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public List<Address> commentByStudentId(long id) {
        return null;
    }

    @Override
    public Address getById(long id) {
        return addressRepo.findById(id).get();
    }
}
