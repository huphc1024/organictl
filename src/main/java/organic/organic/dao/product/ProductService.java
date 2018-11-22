package organic.organic.dao.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import organic.organic.dao.ServiceResult;
import organic.organic.model.product.Product;


@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public ServiceResult findAll(){
        ServiceResult result = new ServiceResult();
        result.setData(productRepository.findAll());
        return result;
    }

    public ServiceResult findById(int id) {
        ServiceResult result = new ServiceResult();
        Product product = productRepository.findById(id).orElse(null);
        result.setData(product);
        return result;
    }

    public ServiceResult create(Product product) {
        ServiceResult result = new ServiceResult();
        result.setData(productRepository.save(product));
        return result;
    }

    public ServiceResult update(Product product) {
        ServiceResult result = new ServiceResult();
        if (!productRepository.findById(product.getId()).isPresent()) {
            result.setStatus(ServiceResult.Status.FAILED);
            result.setMessage("User Not Found");
        } else {
            result.setData(productRepository.save(product));
        }
        return result;
    }

    public ServiceResult delete(int id) {
        ServiceResult result = new ServiceResult();
        Product product = productRepository.findById(id).orElse(null);
        if (product == null) {
            result.setStatus(ServiceResult.Status.FAILED);
            result.setMessage("User Not Found");
        } else {
        	productRepository.deleteById(id);
            result.setMessage("success");
        }
        return result;
    }
}
