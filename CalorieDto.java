package dto;

public class CalorieDto {
	private int foodId;
	private String foodName;
	private int foodCal;
	private String foodPfc;
	private String foodImg;
	private String date;

	public CalorieDto() {

	}
	public CalorieDto(int foodId, String foodName, int foodCal, String foodPfc, String foodImg, String date) {
		this.foodId =foodId;
		this. foodName =  foodName;
		this.foodCal= foodCal;
		this. foodPfc =  foodPfc;
		this.foodImg = foodImg;
		this.date= date;
	}


	public void setfoodId(int foodId) {
		this.foodId =foodId;
	}

	public void setfoodName(String foodName) {
		this. foodName =  foodName;
	}
	public void setfoodCal(int foodCal) {
		this.foodCal= foodCal;
	}
	public void setfoodPfc(String foodPfc) {
		this. foodPfc =  foodPfc;
	}
	public void setfoodImg(String foodImg) {
		this.foodImg = foodImg;
	}
	public void setDate(String date) {
		this.date= date;
	}

	public int getfoodId() {
		return this.foodId;
	}

	public String getfoodName() {
		return this.foodName;
	}
	public int getfoodCal() {
		return this.foodCal;
	}
	public String getfoodPfc() {
		return this.foodPfc;
	}
	public String getfoodImg() {
		return this.foodImg;
	}
	public String getDate() {
		return this.date;
	}

}
