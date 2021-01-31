package com.hjk.dao.cluster;

import com.hjk.domain.Cluster;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface ClusterDao {

    int insert(Cluster cluster);

}
