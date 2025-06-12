package com.tpp.threat_perception_platform.param;

public class AssetsParam {

<<<<<<< HEAD
        private String hostName;

        private String macAddress;

        private String type;

        private Integer account = 0;

        private Integer service = 0;

        private Integer process = 0;

        private Integer app = 0;

        public AssetsParam() {}

        public Integer getAccount() {
            return account;
        }

        public void setAccount(Integer account) {
            this.account = account;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getMacAddress() {
            return macAddress;
        }

        public void setMacAddress(String macAddress) {
            this.macAddress = macAddress;
        }

        public String getHostName() {
            return hostName;
        }

        public void setHostName(String hostName) {
            this.hostName = hostName;
        }

        public Integer getService() {
            return service;
        }

        public void setService(Integer service) {
            this.service = service;
        }

        public Integer getProcess() {
            return process;
        }

        public void setProcess(Integer process) {
            this.process = process;
        }

        public Integer getApp() {
            return app;
        }

        public void setApp(Integer app) {
            this.app = app;
        }
=======
    private  String hostName; // 主机名称
    private  String macAddress; // 主机mac地址
    private String type; // 主机 类型
    private Integer account = 0; // 主机账号数
    private Integer service = 0; // 主机服务数
    private Integer process = 0; // 主机进程数
    private Integer app= 0   ; // 主机应用数
    private Integer page=1;
    private Integer limit=6;
    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getAccount() {
        return account;
    }

    public void setAccount(Integer account) {
        this.account = account;
    }

    public Integer getService() {
        return service;
    }

    public void setService(Integer service) {
        this.service = service;
    }

    public Integer getProcess() {
        return process;
    }

    public void setProcess(Integer process) {
        this.process = process;
    }

    public Integer getApp() {
        return app;
    }

    public void setApp(Integer app) {
        this.app = app;
    }
    public Integer getPage() {
        return page;
    }

    public  Integer getLimit() {
        return limit;
    }
>>>>>>> main
}
