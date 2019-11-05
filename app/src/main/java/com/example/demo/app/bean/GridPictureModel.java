package com.example.demo.app.bean;



import java.io.Serializable;

/**
 * 瀑布流所用缩略图数据模型
 */
public class GridPictureModel implements  Serializable{
	String pictureTitle;
	String pictureUrl;
	int pictureHeight;
	int pictureWidth;

	public int getPictureWidth() {
		return pictureWidth;
	}

	public void setPictureWidth(int pictureWidth) {
		this.pictureWidth = pictureWidth;
	}

	public int getPictureHeight() {
		return pictureHeight;
	}

	public void setPictureHeight(int pictureHeight) {
		this.pictureHeight = pictureHeight;
	}

	public String getPictureTitle() {
		return pictureTitle;
	}

	public void setPictureTitle(String pictureTitle) {
		this.pictureTitle = pictureTitle;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}



	@Override
	public String toString() {
		return "GridPictureModel{" +
				"pictureTitle='" + pictureTitle + '\'' +
				", pictureUrl='" + pictureUrl + '\'' +
				", pictureHeight=" + pictureHeight +
				", pictureWidth=" + pictureWidth +
				'}';
	}
}
