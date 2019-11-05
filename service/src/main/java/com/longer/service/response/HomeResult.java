package com.longer.service.response;

import java.io.Serializable;
import java.util.List;

public class HomeResult extends BaseResult {

    @Override
    public String toString() {
        return "HomeResult{" +
                "nextPageUrl='" + nextPageUrl + '\'' +
                ", nextPublishTime=" + nextPublishTime +
                ", newestIssueType='" + newestIssueType + '\'' +
                ", dialog=" + dialog +
                ", issueList=" + issueList +
                '}';
    }

    /**
     * issueList : [{"releaseTime":1563152400000,"type":"morning","date":1563152400000,"publishTime":1563152400000,"itemList":[{"type":"video","data":{"dataType":"VideoBeanForClient","id":166575,"title":"人类让自己成为上帝，就把天堂变成了地狱","description":"如果「三体」是部电影，那么说这部短片是它的预告也不为过。2048 年，机器人 Chris 和 Charlie 终于进入「人类种族复活计划」的最后一天，可已经彻底对人失望的 Chris 决定「毁灭计划，将地球交给某个外星球统治」\u2026\u2026「Friday」是作者的毕业作品，灵感来源于科幻小说「三体」。除了暗喻人类在地球肆无忌惮的破坏，作者对短片的另一种解释是「这里的人类代表耶稣，人类的灭绝则代表了被钉死在十字架上的信仰」。Chris 当然知道这一天是「星期五」，他也知道人类如何把地球变成了地狱。","library":"DAILY","tags":[{"id":744,"name":"每日创意灵感","actionUrl":"eyepetizer://tag/744/?title=%E6%AF%8F%E6%97%A5%E5%88%9B%E6%84%8F%E7%81%B5%E6%84%9F","adTrack":null,"desc":"技术与审美结合，探索视觉的无限可能","bgPicture":"http://img.kaiyanapp.com/bc2479c09cd15cb93b69d82e5f21c3fc.png?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/bc2479c09cd15cb93b69d82e5f21c3fc.png?imageMogr2/quality/60/format/jpg","tagRecType":"IMPORTANT","childTagList":null,"childTagIdList":null,"communityIndex":0},{"id":74,"name":"CG","actionUrl":"eyepetizer://tag/74/?title=CG","adTrack":null,"desc":null,"bgPicture":"http://img.kaiyanapp.com/fdac34e3c19adf85704b039126edef52.jpeg?imageMogr2/quality/100","headerImage":"http://img.kaiyanapp.com/e2a1eec9efb7e7d0abca85bbdedc425b.jpeg?imageMogr2/quality/100","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"communityIndex":0},{"id":122,"name":"科幻","actionUrl":"eyepetizer://tag/122/?title=%E7%A7%91%E5%B9%BB","adTrack":null,"desc":null,"bgPicture":"http://img.kaiyanapp.com/417a8466c670ccde688bb4b525ddf23d.jpeg?imageMogr2/quality/100","headerImage":"http://img.kaiyanapp.com/114beec25470880881352171834ddf43.jpeg?imageMogr2/quality/60","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"communityIndex":0},{"id":2,"name":"创意","actionUrl":"eyepetizer://tag/2/?title=%E5%88%9B%E6%84%8F","adTrack":null,"desc":"技术与审美结合，探索视觉的无限可能","bgPicture":"http://img.kaiyanapp.com/1b457058cf2b317304ff9f70543c040d.png?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/fdefdb34cbe3d2ac9964d306febe9025.jpeg?imageMogr2/quality/100","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"communityIndex":0}],"consumption":{"collectionCount":716,"shareCount":203,"replyCount":25},"resourceType":"video","slogan":"如果「三体」是部电影，这就是一切的序章","provider":{"name":"Vimeo","alias":"vimeo","icon":"http://img.kaiyanapp.com/c3ad630be461cbb081649c9e21d6cbe3.png"},"category":"创意","author":{"id":4623,"icon":"http://img.kaiyanapp.com/a7df8dcfdfdbdd4f8c2275dc5e30bcae.png?imageMogr2/quality/60/format/jpg","name":"姓萧的陈冠森","description":"3D Generalist \\ VFX\nEmail: edison6@foxmail.com","link":"","latestReleaseTime":1563152409000,"videoNum":1,"adTrack":null,"follow":{"itemType":"author","itemId":4623,"followed":false},"shield":{"itemType":"author","itemId":4623,"shielded":false},"approvedNotReadyVideoCount":0,"ifPgc":true,"recSort":0,"expert":false},"cover":{"feed":"http://img.kaiyanapp.com/fb9f6263539fba0eced53a770f33ff36.jpeg?imageMogr2/quality/60/format/jpg","detail":"http://img.kaiyanapp.com/fb9f6263539fba0eced53a770f33ff36.jpeg?imageMogr2/quality/60/format/jpg","blurred":"http://img.kaiyanapp.com/b7182c612d5387b79900d3f6214244ca.jpeg?imageMogr2/quality/60/format/jpg","sharing":null,"homepage":"http://img.kaiyanapp.com/fb9f6263539fba0eced53a770f33ff36.jpeg?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim"},"playUrl":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=166575&resourceType=video&editionType=default&source=aliyun&playUrlType=url_oss","thumbPlayUrl":null,"duration":194,"webUrl":{"raw":"http://www.eyepetizer.net/detail.html?vid=166575","forWeibo":"http://www.eyepetizer.net/detail.html?vid=166575"},"releaseTime":1563152409000,"playInfo":[{"height":488,"width":854,"urlList":[{"name":"aliyun","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=166575&resourceType=video&editionType=normal&source=aliyun&playUrlType=url_oss","size":9221251},{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=166575&resourceType=video&editionType=normal&source=qcloud&playUrlType=url_oss","size":9221251},{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=166575&resourceType=video&editionType=normal&source=ucloud&playUrlType=url_oss","size":9221251}],"name":"标清","type":"normal","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=166575&resourceType=video&editionType=normal&source=aliyun&playUrlType=url_oss"},{"height":732,"width":1280,"urlList":[{"name":"aliyun","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=166575&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss","size":16793750},{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=166575&resourceType=video&editionType=high&source=qcloud&playUrlType=url_oss","size":16793750},{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=166575&resourceType=video&editionType=high&source=ucloud&playUrlType=url_oss","size":16793750}],"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=166575&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss"}],"campaign":null,"waterMarks":null,"ad":false,"adTrack":null,"type":"NORMAL","titlePgc":null,"descriptionPgc":null,"remark":"","ifLimitVideo":false,"searchWeight":0,"idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1563152400000,"promotion":null,"label":null,"labelList":[],"descriptionEditor":"如果「三体」是部电影，那么说这部短片是它的预告也不为过。2048 年，机器人 Chris 和 Charlie 终于进入「人类种族复活计划」的最后一天，可已经彻底对人失望的 Chris 决定「毁灭计划，将地球交给某个外星球统治」\u2026\u2026「Friday」是作者的毕业作品，灵感来源于科幻小说「三体」。除了暗喻人类在地球肆无忌惮的破坏，作者对短片的另一种解释是「这里的人类代表耶稣，人类的灭绝则代表了被钉死在十字架上的信仰」。Chris 当然知道这一天是「星期五」，他也知道人类如何把地球变成了地狱。","collected":false,"played":false,"subtitles":[],"lastViewTime":null,"playlists":null,"src":null},"tag":null,"id":0,"adIndex":-1},{"type":"video","data":{"dataType":"VideoBeanForClient","id":165613,"title":"青春期的爱和性，是那一年我们都会经历的事","description":"你知道为什么爱的形状是一个红色的心吗？","library":"DAILY","tags":[{"id":14,"name":"动画梦工厂","actionUrl":"eyepetizer://tag/14/?title=%E5%8A%A8%E7%94%BB%E6%A2%A6%E5%B7%A5%E5%8E%82","adTrack":null,"desc":"有趣的人永远不缺童心","bgPicture":"http://img.kaiyanapp.com/afb9e7d7f061d10ade5ebcb524dc8679.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/f9eae3e0321fa1e99a7b38641b5536a2.jpeg?imageMogr2/quality/60/format/jpg","tagRecType":"IMPORTANT","childTagList":null,"childTagIdList":null,"communityIndex":0},{"id":150,"name":"青春","actionUrl":"eyepetizer://tag/150/?title=%E9%9D%92%E6%98%A5","adTrack":null,"desc":null,"bgPicture":"http://img.kaiyanapp.com/34d33f611dbfe38e4d00cd4ab43212e7.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/58e3e0ec1e583a6debcc0f80d16c86fe.jpeg?imageMogr2/quality/100","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"communityIndex":0},{"id":1023,"name":"动画","actionUrl":"eyepetizer://tag/1023/?title=%E5%8A%A8%E7%94%BB","adTrack":null,"desc":"有趣的人永远不缺童心","bgPicture":"http://img.kaiyanapp.com/349cbd33cdf71fc74d5e9c7a00b444fd.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/208aa67386c045497389f015ae28dd29.jpeg?imageMogr2/quality/60/format/jpg","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"communityIndex":0},{"id":773,"name":"脑洞大开","actionUrl":"eyepetizer://tag/773/?title=%E8%84%91%E6%B4%9E%E5%A4%A7%E5%BC%80","adTrack":null,"desc":null,"bgPicture":"http://img.kaiyanapp.com/25f37613bb960c36438b7b335b40f690.png?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/25f37613bb960c36438b7b335b40f690.png?imageMogr2/quality/60/format/jpg","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"communityIndex":0},{"id":128,"name":"污","actionUrl":"eyepetizer://tag/128/?title=%E6%B1%A1","adTrack":null,"desc":null,"bgPicture":"http://img.kaiyanapp.com/4bb010aab06fe32397359def83e4e47c.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/5897def623ef2313849502049047dea1.jpeg?imageMogr2/quality/60/format/jpg","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"communityIndex":0}],"consumption":{"collectionCount":505,"shareCount":182,"replyCount":10},"resourceType":"video","slogan":"狗仔式的爱「Doggy Love」","provider":{"name":"PGC","alias":"PGC","icon":""},"category":"动画","author":{"id":168,"icon":"http://img.kaiyanapp.com/31588812d55435318fef0983e09a19a2.jpeg?imageMogr2/quality/60","name":"NOWNESS现在","description":"全球创意生活短片平台","link":"","latestReleaseTime":1562063379000,"videoNum":79,"adTrack":null,"follow":{"itemType":"author","itemId":168,"followed":false},"shield":{"itemType":"author","itemId":168,"shielded":false},"approvedNotReadyVideoCount":0,"ifPgc":true,"recSort":0,"expert":false},"cover":{"feed":"http://img.kaiyanapp.com/03479f78907817ede8421dfed1b29fa1.jpeg?imageMogr2/quality/60/format/jpg","detail":"http://img.kaiyanapp.com/03479f78907817ede8421dfed1b29fa1.jpeg?imageMogr2/quality/60/format/jpg","blurred":"http://img.kaiyanapp.com/9c89b271f9419cff3768170f81b8de54.jpeg?imageMogr2/quality/60/format/jpg","sharing":null,"homepage":"http://img.kaiyanapp.com/03479f78907817ede8421dfed1b29fa1.jpeg?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim"},"playUrl":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=165613&resourceType=video&editionType=default&source=aliyun&playUrlType=url_oss","thumbPlayUrl":null,"duration":359,"webUrl":{"raw":"http://www.eyepetizer.net/detail.html?vid=165613","forWeibo":"http://www.eyepetizer.net/detail.html?vid=165613&resourceType=video&utm_campaign=routine&utm_medium=share&utm_source=weibo&uid=0"},"releaseTime":1562060420000,"playInfo":[{"height":480,"width":854,"urlList":[{"name":"aliyun","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=165613&resourceType=video&editionType=normal&source=aliyun&playUrlType=url_oss","size":25401390},{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=165613&resourceType=video&editionType=normal&source=qcloud&playUrlType=url_oss","size":25401390},{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=165613&resourceType=video&editionType=normal&source=ucloud&playUrlType=url_oss","size":25401390}],"name":"标清","type":"normal","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=165613&resourceType=video&editionType=normal&source=aliyun&playUrlType=url_oss"},{"height":720,"width":1280,"urlList":[{"name":"aliyun","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=165613&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss","size":39794748},{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=165613&resourceType=video&editionType=high&source=qcloud&playUrlType=url_oss","size":39794748},{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=165613&resourceType=video&editionType=high&source=ucloud&playUrlType=url_oss","size":39794748}],"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=165613&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss"}],"campaign":null,"waterMarks":null,"ad":false,"adTrack":null,"type":"NORMAL","titlePgc":"狗仔式的愛 Doggy Love","descriptionPgc":"Do you know the reason why love is shown in the shape of a red heart?你知道为什么爱的形状是一个红色的心吗？","remark":"","ifLimitVideo":false,"searchWeight":0,"idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1563152400000,"promotion":null,"label":null,"labelList":[],"descriptionEditor":"你知道为什么爱的形状是一个红色的心吗？","collected":false,"played":false,"subtitles":[],"lastViewTime":null,"playlists":null,"src":null},"tag":null,"id":0,"adIndex":-1},{"type":"video","data":{"dataType":"VideoBeanForClient","id":151149,"title":"逃离现实的最好方法：无计划旅行","description":"不要害怕错过风景，因为只有你喜欢的时候，一朵云才变成了风景。所谓真正意义的「旅行」，是扔掉一切期望和规划，是找到看世界的新方法。摄影师 Rob Strok 在迪拜、阿曼、纽约三个城市进行了无计划旅行。先别急着酸，周末买张机票，你也是主角。From Rob Strok","library":"DAILY","tags":[{"id":10,"name":"跟着开眼看世界","actionUrl":"eyepetizer://tag/10/?title=%E8%B7%9F%E7%9D%80%E5%BC%80%E7%9C%BC%E7%9C%8B%E4%B8%96%E7%95%8C","adTrack":null,"desc":"去你想去的地方，发现世界的美","bgPicture":"http://img.kaiyanapp.com/7ea328a893aa1f092b9328a53494a267.png?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/50dab5468ecd2dbe5eb99dab5d608a0a.jpeg?imageMogr2/quality/60/format/jpg","tagRecType":"IMPORTANT","childTagList":null,"childTagIdList":null,"communityIndex":0},{"id":721,"name":"旅行灵感","actionUrl":"eyepetizer://tag/721/?title=%E6%97%85%E8%A1%8C%E7%81%B5%E6%84%9F","adTrack":null,"desc":"","bgPicture":"http://img.kaiyanapp.com/32b7e220d9c012c96e5f9a68e6f3ad9a.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/32b7e220d9c012c96e5f9a68e6f3ad9a.jpeg?imageMogr2/quality/60/format/jpg","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"communityIndex":0},{"id":1019,"name":"旅行","actionUrl":"eyepetizer://tag/1019/?title=%E6%97%85%E8%A1%8C","adTrack":null,"desc":"世界这么大，总有你的目的地","bgPicture":"http://img.kaiyanapp.com/67b5aa7b489b33e7894e04d293e9b01f.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/67b5aa7b489b33e7894e04d293e9b01f.jpeg?imageMogr2/quality/60/format/jpg","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"communityIndex":0}],"consumption":{"collectionCount":213,"shareCount":105,"replyCount":9},"resourceType":"video","slogan":"只有你喜欢的时候，一朵云才变成了风景","provider":{"name":"YouTube","alias":"youtube","icon":"http://img.kaiyanapp.com/fa20228bc5b921e837156923a58713f6.png"},"category":"旅行","author":{"id":2164,"icon":"http://img.kaiyanapp.com/75bc791c5f6cc239d6056e0a52d077fd.jpeg?imageMogr2/quality/60/format/jpg","name":"开眼旅行精选","description":"发现世界的奇妙和辽阔","link":"","latestReleaseTime":1563152413000,"videoNum":567,"adTrack":null,"follow":{"itemType":"author","itemId":2164,"followed":false},"shield":{"itemType":"author","itemId":2164,"shielded":false},"approvedNotReadyVideoCount":0,"ifPgc":true,"recSort":0,"expert":false},"cover":{"feed":"http://img.kaiyanapp.com/329e87c401df4d4df1007d4631651d0e.jpeg?imageMogr2/quality/60/format/jpg","detail":"http://img.kaiyanapp.com/329e87c401df4d4df1007d4631651d0e.jpeg?imageMogr2/quality/60/format/jpg","blurred":"http://img.kaiyanapp.com/e5e3782793cccc0cfdc5a2f16f9d30b1.jpeg?imageMogr2/quality/60/format/jpg","sharing":null,"homepage":"http://img.kaiyanapp.com/329e87c401df4d4df1007d4631651d0e.jpeg?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim"},"playUrl":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=151149&resourceType=video&editionType=default&source=aliyun&playUrlType=url_oss","thumbPlayUrl":null,"duration":583,"webUrl":{"raw":"http://www.eyepetizer.net/detail.html?vid=151149","forWeibo":"http://www.eyepetizer.net/detail.html?vid=151149&resourceType=video&utm_campaign=routine&utm_medium=share&utm_source=weibo&uid=0"},"releaseTime":1563152413000,"playInfo":[{"height":480,"width":854,"urlList":[{"name":"aliyun","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=151149&resourceType=video&editionType=normal&source=aliyun&playUrlType=url_oss","size":46414818},{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=151149&resourceType=video&editionType=normal&source=qcloud&playUrlType=url_oss","size":46414818},{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=151149&resourceType=video&editionType=normal&source=ucloud&playUrlType=url_oss","size":46414818}],"name":"标清","type":"normal","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=151149&resourceType=video&editionType=normal&source=aliyun&playUrlType=url_oss"},{"height":720,"width":1280,"urlList":[{"name":"aliyun","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=151149&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss","size":76068730},{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=151149&resourceType=video&editionType=high&source=qcloud&playUrlType=url_oss","size":76068730},{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=151149&resourceType=video&editionType=high&source=ucloud&playUrlType=url_oss","size":76068730}],"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=151149&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss"}],"campaign":null,"waterMarks":null,"ad":false,"adTrack":null,"type":"NORMAL","titlePgc":null,"descriptionPgc":null,"remark":"","ifLimitVideo":false,"searchWeight":0,"idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1563152400000,"promotion":null,"label":null,"labelList":[],"descriptionEditor":"不要害怕错过风景，因为只有你喜欢的时候，一朵云才变成了风景。所谓真正意义的「旅行」，是扔掉一切期望和规划，是找到看世界的新方法。摄影师 Rob Strok 在迪拜、阿曼、纽约三个城市进行了无计划旅行。先别急着酸，周末买张机票，你也是主角。From Rob Strok","collected":false,"played":false,"subtitles":[],"lastViewTime":null,"playlists":null,"src":null},"tag":null,"id":0,"adIndex":-1},{"type":"video","data":{"dataType":"VideoBeanForClient","id":124274,"title":"这些动物狠起来连自己人都吃","description":"生物进化的基本法则就是：适者生存，弱肉强食。动物之间经常会有同类相食的情境发生，通常是独居的动物会猎杀任何体型适合的猎物，甚至交配对象。对于动物来说，同类相食和其他行为一样都是生活中常见的一部分，一切都是为了生存和繁衍。","library":"DAILY","tags":[{"id":44,"name":"5 分钟新知","actionUrl":"eyepetizer://tag/44/?title=5%20%E5%88%86%E9%92%9F%E6%96%B0%E7%9F%A5","adTrack":null,"desc":"大千世界，总有你不知道的","bgPicture":"http://img.kaiyanapp.com/f2e7359e81e217782f32cc3d482b3284.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/f2e7359e81e217782f32cc3d482b3284.jpeg?imageMogr2/quality/60/format/jpg","tagRecType":"IMPORTANT","childTagList":null,"childTagIdList":null,"communityIndex":0},{"id":1040,"name":"科普","actionUrl":"eyepetizer://tag/1040/?title=%E7%A7%91%E6%99%AE","adTrack":null,"desc":null,"bgPicture":"http://img.kaiyanapp.com/86af95dab03ab8fac3342517e83b07bb.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/86af95dab03ab8fac3342517e83b07bb.jpeg?imageMogr2/quality/60/format/jpg","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"communityIndex":0},{"id":1024,"name":"科技","actionUrl":"eyepetizer://tag/1024/?title=%E7%A7%91%E6%8A%80","adTrack":null,"desc":"新知识与一切先进生产力","bgPicture":"http://img.kaiyanapp.com/7e326064edc565ac6355921cfe4b3e46.png?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/810adad06df812462bb0e00501fa679c.png?imageMogr2/quality/60/format/jpg","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"communityIndex":0},{"id":865,"name":"自然科学","actionUrl":"eyepetizer://tag/865/?title=%E8%87%AA%E7%84%B6%E7%A7%91%E5%AD%A6","adTrack":null,"desc":null,"bgPicture":"http://img.kaiyanapp.com/b51563fb04cfedd7f4ac80d63bc3a328.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/06e1989d9752bb1b3097d7e643640ed6.png?imageMogr2/quality/60/format/jpg","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"communityIndex":0}],"consumption":{"collectionCount":286,"shareCount":157,"replyCount":10},"resourceType":"video","slogan":"同类相食\u2014\u2014适者生存的另一种表现","provider":{"name":"YouTube","alias":"youtube","icon":"http://img.kaiyanapp.com/fa20228bc5b921e837156923a58713f6.png"},"category":"科技","author":{"id":2398,"icon":"http://img.kaiyanapp.com/5e4a548d975069f7d7d1b1fe22286b3e.jpeg?imageMogr2/quality/60/format/jpg","name":"TED-Ed","description":"TED-Ed 致力于与更多的动画师和教育学者共同创造出更多优秀的科普视频。","link":"","latestReleaseTime":1562821533000,"videoNum":495,"adTrack":null,"follow":{"itemType":"author","itemId":2398,"followed":false},"shield":{"itemType":"author","itemId":2398,"shielded":false},"approvedNotReadyVideoCount":0,"ifPgc":true,"recSort":0,"expert":false},"cover":{"feed":"http://img.kaiyanapp.com/8e9682dcbe2b8b5da2b3b40c5ec9c5eb.png?imageMogr2/quality/60/format/jpg","detail":"http://img.kaiyanapp.com/8e9682dcbe2b8b5da2b3b40c5ec9c5eb.png?imageMogr2/quality/60/format/jpg","blurred":"http://img.kaiyanapp.com/4ba0be1968eb94842094f94450ffc2d3.png?imageMogr2/quality/60/format/jpg","sharing":null,"homepage":"http://img.kaiyanapp.com/8e9682dcbe2b8b5da2b3b40c5ec9c5eb.png?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim"},"playUrl":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=124274&resourceType=video&editionType=default&source=aliyun&playUrlType=url_oss","thumbPlayUrl":null,"duration":297,"webUrl":{"raw":"http://www.eyepetizer.net/detail.html?vid=124274","forWeibo":"http://www.eyepetizer.net/detail.html?vid=124274&resourceType=video&utm_campaign=routine&utm_medium=share&utm_source=weibo&uid=0"},"releaseTime":1536508806000,"playInfo":[{"height":480,"width":854,"urlList":[{"name":"aliyun","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=124274&resourceType=video&editionType=normal&source=aliyun&playUrlType=url_oss","size":16567904},{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=124274&resourceType=video&editionType=normal&source=qcloud&playUrlType=url_oss","size":16567904},{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=124274&resourceType=video&editionType=normal&source=ucloud&playUrlType=url_oss","size":16567904}],"name":"标清","type":"normal","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=124274&resourceType=video&editionType=normal&source=aliyun&playUrlType=url_oss"},{"height":1080,"width":1920,"urlList":[{"name":"aliyun","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=124274&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss","size":55683416},{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=124274&resourceType=video&editionType=high&source=qcloud&playUrlType=url_oss","size":55683416},{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=124274&resourceType=video&editionType=high&source=ucloud&playUrlType=url_oss","size":55683416}],"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=124274&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss"}],"campaign":null,"waterMarks":null,"ad":false,"adTrack":null,"type":"NORMAL","titlePgc":null,"descriptionPgc":null,"remark":null,"ifLimitVideo":false,"searchWeight":0,"idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1563152400000,"promotion":null,"label":null,"labelList":[],"descriptionEditor":"生物进化的基本法则就是：适者生存，弱肉强食。动物之间经常会有同类相食的情境发生，通常是独居的动物会猎杀任何体型适合的猎物，甚至交配对象。对于动物来说，同类相食和其他行为一样都是生活中常见的一部分，一切都是为了生存和繁衍。","collected":false,"played":false,"subtitles":[],"lastViewTime":null,"playlists":null,"src":null},"tag":null,"id":0,"adIndex":-1},{"type":"video","data":{"dataType":"VideoBeanForClient","id":133261,"title":"最疯狂的脑洞，成就最棒的剧本","description":"最会拍广告的电视台 Canal+ 又来了。这次它将编剧脑中最不可思议的脑洞在广告中拍了出来，只有敢想才有能力敢做。","library":"DAILY","tags":[{"id":748,"name":"这些广告超有梗","actionUrl":"eyepetizer://tag/748/?title=%E8%BF%99%E4%BA%9B%E5%B9%BF%E5%91%8A%E8%B6%85%E6%9C%89%E6%A2%97","adTrack":null,"desc":null,"bgPicture":"http://img.kaiyanapp.com/9056413cfeffaf0c841d894390aa8e08.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/ff0f6d0ad5f4b6211a3f746aaaffd916.jpeg?imageMogr2/quality/60/format/jpg","tagRecType":"IMPORTANT","childTagList":null,"childTagIdList":null,"communityIndex":0},{"id":758,"name":"欧美广告","actionUrl":"eyepetizer://tag/758/?title=%E6%AC%A7%E7%BE%8E%E5%B9%BF%E5%91%8A","adTrack":null,"desc":null,"bgPicture":"http://img.kaiyanapp.com/4347ee94f8ae98a86f2913db3b8638f3.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/8494d3626c41f8e8cb6316767cc0f573.jpeg?imageMogr2/quality/60/format/jpg","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"communityIndex":0},{"id":773,"name":"脑洞大开","actionUrl":"eyepetizer://tag/773/?title=%E8%84%91%E6%B4%9E%E5%A4%A7%E5%BC%80","adTrack":null,"desc":null,"bgPicture":"http://img.kaiyanapp.com/25f37613bb960c36438b7b335b40f690.png?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/25f37613bb960c36438b7b335b40f690.png?imageMogr2/quality/60/format/jpg","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"communityIndex":0},{"id":766,"name":"脑洞广告","actionUrl":"eyepetizer://tag/766/?title=%E8%84%91%E6%B4%9E%E5%B9%BF%E5%91%8A","adTrack":null,"desc":null,"bgPicture":"http://img.kaiyanapp.com/7c46ad04ff913b87915615c78d226a40.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/0d6ab7ed49de67eab89ada4f65353e8c.jpeg?imageMogr2/quality/60/format/jpg","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"communityIndex":0},{"id":16,"name":"广告","actionUrl":"eyepetizer://tag/16/?title=%E5%B9%BF%E5%91%8A","adTrack":null,"desc":"为广告人的精彩创意点赞","bgPicture":"http://img.kaiyanapp.com/e41e74fe73882b552de00d95d56748d2.jpeg?imageMogr2/quality/60","headerImage":"http://img.kaiyanapp.com/3054658dbd559ac42c4c282e9cab7a32.jpeg?imageMogr2/quality/100","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"communityIndex":0}],"consumption":{"collectionCount":574,"shareCount":181,"replyCount":8},"resourceType":"video","slogan":"最会拍广告的电视台 Canal+ 又来了～","provider":{"name":"Vimeo","alias":"vimeo","icon":"http://img.kaiyanapp.com/c3ad630be461cbb081649c9e21d6cbe3.png"},"category":"广告","author":{"id":938,"icon":"http://img.kaiyanapp.com/e44ed5fcfa424ba35761ce5f1339bc16.jpeg?imageMogr2/quality/60/format/jpg","name":"欧美广告精选","description":"持续推送新奇、有趣、大开眼界的欧美创意广告","link":"","latestReleaseTime":1563120014000,"videoNum":850,"adTrack":null,"follow":{"itemType":"author","itemId":938,"followed":false},"shield":{"itemType":"author","itemId":938,"shielded":false},"approvedNotReadyVideoCount":0,"ifPgc":true,"recSort":0,"expert":false},"cover":{"feed":"http://img.kaiyanapp.com/75be8ec034ce594faebf3a35535ee0db.jpeg?imageMogr2/quality/60/format/jpg","detail":"http://img.kaiyanapp.com/75be8ec034ce594faebf3a35535ee0db.jpeg?imageMogr2/quality/60/format/jpg","blurred":"http://img.kaiyanapp.com/1ab5af41e130096addf79ef999629545.jpeg?imageMogr2/quality/60/format/jpg","sharing":null,"homepage":"http://img.kaiyanapp.com/75be8ec034ce594faebf3a35535ee0db.jpeg?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim"},"playUrl":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=133261&resourceType=video&editionType=default&source=aliyun&playUrlType=url_oss","thumbPlayUrl":null,"duration":100,"webUrl":{"raw":"http://www.eyepetizer.net/detail.html?vid=133261","forWeibo":"http://www.eyepetizer.net/detail.html?vid=133261&resourceType=video&utm_campaign=routine&utm_medium=share&utm_source=weibo&uid=0"},"releaseTime":1552665600000,"playInfo":[{"height":480,"width":854,"urlList":[{"name":"aliyun","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=133261&resourceType=video&editionType=normal&source=aliyun&playUrlType=url_oss","size":7735673},{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=133261&resourceType=video&editionType=normal&source=qcloud&playUrlType=url_oss","size":7735673},{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=133261&resourceType=video&editionType=normal&source=ucloud&playUrlType=url_oss","size":7735673}],"name":"标清","type":"normal","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=133261&resourceType=video&editionType=normal&source=aliyun&playUrlType=url_oss"},{"height":720,"width":1280,"urlList":[{"name":"aliyun","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=133261&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss","size":13322413},{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=133261&resourceType=video&editionType=high&source=qcloud&playUrlType=url_oss","size":13322413},{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=133261&resourceType=video&editionType=high&source=ucloud&playUrlType=url_oss","size":13322413}],"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=133261&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss"}],"campaign":null,"waterMarks":null,"ad":false,"adTrack":null,"type":"NORMAL","titlePgc":null,"descriptionPgc":null,"remark":null,"ifLimitVideo":false,"searchWeight":0,"idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1563152400000,"promotion":null,"label":null,"labelList":[],"descriptionEditor":"最会拍广告的电视台 Canal+ 又来了。这次它将编剧脑中最不可思议的脑洞在广告中拍了出来，只有敢想才有能力敢做。","collected":false,"played":false,"subtitles":[],"lastViewTime":null,"playlists":null,"src":null},"tag":null,"id":0,"adIndex":-1}],"count":5}]
     * nextPageUrl : http://baobab.kaiyanapp.com/api/v2/feed?date=1563066000000&num=1
     * nextPublishTime : 1563238800000
     * newestIssueType : morning
     * dialog : null
     */

    private String nextPageUrl;
    private long nextPublishTime;
    private String newestIssueType;
    private Object dialog;
    private List<IssueListBean> issueList;

    public String getNextPageUrl() {
        return nextPageUrl;
    }

    public void setNextPageUrl(String nextPageUrl) {
        this.nextPageUrl = nextPageUrl;
    }

    public long getNextPublishTime() {
        return nextPublishTime;
    }

    public void setNextPublishTime(long nextPublishTime) {
        this.nextPublishTime = nextPublishTime;
    }

    public String getNewestIssueType() {
        return newestIssueType;
    }

    public void setNewestIssueType(String newestIssueType) {
        this.newestIssueType = newestIssueType;
    }

    public Object getDialog() {
        return dialog;
    }

    public void setDialog(Object dialog) {
        this.dialog = dialog;
    }

    public List<IssueListBean> getIssueList() {
        return issueList;
    }

    public void setIssueList(List<IssueListBean> issueList) {
        this.issueList = issueList;
    }

    public static class IssueListBean extends BaseResult {
        @Override
        public String toString() {
            return "IssueListBean{" +
                    "releaseTime=" + releaseTime +
                    ", type='" + type + '\'' +
                    ", date=" + date +
                    ", publishTime=" + publishTime +
                    ", count=" + count +
                    ", itemList=" + itemList +
                    '}';
        }

        /**
         * releaseTime : 1563152400000
         * type : morning
         * date : 1563152400000
         * publishTime : 1563152400000
         * itemList : [{"type":"video","data":{"dataType":"VideoBeanForClient","id":166575,"title":"人类让自己成为上帝，就把天堂变成了地狱","description":"如果「三体」是部电影，那么说这部短片是它的预告也不为过。2048 年，机器人 Chris 和 Charlie 终于进入「人类种族复活计划」的最后一天，可已经彻底对人失望的 Chris 决定「毁灭计划，将地球交给某个外星球统治」\u2026\u2026「Friday」是作者的毕业作品，灵感来源于科幻小说「三体」。除了暗喻人类在地球肆无忌惮的破坏，作者对短片的另一种解释是「这里的人类代表耶稣，人类的灭绝则代表了被钉死在十字架上的信仰」。Chris 当然知道这一天是「星期五」，他也知道人类如何把地球变成了地狱。","library":"DAILY","tags":[{"id":744,"name":"每日创意灵感","actionUrl":"eyepetizer://tag/744/?title=%E6%AF%8F%E6%97%A5%E5%88%9B%E6%84%8F%E7%81%B5%E6%84%9F","adTrack":null,"desc":"技术与审美结合，探索视觉的无限可能","bgPicture":"http://img.kaiyanapp.com/bc2479c09cd15cb93b69d82e5f21c3fc.png?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/bc2479c09cd15cb93b69d82e5f21c3fc.png?imageMogr2/quality/60/format/jpg","tagRecType":"IMPORTANT","childTagList":null,"childTagIdList":null,"communityIndex":0},{"id":74,"name":"CG","actionUrl":"eyepetizer://tag/74/?title=CG","adTrack":null,"desc":null,"bgPicture":"http://img.kaiyanapp.com/fdac34e3c19adf85704b039126edef52.jpeg?imageMogr2/quality/100","headerImage":"http://img.kaiyanapp.com/e2a1eec9efb7e7d0abca85bbdedc425b.jpeg?imageMogr2/quality/100","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"communityIndex":0},{"id":122,"name":"科幻","actionUrl":"eyepetizer://tag/122/?title=%E7%A7%91%E5%B9%BB","adTrack":null,"desc":null,"bgPicture":"http://img.kaiyanapp.com/417a8466c670ccde688bb4b525ddf23d.jpeg?imageMogr2/quality/100","headerImage":"http://img.kaiyanapp.com/114beec25470880881352171834ddf43.jpeg?imageMogr2/quality/60","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"communityIndex":0},{"id":2,"name":"创意","actionUrl":"eyepetizer://tag/2/?title=%E5%88%9B%E6%84%8F","adTrack":null,"desc":"技术与审美结合，探索视觉的无限可能","bgPicture":"http://img.kaiyanapp.com/1b457058cf2b317304ff9f70543c040d.png?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/fdefdb34cbe3d2ac9964d306febe9025.jpeg?imageMogr2/quality/100","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"communityIndex":0}],"consumption":{"collectionCount":716,"shareCount":203,"replyCount":25},"resourceType":"video","slogan":"如果「三体」是部电影，这就是一切的序章","provider":{"name":"Vimeo","alias":"vimeo","icon":"http://img.kaiyanapp.com/c3ad630be461cbb081649c9e21d6cbe3.png"},"category":"创意","author":{"id":4623,"icon":"http://img.kaiyanapp.com/a7df8dcfdfdbdd4f8c2275dc5e30bcae.png?imageMogr2/quality/60/format/jpg","name":"姓萧的陈冠森","description":"3D Generalist \\ VFX\nEmail: edison6@foxmail.com","link":"","latestReleaseTime":1563152409000,"videoNum":1,"adTrack":null,"follow":{"itemType":"author","itemId":4623,"followed":false},"shield":{"itemType":"author","itemId":4623,"shielded":false},"approvedNotReadyVideoCount":0,"ifPgc":true,"recSort":0,"expert":false},"cover":{"feed":"http://img.kaiyanapp.com/fb9f6263539fba0eced53a770f33ff36.jpeg?imageMogr2/quality/60/format/jpg","detail":"http://img.kaiyanapp.com/fb9f6263539fba0eced53a770f33ff36.jpeg?imageMogr2/quality/60/format/jpg","blurred":"http://img.kaiyanapp.com/b7182c612d5387b79900d3f6214244ca.jpeg?imageMogr2/quality/60/format/jpg","sharing":null,"homepage":"http://img.kaiyanapp.com/fb9f6263539fba0eced53a770f33ff36.jpeg?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim"},"playUrl":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=166575&resourceType=video&editionType=default&source=aliyun&playUrlType=url_oss","thumbPlayUrl":null,"duration":194,"webUrl":{"raw":"http://www.eyepetizer.net/detail.html?vid=166575","forWeibo":"http://www.eyepetizer.net/detail.html?vid=166575"},"releaseTime":1563152409000,"playInfo":[{"height":488,"width":854,"urlList":[{"name":"aliyun","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=166575&resourceType=video&editionType=normal&source=aliyun&playUrlType=url_oss","size":9221251},{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=166575&resourceType=video&editionType=normal&source=qcloud&playUrlType=url_oss","size":9221251},{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=166575&resourceType=video&editionType=normal&source=ucloud&playUrlType=url_oss","size":9221251}],"name":"标清","type":"normal","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=166575&resourceType=video&editionType=normal&source=aliyun&playUrlType=url_oss"},{"height":732,"width":1280,"urlList":[{"name":"aliyun","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=166575&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss","size":16793750},{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=166575&resourceType=video&editionType=high&source=qcloud&playUrlType=url_oss","size":16793750},{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=166575&resourceType=video&editionType=high&source=ucloud&playUrlType=url_oss","size":16793750}],"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=166575&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss"}],"campaign":null,"waterMarks":null,"ad":false,"adTrack":null,"type":"NORMAL","titlePgc":null,"descriptionPgc":null,"remark":"","ifLimitVideo":false,"searchWeight":0,"idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1563152400000,"promotion":null,"label":null,"labelList":[],"descriptionEditor":"如果「三体」是部电影，那么说这部短片是它的预告也不为过。2048 年，机器人 Chris 和 Charlie 终于进入「人类种族复活计划」的最后一天，可已经彻底对人失望的 Chris 决定「毁灭计划，将地球交给某个外星球统治」\u2026\u2026「Friday」是作者的毕业作品，灵感来源于科幻小说「三体」。除了暗喻人类在地球肆无忌惮的破坏，作者对短片的另一种解释是「这里的人类代表耶稣，人类的灭绝则代表了被钉死在十字架上的信仰」。Chris 当然知道这一天是「星期五」，他也知道人类如何把地球变成了地狱。","collected":false,"played":false,"subtitles":[],"lastViewTime":null,"playlists":null,"src":null},"tag":null,"id":0,"adIndex":-1},{"type":"video","data":{"dataType":"VideoBeanForClient","id":165613,"title":"青春期的爱和性，是那一年我们都会经历的事","description":"你知道为什么爱的形状是一个红色的心吗？","library":"DAILY","tags":[{"id":14,"name":"动画梦工厂","actionUrl":"eyepetizer://tag/14/?title=%E5%8A%A8%E7%94%BB%E6%A2%A6%E5%B7%A5%E5%8E%82","adTrack":null,"desc":"有趣的人永远不缺童心","bgPicture":"http://img.kaiyanapp.com/afb9e7d7f061d10ade5ebcb524dc8679.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/f9eae3e0321fa1e99a7b38641b5536a2.jpeg?imageMogr2/quality/60/format/jpg","tagRecType":"IMPORTANT","childTagList":null,"childTagIdList":null,"communityIndex":0},{"id":150,"name":"青春","actionUrl":"eyepetizer://tag/150/?title=%E9%9D%92%E6%98%A5","adTrack":null,"desc":null,"bgPicture":"http://img.kaiyanapp.com/34d33f611dbfe38e4d00cd4ab43212e7.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/58e3e0ec1e583a6debcc0f80d16c86fe.jpeg?imageMogr2/quality/100","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"communityIndex":0},{"id":1023,"name":"动画","actionUrl":"eyepetizer://tag/1023/?title=%E5%8A%A8%E7%94%BB","adTrack":null,"desc":"有趣的人永远不缺童心","bgPicture":"http://img.kaiyanapp.com/349cbd33cdf71fc74d5e9c7a00b444fd.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/208aa67386c045497389f015ae28dd29.jpeg?imageMogr2/quality/60/format/jpg","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"communityIndex":0},{"id":773,"name":"脑洞大开","actionUrl":"eyepetizer://tag/773/?title=%E8%84%91%E6%B4%9E%E5%A4%A7%E5%BC%80","adTrack":null,"desc":null,"bgPicture":"http://img.kaiyanapp.com/25f37613bb960c36438b7b335b40f690.png?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/25f37613bb960c36438b7b335b40f690.png?imageMogr2/quality/60/format/jpg","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"communityIndex":0},{"id":128,"name":"污","actionUrl":"eyepetizer://tag/128/?title=%E6%B1%A1","adTrack":null,"desc":null,"bgPicture":"http://img.kaiyanapp.com/4bb010aab06fe32397359def83e4e47c.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/5897def623ef2313849502049047dea1.jpeg?imageMogr2/quality/60/format/jpg","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"communityIndex":0}],"consumption":{"collectionCount":505,"shareCount":182,"replyCount":10},"resourceType":"video","slogan":"狗仔式的爱「Doggy Love」","provider":{"name":"PGC","alias":"PGC","icon":""},"category":"动画","author":{"id":168,"icon":"http://img.kaiyanapp.com/31588812d55435318fef0983e09a19a2.jpeg?imageMogr2/quality/60","name":"NOWNESS现在","description":"全球创意生活短片平台","link":"","latestReleaseTime":1562063379000,"videoNum":79,"adTrack":null,"follow":{"itemType":"author","itemId":168,"followed":false},"shield":{"itemType":"author","itemId":168,"shielded":false},"approvedNotReadyVideoCount":0,"ifPgc":true,"recSort":0,"expert":false},"cover":{"feed":"http://img.kaiyanapp.com/03479f78907817ede8421dfed1b29fa1.jpeg?imageMogr2/quality/60/format/jpg","detail":"http://img.kaiyanapp.com/03479f78907817ede8421dfed1b29fa1.jpeg?imageMogr2/quality/60/format/jpg","blurred":"http://img.kaiyanapp.com/9c89b271f9419cff3768170f81b8de54.jpeg?imageMogr2/quality/60/format/jpg","sharing":null,"homepage":"http://img.kaiyanapp.com/03479f78907817ede8421dfed1b29fa1.jpeg?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim"},"playUrl":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=165613&resourceType=video&editionType=default&source=aliyun&playUrlType=url_oss","thumbPlayUrl":null,"duration":359,"webUrl":{"raw":"http://www.eyepetizer.net/detail.html?vid=165613","forWeibo":"http://www.eyepetizer.net/detail.html?vid=165613&resourceType=video&utm_campaign=routine&utm_medium=share&utm_source=weibo&uid=0"},"releaseTime":1562060420000,"playInfo":[{"height":480,"width":854,"urlList":[{"name":"aliyun","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=165613&resourceType=video&editionType=normal&source=aliyun&playUrlType=url_oss","size":25401390},{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=165613&resourceType=video&editionType=normal&source=qcloud&playUrlType=url_oss","size":25401390},{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=165613&resourceType=video&editionType=normal&source=ucloud&playUrlType=url_oss","size":25401390}],"name":"标清","type":"normal","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=165613&resourceType=video&editionType=normal&source=aliyun&playUrlType=url_oss"},{"height":720,"width":1280,"urlList":[{"name":"aliyun","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=165613&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss","size":39794748},{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=165613&resourceType=video&editionType=high&source=qcloud&playUrlType=url_oss","size":39794748},{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=165613&resourceType=video&editionType=high&source=ucloud&playUrlType=url_oss","size":39794748}],"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=165613&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss"}],"campaign":null,"waterMarks":null,"ad":false,"adTrack":null,"type":"NORMAL","titlePgc":"狗仔式的愛 Doggy Love","descriptionPgc":"Do you know the reason why love is shown in the shape of a red heart?你知道为什么爱的形状是一个红色的心吗？","remark":"","ifLimitVideo":false,"searchWeight":0,"idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1563152400000,"promotion":null,"label":null,"labelList":[],"descriptionEditor":"你知道为什么爱的形状是一个红色的心吗？","collected":false,"played":false,"subtitles":[],"lastViewTime":null,"playlists":null,"src":null},"tag":null,"id":0,"adIndex":-1},{"type":"video","data":{"dataType":"VideoBeanForClient","id":151149,"title":"逃离现实的最好方法：无计划旅行","description":"不要害怕错过风景，因为只有你喜欢的时候，一朵云才变成了风景。所谓真正意义的「旅行」，是扔掉一切期望和规划，是找到看世界的新方法。摄影师 Rob Strok 在迪拜、阿曼、纽约三个城市进行了无计划旅行。先别急着酸，周末买张机票，你也是主角。From Rob Strok","library":"DAILY","tags":[{"id":10,"name":"跟着开眼看世界","actionUrl":"eyepetizer://tag/10/?title=%E8%B7%9F%E7%9D%80%E5%BC%80%E7%9C%BC%E7%9C%8B%E4%B8%96%E7%95%8C","adTrack":null,"desc":"去你想去的地方，发现世界的美","bgPicture":"http://img.kaiyanapp.com/7ea328a893aa1f092b9328a53494a267.png?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/50dab5468ecd2dbe5eb99dab5d608a0a.jpeg?imageMogr2/quality/60/format/jpg","tagRecType":"IMPORTANT","childTagList":null,"childTagIdList":null,"communityIndex":0},{"id":721,"name":"旅行灵感","actionUrl":"eyepetizer://tag/721/?title=%E6%97%85%E8%A1%8C%E7%81%B5%E6%84%9F","adTrack":null,"desc":"","bgPicture":"http://img.kaiyanapp.com/32b7e220d9c012c96e5f9a68e6f3ad9a.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/32b7e220d9c012c96e5f9a68e6f3ad9a.jpeg?imageMogr2/quality/60/format/jpg","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"communityIndex":0},{"id":1019,"name":"旅行","actionUrl":"eyepetizer://tag/1019/?title=%E6%97%85%E8%A1%8C","adTrack":null,"desc":"世界这么大，总有你的目的地","bgPicture":"http://img.kaiyanapp.com/67b5aa7b489b33e7894e04d293e9b01f.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/67b5aa7b489b33e7894e04d293e9b01f.jpeg?imageMogr2/quality/60/format/jpg","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"communityIndex":0}],"consumption":{"collectionCount":213,"shareCount":105,"replyCount":9},"resourceType":"video","slogan":"只有你喜欢的时候，一朵云才变成了风景","provider":{"name":"YouTube","alias":"youtube","icon":"http://img.kaiyanapp.com/fa20228bc5b921e837156923a58713f6.png"},"category":"旅行","author":{"id":2164,"icon":"http://img.kaiyanapp.com/75bc791c5f6cc239d6056e0a52d077fd.jpeg?imageMogr2/quality/60/format/jpg","name":"开眼旅行精选","description":"发现世界的奇妙和辽阔","link":"","latestReleaseTime":1563152413000,"videoNum":567,"adTrack":null,"follow":{"itemType":"author","itemId":2164,"followed":false},"shield":{"itemType":"author","itemId":2164,"shielded":false},"approvedNotReadyVideoCount":0,"ifPgc":true,"recSort":0,"expert":false},"cover":{"feed":"http://img.kaiyanapp.com/329e87c401df4d4df1007d4631651d0e.jpeg?imageMogr2/quality/60/format/jpg","detail":"http://img.kaiyanapp.com/329e87c401df4d4df1007d4631651d0e.jpeg?imageMogr2/quality/60/format/jpg","blurred":"http://img.kaiyanapp.com/e5e3782793cccc0cfdc5a2f16f9d30b1.jpeg?imageMogr2/quality/60/format/jpg","sharing":null,"homepage":"http://img.kaiyanapp.com/329e87c401df4d4df1007d4631651d0e.jpeg?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim"},"playUrl":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=151149&resourceType=video&editionType=default&source=aliyun&playUrlType=url_oss","thumbPlayUrl":null,"duration":583,"webUrl":{"raw":"http://www.eyepetizer.net/detail.html?vid=151149","forWeibo":"http://www.eyepetizer.net/detail.html?vid=151149&resourceType=video&utm_campaign=routine&utm_medium=share&utm_source=weibo&uid=0"},"releaseTime":1563152413000,"playInfo":[{"height":480,"width":854,"urlList":[{"name":"aliyun","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=151149&resourceType=video&editionType=normal&source=aliyun&playUrlType=url_oss","size":46414818},{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=151149&resourceType=video&editionType=normal&source=qcloud&playUrlType=url_oss","size":46414818},{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=151149&resourceType=video&editionType=normal&source=ucloud&playUrlType=url_oss","size":46414818}],"name":"标清","type":"normal","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=151149&resourceType=video&editionType=normal&source=aliyun&playUrlType=url_oss"},{"height":720,"width":1280,"urlList":[{"name":"aliyun","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=151149&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss","size":76068730},{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=151149&resourceType=video&editionType=high&source=qcloud&playUrlType=url_oss","size":76068730},{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=151149&resourceType=video&editionType=high&source=ucloud&playUrlType=url_oss","size":76068730}],"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=151149&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss"}],"campaign":null,"waterMarks":null,"ad":false,"adTrack":null,"type":"NORMAL","titlePgc":null,"descriptionPgc":null,"remark":"","ifLimitVideo":false,"searchWeight":0,"idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1563152400000,"promotion":null,"label":null,"labelList":[],"descriptionEditor":"不要害怕错过风景，因为只有你喜欢的时候，一朵云才变成了风景。所谓真正意义的「旅行」，是扔掉一切期望和规划，是找到看世界的新方法。摄影师 Rob Strok 在迪拜、阿曼、纽约三个城市进行了无计划旅行。先别急着酸，周末买张机票，你也是主角。From Rob Strok","collected":false,"played":false,"subtitles":[],"lastViewTime":null,"playlists":null,"src":null},"tag":null,"id":0,"adIndex":-1},{"type":"video","data":{"dataType":"VideoBeanForClient","id":124274,"title":"这些动物狠起来连自己人都吃","description":"生物进化的基本法则就是：适者生存，弱肉强食。动物之间经常会有同类相食的情境发生，通常是独居的动物会猎杀任何体型适合的猎物，甚至交配对象。对于动物来说，同类相食和其他行为一样都是生活中常见的一部分，一切都是为了生存和繁衍。","library":"DAILY","tags":[{"id":44,"name":"5 分钟新知","actionUrl":"eyepetizer://tag/44/?title=5%20%E5%88%86%E9%92%9F%E6%96%B0%E7%9F%A5","adTrack":null,"desc":"大千世界，总有你不知道的","bgPicture":"http://img.kaiyanapp.com/f2e7359e81e217782f32cc3d482b3284.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/f2e7359e81e217782f32cc3d482b3284.jpeg?imageMogr2/quality/60/format/jpg","tagRecType":"IMPORTANT","childTagList":null,"childTagIdList":null,"communityIndex":0},{"id":1040,"name":"科普","actionUrl":"eyepetizer://tag/1040/?title=%E7%A7%91%E6%99%AE","adTrack":null,"desc":null,"bgPicture":"http://img.kaiyanapp.com/86af95dab03ab8fac3342517e83b07bb.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/86af95dab03ab8fac3342517e83b07bb.jpeg?imageMogr2/quality/60/format/jpg","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"communityIndex":0},{"id":1024,"name":"科技","actionUrl":"eyepetizer://tag/1024/?title=%E7%A7%91%E6%8A%80","adTrack":null,"desc":"新知识与一切先进生产力","bgPicture":"http://img.kaiyanapp.com/7e326064edc565ac6355921cfe4b3e46.png?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/810adad06df812462bb0e00501fa679c.png?imageMogr2/quality/60/format/jpg","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"communityIndex":0},{"id":865,"name":"自然科学","actionUrl":"eyepetizer://tag/865/?title=%E8%87%AA%E7%84%B6%E7%A7%91%E5%AD%A6","adTrack":null,"desc":null,"bgPicture":"http://img.kaiyanapp.com/b51563fb04cfedd7f4ac80d63bc3a328.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/06e1989d9752bb1b3097d7e643640ed6.png?imageMogr2/quality/60/format/jpg","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"communityIndex":0}],"consumption":{"collectionCount":286,"shareCount":157,"replyCount":10},"resourceType":"video","slogan":"同类相食\u2014\u2014适者生存的另一种表现","provider":{"name":"YouTube","alias":"youtube","icon":"http://img.kaiyanapp.com/fa20228bc5b921e837156923a58713f6.png"},"category":"科技","author":{"id":2398,"icon":"http://img.kaiyanapp.com/5e4a548d975069f7d7d1b1fe22286b3e.jpeg?imageMogr2/quality/60/format/jpg","name":"TED-Ed","description":"TED-Ed 致力于与更多的动画师和教育学者共同创造出更多优秀的科普视频。","link":"","latestReleaseTime":1562821533000,"videoNum":495,"adTrack":null,"follow":{"itemType":"author","itemId":2398,"followed":false},"shield":{"itemType":"author","itemId":2398,"shielded":false},"approvedNotReadyVideoCount":0,"ifPgc":true,"recSort":0,"expert":false},"cover":{"feed":"http://img.kaiyanapp.com/8e9682dcbe2b8b5da2b3b40c5ec9c5eb.png?imageMogr2/quality/60/format/jpg","detail":"http://img.kaiyanapp.com/8e9682dcbe2b8b5da2b3b40c5ec9c5eb.png?imageMogr2/quality/60/format/jpg","blurred":"http://img.kaiyanapp.com/4ba0be1968eb94842094f94450ffc2d3.png?imageMogr2/quality/60/format/jpg","sharing":null,"homepage":"http://img.kaiyanapp.com/8e9682dcbe2b8b5da2b3b40c5ec9c5eb.png?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim"},"playUrl":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=124274&resourceType=video&editionType=default&source=aliyun&playUrlType=url_oss","thumbPlayUrl":null,"duration":297,"webUrl":{"raw":"http://www.eyepetizer.net/detail.html?vid=124274","forWeibo":"http://www.eyepetizer.net/detail.html?vid=124274&resourceType=video&utm_campaign=routine&utm_medium=share&utm_source=weibo&uid=0"},"releaseTime":1536508806000,"playInfo":[{"height":480,"width":854,"urlList":[{"name":"aliyun","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=124274&resourceType=video&editionType=normal&source=aliyun&playUrlType=url_oss","size":16567904},{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=124274&resourceType=video&editionType=normal&source=qcloud&playUrlType=url_oss","size":16567904},{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=124274&resourceType=video&editionType=normal&source=ucloud&playUrlType=url_oss","size":16567904}],"name":"标清","type":"normal","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=124274&resourceType=video&editionType=normal&source=aliyun&playUrlType=url_oss"},{"height":1080,"width":1920,"urlList":[{"name":"aliyun","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=124274&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss","size":55683416},{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=124274&resourceType=video&editionType=high&source=qcloud&playUrlType=url_oss","size":55683416},{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=124274&resourceType=video&editionType=high&source=ucloud&playUrlType=url_oss","size":55683416}],"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=124274&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss"}],"campaign":null,"waterMarks":null,"ad":false,"adTrack":null,"type":"NORMAL","titlePgc":null,"descriptionPgc":null,"remark":null,"ifLimitVideo":false,"searchWeight":0,"idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1563152400000,"promotion":null,"label":null,"labelList":[],"descriptionEditor":"生物进化的基本法则就是：适者生存，弱肉强食。动物之间经常会有同类相食的情境发生，通常是独居的动物会猎杀任何体型适合的猎物，甚至交配对象。对于动物来说，同类相食和其他行为一样都是生活中常见的一部分，一切都是为了生存和繁衍。","collected":false,"played":false,"subtitles":[],"lastViewTime":null,"playlists":null,"src":null},"tag":null,"id":0,"adIndex":-1},{"type":"video","data":{"dataType":"VideoBeanForClient","id":133261,"title":"最疯狂的脑洞，成就最棒的剧本","description":"最会拍广告的电视台 Canal+ 又来了。这次它将编剧脑中最不可思议的脑洞在广告中拍了出来，只有敢想才有能力敢做。","library":"DAILY","tags":[{"id":748,"name":"这些广告超有梗","actionUrl":"eyepetizer://tag/748/?title=%E8%BF%99%E4%BA%9B%E5%B9%BF%E5%91%8A%E8%B6%85%E6%9C%89%E6%A2%97","adTrack":null,"desc":null,"bgPicture":"http://img.kaiyanapp.com/9056413cfeffaf0c841d894390aa8e08.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/ff0f6d0ad5f4b6211a3f746aaaffd916.jpeg?imageMogr2/quality/60/format/jpg","tagRecType":"IMPORTANT","childTagList":null,"childTagIdList":null,"communityIndex":0},{"id":758,"name":"欧美广告","actionUrl":"eyepetizer://tag/758/?title=%E6%AC%A7%E7%BE%8E%E5%B9%BF%E5%91%8A","adTrack":null,"desc":null,"bgPicture":"http://img.kaiyanapp.com/4347ee94f8ae98a86f2913db3b8638f3.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/8494d3626c41f8e8cb6316767cc0f573.jpeg?imageMogr2/quality/60/format/jpg","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"communityIndex":0},{"id":773,"name":"脑洞大开","actionUrl":"eyepetizer://tag/773/?title=%E8%84%91%E6%B4%9E%E5%A4%A7%E5%BC%80","adTrack":null,"desc":null,"bgPicture":"http://img.kaiyanapp.com/25f37613bb960c36438b7b335b40f690.png?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/25f37613bb960c36438b7b335b40f690.png?imageMogr2/quality/60/format/jpg","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"communityIndex":0},{"id":766,"name":"脑洞广告","actionUrl":"eyepetizer://tag/766/?title=%E8%84%91%E6%B4%9E%E5%B9%BF%E5%91%8A","adTrack":null,"desc":null,"bgPicture":"http://img.kaiyanapp.com/7c46ad04ff913b87915615c78d226a40.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/0d6ab7ed49de67eab89ada4f65353e8c.jpeg?imageMogr2/quality/60/format/jpg","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"communityIndex":0},{"id":16,"name":"广告","actionUrl":"eyepetizer://tag/16/?title=%E5%B9%BF%E5%91%8A","adTrack":null,"desc":"为广告人的精彩创意点赞","bgPicture":"http://img.kaiyanapp.com/e41e74fe73882b552de00d95d56748d2.jpeg?imageMogr2/quality/60","headerImage":"http://img.kaiyanapp.com/3054658dbd559ac42c4c282e9cab7a32.jpeg?imageMogr2/quality/100","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"communityIndex":0}],"consumption":{"collectionCount":574,"shareCount":181,"replyCount":8},"resourceType":"video","slogan":"最会拍广告的电视台 Canal+ 又来了～","provider":{"name":"Vimeo","alias":"vimeo","icon":"http://img.kaiyanapp.com/c3ad630be461cbb081649c9e21d6cbe3.png"},"category":"广告","author":{"id":938,"icon":"http://img.kaiyanapp.com/e44ed5fcfa424ba35761ce5f1339bc16.jpeg?imageMogr2/quality/60/format/jpg","name":"欧美广告精选","description":"持续推送新奇、有趣、大开眼界的欧美创意广告","link":"","latestReleaseTime":1563120014000,"videoNum":850,"adTrack":null,"follow":{"itemType":"author","itemId":938,"followed":false},"shield":{"itemType":"author","itemId":938,"shielded":false},"approvedNotReadyVideoCount":0,"ifPgc":true,"recSort":0,"expert":false},"cover":{"feed":"http://img.kaiyanapp.com/75be8ec034ce594faebf3a35535ee0db.jpeg?imageMogr2/quality/60/format/jpg","detail":"http://img.kaiyanapp.com/75be8ec034ce594faebf3a35535ee0db.jpeg?imageMogr2/quality/60/format/jpg","blurred":"http://img.kaiyanapp.com/1ab5af41e130096addf79ef999629545.jpeg?imageMogr2/quality/60/format/jpg","sharing":null,"homepage":"http://img.kaiyanapp.com/75be8ec034ce594faebf3a35535ee0db.jpeg?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim"},"playUrl":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=133261&resourceType=video&editionType=default&source=aliyun&playUrlType=url_oss","thumbPlayUrl":null,"duration":100,"webUrl":{"raw":"http://www.eyepetizer.net/detail.html?vid=133261","forWeibo":"http://www.eyepetizer.net/detail.html?vid=133261&resourceType=video&utm_campaign=routine&utm_medium=share&utm_source=weibo&uid=0"},"releaseTime":1552665600000,"playInfo":[{"height":480,"width":854,"urlList":[{"name":"aliyun","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=133261&resourceType=video&editionType=normal&source=aliyun&playUrlType=url_oss","size":7735673},{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=133261&resourceType=video&editionType=normal&source=qcloud&playUrlType=url_oss","size":7735673},{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=133261&resourceType=video&editionType=normal&source=ucloud&playUrlType=url_oss","size":7735673}],"name":"标清","type":"normal","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=133261&resourceType=video&editionType=normal&source=aliyun&playUrlType=url_oss"},{"height":720,"width":1280,"urlList":[{"name":"aliyun","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=133261&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss","size":13322413},{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=133261&resourceType=video&editionType=high&source=qcloud&playUrlType=url_oss","size":13322413},{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=133261&resourceType=video&editionType=high&source=ucloud&playUrlType=url_oss","size":13322413}],"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=133261&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss"}],"campaign":null,"waterMarks":null,"ad":false,"adTrack":null,"type":"NORMAL","titlePgc":null,"descriptionPgc":null,"remark":null,"ifLimitVideo":false,"searchWeight":0,"idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1563152400000,"promotion":null,"label":null,"labelList":[],"descriptionEditor":"最会拍广告的电视台 Canal+ 又来了。这次它将编剧脑中最不可思议的脑洞在广告中拍了出来，只有敢想才有能力敢做。","collected":false,"played":false,"subtitles":[],"lastViewTime":null,"playlists":null,"src":null},"tag":null,"id":0,"adIndex":-1}]
         * count : 5
         */

        private long releaseTime;
        private String type;
        private long date;
        private long publishTime;
        private int count;
        private List<ItemListBean> itemList;

        public long getReleaseTime() {
            return releaseTime;
        }

        public void setReleaseTime(long releaseTime) {
            this.releaseTime = releaseTime;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public long getDate() {
            return date;
        }

        public void setDate(long date) {
            this.date = date;
        }

        public long getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(long publishTime) {
            this.publishTime = publishTime;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public List<ItemListBean> getItemList() {
            return itemList;
        }

        public void setItemList(List<ItemListBean> itemList) {
            this.itemList = itemList;
        }

        public static class ItemListBean implements Serializable {
            /**
             * type : video
             * data : {"dataType":"VideoBeanForClient","id":166575,"title":"人类让自己成为上帝，就把天堂变成了地狱","description":"如果「三体」是部电影，那么说这部短片是它的预告也不为过。2048 年，机器人 Chris 和 Charlie 终于进入「人类种族复活计划」的最后一天，可已经彻底对人失望的 Chris 决定「毁灭计划，将地球交给某个外星球统治」\u2026\u2026「Friday」是作者的毕业作品，灵感来源于科幻小说「三体」。除了暗喻人类在地球肆无忌惮的破坏，作者对短片的另一种解释是「这里的人类代表耶稣，人类的灭绝则代表了被钉死在十字架上的信仰」。Chris 当然知道这一天是「星期五」，他也知道人类如何把地球变成了地狱。","library":"DAILY","tags":[{"id":744,"name":"每日创意灵感","actionUrl":"eyepetizer://tag/744/?title=%E6%AF%8F%E6%97%A5%E5%88%9B%E6%84%8F%E7%81%B5%E6%84%9F","adTrack":null,"desc":"技术与审美结合，探索视觉的无限可能","bgPicture":"http://img.kaiyanapp.com/bc2479c09cd15cb93b69d82e5f21c3fc.png?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/bc2479c09cd15cb93b69d82e5f21c3fc.png?imageMogr2/quality/60/format/jpg","tagRecType":"IMPORTANT","childTagList":null,"childTagIdList":null,"communityIndex":0},{"id":74,"name":"CG","actionUrl":"eyepetizer://tag/74/?title=CG","adTrack":null,"desc":null,"bgPicture":"http://img.kaiyanapp.com/fdac34e3c19adf85704b039126edef52.jpeg?imageMogr2/quality/100","headerImage":"http://img.kaiyanapp.com/e2a1eec9efb7e7d0abca85bbdedc425b.jpeg?imageMogr2/quality/100","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"communityIndex":0},{"id":122,"name":"科幻","actionUrl":"eyepetizer://tag/122/?title=%E7%A7%91%E5%B9%BB","adTrack":null,"desc":null,"bgPicture":"http://img.kaiyanapp.com/417a8466c670ccde688bb4b525ddf23d.jpeg?imageMogr2/quality/100","headerImage":"http://img.kaiyanapp.com/114beec25470880881352171834ddf43.jpeg?imageMogr2/quality/60","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"communityIndex":0},{"id":2,"name":"创意","actionUrl":"eyepetizer://tag/2/?title=%E5%88%9B%E6%84%8F","adTrack":null,"desc":"技术与审美结合，探索视觉的无限可能","bgPicture":"http://img.kaiyanapp.com/1b457058cf2b317304ff9f70543c040d.png?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/fdefdb34cbe3d2ac9964d306febe9025.jpeg?imageMogr2/quality/100","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"communityIndex":0}],"consumption":{"collectionCount":716,"shareCount":203,"replyCount":25},"resourceType":"video","slogan":"如果「三体」是部电影，这就是一切的序章","provider":{"name":"Vimeo","alias":"vimeo","icon":"http://img.kaiyanapp.com/c3ad630be461cbb081649c9e21d6cbe3.png"},"category":"创意","author":{"id":4623,"icon":"http://img.kaiyanapp.com/a7df8dcfdfdbdd4f8c2275dc5e30bcae.png?imageMogr2/quality/60/format/jpg","name":"姓萧的陈冠森","description":"3D Generalist \\ VFX\nEmail: edison6@foxmail.com","link":"","latestReleaseTime":1563152409000,"videoNum":1,"adTrack":null,"follow":{"itemType":"author","itemId":4623,"followed":false},"shield":{"itemType":"author","itemId":4623,"shielded":false},"approvedNotReadyVideoCount":0,"ifPgc":true,"recSort":0,"expert":false},"cover":{"feed":"http://img.kaiyanapp.com/fb9f6263539fba0eced53a770f33ff36.jpeg?imageMogr2/quality/60/format/jpg","detail":"http://img.kaiyanapp.com/fb9f6263539fba0eced53a770f33ff36.jpeg?imageMogr2/quality/60/format/jpg","blurred":"http://img.kaiyanapp.com/b7182c612d5387b79900d3f6214244ca.jpeg?imageMogr2/quality/60/format/jpg","sharing":null,"homepage":"http://img.kaiyanapp.com/fb9f6263539fba0eced53a770f33ff36.jpeg?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim"},"playUrl":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=166575&resourceType=video&editionType=default&source=aliyun&playUrlType=url_oss","thumbPlayUrl":null,"duration":194,"webUrl":{"raw":"http://www.eyepetizer.net/detail.html?vid=166575","forWeibo":"http://www.eyepetizer.net/detail.html?vid=166575"},"releaseTime":1563152409000,"playInfo":[{"height":488,"width":854,"urlList":[{"name":"aliyun","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=166575&resourceType=video&editionType=normal&source=aliyun&playUrlType=url_oss","size":9221251},{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=166575&resourceType=video&editionType=normal&source=qcloud&playUrlType=url_oss","size":9221251},{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=166575&resourceType=video&editionType=normal&source=ucloud&playUrlType=url_oss","size":9221251}],"name":"标清","type":"normal","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=166575&resourceType=video&editionType=normal&source=aliyun&playUrlType=url_oss"},{"height":732,"width":1280,"urlList":[{"name":"aliyun","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=166575&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss","size":16793750},{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=166575&resourceType=video&editionType=high&source=qcloud&playUrlType=url_oss","size":16793750},{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=166575&resourceType=video&editionType=high&source=ucloud&playUrlType=url_oss","size":16793750}],"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=166575&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss"}],"campaign":null,"waterMarks":null,"ad":false,"adTrack":null,"type":"NORMAL","titlePgc":null,"descriptionPgc":null,"remark":"","ifLimitVideo":false,"searchWeight":0,"idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1563152400000,"promotion":null,"label":null,"labelList":[],"descriptionEditor":"如果「三体」是部电影，那么说这部短片是它的预告也不为过。2048 年，机器人 Chris 和 Charlie 终于进入「人类种族复活计划」的最后一天，可已经彻底对人失望的 Chris 决定「毁灭计划，将地球交给某个外星球统治」\u2026\u2026「Friday」是作者的毕业作品，灵感来源于科幻小说「三体」。除了暗喻人类在地球肆无忌惮的破坏，作者对短片的另一种解释是「这里的人类代表耶稣，人类的灭绝则代表了被钉死在十字架上的信仰」。Chris 当然知道这一天是「星期五」，他也知道人类如何把地球变成了地狱。","collected":false,"played":false,"subtitles":[],"lastViewTime":null,"playlists":null,"src":null}
             * tag : null
             * id : 0
             * adIndex : -1
             */
            private long Serializable = 1L;
            private String type;
            private DataBean data;
            private Object tag;
            private int id;
            private int adIndex;

            @Override
            public String toString() {
                return "ItemListBean{" +
                        "Serializable=" + Serializable +
                        ", type='" + type + '\'' +
                        ", data=" + data +
                        ", tag=" + tag +
                        ", id=" + id +
                        ", adIndex=" + adIndex +
                        '}';
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public DataBean getData() {
                return data;
            }

            public void setData(DataBean data) {
                this.data = data;
            }

            public Object getTag() {
                return tag;
            }

            public void setTag(Object tag) {
                this.tag = tag;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getAdIndex() {
                return adIndex;
            }

            public void setAdIndex(int adIndex) {
                this.adIndex = adIndex;
            }

            public static class DataBean {
                /**
                 * dataType : VideoBeanForClient
                 * id : 166575
                 * title : 人类让自己成为上帝，就把天堂变成了地狱
                 * description : 如果「三体」是部电影，那么说这部短片是它的预告也不为过。2048 年，机器人 Chris 和 Charlie 终于进入「人类种族复活计划」的最后一天，可已经彻底对人失望的 Chris 决定「毁灭计划，将地球交给某个外星球统治」……「Friday」是作者的毕业作品，灵感来源于科幻小说「三体」。除了暗喻人类在地球肆无忌惮的破坏，作者对短片的另一种解释是「这里的人类代表耶稣，人类的灭绝则代表了被钉死在十字架上的信仰」。Chris 当然知道这一天是「星期五」，他也知道人类如何把地球变成了地狱。
                 * library : DAILY
                 * tags : [{"id":744,"name":"每日创意灵感","actionUrl":"eyepetizer://tag/744/?title=%E6%AF%8F%E6%97%A5%E5%88%9B%E6%84%8F%E7%81%B5%E6%84%9F","adTrack":null,"desc":"技术与审美结合，探索视觉的无限可能","bgPicture":"http://img.kaiyanapp.com/bc2479c09cd15cb93b69d82e5f21c3fc.png?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/bc2479c09cd15cb93b69d82e5f21c3fc.png?imageMogr2/quality/60/format/jpg","tagRecType":"IMPORTANT","childTagList":null,"childTagIdList":null,"communityIndex":0},{"id":74,"name":"CG","actionUrl":"eyepetizer://tag/74/?title=CG","adTrack":null,"desc":null,"bgPicture":"http://img.kaiyanapp.com/fdac34e3c19adf85704b039126edef52.jpeg?imageMogr2/quality/100","headerImage":"http://img.kaiyanapp.com/e2a1eec9efb7e7d0abca85bbdedc425b.jpeg?imageMogr2/quality/100","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"communityIndex":0},{"id":122,"name":"科幻","actionUrl":"eyepetizer://tag/122/?title=%E7%A7%91%E5%B9%BB","adTrack":null,"desc":null,"bgPicture":"http://img.kaiyanapp.com/417a8466c670ccde688bb4b525ddf23d.jpeg?imageMogr2/quality/100","headerImage":"http://img.kaiyanapp.com/114beec25470880881352171834ddf43.jpeg?imageMogr2/quality/60","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"communityIndex":0},{"id":2,"name":"创意","actionUrl":"eyepetizer://tag/2/?title=%E5%88%9B%E6%84%8F","adTrack":null,"desc":"技术与审美结合，探索视觉的无限可能","bgPicture":"http://img.kaiyanapp.com/1b457058cf2b317304ff9f70543c040d.png?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/fdefdb34cbe3d2ac9964d306febe9025.jpeg?imageMogr2/quality/100","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"communityIndex":0}]
                 * consumption : {"collectionCount":716,"shareCount":203,"replyCount":25}
                 * resourceType : video
                 * slogan : 如果「三体」是部电影，这就是一切的序章
                 * provider : {"name":"Vimeo","alias":"vimeo","icon":"http://img.kaiyanapp.com/c3ad630be461cbb081649c9e21d6cbe3.png"}
                 * category : 创意
                 * author : {"id":4623,"icon":"http://img.kaiyanapp.com/a7df8dcfdfdbdd4f8c2275dc5e30bcae.png?imageMogr2/quality/60/format/jpg","name":"姓萧的陈冠森","description":"3D Generalist \\ VFX\nEmail: edison6@foxmail.com","link":"","latestReleaseTime":1563152409000,"videoNum":1,"adTrack":null,"follow":{"itemType":"author","itemId":4623,"followed":false},"shield":{"itemType":"author","itemId":4623,"shielded":false},"approvedNotReadyVideoCount":0,"ifPgc":true,"recSort":0,"expert":false}
                 * cover : {"feed":"http://img.kaiyanapp.com/fb9f6263539fba0eced53a770f33ff36.jpeg?imageMogr2/quality/60/format/jpg","detail":"http://img.kaiyanapp.com/fb9f6263539fba0eced53a770f33ff36.jpeg?imageMogr2/quality/60/format/jpg","blurred":"http://img.kaiyanapp.com/b7182c612d5387b79900d3f6214244ca.jpeg?imageMogr2/quality/60/format/jpg","sharing":null,"homepage":"http://img.kaiyanapp.com/fb9f6263539fba0eced53a770f33ff36.jpeg?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim"}
                 * playUrl : http://baobab.kaiyanapp.com/api/v1/playUrl?vid=166575&resourceType=video&editionType=default&source=aliyun&playUrlType=url_oss
                 * thumbPlayUrl : null
                 * duration : 194
                 * webUrl : {"raw":"http://www.eyepetizer.net/detail.html?vid=166575","forWeibo":"http://www.eyepetizer.net/detail.html?vid=166575"}
                 * releaseTime : 1563152409000
                 * playInfo : [{"height":488,"width":854,"urlList":[{"name":"aliyun","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=166575&resourceType=video&editionType=normal&source=aliyun&playUrlType=url_oss","size":9221251},{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=166575&resourceType=video&editionType=normal&source=qcloud&playUrlType=url_oss","size":9221251},{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=166575&resourceType=video&editionType=normal&source=ucloud&playUrlType=url_oss","size":9221251}],"name":"标清","type":"normal","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=166575&resourceType=video&editionType=normal&source=aliyun&playUrlType=url_oss"},{"height":732,"width":1280,"urlList":[{"name":"aliyun","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=166575&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss","size":16793750},{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=166575&resourceType=video&editionType=high&source=qcloud&playUrlType=url_oss","size":16793750},{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=166575&resourceType=video&editionType=high&source=ucloud&playUrlType=url_oss","size":16793750}],"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=166575&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss"}]
                 * campaign : null
                 * waterMarks : null
                 * ad : false
                 * adTrack : null
                 * type : NORMAL
                 * titlePgc : null
                 * descriptionPgc : null
                 * remark :
                 * ifLimitVideo : false
                 * searchWeight : 0
                 * idx : 0
                 * shareAdTrack : null
                 * favoriteAdTrack : null
                 * webAdTrack : null
                 * date : 1563152400000
                 * promotion : null
                 * label : null
                 * labelList : []
                 * descriptionEditor : 如果「三体」是部电影，那么说这部短片是它的预告也不为过。2048 年，机器人 Chris 和 Charlie 终于进入「人类种族复活计划」的最后一天，可已经彻底对人失望的 Chris 决定「毁灭计划，将地球交给某个外星球统治」……「Friday」是作者的毕业作品，灵感来源于科幻小说「三体」。除了暗喻人类在地球肆无忌惮的破坏，作者对短片的另一种解释是「这里的人类代表耶稣，人类的灭绝则代表了被钉死在十字架上的信仰」。Chris 当然知道这一天是「星期五」，他也知道人类如何把地球变成了地狱。
                 * collected : false
                 * played : false
                 * subtitles : []
                 * lastViewTime : null
                 * playlists : null
                 * src : null
                 */

                private String dataType;
                private int id;
                private String title;
                private String description;
                private String library;
                private ConsumptionBean consumption;
                private String resourceType;
                private String slogan;
                private ProviderBean provider;
                private String category;
                private AuthorBean author;
                private CoverBean cover;
                private String playUrl;
                private Object thumbPlayUrl;
                private int duration;
                private WebUrlBean webUrl;
                private long releaseTime;
                private Object campaign;
                private Object waterMarks;
                private boolean ad;
                private Object adTrack;
                private String type;
                private Object titlePgc;
                private Object descriptionPgc;
                private String remark;
                private boolean ifLimitVideo;
                private int searchWeight;
                private int idx;
                private Object shareAdTrack;
                private Object favoriteAdTrack;
                private Object webAdTrack;
                private long date;
                private Object promotion;
                private Object label;
                private String descriptionEditor;
                private boolean collected;
                private boolean played;
                private Object lastViewTime;
                private Object playlists;
                private Object src;
                private List<TagsBean> tags;
                private List<PlayInfoBean> playInfo;
                private List<?> labelList;
                private List<?> subtitles;
                private String text;

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                @Override
                public String toString() {
                    return "DataBean{" +
                            "dataType='" + dataType + '\'' +
                            ", id=" + id +
                            ", title='" + title + '\'' +
                            ", description='" + description + '\'' +
                            ", library='" + library + '\'' +
                            ", consumption=" + consumption +
                            ", resourceType='" + resourceType + '\'' +
                            ", slogan='" + slogan + '\'' +
                            ", provider=" + provider +
                            ", category='" + category + '\'' +
                            ", author=" + author +
                            ", cover=" + cover +
                            ", playUrl='" + playUrl + '\'' +
                            ", thumbPlayUrl=" + thumbPlayUrl +
                            ", duration=" + duration +
                            ", webUrl=" + webUrl +
                            ", releaseTime=" + releaseTime +
                            ", campaign=" + campaign +
                            ", waterMarks=" + waterMarks +
                            ", ad=" + ad +
                            ", adTrack=" + adTrack +
                            ", type='" + type + '\'' +
                            ", titlePgc=" + titlePgc +
                            ", descriptionPgc=" + descriptionPgc +
                            ", remark='" + remark + '\'' +
                            ", ifLimitVideo=" + ifLimitVideo +
                            ", searchWeight=" + searchWeight +
                            ", idx=" + idx +
                            ", shareAdTrack=" + shareAdTrack +
                            ", favoriteAdTrack=" + favoriteAdTrack +
                            ", webAdTrack=" + webAdTrack +
                            ", date=" + date +
                            ", promotion=" + promotion +
                            ", label=" + label +
                            ", descriptionEditor='" + descriptionEditor + '\'' +
                            ", collected=" + collected +
                            ", played=" + played +
                            ", lastViewTime=" + lastViewTime +
                            ", playlists=" + playlists +
                            ", src=" + src +
                            ", tags=" + tags +
                            ", playInfo=" + playInfo +
                            ", labelList=" + labelList +
                            ", subtitles=" + subtitles +
                            '}';
                }

                public String getDataType() {
                    return dataType;
                }

                public void setDataType(String dataType) {
                    this.dataType = dataType;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public String getLibrary() {
                    return library;
                }

                public void setLibrary(String library) {
                    this.library = library;
                }

                public ConsumptionBean getConsumption() {
                    return consumption;
                }

                public void setConsumption(ConsumptionBean consumption) {
                    this.consumption = consumption;
                }

                public String getResourceType() {
                    return resourceType;
                }

                public void setResourceType(String resourceType) {
                    this.resourceType = resourceType;
                }

                public String getSlogan() {
                    return slogan;
                }

                public void setSlogan(String slogan) {
                    this.slogan = slogan;
                }

                public ProviderBean getProvider() {
                    return provider;
                }

                public void setProvider(ProviderBean provider) {
                    this.provider = provider;
                }

                public String getCategory() {
                    return category;
                }

                public void setCategory(String category) {
                    this.category = category;
                }

                public AuthorBean getAuthor() {
                    return author;
                }

                public void setAuthor(AuthorBean author) {
                    this.author = author;
                }

                public CoverBean getCover() {
                    return cover;
                }

                public void setCover(CoverBean cover) {
                    this.cover = cover;
                }

                public String getPlayUrl() {
                    return playUrl;
                }

                public void setPlayUrl(String playUrl) {
                    this.playUrl = playUrl;
                }

                public Object getThumbPlayUrl() {
                    return thumbPlayUrl;
                }

                public void setThumbPlayUrl(Object thumbPlayUrl) {
                    this.thumbPlayUrl = thumbPlayUrl;
                }

                public int getDuration() {
                    return duration;
                }

                public void setDuration(int duration) {
                    this.duration = duration;
                }

                public WebUrlBean getWebUrl() {
                    return webUrl;
                }

                public void setWebUrl(WebUrlBean webUrl) {
                    this.webUrl = webUrl;
                }

                public long getReleaseTime() {
                    return releaseTime;
                }

                public void setReleaseTime(long releaseTime) {
                    this.releaseTime = releaseTime;
                }

                public Object getCampaign() {
                    return campaign;
                }

                public void setCampaign(Object campaign) {
                    this.campaign = campaign;
                }

                public Object getWaterMarks() {
                    return waterMarks;
                }

                public void setWaterMarks(Object waterMarks) {
                    this.waterMarks = waterMarks;
                }

                public boolean isAd() {
                    return ad;
                }

                public void setAd(boolean ad) {
                    this.ad = ad;
                }

                public Object getAdTrack() {
                    return adTrack;
                }

                public void setAdTrack(Object adTrack) {
                    this.adTrack = adTrack;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public Object getTitlePgc() {
                    return titlePgc;
                }

                public void setTitlePgc(Object titlePgc) {
                    this.titlePgc = titlePgc;
                }

                public Object getDescriptionPgc() {
                    return descriptionPgc;
                }

                public void setDescriptionPgc(Object descriptionPgc) {
                    this.descriptionPgc = descriptionPgc;
                }

                public String getRemark() {
                    return remark;
                }

                public void setRemark(String remark) {
                    this.remark = remark;
                }

                public boolean isIfLimitVideo() {
                    return ifLimitVideo;
                }

                public void setIfLimitVideo(boolean ifLimitVideo) {
                    this.ifLimitVideo = ifLimitVideo;
                }

                public int getSearchWeight() {
                    return searchWeight;
                }

                public void setSearchWeight(int searchWeight) {
                    this.searchWeight = searchWeight;
                }

                public int getIdx() {
                    return idx;
                }

                public void setIdx(int idx) {
                    this.idx = idx;
                }

                public Object getShareAdTrack() {
                    return shareAdTrack;
                }

                public void setShareAdTrack(Object shareAdTrack) {
                    this.shareAdTrack = shareAdTrack;
                }

                public Object getFavoriteAdTrack() {
                    return favoriteAdTrack;
                }

                public void setFavoriteAdTrack(Object favoriteAdTrack) {
                    this.favoriteAdTrack = favoriteAdTrack;
                }

                public Object getWebAdTrack() {
                    return webAdTrack;
                }

                public void setWebAdTrack(Object webAdTrack) {
                    this.webAdTrack = webAdTrack;
                }

                public long getDate() {
                    return date;
                }

                public void setDate(long date) {
                    this.date = date;
                }

                public Object getPromotion() {
                    return promotion;
                }

                public void setPromotion(Object promotion) {
                    this.promotion = promotion;
                }

                public Object getLabel() {
                    return label;
                }

                public void setLabel(Object label) {
                    this.label = label;
                }

                public String getDescriptionEditor() {
                    return descriptionEditor;
                }

                public void setDescriptionEditor(String descriptionEditor) {
                    this.descriptionEditor = descriptionEditor;
                }

                public boolean isCollected() {
                    return collected;
                }

                public void setCollected(boolean collected) {
                    this.collected = collected;
                }

                public boolean isPlayed() {
                    return played;
                }

                public void setPlayed(boolean played) {
                    this.played = played;
                }

                public Object getLastViewTime() {
                    return lastViewTime;
                }

                public void setLastViewTime(Object lastViewTime) {
                    this.lastViewTime = lastViewTime;
                }

                public Object getPlaylists() {
                    return playlists;
                }

                public void setPlaylists(Object playlists) {
                    this.playlists = playlists;
                }

                public Object getSrc() {
                    return src;
                }

                public void setSrc(Object src) {
                    this.src = src;
                }

                public List<TagsBean> getTags() {
                    return tags;
                }

                public void setTags(List<TagsBean> tags) {
                    this.tags = tags;
                }

                public List<PlayInfoBean> getPlayInfo() {
                    return playInfo;
                }

                public void setPlayInfo(List<PlayInfoBean> playInfo) {
                    this.playInfo = playInfo;
                }

                public List<?> getLabelList() {
                    return labelList;
                }

                public void setLabelList(List<?> labelList) {
                    this.labelList = labelList;
                }

                public List<?> getSubtitles() {
                    return subtitles;
                }

                public void setSubtitles(List<?> subtitles) {
                    this.subtitles = subtitles;
                }

                public static class ConsumptionBean {
                    /**
                     * collectionCount : 716
                     * shareCount : 203
                     * replyCount : 25
                     */

                    private int collectionCount;
                    private int shareCount;
                    private int replyCount;

                    public int getCollectionCount() {
                        return collectionCount;
                    }

                    public void setCollectionCount(int collectionCount) {
                        this.collectionCount = collectionCount;
                    }

                    public int getShareCount() {
                        return shareCount;
                    }

                    public void setShareCount(int shareCount) {
                        this.shareCount = shareCount;
                    }

                    public int getReplyCount() {
                        return replyCount;
                    }

                    public void setReplyCount(int replyCount) {
                        this.replyCount = replyCount;
                    }
                }

                public static class ProviderBean {
                    /**
                     * name : Vimeo
                     * alias : vimeo
                     * icon : http://img.kaiyanapp.com/c3ad630be461cbb081649c9e21d6cbe3.png
                     */

                    private String name;
                    private String alias;
                    private String icon;

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getAlias() {
                        return alias;
                    }

                    public void setAlias(String alias) {
                        this.alias = alias;
                    }

                    public String getIcon() {
                        return icon;
                    }

                    public void setIcon(String icon) {
                        this.icon = icon;
                    }
                }

                public static class AuthorBean {
                    /**
                     * id : 4623
                     * icon : http://img.kaiyanapp.com/a7df8dcfdfdbdd4f8c2275dc5e30bcae.png?imageMogr2/quality/60/format/jpg
                     * name : 姓萧的陈冠森
                     * description : 3D Generalist \ VFX
                     * Email: edison6@foxmail.com
                     * link :
                     * latestReleaseTime : 1563152409000
                     * videoNum : 1
                     * adTrack : null
                     * follow : {"itemType":"author","itemId":4623,"followed":false}
                     * shield : {"itemType":"author","itemId":4623,"shielded":false}
                     * approvedNotReadyVideoCount : 0
                     * ifPgc : true
                     * recSort : 0
                     * expert : false
                     */

                    private int id;
                    private String icon;
                    private String name;
                    private String description;
                    private String link;
                    private long latestReleaseTime;
                    private int videoNum;
                    private Object adTrack;
                    private FollowBean follow;
                    private ShieldBean shield;
                    private int approvedNotReadyVideoCount;
                    private boolean ifPgc;
                    private int recSort;
                    private boolean expert;

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public String getIcon() {
                        return icon;
                    }

                    public void setIcon(String icon) {
                        this.icon = icon;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getDescription() {
                        return description;
                    }

                    public void setDescription(String description) {
                        this.description = description;
                    }

                    public String getLink() {
                        return link;
                    }

                    public void setLink(String link) {
                        this.link = link;
                    }

                    public long getLatestReleaseTime() {
                        return latestReleaseTime;
                    }

                    public void setLatestReleaseTime(long latestReleaseTime) {
                        this.latestReleaseTime = latestReleaseTime;
                    }

                    public int getVideoNum() {
                        return videoNum;
                    }

                    public void setVideoNum(int videoNum) {
                        this.videoNum = videoNum;
                    }

                    public Object getAdTrack() {
                        return adTrack;
                    }

                    public void setAdTrack(Object adTrack) {
                        this.adTrack = adTrack;
                    }

                    public FollowBean getFollow() {
                        return follow;
                    }

                    public void setFollow(FollowBean follow) {
                        this.follow = follow;
                    }

                    public ShieldBean getShield() {
                        return shield;
                    }

                    public void setShield(ShieldBean shield) {
                        this.shield = shield;
                    }

                    public int getApprovedNotReadyVideoCount() {
                        return approvedNotReadyVideoCount;
                    }

                    public void setApprovedNotReadyVideoCount(int approvedNotReadyVideoCount) {
                        this.approvedNotReadyVideoCount = approvedNotReadyVideoCount;
                    }

                    public boolean isIfPgc() {
                        return ifPgc;
                    }

                    public void setIfPgc(boolean ifPgc) {
                        this.ifPgc = ifPgc;
                    }

                    public int getRecSort() {
                        return recSort;
                    }

                    public void setRecSort(int recSort) {
                        this.recSort = recSort;
                    }

                    public boolean isExpert() {
                        return expert;
                    }

                    public void setExpert(boolean expert) {
                        this.expert = expert;
                    }

                    public static class FollowBean {
                        /**
                         * itemType : author
                         * itemId : 4623
                         * followed : false
                         */

                        private String itemType;
                        private int itemId;
                        private boolean followed;

                        public String getItemType() {
                            return itemType;
                        }

                        public void setItemType(String itemType) {
                            this.itemType = itemType;
                        }

                        public int getItemId() {
                            return itemId;
                        }

                        public void setItemId(int itemId) {
                            this.itemId = itemId;
                        }

                        public boolean isFollowed() {
                            return followed;
                        }

                        public void setFollowed(boolean followed) {
                            this.followed = followed;
                        }
                    }

                    public static class ShieldBean {
                        /**
                         * itemType : author
                         * itemId : 4623
                         * shielded : false
                         */

                        private String itemType;
                        private int itemId;
                        private boolean shielded;

                        public String getItemType() {
                            return itemType;
                        }

                        public void setItemType(String itemType) {
                            this.itemType = itemType;
                        }

                        public int getItemId() {
                            return itemId;
                        }

                        public void setItemId(int itemId) {
                            this.itemId = itemId;
                        }

                        public boolean isShielded() {
                            return shielded;
                        }

                        public void setShielded(boolean shielded) {
                            this.shielded = shielded;
                        }
                    }
                }

                public static class CoverBean {
                    /**
                     * feed : http://img.kaiyanapp.com/fb9f6263539fba0eced53a770f33ff36.jpeg?imageMogr2/quality/60/format/jpg
                     * detail : http://img.kaiyanapp.com/fb9f6263539fba0eced53a770f33ff36.jpeg?imageMogr2/quality/60/format/jpg
                     * blurred : http://img.kaiyanapp.com/b7182c612d5387b79900d3f6214244ca.jpeg?imageMogr2/quality/60/format/jpg
                     * sharing : null
                     * homepage : http://img.kaiyanapp.com/fb9f6263539fba0eced53a770f33ff36.jpeg?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim
                     */

                    private String feed;
                    private String detail;
                    private String blurred;
                    private Object sharing;
                    private String homepage;

                    public String getFeed() {
                        return feed;
                    }

                    public void setFeed(String feed) {
                        this.feed = feed;
                    }

                    public String getDetail() {
                        return detail;
                    }

                    public void setDetail(String detail) {
                        this.detail = detail;
                    }

                    public String getBlurred() {
                        return blurred;
                    }

                    public void setBlurred(String blurred) {
                        this.blurred = blurred;
                    }

                    public Object getSharing() {
                        return sharing;
                    }

                    public void setSharing(Object sharing) {
                        this.sharing = sharing;
                    }

                    public String getHomepage() {
                        return homepage;
                    }

                    public void setHomepage(String homepage) {
                        this.homepage = homepage;
                    }
                }

                public static class WebUrlBean {
                    /**
                     * raw : http://www.eyepetizer.net/detail.html?vid=166575
                     * forWeibo : http://www.eyepetizer.net/detail.html?vid=166575
                     */

                    private String raw;
                    private String forWeibo;

                    public String getRaw() {
                        return raw;
                    }

                    public void setRaw(String raw) {
                        this.raw = raw;
                    }

                    public String getForWeibo() {
                        return forWeibo;
                    }

                    public void setForWeibo(String forWeibo) {
                        this.forWeibo = forWeibo;
                    }
                }

                public static class TagsBean {
                    /**
                     * id : 744
                     * name : 每日创意灵感
                     * actionUrl : eyepetizer://tag/744/?title=%E6%AF%8F%E6%97%A5%E5%88%9B%E6%84%8F%E7%81%B5%E6%84%9F
                     * adTrack : null
                     * desc : 技术与审美结合，探索视觉的无限可能
                     * bgPicture : http://img.kaiyanapp.com/bc2479c09cd15cb93b69d82e5f21c3fc.png?imageMogr2/quality/60/format/jpg
                     * headerImage : http://img.kaiyanapp.com/bc2479c09cd15cb93b69d82e5f21c3fc.png?imageMogr2/quality/60/format/jpg
                     * tagRecType : IMPORTANT
                     * childTagList : null
                     * childTagIdList : null
                     * communityIndex : 0
                     */

                    private int id;
                    private String name;
                    private String actionUrl;
                    private Object adTrack;
                    private String desc;
                    private String bgPicture;
                    private String headerImage;
                    private String tagRecType;
                    private Object childTagList;
                    private Object childTagIdList;
                    private int communityIndex;

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getActionUrl() {
                        return actionUrl;
                    }

                    public void setActionUrl(String actionUrl) {
                        this.actionUrl = actionUrl;
                    }

                    public Object getAdTrack() {
                        return adTrack;
                    }

                    public void setAdTrack(Object adTrack) {
                        this.adTrack = adTrack;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public String getBgPicture() {
                        return bgPicture;
                    }

                    public void setBgPicture(String bgPicture) {
                        this.bgPicture = bgPicture;
                    }

                    public String getHeaderImage() {
                        return headerImage;
                    }

                    public void setHeaderImage(String headerImage) {
                        this.headerImage = headerImage;
                    }

                    public String getTagRecType() {
                        return tagRecType;
                    }

                    public void setTagRecType(String tagRecType) {
                        this.tagRecType = tagRecType;
                    }

                    public Object getChildTagList() {
                        return childTagList;
                    }

                    public void setChildTagList(Object childTagList) {
                        this.childTagList = childTagList;
                    }

                    public Object getChildTagIdList() {
                        return childTagIdList;
                    }

                    public void setChildTagIdList(Object childTagIdList) {
                        this.childTagIdList = childTagIdList;
                    }

                    public int getCommunityIndex() {
                        return communityIndex;
                    }

                    public void setCommunityIndex(int communityIndex) {
                        this.communityIndex = communityIndex;
                    }
                }

                public static class PlayInfoBean {
                    /**
                     * height : 488
                     * width : 854
                     * urlList : [{"name":"aliyun","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=166575&resourceType=video&editionType=normal&source=aliyun&playUrlType=url_oss","size":9221251},{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=166575&resourceType=video&editionType=normal&source=qcloud&playUrlType=url_oss","size":9221251},{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=166575&resourceType=video&editionType=normal&source=ucloud&playUrlType=url_oss","size":9221251}]
                     * name : 标清
                     * type : normal
                     * url : http://baobab.kaiyanapp.com/api/v1/playUrl?vid=166575&resourceType=video&editionType=normal&source=aliyun&playUrlType=url_oss
                     */

                    private int height;
                    private int width;
                    private String name;
                    private String type;
                    private String url;
                    private List<UrlListBean> urlList;

                    public int getHeight() {
                        return height;
                    }

                    public void setHeight(int height) {
                        this.height = height;
                    }

                    public int getWidth() {
                        return width;
                    }

                    public void setWidth(int width) {
                        this.width = width;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getType() {
                        return type;
                    }

                    public void setType(String type) {
                        this.type = type;
                    }

                    public String getUrl() {
                        return url;
                    }

                    public void setUrl(String url) {
                        this.url = url;
                    }

                    public List<UrlListBean> getUrlList() {
                        return urlList;
                    }

                    public void setUrlList(List<UrlListBean> urlList) {
                        this.urlList = urlList;
                    }

                    public static class UrlListBean {
                        /**
                         * name : aliyun
                         * url : http://baobab.kaiyanapp.com/api/v1/playUrl?vid=166575&resourceType=video&editionType=normal&source=aliyun&playUrlType=url_oss
                         * size : 9221251
                         */

                        private String name;
                        private String url;
                        private int size;

                        public String getName() {
                            return name;
                        }

                        public void setName(String name) {
                            this.name = name;
                        }

                        public String getUrl() {
                            return url;
                        }

                        public void setUrl(String url) {
                            this.url = url;
                        }

                        public int getSize() {
                            return size;
                        }

                        public void setSize(int size) {
                            this.size = size;
                        }
                    }
                }
            }
        }
    }
}
