package com.ibm.watson.developer_cloud.alchemy.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import java.util.List;

public class Article extends GenericModel {
    private String author;
    private String cleanedTitle;
    private List<Concept> concepts;
    private EnrichedTitle enrichedTitle;
    private List<Entity> entities;
    private List<Feed> feeds;
    private String image;
    private List<ImageKeyword> imageKeywords;
    private List<Keyword> keywords;
    private String language;
    private PublicationDate publicationDate;
    private List<SAORelation> relations;
    @SerializedName("docSentiment")
    private Sentiment sentiment;
    private List<Taxonomy> taxonomy;
    private String text;
    private String title;
    private String url;

    public static class EnrichedTitle extends GenericModel {
        private List<Concept> concepts;
        private List<Entity> entities;
        private List<Keyword> keywords;
        private List<SAORelation> relations;
        @SerializedName("docSentiment")
        private Sentiment sentiment;
        private List<Taxonomy> taxonomy;

        public List<Concept> getConcepts() {
            return this.concepts;
        }

        public List<Entity> getEntities() {
            return this.entities;
        }

        public List<Keyword> getKeywords() {
            return this.keywords;
        }

        public List<SAORelation> getRelations() {
            return this.relations;
        }

        public Sentiment getSentiment() {
            return this.sentiment;
        }

        public List<Taxonomy> getTaxonomy() {
            return this.taxonomy;
        }

        public void setConcepts(List<Concept> concepts) {
            this.concepts = concepts;
        }

        public void setEntities(List<Entity> entities) {
            this.entities = entities;
        }

        public void setKeywords(List<Keyword> keywords) {
            this.keywords = keywords;
        }

        public void setRelations(List<SAORelation> relations) {
            this.relations = relations;
        }

        public void setSentiment(Sentiment sentiment) {
            this.sentiment = sentiment;
        }

        public void setTaxonomy(List<Taxonomy> taxonomy) {
            this.taxonomy = taxonomy;
        }
    }

    public String getAuthor() {
        return this.author;
    }

    public String getCleanedTitle() {
        return this.cleanedTitle;
    }

    public List<Concept> getConcepts() {
        return this.concepts;
    }

    public EnrichedTitle getEnrichedTitle() {
        return this.enrichedTitle;
    }

    public List<Entity> getEntities() {
        return this.entities;
    }

    public List<Feed> getFeeds() {
        return this.feeds;
    }

    public String getImage() {
        return this.image;
    }

    public List<ImageKeyword> getImageKeywords() {
        return this.imageKeywords;
    }

    public List<Keyword> getKeywords() {
        return this.keywords;
    }

    public String getLanguage() {
        return this.language;
    }

    public PublicationDate getPublicationDate() {
        return this.publicationDate;
    }

    public List<SAORelation> getRelations() {
        return this.relations;
    }

    public Sentiment getSentiment() {
        return this.sentiment;
    }

    public List<Taxonomy> getTaxonomy() {
        return this.taxonomy;
    }

    public String getText() {
        return this.text;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUrl() {
        return this.url;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCleanedTitle(String cleanedTitle) {
        this.cleanedTitle = cleanedTitle;
    }

    public void setConcepts(List<Concept> concepts) {
        this.concepts = concepts;
    }

    public void setEnrichedTitle(EnrichedTitle enrichedTitle) {
        this.enrichedTitle = enrichedTitle;
    }

    public void setEntities(List<Entity> entities) {
        this.entities = entities;
    }

    public void setFeeds(List<Feed> feeds) {
        this.feeds = feeds;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setImageKeywords(List<ImageKeyword> imageKeywords) {
        this.imageKeywords = imageKeywords;
    }

    public void setKeywords(List<Keyword> keywords) {
        this.keywords = keywords;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setPublicationDate(PublicationDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public void setRelations(List<SAORelation> relations) {
        this.relations = relations;
    }

    public void setSentiment(Sentiment sentiment) {
        this.sentiment = sentiment;
    }

    public void setTaxonomy(List<Taxonomy> taxonomy) {
        this.taxonomy = taxonomy;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
