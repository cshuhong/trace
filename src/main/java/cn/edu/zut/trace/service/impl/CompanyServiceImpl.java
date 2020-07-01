package cn.edu.zut.trace.service.impl;

import cn.edu.zut.trace.entity.po.Company;
import cn.edu.zut.trace.mapper.CompanyMapper;
import cn.edu.zut.trace.service.CompanyService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    private CompanyMapper companyMapper;

    @Autowired
    public void setCompanyMapper(CompanyMapper companyMapper) {
        this.companyMapper = companyMapper;
    }

    @Override
    public PageInfo<Company> queryCompany(Company company, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<Company> list = companyMapper.queryCompany(company);
        return new PageInfo<>(list);
    }

    @Override
    public PageInfo<Company> queryAllCompany(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<Company> list = companyMapper.queryAll();
        return new PageInfo<>(list);
    }

    @Override
    public Integer updateCompany(Company company) {
        return companyMapper.updateCompany(company);
    }

    @Override
    public String register(Company company) {
        company.setCompanyStatus("1");
        companyMapper.addCompany(company);
        return company.getCompanyId();
    }

    @Override
    public Integer deleteCompany(String companyId) {
        return companyMapper.deleteCompany(companyId);
    }
}
