package com.tpp.threat_perception_platform.pojo;

/**
 * 
 * @TableName app
 */
public class App {
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
    private String displayName;

    /**
     * 
     */
    private String installLocation;

    /**
     * 
     */
    private String uninstallString;

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
    public String getDisplayName() {
        return displayName;
    }

    /**
     * 
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * 
     */
    public String getInstallLocation() {
        return installLocation;
    }

    /**
     * 
     */
    public void setInstallLocation(String installLocation) {
        this.installLocation = installLocation;
    }

    /**
     * 
     */
    public String getUninstallString() {
        return uninstallString;
    }

    /**
     * 
     */
    public void setUninstallString(String uninstallString) {
        this.uninstallString = uninstallString;
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
        App other = (App) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMacAddress() == null ? other.getMacAddress() == null : this.getMacAddress().equals(other.getMacAddress()))
            && (this.getDisplayName() == null ? other.getDisplayName() == null : this.getDisplayName().equals(other.getDisplayName()))
            && (this.getInstallLocation() == null ? other.getInstallLocation() == null : this.getInstallLocation().equals(other.getInstallLocation()))
            && (this.getUninstallString() == null ? other.getUninstallString() == null : this.getUninstallString().equals(other.getUninstallString()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMacAddress() == null) ? 0 : getMacAddress().hashCode());
        result = prime * result + ((getDisplayName() == null) ? 0 : getDisplayName().hashCode());
        result = prime * result + ((getInstallLocation() == null) ? 0 : getInstallLocation().hashCode());
        result = prime * result + ((getUninstallString() == null) ? 0 : getUninstallString().hashCode());
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
        sb.append(", displayName=").append(displayName);
        sb.append(", installLocation=").append(installLocation);
        sb.append(", uninstallString=").append(uninstallString);
        sb.append("]");
        return sb.toString();
    }
}