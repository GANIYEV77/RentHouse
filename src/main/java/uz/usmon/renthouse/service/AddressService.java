package uz.usmon.renthouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.usmon.renthouse.dto.AddressDto;
import uz.usmon.renthouse.model.Address;
import uz.usmon.renthouse.model.Result;
import uz.usmon.renthouse.repository.AddressRepo;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    AddressRepo addressRepo;

    public List<Address> findAll() {
        return addressRepo.findAll();
    }

    public Address findById(Integer id) {
        return addressRepo.findById(id).get();
    }

    public Result create(AddressDto addressDto) {
        Address address = new Address();
        address.setCity(addressDto.getCity());
        address.setRegion(addressDto.getRegion());
        address.setStreet(addressDto.getStreet());
        return new Result(true, "Address created");
    }

    public Result update(Integer id, AddressDto addressDto) {
        Optional<Address> address = addressRepo.findById(id);
        if (address.isPresent()) {
            address.get().setCity(addressDto.getCity());
            address.get().setRegion(addressDto.getRegion());
            address.get().setStreet(addressDto.getStreet());
            return new Result(true, "Address updated");
        }
        return new Result(false, "Address not found");
    }

    public Result delete(Integer id) {
        Optional<Address> address = addressRepo.findById(id);
        if (address.isPresent()) {
            addressRepo.deleteById(id);
            return new Result(true, "Address deleted");
        }
        return new Result(false, "Address not found");
    }
}
