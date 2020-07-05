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

import cn.dao.DishDao;
import cn.dao.UserDao;
import cn.model.Dish;

public class DishAction extends ActionSupport{
	//��Ҫ�̳�actionsupport
	Dish dish;
	private static final int BUFFER_SIZE = 16 * 1024;
	private String title;
	private File upload;
	private String uploadFileName;
	private String uploadContentType;
	private String savePath;
		//�ϼ�
		public String addFood() throws Exception{
			String dstPath = ServletActionContext.getServletContext().getRealPath(this.getSavePath())+"/"+this.getUploadFileName();
			File dstFile = new File(dstPath);
			copy(this.upload, dstFile);
			dish.setDishImg(this.getUploadFileName());
			
			if(dish==null||dish.getDishName()==null||dish.getType()==null||dish.getPrice()==0.0||dish.getDishImg()==null||dish.getIntroduction()==null){
				return "error";
			}
			//�Ҳ������ݷ���errorһ������Ϊû�ж����get����
			DishDao dishDao = new DishDao();
			boolean flag = dishDao.addDish(dish);
			if(flag){				//�漴Ϊ����ɹ�
				
				ServletActionContext.getRequest().setAttribute("message","�ϼܳɹ�");
				return "upper";
			}
			else{
				ServletActionContext.getRequest().setAttribute("message","�ϼ�ʧ��");
				return "upper";
			}
		}
		
		//�¼�һ����Ʒ
		public String deleteDish(){
			DishDao dao = new DishDao();
			boolean flag = dao.delete(dish);
			if(flag){
				return "success";
			}
			else{
				return "error";
			}
		}
		//�����ļ�
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
		
	public Dish getDish() {
		return dish;
	}

	public void setDish(Dish dish) {
		this.dish = dish;
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
