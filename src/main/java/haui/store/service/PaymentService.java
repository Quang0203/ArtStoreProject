package haui.store.service;

import haui.store.model.PaymentGatewayConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class PaymentService {

    @Autowired
    private PaymentGatewayConfig paymentGatewayConfig;

    public String initiatePayment(String orderId, double amount) {
        try {
            String vnp_TmnCode = paymentGatewayConfig.getTmnCode();
            String vnp_HashSecret = paymentGatewayConfig.getHashSecret();
            String vnp_Url = paymentGatewayConfig.getPayUrl();
            String vnp_ReturnUrl = paymentGatewayConfig.getReturnUrl();

            Map<String, String> vnp_Params = new HashMap<>();
            vnp_Params.put("vnp_Version", "2.1.0");
            vnp_Params.put("vnp_Command", "pay");
            vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
            vnp_Params.put("vnp_Amount", String.valueOf((long) (amount * 100))); // Số tiền phải được nhân 100 để chuyển đổi sang đơn vị VND nhỏ nhất
            vnp_Params.put("vnp_CurrCode", "VND");
            vnp_Params.put("vnp_Locale", "vn");
            vnp_Params.put("vnp_TxnRef", orderId);
            vnp_Params.put("vnp_OrderInfo", "Thanh toan don hang: " + orderId);
            vnp_Params.put("vnp_OrderType", "other");
            vnp_Params.put("vnp_ReturnUrl", vnp_ReturnUrl);
            vnp_Params.put("vnp_IpAddr", "127.0.0.1"); // Địa chỉ IP của người dùng

            // Định dạng ngày giờ
            Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
            String vnp_CreateDate = formatter.format(cld.getTime());
            vnp_Params.put("vnp_CreateDate", vnp_CreateDate);

            cld.add(Calendar.MINUTE, 15); // Thêm 15 phút vào thời gian hiện tại để tạo thời gian hết hạn
            String vnp_ExpireDate = formatter.format(cld.getTime());
            vnp_Params.put("vnp_ExpireDate", vnp_ExpireDate);

            List<String> fieldNames = new ArrayList<>(vnp_Params.keySet());
            Collections.sort(fieldNames);
            StringBuilder hashData = new StringBuilder();
            StringBuilder query = new StringBuilder();

            for (String fieldName : fieldNames) {
                String fieldValue = vnp_Params.get(fieldName);
                if ((fieldValue != null) && (fieldValue.length() > 0)) {
                    hashData.append(fieldName)
                            .append('=')
                            .append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                    query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString()))
                            .append('=')
                            .append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                    if (fieldNames.indexOf(fieldName) < fieldNames.size() - 1) {
                        hashData.append('&');
                        query.append('&');
                    }
                }
            }

            String vnp_SecureHash = hmacSHA512(vnp_HashSecret, hashData.toString());
            query.append("&vnp_SecureHash=").append(URLEncoder.encode(vnp_SecureHash, StandardCharsets.US_ASCII.toString()));

            return vnp_Url + "?" + query.toString();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error generating payment URL", e);
        }
    }

    private static String hmacSHA512(String key, String data) throws NoSuchAlgorithmException {
        try {
            byte[] hmacKey = key.getBytes(StandardCharsets.UTF_8);
            SecretKeySpec secretKeySpec = new SecretKeySpec(hmacKey, "HmacSHA512");
            Mac mac = Mac.getInstance("HmacSHA512");
            mac.init(secretKeySpec);
            byte[] hmacData = mac.doFinal(data.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder(2 * hmacData.length);
            for (byte b : hmacData) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (Exception e) {
            throw new NoSuchAlgorithmException("Error while hashing data", e);
        }
    }

    public boolean validatePaymentResponse(Map<String, String> payload) {
        // Thực hiện việc xác thực phản hồi từ VNPAY tại đây
        // Cần kiểm tra lại chữ ký (vnp_SecureHash) trong phản hồi từ VNPAY
        return true;
    }

}
