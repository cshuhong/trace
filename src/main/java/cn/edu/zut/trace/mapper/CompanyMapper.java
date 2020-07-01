package cn.edu.zut.trace.mapper;

import cn.edu.zut.trace.entity.po.Company;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface CompanyMapper extends Mapper<Company> {

    Integer addCompany(@Param("company") Company company);

    List<Company> queryAll();

    List<Company> queryCompany(@Param("company") Company company);

    Integer updateCompany(@Param("company") Company company);

    Integer deleteCompany(@Param("companyId") String companyId);
}
