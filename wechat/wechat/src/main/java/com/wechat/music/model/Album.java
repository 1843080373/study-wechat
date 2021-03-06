package com.wechat.music.model;

import java.io.Serializable;
import java.util.List;

import com.wechat.music.api.MusicProvider;

/**
 * Created by haohua on 2018/2/11.
 */
public interface Album extends Serializable {
    String getName();

    String getAlbumId();

    List<? extends Artist> getArtists();

    /**
     * 获得多个artists格式化后的字符串
     *
     * @return
     */
    String getFormattedArtistsString();

    List<? extends Song> getSongs();

    MusicProvider getMusicProvider();
}
