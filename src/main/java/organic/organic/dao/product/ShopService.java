package organic.organic.dao.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import organic.organic.dao.ServiceResult;
import organic.organic.model.product.Shop;

@Service
public class ShopService {
    @Autowired
    ShopRepository shopRepository;

    public List<Shop> findAll(){
        return (List<Shop>) shopRepository.findAll();
    }

    public ServiceResult findById(int id) {
        ServiceResult result = new ServiceResult();
        Shop shop  = shopRepository.findById(id).orElse(null);
        result.setData(shop);
        return result;
    }

    public ServiceResult create(Shop shop) {
        ServiceResult result = new ServiceResult();
        result.setData(shopRepository.save(shop));
        return result;
    }

    public ServiceResult update(Shop shop) {
        ServiceResult result = new ServiceResult();
        if (!shopRepository.findById(shop.getId()).isPresent()) {
            result.setStatus(ServiceResult.Status.FAILED);
            result.setMessage("Shop Not Found");
        } else {
            result.setData(shopRepository.save(shop));
        }
        return result;
    }

    public ServiceResult delete(int id) {
        ServiceResult result = new ServiceResult();
        Shop shop = shopRepository.findById(id).orElse(null);
        if (shop == null) {
            result.setStatus(ServiceResult.Status.FAILED);
            result.setMessage("Shop Not Found");
        } else {
        	shopRepository.deleteById(id);
            result.setMessage("success");
        }
        return result;
    }
}
