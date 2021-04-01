/**
 * 
 */
package com.watermarker;

import java.io.File;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * @author Administrator
 */
@SuppressWarnings("serial")
public class WaterMarkerAction extends ActionSupport{
	private static Logger logger = Logger.getLogger(WaterMarkerAction.class);  
	private File[] image;
	private String[] imageFileName;
	private String uploadPath;
	private String outputPath;
	private PicInfo picInfo=new PicInfo();
	public String textwatermark(){
		try {
			String realUploadPath=ServletActionContext.getServletContext().getRealPath(uploadPath);
			String realOutputPath=ServletActionContext.getServletContext().getRealPath(outputPath);
			UploadService uploadService=new UploadService();
			//picInfo.setImageURL(uploadService.uploadImage(image, imageFileName, uploadPath, realUploadPath));
			uploadService.batchUploadImage(image, imageFileName, uploadPath, realUploadPath);
			//MarkServiceAbstract markService=new MoreTextMarkService();//多文字水印
			//MarkServiceAbstract markService=new TextMarkService();//单文字水印
			//MarkServiceAbstract markService=new ImageMarkService();//单图片水印
			//MarkServiceAbstract markService=new MoreImageMarkService();//多图片水印
			BatchMarkService markService=new BatchMarkService();//批量多文字水印
			//picInfo.setLogoImageURL(markService.watermark(image, imageFileName, uploadPath, realUploadPath));
			//markService.textWaterMark(image, imageFileName, uploadPath, realUploadPath);
			picInfo.setOutputPath(markService.textWaterMark(image, imageFileName, uploadPath, realUploadPath,realOutputPath));	
			return SUCCESS;
		}catch(Exception e) {
			e.printStackTrace();
			return ERROR;
		}

	}
	public String imagewatermark(){
		try {
			String realUploadPath=ServletActionContext.getServletContext().getRealPath(uploadPath);
			String realOutputPath=ServletActionContext.getServletContext().getRealPath(outputPath);
			UploadService uploadService=new UploadService();
			//picInfo.setImageURL(uploadService.uploadImage(image, imageFileName, uploadPath, realUploadPath));
			uploadService.batchUploadImage(image, imageFileName, uploadPath, realUploadPath);
			//MarkServiceAbstract markService=new MoreTextMarkService();//多文字水印
			//MarkServiceAbstract markService=new TextMarkService();//单文字水印
			//MarkServiceAbstract markService=new ImageMarkService();//单图片水印
			//MarkServiceAbstract markService=new MoreImageMarkService();//多图片水印
			BatchMarkService markService=new BatchMarkService();//批量多文字水印
			//picInfo.setLogoImageURL(markService.watermark(image, imageFileName, uploadPath, realUploadPath));
			//markService.textWaterMark(image, imageFileName, uploadPath, realUploadPath);
			picInfo.setOutputPath(markService.ImageWaterMark(image, imageFileName, uploadPath, realUploadPath,realOutputPath));	
			return SUCCESS;
		}catch(Exception e) {
			e.printStackTrace();
			return ERROR;
		}

	}	
	/**
	 * @return the image
	 */
	public File[] getImage() {
		return image;
	}
	/**
	 * @param image the image to set
	 */
	public void setImage(File[] image) {
		this.image = image;
	}
	/**
	 * @return the imageFileName
	 */
	public String[] getImageFileName() {
		return imageFileName;
	}
	/**
	 * @param imageFileName the imageFileName to set
	 */
	public void setImageFileName(String[] imageFileName) {
		this.imageFileName = imageFileName;
	}
	/**
	 * @return the uploadPath
	 */
	public String getUploadPath() {
		return uploadPath;
	}
	/**
	 * @param uploadPath the uploadPath to set
	 */
	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}
	/**
	 * @return the picInfo
	 */
	public PicInfo getPicInfo() {
		return picInfo;
	}
	/**
	 * @param picInfo the picInfo to set
	 */
	public void setPicInfo(PicInfo picInfo) {
		this.picInfo = picInfo;
	}
	/**
	 * @return the outputPath
	 */
	public String getOutputPath() {
		return outputPath;
	}
	/**
	 * @param outputPath the outputPath to set
	 */
	public void setOutputPath(String outputPath) {
		this.outputPath = outputPath;
	}	
}
