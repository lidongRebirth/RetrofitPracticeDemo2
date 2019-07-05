package com.ld.retrofitpracticedemo2.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * @Author      LD
 * @Time        2019/1/28 18:32
 * @Describe    返回的收藏文章的总的列表
 * @Modify
 */
public class MyCollectionBean {


    /**
     * data : {"curPage":1,"datas":[{"author":"yuwenque","chapterId":328,"chapterName":"网络&amp;文件下载","courseId":13,"desc":"一个支持断点续传的下载器\r\n\r\n主要功能\r\n\r\n- 支持断点续传下载\r\n- 支持自定义文件夹路径、文件名。\r\n- 支持自定义SQLiteOpenHelper，用于保存下载进度等\r\n- 下载进度回调时自动切换到UI线程，方便更新UI。\r\n- 自动与activity绑定生命周期，无需手动释放\r\n- activity不可见时，不会更新UI，可见时会自动恢复状态\r\n- 自定义请求头\r\n- 支持查询下载历史列表","envelopePic":"http://www.wanandroid.com/resources/image/pc/default_project_img.jpg","id":45572,"link":"http://www.wanandroid.com/blog/show/2209","niceDate":"16小时前","origin":"","originId":3121,"publishTime":1548668574000,"title":"Android断点续传下载器JarvisDownloader","userId":16606,"visible":0,"zan":0},{"author":"李栋3","chapterId":0,"chapterName":"","courseId":13,"desc":"","envelopePic":"","id":45571,"link":"https://www2.bing.com/","niceDate":"16小时前","origin":"","originId":-1,"publishTime":1548667284000,"title":"第三个站外文章，标题长一些标题长一些标题长一些标题长一些标题长一些标题长一些标题长一些标题长一些标题长一些标题长一些标题长一些","userId":16606,"visible":0,"zan":0},{"author":"李栋2","chapterId":0,"chapterName":"","courseId":13,"desc":"","envelopePic":"","id":45565,"link":"https://www2.bing.com/","niceDate":"17小时前","origin":"","originId":-1,"publishTime":1548664023000,"title":"第二个站外文章","userId":16606,"visible":0,"zan":0},{"author":"李栋","chapterId":0,"chapterName":"","courseId":13,"desc":"","envelopePic":"","id":45564,"link":"https://www2.bing.com/","niceDate":"17小时前","origin":"","originId":-1,"publishTime":1548664002000,"title":"自己瞎写的","userId":16606,"visible":0,"zan":0},{"author":"zhangyujiu","chapterId":402,"chapterName":"跨平台应用","courseId":13,"desc":"flutter版的Wanandroid项目","envelopePic":"http://www.wanandroid.com/blogimgs/3bec6028-980e-4c9f-9702-ff3742431462.png","id":45318,"link":"http://www.wanandroid.com/blog/show/2489","niceDate":"1天前","origin":"","originId":7790,"publishTime":1548563926000,"title":"flutter版的Wanandroid项目","userId":16606,"visible":0,"zan":0},{"author":"AICareless","chapterId":402,"chapterName":"跨平台应用","courseId":13,"desc":"极客日报的flutter版本","envelopePic":"http://www.wanandroid.com/blogimgs/0be29fb4-558a-4294-96d7-17398937569a.png","id":45317,"link":"http://www.wanandroid.com/blog/show/2494","niceDate":"1天前","origin":"","originId":7905,"publishTime":1548563922000,"title":"极客日报的flutter版本","userId":16606,"visible":0,"zan":0},{"author":"yangchong211","chapterId":294,"chapterName":"完整项目","courseId":13,"desc":"flutter学习案例，接口使用玩Android开放的api，作为新手入门训练代码案例，已经完成了基本的功能。努力打造一个体验好的flutter版本的玩android客户端！ ","envelopePic":"http://wanandroid.com/blogimgs/859a48f2-9ed9-4c13-b12b-23e1827ee103.png","id":45312,"link":"http://www.wanandroid.com/blog/show/2469","niceDate":"1天前","origin":"","originId":7728,"publishTime":1548562415000,"title":"flutter版本的玩Android客户端","userId":16606,"visible":0,"zan":0},{"author":"chinalwb","chapterId":294,"chapterName":"完整项目","courseId":13,"desc":"用组件化的思想实现一个玩Android APP。目前首页、项目、公众号分别以组件的形式显示到了app中。项目地址附上了实现步骤，欢迎实现您自己的组件！欢迎提出问题 欢迎讨论 欢迎赐教。","envelopePic":"http://www.wanandroid.com/blogimgs/76eb003b-7db1-4e00-be3d-3076b48afc8c.png","id":45311,"link":"http://www.wanandroid.com/blog/show/2483","niceDate":"1天前","origin":"","originId":7775,"publishTime":1548562413000,"title":"组件化的玩Android App","userId":16606,"visible":0,"zan":0},{"author":"kingwang666","chapterId":294,"chapterName":"完整项目","courseId":13,"desc":"APP信息是一个免费的工具应用. 它有以下功能特点:\r\n\r\n查看已安装的app信息.\r\n查看未安装的apk信息.\r\n导出已安装的app应用的apk文件.\r\n复制apk的签名信息到剪切板.","envelopePic":"http://wanandroid.com/blogimgs/f16b7060-38e2-4ebd-87d9-d61b59a000e2.png","id":45310,"link":"http://www.wanandroid.com/blog/show/2493","niceDate":"1天前","origin":"","originId":7892,"publishTime":1548562411000,"title":"一个可以显示app或者apk信息。并且可导出已安装的app的apk文件工具应用","userId":16606,"visible":0,"zan":0},{"author":"arvinljw","chapterId":294,"chapterName":"完整项目","courseId":13,"desc":"Retrofit+LiveData 封装网络请求，DrawerLayout+BottomNavigationView+Fragment 实现侧边栏加底部导航的App整体结构，SwipeRefreshLayout+BaseQuickAdapter实现列表的下拉刷新和上拉加载，TabLayout+ViewPager+Fragment实现顶部导航布局；更多功能项目吧。","envelopePic":"http://wanandroid.com/blogimgs/4384c478-c3a5-4c0a-b7a1-a5e48c772ebf.png","id":45299,"link":"http://www.wanandroid.com/blog/show/2476","niceDate":"1天前","origin":"","originId":7735,"publishTime":1548561308000,"title":"WanAdnroid练手项目","userId":16606,"visible":0,"zan":0},{"author":"songmao123","chapterId":294,"chapterName":"完整项目","courseId":13,"desc":"一款数据基于Wan Android API，采用Kotlin+MVP+Dagger2+Rxjava架构的Material Design风格玩安卓客户端。","envelopePic":"http://www.wanandroid.com/blogimgs/4c47aec3-1740-4ad9-9a37-ee99a1e742de.png","id":45286,"link":"http://www.wanandroid.com/blog/show/2429","niceDate":"1天前","origin":"","originId":7555,"publishTime":1548557481000,"title":"Kotlin+MVP+RxJava+Dagger2版玩安卓客户端","userId":16606,"visible":0,"zan":0},{"author":"xujiaji","chapterId":294,"chapterName":"完整项目","courseId":13,"desc":"一个非常简洁清爽的清单工具，帮您轻松记录个人计划。本App的特色就是简洁，让人一目了然，在交互上让人体会到视觉上的舒适感。固定的4种清单分类在顶部可直接切换列表。API由WanAndroid提供","envelopePic":"http://wanandroid.com/blogimgs/238c157d-a397-4070-af0f-bf039061f653.png","id":45285,"link":"http://www.wanandroid.com/blog/show/2444","niceDate":"1天前","origin":"","originId":7611,"publishTime":1548557472000,"title":"玩清单-怎么这么好用这么好看！才...才不是因为自己开发的呢！o(*￣3￣)o ","userId":16606,"visible":0,"zan":0},{"author":"zqljintu","chapterId":294,"chapterName":"完整项目","courseId":13,"desc":"网上有各种各样的免费API,在众里寻找后，最后发现何不将这些API集合在一个App中呢，鉴于个人能力有限，就选取了部分的API来创作。 感谢知乎日报的Api，提供了App中的日报板块。 感谢豆瓣的Api，提供了App中的电影板块。 感谢WanAndroid的Api，提供了开发板块。 感谢Gank.io的Api，提供了娱乐版块","envelopePic":"http://wanandroid.com/blogimgs/271a4c3f-8066-4038-b4e6-9e5756463403.png","id":45284,"link":"http://www.wanandroid.com/blog/show/2445","niceDate":"1天前","origin":"","originId":7612,"publishTime":1548557466000,"title":"集结号//Assembly-number&mdash;&mdash;集合了多项内容的客户端","userId":16606,"visible":0,"zan":0},{"author":"littledavid-tech","chapterId":294,"chapterName":"完整项目","courseId":13,"desc":"这个算是对Android学习总结，MVP架构+好多轮子","envelopePic":"http://wanandroid.com/blogimgs/9be242c9-e53e-4a54-9f49-d69b04b463b9.png","id":45283,"link":"http://www.wanandroid.com/blog/show/2449","niceDate":"1天前","origin":"","originId":7641,"publishTime":1548556850000,"title":"我的涂鸦之作WanAndroid第三方客户端","userId":16606,"visible":0,"zan":0},{"author":"chinalwb","chapterId":294,"chapterName":"完整项目","courseId":13,"desc":"目前支持的样式:\r\n加粗\r\n斜体\r\n下划线\r\n删除线\r\n有序列表\r\n无序列表\r\n左对齐\r\n居中对齐 \r\n右对齐\r\n插入图片\r\n文字背景色\r\n插入超链接 \r\n@功能\r\n引用\r\n文字颜色（前景色）\r\n插入表情\r\n上角标\r\n下角标\r\n字体大小\r\n插入视频\r\n插入网络图片\r\n插入分割线\r\n所有样式均支持导出HTML文件\r\n加载HTML内容并继续编辑或显示","envelopePic":"http://wanandroid.com/blogimgs/92d3f901-29c9-4c5f-9bee-cfd028e81d49.png","id":45282,"link":"http://www.wanandroid.com/blog/show/2455","niceDate":"1天前","origin":"","originId":7694,"publishTime":1548556846000,"title":"基于自定义Span的富文本编辑器","userId":16606,"visible":0,"zan":0},{"author":"rain9155","chapterId":294,"chapterName":"完整项目","courseId":13,"desc":"使用WanAndroid网站api，一款基于MVP + Rxjava2 + Dagger2 + Retrofit + Material Design的WanAndroid应用。","envelopePic":"http://wanandroid.com/blogimgs/02547877-4a5b-4873-b270-0ee06d4959d7.png","id":45281,"link":"http://www.wanandroid.com/blog/show/2457","niceDate":"1天前","origin":"","originId":7696,"publishTime":1548556844000,"title":"WanAndroid应用","userId":16606,"visible":0,"zan":0},{"author":"gaoleicoding","chapterId":294,"chapterName":"完整项目","courseId":13,"desc":"学Android 主要是采用 MVP + RxJava2 + Retrofit + Multimodule 等架构设计。利用开源的api获取有关android知识的数据，非常感谢张鸿洋老师提供的开放api！向开源者致敬！项目中把目前流行的项目框架都集成到了，代码结构清晰并且有详细注释，如有建议或疑问可留言反馈 。","envelopePic":"http://wanandroid.com/blogimgs/056802c7-9a43-4081-9482-35d0c4e1a9fc.png","id":45241,"link":"http://www.wanandroid.com/blog/show/2463","niceDate":"2天前","origin":"","originId":7722,"publishTime":1548509287000,"title":"结合android当前著名框架写的一个项目--学Android","userId":16606,"visible":0,"zan":0},{"author":"Ruheng","chapterId":26,"chapterName":"基础UI控件","courseId":13,"desc":"详解Android图文混排实现。","envelopePic":"","id":45022,"link":"http://www.jianshu.com/p/6843f332c8df","niceDate":"2019-01-24","origin":"","originId":1165,"publishTime":1548321533000,"title":"Android图文混排实现方式详解","userId":16606,"visible":0,"zan":0}],"offset":0,"over":true,"pageCount":1,"size":20,"total":18}
     * errorCode : 0
     * errorMsg :
     */

    private DataBean data;
    private int errorCode;
    private String errorMsg;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public static class DataBean {
        /**
         * curPage : 1
         * datas : [{"author":"yuwenque","chapterId":328,"chapterName":"网络&amp;文件下载","courseId":13,"desc":"一个支持断点续传的下载器\r\n\r\n主要功能\r\n\r\n- 支持断点续传下载\r\n- 支持自定义文件夹路径、文件名。\r\n- 支持自定义SQLiteOpenHelper，用于保存下载进度等\r\n- 下载进度回调时自动切换到UI线程，方便更新UI。\r\n- 自动与activity绑定生命周期，无需手动释放\r\n- activity不可见时，不会更新UI，可见时会自动恢复状态\r\n- 自定义请求头\r\n- 支持查询下载历史列表","envelopePic":"http://www.wanandroid.com/resources/image/pc/default_project_img.jpg","id":45572,"link":"http://www.wanandroid.com/blog/show/2209","niceDate":"16小时前","origin":"","originId":3121,"publishTime":1548668574000,"title":"Android断点续传下载器JarvisDownloader","userId":16606,"visible":0,"zan":0},{"author":"李栋3","chapterId":0,"chapterName":"","courseId":13,"desc":"","envelopePic":"","id":45571,"link":"https://www2.bing.com/","niceDate":"16小时前","origin":"","originId":-1,"publishTime":1548667284000,"title":"第三个站外文章，标题长一些标题长一些标题长一些标题长一些标题长一些标题长一些标题长一些标题长一些标题长一些标题长一些标题长一些","userId":16606,"visible":0,"zan":0},{"author":"李栋2","chapterId":0,"chapterName":"","courseId":13,"desc":"","envelopePic":"","id":45565,"link":"https://www2.bing.com/","niceDate":"17小时前","origin":"","originId":-1,"publishTime":1548664023000,"title":"第二个站外文章","userId":16606,"visible":0,"zan":0},{"author":"李栋","chapterId":0,"chapterName":"","courseId":13,"desc":"","envelopePic":"","id":45564,"link":"https://www2.bing.com/","niceDate":"17小时前","origin":"","originId":-1,"publishTime":1548664002000,"title":"自己瞎写的","userId":16606,"visible":0,"zan":0},{"author":"zhangyujiu","chapterId":402,"chapterName":"跨平台应用","courseId":13,"desc":"flutter版的Wanandroid项目","envelopePic":"http://www.wanandroid.com/blogimgs/3bec6028-980e-4c9f-9702-ff3742431462.png","id":45318,"link":"http://www.wanandroid.com/blog/show/2489","niceDate":"1天前","origin":"","originId":7790,"publishTime":1548563926000,"title":"flutter版的Wanandroid项目","userId":16606,"visible":0,"zan":0},{"author":"AICareless","chapterId":402,"chapterName":"跨平台应用","courseId":13,"desc":"极客日报的flutter版本","envelopePic":"http://www.wanandroid.com/blogimgs/0be29fb4-558a-4294-96d7-17398937569a.png","id":45317,"link":"http://www.wanandroid.com/blog/show/2494","niceDate":"1天前","origin":"","originId":7905,"publishTime":1548563922000,"title":"极客日报的flutter版本","userId":16606,"visible":0,"zan":0},{"author":"yangchong211","chapterId":294,"chapterName":"完整项目","courseId":13,"desc":"flutter学习案例，接口使用玩Android开放的api，作为新手入门训练代码案例，已经完成了基本的功能。努力打造一个体验好的flutter版本的玩android客户端！ ","envelopePic":"http://wanandroid.com/blogimgs/859a48f2-9ed9-4c13-b12b-23e1827ee103.png","id":45312,"link":"http://www.wanandroid.com/blog/show/2469","niceDate":"1天前","origin":"","originId":7728,"publishTime":1548562415000,"title":"flutter版本的玩Android客户端","userId":16606,"visible":0,"zan":0},{"author":"chinalwb","chapterId":294,"chapterName":"完整项目","courseId":13,"desc":"用组件化的思想实现一个玩Android APP。目前首页、项目、公众号分别以组件的形式显示到了app中。项目地址附上了实现步骤，欢迎实现您自己的组件！欢迎提出问题 欢迎讨论 欢迎赐教。","envelopePic":"http://www.wanandroid.com/blogimgs/76eb003b-7db1-4e00-be3d-3076b48afc8c.png","id":45311,"link":"http://www.wanandroid.com/blog/show/2483","niceDate":"1天前","origin":"","originId":7775,"publishTime":1548562413000,"title":"组件化的玩Android App","userId":16606,"visible":0,"zan":0},{"author":"kingwang666","chapterId":294,"chapterName":"完整项目","courseId":13,"desc":"APP信息是一个免费的工具应用. 它有以下功能特点:\r\n\r\n查看已安装的app信息.\r\n查看未安装的apk信息.\r\n导出已安装的app应用的apk文件.\r\n复制apk的签名信息到剪切板.","envelopePic":"http://wanandroid.com/blogimgs/f16b7060-38e2-4ebd-87d9-d61b59a000e2.png","id":45310,"link":"http://www.wanandroid.com/blog/show/2493","niceDate":"1天前","origin":"","originId":7892,"publishTime":1548562411000,"title":"一个可以显示app或者apk信息。并且可导出已安装的app的apk文件工具应用","userId":16606,"visible":0,"zan":0},{"author":"arvinljw","chapterId":294,"chapterName":"完整项目","courseId":13,"desc":"Retrofit+LiveData 封装网络请求，DrawerLayout+BottomNavigationView+Fragment 实现侧边栏加底部导航的App整体结构，SwipeRefreshLayout+BaseQuickAdapter实现列表的下拉刷新和上拉加载，TabLayout+ViewPager+Fragment实现顶部导航布局；更多功能项目吧。","envelopePic":"http://wanandroid.com/blogimgs/4384c478-c3a5-4c0a-b7a1-a5e48c772ebf.png","id":45299,"link":"http://www.wanandroid.com/blog/show/2476","niceDate":"1天前","origin":"","originId":7735,"publishTime":1548561308000,"title":"WanAdnroid练手项目","userId":16606,"visible":0,"zan":0},{"author":"songmao123","chapterId":294,"chapterName":"完整项目","courseId":13,"desc":"一款数据基于Wan Android API，采用Kotlin+MVP+Dagger2+Rxjava架构的Material Design风格玩安卓客户端。","envelopePic":"http://www.wanandroid.com/blogimgs/4c47aec3-1740-4ad9-9a37-ee99a1e742de.png","id":45286,"link":"http://www.wanandroid.com/blog/show/2429","niceDate":"1天前","origin":"","originId":7555,"publishTime":1548557481000,"title":"Kotlin+MVP+RxJava+Dagger2版玩安卓客户端","userId":16606,"visible":0,"zan":0},{"author":"xujiaji","chapterId":294,"chapterName":"完整项目","courseId":13,"desc":"一个非常简洁清爽的清单工具，帮您轻松记录个人计划。本App的特色就是简洁，让人一目了然，在交互上让人体会到视觉上的舒适感。固定的4种清单分类在顶部可直接切换列表。API由WanAndroid提供","envelopePic":"http://wanandroid.com/blogimgs/238c157d-a397-4070-af0f-bf039061f653.png","id":45285,"link":"http://www.wanandroid.com/blog/show/2444","niceDate":"1天前","origin":"","originId":7611,"publishTime":1548557472000,"title":"玩清单-怎么这么好用这么好看！才...才不是因为自己开发的呢！o(*￣3￣)o ","userId":16606,"visible":0,"zan":0},{"author":"zqljintu","chapterId":294,"chapterName":"完整项目","courseId":13,"desc":"网上有各种各样的免费API,在众里寻找后，最后发现何不将这些API集合在一个App中呢，鉴于个人能力有限，就选取了部分的API来创作。 感谢知乎日报的Api，提供了App中的日报板块。 感谢豆瓣的Api，提供了App中的电影板块。 感谢WanAndroid的Api，提供了开发板块。 感谢Gank.io的Api，提供了娱乐版块","envelopePic":"http://wanandroid.com/blogimgs/271a4c3f-8066-4038-b4e6-9e5756463403.png","id":45284,"link":"http://www.wanandroid.com/blog/show/2445","niceDate":"1天前","origin":"","originId":7612,"publishTime":1548557466000,"title":"集结号//Assembly-number&mdash;&mdash;集合了多项内容的客户端","userId":16606,"visible":0,"zan":0},{"author":"littledavid-tech","chapterId":294,"chapterName":"完整项目","courseId":13,"desc":"这个算是对Android学习总结，MVP架构+好多轮子","envelopePic":"http://wanandroid.com/blogimgs/9be242c9-e53e-4a54-9f49-d69b04b463b9.png","id":45283,"link":"http://www.wanandroid.com/blog/show/2449","niceDate":"1天前","origin":"","originId":7641,"publishTime":1548556850000,"title":"我的涂鸦之作WanAndroid第三方客户端","userId":16606,"visible":0,"zan":0},{"author":"chinalwb","chapterId":294,"chapterName":"完整项目","courseId":13,"desc":"目前支持的样式:\r\n加粗\r\n斜体\r\n下划线\r\n删除线\r\n有序列表\r\n无序列表\r\n左对齐\r\n居中对齐 \r\n右对齐\r\n插入图片\r\n文字背景色\r\n插入超链接 \r\n@功能\r\n引用\r\n文字颜色（前景色）\r\n插入表情\r\n上角标\r\n下角标\r\n字体大小\r\n插入视频\r\n插入网络图片\r\n插入分割线\r\n所有样式均支持导出HTML文件\r\n加载HTML内容并继续编辑或显示","envelopePic":"http://wanandroid.com/blogimgs/92d3f901-29c9-4c5f-9bee-cfd028e81d49.png","id":45282,"link":"http://www.wanandroid.com/blog/show/2455","niceDate":"1天前","origin":"","originId":7694,"publishTime":1548556846000,"title":"基于自定义Span的富文本编辑器","userId":16606,"visible":0,"zan":0},{"author":"rain9155","chapterId":294,"chapterName":"完整项目","courseId":13,"desc":"使用WanAndroid网站api，一款基于MVP + Rxjava2 + Dagger2 + Retrofit + Material Design的WanAndroid应用。","envelopePic":"http://wanandroid.com/blogimgs/02547877-4a5b-4873-b270-0ee06d4959d7.png","id":45281,"link":"http://www.wanandroid.com/blog/show/2457","niceDate":"1天前","origin":"","originId":7696,"publishTime":1548556844000,"title":"WanAndroid应用","userId":16606,"visible":0,"zan":0},{"author":"gaoleicoding","chapterId":294,"chapterName":"完整项目","courseId":13,"desc":"学Android 主要是采用 MVP + RxJava2 + Retrofit + Multimodule 等架构设计。利用开源的api获取有关android知识的数据，非常感谢张鸿洋老师提供的开放api！向开源者致敬！项目中把目前流行的项目框架都集成到了，代码结构清晰并且有详细注释，如有建议或疑问可留言反馈 。","envelopePic":"http://wanandroid.com/blogimgs/056802c7-9a43-4081-9482-35d0c4e1a9fc.png","id":45241,"link":"http://www.wanandroid.com/blog/show/2463","niceDate":"2天前","origin":"","originId":7722,"publishTime":1548509287000,"title":"结合android当前著名框架写的一个项目--学Android","userId":16606,"visible":0,"zan":0},{"author":"Ruheng","chapterId":26,"chapterName":"基础UI控件","courseId":13,"desc":"详解Android图文混排实现。","envelopePic":"","id":45022,"link":"http://www.jianshu.com/p/6843f332c8df","niceDate":"2019-01-24","origin":"","originId":1165,"publishTime":1548321533000,"title":"Android图文混排实现方式详解","userId":16606,"visible":0,"zan":0}]
         * offset : 0
         * over : true
         * pageCount : 1
         * size : 20
         * total : 18
         */

        private int curPage;
        private int offset;
        private boolean over;
        private int pageCount;
        private int size;
        private int total;
        private List<DatasBean> datas;

        public int getCurPage() {
            return curPage;
        }

        public void setCurPage(int curPage) {
            this.curPage = curPage;
        }

        public int getOffset() {
            return offset;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }

        public boolean isOver() {
            return over;
        }

        public void setOver(boolean over) {
            this.over = over;
        }

        public int getPageCount() {
            return pageCount;
        }

        public void setPageCount(int pageCount) {
            this.pageCount = pageCount;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<DatasBean> getDatas() {
            return datas;
        }

        public void setDatas(List<DatasBean> datas) {
            this.datas = datas;
        }

        public static class DatasBean implements Parcelable {
            /**
             * author : yuwenque
             * chapterId : 328
             * chapterName : 网络&amp;文件下载
             * courseId : 13
             * desc : 一个支持断点续传的下载器

             主要功能

             - 支持断点续传下载
             - 支持自定义文件夹路径、文件名。
             - 支持自定义SQLiteOpenHelper，用于保存下载进度等
             - 下载进度回调时自动切换到UI线程，方便更新UI。
             - 自动与activity绑定生命周期，无需手动释放
             - activity不可见时，不会更新UI，可见时会自动恢复状态
             - 自定义请求头
             - 支持查询下载历史列表
             * envelopePic : http://www.wanandroid.com/resources/image/pc/default_project_img.jpg
             * id : 45572
             * link : http://www.wanandroid.com/blog/show/2209
             * niceDate : 16小时前
             * origin :
             * originId : 3121
             * publishTime : 1548668574000
             * title : Android断点续传下载器JarvisDownloader
             * userId : 16606
             * visible : 0
             * zan : 0
             */

            private String author;
            private int chapterId;
            private String chapterName;
            private int courseId;
            private String desc;
            private String envelopePic;
            private int id;
            private String link;
            private String niceDate;
            private String origin;
            private int originId;
            private long publishTime;
            private String title;
            private int userId;
            private int visible;
            private int zan;

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public int getChapterId() {
                return chapterId;
            }

            public void setChapterId(int chapterId) {
                this.chapterId = chapterId;
            }

            public String getChapterName() {
                return chapterName;
            }

            public void setChapterName(String chapterName) {
                this.chapterName = chapterName;
            }

            public int getCourseId() {
                return courseId;
            }

            public void setCourseId(int courseId) {
                this.courseId = courseId;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getEnvelopePic() {
                return envelopePic;
            }

            public void setEnvelopePic(String envelopePic) {
                this.envelopePic = envelopePic;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }

            public String getNiceDate() {
                return niceDate;
            }

            public void setNiceDate(String niceDate) {
                this.niceDate = niceDate;
            }

            public String getOrigin() {
                return origin;
            }

            public void setOrigin(String origin) {
                this.origin = origin;
            }

            public int getOriginId() {
                return originId;
            }

            public void setOriginId(int originId) {
                this.originId = originId;
            }

            public long getPublishTime() {
                return publishTime;
            }

            public void setPublishTime(long publishTime) {
                this.publishTime = publishTime;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public int getVisible() {
                return visible;
            }

            public void setVisible(int visible) {
                this.visible = visible;
            }

            public int getZan() {
                return zan;
            }

            public void setZan(int zan) {
                this.zan = zan;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.author);
                dest.writeInt(this.chapterId);
                dest.writeString(this.chapterName);
                dest.writeInt(this.courseId);
                dest.writeString(this.desc);
                dest.writeString(this.envelopePic);
                dest.writeInt(this.id);
                dest.writeString(this.link);
                dest.writeString(this.niceDate);
                dest.writeString(this.origin);
                dest.writeInt(this.originId);
                dest.writeLong(this.publishTime);
                dest.writeString(this.title);
                dest.writeInt(this.userId);
                dest.writeInt(this.visible);
                dest.writeInt(this.zan);
            }

            public DatasBean() {
            }

            protected DatasBean(Parcel in) {
                this.author = in.readString();
                this.chapterId = in.readInt();
                this.chapterName = in.readString();
                this.courseId = in.readInt();
                this.desc = in.readString();
                this.envelopePic = in.readString();
                this.id = in.readInt();
                this.link = in.readString();
                this.niceDate = in.readString();
                this.origin = in.readString();
                this.originId = in.readInt();
                this.publishTime = in.readLong();
                this.title = in.readString();
                this.userId = in.readInt();
                this.visible = in.readInt();
                this.zan = in.readInt();
            }

            public static final Creator<DatasBean> CREATOR = new Creator<DatasBean>() {
                @Override
                public DatasBean createFromParcel(Parcel source) {
                    return new DatasBean(source);
                }

                @Override
                public DatasBean[] newArray(int size) {
                    return new DatasBean[size];
                }
            };
        }
    }
}
