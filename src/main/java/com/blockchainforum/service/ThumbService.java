package com.blockchainforum.service;

import com.blockchainforum.entity.Thumbs;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public interface ThumbService {
    public abstract void createThumbs(Thumbs thumbs);
    public abstract void deleteThumbs(int id);
    public abstract List<Thumbs> getThumbs(int uid);
}
