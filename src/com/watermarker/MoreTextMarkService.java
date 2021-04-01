/**
 * 
 */
package com.watermarker;

import java.awt.AlphaComposite;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.imageio.ImageIO;
import org.apache.log4j.Logger;

/**
 * @author Administrator
 *
 */
public class MoreTextMarkService extends MarkServiceAbstract {
	private static Logger logger = Logger.getLogger(MoreTextMarkService.class);  
	/* (non-Javadoc)
	 * @see com.watermarker.MarkServiceAbstract#watermark(java.io.File, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public String watermark(File image, String imageFileName, String uploadPath, String realUploadPath,String realOutputPath) throws Exception {
		// TODO Auto-generated method stub
		String logoFileName="logo_"+imageFileName;
		OutputStream os=null;
		
		try {
			Image image2=ImageIO.read(image);
			int width=image2.getWidth(null);
			int height=image2.getHeight(null);
			
			BufferedImage bufferedImage=new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			Graphics2D g=bufferedImage.createGraphics();
			g.drawImage(image2, 0, 0, width, height, null);
			g.setFont(new Font(FONT_NAME,FONT_STYLE,FONT_SIZE));
			g.setColor(FONT_COLOR);
			
			int width1=FONT_SIZE*getTextLength(MARK_TEXT);
			int height1=FONT_SIZE;
			//透明度
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,ALPHA));
			//水印文字角度旋转
			g.rotate(Math.toRadians(30), bufferedImage.getWidth()/2, bufferedImage.getHeight()/2);
			
			int x=-width/2;
			int y=-height/2;
			while(x<width*1.5) {
				y=-height/2;
				while(y<height*1.5) {
					g.drawString(MARK_TEXT, x, y);
					y+=height1+300;
				}
				x+=width1+300;
			}
			g.dispose();
			
			os=new FileOutputStream(realOutputPath+"/"+logoFileName);
			//JPEGImageEncoder en=JPEGCodec.createJPEGEncoder(os);
			ImageIO.write(bufferedImage, "jpg", os); 
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception("报错啦！！！");
		}finally {
			if(os!=null) {
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return uploadPath+"/"+logoFileName;
	}
}
