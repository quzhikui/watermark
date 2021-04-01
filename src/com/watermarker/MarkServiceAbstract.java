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
public abstract class MarkServiceAbstract {
	public static final String MARK_TEXT="Ä½¿ÎÍô";
	
	public static final String FONT_NAME="Î¢ÈíÑÅºÚ";
	public static final int FONT_STYLE=Font.BOLD;
	public static final int FONT_SIZE=120;
	public static final Color FONT_COLOR=Color.black;
	
	public static final int X=5;
	public static final int Y=5;
	
	public static final float ALPHA=0.3F;
	
	public static final String LOGO="logo.png";
	public abstract String watermark(File image,String imageFileName,String uploadPath,String realUploadPath,String realOutputPath) throws Exception;
	
	public int getTextLength(String text) {
		int length=text.length();
		for(int i=0;i<text.length();i++) {
			String s=String.valueOf(text.charAt(i));
			if(s.getBytes().length>1) {
				length++;
			}
		}
		length=length%2==0?length/2:length/2+1;
		return length;
	}
}
