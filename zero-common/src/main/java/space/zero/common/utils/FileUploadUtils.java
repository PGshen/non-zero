package space.zero.common.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by PG_shen on 9/27/18
 */
public class FileUploadUtils {

//    @Value("${website.global.upload.location}")
    private String fileLocation = "/home/pipix/Project/web/non-zero/upload";

    /**
     * 上传文件
     *
     * @param file
     * @param fileUploadEnum
     * @return
     * @throws IOException
     */
    public String uploadFile(MultipartFile file, FileUploadEnum fileUploadEnum) throws IOException {

        String filePath = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        String yearDir = sdf.format(new Date());
        sdf = new SimpleDateFormat("yyyyMM");
        String monthDir = sdf.format(new Date()).substring(4);
        if (fileUploadEnum == FileUploadEnum.FILE){
            filePath = "/file/" + yearDir + "/" + monthDir + "/" + getFileName(file.getOriginalFilename());
        }else if (fileUploadEnum == FileUploadEnum.AVATAR){
            filePath = "/avatar/" + yearDir + "/" + monthDir + "/" + getFileName(file.getOriginalFilename());
        }

        String realPath = fileLocation + filePath;

        File dest = new File(realPath);

        //判断文件父目录是否存在
        if(!dest.getParentFile().exists()){
            dest.getParentFile().mkdirs();
        }

        try {
            //保存文件
            file.transferTo(dest);
            return "upload"+filePath;
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "error";
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "error";
        }
    }

    /**
     * 获取文件后缀
     * @param fileName
     * @return
     */
    public static String getSuffix(String fileName){
        return fileName.substring(fileName.lastIndexOf("."));
    }

    /**
     * 生成新的文件名,时分秒毫秒
     * @param fileOriginName 源文件名
     * @return
     */
    public static String getFileName(String fileOriginName){
        SimpleDateFormat sdf = new SimpleDateFormat("ddHHmmssSSS");
        String fileName = sdf.format(new Date());
        return fileName + getSuffix(fileOriginName);
    }
}
