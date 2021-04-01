/**
 * 
 */
package com.watermarker;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author Administrator
 *
 */
public class UploadService {
	public String uploadImage(File image,String imageFileName ,String uploadPath,String realUploadPath) {
		InputStream is=null;
		OutputStream os=null;
		
		try {
			is=new FileInputStream(image);
			os=new FileOutputStream(realUploadPath+"/"+imageFileName);
			byte[] buffer=new byte[1024];
			int len=0;
			while((len=is.read(buffer))>0) {
				os.write(buffer);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(is!=null) {
				try {
					is.close();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
			if(os!=null) {
				try {
					os.close();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}			
		}
		
		return uploadPath+"/"+imageFileName;
		
	}
	public void batchUploadImage(File[] images,String[] imageFileName ,String uploadPath,String realUploadPath) {
		InputStream is=null;
		OutputStream os=null;
		int i=0;
		for(File image : images) {			
			try {
				is=new FileInputStream(image);
				os=new FileOutputStream(realUploadPath+"/"+imageFileName[i]);
				byte[] buffer=new byte[1024];
				int len=0;
				while((len=is.read(buffer))>0) {
					os.write(buffer);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				if(is!=null) {
					try {
						is.close();
					} catch (Exception e2) {
						// TODO: handle exception
						e2.printStackTrace();
					}
				}
				if(os!=null) {
					try {
						os.close();
					} catch (Exception e2) {
						// TODO: handle exception
						e2.printStackTrace();
					}
				}			
			}
			i++;
		}
		
	}	
}
