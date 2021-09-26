package com.blockchainforum.dao;

import com.blockchainforum.entity.Thumbs;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ThumbsMapper {
    Thumbs selectById(int uid, int pid, int tid);
    int insertThumbs(Thumbs thumbs);
    int updateThumbs(int uid, int pid, int tid);
}
