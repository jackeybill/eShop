package net.shopxx;

import com.octo.captcha.component.image.backgroundgenerator.FileReaderRandomBackgroundGenerator;
import com.octo.captcha.component.image.color.RandomListColorGenerator;
import com.octo.captcha.component.image.fontgenerator.RandomFontGenerator;
import com.octo.captcha.component.image.textpaster.DecoratedRandomTextPaster;
import com.octo.captcha.component.image.textpaster.textdecorator.TextDecorator;
import com.octo.captcha.component.image.wordtoimage.ComposedWordToImage;
import com.octo.captcha.component.word.wordgenerator.RandomWordGenerator;
import com.octo.captcha.engine.image.ListImageCaptchaEngine;
import com.octo.captcha.image.gimpy.GimpyFactory;
import java.awt.Color;
import java.awt.Font;
import org.springframework.core.io.ClassPathResource;

public class CaptchaEngine extends ListImageCaptchaEngine
{
  private static final int IIIllIlI = 80;
  private static final int IIIllIll = 28;
  private static final int IIIlllII = 12;
  private static final int IIIlllIl = 16;
  private static final int IIIllllI = 4;
  private static final int IIIlllll = 4;
  private static final String IIlIIIII = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  private static final String IIlIIIIl = "/net/shopxx/captcha/";
  private static final Font[] IIlIIIlI = { new Font("nyala", 1, 16), new Font("Arial", 1, 16), new Font("nyala", 1, 16), new Font("Bell", 1, 16), new Font("Bell MT", 1, 16), new Font("Credit", 1, 16), new Font("valley", 1, 16), new Font("Impact", 1, 16) };
  private static final Color[] IIlIIIll = { new Color(255, 255, 255), new Color(255, 220, 220), new Color(220, 255, 255), new Color(220, 220, 255), new Color(255, 255, 220), new Color(220, 255, 220) };

  protected void buildInitialFactories()
  {
    RandomFontGenerator localRandomFontGenerator = new RandomFontGenerator(Integer.valueOf(12), Integer.valueOf(16), IIlIIIlI);
    FileReaderRandomBackgroundGenerator localFileReaderRandomBackgroundGenerator = new FileReaderRandomBackgroundGenerator(Integer.valueOf(80), Integer.valueOf(28), new ClassPathResource("/net/shopxx/captcha/").getPath());
    DecoratedRandomTextPaster localDecoratedRandomTextPaster = new DecoratedRandomTextPaster(Integer.valueOf(4), Integer.valueOf(4), new RandomListColorGenerator(IIlIIIll), new TextDecorator[0]);
    addFactory(new GimpyFactory(new RandomWordGenerator("ABCDEFGHIJKLMNOPQRSTUVWXYZ"), new ComposedWordToImage(localRandomFontGenerator, localFileReaderRandomBackgroundGenerator, localDecoratedRandomTextPaster)));
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.CaptchaEngine
 * JD-Core Version:    0.6.2
 */