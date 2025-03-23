package com.timex.dto;

public class Products {
	  private long id;
	    private String pname;
	    private double price;
	    private byte[] pic;
	    public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getPname() {
			return pname;
		}
		public void setPname(String pname) {
			this.pname = pname;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public byte[] getPic() {
			return pic;
		}
		public void setPic(byte[] pic) {
			this.pic = pic;
		}
		public String getPdetails() {
			return pdetails;
		}
		public void setPdetails(String pdetails) {
			this.pdetails = pdetails;
		}
		private String pdetails;
	    

}
