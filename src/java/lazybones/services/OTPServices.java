
package lazybones.services;


public class OTPServices {
    
    public static int otpGenerator()
    {
        int otp;
        while(true)
        {
          otp=(int)(Math.random()*10000); 
          if(otp>=1000 && otp<10000)
          {
            break;
          }
        }
        
        return otp;
    }
}
