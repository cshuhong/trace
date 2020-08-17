package cn.edu.zut.trace.controller;

import cn.edu.zut.trace.common.enums.ResultCode;
import cn.edu.zut.trace.entity.po.Product;
import cn.edu.zut.trace.entity.vo.ProductVo;
import cn.edu.zut.trace.entity.vo.R;
import cn.edu.zut.trace.service.ProductService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/product")
@Api(tags = "产品接口")
@CrossOrigin
public class ProductController {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @ApiOperation(value = "查询所有产品", response = R.class)
    @GetMapping("/queryAll")
    public R queryAllProduct(@ApiParam(name = "页数", required = true)@RequestParam(defaultValue = "1") int pageNo,
                      @ApiParam(name = "页大小", required = true) @RequestParam(defaultValue = "10") int pageSize,
                      HttpServletResponse response) {
        PageInfo<ProductVo> pageInfo = productService.queryAllProduct(pageNo,pageSize);
        if (pageInfo == null) {
            response.setStatus(500);
            return new R(ResultCode.Http接口响应异常);
        }
        return new R(ResultCode.成功, pageInfo);
    }

    @ApiOperation(value = "条件查询产品", response = R.class)
    @GetMapping("/query")
    public R queryProduct(@ApiParam(name = "产品实体类", required = true) Product product,
                      @ApiParam(name = "页数", required = true)@RequestParam(defaultValue = "1") int pageNo,
                      @ApiParam(name = "页大小", required = true) @RequestParam(defaultValue = "10") int pageSize,
                      HttpServletResponse response) {
        PageInfo<ProductVo> pageInfo = productService.queryProduct(product,pageNo,pageSize);
        if (pageInfo == null) {
            response.setStatus(500);
            return new R(ResultCode.Http接口响应异常);
        }
        return new R(ResultCode.成功, pageInfo);
    }

    @ApiOperation(value = "取出生产公司一个产品", response = R.class)
    @GetMapping("/queryOne")
    public R queryProduct(@ApiParam(name = "生产公司id", required = true) String id,
                          HttpServletResponse response) {
        Product p = new Product(null,id,null);
        PageInfo<ProductVo> pageInfo = productService.queryProduct(p,0,0);
        List<ProductVo> list = pageInfo.getList();
        if (list.size()>0){
            for (ProductVo product : list){
                if (StringUtils.isBlank(product.getTagId())){
                    return new R(ResultCode.成功, product);
                }
            }
        }
        response.setStatus(403);
        return new R(ResultCode.操作失败);
    }

    @ApiOperation(value = "更新产品信息", response = R.class)
    @PostMapping("/update")
    public R updateProduct(@ApiParam(name = "产品实体类", required = true) Product product) {
        Integer res = productService.updateProduct(product);
        if (res > 0) {
            return new R(ResultCode.成功);
        }
        return new R(ResultCode.系统异常);
    }

    @ApiOperation(value = "添加产品", response = R.class)
    @PostMapping("/add")
    public R addProduct(@ApiParam(name = "产品实体类", required = true) Product product) {
        product.setProductStatus("0");
        Integer res = productService.addProduct(product);
        if (res > 0) {
            return new R(ResultCode.成功);
        }
        return new R(ResultCode.系统异常);
    }

    @ApiOperation(value = "删除产品", response = R.class)
    @PostMapping("/delete")
    public R deleteProduct(@ApiParam(name = "产品id", required = true) String productId) {
        Integer res = productService.deleteProduct(productId);
        if (res > 0) {
            return new R(ResultCode.成功);
        }
        return new R(ResultCode.系统异常);
    }
}
