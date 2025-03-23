package com.timex.dto;

public class Product {
    private long id;
    private String pname;
    private double price;
    private String pdetails;
    private String base64Image; // Base64 encoded image

    // Getters and Setters
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getPname() { return pname; }
    public void setPname(String pname) { this.pname = pname; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getPdetails() { return pdetails; }
    public void setPdetails(String pdetails) { this.pdetails = pdetails; }

    public String getBase64Image() { return base64Image; }
    public void setBase64Image(String base64Image) { this.base64Image = base64Image; }
}
