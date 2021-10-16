package com.blockchainforum.dao;

import com.blockchainforum.entity.Thumbs;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ThumbsMapper {
    Thumbs selectById(int tid, int uid, int pid);
    int insertThumbs(int tid, int uid, int pid);
    int deleteThumbs(int tid);
    List<Thumbs> selectThumbsByUid(int uid);
}
