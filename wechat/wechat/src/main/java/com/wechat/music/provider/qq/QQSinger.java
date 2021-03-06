package com.wechat.music.provider.qq;

import com.alibaba.fastjson.annotation.JSONField;
import com.wechat.music.model.Artist;
import com.wechat.music.model.BaseBean;

/**
 * Created by haohua on 2018/2/9.
 */
class QQSinger extends BaseBean implements Artist {
    @JSONField(name = "name")
    public String name;

    @JSONField(name = "mid")
    public String mid;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getId() {
        return mid;
    }
}
