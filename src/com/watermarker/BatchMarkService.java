/**
 * 
 */
package com.watermarker;

import java.io.File;

/**
 * @author Administrator
 *  ���ˮӡ����
 */
public class BatchMarkService {
	public String textWaterMark(File[] files ,String[] imageFileName,String uploadPath,String realUploadPath,String realOutputPath) throws Exception {
		int i=0;
		for(File image:files) {
			MarkServiceAbstract markService=new MoreTextMarkService();//����ˮӡ
			markService.watermark(image, imageFileName[i], uploadPath, realUploadPath, realOutputPath);
			i++;
		}
		return realOutputPath;
	}
	public String ImageWaterMark(File[] files ,String[] imageFileName,String uploadPath,String realUploadPath, String realOutputPath) throws Exception {
		int i=0;
		for(File image:files) {
			MarkServiceAbstract markService=new MoreImageMarkService();//����ˮӡ
			markService.watermark(image, imageFileName[i], uploadPath, realUploadPath, realOutputPath);
			i++;
		}
		return realOutputPath;
	}
}
