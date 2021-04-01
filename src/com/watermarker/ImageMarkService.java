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

/**
 * @author Administrator
 *
 */
public class ImageMarkService  extends  MarkServiceAbstract  {

	@Override
	public String watermark(File image, String imageFileName, String uploadPath, String realUploadPath,String realOutputPath ) {
		
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
			int widthDiff=width-width1;
			int heightDiff=height-height1;
			int x=X;
			int y=Y;
			if(x>widthDiff) {
				x=widthDiff;
			}
			if(y>heightDiff) {
				y=heightDiff;
			}	
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,ALPHA));
			g.drawImage(imageLogo, x, y, null);
			g.dispose();
			
			os=new FileOutputStream(realOutputPath+"/"+logoFileName);
			//JPEGImageEncoder en=JPEGCodec.createJPEGEncoder(os);
			ImageIO.write(bufferedImage, "jpg", os); 
		}catch(Exception e) {
			e.printStackTrace();
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
