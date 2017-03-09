/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package support;

import dao.UserDao;
import entities.User;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author Rice Pavel
 */
@Component
@Transactional
public class AuthManager {
  
  @Autowired
  private UserDao userDao;
    
  public User getCurrentUser() {
      return userDao.getUserByLogin(getUserName());
  }
  
  public static String getUserName() {
     String username;
    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    
    if (principal instanceof UserDetails) {
      username = ((UserDetails) principal).getUsername();
    } else {
      username = principal.toString();
    }
    return username;
  }
  
  public static String md5Custom(String st) {
    MessageDigest messageDigest = null;
    byte[] digest = new byte[0];
 
    try {
        messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.reset();
        messageDigest.update(st.getBytes());
        digest = messageDigest.digest();
    } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
    }
 
    BigInteger bigInt = new BigInteger(1, digest);
    String md5Hex = bigInt.toString(16);
 
    while( md5Hex.length() < 32 ){
        md5Hex = "0" + md5Hex;
    }
 
    return md5Hex;
}
  
}
