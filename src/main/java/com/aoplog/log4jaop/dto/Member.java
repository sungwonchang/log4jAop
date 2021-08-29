package com.aoplog.log4jaop.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Member {
    String userId;
    String name;
    Integer age;
}
