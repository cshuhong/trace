package cn.edu.zut.trace.service.impl;

import cn.edu.zut.trace.entity.po.Product;
import cn.edu.zut.trace.entity.vo.ProductVo;
import cn.edu.zut.trace.mapper.ProductMapper;
import cn.edu.zut.trace.service.ProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductMapper productMapper;

    @Autowired
    public ProductServiceImpl(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Override
    public PageInfo<ProductVo> queryAllProduct(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<ProductVo> list = productMapper.queryAll();
        return new PageInfo<>(list);
    }

    @Override
    public PageInfo<ProductVo> queryProduct(Product product, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<ProductVo> list = productMapper.queryProduct(product);
        return new PageInfo<>(list);
    }

    @Override
    public Integer addProduct(Product product) {
        return productMapper.addProduct(product);
    }

    @Override
    public Integer updateProduct(Product product) {
        return productMapper.updateProduct(product);
    }

    @Override
    public Integer deleteProduct(String productId) {
        return productMapper.deleteProduct(productId);
    }
}
