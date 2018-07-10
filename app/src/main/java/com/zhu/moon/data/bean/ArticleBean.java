package com.zhu.moon.data.bean;

/**
 * 文章实体类
 * Created by zhuguangjun on 2018/7/6.
 */

public class ArticleBean {
    public String id;
    public String apkLink;
    public String author;
    public String chapterId;
    public String chapterName;
    public boolean collect;
    public String courseId;
    public String desc;
    public String niceDate;
    public String link;
    public String superChapterName;
    public String title;
    public String projectLink;

    @Override
    public String toString() {
        return "ArticleBean{" +
                "id='" + id + '\'' +
                ", apkLink='" + apkLink + '\'' +
                ", author='" + author + '\'' +
                ", chapterId='" + chapterId + '\'' +
                ", chapterName='" + chapterName + '\'' +
                ", collect=" + collect +
                ", courseId='" + courseId + '\'' +
                ", desc='" + desc + '\'' +
                ", niceDate='" + niceDate + '\'' +
                ", link='" + link + '\'' +
                ", superChapterName='" + superChapterName + '\'' +
                ", title='" + title + '\'' +
                ", projectLink='" + projectLink + '\'' +
                '}';
    }
}
