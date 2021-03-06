package com.wechat.music.provider.xiami;

import com.wechat.music.model.BaseBean;
import com.wechat.music.model.MusicLink;

@SuppressWarnings("SpellCheckingInspection")
class XiamiSongLink extends BaseBean implements MusicLink {

    public String url;

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public String getType() {
        return null;
    }

    @Override
    public long getSize() {
        return 0;
    }

    @Override
    public String getSongId() {
        return null;
    }

    @Override
    public long getBitRate() {
        return 0;
    }

    @Override
    public String getMd5() {
        return null;
    }
}
