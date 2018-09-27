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

    @Value("${official-website.upload.file}")
    private String fileLocation;
    @Value("${official-website.upload.avatar}")
    private String avatarLocation;

    /**
     * 上传文件
     *
     * @param file
     * @param fileUploadEnum
     * @return
     * @throws IOException
     */
    public String uploadFile(MultipartFile file, FileUploadEnum fileUploadEnum) throws IOException {

        String localPath = "";
        if (fileUploadEnum == FileUploadEnum.FILE){
            localPath = fileLocation;
        }else if (fileUploadEnum == FileUploadEnum.AVATAR){
            localPath = avatarLocation;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String direct = sdf.format(new Date());

        String realPath = localPath + "/" + direct + "/" + getFileName(file.getOriginalFilename());

        File dest = new File(realPath);

        //判断文件父目录是否存在
        if(!dest.getParentFile().exists()){
            dest.getParentFile().mkdir();
        }

        try {
            //保存文件
            file.transferTo(dest);
            return realPath;
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
     * 生成新的文件名
     * @param fileOriginName 源文件名
     * @return
     */
    public static String getFileName(String fileOriginName){
        return UUID.randomUUID().toString().replace("-", "") + getSuffix(fileOriginName);
    }
}
