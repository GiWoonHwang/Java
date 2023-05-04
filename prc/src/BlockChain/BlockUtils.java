package BlockChain;


import java.io.UnsupportedEncodingException;
import java.security.MessageDigest; // SHA 알고리즘을 이용하기 위한 클래스,
import java.security.NoSuchAlgorithmException;

public class BlockUtils {
    public static String generateHash(String... inputValues){ // 가변인자
        try{
            StringBuffer sb = new StringBuffer();
            for(String inputValue: inputValues){
//                System.out.println("무슨값이 나올까요" + inputValue);
                sb.append(inputValue);

            }

            String input = sb.toString(); // 이거 왜 쓰는지 이해 안됨

            MessageDigest digest = MessageDigest.getInstance("SHA-256"); // SHA-256을 호출, 파라미터로 받는 알고리즘은 NoSuchAlgorithmException 때문에 try / catch로 감싸줘야 한다.

            byte[] hash = digest.digest(input.getBytes("UTF-8")); // 문자열을 utf-8로 인코딩한 후 해시화된 값을 반환한다.

            StringBuffer hexString = new StringBuffer(); // 위에 같은 인스턴스가 이미 선언되어 있는데 또 선언한 이유는 뭘까 ??

            for (int i = 0; i < hash.length; i++){
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new RuntimeException(e);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
