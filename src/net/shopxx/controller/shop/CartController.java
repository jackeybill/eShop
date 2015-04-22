package net.shopxx.controller.shop;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.shopxx.Message;
import net.shopxx.entity.Cart;
import net.shopxx.entity.CartItem;
import net.shopxx.entity.Member;
import net.shopxx.entity.Product;
import net.shopxx.service.CartItemService;
import net.shopxx.service.CartService;
import net.shopxx.service.MemberService;
import net.shopxx.service.ProductService;
import net.shopxx.util.CookieUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("shopCartController")
@RequestMapping({"/cart"})
public class CartController extends BaseController
{

  @Resource(name="memberServiceImpl")
  private MemberService IIIlllIl;

  @Resource(name="productServiceImpl")
  private ProductService IIIllllI;

  @Resource(name="cartServiceImpl")
  private CartService IIIlllll;

  @Resource(name="cartItemServiceImpl")
  private CartItemService IIlIIIII;

  @RequestMapping(value={"/add"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  @ResponseBody
  public Message add(Long id, Integer quantity, HttpServletRequest request, HttpServletResponse response)
  {
    if ((quantity == null) || (quantity.intValue() < 1))
      return IIIllIll;
    Product localProduct = (Product)this.IIIllllI.find(id);
    if (localProduct == null)
      return Message.warn("shop.cart.productNotExsit", new Object[0]);
    if (!localProduct.getIsMarketable().booleanValue())
      return Message.warn("shop.cart.productNotMarketable", new Object[0]);
    if (localProduct.getIsGift().booleanValue())
      return Message.warn("shop.cart.notForSale", new Object[0]);
    Cart localCart = this.IIIlllll.getCurrent();
    Member localMember = this.IIIlllIl.getCurrent();
    if (localCart == null)
    {
      localCart = new Cart();
      localCart.setKey(UUID.randomUUID().toString() + DigestUtils.md5Hex(RandomStringUtils.randomAlphabetic(30)));
      localCart.setMember(localMember);
      this.IIIlllll.save(localCart);
    }
    if ((Cart.MAX_PRODUCT_COUNT != null) && (localCart.getCartItems().size() >= Cart.MAX_PRODUCT_COUNT.intValue()))
      return Message.warn("shop.cart.addCountNotAllowed", new Object[] { Cart.MAX_PRODUCT_COUNT });
    CartItem localCartItem;
    if (localCart.contains(localProduct))
    {
      localCartItem = localCart.getCartItem(localProduct);
      if ((CartItem.MAX_QUANTITY != null) && (localCartItem.getQuantity().intValue() + quantity.intValue() > CartItem.MAX_QUANTITY.intValue()))
        return Message.warn("shop.cart.maxCartItemQuantity", new Object[] { CartItem.MAX_QUANTITY });
      if ((localProduct.getStock() != null) && (localCartItem.getQuantity().intValue() + quantity.intValue() > localProduct.getAvailableStock().intValue()))
        return Message.warn("shop.cart.productLowStock", new Object[0]);
      localCartItem.add(quantity.intValue());
      this.IIlIIIII.update(localCartItem);
    }
    else
    {
      if ((CartItem.MAX_QUANTITY != null) && (quantity.intValue() > CartItem.MAX_QUANTITY.intValue()))
        return Message.warn("shop.cart.maxCartItemQuantity", new Object[] { CartItem.MAX_QUANTITY });
      if ((localProduct.getStock() != null) && (quantity.intValue() > localProduct.getAvailableStock().intValue()))
        return Message.warn("shop.cart.productLowStock", new Object[0]);
      localCartItem = new CartItem();
      localCartItem.setQuantity(quantity);
      localCartItem.setProduct(localProduct);
      localCartItem.setCart(localCart);
      this.IIlIIIII.save(localCartItem);
      localCart.getCartItems().add(localCartItem);
    }
    if (localMember == null)
    {
      CookieUtils.addCookie(request, response, "cartId", localCart.getId().toString(), Integer.valueOf(604800));
      CookieUtils.addCookie(request, response, "cartKey", localCart.getKey(), Integer.valueOf(604800));
    }
    return Message.success("shop.cart.addSuccess", new Object[] { Integer.valueOf(localCart.getQuantity()), IIIllIlI(localCart.getAmount(), true, false) });
  }

  @RequestMapping(value={"/list"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String list(ModelMap model)
  {
    model.addAttribute("cart", this.IIIlllll.getCurrent());
    return "/shop/cart/list";
  }

  @RequestMapping(value={"/edit"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  @ResponseBody
  public Map<String, Object> edit(Long id, Integer quantity)
  {
    HashMap localHashMap = new HashMap();
    if ((quantity == null) || (quantity.intValue() < 1))
    {
      localHashMap.put("message", IIIllIll);
      return localHashMap;
    }
    Cart localCart = this.IIIlllll.getCurrent();
    if ((localCart == null) || (localCart.isEmpty()))
    {
      localHashMap.put("message", Message.error("shop.cart.notEmpty", new Object[0]));
      return localHashMap;
    }
    CartItem localCartItem = (CartItem)this.IIlIIIII.find(id);
    Set localSet = localCart.getCartItems();
    if ((localCartItem == null) || (localSet == null) || (!localSet.contains(localCartItem)))
    {
      localHashMap.put("message", Message.error("shop.cart.cartItemNotExsit", new Object[0]));
      return localHashMap;
    }
    if ((CartItem.MAX_QUANTITY != null) && (quantity.intValue() > CartItem.MAX_QUANTITY.intValue()))
    {
      localHashMap.put("message", Message.warn("shop.cart.maxCartItemQuantity", new Object[] { CartItem.MAX_QUANTITY }));
      return localHashMap;
    }
    Product localProduct = localCartItem.getProduct();
    if ((localProduct.getStock() != null) && (quantity.intValue() > localProduct.getAvailableStock().intValue()))
    {
      localHashMap.put("message", Message.warn("shop.cart.productLowStock", new Object[0]));
      return localHashMap;
    }
    localCartItem.setQuantity(quantity);
    this.IIlIIIII.update(localCartItem);
    localHashMap.put("message", IIIlllII);
    localHashMap.put("subtotal", localCartItem.getSubtotal());
    localHashMap.put("isLowStock", Boolean.valueOf(localCartItem.getIsLowStock()));
    localHashMap.put("quantity", Integer.valueOf(localCart.getQuantity()));
    localHashMap.put("point", Integer.valueOf(localCart.getPoint()));
    localHashMap.put("amount", localCart.getAmount());
    localHashMap.put("promotions", localCart.getPromotions());
    localHashMap.put("giftItems", localCart.getGiftItems());
    return localHashMap;
  }

  @RequestMapping(value={"/delete"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  @ResponseBody
  public Map<String, Object> delete(Long id)
  {
    HashMap localHashMap = new HashMap();
    Cart localCart = this.IIIlllll.getCurrent();
    if ((localCart == null) || (localCart.isEmpty()))
    {
      localHashMap.put("message", Message.error("shop.cart.notEmpty", new Object[0]));
      return localHashMap;
    }
    CartItem localCartItem = (CartItem)this.IIlIIIII.find(id);
    Set localSet = localCart.getCartItems();
    if ((localCartItem == null) || (localSet == null) || (!localSet.contains(localCartItem)))
    {
      localHashMap.put("message", Message.error("shop.cart.cartItemNotExsit", new Object[0]));
      return localHashMap;
    }
    localSet.remove(localCartItem);
    this.IIlIIIII.delete(localCartItem);
    localHashMap.put("message", IIIlllII);
    localHashMap.put("quantity", Integer.valueOf(localCart.getQuantity()));
    localHashMap.put("point", Integer.valueOf(localCart.getPoint()));
    localHashMap.put("amount", localCart.getAmount());
    localHashMap.put("promotions", localCart.getPromotions());
    localHashMap.put("isLowStock", Boolean.valueOf(localCart.getIsLowStock()));
    return localHashMap;
  }

  @RequestMapping(value={"/clear"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  @ResponseBody
  public Message clear()
  {
    Cart localCart = this.IIIlllll.getCurrent();
    this.IIIlllll.delete(localCart);
    return IIIlllII;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.controller.shop.CartController
 * JD-Core Version:    0.6.2
 */