package com.xiyan.service;


import com.xiyan.model.entrty.User;
import com.xiyan.model.utils.APIResponse;

import java.util.List;

/**
 * @antuor binwang
 * @date 2018/1/24  16:21
 */
public interface UserService {
    APIResponse<List<User>> selectAllUser();
    APIResponse<Integer> insertUser(User user);
}
