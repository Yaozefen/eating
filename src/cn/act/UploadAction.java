package cn.act;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport{
	private static final int BUFFER_SIZE = 16 * 1024;
	private String title;
	private File upload;
	private String uploadFileName;
	private String uploadContentType;
	private String savePath;
	
	public String execute() throws Exception{
		String dstPath = ServletActionContext.getServletContext().getRealPath(this.getSavePath())+"/"+this.getUploadFileName();
		File dstFile = new File(dstPath);
		copy(this.upload, dstFile);
		return "success";
	}
	
	private void copy(File src,File dst){
		InputStream in = null;
		OutputStream out = null;
		try{
			in = new BufferedInputStream(new FileInputStream(src), BUFFER_SIZE);
			out = new BufferedOutputStream(new FileOutputStream(dst), BUFFER_SIZE);
			byte[] buffer = new byte[BUFFER_SIZE];
			int len = 0;
			while((len = in.read(buffer))>0){
				out.write(buffer, 0, len);
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			if(in!=null){
				try{
					in.close();
				}
				catch (IOException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			if(out!=null){
				try{
					out.close();
				}
				catch (IOException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
	}
	
	
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public String getSavePath() {
		return savePath;
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	
}
