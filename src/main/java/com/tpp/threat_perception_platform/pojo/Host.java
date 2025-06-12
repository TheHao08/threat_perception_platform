package com.tpp.threat_perception_platform.pojo;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Date;

/**
 * 
 * @TableName host
 */
public class Host {



    /**
     * 
=======
import java.util.Date;

/**
 * 主机表
 * @TableName host
 */
public class Host {
    /**
     * 自增id
>>>>>>> main
     */
    private Integer id;

    /**
<<<<<<< HEAD
     * 
     */
    private String hostName;

    /**
     * 
     */
    private String ipAddress;

    /**
     * 
=======
     * 主机mac地址
>>>>>>> main
     */
    private String macAddress;

    /**
<<<<<<< HEAD
     * 
=======
     * 主机的名字
     */
    private String hostName;

    /**
     * 主机的ip地址
     */
    private String ipAddress;

    /**
     * 主机的系统类型
>>>>>>> main
     */
    private String osType;

    /**
<<<<<<< HEAD
     * 
=======
     * 主机的操作系统名字
>>>>>>> main
     */
    private String osName;

    /**
<<<<<<< HEAD
     * 
=======
     * 主机操作系统版本号
>>>>>>> main
     */
    private String osVersion;

    /**
<<<<<<< HEAD
     * 
=======
     * 主机操作系统位数
>>>>>>> main
     */
    private String osBit;

    /**
<<<<<<< HEAD
     * 
=======
     * cpu名字
>>>>>>> main
     */
    private String cpuName;

    /**
<<<<<<< HEAD
     * 
=======
     * 主机内存大小
>>>>>>> main
     */
    private String ram;

    /**
<<<<<<< HEAD
     * 
=======
     * 主机状态：1在线 0下线
>>>>>>> main
     */
    private Integer status;

    /**
<<<<<<< HEAD
     * 
=======
     * 创建时间
>>>>>>> main
     */
    private Date createTime;

    /**
<<<<<<< HEAD
     * 
=======
     * 更新时间
>>>>>>> main
     */
    private Date updateTime;

    /**
<<<<<<< HEAD
     * 
=======
     * 自增id
>>>>>>> main
     */
    public Integer getId() {
        return id;
    }

    /**
<<<<<<< HEAD
     * 
=======
     * 自增id
>>>>>>> main
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
<<<<<<< HEAD
     * 
     */
    public String getHostName() {
        return hostName;
    }

    /**
     * 
     */
    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    /**
     * 
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * 
     */
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    /**
     * 
=======
     * 主机mac地址
>>>>>>> main
     */
    public String getMacAddress() {
        return macAddress;
    }

    /**
<<<<<<< HEAD
     * 
=======
     * 主机mac地址
>>>>>>> main
     */
    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    /**
<<<<<<< HEAD
     * 
=======
     * 主机的名字
     */
    public String getHostName() {
        return hostName;
    }

    /**
     * 主机的名字
     */
    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    /**
     * 主机的ip地址
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * 主机的ip地址
     */
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    /**
     * 主机的系统类型
>>>>>>> main
     */
    public String getOsType() {
        return osType;
    }

    /**
<<<<<<< HEAD
     * 
=======
     * 主机的系统类型
>>>>>>> main
     */
    public void setOsType(String osType) {
        this.osType = osType;
    }

    /**
<<<<<<< HEAD
     * 
=======
     * 主机的操作系统名字
>>>>>>> main
     */
    public String getOsName() {
        return osName;
    }

    /**
<<<<<<< HEAD
     * 
=======
     * 主机的操作系统名字
>>>>>>> main
     */
    public void setOsName(String osName) {
        this.osName = osName;
    }

    /**
<<<<<<< HEAD
     * 
=======
     * 主机操作系统版本号
>>>>>>> main
     */
    public String getOsVersion() {
        return osVersion;
    }

    /**
<<<<<<< HEAD
     * 
=======
     * 主机操作系统版本号
>>>>>>> main
     */
    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    /**
<<<<<<< HEAD
     * 
=======
     * 主机操作系统位数
>>>>>>> main
     */
    public String getOsBit() {
        return osBit;
    }

    /**
<<<<<<< HEAD
     * 
=======
     * 主机操作系统位数
>>>>>>> main
     */
    public void setOsBit(String osBit) {
        this.osBit = osBit;
    }

    /**
<<<<<<< HEAD
     * 
=======
     * cpu名字
>>>>>>> main
     */
    public String getCpuName() {
        return cpuName;
    }

    /**
<<<<<<< HEAD
     * 
=======
     * cpu名字
>>>>>>> main
     */
    public void setCpuName(String cpuName) {
        this.cpuName = cpuName;
    }

    /**
<<<<<<< HEAD
     * 
=======
     * 主机内存大小
>>>>>>> main
     */
    public String getRam() {
        return ram;
    }

    /**
<<<<<<< HEAD
     * 
=======
     * 主机内存大小
>>>>>>> main
     */
    public void setRam(String ram) {
        this.ram = ram;
    }

    /**
<<<<<<< HEAD
     * 
=======
     * 主机状态：1在线 0下线
>>>>>>> main
     */
    public Integer getStatus() {
        return status;
    }

    /**
<<<<<<< HEAD
     * 
=======
     * 主机状态：1在线 0下线
>>>>>>> main
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
<<<<<<< HEAD
     * 
=======
     * 创建时间
>>>>>>> main
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
<<<<<<< HEAD
     * 
=======
     * 创建时间
>>>>>>> main
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
<<<<<<< HEAD
     * 
=======
     * 更新时间
>>>>>>> main
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
<<<<<<< HEAD
     * 
=======
     * 更新时间
>>>>>>> main
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Host other = (Host) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
<<<<<<< HEAD
            && (this.getHostName() == null ? other.getHostName() == null : this.getHostName().equals(other.getHostName()))
            && (this.getIpAddress() == null ? other.getIpAddress() == null : this.getIpAddress().equals(other.getIpAddress()))
            && (this.getMacAddress() == null ? other.getMacAddress() == null : this.getMacAddress().equals(other.getMacAddress()))
=======
            && (this.getMacAddress() == null ? other.getMacAddress() == null : this.getMacAddress().equals(other.getMacAddress()))
            && (this.getHostName() == null ? other.getHostName() == null : this.getHostName().equals(other.getHostName()))
            && (this.getIpAddress() == null ? other.getIpAddress() == null : this.getIpAddress().equals(other.getIpAddress()))
>>>>>>> main
            && (this.getOsType() == null ? other.getOsType() == null : this.getOsType().equals(other.getOsType()))
            && (this.getOsName() == null ? other.getOsName() == null : this.getOsName().equals(other.getOsName()))
            && (this.getOsVersion() == null ? other.getOsVersion() == null : this.getOsVersion().equals(other.getOsVersion()))
            && (this.getOsBit() == null ? other.getOsBit() == null : this.getOsBit().equals(other.getOsBit()))
            && (this.getCpuName() == null ? other.getCpuName() == null : this.getCpuName().equals(other.getCpuName()))
            && (this.getRam() == null ? other.getRam() == null : this.getRam().equals(other.getRam()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
<<<<<<< HEAD
        result = prime * result + ((getHostName() == null) ? 0 : getHostName().hashCode());
        result = prime * result + ((getIpAddress() == null) ? 0 : getIpAddress().hashCode());
        result = prime * result + ((getMacAddress() == null) ? 0 : getMacAddress().hashCode());
=======
        result = prime * result + ((getMacAddress() == null) ? 0 : getMacAddress().hashCode());
        result = prime * result + ((getHostName() == null) ? 0 : getHostName().hashCode());
        result = prime * result + ((getIpAddress() == null) ? 0 : getIpAddress().hashCode());
>>>>>>> main
        result = prime * result + ((getOsType() == null) ? 0 : getOsType().hashCode());
        result = prime * result + ((getOsName() == null) ? 0 : getOsName().hashCode());
        result = prime * result + ((getOsVersion() == null) ? 0 : getOsVersion().hashCode());
        result = prime * result + ((getOsBit() == null) ? 0 : getOsBit().hashCode());
        result = prime * result + ((getCpuName() == null) ? 0 : getCpuName().hashCode());
        result = prime * result + ((getRam() == null) ? 0 : getRam().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
<<<<<<< HEAD
        sb.append(", hostName=").append(hostName);
        sb.append(", ipAddress=").append(ipAddress);
        sb.append(", macAddress=").append(macAddress);
=======
        sb.append(", macAddress=").append(macAddress);
        sb.append(", hostName=").append(hostName);
        sb.append(", ipAddress=").append(ipAddress);
>>>>>>> main
        sb.append(", osType=").append(osType);
        sb.append(", osName=").append(osName);
        sb.append(", osVersion=").append(osVersion);
        sb.append(", osBit=").append(osBit);
        sb.append(", cpuName=").append(cpuName);
        sb.append(", ram=").append(ram);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}