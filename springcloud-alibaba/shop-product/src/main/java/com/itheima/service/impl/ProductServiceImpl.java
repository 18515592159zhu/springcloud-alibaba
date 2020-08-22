package com.itheima.service.impl;

import com.itheima.dao.ProductDao;
import com.itheima.pojo.Product;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product findByPid(Integer pid) {
        return productDao.findById(pid).get();
    }

  /*  @Override
    public void reduceInventory(Integer pid, int num) {
        Product product = productDao.findById(pid).get();
        product.setStock(product.getStock() - num);//减库存
        productDao.save(product);
    }
*/

    @Override
    public void reduceInventory(Integer pid, int num) {
        Product product = productDao.findById(pid).get();
        if (product.getStock() < num) {
            throw new RuntimeException("库存不足");
        }
        int i = 1 / 0;
        product.setStock(product.getStock() - num);
        productDao.save(product);
    }
}
