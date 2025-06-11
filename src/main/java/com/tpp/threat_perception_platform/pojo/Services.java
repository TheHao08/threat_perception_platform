package com.tpp.threat_perception_platform.pojo;

/**
 * 
 * @TableName services
 */
public class Services {
    /**
     * 
     */
    private Long id;

    /**
     * 
     */
    private String macAddress;

    /**
     * 
     */
    private String protocol;

    /**
     * 
     */
    private Integer port;

    /**
     * 
     */
    private String state;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String product;

    /**
     * 
     */
    private String version;

    /**
     * 
     */
    private String extrainfo;

    /**
     * 
     */
    public Long getId() {
        return id;
    }

    /**
     * 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 
     */
    public String getMacAddress() {
        return macAddress;
    }

    /**
     * 
     */
    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    /**
     * 
     */
    public String getProtocol() {
        return protocol;
    }

    /**
     * 
     */
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    /**
     * 
     */
    public Integer getPort() {
        return port;
    }

    /**
     * 
     */
    public void setPort(Integer port) {
        this.port = port;
    }

    /**
     * 
     */
    public String getState() {
        return state;
    }

    /**
     * 
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * 
     */
    public String getName() {
        return name;
    }

    /**
     * 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     */
    public String getProduct() {
        return product;
    }

    /**
     * 
     */
    public void setProduct(String product) {
        this.product = product;
    }

    /**
     * 
     */
    public String getVersion() {
        return version;
    }

    /**
     * 
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * 
     */
    public String getExtrainfo() {
        return extrainfo;
    }

    /**
     * 
     */
    public void setExtrainfo(String extrainfo) {
        this.extrainfo = extrainfo;
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
        Services other = (Services) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMacAddress() == null ? other.getMacAddress() == null : this.getMacAddress().equals(other.getMacAddress()))
            && (this.getProtocol() == null ? other.getProtocol() == null : this.getProtocol().equals(other.getProtocol()))
            && (this.getPort() == null ? other.getPort() == null : this.getPort().equals(other.getPort()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getProduct() == null ? other.getProduct() == null : this.getProduct().equals(other.getProduct()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()))
            && (this.getExtrainfo() == null ? other.getExtrainfo() == null : this.getExtrainfo().equals(other.getExtrainfo()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMacAddress() == null) ? 0 : getMacAddress().hashCode());
        result = prime * result + ((getProtocol() == null) ? 0 : getProtocol().hashCode());
        result = prime * result + ((getPort() == null) ? 0 : getPort().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getProduct() == null) ? 0 : getProduct().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        result = prime * result + ((getExtrainfo() == null) ? 0 : getExtrainfo().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", macAddress=").append(macAddress);
        sb.append(", protocol=").append(protocol);
        sb.append(", port=").append(port);
        sb.append(", state=").append(state);
        sb.append(", name=").append(name);
        sb.append(", product=").append(product);
        sb.append(", version=").append(version);
        sb.append(", extrainfo=").append(extrainfo);
        sb.append("]");
        return sb.toString();
    }
    // 在 Services.java 里
    private Boolean danger;

    public Boolean getDanger() { return danger; }
    public void setDanger(Boolean danger) { this.danger = danger; }
}