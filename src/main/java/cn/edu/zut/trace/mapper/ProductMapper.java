package cn.edu.zut.trace.mapper;

import cn.edu.zut.trace.entity.po.Product;
import cn.edu.zut.trace.entity.vo.ProductVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface ProductMapper extends Mapper<Product> {
    Integer addProduct(@Param("product") Product product);

    List<ProductVo> queryAll();

    List<ProductVo> queryProduct(@Param("product") Product product);

    Integer updateProduct(@Param("product") Product product);

    Integer deleteProduct(@Param("productId") String productId);
}
