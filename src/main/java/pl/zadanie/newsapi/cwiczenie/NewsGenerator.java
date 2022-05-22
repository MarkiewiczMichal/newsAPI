package pl.zadanie.newsapi.cwiczenie;

import com.kwabenaberko.newsapilib.NewsApiClient;
import com.kwabenaberko.newsapilib.models.Article;
import com.kwabenaberko.newsapilib.models.request.TopHeadlinesRequest;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;

public class NewsGenerator {

  private String wantedNews ="";


    public void setWantedNews(String wantedNews) {
        this.wantedNews += wantedNews;
    }

    public String getWantedNews(){
      return wantedNews;
  }

    public void somethingNews(String kindofNews) {

        NewsApiClient newsApiClient = new NewsApiClient("6be3100f0ee74e16aa370f7d5ac62bcd");
        newsApiClient.getTopHeadlines(
                new TopHeadlinesRequest.Builder()
                        .category(kindofNews)
                        .country("pl")
                        .build(),
                new NewsApiClient.ArticlesResponseCallback() {
                    @Override
                    public void onSuccess(ArticleResponse response) {

                        for (Article article : response.getArticles()) {
                            String daneArtykulu = article.getTitle() +
                                    ":" + article.getDescription() +
                                    ":" + article.getAuthor() +
                                    System.getProperty("line.separator");
                          //  System.out.println(daneArtykulu);
                           setWantedNews(daneArtykulu);
                        }

                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        System.out.println(throwable.getMessage());
                    }
                }
        );

    }
}
