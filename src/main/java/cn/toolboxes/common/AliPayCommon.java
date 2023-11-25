package cn.toolboxes.common;


import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayConfig;
import com.alipay.api.DefaultAlipayClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "alipay")
@PropertySource("classpath:application.yml")
public class AliPayCommon {
    private String appId;
    private String privateKey;
    private String publicCert;
    private String rootCert;
    private String notifyUrl;   // 通知网址
    private String returnUrl;   // 返回网址

    private String signType;
    private String charset;
    private String gatewayUrl;  // 网关网址

    @Bean
    public AlipayClient getAlipayClient() throws AlipayApiException {
        //获得初始化的AlipayClient
        AlipayConfig alipayConfig = new AlipayConfig();
        alipayConfig.setServerUrl(gatewayUrl);
        alipayConfig.setAppId(appId);
        alipayConfig.setPrivateKey(privateKey);
        alipayConfig.setAlipayPublicKey(publicCert);
        alipayConfig.setRootCertPath(rootCert);
        alipayConfig.setFormat("JSON");
        alipayConfig.setCharset(charset);
        alipayConfig.setSignType(signType);
        //构造client
        return new DefaultAlipayClient(alipayConfig);
    }

}
