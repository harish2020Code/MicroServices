package com.project.user.service.VO;

import com.project.user.service.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ResponseTemplateVO {
    private Users user;
    private Department department;
}