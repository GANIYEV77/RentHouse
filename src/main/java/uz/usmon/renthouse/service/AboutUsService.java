package uz.usmon.renthouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.usmon.renthouse.dto.AboutUsDto;
import uz.usmon.renthouse.model.AboutUs;
import uz.usmon.renthouse.model.Address;
import uz.usmon.renthouse.model.Result;
import uz.usmon.renthouse.repository.AboutUsRepo;
import uz.usmon.renthouse.repository.AddressRepo;

import java.util.List;
import java.util.Optional;

@Service
public class AboutUsService {
    @Autowired
    AboutUsRepo aboutUsRepo;
    @Autowired
    AddressRepo addressRepo;

    public List<AboutUs> findAll() {
        return aboutUsRepo.findAll();
    }

    public AboutUs findById(Integer id) {
        return aboutUsRepo.findById(id).get();
    }

    public Result create(AboutUsDto aboutUsDto) {
        AboutUs aboutUs = new AboutUs();
        Optional<Address> addressOptional = addressRepo.findById(aboutUsDto.getAddress_id());
        Address address = addressOptional.get();
        aboutUs.setAddress_id(address);
        return new Result(true, "AboutUs created");

    }

    public Result update(Integer id ,AboutUsDto aboutUsDto) {
        Optional<AboutUs> aboutUsOptional = aboutUsRepo.findById(id);
        if (aboutUsOptional.isPresent()) {
            AboutUs aboutUs = aboutUsOptional.get();
            Optional<Address> addressOptional = addressRepo.findById(aboutUsDto.getAddress_id());
            Address address = addressOptional.get();
            aboutUs.setAddress_id(address);
            return new Result(true, "AboutUs updated");
        }
        return new Result(false, "AboutUs not found");
    }
    public Result delete(Integer id) {
        Optional<AboutUs> aboutUsOptional = aboutUsRepo.findById(id);
        if (aboutUsOptional.isPresent()) {
            AboutUs aboutUs = aboutUsOptional.get();
            aboutUsRepo.delete(aboutUs);
            return new Result(true, "AboutUs deleted");
        }
        return new Result(false, "AboutUs not found");
    }

}
