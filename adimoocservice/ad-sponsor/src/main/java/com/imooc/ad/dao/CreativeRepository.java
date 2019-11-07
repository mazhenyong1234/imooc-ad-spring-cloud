package com.imooc.ad.dao;

import com.imooc.ad.entity.AdUnit;
import com.imooc.ad.entity.Creative;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CreativeRepository extends JpaRepository<Creative,Long> {


    /*通过就jpa 实现。dao 增删改查接口实现*/

    AdUnit findByPlanIdAndUnitName(Long planId,String unitName);

    List<AdUnit> findAllByUnitStatus(Integer unitstatus);



}
