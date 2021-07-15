package com.loti.dao.mapper;

import com.loti.dao.pojo.Entity.RealPaper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RPaperMapper {
    void InsertRPaper(RealPaper paper);
    RealPaper SelectRPaperByName(String name);
}
