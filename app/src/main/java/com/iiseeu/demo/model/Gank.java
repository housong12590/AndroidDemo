package com.iiseeu.demo.model;

import java.util.List;

/**
 * Author: housong
 * Date: 2016/6/21 17:26
 */
public class Gank {

    private int count;
    private boolean error;
    private List<Results> results;

    @Override
    public String toString() {
        return "Gank{" +
                "count=" + count +
                ", error=" + error +
                ", results=" + results +
                '}';
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<Results> getResults() {
        return results;
    }

    public void setResults(List<Results> results) {
        this.results = results;
    }

    public void addResults(Gank.Results result) {
        results.add(result);
    }

    public static class Results {

        private String desc;
        private String publishedAt;
        private String readability;
        private String type;
        private String url;
        private String who;

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getReadability() {
            return readability;
        }

        public void setReadability(String readability) {
            this.readability = readability;
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

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }

        @Override
        public String toString() {
            return "Results{" +
                    "desc='" + desc + '\'' +
                    ", publishedAt='" + publishedAt + '\'' +
                    ", readability='" + readability + '\'' +
                    ", type='" + type + '\'' +
                    ", url='" + url + '\'' +
                    ", who='" + who + '\'' +
                    '}';
        }
    }
}
