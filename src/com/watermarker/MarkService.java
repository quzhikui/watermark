/**
 * 
 */
package com.watermarker;

import java.awt.Color;
import java.awt.Font;
import java.io.File;

/**
 * @author Administrator
 *
 */
public interface MarkService {
	public static final String MARK_TEXT="Ľ����";
	
	public static final String FONT_NAME="΢���ź�";
	public static final int FONT_STYLE=Font.BOLD;
	public static final int FONT_SIZE=120;
	public static final Color FONT_COLOR=Color.black;
	
	public static final int X=10;
	public static final int Y=10;
	
	public static final float ALPHA=0.3F;
	
	public static final String LOGO="logo.png";
	public String watermark(File image,String imageFileName,String uploadPath,String realUploadPath);
}
