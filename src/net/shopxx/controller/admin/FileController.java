package net.shopxx.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import net.shopxx.FileInfo;
import net.shopxx.FileInfo.FileType;
import net.shopxx.FileInfo.OrderType;
import net.shopxx.Message;
import net.shopxx.service.FileService;
import net.shopxx.util.JsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller("adminFileController")
@RequestMapping({"/admin/file"})
public class FileController extends BaseController
{

  @Resource(name="fileServiceImpl")
  private FileService IIIlllIl;

  @RequestMapping(value={"/upload"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public void upload(FileInfo.FileType fileType, MultipartFile file, HttpServletResponse response)
  {
    if (!this.IIIlllIl.isValid(fileType, file))
    {
      JsonUtils.toJson(response, "text/html; charset=UTF-8", Message.warn("admin.upload.invalid", new Object[0]));
    }
    else
    {
      String str = this.IIIlllIl.upload(fileType, file, false);
      if (str == null)
        JsonUtils.toJson(response, "text/html; charset=UTF-8", Message.warn("admin.upload.error", new Object[0]));
      HashMap localHashMap = new HashMap();
      localHashMap.put("url", str);
      JsonUtils.toJson(response, "text/html; charset=UTF-8", localHashMap);
    }
  }

  @RequestMapping(value={"/browser"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  @ResponseBody
  public List<FileInfo> browser(String path, FileInfo.FileType fileType, FileInfo.OrderType orderType)
  {
    return this.IIIlllIl.browser(path, fileType, orderType);
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.controller.admin.FileController
 * JD-Core Version:    0.6.2
 */