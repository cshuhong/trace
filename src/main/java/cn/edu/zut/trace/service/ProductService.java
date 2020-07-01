package cn.edu.zut.trace.service;

import cn.edu.zut.trace.entity.po.Product;
import cn.edu.zut.trace.entity.vo.ProductVo;
import com.github.pagehelper.PageInfo;

import java.sql.Timestamp;
import java.util.List;

public interface ProductService {
//    追溯所有产品
    PageInfo<ProductVo> queryAllProduct(int pageNo, int pageSize);

//    条件查询产品
    PageInfo<ProductVo> queryProduct(Product product, int pageNo, int pageSize);

//    生产企业管理人员添加产品
    Integer addProduct(Product product);

//    更新产品信息
    Integer updateProduct(Product product);

//    删除产品
    Integer deleteProduct(String productId);
}
