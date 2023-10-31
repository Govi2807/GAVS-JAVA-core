package jj;


public class Product {
    private int prodId;
    private String prodName;
    private String prodColor;

    public Product(int prodId, String prodName, String prodColor) {
        this.prodId = prodId;
        this.prodName = prodName;
        this.prodColor = prodColor;
    }

	public int getProdId() {
		return prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getProdColor() {
		return prodColor;
	}

	public void setProdColor(String prodColor) {
		this.prodColor = prodColor;
	}

  
}
