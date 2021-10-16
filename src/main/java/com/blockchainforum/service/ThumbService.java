package com.blockchainforum.service;

import com.blockchainforum.entity.Thumbs;

import java.util.Collection;

public interface ThumbService {
    public abstract void createThumbs(Thumbs thumbs);
    public abstract void deleteThumbs(int id);
    public abstract Collection<Thumbs> getThumbs();
}
