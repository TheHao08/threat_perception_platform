package com.tpp.threat_perception_platform.pojo;

import java.util.Date;

/**
 * 
 * @TableName host
 */
public class Host {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String mac;

    /**
     * 
     */
    private String hostname;

    /**
     * 
     */
    private String ip;

    /**
     * 
     */
    private String osName;

    /**
     * 
     */
    private String osVersion;

    /**
     * 
     */
    private String osArch;

    /**
     * 
     */
    private String cpuName;

    /**
     * 
     */
    private String ram;

    /**
     * 1zaixai,0buzai

     */
    private Integer status;

    /**
     * 
     */
    private Date createtime;

    /**
     * 
     */
    private Date updatetime;

    /**
     * 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     */
    public String getMac() {
        return mac;
    }

    /**
     * 
     */
    public void setMac(String mac) {
        this.mac = mac;
    }

    /**
     * 
     */
    public String getHostname() {
        return hostname;
    }

    /**
     * 
     */
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    /**
     * 
     */
    public String getIp() {
        return ip;
    }

    /**
     * 
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * 
     */
    public String getOsName() {
        return osName;
    }

    /**
     * 
     */
    public void setOsName(String osName) {
        this.osName = osName;
    }

    /**
     * 
     */
    public String getOsVersion() {
        return osVersion;
    }

    /**
     * 
     */
    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    /**
     * 
     */
    public String getOsArch() {
        return osArch;
    }

    /**
     * 
     */
    public void setOsArch(String osArch) {
        this.osArch = osArch;
    }

    /**
     * 
     */
    public String getCpuName() {
        return cpuName;
    }

    /**
     * 
     */
    public void setCpuName(String cpuName) {
        this.cpuName = cpuName;
    }

    /**
     * 
     */
    public String getRam() {
        return ram;
    }

    /**
     * 
     */
    public void setRam(String ram) {
        this.ram = ram;
    }

    /**
     * 1zaixai,0buzai

     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 1zaixai,0buzai

     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * 
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
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
            && (this.getMac() == null ? other.getMac() == null : this.getMac().equals(other.getMac()))
            && (this.getHostname() == null ? other.getHostname() == null : this.getHostname().equals(other.getHostname()))
            && (this.getIp() == null ? other.getIp() == null : this.getIp().equals(other.getIp()))
            && (this.getOsName() == null ? other.getOsName() == null : this.getOsName().equals(other.getOsName()))
            && (this.getOsVersion() == null ? other.getOsVersion() == null : this.getOsVersion().equals(other.getOsVersion()))
            && (this.getOsArch() == null ? other.getOsArch() == null : this.getOsArch().equals(other.getOsArch()))
            && (this.getCpuName() == null ? other.getCpuName() == null : this.getCpuName().equals(other.getCpuName()))
            && (this.getRam() == null ? other.getRam() == null : this.getRam().equals(other.getRam()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getUpdatetime() == null ? other.getUpdatetime() == null : this.getUpdatetime().equals(other.getUpdatetime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMac() == null) ? 0 : getMac().hashCode());
        result = prime * result + ((getHostname() == null) ? 0 : getHostname().hashCode());
        result = prime * result + ((getIp() == null) ? 0 : getIp().hashCode());
        result = prime * result + ((getOsName() == null) ? 0 : getOsName().hashCode());
        result = prime * result + ((getOsVersion() == null) ? 0 : getOsVersion().hashCode());
        result = prime * result + ((getOsArch() == null) ? 0 : getOsArch().hashCode());
        result = prime * result + ((getCpuName() == null) ? 0 : getCpuName().hashCode());
        result = prime * result + ((getRam() == null) ? 0 : getRam().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getUpdatetime() == null) ? 0 : getUpdatetime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", mac=").append(mac);
        sb.append(", hostname=").append(hostname);
        sb.append(", ip=").append(ip);
        sb.append(", osName=").append(osName);
        sb.append(", osVersion=").append(osVersion);
        sb.append(", osArch=").append(osArch);
        sb.append(", cpuName=").append(cpuName);
        sb.append(", ram=").append(ram);
        sb.append(", status=").append(status);
        sb.append(", createtime=").append(createtime);
        sb.append(", updatetime=").append(updatetime);
        sb.append("]");
        return sb.toString();
    }
}