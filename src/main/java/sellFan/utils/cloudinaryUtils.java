package sellFan.utils;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.apache.commons.fileupload.FileItem;

import javax.annotation.ManagedBean;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@ManagedBean
public class cloudinaryUtils {
    private Cloudinary cloud;
    public Cloudinary getcloudinaryUtils() {
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "nguyenhieunghia",
                "api_key", "228511477255843",
                "api_secret", "P4MrHnkT2sHi9f_2-2OMozJ6U2E"
        ));
    }

    public cloudinaryUtils() {
        cloud = getcloudinaryUtils();
    }

    private Map upload(FileItem file , String folder) {
        Map uploadResult;
        try {
            uploadResult = cloud.uploader().upload(file.get(),
                    ObjectUtils.asMap("resource_type", "auto",
                            "folder", folder == null ? "" : folder + "/"));
            return uploadResult;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    public Map<String,String> uploadImage(FileItem file){

        Map<String,String> result = new HashMap<String, String>();
        Map uploadResult = upload(file,"avatar");
        result.put("public_id", (String) uploadResult.get("public_id"));
        result.put("url", (String) uploadResult.get("url"));
        return result;
    }
}
