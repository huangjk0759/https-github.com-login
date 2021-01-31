package com.hjk.job;

import com.hjk.dao.cluster.ClusterDao;
import com.hjk.dao.master.MasterDao;
import com.hjk.domain.Cluster;
import com.hjk.domain.Master;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

/**
 * @author huangjunkai
 * @version 1.0
 * @date 2021/01/29
 */
@Component
@AllArgsConstructor
public class MyJob {

    MasterDao masterDao;
    ClusterDao clusterDao;

    @Scheduled(initialDelay = 0, fixedDelay = 3000)
    public void test() {
        List<Master> masters = masterDao.selectAll();
        if (!masters.isEmpty()) {
            masters.forEach(master -> {
                Cluster cluster = new Cluster();

                BeanUtils.copyProperties(master, cluster);
                //自己弄个批量插入...
                cluster.setId(UUID.randomUUID().toString().replace("-",""));
                clusterDao.insert(cluster);
            });
        }


    }
}
