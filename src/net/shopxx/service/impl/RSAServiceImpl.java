package net.shopxx.service.impl;

import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import net.shopxx.service.RSAService;
import net.shopxx.util.RSAUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service("rsaServiceImpl")
public class RSAServiceImpl
  implements RSAService
{
  private static final String IIIllIlI = "privateKey";

  @Transactional(readOnly=true)
  public RSAPublicKey generateKey(HttpServletRequest request)
  {
    Assert.notNull(request);
    KeyPair localKeyPair = RSAUtils.generateKeyPair();
    RSAPublicKey localRSAPublicKey = (RSAPublicKey)localKeyPair.getPublic();
    RSAPrivateKey localRSAPrivateKey = (RSAPrivateKey)localKeyPair.getPrivate();
    HttpSession localHttpSession = request.getSession();
    localHttpSession.setAttribute("privateKey", localRSAPrivateKey);
    return localRSAPublicKey;
  }

  @Transactional(readOnly=true)
  public void removePrivateKey(HttpServletRequest request)
  {
    Assert.notNull(request);
    HttpSession localHttpSession = request.getSession();
    localHttpSession.removeAttribute("privateKey");
  }

  @Transactional(readOnly=true)
  public String decryptParameter(String name, HttpServletRequest request)
  {
    Assert.notNull(request);
    if (name != null)
    {
      HttpSession localHttpSession = request.getSession();
      RSAPrivateKey localRSAPrivateKey = (RSAPrivateKey)localHttpSession.getAttribute("privateKey");
      String str = request.getParameter(name);
      if ((localRSAPrivateKey != null) && (StringUtils.isNotEmpty(str)))
        return RSAUtils.decrypt(localRSAPrivateKey, str);
    }
    return null;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.service.impl.RSAServiceImpl
 * JD-Core Version:    0.6.2
 */