package com.shangpin.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.shangpin.common.JsonResult;
import com.shangpin.entity.ApplyPerson;
import com.shangpin.entity.Person;
import com.shangpin.entity.dto.CheckPersonDTO;
import com.shangpin.entity.vo.ApplyCompanyVO;
import com.shangpin.entity.vo.ApplyPersonVO;
import com.shangpin.entity.vo.CompanyVO;
import com.shangpin.entity.vo.PersonVO;
import com.shangpin.mapper.PersonMapper;
import com.shangpin.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * person service
 * @author wind
 * @date 2021/04/29 22:22:37
 * @version V1.0
 */
@Service
public class PersonServiceImpl implements PersonService {

	private Logger logger = LoggerFactory.getLogger(PersonServiceImpl.class);

    @Autowired
    private PersonMapper mapper;

    @Override
    public int save( Person r) {
    	logger.info("PersonServiceImpl.save param: r is {}", r);
        Person entity = new Person();
        BeanUtil.copyProperties(r, entity);
        return mapper.insert(entity);
    }

    @Override
    public int delete(Integer id) {
    	logger.info("PersonServiceImpl.delete param: id is {}", id);
        return mapper.deleteById(id);
    }

    @Override
    public Person get(Integer id) {
    	logger.info("PersonServiceImpl.get param: id is {}", id);
        return mapper.findById(id);
    }

    @Override
    public int update( Person r) {
    	logger.info("PersonServiceImpl.update param: r is {}", r);
        Person entity = new Person();
        BeanUtil.copyProperties(r, entity);
        return mapper.update(entity);
    }

    @Override
    public List<Person> list(Person r) {
    	logger.info("PersonServiceImpl.list param: r is {}", r);
        return mapper.list(r);
    }

    @Override
    public JsonResult<PersonVO> checkPerson(CheckPersonDTO personDTO) {
        List<ApplyPersonVO> list = mapper.checkList(personDTO);
        List<PersonVO> voList = new ArrayList<>();
        list.forEach(v -> {
            PersonVO personVO = new PersonVO();
            BeanUtil.copyProperties(v, personVO);
            if(Integer.valueOf(1).equals(v.getStatus())){
                personVO.setReturnCode(JsonResult.SUCCESS);
                personVO.setReturnMsg("申请成功");
            }else if(Integer.valueOf(2).equals(v.getStatus())){
                personVO.setReturnCode(JsonResult.FAIL);
                personVO.setReturnMsg("申请失败");
            }else{
                personVO.setReturnCode(JsonResult.SUCCESS);
                personVO.setReturnMsg("申请中");
            }
            voList.add(personVO);
        });
        return JsonResult.success(voList);
    }
}
