package ff;

import java.io.Serializable;
 
public class product implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int prdId;
	private String prdName;
	private float prdPrice;
	public product() {
		prdId=0;
		prdName="";
		prdPrice=0.0F;
	}
	public product(int prdId, String prdName, float prdPrice) {
		super();
		this.prdId = prdId;
		this.prdName = prdName;
		this.prdPrice = prdPrice;
	}
 
	public int getPrdId() {
		return prdId;
	}
	public void setPrdId(int prdId) {
		this.prdId = prdId;
	}
	public String getPrdName() {
		return prdName;
	}
	public void setPrdName(String prdName) {
		this.prdName = prdName;
	}
	public float getPrdPrice() {
		return prdPrice;
	}
	public void setPrdPrice(float prdPrice) {
		this.prdPrice = prdPrice;
	}
	
	
}