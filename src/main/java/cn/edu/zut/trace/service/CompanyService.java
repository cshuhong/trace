package cn.edu.zut.trace.service;

import cn.edu.zut.trace.entity.po.Company;
import com.github.pagehelper.PageInfo;

public interface CompanyService {
//    公司注册
    String register(Company company);

//    条件查询公司
    PageInfo<Company> queryCompany(Company company, int pageNo, int pageSize);

//    查询所有公司
    PageInfo<Company> queryAllCompany(int pageNo, int pageSize);

//    更新公司信息
    Integer updateCompany(Company company);

//    删除公司
    Integer deleteCompany(String companyId);
}
