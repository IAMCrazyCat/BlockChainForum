package com.blockchainforum.service;

import com.blockchainforum.dao.ThumbsMapper;
import com.blockchainforum.entity.Thumbs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class ThumbServiceImpl implements ThumbService{
    //public static Map<Integer,Thumbs> thumbsMap=new HashMap<>();
    @Autowired
    private ThumbsMapper thumbsMapper;

    @Override
    public void createThumbs(Thumbs thumbs) {
        thumbsMapper.insertThumbs(thumbs.getTid(),thumbs.getUid(),thumbs.getPid());
    }

    @Override
    public void deleteThumbs(int id) {
        thumbsMapper.deleteThumbs(id);
    }

    @Override
    public List<Thumbs> getThumbs(int uid) {
        return thumbsMapper.selectThumbsByUid(uid);
    }
}
