/**
 * 
 */
package com.watermarker;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;

/**
 * @author Administrator
 *
 */
public class MoreImageMarkService extends MarkServiceAbstract {

	/* (non-Javadoc)
	 * @see com.watermarker.MarkServiceAbstract#watermark(java.io.File, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public String watermark(File image, String imageFileName, String uploadPath, String realUploadPath,String realOutputPath) throws Exception {
		String logoFileName="logo_"+imageFileName;
		OutputStream os=null;
		String logoPath=realUploadPath+"/"+LOGO;
		try {
			Image image2=ImageIO.read(image);
			int width=image2.getWidth(null);
			int height=image2.getHeight(null);
			
			BufferedImage bufferedImage=new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			Graphics2D g=bufferedImage.createGraphics();
			g.drawImage(image2, 0, 0, width, height, null);

			File logo=new File(logoPath);
			Image imageLogo=ImageIO.read(logo);
			int width1=imageLogo.getWidth(null);
			int height1=imageLogo.getHeight(null);	
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,ALPHA));
			//水印文字角度旋转
			g.rotate(Math.toRadians(30), bufferedImage.getWidth()/2, bufferedImage.getHeight()/2);	
			
			int x=-width/2;
			int y=-height/2;
			while(x<width*1.5) {
				y=-height/2;
				while(y<height*1.5) {
					g.drawImage(imageLogo, x, y, null);
					y+=height1+300;
				}
				x+=width1+50;
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
