package cn.act;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import java.io.*;

public class ImgAction extends ActionSupport {
    private File doc;
    private String docFileName;
    private String docContentType;

    private String address;

    @Override
    public String execute() throws Exception {
        String contextPath = ServletActionContext.getServletContext().getRealPath("/img");
        File destFile = new File(contextPath, docFileName);
        String destFilePath = destFile.getPath();
        String realPath = ServletActionContext.getServletContext().getRealPath("/");
       // System.out.println(realPath);
        address = destFilePath.substring(realPath.length());
       // System.out.println(address);
        FileUtils.copyFile(doc, destFile);
        return "success";
    }

    public File getDoc() {
        return doc;
    }

    public void setDoc(File doc) {
        this.doc = doc;
    }

    public String getDocFileName() {
        return docFileName;
    }

    public void setDocFileName(String docFileName) {
        this.docFileName = docFileName;
    }

    public String getDocContentType() {
        return docContentType;
    }

    public void setDocContentType(String docContentType) {
        this.docContentType = docContentType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
