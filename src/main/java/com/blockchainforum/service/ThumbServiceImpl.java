package com.blockchainforum.service;

import com.blockchainforum.entity.Thumbs;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ThumbServiceImpl implements ThumbService{
    public static Map<Integer,Thumbs> thumbsMap=new HashMap<>();

    @Override
    public void createThumbs(Thumbs thumbs) {
        thumbsMap.put(thumbs.getTid(),thumbs);
    }

    @Override
    public void deleteThumbs(int id) {
        thumbsMap.remove(id);
    }

    @Override
    public Collection<Thumbs> getThumbs() {
        return thumbsMap.values();
    }
}
