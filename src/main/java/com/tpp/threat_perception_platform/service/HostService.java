package com.tpp.threat_perception_platform.service;

<<<<<<< HEAD
=======
import com.github.pagehelper.PageHelper;
>>>>>>> main
import com.tpp.threat_perception_platform.param.AssetsParam;
import com.tpp.threat_perception_platform.param.MyParam;
import com.tpp.threat_perception_platform.pojo.Host;
import com.tpp.threat_perception_platform.response.ResponseResult;

<<<<<<< HEAD
import java.lang.module.ResolutionException;
import java.util.List;

public interface HostService {
    public int saveHost(Host host);

    public ResponseResult hostList(MyParam param);

    Host findById(Integer id);

    Host findByMacAddress(String mac);

    List<Host> findByHostNameLike(String hostName);

    int deleteById(Long id);

    public int updateHostByMacAddress(Host host);

    public ResponseResult assetsDiscovery(AssetsParam param);


}

=======
import java.util.List;

public interface HostService {
    /**
     * 保存主机信息
     * @param host 主机信息
     * @return 返回影响的行数
     */

     public int saveHost(Host host); //保存主机信息，如果有记录则更新，没有记录则插入



    public ResponseResult hostList(MyParam param);

    public ResponseResult delete(List<Long> id);
    public int updateByMacAddress(Host host); //根据mac地址更新主机信息

    /**
     * 资产发现
     * @param param 资产参数
     * @return
     */
    public ResponseResult assetsDiscovery(AssetsParam param); //资产发现，更新主机的状态和信息

    public ResponseResult accountDiscovery(AssetsParam param);
    public ResponseResult serviceDiscovery(AssetsParam param);
    public ResponseResult processDiscovery(AssetsParam param);
    public ResponseResult appDiscovery(AssetsParam param);

    //public ResponseResult heartbeat(String macAddress); //心跳检测，更新主机的最后在线时间
}
>>>>>>> main
