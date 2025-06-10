package com.tpp.threat_perception_platform.param;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Getter
@Setter
public class AssetsParam {
    private Integer account = 0;
    private Integer service = 0;
    private Integer process = 0;
    private Integer app = 0;

    private String hostname;
    private String mac;
    private String type = "assets";

}
