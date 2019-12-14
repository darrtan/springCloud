package com.tan.springcloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
@Data
//链式写法
@Accessors(chain = true)
@NoArgsConstructor
public class Dept implements Serializable {
//    主键
    private Long dID;
    private String deptName;


    private String db_source;

    public Dept(String deptName) {
        this.deptName = deptName;
    }
}
