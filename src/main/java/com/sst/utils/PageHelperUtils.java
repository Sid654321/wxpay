package com.sst.utils;

import com.github.pagehelper.PageHelper;

import java.util.HashMap;
import java.util.Map;

public class PageHelperUtils {
    public static void pageHelper(Entity entity){
        if (entity!=null&&entity.getPage()!=null&&entity.getLimit()!=null){
            PageHelper.startPage(entity.getPage(),entity.getLimit());
        }
    }


}
