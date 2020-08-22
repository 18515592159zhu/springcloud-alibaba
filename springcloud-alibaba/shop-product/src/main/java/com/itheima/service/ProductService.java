package com.itheima.service;

import com.itheima.pojo.Product;

public interface ProductService {

    public Product findByPid(Integer pid);
    public void reduceInventory(Integer pid, int num);
}