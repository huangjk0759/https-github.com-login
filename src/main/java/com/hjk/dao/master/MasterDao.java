package com.hjk.dao.master;

import com.hjk.domain.Master;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface MasterDao {
    List<Master> selectAll();
}
