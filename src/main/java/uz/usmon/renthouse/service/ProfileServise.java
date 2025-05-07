package uz.usmon.renthouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.usmon.renthouse.dto.ProfileDto;
import uz.usmon.renthouse.model.Profile;
import uz.usmon.renthouse.model.Result;
import uz.usmon.renthouse.repository.ProfileRepo;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class ProfileServise {
    @Autowired
    ProfileRepo profileRepo;

    public List<Profile> findAll() {
        return profileRepo.findAll();
    }

    public Profile findById(Integer id) {
        return profileRepo.findById(id).get();
    }
    public Result create(ProfileDto profileDto) {
        Profile profile = new Profile();
        profile.setName(profileDto.getName());
        profile.setEmail(profileDto.getEmail());
        profile.setSurname(profileDto.getSurname());
        profileRepo.save(profile);
        return new Result(true, "Profile created");
    }
    public Result update(ProfileDto profileDto , Integer id) {
        Optional<Profile> profile = profileRepo.findById(id);
        if (profile.isPresent()) {
            profile.get().setName(profileDto.getName());
            profile.get().setEmail(profileDto.getEmail());
            profile.get().setSurname(profileDto.getSurname());
            profileRepo.save(profile.get());
            return new Result(true, "Profile updated");
        }
        return new Result(false, "Profile not found");
    }
    public Result delete(Integer id) {
        Optional<Profile> profile = profileRepo.findById(id);
        if (profile.isPresent()) {
            profileRepo.delete(profile.get());
            return new Result(true, "Profile deleted");
        }
        return new Result(false, "Profile not found");
    }

}
