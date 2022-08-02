package com.mayurmishra.user.VO;

import com.mayurmishra.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Project - user-service
 * Created By MAYUR on 01/08/22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseTemplateVO {

    private User user;
    private Department department;
}
