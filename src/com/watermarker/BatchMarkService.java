/**
 * 
 */
package com.watermarker;

import java.io.File;

/**
 * @author Administrator
 *  添加水印批量
 */
public class BatchMarkService {
	public String textWaterMark(File[] files ,String[] imageFileName,String uploadPath,String realUploadPath,String realOutputPath) throws Exception {
		int i=0;
		for(File image:files) {
			MarkServiceAbstract markService=new MoreTextMarkService();//文字水印
			markService.watermark(image, imageFileName[i], uploadPath, realUploadPath, realOutputPath);
			i++;
		}
		return realOutputPath;
	}
	public String ImageWaterMark(File[] files ,String[] imageFileName,String uploadPath,String realUploadPath, String realOutputPath) throws Exception {
		int i=0;
		for(File image:files) {
			MarkServiceAbstract markService=new MoreImageMarkService();//文字水印
			markService.watermark(image, imageFileName[i], uploadPath, realUploadPath, realOutputPath);
			i++;
		}
		return realOutputPath;
	}
}
