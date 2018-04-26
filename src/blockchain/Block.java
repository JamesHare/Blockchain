package blockchain;

import java.util.Date;
import java.security.MessageDigest;

public class Block{

  // variables
  private String hash;
  private String previousHash;
  private String data;
  private long timeStamp;

  // constructor
  public Block(String data, String previousHash){
    this.data = data;
    this.previousHash = previousHash;
    this.timeStamp = new Date().getTime();
    this.hash = calculateHash(); // other variables are set before we do this
  }

  private String calculateHash(){
    String input = previousHash + Long.toString(timeStamp) + data;
    try {
      MessageDigest digest = MessageDigest.getInstance("SHA-256");

      byte[] hash = digest.digest(input.getBytes("UTF-8"));
      StringBuffer hexString = new StringBuffer();

      for(int i = 0; i < hash.length; i++){
        String hex = Integer.toHexString(0xff & hash[i]);
        if(hex.length() == 1){
          hexString.append('0');
        }
        hexString.append(hex);
      }
      return hexString.toString();
    }
    catch(Exception e){
      throw new RuntimeException(e);
    }
  }

  public String getHash(){
    return hash;
  }

  public String getPreviousHash(){
    return previousHash;
  }

}
