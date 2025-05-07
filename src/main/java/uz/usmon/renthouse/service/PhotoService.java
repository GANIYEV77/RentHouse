package uz.usmon.renthouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.usmon.renthouse.dto.PhotoDto;
import uz.usmon.renthouse.model.Photo;
import uz.usmon.renthouse.model.Result;
import uz.usmon.renthouse.repository.PhotoRepo;

import java.util.List;
import java.util.Optional;

@Service
public class PhotoService {
    @Autowired
    PhotoRepo photoRepo;

    public List<Photo> findAll() {
        return photoRepo.findAll();
    }
    public Photo findById(Integer id) {
        return photoRepo.findById(id).get();
    }
    public Result create(PhotoDto photoDto) {
        Photo photo = new Photo();
        photo.setName(photoDto.getName());
        photo.setSize(photoDto.getSize());
        photo.setPath(photoDto.getPath());
        photoRepo.save(photo);
        return new Result(true, "Photo created");
    }
    public Result update(Integer id ,PhotoDto photoDto) {
        Optional<Photo> photo = photoRepo.findById(id);
        if (photo.isPresent()) {
            Photo p = photo.get();
            p.setName(photoDto.getName());
            p.setSize(photoDto.getSize());
            p.setPath(photoDto.getPath());
            photoRepo.save(p);
            return new Result(true, "Photo created");
        }
        return new Result(false, "Photo not found");
    }
    public Result delete(Integer id) {
        Optional<Photo> photo = photoRepo.findById(id);
        if (photo.isPresent()) {
            Photo p = photo.get();
            photoRepo.delete(p);
            return new Result(true, "Photo created");
        }
        return new Result(false, "Photo not found");
    }

}
