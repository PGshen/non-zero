package space.zero.business.module.official.website.param.response;

import org.codehaus.jackson.annotate.JsonProperty;
import space.zero.business.module.official.website.model.OfficialWebsiteNews;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA
 * User: pipix
 * Date: 10/17/18
 * TIME: 6:14 PM
 */
public class NewsDetailResponse implements Serializable {
    @JsonProperty("news")
    private OfficialWebsiteNews news;

    // 下一篇文章
    @JsonProperty("next")
    private OfficialWebsiteNews next;

    // 上一篇文章
    @JsonProperty("previous")
    private OfficialWebsiteNews previous;

    public OfficialWebsiteNews getNews() {
        return news;
    }

    public void setNews(OfficialWebsiteNews news) {
        this.news = news;
    }

    public OfficialWebsiteNews getNext() {
        return next;
    }

    public void setNext(OfficialWebsiteNews next) {
        this.next = next;
    }

    public OfficialWebsiteNews getPrevious() {
        return previous;
    }

    public void setPrevious(OfficialWebsiteNews previous) {
        this.previous = previous;
    }
}
