package com.itheima.config;

import com.itheima.pojo.Product;
import com.itheima.service.ProductService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceFallBackFactory implements FallbackFactory<ProductService> {
    @Override
    public ProductService create(Throwable throwable) {
        return new ProductService() {
            @Override
            public Product findByPid(Integer pid) {
                throwable.printStackTrace();
                Product product = new Product();
                product.setPid(-1);
                return product;
            }

            @Override
            public void reduceInventory(Integer pid, int num) {

            }
        };
    }
}