package com.blockchainforum.dao;

import com.blockchainforum.entity.Thumbs;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ThumbsMapper {
    Thumbs selectById(int tid, int uid, int pid);
    int insertThumbs(Thumbs thumbs);
    int deleteThumbs(int tid, int uid, int pid);
}
