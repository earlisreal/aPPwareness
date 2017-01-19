package com.ibm.watson.developer_cloud.alchemy.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Dates.ExtractedDate;
import java.util.List;

public class CombinedResults extends AlchemyLanguageGenericModel {
    private String author;
    private List<Concept> concepts;
    List<ExtractedDate> dates;
    private List<Entity> entities;
    private List<Feed> feeds;
    private String image;
    private List<Keyword> imageKeywords;
    private List<Keyword> keywords;
    private PublicationDate publicationDate;
    private List<SAORelation> relations;
    @SerializedName("docSentiment")
    private Sentiment sentiment;
    private List<Taxonomy> taxonomy;
    private String text;
    private String title;

    public String getAuthor() {
        return this.author;
    }

    public List<Concept> getConcepts() {
        return this.concepts;
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

    public List<Keyword> getImageKeywords() {
        return this.imageKeywords;
    }

    public List<ExtractedDate> getDates() {
        return this.dates;
    }

    public void setDates(List<ExtractedDate> dates) {
        this.dates = dates;
    }

    public List<Keyword> getKeywords() {
        return this.keywords;
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

    public String getTitle() {
        return this.title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setConcepts(List<Concept> concepts) {
        this.concepts = concepts;
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

    public void setImageKeywords(List<Keyword> imageKeywords) {
        this.imageKeywords = imageKeywords;
    }

    public void setKeywords(List<Keyword> keywords) {
        this.keywords = keywords;
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

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
