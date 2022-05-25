package pl.zadanie.newsapi.cwiczenie;

import com.kwabenaberko.newsapilib.NewsApiClient;
import com.kwabenaberko.newsapilib.models.Article;
import com.kwabenaberko.newsapilib.models.request.TopHeadlinesRequest;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class NewsGenerator {


    private String wantedNews = "";
    private List<Article> articles = new ArrayList<>();

    public void setArticles(Article article) {
        articles.add(article);
    }

    public String getArticles() {
        String wynik = "";
        Random random = new Random();

        wynik = articles.get(random.nextInt(articles.size() - 1)).getTitle();
//        for (Article a : articles) {
//            wynik += a.getTitle()+ System.getProperty("line.separator");
//        }

        return wynik;
    }

    public void setWantedNews(String wantedNews) {
        this.wantedNews += wantedNews;
    }

    public String getWantedNews() {
        return wantedNews;
    }

    public void somethingNews(String kindofNews) {
        CompletableFuture future = new CompletableFuture<ArticleResponse>();

        NewsApiClient newsApiClient = new NewsApiClient("6be3100f0ee74e16aa370f7d5ac62bcd");
        newsApiClient.getTopHeadlines(
                new TopHeadlinesRequest.Builder()
                        .category(kindofNews)
                        .country("pl")
                        .build(),
                new NewsApiClient.ArticlesResponseCallback() {
                    @Override
                    public void onSuccess(ArticleResponse response) {
                        future.complete(response);
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        future.complete(throwable);
                    }
                }
        );

        ArticleResponse response = null;
        try {
            response = (ArticleResponse) future.get();
            for (Article article : response.getArticles()) {
                setArticles(article);
                String daneArtykulu = article.getTitle() +
                        ":" + article.getDescription() +
                        ":" + article.getAuthor() +
                        System.lineSeparator();
                //  System.out.println(daneArtykulu);
                setWantedNews(daneArtykulu);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
