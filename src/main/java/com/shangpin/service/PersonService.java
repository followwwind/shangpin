package com.shangpin.service;

import com.shangpin.common.JsonResult;
import com.shangpin.entity.Person;
import com.shangpin.entity.dto.CheckCompanyDTO;
import com.shangpin.entity.dto.CheckPersonDTO;
import com.shangpin.entity.vo.CompanyVO;
import com.shangpin.entity.vo.PersonVO;

import java.util.List;

/**
 * person service
 * @author wind
 * @date 2021/04/29 22:22:37
 * @version V1.0
 */
public interface PersonService{

    /**
     * 添加
     * @param r
     * @return
     */
    int save(Person r);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    int delete(Integer id);

    /**
     * 单条记录查询
     * @param id
     * @return
     */
    Person get(Integer id);

    /**
     * 修改
     * @param r
     * @return
     */
    int update(Person r);

    /**
     * 批量查询记录
     * @param r
     * @return
     */
    List<Person> list(Person r);

    /**
     * 检测个人申请状态
     * @param personDTO
     * @return
     */
    JsonResult<PersonVO> checkPerson(CheckPersonDTO personDTO);
}