package com.master.core.event.user;


public class UploadAdImageEvent{
  	
  private boolean isLegalImage = true;
  private String imagePath = "Unknown";
  
	public String getImagePath() {
		return imagePath;
	}
	public boolean isLegalImage() {
		return isLegalImage;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public void setLegalImage(boolean isLegalImage) {
		this.isLegalImage = isLegalImage;
	}


}
