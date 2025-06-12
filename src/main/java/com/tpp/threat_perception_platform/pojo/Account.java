package com.tpp.threat_perception_platform.pojo;

/**
<<<<<<< HEAD
 *
=======
 * 
>>>>>>> main
 * @TableName account
 */
public class Account {
    /**
<<<<<<< HEAD
     *
=======
     * 
>>>>>>> main
     */
    private Long id;

    /**
<<<<<<< HEAD
     *
=======
     * 
>>>>>>> main
     */
    private String macAddress;


    /**
     * 主机mac地址
     */

    /**
<<<<<<< HEAD
     *
=======
     * 
>>>>>>> main
     */
    private String name;

    /**
<<<<<<< HEAD
     *
=======
     * 
>>>>>>> main
     */
    private String fullName;

    /**
<<<<<<< HEAD
     *
=======
     * 
>>>>>>> main
     */
    private String sid;

    /**
<<<<<<< HEAD
     *
=======
     * 
>>>>>>> main
     */
    private Integer sidType;

    /**
<<<<<<< HEAD
     *
=======
     * 
>>>>>>> main
     */
    private String status;

    /**
<<<<<<< HEAD
     *
=======
     * 
>>>>>>> main
     */
    private Integer disabled;

    /**
<<<<<<< HEAD
     *
=======
     * 
>>>>>>> main
     */
    private Integer lockout;

    /**
<<<<<<< HEAD
     *
=======
     * 
>>>>>>> main
     */
    private Integer passwordChangeable;

    /**
<<<<<<< HEAD
     *
=======
     * 
>>>>>>> main
     */
    private Integer passwordExpires;

    /**
<<<<<<< HEAD
     *
=======
     * 
>>>>>>> main
     */
    private Integer passwordRequired;

    /**
<<<<<<< HEAD
     *
     */
=======
     * 
     */
    // src/main/java/com/tpp/threat_perception_platform/pojo/Account.java
    private boolean danger; // 新增字段

    public boolean isDanger() { return danger; }
    public void setDanger(boolean danger) { this.danger = danger; }
>>>>>>> main
    public Long getId() {
        return id;
    }

<<<<<<< HEAD
    /**
     *
=======
       /**
     * 
>>>>>>> main
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
<<<<<<< HEAD
     *
=======
     * 
>>>>>>> main
     */
    public String getMacAddress() {
        return macAddress;
    }

    /**
<<<<<<< HEAD
     *
=======
     * 
>>>>>>> main
     */
    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    /**
<<<<<<< HEAD
     *
=======
     * 
>>>>>>> main
     */
    public String getName() {
        return name;
    }

    /**
<<<<<<< HEAD
     *
=======
     * 
>>>>>>> main
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
<<<<<<< HEAD
     *
=======
     * 
>>>>>>> main
     */
    public String getFullName() {
        return fullName;
    }

    /**
<<<<<<< HEAD
     *
=======
     * 
>>>>>>> main
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
<<<<<<< HEAD
     *
=======
     * 
>>>>>>> main
     */
    public String getSid() {
        return sid;
    }

    /**
<<<<<<< HEAD
     *
=======
     * 
>>>>>>> main
     */
    public void setSid(String sid) {
        this.sid = sid;
    }

    /**
<<<<<<< HEAD
     *
=======
     * 
>>>>>>> main
     */
    public Integer getSidType() {
        return sidType;
    }

    /**
<<<<<<< HEAD
     *
=======
     * 
>>>>>>> main
     */
    public void setSidType(Integer sidType) {
        this.sidType = sidType;
    }

    /**
<<<<<<< HEAD
     *
=======
     * 
>>>>>>> main
     */
    public String getStatus() {
        return status;
    }

    /**
<<<<<<< HEAD
     *
=======
     * 
>>>>>>> main
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
<<<<<<< HEAD
     *
=======
     * 
>>>>>>> main
     */
    public Integer getDisabled() {
        return disabled;
    }

    /**
<<<<<<< HEAD
     *
=======
     * 
>>>>>>> main
     */
    public void setDisabled(Integer disabled) {
        this.disabled = disabled;
    }

    /**
<<<<<<< HEAD
     *
=======
     * 
>>>>>>> main
     */
    public Integer getLockout() {
        return lockout;
    }

    /**
<<<<<<< HEAD
     *
=======
     * 
>>>>>>> main
     */
    public void setLockout(Integer lockout) {
        this.lockout = lockout;
    }

    /**
<<<<<<< HEAD
     *
=======
     * 
>>>>>>> main
     */
    public Integer getPasswordChangeable() {
        return passwordChangeable;
    }

    /**
<<<<<<< HEAD
     *
=======
     * 
>>>>>>> main
     */
    public void setPasswordChangeable(Integer passwordChangeable) {
        this.passwordChangeable = passwordChangeable;
    }

    /**
<<<<<<< HEAD
     *
=======
     * 
>>>>>>> main
     */
    public Integer getPasswordExpires() {
        return passwordExpires;
    }

    /**
<<<<<<< HEAD
     *
=======
     * 
>>>>>>> main
     */
    public void setPasswordExpires(Integer passwordExpires) {
        this.passwordExpires = passwordExpires;
    }

    /**
<<<<<<< HEAD
     *
=======
     * 
>>>>>>> main
     */
    public Integer getPasswordRequired() {
        return passwordRequired;
    }

    /**
<<<<<<< HEAD
     *
=======
     * 
>>>>>>> main
     */
    public void setPasswordRequired(Integer passwordRequired) {
        this.passwordRequired = passwordRequired;
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
        Account other = (Account) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
<<<<<<< HEAD
                && (this.getMacAddress() == null ? other.getMacAddress() == null : this.getMacAddress().equals(other.getMacAddress()))
                && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
                && (this.getFullName() == null ? other.getFullName() == null : this.getFullName().equals(other.getFullName()))
                && (this.getSid() == null ? other.getSid() == null : this.getSid().equals(other.getSid()))
                && (this.getSidType() == null ? other.getSidType() == null : this.getSidType().equals(other.getSidType()))
                && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
                && (this.getDisabled() == null ? other.getDisabled() == null : this.getDisabled().equals(other.getDisabled()))
                && (this.getLockout() == null ? other.getLockout() == null : this.getLockout().equals(other.getLockout()))
                && (this.getPasswordChangeable() == null ? other.getPasswordChangeable() == null : this.getPasswordChangeable().equals(other.getPasswordChangeable()))
                && (this.getPasswordExpires() == null ? other.getPasswordExpires() == null : this.getPasswordExpires().equals(other.getPasswordExpires()))
                && (this.getPasswordRequired() == null ? other.getPasswordRequired() == null : this.getPasswordRequired().equals(other.getPasswordRequired()));
=======
            && (this.getMacAddress() == null ? other.getMacAddress() == null : this.getMacAddress().equals(other.getMacAddress()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getFullName() == null ? other.getFullName() == null : this.getFullName().equals(other.getFullName()))
            && (this.getSid() == null ? other.getSid() == null : this.getSid().equals(other.getSid()))
            && (this.getSidType() == null ? other.getSidType() == null : this.getSidType().equals(other.getSidType()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getDisabled() == null ? other.getDisabled() == null : this.getDisabled().equals(other.getDisabled()))
            && (this.getLockout() == null ? other.getLockout() == null : this.getLockout().equals(other.getLockout()))
            && (this.getPasswordChangeable() == null ? other.getPasswordChangeable() == null : this.getPasswordChangeable().equals(other.getPasswordChangeable()))
            && (this.getPasswordExpires() == null ? other.getPasswordExpires() == null : this.getPasswordExpires().equals(other.getPasswordExpires()))
            && (this.getPasswordRequired() == null ? other.getPasswordRequired() == null : this.getPasswordRequired().equals(other.getPasswordRequired()));
>>>>>>> main
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMacAddress() == null) ? 0 : getMacAddress().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getFullName() == null) ? 0 : getFullName().hashCode());
        result = prime * result + ((getSid() == null) ? 0 : getSid().hashCode());
        result = prime * result + ((getSidType() == null) ? 0 : getSidType().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getDisabled() == null) ? 0 : getDisabled().hashCode());
        result = prime * result + ((getLockout() == null) ? 0 : getLockout().hashCode());
        result = prime * result + ((getPasswordChangeable() == null) ? 0 : getPasswordChangeable().hashCode());
        result = prime * result + ((getPasswordExpires() == null) ? 0 : getPasswordExpires().hashCode());
        result = prime * result + ((getPasswordRequired() == null) ? 0 : getPasswordRequired().hashCode());
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
        sb.append(", name=").append(name);
        sb.append(", fullName=").append(fullName);
        sb.append(", sid=").append(sid);
        sb.append(", sidType=").append(sidType);
        sb.append(", status=").append(status);
        sb.append(", disabled=").append(disabled);
        sb.append(", lockout=").append(lockout);
        sb.append(", passwordChangeable=").append(passwordChangeable);
        sb.append(", passwordExpires=").append(passwordExpires);
        sb.append(", passwordRequired=").append(passwordRequired);
        sb.append("]");
        return sb.toString();
    }
}