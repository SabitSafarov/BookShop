package org.example.booksInfo;

import java.io.Serializable;
import java.util.Date;

public class Book implements Serializable {

    private Integer id;
    private String name;
    private String author;
    private String publisher;
    private Integer pageCounts;
    private String genre;
    private int publishingDate;
    private double costPrice;
    private double salePrice;
    private int inStock;
    private boolean isSequel;

    public Book(Integer id, String name, String author, String publisher, Integer pageCounts, String genre, int publishingDate,
                double costPrice, double salePrice, int inStock, boolean isSequel) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.pageCounts = pageCounts;
        this.genre = genre;
        this.publishingDate = publishingDate;
        this.costPrice = costPrice;
        this.salePrice = salePrice;
        this.isSequel = isSequel;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public Integer getPageCounts() {
        return pageCounts;
    }

    public String getGenre() {
        return genre;
    }

    public int getPublishingDate() {
        return publishingDate;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public double getSalePrice() {
        return salePrice;
    }
    public int getInStock() { return inStock; }

    public boolean isSequel() {
        return isSequel;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setPageCounts(Integer pageCounts) {
        this.pageCounts = pageCounts;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setPublishingDate(int publishingDate) {
        this.publishingDate = publishingDate;
    }

    public void setCostPrice(double costPrice) {
        this.costPrice = costPrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public void setInStock(int inStock) { this.inStock = inStock; }

    public void setSequel(boolean sequel) {
        isSequel = sequel;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\nНазвание: " + name + "\nАвтор: " + author + "\nИздательство: " + publisher + "\nКоличество страниц: "
                + pageCounts + "\nЖанр: " + genre + "\nГод издания: " + publishingDate + "\nСебестоимость книги: " + costPrice + "$"
                + "\nЦена для продажи: " + salePrice + "$" + "\nВ наличии: " + inStock + " шт."
                + (isSequel() ? "\nКнига является продолжением" : "\nКнига не является продолжением");
    }
}
