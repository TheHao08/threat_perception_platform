package com.tpp.threat_perception_platform.pojo;

/**
 * 
 * @TableName processes
 */
public class Processes {
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
    private Integer pid;

    /**
     * 
     */
    private Integer ppid;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String cmd;

    /**
     * 
     */
    private Integer priority;

    /**
     * 
     */
    private String description;

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
    public Integer getPid() {
        return pid;
    }

    /**
     * 
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * 
     */
    public Integer getPpid() {
        return ppid;
    }

    /**
     * 
     */
    public void setPpid(Integer ppid) {
        this.ppid = ppid;
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
    public String getCmd() {
        return cmd;
    }

    /**
     * 
     */
    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    /**
     * 
     */
    public Integer getPriority() {
        return priority;
    }

    /**
     * 
     */
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /**
     * 
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     */
    public void setDescription(String description) {
        this.description = description;
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
        Processes other = (Processes) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMacAddress() == null ? other.getMacAddress() == null : this.getMacAddress().equals(other.getMacAddress()))
            && (this.getPid() == null ? other.getPid() == null : this.getPid().equals(other.getPid()))
            && (this.getPpid() == null ? other.getPpid() == null : this.getPpid().equals(other.getPpid()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getCmd() == null ? other.getCmd() == null : this.getCmd().equals(other.getCmd()))
            && (this.getPriority() == null ? other.getPriority() == null : this.getPriority().equals(other.getPriority()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMacAddress() == null) ? 0 : getMacAddress().hashCode());
        result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
        result = prime * result + ((getPpid() == null) ? 0 : getPpid().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getCmd() == null) ? 0 : getCmd().hashCode());
        result = prime * result + ((getPriority() == null) ? 0 : getPriority().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
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
        sb.append(", pid=").append(pid);
        sb.append(", ppid=").append(ppid);
        sb.append(", name=").append(name);
        sb.append(", cmd=").append(cmd);
        sb.append(", priority=").append(priority);
        sb.append(", description=").append(description);
        sb.append("]");
        return sb.toString();
    }

    private Boolean danger;
    public void setDanger(Boolean danger) { this.danger = danger; }
    public Boolean getDanger() { return danger; }
    public String getPpidName() {
        if (ppid == null || ppid == 0) {
            return "N/A";
        }
        return String.valueOf(ppid);
    }
}