package com.wzu.oa.common.util;

import com.wzu.oa.common.entity.UserResource;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jack
 * @date 2018-01-24   16:09
 */
public class PrivilegeUtils {

    public static List<UserResource> getUserResource(Integer uid,Integer[] mids){
        List<UserResource> list = new ArrayList<>();
        if (mids!=null&& mids.length!=0){
            for (Integer i:mids){
                UserResource userResource = new UserResource(uid,i);
                list.add(userResource);
            }
        }
        return list;

    }
}
