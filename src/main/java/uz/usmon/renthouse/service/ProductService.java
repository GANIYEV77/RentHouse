package uz.usmon.renthouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.usmon.renthouse.dto.ProductDto;
import uz.usmon.renthouse.model.Product;
import uz.usmon.renthouse.model.Result;
import uz.usmon.renthouse.repository.ProductRepo;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;


    public List<Product> findAll() {
        return productRepo.findAll();

    }

    public Product findById(Integer id) {
        return productRepo.findById(id).get();
    }

    public Result create(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setLike_count(productDto.getLike_count());
        product.setPhone_number(productDto.getPhone_number());
        product.setShare(productDto.getShare());
        productRepo.save(product);
        return new Result(true, "Product created");
    }

    public Result update(Integer id, ProductDto productDto) {
        Optional<Product> product = productRepo.findById(id);
        if (product.isPresent()) {
            product.get().setName(productDto.getName());
            product.get().setDescription(productDto.getDescription());
            product.get().setPrice(productDto.getPrice());
            product.get().setLike_count(productDto.getLike_count());
            product.get().setPhone_number(productDto.getPhone_number());
            product.get().setShare(productDto.getShare());
            productRepo.save(product.get());
            return new Result(true, "Product updated");

        }
        return new Result(false, "Product not found");
    }

    public Result delete(Integer id) {
        Optional<Product> product = productRepo.findById(id);
        if (product.isPresent()) {
            productRepo.delete(product.get());
            return new Result(true, "Product deleted");
        }
        return new Result(false, "Product not found");
    }

}
